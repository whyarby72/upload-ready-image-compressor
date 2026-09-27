# S5 COMPOSE IMPLEMENTATION BRIEF v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Visual anchor: human-approved Warm Ink five-screen mockup
Visual system: `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
Status: IMPLEMENTATION-SPEC READY / CODING NOT YET AUTHORIZED

---

## 1. Objective

Replace the rejected market-facing View/XML presentation with a Compose Material 3 presentation layer that faithfully implements the approved `MEDIA-FIRST PRECISION UTILITY — WARM INK` visual concept.

This is a UI-layer migration, not a product/domain rewrite.

The implementation must preserve the already-verified Java/domain engine and all product-truth behavior.

---

## 2. Frozen domain behavior

MUST remain behaviorally equivalent:

- package/applicationId: `com.afradadmedia.reducephotosize`
- minSdk 29
- targetSdk 36
- versionCode/versionName unchanged unless separately authorized
- JPEG/JPG input scope
- image inspection
- explicit known-limit selection
- decimal-SI presets:
  - 50 KB = 50,000 bytes
  - 100 KB = 100,000 bytes
  - 200 KB = 200,000 bytes
  - 500 KB = 500,000 bytes
  - 1 MB = 1,000,000 bytes
- Custom:
  - 1 KB..50 MB
  - dot OR comma decimal separator
  - max 3 fraction digits
  - exact decimal conversion
- no default target
- known path only after explicit valid target
- unknown path never claims PASS
- PASS iff outputBytes <= targetBytes
- NOT_MET iff outputBytes > targetBytes after quality guard
- REDUCED/ALREADY_SMALL truth
- source/original untouched
- Save
- Share
- EXIF orientation correctness
- metadata behavior of compressed copy
- no INTERNET permission
- no broad storage/media permission
- no AdMob/UMP/analytics
- API29/API36 behavior

Do NOT rewrite:
- `JpegCompressionEngine.java`
- `TargetLimitParser.java`
- `ImageInspector.java`
- `MediaStoreSaver.java`
- `ResultContentProvider.java`
unless an independently proven functional defect requires it.

---

## 3. Current technical baseline

Current application module:
- AGP 9.4.1
- Gradle 9.7.1
- Java 17
- compileSdk 36
- minSdk 29
- targetSdk 36
- no current AndroidX UI dependency

Current MainActivity:
- Java Activity
- XML/View state panels
- single-thread ExecutorService
- platform/system photo picker logic
- direct bridge to existing Java engine

The Compose pass should preserve the same high-level execution model unless there is a specific reason to change it.

---

## 4. Preferred migration architecture

### 4.1 Activity

Replace:
`MainActivity.java extends Activity`

with:
`MainActivity.kt extends ComponentActivity`

Responsibilities retained in Activity:
- register/launch photo picker
- persist API29 URI grant behavior
- own ExecutorService
- call `ImageInspector`
- call `JpegCompressionEngine`
- call `MediaStoreSaver`
- create Android Share intent
- own result File reference
- update immutable Compose UI state

Do not move compression logic into Composables.

### 4.2 UI state

Create:
`MainUiState.kt`

Recommended sealed model:

```kotlin
sealed interface MainUiState {
    data object Home : MainUiState

    data class Inspecting(
        val message: String = "Reading photo…"
    ) : MainUiState

    data class Requirement(
        val image: ImageInfo,
        val selectedTargetBytes: Long? = null,
        val selectedTargetIndex: Int? = null,
        val sourcePreview: ImageBitmap? = null
    ) : MainUiState

    data class Processing(
        val image: ImageInfo,
        val mode: ProcessingMode,
        val sourcePreview: ImageBitmap? = null
    ) : MainUiState

    data class Result(
        val source: ImageInfo,
        val result: CompressionResult,
        val sourcePreview: ImageBitmap?,
        val resultPreview: ImageBitmap?
    ) : MainUiState

