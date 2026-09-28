# CODEX TASK-S5-005 — ACTUAL ENGINE GEOMETRY PROOF REPAIR

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use the exact latest branch HEAD supplied by caller.

Read:
1. `docs/qa/S5_005_GEOMETRY_PROOF_INDEPENDENT_AUDIT_v1.0.md`
2. `docs/product/IMAGE_GEOMETRY_PRESERVATION_CONTRACT_v1.0.md`
3. `CURRENT_TASK.md`

This is a TEST/EVIDENCE repair.

## Hard boundary

DO NOT modify protected compression/domain production files.

The current UI Fit/NOT_MET source correction remains accepted.

If actual production-engine output violates geometry preservation:
STOP and report exact fixture, source dimensions, output dimensions, state and hashes.
Do NOT fix the protected engine without new explicit approval.

## A. Exercise the actual production engine

Create a deterministic Android instrumentation/runtime test or equivalent test-only harness that invokes the real production `JpegCompressionEngine` with real JPEG inputs and a real Android Context.

Do not merely test `ScalePlanner`.

For every fixture:
1. inspect source through the same orientation semantics used by production;
2. invoke the production engine;
3. obtain the actual result JPEG file;
4. decode the result JPEG;
5. record observed output dimensions.

## B. Required matrix

Required:
- 1:1
- 3:2
- 2:3
- 4:3
- 3:4
- 16:9
- 9:16
- EXIF rotate-90
- mirrored EXIF if supported by existing fixture tooling
- ALREADY_READY/no-resize

For resize cases, choose deterministic input size/target so an actual resize occurs where technically possible under current quality guard.

Do not fake `resized=true`.

## C. Per-record proof schema

For every case record at minimum:

- fixture
- source_file_sha256
- source_bytes
- source_raw_width
- source_raw_height
- source_exif_orientation
- source_display_width (W0)
- source_display_height (H0)
- target_bytes
- engine_state
- resized
- output_file_sha256
- output_bytes
- output_decoded_width (W1)
- output_decoded_height (H1)
- source_ratio
- output_ratio
- cross_product_delta = abs(W1*H0 - H1*W0)
- allowed_tolerance = W0 + H0
- ratio_status
- decode_status
- final_status

No placeholder strings such as:
`or-scaled-uniformly`

All dimensions must be observed integers from actual files.

## D. Full-frame / crop truth

Actual engine output must be full-frame.

Use fixtures with visible edge markers where feasible.

For at least landscape, portrait and square:
retain source and output JPEGs under:
`evidence/geometry/s5_005_actual_outputs/`

Record hashes.

If practical, capture visual before/output comparisons from those exact files.

## E. Update evidence

Upgrade:
`evidence/geometry/S5_005_GEOMETRY_PROOF.json`

Correct:
`TEST_MATRIX.csv`

S5-24 may be PASS only when actual decoded output evidence supports it.

Update:
- evidence/INDEX.json
- PROJECT_STATE.json
- HANDOFF_CURRENT.md

## F. Verification

Run required geometry instrumentation/runtime test plus:
- assembleDebug
- testDebugUnitTest
- lintDebug

Do not rebuild release APK/AAB unless source or build inputs change.
If only test/evidence files change, retain current source artifacts and bind them explicitly.

## Final status

Only if every mandatory actual-engine geometry record passes:
`READY_FOR_FINAL_GEOMETRY_HUMAN_REVIEW`

Do not self-declare human visual PASS.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
