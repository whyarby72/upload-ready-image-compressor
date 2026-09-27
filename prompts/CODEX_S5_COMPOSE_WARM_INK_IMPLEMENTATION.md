# CODEX TASK-S5-005 — COMPOSE WARM INK IMPLEMENTATION

Repository:
`whyarby72/upload-ready-image-compressor`

Checkout:
`task/TASK-S5-005`

Required starting HEAD:
Use the exact SHA supplied in the external handoff. It must equal the branch HEAD at execution.

Material approval:
`COMPOSE_WARM_INK_IMPLEMENTATION`

## Read first

1. `CURRENT_TASK.md`
2. `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
3. `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`
4. `docs/ux/S5_COMPOSE_TOOLCHAIN_BINDING_v1.0.md`
5. `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`
6. `PRODUCT_SPEC.md`
7. `docs/ux/S5_004_HUMAN_VISUAL_REJECTION_AUDIT_v1.0.md`

STOP if the caller-supplied starting HEAD does not match the checked-out branch HEAD exactly.

## Phase 0 — source and toolchain preflight

Record:
- git branch/head;
- JDK;
- Gradle;
- AGP;
- compileSdk/targetSdk/minSdk;
- installed SDKs;
- current package/version identity.

Verify the bound stable toolchain from official Android sources.

Bound expectation:
- AGP 9.4.1 retained;
- Gradle 9.7.1 retained;
- JDK 17;
- Kotlin 2.4.10;
- Compose compiler plugin 2.4.10;
- Compose BOM 2026.09.00;
- Material 3 stable via BOM;
- activity-compose 1.13.0;
- compileSdk 37;
- targetSdk 36 unchanged;
- minSdk 29 unchanged.

If an official-current incompatibility conflicts with the binding, STOP and report. Do not silently substitute alpha/beta versions.

## Phase 1 — toolchain enablement

Add Kotlin/Compose to existing Groovy Gradle project.

Root build:
- retain com.android.application 9.4.1;
- add org.jetbrains.kotlin.android 2.4.10 apply false;
- add org.jetbrains.kotlin.plugin.compose 2.4.10 apply false.

App module:
- apply Kotlin Android + Compose compiler plugins;
- enable buildFeatures.compose;
- compileSdk 37;
- keep targetSdk 36;
- keep minSdk 29;
- keep versionCode/versionName;
- add Compose BOM 2026.09.00;
- Material3, UI/foundation, tooling preview;
- activity-compose 1.13.0;
- debug UI tooling;
- Compose UI test dependencies only if actually used.

Run:
- assembleDebug
- unit tests
- lintDebug

Do not remove old UI yet.

## Phase 2 — state/event bridge

Implement exact brief:
- MainActivity.kt ComponentActivity;
- MainUiState;
- MainUiEvent;
- immutable UI state;
- Activity/controller owns picker/compression/save/share side effects;
- existing Java engine remains authoritative.

Do not introduce DI/navigation/database/backend.

Prove old functional behavior still works.

## Phase 3 — Warm Ink UI

Implement:
- edge-to-edge;
- WarmInkTheme;
- approved palette;
- approved typography;
- approved spacing/radius;
- current Material Symbols/vector language;
- no bright cobalt;
- no floppy Save icon;
- one-line product identity.

Screens:
- Home
- Requirement
- Custom
- Processing
- PASS
- NOT_MET
- REDUCED/ALREADY_SMALL

Copy density must follow the implementation brief exactly.

No fake progress.

## Phase 4 — preview pipeline

Implement bounded UI-only source/result previews.

Rules:
- no full-resolution decode on main thread;
- source preview failure must not block compression;
- result preview is the actual result file;
- no fabricated before/after quality;
- preserve orientation behavior.

Do not add Coil unless a concrete blocker is documented.

## Phase 5 — result/action behavior

PASS:
- Meets limit
- large friendly result size
- compact exact-byte verification
- real before/after visual
- Save primary
- Share + Compress another compact secondary actions

NOT_MET:
- Target not met
- exact > proof
- one-line guidance
- no fake retry workflow
- existing supported actions only

REDUCED:
- Smaller copy
- No limit was entered
- no success-green semantics

## Phase 6 — retire rejected View/XML presentation

Only after Compose parity is proven:
- remove obsolete activity_main UI dependency and obsolete UI-only drawables/styles as appropriate;
- retain any resource still used by manifest/provider/domain;
- do not delete evidence/provenance docs.

Verify compression/domain source diff remains untouched.

## Phase 7 — full regression

Run:
- preflight
- assembleDebug
- testDebugUnitTest
- lintDebug
- assembleRelease
- bundleRelease

Runtime:
- API36
- API29

Buyer-critical:
- no default target
- 50/100/200/500 KB and 1 MB
- Custom 10.5 KB
- Custom 1.5 MB
- invalid Custom
- known -> unknown stale-target defense
- target reset on new photo
- PASS
- NOT_MET
- REDUCED
- Save
- Share
- original preservation
- EXIF orientation
- large input
- offline/privacy
- permission inspection

## Phase 8 — visual evidence

Capture actual runtime screenshots:

1. Home 320x640
2. Home 360x800
3. Requirement unselected
4. Requirement 100 KB selected
5. Custom dialog
6. Processing actual indeterminate
7. PASS
8. NOT_MET
9. REDUCED
10. Save success
11. Share sheet
12. API29 Requirement
13. 1.3x font Home
14. 1.3x font Result

Inspect every screenshot before naming it.
No splash/system picker frame may be mislabeled as app evidence.

## Phase 9 — artifact proof

Generate fresh:
- debug APK
- unsigned release APK
- unsigned release AAB

Record:
- bytes
- SHA-256
- source commit
- environment
- signing state

Mark pre-Compose AAB `de446e023...` provenance-only.

## Acceptance state

Do NOT mark TASK-S5-005 visual PASS.

Final Codex status:
`READY_FOR_HUMAN_VISUAL_REVIEW`

Next owner:
`CHAT + HUMAN`

## Stop boundaries

STOP for reviewer if:
- engine/domain source must change;
- package/version/targetSdk must change;
- stable toolchain cannot resolve;
- Compose requires alpha/beta dependency;
- screenshot quality diverges materially from approved Warm Ink anchor;
- a truth regression appears.

Never:
- sign;
- upload Play;
- integrate ads/analytics;
- claim S6/BUILD/Artifact Freeze/release/publication.
