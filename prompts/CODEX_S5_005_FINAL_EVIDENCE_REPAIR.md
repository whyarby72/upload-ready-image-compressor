# CODEX TASK-S5-005 — FINAL EVIDENCE REPAIR + 320DP CHIP LABEL FIX

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use exact latest branch HEAD supplied by caller.

Approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

Read first:
- `docs/ux/S5_005_FINAL_VISUAL_EVIDENCE_INTEGRITY_AUDIT_v1.0.md`
- `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
- `CURRENT_TASK.md`

This is NOT a redesign.

## A. Narrow source fix — target chips at 320dp

Fix only the target-chip layout so all labels render fully at 320dp.

Current observed defect:
- `Custom` renders as `Custo`.
- selected `100 KB` renders as check + `100`.

Requirements:
- all six visible labels must be complete:
  - 50 KB
  - 100 KB
  - 200 KB
  - 500 KB
  - 1 MB
  - Custom
- selected check remains visible;
- 48dp minimum touch target retained;
- no horizontal clipping;
- 320dp and 360dp both pass;
- 1.3x font Requirement remains usable.

Allowed implementation:
- reduce internal horizontal padding;
- reduce selected check/spacer slightly;
- use a narrowly smaller label style only at constrained width;
- width-aware layout.

Do not change target semantics.

## B. Evidence capture control repair

The previous final evidence contains mislabeled/duplicate frames.

Do not reuse those files as proof.

Create:
`evidence/screenshots/s5_005_final_recap/`

Before every capture, verify:
- foreground package;
- expected semantic tokens;
- viewport size;
- font scale when applicable.

Capture and semantically verify:

### Requirement
1. requirement_100kb_api36_360x800.png
2. requirement_100kb_api36_320x640.png
3. requirement_font_1_3x_api36.png

Required visible tokens:
- Choose limit
- 100 KB selected
- Custom fully visible
- Required ≤ 100 KB
- Continue

### Processing
4. processing_api36.png

Must show active indeterminate processing.
Must not show SMALLER COPY / MEETS LIMIT / TARGET NOT MET.

### PASS
5. result_pass_api36_360x800.png
6. result_pass_api36_320x640.png
7. result_pass_font_1_3x_api36.png

Required:
- MEETS LIMIT
- friendly size one line
- exact proof contains ≤

### NOT_MET
8. result_not_met_api36_360x800.png

Required:
- TARGET NOT MET
- proof >

### REDUCED
9. result_reduced_api36_360x800.png
10. result_reduced_api36_320x640.png
11. result_reduced_font_1_3x_api36.png

Required:
- SMALLER COPY
- No upload limit entered
- no PASS claim

## C. Hard anti-mislabel controls

For each capture create a sidecar semantic verification record containing:
- filename
- timestamp
- foreground package
- viewport
- font_scale
- expected_state
- observed required tokens
- observed forbidden tokens
- SHA-256
- PASS/FAIL

STOP if any state check fails.

Reject closure if:
- PASS / NOT_MET / REDUCED screenshots share the same SHA-256;
- normal / 1.3x evidence is byte-identical when it is claimed as different font-scale evidence;
- foreground package is system picker for an app-state screenshot;
- filename state does not match observed UI state.

## D. Build/evidence

Because source changes:
- assembleDebug
- unit tests
- lint
- assembleRelease
- bundleRelease
- fresh artifacts + full hashes

Protected domain/compression files remain untouched.

Update:
- evidence/INDEX.json
- TEST_MATRIX.csv
- PROJECT_STATE.json
- HANDOFF_CURRENT.md

Mark prior `s5_005_final` state-specific screenshots:
`INVALID_FOR_FINAL_VISUAL_PROOF / provenance only`

Do not delete provenance.

## Final status

Only if all semantic capture checks pass:
`READY_FOR_FINAL_HUMAN_VISUAL_REVIEW_RECAPTURED`

Do not self-declare visual PASS.
No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