    data class Failure(
        val message: String,
        val recoverTo: MainUiState
    ) : MainUiState
}
```

ProcessingMode:
- KNOWN_COMPRESS
- KNOWN_VERIFY
- UNKNOWN_REDUCE

No percentage field.

### 4.3 Event contract

Create:
`MainUiEvent.kt`

Events:
- ChoosePhoto
- SelectPreset(bytes,index)
- OpenCustom
- ApplyCustom(raw, unit)
- DismissCustom
- ContinueKnown
- ContinueUnknown
- Save
- Share
- CompressAnother
- DismissError

Composables emit events only.
Activity/controller performs side effects.

### 4.4 State ownership

For this migration pass, keep state ownership simple:

- Activity owns a single `mutableStateOf<MainUiState>`
- Compose receives immutable state
- Compose sends callbacks/events back to Activity

Do NOT introduce:
- repository layer
- DI framework
- navigation framework
- database
- backend
- ViewModel architecture rewrite

unless independently necessary.

Lifecycle/process-death hardening remains a later QA concern; do not expand scope now.

---

## 5. Compose dependency plan

At implementation start, verify current official Android compatibility for:
- Kotlin Android plugin compatible with AGP 9.4.1
- Compose BOM
- Compose Material 3
- activity-compose
- compose UI/foundation/tooling

Use official Android/Jetpack repositories only.

Expected dependency categories:

- Kotlin Android plugin
- Compose BOM
- `androidx.activity:activity-compose`
- `androidx.compose.ui:ui`
- `androidx.compose.foundation:foundation`
- `androidx.compose.material3:material3`
- `androidx.compose.ui:ui-tooling-preview`
- debug-only `androidx.compose.ui:ui-tooling`

Do not add:
- Coil by default
- Accompanist by default
- animation libraries
- icon packs solely for cosmetics
- navigation-compose for this single-flow MVP

Use vector resources / locally owned assets for icons.

Mutable dependency versions must be verified from current official Android documentation at implementation time rather than copied from stale examples.

---

## 6. Package/file structure

Recommended new files:

```
app/src/main/java/com/afradadmedia/reducephotosize/
  MainActivity.kt
  MainUiState.kt
  MainUiEvent.kt
  PreviewLoader.kt

app/src/main/java/com/afradadmedia/reducephotosize/ui/
  ReducePhotoSizeApp.kt
  WarmInkTheme.kt
  WarmInkTokens.kt
  components/
    AppIdentity.kt
    PhotoHero.kt
    LimitTile.kt
    RequirementSummary.kt
    StatusHero.kt
    BeforeAfterPreview.kt
    VerificationStrip.kt
    ResultActionDock.kt
    CustomLimitDialog.kt
  screens/
    HomeScreen.kt
    RequirementScreen.kt
    ProcessingScreen.kt
    ResultScreen.kt
```

Existing verified Java domain files remain in the same package.

Delete old XML/View presentation resources only after Compose parity is proven.
Do not remove provenance evidence.

---

## 7. Theme implementation

Create:
`WarmInkTheme.kt`

### Light scheme

Primary:
`#1E3335`

OnPrimary:
`#FFFDFC`

PrimaryContainer:
`#E5ECE9`

OnPrimaryContainer:
`#142629`

Background:
`#F6F0ED`

OnBackground:
`#142126`

Surface:
`#FCF9F6`

OnSurface:
`#142126`

SurfaceVariant:
`#EFE9E4`

Outline:
`#DED7D1`

Success and warning should remain custom semantic tokens rather than forcing them into Material error roles.

No dark theme is required in this task unless separately approved.

---

## 8. Edge-to-edge and system bars

Use:
- `enableEdgeToEdge()`
- transparent system bars
- dark system-bar icons on Warm Ink light canvas
- safe inset handling through Compose Scaffold/window insets

No content may render under the status/navigation bars unintentionally.

---

## 9. Responsive rules

Reference widths:
- 320dp narrow
- 360dp standard
- larger phone widths

### Narrow <= 340dp

- horizontal gutter: 20dp
- product title must remain one line
- hide/move `On-device` chip if needed to protect title width
- hero headline: ~30sp
- primary CTA: 56dp
- result content may scroll
- bottom actions remain reachable

### > 340dp

- gutter: 24dp
- hero headline: ~32sp
- richer media surface allowed
- title + privacy cue may coexist if one-line identity remains

Use `BoxWithConstraints` or equivalent simple width branching.
Do not create tablet-specific product behavior in this task.

