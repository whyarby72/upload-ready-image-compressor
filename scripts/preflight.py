#!/usr/bin/env python3
from pathlib import Path
import json,csv,sys
root=Path(__file__).resolve().parents[1]
required=['AGENTS.md','PRODUCT_SPEC.md','ACCEPTANCE_CRITERIA.md','CURRENT_TASK.md','TEST_MATRIX.csv','PROJECT_STATE.json','DECISIONS.md','CHANGELOG.md']
missing=[x for x in required if not (root/x).exists()]
if missing:
    print('PREFLIGHT_FAIL missing:', ', '.join(missing)); sys.exit(1)
try: state=json.loads((root/'PROJECT_STATE.json').read_text(encoding='utf-8'))
except Exception as e:
    print('PREFLIGHT_FAIL state:',e); sys.exit(1)
if state.get('current_task',{}).get('owner') not in {'CHAT','CODEX','WORK','HUMAN'}:
    print('PREFLIGHT_FAIL owner'); sys.exit(1)
a=state.get('authority',{})
for k in ['build_authorized','artifact_freeze','release_authorized','publication_authorized']:
    if not isinstance(a.get(k),bool): print('PREFLIGHT_FAIL authority',k); sys.exit(1)
with open(root/'TEST_MATRIX.csv',newline='',encoding='utf-8') as f:
    r=csv.DictReader(f); rows=list(r)
    cols={'test_id','requirement_id','stage','environment','fixture','expected','actual','evidence_path','artifact_version','artifact_hash','status','last_run'}
    if not rows or not cols.issubset(set(r.fieldnames or [])):
        print('PREFLIGHT_FAIL test matrix'); sys.exit(1)
print('PREFLIGHT_PASS')
