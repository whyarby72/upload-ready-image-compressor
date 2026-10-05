#!/usr/bin/env python3
from __future__ import annotations

import hashlib
import json
import shutil
import xml.etree.ElementTree as ET
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "build" / "w2-audit"
INTERMEDIATES = ROOT / "app" / "build" / "intermediates"
ANDROID_NS = "http://schemas.android.com/apk/res/android"
ANDROID_NAME = f"{{{ANDROID_NS}}}name"
ADMOB_META = "com.google.android.gms.ads.APPLICATION_ID"
AD_ID = "com.google.android.gms.permission.AD_ID"

OUT.mkdir(parents=True, exist_ok=True)

candidates = [
    p for p in INTERMEDIATES.rglob("AndroidManifest.xml")
    if "release" in str(p).lower()
]

def rank(path: Path) -> tuple[int, str]:
    s = str(path).lower()
    if "/merged_manifest/" in s or "\\merged_manifest\\" in s:
        return (0, s)
    if "/merged_manifests/" in s or "\\merged_manifests\\" in s:
        return (1, s)
    if "/packaged_manifests/" in s or "\\packaged_manifests\\" in s:
        return (2, s)
    return (9, s)

if not candidates:
    raise SystemExit("W2_AUDIT_FAIL: no release AndroidManifest.xml found under app/build/intermediates")

selected = sorted(candidates, key=rank)[0]
merged_out = OUT / "AndroidManifest.release.merged.xml"
shutil.copyfile(selected, merged_out)

root = ET.parse(selected).getroot()
permissions = sorted({
    node.attrib.get(ANDROID_NAME, "")
    for node in root.findall("uses-permission")
    if node.attrib.get(ANDROID_NAME)
})

app = root.find("application")
admob_app_id = None
if app is not None:
    for node in app.findall("meta-data"):
        if node.attrib.get(ANDROID_NAME) == ADMOB_META:
            admob_app_id = node.attrib.get(f"{{{ANDROID_NS}}}value")
            break

deps_path = OUT / "releaseRuntimeClasspath.txt"
dependency_focus = []
if deps_path.exists():
    for line in deps_path.read_text(encoding="utf-8", errors="replace").splitlines():
        if any(token in line for token in (
            "ads-mobile-sdk",
            "user-messaging-platform",
            "play-services-ads-identifier",
            "play-services-appset",
        )):
            dependency_focus.append(line)

apk_hashes = {}
for apk in sorted((ROOT / "app" / "build" / "outputs" / "apk" / "release").glob("*.apk")):
    digest = hashlib.sha256(apk.read_bytes()).hexdigest()
    apk_hashes[str(apk.relative_to(ROOT))] = digest

audit = {
    "selected_merged_manifest": str(selected.relative_to(ROOT)),
    "all_release_manifest_candidates": [str(p.relative_to(ROOT)) for p in sorted(candidates)],
    "package_attribute": root.attrib.get("package"),
    "permissions": permissions,
    "ad_id_permission_present": AD_ID in permissions,
    "admob_application_id_value": admob_app_id,
    "dependency_focus_lines": dependency_focus,
    "release_apk_sha256": apk_hashes,
}

(OUT / "manifest_audit.json").write_text(
    json.dumps(audit, indent=2, sort_keys=True) + "\n",
    encoding="utf-8",
)
(OUT / "permissions.txt").write_text(
    "\n".join(permissions) + ("\n" if permissions else ""),
    encoding="utf-8",
)
(OUT / "dependency_focus.txt").write_text(
    "\n".join(dependency_focus) + ("\n" if dependency_focus else ""),
    encoding="utf-8",
)

print("W2_ARTIFACT_AUDIT_PASS")
print(json.dumps(audit, indent=2, sort_keys=True))