---

## 10. Screen A — First Open

### Purpose
Answer only:
“What does this do, and what do I tap?”

### Layout

`Scaffold`

Top:
- one-line AppIdentity
- no back
- no overflow

Content:
- headline
- media hero
- minimal trust

Bottom:
- primary Choose photo action

### Exact copy

Product:
`Reduce Photo Size`

Hero:
`Fit your photo to an upload limit.`

Primary:
`Choose photo`

Trust:
`On-device · Original untouched`

No feature-list copy.
No supported-format marketing copy.
No promised output number.

### Media hero

Use a first-party owned/generated static landscape/photo-style asset or abstract image composition.

Requirements:
- licensing/provenance documented
- no third-party stock asset without license evidence
- no exact MB -> KB output promise
- subtle before/smaller visual is acceptable

### Layout targets

Header:
56dp content zone

Hero title:
30–34sp

Hero media:
- width fill
- aspect ~0.9–1.1 depending screen fit
- radius 24–28dp
- no large shadow

Primary CTA:
56–60dp
deep ink pill

Trust:
12–13sp
quiet

---

## 11. Screen B — Requirement

### Purpose
Answer:
“What maximum size should I use?”

### Top
- back action
- one-line product identity
- no decorative overflow

### Selected photo surface

Preferred:
actual safe source thumbnail.

If thumbnail load fails:
refined placeholder.

Show only:
- photo
- current friendly size
- optional compact dimensions

Do not show large technical text blocks.

### Title

`Choose limit`

No paragraph required by default.

### Preset grid

Two rows, three equal-width tiles:

50 KB | 100 KB | 200 KB
500 KB | 1 MB | Custom

Tile:
- min 64–72dp visual height
- 48dp minimum interaction
- 16–18dp radius
- warm surface unselected
- deep ink selected
- check indicator selected
- text remains readable at 1.3x font

### Selected summary

When selected:
`Required ≤ 100 KB`

When none:
No strong summary surface required; CTA disabled.

### Bottom actions

Primary:
`Continue`

Tertiary:
`I don't know the limit`

Do not use:
- per-preset marketing descriptions
- social-media/job-portal claims

---

## 12. Screen C — Custom Limit dialog

### Visual

Custom M3-quality Dialog / Surface.
Radius 28dp.

Title:
`Custom limit`

Numeric input.

Segment:
KB | MB

Helper:
`1 KB–50 MB · up to 3 decimals`

If needed:
`Use . or , for decimals`

Inline validation.
No Toast-only validation.

Actions:
`Cancel`
`Use limit`

### Truth

Parser must continue delegating to:
`TargetLimitParser.parse()`

Do not reimplement decimal conversion in Compose.

---

## 13. Screen D — Processing

### Purpose
Show that work is happening without false precision.

### Layout

Top:
one-line identity

Center:
- actual source preview if available
- subtle media treatment
- indeterminate progress indicator

Copy:
`Compressing…`

Optional micro trust:
`On-device`

For already-small known image:
copy may be:
`Verifying…`

For unknown:
`Making a smaller copy…`

### Prohibited

- numeric percentage
- fake phases
- estimated time
- fake progress bar
- “72%”
- fabricated quality analysis

---

## 14. PreviewLoader

New UI helper only.

### Source thumbnail

minSdk 29 permits:
`ContentResolver.loadThumbnail(uri, Size(...), null)`

Run off main thread.

Recommended target:
max ~1080px edge for UI preview, with smaller target at narrow width.

If decode/load fails:
return null and show placeholder.
Do not block compression.

### Result thumbnail

Load from result File off main thread.

Use bounded decoding / sampling.
Do not decode arbitrarily huge full-resolution bitmap into UI memory.

Target:
max ~1080px UI edge.

Output orientation should already reflect engine behavior; do not add a second transform unless evidence proves necessary.

### Preview truth

Preview is illustrative of the actual source/result files.
Never fabricate visual quality degradation or enhancement.

---

## 15. Screen E — Result: PASS / ALREADY_READY

### Structure

`Scaffold(bottomBar = ResultActionDock)`

Scrollable content if needed.

