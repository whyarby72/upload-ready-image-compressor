# CODEX — S5 PLAY SCREENSHOT PREMIUM COMPOSITION + TARGETED RECAPTURE v1.0

## Mission

Upgrade the current truthful emulator screenshot set into a premium Google Play creative set without altering app UI truth.

Product:
`PHOTO COMPRESSOR: KB LIMIT`

Branch:
`task/TASK-S5-007`

Human authorization:
`USER_OPTION_1_2026-10-02_S5_PLAY_SCREENSHOT_PREMIUM_COMPOSITION_TARGETED_RECAPTURE`

Current authoritative branch HEAD at authorization:
`b1586231d0432d0051f6bedf2f7eda0579ddb87a`

Existing accepted capture commit:
`5e575b22f50c8309aefd71ff84db6dfb881ae122`

Existing independent audit:
`docs/qa/S5_REAL_PLAY_SCREENSHOT_CAPTURE_CHAT_INDEPENDENT_AUDIT_v1.0.md`

Current capture verdict:
`CAPTURE_EVIDENCE_PASS / STORE_VISUAL_HOLD`

Strategic thesis:
`QUIET PROOF > LOUD PROMISE`

## Goal

Produce six final 1080x1920 Play screenshot creatives that:
- use only genuine app screenshots;
- look materially more premium than raw screenshot dumps;
- retain current Warm Ink brand;
- present one buyer message per image;
- preserve exact-byte truth;
- avoid generic blue-toolbox / mascot / giant-percentage competitor tropes;
- do not modify product source.

## Non-negotiable truth constraints

MUST:
- use real Android API36 app screenshots;
- preserve original app pixels inside the embedded screenshot area;
- generate PASS / NOT_MET only from the real compression engine;
- record any recapture with foreground + UIAutomator + capture.json + SHA-256;
- preserve current product semantics;
- keep current screenshot source provenance.

MUST NOT:
- redraw app UI;
- use generative AI to create/recreate screens;
- retouch text, numbers, icons, status labels, buttons, photos, or controls inside app screenshot pixels;
- replace a real runtime screen with a mock;
- fabricate selected states;
- alter app source;
- add debug-only product UI;
- perform any Play Console mutation;
- sign/upload AAB;
- mutate testers/releases/rollout;
- enter S6;
- BUILD promote;
- Artifact Freeze;
- release/publish.

If any required truth condition cannot be met:
`STOP / HOLD`

## Stage 0 — sync and source safety

Run:

```bash
git fetch origin
git switch task/TASK-S5-007
git pull --ff-only origin task/TASK-S5-007
git rev-parse HEAD
git status --short
git diff -- app/
```

Expected synchronized HEAD at or after:
`b1586231d0432d0051f6bedf2f7eda0579ddb87a`

If branch diverged or unexpected `app/` changes exist:
`STOP = HOLD_SOURCE_OR_BRANCH_DRIFT`

Do not reset/rebase/discard user work.

Existing untracked files from the prior local session may include:
- `docs/qa/S5_REAL_PLAY_SCREENSHOT_CAPTURE_REVIEW_v1.0.md`
- `tools/`

Do not stage/delete/overwrite them unless they are explicitly required and reviewed for this task.

## Stage 1 — environment validation

Reuse the previously proven environment when available:

- AVD: `task-s3-api36`
- serial: `emulator-5554`
- API: 36
- capture size: 1080x1920
- density: 480
- font scale: 1.0
- package: `com.afradadmedia.reducephotosize`

Verify:

```bash
adb devices -l
adb -s emulator-5554 shell getprop ro.build.version.sdk
adb -s emulator-5554 shell wm size
adb -s emulator-5554 shell wm density
adb -s emulator-5554 shell settings get system font_scale
```

If emulator is unavailable:
`STOP = BLOCKED_EMULATOR_ENVIRONMENT_NOT_AVAILABLE`

## Stage 2 — build integrity

Run:

```bash
./gradlew test lintDebug assembleDebug
shasum -a 256 app/build/outputs/apk/debug/app-debug.apk
```

Expected debug APK SHA-256 unless source has legitimately changed only through previously approved app commits:
`843c6321febc8b1756c7ed3ba0f0d547fa74bad69bc7a9fef121f44a138e64ce`

If APK hash changes unexpectedly:
`STOP = HOLD_APK_DRIFT`

Install/reinstall if needed:

```bash
adb -s emulator-5554 install -r app/build/outputs/apk/debug/app-debug.apk
```

## Stage 3 — capture hygiene

Objective:
remove avoidable emulator/system clutter without altering app content.

Allowed:
- collapse notification shade;
- close system dialogs;
- hide keyboard unless required;
- disable show-touches / pointer-location if enabled;
- disable animations for stable capture;
- clear nonessential emulator notifications if safely possible;
- use clean status-bar/system state.

Examples:

```bash
adb -s emulator-5554 shell am broadcast -a android.intent.action.CLOSE_SYSTEM_DIALOGS || true
adb -s emulator-5554 shell settings put system show_touches 0 || true
adb -s emulator-5554 shell settings put system pointer_location 0 || true
adb -s emulator-5554 shell settings put global window_animation_scale 0
adb -s emulator-5554 shell settings put global transition_animation_scale 0
adb -s emulator-5554 shell settings put global animator_duration_scale 0
```

