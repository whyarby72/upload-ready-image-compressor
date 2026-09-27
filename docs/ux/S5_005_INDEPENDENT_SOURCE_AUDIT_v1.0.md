# S5-005 INDEPENDENT SOURCE AUDIT v1.0

Observed: 2026-09-27
Branch: `task/TASK-S5-005`
Required start: `e1c71aebca8b4c2218890f47fe44ed52a1cb4454`
Implementation commit: `ee59fbf78cd0623b83b8bb6785aa479688231a38`
Reviewer: CHAT

Disposition:
`TECHNICAL_MIGRATION_PASS / WARM_INK_FIDELITY_REWORK_REQUIRED`

## What passes

### Commit lineage
Implementation is exactly one commit ahead of the required starting HEAD.

### Protected domain source
The implementation commit does not modify:
- JpegCompressionEngine.java
- TargetLimitParser.java
- ImageInspector.java
- MediaStoreSaver.java
- ResultContentProvider.java
- CompressionResult.java
- ImageInfo.java

This satisfies the core presentation-layer migration boundary.

### Toolchain direction
Observed:
- compileSdk 37
- targetSdk 36 retained
- minSdk 29 retained
- versionCode/versionName retained
- Compose BOM 2026.09.00
- activity-compose 1.13.0
- Compose Material3
- Kotlin/Compose plugin setup added
- no AdMob/network/analytics/signing/Play changes observed

### Compose state bridge
Observed:
- ComponentActivity
- Compose setContent
- MainUiState
- MainUiEvent
- picker preserved
- compression worker preserved
- Save/Share side effects preserved
- safe bounded PreviewLoader added

## Blocking fidelity / UX findings

### C1 — Home screen violates approved low-text concept

Approved direction:
- one identity
- one short hero
- one short trust line
- media-first hero
- one CTA

Current source adds:
- `Make your photo ready to upload.`
- a long explanatory paragraph;
- a framed generic placeholder card;
- `PHOTO UTILITY`;
- `Before → smaller, with proof`;
- `Your original stays untouched.`;
- another `Local processing • No account • No upload` row.

This recreates the text-density problem the user explicitly rejected.

Required:
- hero: `Fit your photo to an upload limit.`
- remove the long paragraph;
- replace generic icon placeholder with a refined owned Warm Ink media illustration/visual;
- one compact trust line only;
- keep Choose photo as the single primary action.

### C2 — Requirement screen is still copy-heavy and form-like

Current:
- `What limit does the form show?`
- explanatory paragraph
- CURRENT PHOTO card
- REQUIRED label
- 2-row chips
- selected summary card
- full-width primary button
- full-width secondary button

Required approved structure:
- concise `Choose limit`
- current photo/media surface
- preset grid
- optional compact Required ≤ value
- primary `Continue`
- low-emphasis `I don't know the limit`

The unknown-limit path must not look like a second primary CTA.

### C3 — Limit selected state lacks the required visible check indicator

Current Compose `LimitChip` changes surface and outline only.

Approved system requires:
- fill/tone;
- visible check indicator;
- semantics.

This is both visual-fidelity and non-color state evidence.

### C4 — Custom validation regressed from the accepted pre-Compose behavior

Current flow:
- Custom dialog sets `customOpen = false` before dispatching ApplyCustom.
- TargetLimitParser errors are converted into `MainUiState.Failure`.
- Error appears outside the dialog.

This violates:
- inline validation;
- invalid input keeps dialog open;
- last-valid target preserved while user corrects input.

Required:
- keep dialog open on invalid;
- show inline error in the dialog;
- continue calling `TargetLimitParser.parse()`;
- dismiss only after valid parse/apply.

### C5 — Processing is not media-first

Current `ProcessingScreen` contains spinner + text only.

Approved visual direction requires source photo/media context during processing when preview exists.

Required:
- render source preview as primary visual;
- overlay or pair with subtle indeterminate processing indicator;
- one short processing line;
- no fake percentage.

### C6 — Result screen recreates the rejected layout pattern

Current sequence:
- status pill
- large number
- redundant explanatory sentence
- side-by-side previews
- a separate outlined technical proof card
- technical metadata
- full-width Save
- full-width Share
- full-width/row Compress another

This is materially close to the prior rejected:
`status -> number -> text -> proof card -> metadata -> stacked actions`

Required:
- media-first result hero;
- integrate status + result size with actual result preview;
- compact verification strip only;
- remove redundant sentence when badge/proof already communicate state;
- compact metadata;
- one primary Save pill;
- Share + Compress another in a compact two-cell action dock;
- no three vertical result actions.

### C7 — Explicitly prohibited floppy-disk Save icon remains

`ic_save.xml` is a classic floppy-disk path.

This was a hard visual rejection criterion.

Required:
replace with contemporary download/save-to-device symbol.

### C8 — Legacy bright-cobalt icon assets remain

Several vector resources retain hard-coded `#3157F6`.

Compose Icon tint often overrides vector fill, but these stale resources remain a visual-risk surface and violate the Warm Ink asset system if used outside tinted Icon.

Required:
- replace or normalize active UI vectors for Warm Ink;
- no bright cobalt in rendered UI.

### C9 — PreviewLoader does not match engine EXIF handling

Existing JpegCompressionEngine handles:
- rotate 90/180/270;
- flip horizontal/vertical;
- transpose;
- transverse.

PreviewLoader handles only:
- rotate 90/180/270.

Therefore some EXIF-mirrored inputs can display a preview inconsistent with the actual engine output.

Required:
add the same flip/transpose/transverse transforms in PreviewLoader only.
Do not change the compression engine.

### C10 — Responsive behavior is not implemented as specified

The approved brief called for narrow-width treatment around <=340dp.

Current AppHeader always keeps:
- title;
- On-device trailing pill

in one Row.

Although title has maxLines=1, there is no width-specific layout policy.

Required:
- protect one-line product identity at 320dp;
- move/de-emphasize trust chip below the title on narrow width if necessary;
- capture actual 320x640 evidence.

### C11 — Warm Ink typography/system is only partially implemented

Current app manually assigns many individual font sizes/weights but does not create the approved tuned Material typography system.

This makes hierarchy inconsistent and increases the chance of visual drift.

Required:
- define Warm Ink typography tokens centrally;
- use them consistently;
- avoid blanket bold.

## Evidence / artifact closure blocker

The implementation commit contains no new TASK-S5-005:
- runtime screenshot set;
- artifact proof;
- binary artifact evidence;
- test matrix closure;
- updated PROJECT_STATE/HANDOFF closure.

No `s5_005`, `compose`, `warm`, or equivalent new evidence set is present under the repository evidence locations.

The user supplied only abbreviated artifact hashes in chat:
- debug `60d03d79…7da44`
- release APK `54e10825…3f43d4`
- AAB `4ff2d675…bec314`

Those are not sufficient for independent hash verification.

Therefore build/smoke claims remain:
`OPERATOR_ATTESTED_NOT_REPO_BOUND`

until complete evidence is committed.

## Artifact disposition

Pre-Compose AAB:
`de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

is now:
`PROVENANCE_ONLY`

because product source changed.

The new Compose AAB cannot yet be promoted as current candidate because its full hash/binary proof is not repository-bound.

## Gate

TASK-S5-005:
`REWORK_REQUIRED_BEFORE_HUMAN_VISUAL_REVIEW`

Canonical decision:
`TEST`

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
