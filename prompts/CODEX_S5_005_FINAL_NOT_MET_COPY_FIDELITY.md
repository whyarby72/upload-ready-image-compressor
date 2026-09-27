# CODEX TASK-S5-005 — FINAL NOT_MET COPY FIDELITY FIX

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use the exact latest branch HEAD supplied by caller.

Approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

Read:
- `docs/ux/S5_005_FINAL_DIRECT_VISUAL_REVIEW_v1.0.md`
- `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
- `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`

This is the final narrow presentation-copy fidelity fix.

## Scope

Do not change protected domain/compression files.
Do not redesign Result.

For NOT_MET only:

1. Add guidance exactly:
`Try a higher limit or a different photo.`

Place it as a quiet warning-support line/surface after exact proof and before/with the comparison area, preserving Warm Ink hierarchy.

2. Primary save label must be:
`Save current copy`

For PASS / REDUCED:
keep:
`Save copy`

Do not add fake retry behavior.
Do not add Go back.
Do not change compression semantics.

## Responsive proof

Capture:
- result_not_met_api36_360x800.png
- result_not_met_api36_320x640.png
- result_not_met_font_1_3x_api36.png
- result_not_met_actions_api36_360x800.png

The action-area frame must visibly show:
- Save current copy
- Share
- Compress another

Semantic sidecar must verify:
- TARGET NOT MET
- proof contains >
- Try a higher limit or a different photo.
- Save current copy

Forbidden:
- MEETS LIMIT
- SMALLER COPY

Quick regression:
- PASS save label = Save copy
- REDUCED save label = Save copy

## Technical

Because source changes:
- assembleDebug
- testDebugUnitTest
- lintDebug
- assembleRelease
- bundleRelease
- fresh artifact hashes

Keep previous valid recap evidence as provenance for unaffected states.
Create a narrow namespace:
`evidence/screenshots/s5_005_not_met_final/`

Update:
- SEMANTIC_VERIFICATION.json for new NOT_MET captures;
- TEST_MATRIX.csv;
- evidence/INDEX.json;
- PROJECT_STATE.json;
- HANDOFF_CURRENT.md.

Final status only:
`READY_FOR_FINAL_NOT_MET_HUMAN_VISUAL_REVIEW`

Do not self-declare visual PASS.
No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
