# CURRENT_TASK.md

Task ID: TASK-S5-004
Owner: CODEX
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY
Priority: HIGH
Status: OPEN_UI_UX_REDESIGN_REQUIRED

## Goal

Modernize the Android UI/UX before any Google Play Internal Testing upload.

The current app is functionally correct but visually below the intended professional market bar. This task is not a cosmetic recolor. It is a controlled UI/UX redesign that must preserve every frozen buyer-truth and compression behavior.

## Current UI diagnosis

The current implementation still relies on:
- `android:style/Theme.Material.Light.NoActionBar`;
- `android:style/Widget.Material.Button`;
- stacked LinearLayout composition;
- native rectangular preset buttons;
- text-glyph branding such as `✓ Reduce Photo Size`;
- weak component hierarchy between header, cards, target controls, and result actions;
- a visually old platform-button treatment despite otherwise clear product semantics.

The existing layout is understandable, but it reads like a prototype/utility from an older Android design era rather than a polished 2026 consumer utility.

## Benchmark-derived binding direction

Read before implementation:
1. `docs/ux/S5_UI_UX_BENCHMARK_FORENSICS_v1.0.md`
2. `docs/ux/S5_UI_DESIGN_SYSTEM_BLUEPRINT_v1.0.md`

Binding archetype:
**PRECISION UTILITY / COBALT-NEUTRAL / MODERN EDITORIAL ANDROID**

Target:
**modern, premium, calm, high-trust utility**

Not:
- flashy;
- game-like;
- gradient-heavy;
- glassmorphism-heavy;
- excessive animation;
- decorative feature soup;
- clone of another brand.

Visual principles:
1. strong hierarchy;
2. generous but efficient spacing;
3. rounded modern surfaces;
4. clear primary/secondary/tertiary actions;
5. restrained blue accent;
6. privacy/trust cues as proper chips/badges, not text bullets;
7. status/result states that feel deliberate and professional;
8. modern target selectors, not old native buttons;
9. no visual element may weaken requirement truth.

## Required screen redesigns

### UX-01 — App shell / header
Replace text-glyph header `✓ Reduce Photo Size`.

Use:
- compact product header;
- neutral app/product mark or vector icon;
- product name;
- optional compact privacy/on-device chip.

Do not use a static checkmark that can be confused with result success state.

### UX-02 — First-open screen
Preserve:
- clear buyer job;
- one dominant action;
- local/private trust;
- original untouched/no account reassurance.

Modernize composition:
- concise hero;
- contained visual/photo utility surface;
- modern iconography;
- rounded primary CTA;
- tighter, intentional spacing;
- no empty prototype-like dead space.

Primary CTA:
`Choose photo`

### UX-03 — Selected-photo / requirement screen
Redesign CURRENT PHOTO as a modern information card.

Must show:
- file size as dominant datum;
- dimensions;
- format;
- on-device status.

Redesign preset selector:
- 50 KB / 100 KB / 200 KB / 500 KB / 1 MB / Custom;
- modern chip/segmented/pill treatment;
- selected state must be obvious through more than color alone;
- no default selected target;
- 48dp minimum touch target.

Requirement title:
`What's the upload limit?`

Neutral state:
`Choose the upload limit`

Known CTA remains disabled until valid explicit selection.

Unknown-limit action stays visibly secondary.

### UX-04 — Custom limit
Modernize Custom input presentation without changing parser semantics.

Preserve:
- decimal SI;
- 1 KB..50 MB;
- dot/comma decimal support;
- max 3 fractional digits;
- last-valid-target invariant.

Prefer a clean modal/dialog or contained sheet-like presentation consistent with the visual system.
Do not add unrelated settings.

### UX-05 — Progress
Replace generic legacy-feeling progress composition with a calm contained processing state.

Show:
- clear local/on-device processing cue;
- non-blocking reassurance;
- no fake percentage unless real progress is measured.

### UX-06 — Result screen
Redesign the result as the strongest screen in the app.

Required hierarchy:
1. status badge/state;
2. final size;
3. exact truth proof;
4. before -> after comparison;
5. dimensions / preservation disclosure;
6. action hierarchy.