Do NOT mutate time, system branding, or status icons merely to create a fake screenshot.

If residual system-status clutter cannot be safely removed:
- retain truthful raw capture;
- crop only system chrome in the final composition;
- never crop app UI content.

## Stage 4 — mandatory targeted recapture

Create a new evidence namespace:

`evidence/store/play_screenshots_v2/`

Preserve v1 unchanged.

### 02 — SET KB LIMIT — MUST RECAPTURE

Required state:
- real selected fixture;
- `Choose limit`;
- `CURRENT PHOTO`;
- `200 KB` selected;
- Continue button enabled/active;
- all relevant presets visible.

Use the same project-owned fixture:
`app/src/androidTest/assets/fixtures/ratio_16x9.jpg`

Same-session proof required:
- screenshot_raw.png
- uiautomator.xml
- foreground.txt
- capture.json

Required semantic assertions:
- Choose limit
- CURRENT PHOTO
- 200 KB
- Continue
- UIAutomator node for Continue reports enabled=true if exposed
- foreground package is app package

Do not fake selection.

### 04 — CUSTOM LIMIT — MUST RECAPTURE

Required state:
- Custom limit dialog;
- value `750`;
- KB selected;
- keyboard dismissed;
- decimal guidance visible;
- Use limit visible.

Required semantic assertions:
- Custom limit
- 750
- KB
- MB
- Use a dot or comma for decimals · up to 3 decimal places
- Use limit

Do not submit the value unless needed for stable truthful UI.

### 03 — SAVE / SHARE — OPTIONAL RECAPTURE

Current v1 state is acceptable truth evidence but visually partial because it is scrolled.

Attempt a better truthful state only if possible WITHOUT:
- changing app source;
- changing product semantics;
- stitching multiple screen states;
- hiding proof.

Ideal single frame:
- PASS context or exact proof visible;
- Save copy;
- Share;
- Compress another.

If not possible:
retain v1 raw state and rely on external headline in final composition.

### 01 / 05 / 06

Reuse v1 raw captures unless capture hygiene cleanup makes a materially cleaner truthful recapture easy and fully evidence-bound.

Do not recapture merely for cosmetic variation.

## Stage 5 — final creative architecture

Output namespace:

`store/assets/play/en-US/screenshots_v2/`

Create:

1. `01_verified_result_1080x1920.png`
2. `02_set_kb_limit_1080x1920.png`
3. `03_save_share_1080x1920.png`
4. `04_custom_limit_1080x1920.png`
5. `05_on_device_1080x1920.png`
6. `06_not_met_1080x1920.png`

### Composition system

Canvas:
- 1080 x 1920;
- RGB PNG;
- no alpha;
- 9:16.

Brand palette:
- canvas `#F6F0ED`
- surface `#FCF9F6`
- surface subtle `#EFE9E4`
- ink `#1E3335`
- ink deep `#142629`
- secondary `#5E6C72`
- success `#2F6C59`
- warning `#9D4447`
- info `#4B6668`

Visual style:
`MEDIA-FIRST PRECISION UTILITY — WARM INK`

### Premium visual direction

Do:
- quiet warm background;
- subtle geometric compression/limit motif;
- restrained depth/shadow;
- generous negative space;
- strong headline;
- actual app screenshot visually dominant;
- small brand mark / product identity only where useful;
- consistent six-image system;
- deterministic vector/Pillow/SVG styling.

Do NOT:
- use phone-device hardware mockups;
- use plant/desk/lifestyle stock backgrounds;
- use mascot;
- use giant percentage-saving claims;
- use fake file numbers outside app UI;
- use giant checkmarks;
- use generic bright-blue SaaS gradients;
- use feature-grid collage;
- add irrelevant marketing badges.

### Layout target

Headline region:
- top ~280–340 px;
- never >20% of image height;
- max two lines;
- high contrast;
- left aligned or consistently aligned across series.

App screenshot region:
- begins around y=330–390;
- ~820–900 px wide depending on crop;
- centered;
- placed on subtle elevated surface;
- actual app screenshot pixels dominate.

System chrome handling:
- cropping the Android status bar / gesture bar is allowed ONLY if no app UI pixels are removed;
- record crop rectangle;
- do not edit system chrome inside the retained crop;
- preferred final asset shows app UI content rather than emulator clutter.

### Frozen headlines

01:
`Verify the final size`

02:
`Set your KB limit`

03:
`Save or share the verified file`

04:
`Use a custom KB or MB limit`

05:
`Photo compression stays on-device`

06:
`No false PASS when the target is too small`

Optional one-line supporting copy may be used only if visual quality materially improves and copy remains concise/truthful.

Recommended support copy:

01:
`Exact bytes make the result clear.`

02:
`Choose a preset or enter your own limit.`

03:
`Use the verified copy wherever you need it.`

04:
`Set the maximum size your upload requires.`

05:
`Your selected photo is processed locally.`

06:
`If the target is not reached, the app says so.`

