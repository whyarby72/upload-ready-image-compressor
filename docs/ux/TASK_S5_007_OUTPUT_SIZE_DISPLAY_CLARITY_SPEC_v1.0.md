# TASK-S5-007 — OUTPUT SIZE DISPLAY CLARITY SPEC v1.0

Observed: 2026-09-30
Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_OUTPUT_SIZE_TRUTH_CLARITY_REWORK
Implementation authority: GRANTED — bounded presentation-only scope

## 1. Objective

Prevent buyer confusion when the app's decimal-SI KB/MB display differs from Android or third-party file-manager labels, while preserving exact-byte truth and the existing target semantics.

## 2. Frozen semantics

Do NOT change:
- 1 KB = 1,000 bytes;
- 1 MB = 1,000,000 bytes;
- custom-limit parser;
- min/max range;
- max 3 fractional digits;
- dot/comma decimal separator;
- PASS iff `outputBytes <= targetBytes`;
- compression algorithm;
- saved bytes;
- output encoding;
- package/version/SDK.

## 3. Result hierarchy

Keep the current large human-readable result size:
- example: `496 KB`

This remains a scan-friendly decimal-SI summary.

Immediately below, use an explicit exact-byte proof.

### PASS

Current:
`495669 bytes ≤ 500000 bytes — PASS`

Required:
`Actual file: 495,669 bytes ≤ 500,000-byte limit — PASS`

### NOT_MET

Required:
`Actual file: 80,947 bytes > 50,000-byte limit — NOT_MET`

### REDUCED / no known limit

Required:
`Actual file: 1,680,123 bytes · no upload limit entered`

Second line may retain:
`No PASS claim`

Do not imply success against an unknown limit.

## 4. Unit disclosure

Add a compact, quiet helper on Result screens:

`Size units here: 1 KB = 1,000 bytes. Some file managers calculate KB using 1,024 bytes.`

Requirements:
- secondary text color;
- small body/label style;
- not inside the primary status badge;
- no modal;
- no tooltip required for MVP;
- should not push Save/Share into an unusable position at 320x640;
- may wrap to two lines.

## 5. Number formatting

Add a presentation helper for exact byte counts with grouping:
- `495,669`
- `500,000`
- `1,000,000`

Locale for canonical English UI:
- comma thousands grouping;
- no decimal fraction for bytes.

This helper is presentation-only and must not participate in arithmetic.

## 6. Before/After

Keep rounded sizes in Before/After for compact comparison.

Do not repeat the unit disclosure under each thumbnail.

The exact result byte statement is authoritative.

## 7. Requirement screen

No mandatory new note on the Requirement screen.

Reason:
the user-selected target labels already follow the product's declared decimal-SI semantics; repeating the file-manager caveat before processing would add noise without solving the observed confusion.

## 8. Acceptance criteria

### SD-01 Exact saved-file truth
For a saved output, app exact output bytes and actual file bytes are identical.

### SD-02 PASS copy
PASS result explicitly says `Actual file` and shows grouped exact output bytes, exact target bytes, and `PASS`.

### SD-03 NOT_MET copy
NOT_MET explicitly says `Actual file` and shows grouped exact output/target bytes.

### SD-04 REDUCED copy
Unknown-limit result shows exact actual-file bytes but makes no PASS claim.

### SD-05 Unit disclosure
Result includes:
`1 KB = 1,000 bytes`
and explains that some file managers may show 1,024-byte units.

### SD-06 Arithmetic unchanged
Target parser / compression / classification behavior remains byte-identical to pre-task behavior.

### SD-07 Small screen
320x640 remains usable; Save/Share controls remain reachable.

### SD-08 Standard screen
360x800 hierarchy remains calm and readable.

### SD-09 Font scale
1.3x remains usable without overlap/clipping.

### SD-10 Saved-file evidence
At least one output must prove:
- result exact bytes;
- saved file byte count;
- matching SHA-256 between engine result and saved copy or otherwise prove saved file identity under the existing Save path.

## 9. Evidence set

Fresh API36 runtime evidence:
- PASS 360x800;
- NOT_MET 360x800;
- REDUCED 360x800;
- PASS 320x640;
- PASS font scale 1.3;
- saved-file byte/hash proof.

Exact source/artifact hash required.

## 10. Non-goals

Do NOT:
- switch to KiB labels;
- change target presets;
- change compression;
- change Save;
- redesign Result;
- add settings;
- add a unit preference;
- add a modal educational screen;
- change generated Home hero.

## 11. Source mutation boundary

Expected app-source mutation is limited to:
- `MainActivity.kt`;
- `FormatUtils.java`;
- optional formatting-only unit test under the existing unit-test package.

Protected compression/domain/Save files remain unchanged.

## 12. Deterministic evidence binding

Every PASS / NOT_MET / REDUCED screenshot used for closure must bind:
- screenshot SHA-256;
- foreground package proof;
- UIAutomator hierarchy from the same state/session;
- required and forbidden semantic anchors.

A filename or manifest description alone is not evidence of screen state.

## 13. Saved-file proof method

At least one case must execute the real UI Save action and independently compare:
- app result cache JPEG;
- MediaStore saved JPEG.

Record bytes and SHA-256 for each.
Closure requires equality.

## 14. Current disposition

`IMPLEMENTATION_AUTHORIZED / CODEX_READY_AFTER_WORK_ORDER_HARDENING`

Approval scope:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY IMPLEMENTATION`

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_IMPLEMENTATION`
