# CODEX — S5 REAL PLAY SCREENSHOT CAPTURE VIA ANDROID EMULATOR v1.0

## Mission

Produce a truthful, artifact-bound, environment-bound, replayable Google Play screenshot set for:

- Product: `PHOTO COMPRESSOR: KB LIMIT`
- Android package: `com.afradadmedia.reducephotosize`
- Launcher label: `Reduce Photo Size`
- Branch: `task/TASK-S5-007`

This task replaces synthetic/recreated app UI with screenshots captured from the real running Android app.

Strategic thesis:
`QUIET PROOF > LOUD PROMISE`

## Human authorization

Approval ref:
`USER_OPTION_1_2026-10-02_CODEX_S5_REAL_PLAY_SCREENSHOT_CAPTURE_VIA_ANDROID_EMULATOR_PROMPT`

Authorized execution scope when this prompt is deliberately handed to Codex:
`S5 REAL PLAY SCREENSHOT CAPTURE VIA ANDROID EMULATOR`

This prompt itself does NOT authorize Play Console mutations, signing, upload, testers, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.

## Source / truth baseline

Previously tested app source:
`27199bf6f174e55dc835d0d9898e456d3848001c`

Previously tested debug APK SHA-256:
`843c6321febc8b1756c7ed3ba0f0d547fa74bad69bc7a9fef121f44a138e64ce`

Current branch contains later docs/evidence/state commits. Before capture:

1. record `git rev-parse HEAD`;
2. verify:
   `git diff --name-only 27199bf6f174e55dc835d0d9898e456d3848001c..HEAD -- app/`
3. expected result: no protected/product-source drift except changes already explicitly bound to the tested source.

If unexpected `app/` drift is present:
`STOP = HOLD_SOURCE_DRIFT`

Do not silently capture a different product build.

## Hard constraints

MUST:
- use actual APK built from the verified repository source;
- use a real Android emulator accessible through `adb`;
- capture actual application pixels with `adb exec-out screencap -p`;
- bind every screenshot to foreground-package evidence and UIAutomator hierarchy from the same state;
- use genuine PASS / NOT_MET states produced by the real compression engine;
- preserve current UI, geometry, file-size semantics, exact-byte proof, Save/Share semantics;
- use only project-owned/test fixture images;
- preserve actual screenshot pixels in marketing composites.

MUST NOT:
- redraw/recreate the app UI;
- use generative AI to make app screens;
- fabricate PASS/NOT_MET;
- edit numbers/status labels inside captured UI;
- replace real photos inside an app screenshot;
- retouch app UI pixels;
- change production source merely to make screenshots easier;
- add debug-only UI to production code;
- upload anything to Play Console;
- create/sign/rotate/import keys;
- publish/release.

If a required screenshot cannot be produced truthfully:
mark it `BLOCKED`, record why, and continue only with independent states.

## Required environment preflight

Run and persist outputs:

```bash
git rev-parse HEAD
git status --short
java -version
./gradlew --version
command -v adb || true
adb version || true
adb devices -l || true
command -v emulator || true
emulator -list-avds || true
```

Verify:
- Android SDK is available;
- `adb` is functional;
- at least one emulator is booted or an existing local API 36 AVD can be started;
- API level is 36;
- device is writable/test-capable.

Do NOT download SDK images, create cloud resources, or install unrelated system tooling without a separate explicit approval.

If no usable emulator/API36 environment exists:
`STOP = BLOCKED_EMULATOR_ENVIRONMENT_NOT_AVAILABLE`

## Build gate

From the current verified branch:

```bash
./gradlew clean test lintDebug assembleDebug
```

Required:
- unit tests PASS;
- lintDebug PASS;
- assembleDebug PASS.

Record:
- debug APK path;
- bytes;
- SHA-256.

Install:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Confirm installed package:

```bash
adb shell pm path com.afradadmedia.reducephotosize
```

## Emulator presentation profile

