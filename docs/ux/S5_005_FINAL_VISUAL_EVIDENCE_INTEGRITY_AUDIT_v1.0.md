# S5-005 FINAL VISUAL EVIDENCE INTEGRITY AUDIT v1.0

Observed: 2026-09-28
Reviewer: CHAT
Direct review package:
`S5_005_FINAL_VISUAL_REVIEW.zip`
ZIP bytes: 2,335,442
ZIP SHA-256:
`8a8c4ba52cd9cacc52bda4ee42bc10416fcb540ef31db2e05ba2e7bee961bf7c`

Repository evidence baseline:
`1d932cfb239c3c74b426fa3a16cf8ed703b5df3a`

Disposition:
`HOLD_EVIDENCE_INTEGRITY_FAILURE_PLUS_NARROW_320DP_UI_DEFECT`

## 1. Repository binding

PASS.

Every reviewed uploaded screenshot SHA-256 matches the corresponding entry in `evidence/INDEX.json`.

Therefore the defects below are in the repository-bound evidence itself, not in ZIP packaging.

## 2. Material evidence-label failures

### E1 — PASS 360 evidence is actually REDUCED

File:
`result_pass_api36_360x800.png`

Observed:
- badge: `SMALLER COPY`
- result: `77 KB`
- proof: `No upload limit entered — no PASS claim`

This is REDUCED state, not PASS.

### E2 — NOT_MET 360 evidence is also the same REDUCED frame

Files:
- `result_not_met_api36_360x800.png`
- `result_pass_api36_360x800.png`
- `result_reduced_api36_360x800.png`

All three are byte-identical:
SHA-256:
`4d340f96d44b1815cff0a496e33493c3b9c9e2d4779ecabf04566aa6fc5cbf65`

Distinct semantic states cannot share the same screenshot.

### E3 — PASS 320 evidence is the Android system photo picker

File:
`result_pass_api36_320x640.png`

Observed:
- system Photos/Albums picker;
- no app Result state;
- no PASS badge/proof.

### E4 — PASS font-scale evidence is the same system picker

Files:
- `result_pass_api36_320x640.png`
- `result_pass_font_1_3x_api36.png`

Byte-identical:
SHA-256:
`2d4c45b19c0346ab6f84d92295750e4725f66281cd36738e37661739ad870474`

This proves the 1.3x Result claim was not captured.

### E5 — Requirement 1.3x evidence is actually Home

File:
`requirement_font_1_3x_api36.png`

Observed:
- `Fit your photo to an upload limit.`
- `Choose photo`

This is Home, not Requirement.

### E6 — Reduced 320 and Reduced font-scale are byte-identical

Files:
- `result_reduced_api36_320x640.png`
- `result_reduced_font_1_3x_api36.png`

SHA-256:
`5014ac7127ba31ba1d94c55850f6fe84f587f80a4ca6ac6a38aca9caa2097a44`

The font-scale claim is therefore unproven.

### E7 — Processing evidence does not show Processing

File:
`processing_api36.png`

Observed direct image is a completed `SMALLER COPY` result rather than an indeterminate processing state.

## 3. Actual visual findings that can be accepted

### Requirement 360x800

PASS.

Directly observed:
- all six target choices visible;
- selected summary visible;
- Continue visible;
- compact media row works;
- hierarchy materially improved.

### Requirement 320x640

PARTIAL / UI DEFECT.

Main hierarchy is now visible and Continue is visible.

However:
- `Custom` is clipped to `Custo`.
- selected `100 KB` chip renders as check + `100`, dropping the unit.

The missing `KB` is mitigated by `Required ≤ 100 KB` below, but the clipped `Custom` label is not acceptable for final polish.

Required source correction:
ensure all six target labels render fully at 320dp, with selected check still visible.

### Reduced Result 360x800

PASS for the REDUCED state itself.

Observed:
- `SMALLER COPY`;
- `77 KB` stays on one line;
- media-first result hierarchy is materially cleaner;
- compact proof is secondary;
- before/result visual is present.

### Reduced Result 320x640

PASS_WITH_SCROLL.

The result hero and one-line value are correct; lower comparison/actions naturally continue below fold.

## 4. Root cause in evidence-control gate

The evidence pipeline accepted filenames and operator claims without proving that the foreground app state matched each intended semantic state.

This is an evidence-control failure.

Earliest control that should have caught it:
semantic screenshot verification before file naming / index binding.

## 5. Mandatory evidence-control repair

For each screenshot, before naming/committing:

1. Verify foreground package:
`com.afradadmedia.reducephotosize`
unless the artifact intentionally documents the Android Sharesheet/system picker.

2. Dump UI semantics / accessibility tree or equivalent.

3. Match required state tokens:

Requirement selected:
- `Choose limit`
- `Required ≤ 100 KB`
- `Custom`
- `Continue`

Processing:
- processing message such as `Compressing…`, `Verifying…`, or `Making a smaller copy…`
- MUST NOT contain result-state token.

PASS:
- `MEETS LIMIT`
- exact proof contains `≤`

NOT_MET:
- `TARGET NOT MET`
- exact proof contains `>`

REDUCED:
- `SMALLER COPY`
- `No upload limit entered`

4. Verify viewport dimensions before capture.

5. For font-scale evidence:
record actual system font scale before capture; required `1.3`.
Restore after test.

6. Reject duplicate SHA-256 across screenshots that are supposed to represent different semantic states.

7. Human/operator visually inspects each frame before naming it.

8. Only then update TEST_MATRIX and evidence/INDEX.

## 6. Gate

Source/technical build:
`PASS`

Warm Ink visual direction:
`PASS`

Final evidence integrity:
`FAIL_RECAPTURE_REQUIRED`

320dp Requirement label:
`NARROW_SOURCE_FIX_REQUIRED`

Final visual PASS:
`NOT_GRANTED`

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
