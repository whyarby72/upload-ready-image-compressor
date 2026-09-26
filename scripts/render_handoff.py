#!/usr/bin/env python3
from pathlib import Path
import json,csv
root=Path(__file__).resolve().parents[1]
s=json.loads((root/'PROJECT_STATE.json').read_text(encoding='utf-8'))
with open(root/'TEST_MATRIX.csv',newline='',encoding='utf-8') as f:
    rows=list(csv.DictReader(f))
counts={}
for r in rows:
    k=(r.get('status') or 'UNKNOWN').strip() or 'UNKNOWN'
    counts[k]=counts.get(k,0)+1
p=s.get('project',{})
t=s.get('current_task',{})
a=s.get('authority',{})
L=[
    '# HANDOFF_CURRENT','',
    f"Product: {p.get('canonical_name','')}",
    f"Stage: {p.get('current_stage','')}",
    f"Decision: {p.get('canonical_decision','')}",
    f"Progress: {p.get('progress_percent',0)}%",
    f"Current task: {t.get('id','')}",
    f"Next owner: {t.get('next_owner', t.get('owner',''))}",
    f"Task status: {t.get('status','')}",
    '', '## Evidence summary'
]
for k in sorted(counts):
    L.append(f'- {k}: {counts[k]}')
L += [
    '', '## Authority',
    f"- build_authorized: {a.get('build_authorized')}",
    f"- artifact_freeze: {a.get('artifact_freeze')}",
    f"- release_authorized: {a.get('release_authorized')}",
    f"- publication_authorized: {a.get('publication_authorized')}",
    '', '## Blockers'
]
for x in s.get('open_blockers',[]) or ['None recorded']:
    L.append(f'- {x}')
L += ['', '## Human decisions required']
for x in s.get('human_decisions_required',[]) or ['None recorded']:
    L.append(f'- {x}')
L += ['', '## Next action', s.get('next_action','')]
(root/'HANDOFF_CURRENT.md').write_text("\n".join(L),encoding='utf-8')
print('HANDOFF_RENDER_PASS')