Top:
- back only if it maps to a real supported state transition; otherwise omit
- one-line identity

Hero:
quiet success surface.

Copy:
`Meets limit`

Result size:
friendly decimal-SI, e.g.
`980 KB`

Proof:
`Verified · 980,053 ≤ 1,000,000 bytes`

No redundant success paragraph.

### BeforeAfterPreview

Use actual source + result previews.

Preferred first implementation:
static 50/50 split.

Not required:
drag gesture.

Elements:
- Before tag
- After tag
- source size
- output size
- subtle center divider

Do not fake a visual difference if none is perceptible.

### Metadata

One compact row:
`JPEG · 2400 × 1600`

Optional quiet:
`Original untouched`

Do not foreground:
`JPEG quality 48`

### Action dock

Primary:
`Save copy`
with contemporary download/save-to-device icon.

Secondary two-cell dock:
`Share`
`Compress another`

No floppy disk icon.

---

## 16. Screen F — Result: NOT_MET

Hero:
quiet warm warning/rose surface.

Copy:
`Target not met`

Actual result size.

Proof:
`81,208 > 50,000 bytes`

Guidance:
`Try a higher limit or a different photo.`

Before/after:
actual previews and sizes.

If result file exists:

Primary:
`Save current copy`

Secondary:
`Share`
`Compress another`

Do NOT add:
- fake `Try again` behavior
- `Go back` unless a tested state transition is intentionally implemented
- automatic quality-lowering control

Existing compression truth remains authoritative.

---

## 17. Screen G — Result: REDUCED / ALREADY_SMALL

Hero:
neutral ink/info surface.

Copy:
`Smaller copy`

Result size.

Truth:
`No limit was entered.`

Do not show green success.

Before/after:
actual previews.

Actions:
`Save copy`
`Share`
`Compress another`

---

## 18. ERROR handling

Do not create a dedicated decorative error screen unless needed.

Use:
- inline error surface
- recover to Home or Requirement depending whether image exists

Preserve current recovery semantics.

Error copy should be concise.

---

## 19. Result presentation mapping

Create pure presentation mapping:

`ResultPresentation.kt`

Input:
`CompressionResult`

Output:
- semantic state
- label
- hero tone
- proof text
- guidance text
- primary action label

Mapping:

PASS / ALREADY_READY:
- state SUCCESS
- `Meets limit`
- proof <=

NOT_MET:
- state WARNING
- `Target not met`
- proof >

REDUCED / ALREADY_SMALL:
- state INFO
- `Smaller copy`
- `No limit was entered.`

ERROR:
- not rendered as normal result

Add unit tests for this mapping.

Do not derive truth from UI copy.

---

## 20. Friendly size formatting

Continue exact-byte truth from domain.

UI-friendly sizes must remain decimal SI.

Result proof:
exact bytes.

Before/after tags:
friendly decimal SI.

No 1024-based KB/MB.

---

## 21. Save UX

Existing MediaStore behavior remains authoritative.

On Save success:
replace legacy Toast-only completion where practical with a Compose Snackbar:

`Saved to Pictures`

Do not claim a location not actually used by `MediaStoreSaver`.

Save remains primary.

Disable/debounce while active.

---

## 22. Share UX

Keep Android Sharesheet.

MIME:
`image/jpeg`

URI:
existing scoped `ResultContentProvider.RESULT_URI`

Do not build a custom share sheet.

---

## 23. System picker

Preserve current behavior:

API >=33:
`MediaStore.ACTION_PICK_IMAGES`
JPEG only.

API <33:
`ACTION_OPEN_DOCUMENT`
JPEG only.
Persist read permission where currently supported.

Compose UI should not broaden file-type scope.

---

## 24. Animation

Initial pass only:

- 150–250ms content fade
- subtle state crossfade
- M3 press/ripple
- indeterminate progress
- optional image crossfade after preview load

No:
- confetti
- bounce
- parallax
- decorative looping animation

Static quality wins over motion.

---

## 25. Accessibility

Required before visual PASS:

- 48dp minimum touch targets
- content descriptions for icon-only controls
- no color-only result state
- selected target: fill + check + semantics
- TalkBack order follows visual order
- 1.3x font smoke at 320x640
- 360x800 smoke
- API29 and API36
- no critical control clipped by bottom action dock
- meaningful state announcements when Processing -> Result transitions where practical

