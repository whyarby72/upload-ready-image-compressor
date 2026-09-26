#!/usr/bin/env python3
from pathlib import Path
import hashlib,json
root=Path(__file__).resolve().parents[1]; ev=root/'evidence'; files=[]
for p in ev.rglob('*'):
    if p.is_file() and p.name!='INDEX.json' and p.name!='.gitkeep':
        files.append({'path':str(p.relative_to(root)).replace('\\','/'),'bytes':p.stat().st_size,'sha256':hashlib.sha256(p.read_bytes()).hexdigest()})
files.sort(key=lambda x:x['path'])
(ev/'INDEX.json').write_text(json.dumps({'schema_version':'1.0.0','file_count':len(files),'files':files},indent=2),encoding='utf-8')
print('EVIDENCE_INDEX_PASS',len(files))