Do not add more than one supporting line.

## Stage 6 — original-pixel preservation

For every final composition create metadata recording:

- source raw screenshot path;
- source SHA-256;
- source crop rectangle;
- resize width/height;
- interpolation method;
- destination x/y;
- output SHA-256.

Store:
`store/assets/play/en-US/screenshots_v2/composition_manifest.json`

### Pixel-fidelity gate

Build final compositions deterministically.

For each image:
1. read raw screenshot;
2. crop only allowed system chrome;
3. resize exactly once using a documented algorithm;
4. paste screenshot into final canvas;
5. after final PNG is written, crop embedded screenshot region back out;
6. compare pixel-for-pixel against the independently generated resized source crop.

Required:
`PIXEL_FIDELITY = PASS`

Zero UI overlays are allowed on top of the embedded screenshot.

No blur/tint/color-grade may touch app screenshot pixels.

## Stage 7 — screenshot-specific quality requirements

### 01 — verified result
Must make result proof the focal story.
The embedded UI must visibly communicate genuine PASS.
No external fake numeric claim.

### 02 — set KB limit
Must use newly recaptured selected `200 KB` state.
Continue must look active.
This is the strongest "buyer control" screen.

### 03 — save/share
Must clearly show completion action.
If v1 scrolled screenshot is retained, external headline supplies context.
Do not synthesize missing MEETS LIMIT label.

### 04 — custom limit
Must use newly recaptured `750 KB` populated dialog.
No blank Amount field.

### 05 — on-device
Preserve the current Home visual story.
This should remain calm and trust-led.
No whole-app offline claim.

### 06 — NOT_MET
Keep tone calm and factual.
Do not make the warning visually dominant beyond the app's own state.
The listing story is honesty, not failure drama.

## Stage 8 — semantic + visual QA

Create:
`docs/qa/S5_PLAY_SCREENSHOT_PREMIUM_COMPOSITION_REVIEW_v1.0.md`

Create:
`evidence/store/S5_PLAY_SCREENSHOT_PREMIUM_COMPOSITION_PROOF_v1.0.json`

Create:
`store/assets/play/en-US/screenshots_v2/alt_text.json`

QA must include:

### Artifact QA
- six files exist;
- exactly 1080x1920;
- RGB/no alpha;
- valid PNG;
- SHA-256 recorded;
- source raw screenshot recorded;
- pixel-fidelity PASS;
- no unsupported UI edit.

### Semantic QA
- headline matches actual screen;
- no claim conflict;
- no fake exact equality;
- no guaranteed success;
- on-device copy scoped to photo compression;
- NOT_MET remains truthful;
- screenshot order tells coherent story.

### Visual QA
Evaluate each 1–5, descriptively only:
- hierarchy;
- scanability;
- screenshot dominance;
- brand coherence;
- premium feel;
- competitor differentiation;
- clutter;
- text density.

Do not self-approve human visual quality.

## Stage 9 — comparison contact sheet

Create:
`store/assets/play/en-US/screenshots_v2/CONTACT_SHEET_6UP.png`

Purpose:
human review only.

Layout:
- six final creatives at equal scale;
- order 01 → 06;
- labels only outside final assets;
- do not use contact sheet as Play upload asset.

## Stage 10 — git safety and commit

Before staging:

```bash
git status --short
git diff -- app/
```

If any unexpected `app/` modification exists:
`STOP = HOLD_UNEXPECTED_APP_SOURCE_CHANGE`

Stage ONLY:
- new v2 capture evidence;
- new v2 screenshot assets;
- new proof/QA docs directly created by this task.

Do not stage unrelated untracked files.

Show:

```bash
git diff --cached --name-status
git diff --cached --stat
```

Commit message:

`store: produce premium truthful Play screenshot set v2`

Push:
`origin/task/TASK-S5-007`

## Terminal success state

`PLAY_SCREENSHOT_V2_PREMIUM_COMPOSITION_READY_HUMAN_REVIEW_REQUIRED`

Possible holds:
- `HOLD_SOURCE_OR_BRANCH_DRIFT`
- `BLOCKED_EMULATOR_ENVIRONMENT_NOT_AVAILABLE`
- `HOLD_APK_DRIFT`
- `PARTIAL_TARGETED_RECAPTURE_BLOCKED`
- `HOLD_PIXEL_FIDELITY_FAILURE`
- `HOLD_VISUAL_QA_FAILURE`

## Final return payload

Return:

1. terminal status;
2. source HEAD before task;
3. new commit HEAD;
4. APK SHA-256;
5. emulator profile;
6. which states were recaptured;
7. six raw source screenshot paths + SHA-256;
8. six final v2 screenshot paths + SHA-256;
9. composition manifest path;
10. proof JSON path;
11. QA review path;
12. contact sheet path;
13. pixel-fidelity result for all six;
14. deviations/blockers;
15. `git status --short`.

Human visual approval remains:
`PENDING`

## Authority boundary

Even on full success, DO NOT:
- create/submit Play app;
- register package;
- ownership/key proof;
- create/import/rotate signing keys;
- sign release;
- upload AAB;
- mutate testers;
- create release;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.
