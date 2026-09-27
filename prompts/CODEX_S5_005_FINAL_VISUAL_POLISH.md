# CODEX TASK-S5-005 — FINAL VISUAL POLISH

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use the exact latest branch HEAD supplied by the caller.

Approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

Read first:
- `docs/ux/S5_005_HUMAN_VISUAL_FORENSIC_AUDIT_v1.0.md`
- `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
- `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`

This is a narrow final visual-polish pass. Do not redesign or change product/domain behavior.

## P1 — Requirement above-fold hierarchy

At 360x800, first viewport should show:
- one-line app identity;
- `Choose limit`;
- compact photo context;
- all six target choices;
- selected `Required ≤ ...` when selected;
- preferably the primary Continue action.

Reduce current media-card vertical footprint.

Preferred solution:
- compact horizontal media row/thumbnail around 88–112dp height;
- current size + dimensions beside/below thumbnail;
- maintain elegant Warm Ink treatment.

Do not remove actual photo context unless layout evidence proves necessary.

Capture:
- requirement unselected 360x800;
- requirement 100 KB selected 360x800;
- requirement 320x640;
- 1.3x requirement.

## P2 — Result value single-line guarantee

At 320dp and 360dp:
- friendly result size and unit must remain one line for realistic output sizes;
- `199 KB`, not `199\nKB`.

Do not truncate or hide the actual value.

Preferred:
- status badge on its own row;
- result value below it with responsive typography;
OR
- measured responsive type size with guaranteed unit pairing.

Test representative strings:
- 99 KB
- 199 KB
- 980 KB
- 1 MB
- 10.5 MB
- 50 MB

Exact bytes remain in proof strip below.

Capture:
- PASS 360x800;
- PASS 320x640;
- NOT_MET 360x800;
- REDUCED 360x800;
- 1.3x Result.

## P3 — Processing micro-polish

If touched:
- remove duplicate `On-device` body trust line when header already shows it;
- keep media preview + indeterminate progress;
- no fake percent.

Do not expand scope.

## P4 — No regression

Protected domain/compression files remain untouched.

Run:
- assembleDebug
- testDebugUnitTest
- lintDebug
- assembleRelease
- bundleRelease
- API36 launch
- API29 launch

Re-capture only the visual screens affected plus any required regression evidence.

Update evidence namespace:
`evidence/screenshots/s5_005_final/`

Generate fresh artifact hashes because source changes.

Final status:
`READY_FOR_FINAL_HUMAN_VISUAL_REVIEW`

Do not claim visual PASS.
No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
