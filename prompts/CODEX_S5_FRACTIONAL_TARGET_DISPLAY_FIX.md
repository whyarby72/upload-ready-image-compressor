# CODEX S5 FRACTIONAL TARGET DISPLAY CORRECTION

Repository: `whyarby72/upload-ready-image-compressor`
Branch: `task/TASK-S5-003`

Read:
1. `CURRENT_TASK.md`
2. `docs/ux/S5_003_INDEPENDENT_CLOSURE_AUDIT_v1.0.md`
3. `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`

Perform only the narrow corrective repair.

Required behavior:
- 10,500 bytes -> `10.5 KB`
- 1,500,000 bytes -> `1.5 MB`
- 1,000 bytes -> `1 KB`
- 50,000,000 bytes -> `50 MB`
- 1,001 bytes -> `1.001 KB`

Use decimal SI, up to 3 useful fractional digits, trim trailing zeros, and never round the displayed maximum upward.
Do not change exact-byte PASS/NOT_MET proof.

Add unit tests for target formatting.
Capture runtime requirement-screen evidence after valid Custom 10.5 KB and 1.5 MB selections.
Re-run preflight, debug build, unit, lint, release APK, AAB, API36/API29 smoke, PASS/NOT_MET/REDUCED, Save/Share/preservation/privacy proportional regression.
Generate fresh APK/AAB bytes + SHA-256.
Update matrix/state/handoff/evidence index.

The current AAB `968f3ae2928b407aa01efd96b14785c856d75861fe162d7f27bfc0169299c5e4` becomes provenance-only after source repair.

Do not broaden UI scope, integrate AdMob, sign/upload to Play, claim S6/BUILD, Artifact Freeze, release, or publication.