Target raw capture:
`1080 x 1920 portrait / 9:16`

Recommended controlled profile:

```bash
adb shell wm size 1080x1920
adb shell wm density 480
adb shell settings put system font_scale 1.0
adb shell settings put global window_animation_scale 0
adb shell settings put global transition_animation_scale 0
adb shell settings put global animator_duration_scale 0
```

Then verify:

```bash
adb shell wm size
adb shell wm density
adb shell settings get system font_scale
adb shell getprop ro.build.version.sdk
```

Expected API:
`36`

The 1080x1920 raw screenshot must be verified after every capture.

Keep:
- portrait;
- en-US;
- no notification drawer;
- no keyboard unless the Custom Limit state specifically needs it;
- no unrelated dialogs.

## Deterministic fixture setup

Use project-owned JPEG fixtures only.

Preferred candidates already in repo:
- `app/src/androidTest/assets/fixtures/ratio_16x9.jpg`
- `app/src/androidTest/assets/fixtures/ratio_3x2.jpg`
- another existing project-owned deterministic JPEG if it gives cleaner genuine states.

Copy fixture to the emulator, for example:

```bash
adb shell mkdir -p "/sdcard/Pictures/PhotoCompressorStore"
adb push <fixture> "/sdcard/Pictures/PhotoCompressorStore/store_fixture.jpg"
adb shell am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d "file:///sdcard/Pictures/PhotoCompressorStore/store_fixture.jpg"
```

Record fixture:
- repo source path;
- source SHA-256;
- device destination.

Do not use external stock photography unless separately approved and provenance-recorded.

## State navigation rule

Prefer deterministic automation based on visible text/content descriptions and UIAutomator bounds rather than brittle hard-coded coordinates.

For each interaction:
1. dump hierarchy;
2. locate target by text/content-desc;
3. parse center of bounds;
4. tap via `adb shell input tap x y`;
5. wait for state anchor;
6. re-dump hierarchy.

A small task-local script under `tools/store_screenshot_capture/` may be created if needed.

Task-local automation scripts are allowed.
Product-source behavior changes are not.

## Same-session evidence binding

For every screenshot ID, persist FOUR minimum artifacts:

```
<id>/screenshot_raw.png
<id>/uiautomator.xml
<id>/foreground.txt
<id>/capture.json
```

Optional:
```
<id>/screenrecord_context.mp4
<id>/logcat_tail.txt
```

Immediately before screenshot:
- foreground proof;
- UI hierarchy dump.

Immediately after:
- screencap;
- hash all three;
- write capture.json.

Foreground proof must show:
`com.afradadmedia.reducephotosize/.MainActivity`

Use at least one:
```bash
adb shell dumpsys window windows
adb shell dumpsys activity activities
```

## Required screenshot states

### 01 — VERIFIED RESULT

Store message:
`Verify the final size`

Required genuine app state:
- result media visible;
- `MEETS LIMIT`;
- large rounded output size;
- exact-byte line;
- output bytes <= required bytes;
- explicit PASS semantics.

Preferred known target:
`1 MB`

PASS must be produced by the real engine.

UI hierarchy semantic assertions:
- `MEETS LIMIT`
- `Actual file:`
- `PASS`
- no `TARGET NOT MET`

Raw path:
`evidence/store/play_screenshots_v1/01_verified_result/`

### 02 — SET YOUR KB LIMIT

Store message:
`Set your KB limit`

Required state:
- real selected photo;
- `Choose limit`;
- `CURRENT PHOTO`;
- size + dimensions;
- `UPLOAD LIMIT`;
- 50 KB;
- 100 KB;
- 200 KB;
- 500 KB;
- 1 MB;
- Custom.

Prefer a visibly selected preset if it improves clarity, but do not alter product behavior.

Raw path:
`evidence/store/play_screenshots_v1/02_set_kb_limit/`

### 03 — SAVE OR SHARE VERIFIED FILE

Store message:
`Save or share the verified file`

