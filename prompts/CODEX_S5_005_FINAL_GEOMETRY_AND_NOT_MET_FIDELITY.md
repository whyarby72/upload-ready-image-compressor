# CODEX TASK-S5-005 — FINAL GEOMETRY + NOT_MET FIDELITY CORRECTIVE

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use the exact latest branch HEAD supplied by caller.

Existing approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

Read first:
1. `docs/product/IMAGE_GEOMETRY_PRESERVATION_CONTRACT_v1.0.md`
2. `docs/ux/S5_005_FINAL_DIRECT_VISUAL_REVIEW_v1.0.md`
3. `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
4. `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`
5. `CURRENT_TASK.md`

This replaces/supersedes the earlier standalone NOT_MET-copy corrective. Execute both narrow concerns in one pass.

## A. HARD GEOMETRY INVARIANT

Do not change protected compression/domain code unless tests prove an existing geometry defect.

First prove current engine behavior.

### A1. Output geometry tests

Add deterministic tests/evidence for:
- 1:1
- 3:2
- 2:3
- 4:3
- 3:4
- 16:9
- 9:16
- EXIF rotate-90
- mirrored EXIF if the existing fixture pipeline supports it

For each resized output:
- source oriented W/H;
- output oriented W/H;
- confirm uniform scaling;
- compute:
  `abs(W1 * H0 - H1 * W0)`
- required:
  delta <= W0 + H0
- confirm decoded output has no crop.

Also prove an ALREADY_READY/no-resize case.

Create:
`evidence/geometry/S5_005_GEOMETRY_PROOF.json`

If the existing engine fails:
STOP and report.
Do NOT modify protected compression/domain source without new explicit approval.

### A2. Preview truth policy

Refactor preview presentation so `PreviewBox` accepts explicit content scale.

Required:
- Requirement thumbnail: Crop allowed.
- Processing: Fit.
- Result hero: Fit.
- Before/After source: Fit.
- Before/After result: Fit.

No FillBounds.
No unequal X/Y scale.
No custom stretch.

Use Warm Ink `SurfaceSubtle` for any letterbox/pillarbox space.

### A3. Geometry visual fixtures

Use images with obvious edge markers / recognizable full-frame content.
Do not use only homogeneous texture.

Capture:
- landscape Result + Before/After;
- portrait Result + Before/After;
- square Result + Before/After.

The complete frame edges must be visible.

## B. FINAL NOT_MET COPY FIDELITY

For NOT_MET only add exact guidance:
`Try a higher limit or a different photo.`

For NOT_MET primary save action:
`Save current copy`

PASS / REDUCED remain:
`Save copy`

No fake retry.
No Go back.
No compression behavior change.

## C. Regression

Preserve:
- PASS / NOT_MET / REDUCED truth;
- exact-byte proof;
- Custom semantics;
- Save/Share;
- EXIF orientation handling;
- API29/API36 launch;
- permissions/privacy;
- no Internet/AdMob/analytics.

Run:
- assembleDebug
- testDebugUnitTest
- lintDebug
- assembleRelease
- bundleRelease

## D. Visual/evidence capture

Create:
`evidence/screenshots/s5_005_geometry_final/`

Required:
1. result_pass_landscape_360x800.png
2. result_pass_portrait_360x800.png
3. result_pass_square_360x800.png
4. before_after_landscape.png
5. before_after_portrait.png
6. result_not_met_api36_360x800.png
7. result_not_met_api36_320x640.png
8. result_not_met_font_1_3x_api36.png
9. result_not_met_actions_api36_360x800.png

Semantic proof for NOT_MET must contain:
- TARGET NOT MET
- proof >
- Try a higher limit or a different photo.
- Save current copy

Geometry evidence must include decoded dimensions, not only UI text.

## E. Artifact closure

Because presentation source changes:
- generate fresh debug APK;
- unsigned release APK;
- unsigned release AAB;
- record bytes/full SHA-256/source commit/environment/signing state.

Update:
- TEST_MATRIX.csv
- evidence/INDEX.json
- PROJECT_STATE.json
- HANDOFF_CURRENT.md

## Final status

Only:
`READY_FOR_FINAL_GEOMETRY_AND_VISUAL_HUMAN_REVIEW`

Do not self-declare visual PASS.
Do not self-declare geometry PASS without decoded-output evidence.
No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