PASS / NOT_MET / REDUCED must be visually differentiated by:
- label;
- icon;
- typography;
- restrained semantic color;
not by color alone.

Do not remove exact-byte proof.

### UX-07 — Result actions
Change hierarchy to align with the buyer job:

Primary:
`Save copy`

Secondary:
`Share`

Tertiary:
`Compress another`

Reason: the core job is to create a concrete file that can be selected in an external upload form. Share remains important but is not the universal completion path.

This is an approved UI/UX action-hierarchy change, not a change to result semantics.

### UX-08 — Buttons and controls
Remove old `Widget.Material.Button` appearance.

Target:
- 12–16dp corner radius;
- 48–56dp touch height;
- restrained elevation or outline;
- clear disabled state;
- proper press/focus state;
- no all-caps;
- no excessive shadows.

Implementation may use Material Components if justified and verified, but:
- do not migrate the app to Compose;
- do not add a large framework migration only for styling;
- avoid unnecessary dependency surface.

### UX-09 — Cards / surfaces
Use a consistent surface system:
- app background;
- card/surface;
- outline;
- tonal selected surface;
- semantic success/warning surfaces.

Suggested radius:
- cards: 18–22dp;
- primary buttons: 14–16dp;
- chips/presets: 12–16dp.

### UX-10 — Typography
Keep system/Roboto-compatible fonts.

Suggested hierarchy:
- product/app header: 18–20sp semibold/bold;
- hero: 28–32sp bold;
- section: 20–22sp bold;
- dominant numeric result: 40–48sp bold;
- body: 15–16sp;
- labels: 12–14sp medium/bold.

Do not shrink critical text to fit.

### UX-11 — Iconography
Use vector icons where useful:
- photo/image;
- shield/privacy;
- upload/target;
- save/download;
- share;
- repeat/another;
- success/warning/info.

Do not use emoji or Unicode symbols as primary UI icons.

### UX-12 — Color system
Keep the high-trust blue/neutral identity but modernize application.

Required properties:
- accessible contrast;
- semantic success/warning/error;
- restrained saturation;
- no gradient requirement;
- no decorative neon.

### UX-13 — Small-screen composition
Reference viewport:
`320 x 640`

Also inspect:
- a typical modern phone viewport around 360 x 800;
- API29 and API36.

No critical CTA may be accidentally clipped.
Scrolling is acceptable when intentional.

### UX-14 — Accessibility
At minimum:
- 48dp interactive targets;
- content descriptions for non-text actionable icons;
- text/button state does not rely only on color;
- standard font-scale smoke;
- no obvious TalkBack-order regression.

Full accessibility certification remains S6 evidence.

## Frozen behavior — MUST NOT regress

Preserve all TASK-S5-003 truth:
- no implicit target;
- known path requires explicit target;
- decimal SI KB/MB;
- Custom parser contract;
- exact-byte verification;
- PASS / NOT_MET / REDUCED semantics;
- unknown path never claims PASS;
- source original untouched;
- Save/Share;
- EXIF/orientation safety;
- no INTERNET;
- no broad storage/media permissions;
- no AdMob/UMP/analytics;
- API29 + API36 support.

## Implementation discipline

Do NOT:
- rewrite compression engine;
- alter package/applicationId;
- alter versionCode/versionName unless separately required;
- add accounts/cloud/backend;
- add ads;
- add analytics;
- change signing;
- upload to Play;
- add batch/PDF/editor/background-removal features;
- convert project to Compose;
- hide truth proof for aesthetics.

## Required visual evidence

Capture fresh screenshots for:
1. first open;
2. requirement unselected;
3. preset selected;
4. Custom 10.5 KB;
5. PASS/ALREADY_READY;
6. NOT_MET;
7. REDUCED;
8. progress;
9. Save action/result;
10. Share sheet.

For core screens capture:
- API36;
- API29 where materially relevant.

## Required verification

Run:
- preflight;
- assembleDebug;
- unit tests;
- lint;
- assembleRelease;
- bundleRelease;
- API36 install/launch;
- API29 install/launch;
- PASS/NOT_MET/REDUCED regression;
- Custom 10.5 KB / 1.5 MB;
- no-selection guard;
- target reset;
- Save;
- Share;
- source preservation;
- EXIF/orientation;
- large input;
- permission/privacy inspection.

