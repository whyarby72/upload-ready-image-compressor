# TASK-S5-007 — OUTPUT SIZE DISPLAY TRUTH AUDIT v1.0

Observed: 2026-09-30
Product: REDUCE PHOTO SIZE: KB LIMIT
Trigger: human manual emulator + saved-file evidence review
Decision: TEST

## 1. Disposition

`REWORK_PRESENTATION_ONLY / CROSS-DISPLAY_UNIT_AMBIGUITY`

This is NOT a compression defect.
This is NOT a Save defect.
This is NOT an exact-byte verification defect.

The defect is that the app's rounded decimal-SI KB/MB display can differ from Android file-manager size labels even when the saved file bytes are exactly identical, creating avoidable buyer distrust/support burden.

## 2. Evidence observed

Human-provided evidence includes:
- app Result screen reporting rounded decimal-SI size plus exact-byte proof;
- Android file-manager display for the saved JPEG;
- actual output JPEG and saved JPEG for one case.

### Case A — 500 KB target

App exact result:
`495,669 bytes`

App rounded display:
`496 KB`

Saved output:
`UploadReady_20260930_051947.jpg`

Saved output bytes:
`495,669`

Saved output SHA-256:
`f30a022df6c6c447a5c2d22aefc715277310d6455ce285d8f6db0fcd6992790b`

Engine/result file:
`UploadReady_result.jpg`

Engine/result bytes:
`495,669`

Engine/result SHA-256:
`f30a022df6c6c447a5c2d22aefc715277310d6455ce285d8f6db0fcd6992790b`

Therefore the saved file is byte-for-byte identical to the produced result.

The app display derives:
`495,669 / 1000 = 495.669 KB → 496 KB`

A 1024-byte display derives approximately:
`495,669 / 1024 = 484.05`

The observed file-manager label was approximately `484 KB`.

### Case B — second observed result

App exact result:
`199,392 bytes`

App rounded decimal-SI display:
`199 KB`

A 1024-byte display is approximately:
`194.72`

The human-observed file-manager label was approximately `195 KB`.

The pattern is consistent with unit-display convention, not byte mutation.

## 3. Canonical product truth remains unchanged

The product's bound custom-limit semantics remain:
- 1 KB = 1,000 bytes;
- 1 MB = 1,000,000 bytes;
- exact bytes are authoritative;
- PASS iff output bytes <= required bytes.

Therefore:
`495,669 bytes <= 500,000 bytes`
is correctly `PASS`.

Do NOT change target arithmetic to 1024-byte units merely to imitate a file manager.

## 4. Source confirmation

Current `FormatUtils.bytes()` intentionally formats:
- MB using divisor `1_000_000d`;
- KB using divisor `1_000d`;
- KB display rounded to zero decimal places.

Current Result proof line already uses exact byte counts, but presents them as:
`<output> bytes <= <target> bytes — PASS`

The exact-byte truth is correct, but the UI does not explicitly explain why another file manager may show a different KB number.

## 5. User-risk / support surface

Without clarification, a user may conclude:
- the Save operation altered the file;
- the app's reported size is inaccurate;
- the exact proof is inconsistent with Android Files;
- the app cannot be trusted for portal upload limits.

This is a support-prevention defect even though the bytes are correct.

## 6. Earliest reusable control that should have caught it

The unit-semantics decision correctly bound decimal-SI target arithmetic, but did not bind a cross-display explanation for buyer-visible result screens.

Reusable control to add:
`EXACT_BYTE_TRUTH + DISPLAY_UNIT_DISCLOSURE`

Rule:
when rounded KB/MB is buyer-visible and an external system/file manager may use another display convention, exact bytes must remain visible and the app must disclose its KB/MB convention compactly.

## 7. Preserved PASS

Remain valid:
- compression engine;
- output byte count;
- target parsing;
- PASS / NOT_MET / REDUCED classification;
- Save fidelity;
- Share fidelity;
- geometry;
- visual productization assets;
- generated Home hero;
- API29/API36 technical evidence.

## 8. Required correction

Presentation-only:
1. make exact file bytes read as an explicit `Actual file` statement;
2. make the byte-limit relationship explicit for PASS/NOT_MET;
3. disclose `1 KB = 1,000 bytes` compactly;
4. explain that some file managers may display 1,024-byte units;
5. preserve the existing large rounded KB/MB display for scanability;
6. do not add modal friction;
7. do not change compression/domain arithmetic.

## 9. Gate

- core technical: PASS, preserved
- Save fidelity: PASS, preserved
- exact-byte proof: PASS, preserved
- output-size display clarity: REWORK
- Play handoff: HOLD until this bounded presentation correction is reverified
- signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication: NOT AUTHORIZED
