#!/usr/bin/env python3
from pathlib import Path
import json,re,sys
root=Path(__file__).resolve().parents[1]
if len(sys.argv)<3:
    print('Usage: python scripts/init_product.py "Product Name" com.example.package'); sys.exit(2)
name=sys.argv[1].strip(); package=sys.argv[2].strip()
if not re.fullmatch(r'[A-Za-z_][A-Za-z0-9_]*(\.[A-Za-z_][A-Za-z0-9_]*)+',package):
    print('INIT_FAIL invalid Android package'); sys.exit(1)
p=root/'PROJECT_STATE.json'; s=json.loads(p.read_text(encoding='utf-8'))
s['project']['canonical_name']=name; s['project']['package_name']=package; s['next_action']='Complete opportunity evidence and PRODUCT_SPEC draft.'
p.write_text(json.dumps(s,indent=2),encoding='utf-8')
sp=root/'PRODUCT_SPEC.md'; x=sp.read_text(encoding='utf-8').replace('Canonical name:',f'Canonical name: {name}',1).replace('Package name:',f'Package name: {package}',1); sp.write_text(x,encoding='utf-8')
print('INIT_PRODUCT_PASS',name,package)