Generate fresh APK/AAB hashes.

## Artifact rule

Current AAB:
`064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc`

is HOLD for Play while TASK-S5-004 is active.

Once source/UI changes occur, that AAB becomes provenance-only and a fresh post-redesign AAB is required.

## Acceptance

- UI-01: no legacy text-glyph app header.
- UI-02: first-open looks like a current professional consumer utility.
- UI-03: target controls are modern, clear, and accessible.
- UI-04: no default target regression.
- UI-05: Custom flow visually coherent and truth-preserving.
- UI-06: result screen hierarchy is strong and modern.
- UI-07: Save copy is primary; Share secondary; Compress another tertiary.
- UI-08: old platform-button visual treatment removed.
- UI-09: status states remain semantically truthful.
- UI-10: 320x640 has no accidental critical clipping.
- UI-11: API29/API36 core screens render correctly.
- UI-12: build/unit/lint/release/bundle pass.
- UI-13: buyer-critical runtime regression passes.
- UI-14: no new permissions/network/AdMob/analytics.
- UI-15: fresh screenshot set and fresh APK/AAB hashes exist.
- UI-16: independent Chat visual + artifact-bound review passes before Play.

## Design-system requirement

Implementation must use the exact token/component/screen hierarchy in:
`docs/ux/S5_UI_DESIGN_SYSTEM_BLUEPRINT_v1.0.md`

Small stylistic adjustments are allowed only when they preserve the benchmark-derived archetype and improve real-device fit.

Do not substitute a generic Material template or a Dribbble-style decorative dashboard.

## Done when

The app no longer reads visually as a legacy Android prototype, while every frozen truth and privacy behavior remains intact.

Next owner after implementation:
CHAT independent visual/artifact audit.

Do not proceed to HUMAN_PLAY_CONSOLE until TASK-S5-004 passes.


## High-fidelity mockup review

Binding review:
`docs/ux/S5_HIGH_FIDELITY_MOCKUP_REVIEW_v1.0.md`

The visual direction is approved, but the literal mockup is REWORK before implementation.

Mandatory corrections:
- no EXIF-preserved claim;
- no guaranteed target-success copy;
- decimal-SI friendly/exact-byte values must agree;
- no precise promised output in first-open illustration;
- photo thumbnail optional, vector/photo icon default;
- no decorative back/overflow controls;
- no confetti;
- unknown-limit action remains visibly reachable.

Codex must implement the corrected design system, not copy the mockup literally.


## Mockup v2 and final implementation contract

Read:
- `docs/ux/S5_HIGH_FIDELITY_MOCKUP_V2_REVIEW_v1.0.md`
- `docs/ux/S5_UI_IMPLEMENTATION_CONTRACT_v1.0.md`

Mockup v2 is the visual quality target, but:
- fake numeric progress is forbidden;
- fake progress stages are forbidden;
- Requirement Helper is deferred from MVP;
- friendly file sizes must use decimal SI;
- PASS support copy must only claim the entered maximum size is met;
- NOT_MET must not add an unapproved new navigation flow.

The implementation contract is authoritative for coding.


## Independent Chat audit — corrective pass required

Audit:
`docs/ux/S5_004_INDEPENDENT_VISUAL_ARTIFACT_AUDIT_v1.0.md`

Status:
`REOPENED_CORRECTIVE_UI_AND_EVIDENCE`

Do not redesign the successful first-open/requirement foundation from scratch.

Required:
- modern Custom Limit modal with segmented KB/MB treatment;
- real target/limit icon, not plus;
- visible selected target indicator;
- complete runtime screenshots/evidence for all binding screens;
- one-to-one UI-01..UI-16 matrix reconciliation;
- fresh artifacts after corrective source changes;
- evidence hash/byte-count corrections.

Current S5-004 AAB `908755dddc0d030e22172d5ad9650037a513bffa8e86d701337dbff1ed646de6` is HOLD and becomes provenance-only after corrective source changes.