---

## 26. Performance and memory guard

No preview decode on main thread.

No full-resolution bitmap retained unnecessarily.

Release source preview when a new photo is chosen/reset.

Release result preview when reset or Activity destroyed.

Compression engine remains on existing worker.

UI preview failure must never fail compression.

---

## 27. Source-mutation boundary

Allowed in implementation pass after explicit authorization:

- replace MainActivity Java UI orchestration with Kotlin ComponentActivity
- add Kotlin/Compose UI files
- add Compose dependencies
- add owned visual assets/vectors
- remove obsolete XML/View presentation only after parity
- add UI/presentation tests

Not allowed without separate defect evidence:

- change compression algorithm
- change target parser
- change quality floor
- change output truth
- change package/version
- add formats
- add network
- add ads/analytics
- change signing
- Play upload

---

## 28. Migration order

### M1 — Toolchain enablement
Add Kotlin + Compose with verified compatible versions.
Build empty Compose host.
Do not remove old UI yet.

Gate:
debug build + unit + lint.

### M2 — State bridge
Create MainUiState/MainUiEvent.
Bridge existing engine/picker/save/share.
No visual migration claim yet.

Gate:
existing functional tests still pass.

### M3 — First Open + Requirement + Custom
Implement approved Warm Ink screens.

Gate:
API36/API29 screenshots + no-default-target + Custom tests.

### M4 — Processing + Result
Implement media-first processing/result screens.

Gate:
PASS/NOT_MET/REDUCED + exact proof + Save/Share.

### M5 — Preview
Add safe source/result thumbnail pipeline.

Gate:
large input / EXIF / memory smoke.

### M6 — Remove obsolete View presentation
Only after parity is proven.

Gate:
source diff confirms engine untouched.

### M7 — Full artifact refresh
Fresh debug APK, release APK, AAB.
Fresh hashes.

### M8 — Human visual review
No Play progression until user approves actual emulator/device screenshots.

---

## 29. Required screenshot gate

Fresh current-build screenshots:

1. First Open — 320x640
2. First Open — 360x800
3. Requirement — unselected
4. Requirement — 100 KB selected
5. Custom Limit
6. Processing actual indeterminate
7. PASS
8. NOT_MET
9. REDUCED
10. Save success
11. Share sheet
12. API29 Requirement
13. 1.3x font First Open
14. 1.3x font Result

Human visual approval must be based on actual runtime screenshots, not mockup alone.

---

## 30. Visual acceptance criteria

FAIL if actual implementation:
- resembles the rejected View/XML UI;
- returns to bright cobalt;
- uses a floppy Save icon;
- stacks three large full-width result buttons;
- uses text as the entire result focal point;
- has no actual source/result visual context;
- exposes JPEG quality as primary metadata;
- makes exact-byte proof headline-sized;
- wraps product title because of trust chip;
- adds more copy than the approved concept;
- uses fake percentage progress;
- uses stock/default Material styling without Warm Ink tuning.

PASS requires direct human approval of actual runtime screenshots.

---

## 31. Verification after implementation

Must rerun:
- preflight
- assembleDebug
- unit tests
- lint
- assembleRelease
- bundleRelease
- API36 install/launch
- API29 install/launch
- no default target
- decimal presets
- Custom 10.5 KB / 1.5 MB
- PASS
- NOT_MET
- REDUCED
- Save
- Share
- source preservation
- EXIF orientation
- large input
- offline/privacy/permissions
- fresh artifact bytes + SHA-256

Any UI migration defect repairs both product and earliest missed control.

---

## 32. Artifact disposition

Current pre-Compose AAB:
`de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

Disposition:
`PROVENANCE_ONLY_AFTER_COMPOSE_SOURCE_CHANGE`

Until source changes:
`HOLD_HUMAN_VISUAL_REJECTION`

No Play upload.

---

## 33. Authority

This document is a complete implementation brief.

Coding remains:
`NOT_AUTHORIZED`

Required next material decision:
explicit human authorization to implement the Compose Warm Ink presentation layer within this exact scope.
