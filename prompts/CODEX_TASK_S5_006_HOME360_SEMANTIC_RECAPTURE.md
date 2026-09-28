# CODEX EVIDENCE-ONLY WORK ORDER — TASK-S5-006 HOME360 SEMANTIC RECAPTURE

Observed: 2026-09-29
Branch: `task/TASK-S5-006`
Parent audit:
`docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.1.md`

Authority:
Existing TASK-S5-006 implementation approval.
Evidence-only recapture; no source change is required or authorized.

## 1. Synchronize first

```bash
git status --short
git fetch origin
git checkout task/TASK-S5-006
git pull --ff-only origin task/TASK-S5-006
git rev-parse HEAD
```

If uncommitted changes exist, STOP and report.
Do not reset/stash/discard.

## 2. Read

- `docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.1.md`
- `docs/engine/AI_PROD_ANDROID_NATIVE_VISUAL_PRODUCTIZATION_GATE_PATCH_v1.0.1.md`
- current screenshot manifest
- current PROJECT_STATE / TEST_MATRIX

## 3. Do not change source

Do NOT edit `app/` or production/test source.

Do NOT rebuild unless installation is missing and the exact repaired debug APK can no longer be used.

Expected repaired source:
`bfd3c329efbc58b82e99c101d744c3746c711468`

Expected debug APK SHA-256:
`34c6af2c5f42d18893608b923dac28fef2ba8710802ae4fbe55bde9839c05814`

## 4. Prepare emulator 360x800

Use API 36 emulator.

Ensure logical display is 360x800 and font scale is default for this capture.

Launch:
`com.afradadmedia.reducephotosize`

Wait until splash has exited.

## 5. Mandatory capture-time semantic binding

Immediately before screenshot:

### A. Foreground package proof

Capture:
```bash
adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp'
```

Persist to:
`evidence/screenshots/s5_006_visual_productization/home_api36_360x800_foreground.txt`

HARD REQUIREMENT:
output must identify:
`com.afradadmedia.reducephotosize`

If not, do NOT capture. Relaunch/wait and retry.

### B. UI hierarchy proof

Dump hierarchy from the same displayed state:
```bash
adb shell uiautomator dump /sdcard/home360.xml
adb pull /sdcard/home360.xml evidence/screenshots/s5_006_visual_productization/home_api36_360x800_uiautomator.xml
```

HARD REQUIREMENT:
hierarchy must contain all:
- `Reduce Photo Size`
- `Fit your photo to an upload limit.`
- `Choose photo`
- `On-device · original untouched`

If any anchor is missing:
do NOT accept screenshot; fix runtime state and repeat.

### C. Screenshot

Only after A and B PASS:
```bash
adb exec-out screencap -p > evidence/screenshots/s5_006_visual_productization/home_api36_360x800.png
```

Visually inspect the file and confirm it shows the app Home, not launcher, wallpaper, splash, picker, or system UI surface.

## 6. Hash and bind

Compute SHA-256 for:
- screenshot PNG;
- foreground txt;
- UIAutomator XML.

Update:
- `SCREENSHOT_MANIFEST.json`
- `evidence/INDEX.json`
- `TEST_MATRIX.csv`
- `PROJECT_STATE.json`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`

Add explicit screenshot-semantic binding evidence:
- foreground package PASS;
- UI anchor PASS;
- screenshot SHA.

S5-VAC-02 may be PASS only if all three are bound.

S5-VAC-AUDIT-01 must reference v1.1 audit and corrected binding.

## 7. Completion status

If successful:
`IMPLEMENTED_MACHINE_QA_PASS_CHAT_PREMIUM_REVIEW_READY`

Next owner:
`CHAT`

Human PREMIUM_QUALITY approval remains pending.

Do not sign/upload/advance S6/promote BUILD/freeze/release/publish.

## 8. Final report

Return:
- evidence-only closure commit;
- Home360 PNG SHA-256;
- foreground proof path + observed package;
- UI hierarchy path + confirmed required anchors;
- screenshot manifest reconciliation;
- TEST_MATRIX reconciliation;
- confirmation that no app/source files changed.

Then STOP for CHAT direct review.
