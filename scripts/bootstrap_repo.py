#!/usr/bin/env python3
from pathlib import Path
import argparse, json, os, re, shutil, subprocess, sys, datetime

ROOT = Path(__file__).resolve().parents[1]
STATE_PATH = ROOT / "PROJECT_STATE.json"
EVIDENCE_PATH = ROOT / "evidence" / "build" / "REPO_BOOTSTRAP.json"

class Hold(Exception):
    def __init__(self, code, message, exit_code=3):
        self.code=code; self.message=message; self.exit_code=exit_code
        super().__init__(message)

def run(cmd, check=True):
    p=subprocess.run(cmd, cwd=ROOT, text=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    if check and p.returncode != 0:
        raise Hold("COMMAND_FAILED", f"{' '.join(cmd)} :: {p.stdout.strip()}")
    return p.returncode, p.stdout.strip()

def out(cmd):
    rc,s=run(cmd,check=False)
    return s if rc==0 else ""

def slugify(s):
    s=re.sub(r'[^a-zA-Z0-9._-]+','-',s.strip()).strip('-').lower()
    return s or 'ai-prod-android-app'

def now(): return datetime.datetime.now(datetime.timezone.utc).isoformat()

def save(state, result, details, code=0):
    repo=state.setdefault('repository',{})
    repo['bootstrap_state']=result
    repo['last_bootstrap_at']=now()
    repo['last_bootstrap_evidence']='evidence/build/REPO_BOOTSTRAP.json'
    STATE_PATH.write_text(json.dumps(state,indent=2),encoding='utf-8')
    EVIDENCE_PATH.parent.mkdir(parents=True,exist_ok=True)
    evidence={
      'schema':'AI_PROD_REPO_BOOTSTRAP_EVIDENCE_v1',
      'observed_at':repo['last_bootstrap_at'],
      'result':result,
      'details':details,
      'secrets_recorded':False
    }
    EVIDENCE_PATH.write_text(json.dumps(evidence,indent=2),encoding='utf-8')
    if result.startswith('READY_') and (ROOT/'.git').exists():
        # Record bootstrap state/evidence on the active task branch; do not leave routine bootstrap dirt behind.
        subprocess.run(['git','add','PROJECT_STATE.json','evidence/build/REPO_BOOTSTRAP.json'],cwd=ROOT,check=False)
        diff=subprocess.run(['git','diff','--cached','--quiet'],cwd=ROOT)
        if diff.returncode != 0:
            subprocess.run(['git','commit','-m','chore(repo): record bootstrap state'],cwd=ROOT,check=True,stdout=subprocess.PIPE,stderr=subprocess.STDOUT,text=True)
    print(f"REPO_BOOTSTRAP_{result}")
    return code

def main():
    ap=argparse.ArgumentParser()
    ap.add_argument('--create-private-github',action='store_true')
    ap.add_argument('--push',action='store_true')
    ap.add_argument('--repo-name',default='')
    args=ap.parse_args()

    if not STATE_PATH.exists():
        print('REPO_BOOTSTRAP_HOLD missing PROJECT_STATE.json'); return 3
    state=json.loads(STATE_PATH.read_text(encoding='utf-8'))
    repo=state.setdefault('repository',{})
    repo.setdefault('bootstrap_owner','CODEX')
    repo.setdefault('provider','GITHUB')
    repo.setdefault('visibility_required','PRIVATE')
    repo.setdefault('remote_creation_authorized',False)
    repo.setdefault('remote_delete_authorized',False)
    repo.setdefault('remote_transfer_authorized',False)
    details={'root':str(ROOT),'provider':repo['provider'],'visibility_required':repo['visibility_required']}

    try:
        if shutil.which('git') is None:
            raise Hold('GIT_MISSING','git executable not available')

        # Local repository
        if not (ROOT/'.git').exists():
            run(['git','init','-b','main'])
        branch=out(['git','branch','--show-current']) or 'main'
        details['initial_branch']=branch

        # Identity must pre-exist; never fabricate it.
        user_name=out(['git','config','user.name'])
        user_email=out(['git','config','user.email'])
        if not user_name or not user_email:
            raise Hold('IDENTITY_REQUIRED','configured Git user.name/user.email required; identity will not be fabricated',4)
        details['git_identity_configured']=True

        # Initial commit if repository has no HEAD.
        has_head = subprocess.run(['git','rev-parse','--verify','HEAD'],cwd=ROOT,stdout=subprocess.DEVNULL,stderr=subprocess.DEVNULL).returncode==0
        if not has_head:
            run(['git','add','-A'])
            run(['git','commit','-m','chore(factory): bootstrap product repository'])

        main_sha=out(['git','rev-parse','HEAD'])
        details['baseline_commit']=main_sha

        # Ensure develop exists.
        if subprocess.run(['git','show-ref','--verify','--quiet','refs/heads/develop'],cwd=ROOT).returncode != 0:
            run(['git','branch','develop',main_sha])

        task_id=state.get('current_task',{}).get('id') or 'TASK-000'
        task_branch='task/'+re.sub(r'[^A-Za-z0-9._-]+','-',task_id)
        if subprocess.run(['git','show-ref','--verify','--quiet',f'refs/heads/{task_branch}'],cwd=ROOT).returncode != 0:
            run(['git','branch',task_branch,'develop'])
        run(['git','switch',task_branch])
        details['task_branch']=task_branch
        repo['local_git_state']='READY'
        repo['default_branch']='main'
        repo['integration_branch']='develop'
        repo['active_task_branch']=task_branch

        # Validate existing origin if any.
        origin=out(['git','remote','get-url','origin'])
        if origin:
            repo['remote_url']=origin
            details['existing_origin']=origin

        if args.create_private_github:
            if repo.get('provider') != 'GITHUB':
                raise Hold('PROVIDER_MISMATCH','private GitHub creation requested but provider is not GITHUB')
            if repo.get('visibility_required') != 'PRIVATE':
                raise Hold('VISIBILITY_POLICY_MISMATCH','Factory bootstrap only supports required PRIVATE visibility')
            if not repo.get('remote_creation_authorized',False):
                raise Hold('REMOTE_AUTHORIZATION_REQUIRED','set repository.remote_creation_authorized=true only under explicit current-task/user authorization',5)
            if shutil.which('gh') is None:
                raise Hold('AUTH_REQUIRED','GitHub CLI unavailable; provider authorization/environment required',6)
            rc,_=run(['gh','auth','status'],check=False)
            if rc!=0:
                raise Hold('AUTH_REQUIRED','GitHub authentication required',6)
            if not origin:
                name=args.repo_name or repo.get('name') or state.get('project',{}).get('repo') or state.get('project',{}).get('canonical_name','')
                name=slugify(name)
                run(['gh','repo','create',name,'--private','--source=.', '--remote=origin'])
                origin=out(['git','remote','get-url','origin'])
            rc,view=run(['gh','repo','view','--json','visibility,url,nameWithOwner'],check=False)
            if rc!=0:
                raise Hold('REMOTE_VERIFY_FAILED','unable to verify GitHub remote')
            try: meta=json.loads(view)
            except Exception: raise Hold('REMOTE_VERIFY_FAILED','GitHub remote metadata was not valid JSON')
            if meta.get('visibility') != 'PRIVATE':
                raise Hold('REMOTE_NOT_PRIVATE','remote visibility is not PRIVATE')
            repo['remote_url']=meta.get('url') or origin
            repo['remote_visibility']='PRIVATE'
            repo['remote_state']='READY'
            details['github']=meta
            if args.push:
                # Push exact baseline and integration/task branches. No force push.
                run(['git','push','-u','origin','main'])
                run(['git','push','-u','origin','develop'])
                run(['git','push','-u','origin',task_branch])
                details['push']='PASS'
            return save(state,'READY_REMOTE',details,0)

        repo['remote_state']='UNBOUND' if not origin else repo.get('remote_state','BOUND_UNVERIFIED')
        return save(state,'READY_LOCAL',details,0)

    except Hold as e:
        details['hold_code']=e.code
        details['message']=e.message
        # Keep safe local progress, but never claim remote readiness.
        repo['last_hold_code']=e.code
        return save(state,e.code,details,e.exit_code)

if __name__=='__main__':
    sys.exit(main())