Use a genuine PASS result.

Required visible semantic anchors:
- PASS / MEETS LIMIT context;
- Save;
- Share.

If Save/Share require scrolling, scroll the real app and capture the resulting real screen. Do not stitch different UI states into a fake app screenshot.

Raw path:
`evidence/store/play_screenshots_v1/03_save_share/`

### 04 — CUSTOM KB / MB LIMIT

Store message:
`Use a custom KB or MB limit`

Required state:
- real Custom Limit dialog;
- `Custom limit`;
- `Amount`;
- KB;
- MB;
- decimal guidance;
- `Use limit`.

Use a valid example such as:
`750 KB`

The entered value may be shown if that state is stable.

Raw path:
`evidence/store/play_screenshots_v1/04_custom_limit/`

### 05 — ON-DEVICE CORE PROCESSING / HOME

Store message:
`Photo compression stays on-device`

Preferred state:
current Home screen because it visibly contains:
- `Fit your photo to an upload limit.`;
- `Choose photo`;
- `On-device`;
- `original untouched`.

Alternative:
real Processing screen if the Home state is materially weaker after review.

Do not claim whole-app offline behavior.

Raw path:
`evidence/store/play_screenshots_v1/05_on_device/`

### 06 — HONEST NOT_MET

Store message:
`No false PASS when the target is too small`

Required genuine state:
- `TARGET NOT MET`;
- large actual output size;
- exact-byte proof;
- actual bytes > required bytes;
- `NOT_MET`;
- recovery guidance.

Prefer target:
`50 KB` if it genuinely produces NOT_MET using the chosen fixture.

If 50 KB genuinely passes, try a smaller valid limit such as 10 KB or 1 KB. Record the actual target. Never fabricate a 50 KB failure.

Raw path:
`evidence/store/play_screenshots_v1/06_not_met/`

## Capture function contract

Implement a reusable helper conceptually equivalent to:

```bash
capture_state <id>
  -> assert foreground package
  -> adb shell uiautomator dump
  -> adb pull hierarchy
  -> assert semantic anchors
  -> adb exec-out screencap -p > screenshot_raw.png
  -> verify PNG dimensions = 1080x1920
  -> sha256 screenshot/hierarchy/foreground
  -> write capture.json
```

Do not declare PASS from file existence alone.

## capture.json minimum schema

```json
{
  "schema_version": "1.0.0",
  "screenshot_id": "01_verified_result",
  "source_commit": "<git sha>",
  "app_source_baseline": "27199bf6f174e55dc835d0d9898e456d3848001c",
  "debug_apk_sha256": "<sha256>",
  "device_serial": "<serial>",
  "api": 36,
  "wm_size": "1080x1920",
  "wm_density": 480,
  "font_scale": 1.0,
  "package": "com.afradadmedia.reducephotosize",
  "activity": ".MainActivity",
  "fixture_path": "<repo path>",
  "fixture_sha256": "<sha256>",
  "semantic_assertions": [],
  "screenshot_sha256": "<sha256>",
  "uiautomator_sha256": "<sha256>",
  "foreground_sha256": "<sha256>",
  "result": "PASS"
}
```

For PASS / NOT_MET screens also record:
- target exact bytes;
- output exact bytes;
- classification.

## Store-ready composition

After all six RAW captures pass semantic binding, create six Google Play marketing composites:

`store/assets/play/en-US/screenshots/01_verified_result_1080x1920.png`
through
`06_not_met_1080x1920.png`

Rules:
- canvas exactly 1080x1920;
- Warm Ink system;
- actual captured UI remains visually dominant;
- one short marketing headline per screenshot;
- headline region <=20% of total image;
- may scale/position the raw screenshot;
- may add background, shadow, rounded outer frame, numbering;
- MUST NOT modify pixels inside the embedded raw app screenshot;
- no synthetic app UI;
- no phone UI recreation;
- no ratings/downloads/pricing/Play badge;
- no device manufacturer branding;
- no unsupported claims;
- no "Exact KB" equality guarantee.

