# TASK-S5-007 — CHAT OUTPUT SIZE DISPLAY CLARITY REVIEW v1.0

Observed: 2026-09-30
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-007`
Reviewed evidence closure: `b7a5191d5562b50e7d5869c81946f3bc2d270527`
Tested source: `27199bf6f174e55dc835d0d9898e456d3848001c`
Debug APK SHA-256: `843c6321febc8b1756c7ed3ba0f0d547fa74bad69bc7a9fef121f44a138e64ce`

## Disposition

`CHAT_CLARITY_REVIEW_PASS / HUMAN_APPROVAL_PENDING`

## Source review

Implementation diff from hardened pre-task HEAD changes only:
- `MainActivity.kt`;
- `FormatUtils.java`;
- `TargetLimitParserTest.java`.

Protected compression/domain/Save files are unchanged.

`FormatUtils.bytes()` remains unchanged for scan-friendly decimal-SI summary display.

A separate presentation helper `FormatUtils.exactBytes()` now formats grouped exact bytes.

Result arithmetic and PASS/NOT_MET classification remain unchanged.

## Direct runtime visual review

CHAT directly rendered:
- PASS 360x800;
- NOT_MET 360x800;
- REDUCED 360x800;
- PASS 320x640;
- PASS font scale 1.3.

### PASS 360

Observed:
- `MEETS LIMIT`;
- large rounded `981 KB` remains the main visual result;
- exact proof reads `Actual file: 981,182 bytes ≤ 1,000,000-byte limit — PASS`;
- unit disclosure is visible and visually secondary;
- Before/After remains visible;
- no material crowding or hierarchy regression.

Status: `PASS`.

### NOT_MET 360

Observed:
- `TARGET NOT MET`;
- exact proof reads `Actual file: 54,114 bytes > 50,000-byte limit — NOT_MET`;
- unit disclosure remains secondary;
- recovery guidance remains visible;
- Before/After remains visible.

Status: `PASS`.

### REDUCED 360

Observed:
- `SMALLER COPY`;
- exact actual bytes are shown;
- `no upload limit entered`;
- `No PASS claim`;
- unit disclosure is visible;
- no success semantics leak.

Status: `PASS`.

### PASS 320

Observed:
- exact proof and unit disclosure remain readable after scroll;
- Before/After remains coherent;
- Save, Share and Compress another are reachable;
- no clipping/overlap observed.

Status: `PASS`.

### Font scale 1.3

Observed:
- status, large rounded size, exact proof and disclosure remain readable;
- no overlap or clipping observed;
- lower actions remain reachable by the existing vertical scroll model.

Status: `PASS`.

## Semantic binding review

Foreground evidence for all required captures shows:
`com.afradadmedia.reducephotosize/.MainActivity`.

UIAutomator evidence confirms state-specific required anchors for PASS, NOT_MET and REDUCED and the canonical unit-disclosure text.

The 320 capture is intentionally scrolled; its visible state does not retain the top status badge in the hierarchy, but exact proof/disclosure and action reachability are present. This does not invalidate the small-screen usability evidence.

## Formatting tests

Verified source tests cover:
- 0 → 0;
- 999 → 999;
- 1000 → 1,000;
- 495669 → 495,669;
- 1000000 → 1,000,000.

Regression assertions also preserve:
- 495,669 bytes → `496 KB`;
- 1,500,000 bytes → `1.50 MB`.

Status: `PASS`.

## Save fidelity

TASK-S5-007 does not modify `MediaStoreSaver.java` or the result-writing path.

The evidence closure records a real in-app Save case:
- internal result: 981,182 bytes;
- MediaStore saved JPEG: 981,182 bytes;
- both SHA-256:
  `b9ee1bb65ce9cf7012665df5ea24690feefe8866a93243fd988c4f9a43d7de71`.

The repository proof records this equality; the saved JPEG binary itself is not retained in the repository. Save fidelity is additionally preserved by unchanged Save source and the earlier human-provided artifact evidence that independently showed byte-for-byte result/save identity.

Status:
`PASS_PRESERVED_WITH_FRESH_RECORDED_PROOF`.

## Instrumentation note

The evidence closure records:
`instrumentation_regressions = NOT_AVAILABLE_IN_THIS_RUN`.

This is not a blocker for TASK-S5-007 because:
- the task is presentation-only;
- protected compression/domain/Save files are unchanged;
- unit, lint, debug/release build and bundle gates pass;
- actual API36 runtime evidence covers the changed Result presentation.

Existing geometry/engine instrumentation evidence remains preserved by scope.

## Buyer problem resolution

The observed ambiguity is now addressed without changing arithmetic.

The app can still show:
`981 KB`

while the exact authoritative line makes the byte truth explicit, and the helper explains why another file manager may calculate a different KB label.

This prevents a different display convention from being mistaken for compression or Save mutation.

## Gate

- TASK-S5-007 source scope: PASS
- exact-byte formatting: PASS
- PASS/NOT_MET/REDUCED copy: PASS
- unit disclosure: PASS
- 320dp/font 1.3 usability: PASS
- Save fidelity: PASS_PRESERVED
- CHAT product-clarity review: PASS
- HUMAN TASK-S5-007 output-size clarity approval: PENDING
- Play handoff: PAUSED
- signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication: NOT AUTHORIZED

## Required next action

Human explicitly decides only:

`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY`

Approval closes this clarity corrective only.
It does not authorize Play/signing/S6/BUILD/freeze/release/publication.
