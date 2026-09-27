# S5-004 INDEPENDENT VISUAL + ARTIFACT AUDIT v1.0

Observed: 2026-09-27
Branch: `task/TASK-S5-004`
Starting contract HEAD: `a996a1d5c3cbe4c43eea6b0962dddb350cfa2e58`
Source commit: `959b131c7746dec1e5e8414f6b11d2741ae19b70`
Codex evidence closure: `a4dd389a764e7ce5e722c99759a48ab6d5b9a9ca`
Reviewer: CHAT

Disposition:
`HOLD_CORRECTIVE_UI_AND_EVIDENCE`

## What independently passes

### Commit/artifact binding
- start -> source is exactly one product-source commit;
- source -> closure contains evidence/state/artifacts only;
- no product source/build-logic changes after tested source commit.

### Visual improvement
The actual API36/API29 first-open screens are materially improved over the legacy baseline:
- text-glyph header removed;
- compact product identity introduced;
- cobalt-neutral palette coherent;
- rounded cards/buttons;
- first-open buyer job is immediately understandable;
- one dominant Choose photo CTA;
- on-device trust cue visible;
- legacy raised-button look removed from main app controls.

Requirement screen also materially improves:
- CURRENT PHOTO is a modern information card;
- no default target;
- 2x3 target selector is clearer;
- selected 100 KB state uses tonal fill + stronger outline;
- required-summary surface is distinct;
- known CTA remains disabled until selection;
- unknown-limit action remains reachable.

### Source truth
- no fake progress percentage or fake phase checklist;
- progress implementation is indeterminate;
- no Compose;
- no AdMob/analytics;
- no package/version identity drift;
- PASS wording uses `MEETS LIMIT`;
- REDUCED uses `SMALLER COPY`;
- NOT_MET uses honest quality-guard wording;
- Save is primary, Share secondary, Compress another tertiary;
- Custom invalid input stays in the dialog with inline validation.

### AAB
Fresh AAB SHA-256 independently recomputed:
`908755dddc0d030e22172d5ad9650037a513bffa8e86d701337dbff1ed646de6`

Actual AAB bytes independently decoded from GitHub:
`677037`

## Material/P1 defects

### V-01 — Custom Limit presentation still visually legacy

Implementation still uses platform `AlertDialog`, raw `EditText`, `RadioGroup`, and `RadioButton`.

Actual runtime screenshot shows:
- old white platform dialog;
- legacy radio circles for KB/MB;
- flat default text input;
- platform all-caps dialog actions.

This conflicts with the frozen Precision Utility blueprint and mockup-v2 contract, which required a visually coherent modern Custom modal and KB/MB segmented choice.

Disposition:
`FAIL_UI-05 / FAIL_UI-08`

Required correction:
- custom rounded 24dp dialog surface;
- styled numeric field;
- KB/MB segmented/toggle treatment with explicit selected state;
- modern Cancel / Use limit hierarchy;
- keep inline validation and keep-open-on-error behavior.

No parser changes.

### V-02 — Target icon is semantically wrong

`ic_target.xml` is a plus symbol:
`M10,2h4v6h6v4h-6v6h-4v-6H4V8h6z`

It appears as `+` in:
- requirement summary;
- Make it upload-ready primary CTA.

The icon does not represent a target/upload limit and looks accidental.

Required correction:
replace with a real target/bullseye/limit vector icon.

### V-03 — selected target lacks the required non-color visual indicator

Selected chip currently changes:
- fill;
- border.

Source adds only a contentDescription change for accessibility.
There is no visible check/indicator.

The binding contract required:
`border + tonal fill + indicator, not color only`.

Required correction:
add a visible selected check/indicator without reducing the 48dp touch target.

## Evidence closure defects

### E-01 — required screenshot set is incomplete

Binding contract required evidence for:
1. first open 320x640;
2. first open 360x800;
3. requirement unselected;
4. 100 KB selected;
5. Custom 10.5 KB;
6. progress;
7. PASS;
8. NOT_MET;
9. REDUCED;
10. Save success;
11. Share sheet;
12. API29 requirement;
13. large-font first open/requirement smoke.

Current `evidence/screenshots/s5_004/` contains first-open, requirement, selected target, picker, and Custom-dialog evidence only.

Missing material runtime visuals:
- progress;
- PASS result;
- NOT_MET result;
- REDUCED result;
- Save success;
- Share sheet;
- API29 requirement;
- 360x800 first open;
- large-font smoke.

Therefore UI-06/UI-07/UI-09/UI-10/UI-11/UI-13/UI-15 are not fully artifact-bound.

### E-02 — acceptance matrix is incomplete

TASK-S5-004 defines UI-01..UI-16.

The appended matrix currently covers only eight S5-UI rows and does not establish one-to-one evidence for all acceptance IDs.
The last row maps `S5-UI-08` to requirement `UI-07`, leaving UI-08..UI-16 without complete explicit closure.

Required:
one-to-one acceptance reconciliation for UI-01..UI-16.

### E-03 — debug APK hash typo in matrix

Several early S5-UI rows contain:
`eb30f81194d75b0b7424d75a3ae9f8373adae779d42ada26aa8d72d96cd8f76`

The recorded/debug artifact SHA is:
`eb30f81194d75b0b7424d75ba3ae9f8373adae779d42ada26aa8d72d96cd8f76`

The missing `b` makes those rows not artifact-bound.

### E-04 — AAB byte count drift

`S5_UI_UX_PROOF.json` records AAB bytes:
`677122`

Actual GitHub file size and independently decoded binary size:
`677037`

SHA-256 is correct.

Required:
fix proof byte count to the actual artifact.

### E-05 — Custom dialog evidence path mismatch

`api36_custom_dialog.png` does not visibly show the dialog in the captured frame.
The later invalid-inline screenshot does show the dialog.

Required:
capture a clean valid Custom dialog/open-state screenshot and a valid 10.5 KB selected state.

## Nonblocking visual observations

- At 320px width, `Reduce Photo Size` wraps to two lines because the On-device pill shares the header row. This is acceptable for corrective pass, but a one-line header or less crowded trust placement would be more polished if achievable without shrinking accessibility-critical text.
- Current photo/result secondary detail still exposes technical JPEG quality. Keep it secondary; do not promote it as the primary buyer explanation.
- The main first-open/requirement screens are already a substantial improvement and should not be redesigned again from scratch.

## Artifact disposition

Pre-redesign AAB:
`064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc`
remains provenance only.

Current S5-004 AAB:
`908755dddc0d030e22172d5ad9650037a513bffa8e86d701337dbff1ed646de6`
is valid evidence for source commit `959b131...` but is HOLD for Play because TASK-S5-004 requires corrective UI source changes.

Any corrective source change requires fresh APK/AAB hashes.

## Gate

TASK-S5-004:
`REOPENED_CORRECTIVE_REQUIRED`

Play:
`HOLD`

Canonical decision:
`TEST`

No S6 / BUILD / Artifact Freeze / release / publication claim.
