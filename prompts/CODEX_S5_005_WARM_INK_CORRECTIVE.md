# CODEX TASK-S5-005 — WARM INK FIDELITY CORRECTIVE

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-005`

Required starting HEAD:
use the exact latest branch HEAD supplied by the caller.

Approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

This corrective pass is inside the already-approved presentation-layer scope.

Read:
1. `docs/ux/S5_005_INDEPENDENT_SOURCE_AUDIT_v1.0.md`
2. `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
3. `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`
4. `CURRENT_TASK.md`

STOP on starting-HEAD mismatch.

## Do not change protected domain files

Do not modify:
- JpegCompressionEngine.java
- TargetLimitParser.java
- ImageInspector.java
- MediaStoreSaver.java
- ResultContentProvider.java
- CompressionResult.java
- ImageInfo.java

If a protected-domain change appears necessary, STOP and report.

## Corrective source requirements

### F1 — Minimal Home
Implement the approved low-text Home:
- one-line app identity;
- `Fit your photo to an upload limit.`
- refined owned Warm Ink media artwork/illustration;
- `Choose photo`;
- one compact trust line.

Remove:
- long explanatory paragraph;
- PHOTO UTILITY label;
- Before → smaller, with proof text block;
- duplicate trust copy.

The media artwork must be locally owned/generated or built in Compose; do not add unlicensed stock media.

### F2 — Minimal Requirement
Use:
- `Choose limit`
- selected photo/media surface
- 50/100/200/500 KB / 1 MB / Custom
- compact `Required ≤ ...`
- primary `Continue`
- low-emphasis `I don't know the limit`

Remove the extra explanatory paragraph unless a short accessibility-support sentence is demonstrably necessary.

### F3 — Selected chip
Add visible selected check indicator plus tonal/outline change and semantics.

### F4 — Custom inline validation
Keep the dialog open when TargetLimitParser rejects input.

Implementation may call `TargetLimitParser.parse()` directly inside the dialog's validation handler because it is pure domain validation; do not reimplement parser rules.

On success:
- dispatch/apply parsed bytes;
- close dialog.

On failure:
- show inline error;
- preserve previous valid target;
- keep dialog open.

### F5 — Media-first Processing
Use actual source preview when available.
Overlay/pair a subtle indeterminate progress indicator.
Copy:
- `Compressing…`
- `Verifying…`
- or `Making a smaller copy…`
as appropriate.

No percentage/fake phases.

### F6 — Media-first Result
Recompose the result screen:
- actual result preview is the visual hero;
- status and result size are integrated with/adjacent to hero;
- exact-byte truth is a compact verification strip;
- no redundant explanatory paragraph for PASS;
- before/after remains visual and compact;
- metadata limited to `JPEG · WxH` + optional quiet `Original untouched`;
- technical JPEG quality is not primary UI.

### F7 — Result action dock
Use:
- one primary `Save copy` / `Save current copy`;
- compact two-cell secondary dock: Share | Compress another.

Do not stack Save + Share + Compress another as three vertical actions.

### F8 — Save icon
Replace floppy-disk icon with contemporary save-to-device/download icon.

### F9 — Warm Ink vectors
Remove rendered bright-cobalt visual residues from active vector/icon resources.

### F10 — EXIF preview parity
Update PreviewLoader to mirror JpegCompressionEngine orientation handling for:
- FLIP_HORIZONTAL
- FLIP_VERTICAL
- TRANSPOSE
- TRANSVERSE
in addition to rotations.

Add focused tests where feasible.

### F11 — responsive 320dp
Protect one-line product identity.
At narrow width, move or simplify On-device trust treatment rather than compressing/truncating the product name.

### F12 — central typography
Create/reuse centralized Warm Ink typography tokens and apply them consistently.

## Verification

Run:
- preflight
- assembleDebug
- unit tests
- lintDebug
- assembleRelease
- bundleRelease

Runtime:
- API36
- API29

Functional regression:
- no default target
- all presets
- Custom 10.5 KB / 1.5 MB
- invalid Custom stays open
- PASS
- NOT_MET
- REDUCED
- Save
- Share
- original preservation
- EXIF rotation + mirrored orientation preview parity
- large input
- offline/privacy/permissions

## Required current evidence

Create a dedicated evidence namespace, e.g.:
`evidence/screenshots/s5_005/`

Capture:
1. Home 320x640
2. Home 360x800
3. Requirement unselected
4. Requirement selected
5. Custom valid
6. Custom invalid inline
7. Processing actual
8. PASS
9. NOT_MET
10. REDUCED
11. Save success
12. Share sheet
13. API29 Requirement
14. 1.3x Home
15. 1.3x Result
16. mirrored EXIF preview parity if fixture exists

Inspect every screenshot before naming.

## Artifact proof

Commit evidence for fresh:
- debug APK
- release APK
- release AAB

Record full:
- path
- bytes
- SHA-256
- source commit
- environment
- signing state

Update:
- evidence/INDEX.json
- TEST_MATRIX.csv
- PROJECT_STATE.json
- HANDOFF_CURRENT.md

Mark pre-Compose AAB provenance-only.

## Final state

Only if all technical checks pass:
`READY_FOR_HUMAN_VISUAL_REVIEW`

Do not claim visual PASS.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