Headlines, frozen:
1. `Verify the final size`
2. `Set your KB limit`
3. `Save or share the verified file`
4. `Use a custom KB or MB limit`
5. `Photo compression stays on-device`
6. `No false PASS when the target is too small`

## Pixel-fidelity verification

For each final composite:
- record the raw screenshot rectangle inside the final asset;
- programmatically crop that rectangle back out;
- account for only the deterministic resize transform;
- compare against the expected resized raw screenshot;
- require zero pixel delta after the same resize operation, or document the exact deterministic interpolation path.

Simpler acceptable method:
embed the raw screenshot at 1:1 without resizing if layout permits.

No retouching.

## Required QA

### Deterministic
- file dimensions;
- PNG validity;
- no alpha if store pipeline requires 24-bit RGB;
- <=2:1 longest/shortest ratio;
- exact 1080x1920 output;
- SHA-256 manifest;
- all six capture.json files;
- foreground package proof;
- UI hierarchy semantic assertions;
- raw-to-composite pixel fidelity.

### Semantic
- screenshot sequence tells one coherent buyer story;
- no duplicate low-value screens;
- #1 clearly differentiates the app through verified result truth;
- #6 is calm and credible rather than alarming;
- real user media is not stretched/cropped deceptively;
- copy does not conflict with app state.

## Evidence outputs

Required repository structure:

```
evidence/store/play_screenshots_v1/
  ENVIRONMENT_PREFLIGHT.txt
  BUILD_PROOF.json
  01_verified_result/
  02_set_kb_limit/
  03_save_share/
  04_custom_limit/
  05_on_device/
  06_not_met/
  MANIFEST.json
  REVIEW_MATRIX.md

store/assets/play/en-US/screenshots/
  01_verified_result_1080x1920.png
  02_set_kb_limit_1080x1920.png
  03_save_share_1080x1920.png
  04_custom_limit_1080x1920.png
  05_on_device_1080x1920.png
  06_not_met_1080x1920.png
  alt_text.json
  manifest.json
```

Create:
`evidence/store/S5_REAL_PLAY_SCREENSHOT_CAPTURE_PROOF_v1.0.json`

Create:
`docs/qa/S5_REAL_PLAY_SCREENSHOT_CAPTURE_REVIEW_v1.0.md`

## Alt-text direction

Write concise factual alt text describing the actual screen, not marketing hype.

Example:
`Result screen showing a compressed photo, a MEETS LIMIT status, final file size, and exact byte verification against the selected limit.`

## Terminal statuses

Success:
`REAL_PLAY_SCREENSHOT_SET_CAPTURED_ARTIFACT_BOUND_HUMAN_REVIEW_REQUIRED`

Environment unavailable:
`BLOCKED_EMULATOR_ENVIRONMENT_NOT_AVAILABLE`

Unexpected app/source drift:
`HOLD_SOURCE_DRIFT`

One or more screenshot states cannot be produced truthfully:
`PARTIAL_SCREENSHOT_SET_STATE_BLOCKED`

Build/test failure:
`HOLD_BUILD_OR_QA_FAILURE`

## Human gate

Codex MUST NOT self-approve final visual quality.

After deterministic + semantic machine QA:
`HUMAN PLAY STORE SCREENSHOT VISUAL APPROVAL = PENDING`

Stop and return:
- current source commit;
- APK SHA-256;
- emulator identity/API/config;
- fixture identity/hash;
- six raw screenshot hashes;
- six final screenshot hashes;
- evidence proof path;
- any deviations;
- terminal status.

## Authority boundary

Even on full screenshot success, DO NOT:
- submit Create app;
- register package;
- perform ownership proof;
- create/import/rotate keys;
- sign release;
- upload AAB;
- change testers;
- create Play release;
- roll out;
- enter S6;
- promote BUILD;
- Artifact Freeze;
- publish.
