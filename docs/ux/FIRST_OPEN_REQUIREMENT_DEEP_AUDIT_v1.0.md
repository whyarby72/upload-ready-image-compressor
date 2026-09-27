# FIRST_OPEN_REQUIREMENT_DEEP_AUDIT_v1.0

Observed: 2026-09-27
Baseline artifact/source: closure baseline `0ffe55ea0c1cc8dc22ac7f3e178b0cd551f8e3ca`
Scope: first-open -> choose photo -> requirement/target screen.
Decision: TASK-S5-003 IS JUSTIFIED BEFORE PLAY INTERNAL TESTING.

## Evidence

Fresh identity first-open:
- `evidence/screenshots/s5_identity_launch_api36.png`
- `evidence/screenshots/s5_identity_launch_api36_uiautomator.xml`

Requirement composition:
- `evidence/screenshots/photo_selected_api36.png`
- `evidence/screenshots/photo_selected_api36_uiautomator.xml`
- current `activity_main.xml`
- current `MainActivity.java`

The requirement screenshot predates the public-name migration, but the requirement panel source/layout is unchanged; the fresh-identity screenshot independently proves the new `Reduce Photo Size` header fits the same 320 px viewport.

## First-open audit

Reference viewport: 320 x 640.

Observed hierarchy:
- app header: y=24..55, ~22sp
- trust line: y=63..83, ~14sp
- hero starts y=117
- hero: two lines, ~30sp, y=117..193
- explanatory body: y=205..246, ~16sp
- primary CTA: y=274..330, 56 px high
- trust footer: y=342..361

### Verdict
PASS.

The first-open screen is unusually clean for this category:
- user understands the job before interacting;
- only one primary action is presented;
- privacy/on-device is visible but does not dominate;
- source-preservation/no-account reassurance is secondary;
- no unsupported functionality is advertised.

### No source change required
Do not add presets, editor controls, conversion options, ads, tutorials, or a feature carousel to first-open.

## Requirement-screen geometry audit

Observed standard viewport positions from the unchanged requirement composition:
- header/trust occupies through y=83
- requirement panel begins y=111
- CURRENT card y=111..262
- heading `What does the website require?` y=290..342 (two lines)
- helper y=348..389
- preset row 1 y=405..453
- preset row 2 y=453..501
- selected-target proof y=513..534
- primary CTA y=550..606
- unknown-limit fallback begins y=616 and continues below the 640 viewport

The primary verified path is completely visible. The fallback is scroll-accessible, but appears partially clipped in the first frame.

## MATERIAL FINDING — implicit 1 MB requirement

Current source initializes:
- `selectedTargetBytes = 1 MB`
- `selectTarget(1 MB, index 4)` during `onCreate`

Therefore the requirement screen opens with:
- `1 MB` visibly selected;
- `REQUIRED: <= 1 MB`;
- the primary compression CTA immediately actionable.

This conflicts with the product's source-of-truth semantics:
`REQUIRED: User-provided external website/form limit.`

### Failure scenario
A website requires <=100 KB.
User chooses a photo, sees a preselected 1 MB option, and taps the primary CTA without deliberately selecting 100 KB.
The app can correctly report PASS against 1 MB while failing the user's real external requirement.

This is not a compression-engine false PASS; it is a requirement-capture defect.

### Disposition
P0/P1 BUYER-JOB TRUTH RISK.
Fix before Play Internal Testing rather than asking S6 testers to validate a known requirement-capture ambiguity.

## Required surgical fix

### FR-01 — No implicit REQUIRED
On entering the requirement screen:
- no target is selected by default;
- display a neutral state such as `Choose the upload limit`;
- disable the verified-path primary CTA until the user explicitly selects a preset/custom limit;
- unknown-limit mode remains available as a deliberate alternative.

After user selection:
- show `REQUIRED: <= X`;
- enable primary CTA.

This preserves the distinction:
- known external limit -> eligible for PASS/NOT_MET;
- unknown external limit -> REDUCED only.

## Copy optimization with layout benefit

Replace:
`What does the website require?`

with:
`What's the upload limit?`

Why:
- shorter and more directly aligned to buyer vocabulary;
- applies to websites/forms without forcing the user to interpret “require”;
- likely fits one line at the current 20sp/280 px content width;
- recovers roughly one text line (~25-30 px) in the 320x640 reference layout;
- this should make the unknown-limit fallback fully or nearly fully visible without squeezing touch targets.

Recommended helper:
`Choose the maximum size shown on the website or form.`

## CTA architecture

Known-limit state:
- no selection: primary CTA disabled, label may remain `Make it upload-ready` or use `Choose a limit first` while disabled;
- after selection: `Make it upload-ready` becomes primary.

Unknown-limit state:
- `I don't know the upload limit` remains secondary and explicit.

Do not auto-map unknown users to an arbitrary preset.

## Preset grid

PASS:
- 50 KB / 100 KB / 200 KB / 500 KB / 1 MB / Custom are immediately legible;
- 48 px touch height in the reference emulator is adequate for the existing density;
- selected state uses border + tonal fill + text color, not color alone.

No need to add more presets before behavioral evidence.

## Typography

PASS at standard font scale:
- header 22sp;
- requirement heading 20sp;
- current size 34sp;
- body 16sp;
- selected requirement 15sp;
- target buttons use standard platform button text.

The hierarchy is coherent. Do not reduce font size merely to fit more content.

Large font scale remains an S6 test obligation.

## Spacing

Current spacing is generous rather than cramped until the lower CTA area.
Do not globally compress the screen.

Preferred order of intervention:
1. shorten the requirement heading to one line;
2. remove implicit 1 MB selection;
3. reassess screenshot;
4. only then reduce isolated margins if needed.

Avoid shrinking the CURRENT card or preset touch targets merely to keep everything above fold.

## App-header observation

Fresh header `✓ Reduce Photo Size` occupies x=20..231 on a 320 px viewport and is not crowded.

No migration-induced truncation exists.

The static check mark remains a P2 polish concern because it resembles a success-state mark, but it is not a reason to delay Internal Testing once the requirement-capture defect is fixed.

## Decision on TASK-S5-003

YES — create TASK-S5-003, but keep it narrowly bounded.

Required before next Play artifact:
1. remove implicit 1 MB REQUIRED;
2. require explicit target selection for verified PASS path;
3. shorten requirement heading to `What's the upload limit?`;
4. capture fresh first-open + requirement screenshots;
5. rerun PASS/NOT_MET/REDUCED truth, unknown-limit fallback, Custom target, Save/Share, API36/API29 launch, and build/lint/unit checks.

Optional in the same task only if low-risk:
- promote Save over Share;
- buyer-friendly NOT_MET/REDUCED copy;
- minimal rounded-button polish.

Do not turn TASK-S5-003 into a broad redesign.

## Artifact rule

Any source/UI change invalidates the current Play-candidate AAB:
`992a2acddb197796b7aec8be72923c7ec8759a2cb36cf39dcc7f91c32a60c7a6`

After TASK-S5-003, produce and bind fresh APK/AAB hashes before human Play action.
