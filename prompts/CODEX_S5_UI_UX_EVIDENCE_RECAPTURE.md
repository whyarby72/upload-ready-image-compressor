# CODEX S5-004 EVIDENCE-ONLY RECAPTURE

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-004`

Required starting HEAD:
`<use latest branch HEAD containing this prompt>`

Read:
1. `docs/ux/S5_004_CORRECTIVE_INDEPENDENT_REVIEW_v1.0.md`
2. `evidence/play/S5_UI_UX_CORRECTIVE_PROOF.json`
3. `CURRENT_TASK.md`

Mode:
`EVIDENCE_ONLY / NO PRODUCT SOURCE MUTATION`

Do not edit:
- `app/**`
- Gradle/build logic
- manifest
- package/version/signing

Use the existing corrective debug APK whose expected SHA-256 is:
`690318caca04be7a43d7d5d1debf17613ea20a8b66bf0c18639ede86dd1f5370`

Before runtime:
- compute the APK SHA-256;
- record it;
- stop if it does not match.

Recapture clean actual app evidence:

1. API36 first open at 320x640 after splash is gone.
2. API36 first open around 360x800 after splash is gone.
3. API36 indeterminate progress while compression/reduction is actually running.
4. API36 clean NOT_MET result showing:
   - TARGET NOT MET;
   - final size;
   - exact `output bytes > target bytes` proof;
   - buyer explanation;
   - Save/Share/Compress another hierarchy.
5. API36 requirement screen at font-scale >=1.3x, after picker returns to app.
6. API29 requirement unselected after document picker returns to app.

For every screenshot:
- verify package/activity is the app, not picker/system overlay;
- capture UI hierarchy when useful;
- inspect image before naming it;
- do not claim PASS from filename alone.

Then reconcile:
- UI-01..UI-16 one-to-one in TEST_MATRIX;
- corrective proof;
- evidence index;
- state/handoff.

Do not change product source.
Do not rebuild/re-hash artifacts unless source/build files changed.
Do not sign/upload to Play.
Return final evidence commit SHA to CHAT.
