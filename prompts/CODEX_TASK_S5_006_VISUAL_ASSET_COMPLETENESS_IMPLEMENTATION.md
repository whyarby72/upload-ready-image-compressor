# CODEX WORK ORDER — TASK-S5-006 VISUAL ASSET COMPLETENESS IMPLEMENTATION

Observed: 2026-09-28
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-006`
Approval ref: `USER_OPTION_1_2026-09-28_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION`
Authority: IMPLEMENTATION AUTHORIZED FOR THIS TASK ONLY

## 0. Read first

Mandatory source-of-truth:
1. `CURRENT_TASK.md`
2. `PROJECT_STATE.json`
3. `docs/qa/TASK_S5_006_VISUAL_PRODUCTIZATION_ESCAPE_AUDIT_v1.0.md`
4. `docs/ux/TASK_S5_006_VISUAL_ASSET_COMPLETENESS_CORRECTIVE_SPEC_v1.0.md`
5. `docs/engine/AI_PROD_ANDROID_NATIVE_VISUAL_PRODUCTIZATION_GATE_PATCH_v1.0.0.md`
6. `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
7. `docs/ux/S5_HIGH_FIDELITY_MOCKUP_V2_REVIEW_v1.0.md`
8. `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`

Do not infer broader authority.

## 1. Protected boundaries

Do NOT modify unless a deterministic build defect proves it is necessary and the change is purely mechanical:
- `JpegCompressionEngine.java`
- `TargetLimitParser.java`
- `ImageInspector.java`
- `MediaStoreSaver.java`
- `ResultContentProvider.java`

Do NOT change:
- applicationId/package;
- minSdk/targetSdk/compileSdk;
- versionCode/versionName;
- JPEG/JPG product scope;
- PASS / NOT_MET / REDUCED semantics;
- decimal-SI target semantics;
- Save/Share behavior;
- permissions/privacy model;
- no-INTERNET/no-AdMob/no-analytics posture.

Do NOT sign, upload, publish, mutate Play Console, advance S6, promote BUILD, freeze artifact, or release.

## 2. Goal

Close VAC-01..VAC-12 without broad redesign.

The result must look like a finished consumer utility, not a wireframe with polished colors.

Preserve:
`MEDIA-FIRST PRECISION UTILITY — WARM INK`

Add:
`BRANDED / PURPOSE-BUILT / VISUALLY EXPLANATORY`

## 3. Brand mark

Create a dedicated product mark distinct from `ic_photo`.

Concept:
`Compression Frame Mark`

Visual construction:
- simplified photo/frame outline;
- two subtle inward/limit cues or compacting corners;
- deep Warm Ink geometry;
- recognizable at 20–24dp and launcher scale;
- no letters;
- no embedded text;
- no fake numbers;
- no copied competitor expression.

Use it for:
- app header mark;
- launcher foreground basis.

Do not use `ic_photo` as the brand mark after this task.

## 4. Launcher icon

Implement explicit launcher icon resources and manifest binding.

Required:
- adaptive icon;
- fallback launcher resource;
- round icon when applicable;
- monochrome/themed foreground if current Android resource/toolchain supports it cleanly.

Use Warm Ink palette:
- warm ivory / surface background;
- deep ink/teal foreground;
- restrained low-saturation secondary shape only if it improves recognition.

Verify packaged resources resolve.

## 5. Home hero

Replace the current `WarmInkArtwork()` placeholder-like construction.

Required visual story:
`source photo → fit to upload limit → smaller result copy`

Use an owned local vector/Compose composition:
- source-photo frame;
- smaller destination-photo frame;
- subtle inward/limit bracket motif;
- one restrained direction/transition cue;
- tonal layering;
- no exact file-size numbers;
- no guarantee of PASS;
- no baked text in the illustration.

Do not add random stock photography or decorative AI-art filler.

Hierarchy at 360x800:
headline → hero illustration → Choose photo CTA.

At 320x640:
CTA must remain reachable without clipping; vertical scrolling may support smaller viewports but first-use composition must remain coherent.

At 1.3x font scale:
no overlap/cutoff.

## 6. Other screens

Requirement:
- keep REAL selected photo as primary visual;
- no decorative illustration;
- app shell may use new brand mark.

Custom Limit:
- no illustration required;
- keep target/limit visual grammar coherent.

