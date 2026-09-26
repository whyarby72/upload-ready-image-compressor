#!/usr/bin/env python3
from pathlib import Path
import json,sys
root=Path(__file__).resolve().parents[1]
a=json.loads((root/'PROJECT_STATE.json').read_text(encoding='utf-8')).get('authority',{})
if a.get('publication_authorized') and (not a.get('artifact_freeze') or not a.get('release_authorized')):
    print('AUTHORITY_HOLD inconsistent publication authority'); sys.exit(1)
print('AUTHORITY_STATE', 'publication authorized — verify exact human packet' if a.get('publication_authorized') else 'publication NOT authorized')
