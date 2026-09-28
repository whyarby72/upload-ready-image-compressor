# CODEX REPAIR WORK ORDER — TASK-S5-006 EVIDENCE RECAPTURE + VISUAL FIDELITY REPAIR

Observed: 2026-09-28
Branch: `task/TASK-S5-006`
Parent audit:
`docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.0.md`

Authority:
Existing TASK-S5-006 visual implementation approval remains sufficient.
This is deterministic repair/reverification only.

## 1. Read first

- `CURRENT_TASK.md`
- `PROJECT_STATE.json`
- `docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.0.md`
- `docs/ux/TASK_S5_006_VISUAL_ASSET_COMPLETENESS_CORRECTIVE_SPEC_v1.0.md`
- `docs/ux/S5_HIGH_FIDELITY_MOCKUP_V2_REVIEW_v1.0.md`
- existing screenshot manifest/fidelity matrix/artifact proof

## 2. Do not broaden scope

Do NOT change protected compression/domain files.
Do NOT change package/version/SDK/privacy/permissions.
Do NOT sign/upload/advance S6/promote BUILD/freeze/release/publish.

## 3. Repair Custom Limit helper

Current:
`Decimal KB or MB · 1 KB to 50 MB`

Binding buyer guidance must expose decimal semantics.

Use:
`Use a dot or comma for decimals · up to 3 decimal places`

Keep range enforcement unchanged.
If range guidance is still needed, preserve it elsewhere only if it remains visually compact and truthful.

This is presentation-only.

## 4. Rebuild + regression

After source change:
- `./gradlew clean assembleDebug`
- `./gradlew test`
- `./gradlew lintDebug`
- existing relevant instrumentation/regression where available

Protected domain diff must remain unchanged.

## 5. Fresh emulator recapture

Use API 36.

Replace/rebuild the TASK-S5-006 evidence set with semantically correct artifacts.

### Home 360
Capture:
`home_api36_360x800.png`

HARD CHECK before save:
The screenshot must visibly contain ALL:
- `Reduce Photo Size`
- `Fit your photo to an upload limit.`
- purpose-built hero illustration
- `Choose photo`
- `On-device · original untouched`

Do not capture Android splash.

### PASS
Capture:
`result_pass_api36.png`

HARD CHECK:
The screenshot must visibly contain:
- `MEETS LIMIT`
- output size
- exact `<=` proof
- no `TARGET NOT MET`
- no `>` proof

Use a deterministic source/target combination already known to produce PASS, e.g. a target large enough for the output. Do not fake state.

### Landscape Before/After
Capture:
`before_after_landscape_api36.png`

HARD CHECK:
- input fixture has display width > display height;
- Before and Result previews are visible;
- both preserve the same landscape geometry;
- this screenshot must not be byte-identical to the portrait/NOT_MET capture.

### Existing required set
Reconfirm:
- launcher_api36.png
- home_api36_320x640.png
- home_font_1_3x_api36.png
- requirement_real_photo_api36.png
- custom_limit_api36.png
- processing_real_photo_api36.png
- result_not_met_api36.png
- result_reduced_api36.png
- before_after_portrait_api36.png

Re-capture any file whose current content no longer matches its semantic label after source rebuild.

## 6. Semantic validation before manifest write

Before writing PASS, programmatically or manually inspect visible UI text/content for each screenshot.

Minimum negative controls:
- Home360 must not be splash-only.
- result_pass must not contain `TARGET NOT MET`.
- result_not_met must contain `TARGET NOT MET`.
- result_reduced must contain `SMALLER COPY`.
- landscape evidence must come from a landscape source.

If any condition fails:
do not write PASS; recapture.

## 7. Reconcile state/evidence

Update:
- `evidence/screenshots/s5_006_visual_productization/SCREENSHOT_MANIFEST.json`
- `docs/ux/TASK_S5_006_MOCKUP_RUNTIME_FIDELITY_MATRIX_v1.0.md`
- `evidence/play/S5_006_ARTIFACT_PROOF.json`
- `evidence/INDEX.json`
- `TEST_MATRIX.csv`
- `PROJECT_STATE.json`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`

Correct `PROJECT_STATE.artifacts.current_build` to the fresh TASK-S5-006 debug artifact identity.
Do not leave stale prior APK hash as current.

S5-VAC-02 and S5-VAC-03 may return to PASS only after the corrected artifacts exist and semantic checks pass.

## 8. Completion

If all deterministic repair succeeds:
- status:
  `IMPLEMENTED_MACHINE_QA_PASS_CHAT_PREMIUM_REVIEW_READY`
- progress: 98
- next owner: `CHAT`
- human premium gate remains pending;
- do not self-approve PREMIUM_QUALITY.

Final report must include:
- repair source commit;
- evidence closure commit;
- fresh debug APK SHA-256;
- changed files;
- exact PASS screenshot visible-text checks;
- screenshot manifest path;
- fidelity matrix path;
- state reconciliation result;
- protected-domain diff status.