Processing:
- keep REAL selected photo;
- indeterminate progress only;
- no fake percentage/stages;
- optional restrained tonal processing frame/halo only.

PASS:
- REAL result photo remains dominant;
- success icon/status supports the image;
- exact-byte proof stays truthful.

NOT_MET:
- REAL result photo remains dominant;
- calm warning semantics;
- keep exact guidance and `Save current copy`.

REDUCED:
- REAL result photo remains dominant;
- neutral/info semantics, not green success.

## 7. Asset provenance

Create:
`docs/ux/TASK_S5_006_VISUAL_ASSET_MANIFEST_v1.0.json`

For every new asset record:
- asset_id;
- resource_path;
- role;
- type;
- provenance = ORIGINAL_PROJECT_OWNED;
- generation_method = CODEX_VECTOR_OR_COMPOSE;
- license = PROJECT_OWNED;
- file SHA-256 after final generation.

No remote asset dependency.

## 8. Mockup-runtime matrix

Create:
`docs/ux/TASK_S5_006_MOCKUP_RUNTIME_FIDELITY_MATRIX_v1.0.md`

Rows:
- Home
- Requirement
- Custom Limit
- Processing
- PASS
- NOT_MET
- REDUCED

For each record:
- buyer job;
- required visual objects;
- actual visual objects;
- intentional deltas;
- missing objects;
- placeholder-like objects;
- composition status;
- visual signature;
- status.

Do not mark final human premium quality PASS yourself. Use `PENDING_HUMAN_REVIEW` after machine evidence is complete.

## 9. Build / deterministic QA

Run at minimum:
```bash
./gradlew clean assembleDebug
./gradlew test
```

Run existing instrumentation/regression suites that cover TASK-S5-005 and geometry where available.

If an existing test breaks because a selector/resource changed:
- repair the test only if product behavior remains unchanged;
- rerun affected + broader regression.

Do not weaken assertions to make tests pass.

## 10. Emulator evidence

Use API 36 emulator already available.

Capture actual runtime PNG evidence under:
`evidence/screenshots/s5_006_visual_productization/`

Required:
- launcher_api36.png
- home_api36_360x800.png
- home_api36_320x640.png
- home_font_1_3x_api36.png
- requirement_real_photo_api36.png
- custom_limit_api36.png
- processing_real_photo_api36.png
- result_pass_api36.png
- result_not_met_api36.png
- result_reduced_api36.png
- before_after_landscape_api36.png
- before_after_portrait_api36.png

If REDUCED cannot be reached deterministically with an existing fixture, create a test fixture only; do not change product semantics.

## 11. Visual deterministic checks

Verify:
- dedicated launcher identity exists;
- brand mark differs from generic `ic_photo`;
- Home hero is not the old `PHOTO → READY` block;
- no fake numbers/progress;
- no screen loses primary action due to asset height;
- 320x640 remains usable;
- 360x800 composition coherent;
- 1.3x font scale usable;
- real selected/result media remains primary after selection;
- Result/BeforeAfter still use Fit/full-frame behavior;
- no new network permission/dependency;
- no compression/domain diff.

## 12. Evidence / hashes

Record:
- exact source commit tested;
- debug APK path/bytes/SHA-256;
- any release AAB built for evidence only path/bytes/SHA-256, unsigned;
- screenshots + SHA-256;
- asset manifest hashes;
- environment: emulator model/API/resolution/font scale.

Update:
- `TEST_MATRIX.csv`
- `PROJECT_STATE.json`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`

## 13. Completion state

If all deterministic checks pass:
- task status = `IMPLEMENTED_MACHINE_QA_PASS_HUMAN_PREMIUM_REVIEW_PENDING`
- progress may advance to 98, not 99/100;
- next owner = `CHAT + HUMAN`;
- internal test gate remains HOLD until human premium-quality visual approval.

Do not resume Play handoff yourself.

If a material design judgment remains ambiguous:
- stop at `HOLD_HUMAN_VISUAL_DECISION`;
- provide exact screenshot/evidence references;
- do not invent a new visual direction.

If implementation requires domain behavior change:
- STOP and report blocker.

## 14. Final report

Report:
- exact commits;
- changed files;
- protected files unchanged = PASS/FAIL;
- build/test results;
- screenshot evidence paths;
- asset manifest path;
- mockup fidelity matrix path;
- unresolved visual exceptions;
- exact next human approval needed:
  `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION`.
