# CODEX — ANDROID RUNTIME SCREENSHOT CAPTURE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Mission

Capture four **real screenshots from the Android app while it is actually running**.

These screenshots will become the runtime source-of-truth for the final Google Play marketing screenshots.

Do not create or use generated/mock UI for this task.

## Scope

Allowed:
- refresh the canonical branch;
- build/install a local debug APK from the exact canonical source;
- use ADB against one explicitly connected/authorized Android device;
- create/push a non-personal synthetic JPEG test image when needed;
- navigate the app;
- capture screenshots using ADB;
- copy the screenshots into the evidence folder;
- write an evidence report;
- commit only runtime screenshot evidence + the report.

Not allowed:
- modify app source, resources, manifest, Gradle files, ads configuration, or privacy behavior;
- patch UI just to make screenshots look better;
- hide/remove ads by source modification;
- alter Play Console;
- upload listing assets;
- Save/Save and publish;
- Send app for review;
- release/track/publication actions.

## Hard preflight

1. Fetch/refresh:
   - repo: `whyarby72/upload-ready-image-compressor`
   - branch: `task/TASK-S7-001`
2. Record exact commit SHA.
3. Require a clean working tree before capture.
4. Run:
   `adb devices -l`
5. Require exactly one authorized Android device.
6. Record:
   - device model;
   - Android version;
   - API level;
   - screen size;
   - screen density;
   - orientation.
7. If no authorized device is available, STOP:
   `BLOCKED_ADB_DEVICE_UNAVAILABLE`
8. If multiple devices are present and the intended device is ambiguous, STOP:
   `BLOCKED_ADB_DEVICE_AMBIGUOUS`

## Build/install

Preferred capture build:
- local `debug` build from the exact canonical source commit;
- do not modify source/config to prepare screenshots.

Run the existing deterministic tests/build checks that are reasonably available before installing.

Install the debug APK with the ordinary project workflow. If an existing installed app would be replaced, record that fact.

Record:
- source commit;
- APK path;
- APK SHA-256;
- package version if available;
- build variant = debug.

If build/install fails, STOP:
`BLOCKED_RUNTIME_BUILD_OR_INSTALL`

## Test-image privacy rule

Use only a non-personal image.

Preferred:
1. if a canonical non-personal JPEG fixture already exists locally, use it;
2. otherwise generate a synthetic JPEG locally using Python/Pillow or another deterministic local tool;
3. do not use a human/private photo from the operator's gallery.

If a synthetic JPEG is generated, make it visually neutral and sufficiently large that the app can demonstrate size reduction. Push it to a temporary public media location such as Download and make it visible to the Android picker.

Record the sample-image SHA-256.

## Capture requirements

Capture screenshots with the app in portrait orientation.

Use:
`adb exec-out screencap -p > <output>.png`

Do not crop, retouch, recolor, add captions, or otherwise modify the raw runtime screenshots.

Capture exactly these four states:

### 01 — HOME

Fresh app launch, before choosing a photo.

Required visible truth:
- app header;
- current home headline;
- Choose photo action;
- on-device / original-untouched messaging if currently shown;
- any privacy controls that naturally appear.

Output:
`evidence/play/runtime/W2_RUNTIME_01_HOME_2026_10_06.png`

### 02 — CHOOSE LIMIT

Choose the non-personal JPEG through the real picker.

Reach the actual limit-selection screen.

Prefer selecting `200 KB` if the UI supports it exactly as current source/runtime.

Required visible truth:
- selected photo preview;
- actual source size/dimensions shown by runtime;
- limit chips/options;
- selected target;
- Continue action.

Output:
`evidence/play/runtime/W2_RUNTIME_02_CHOOSE_LIMIT_2026_10_06.png`

### 03 — RESULT / VERIFIED TARGET

Run the real compression flow.

Goal:
- obtain a real successful known-target result;
- prefer 200 KB if the sample image can genuinely meet it.

If 200 KB cannot be achieved:
- do not fake the result;
- use the smallest preset that genuinely returns a target PASS;
- record the actual target and result.

Required visible truth:
- actual result image;
- actual output size;
- actual target;
- PASS / MEETS LIMIT semantics if genuinely achieved;
- before/after information;
- Save copy / Share / Compress another controls if visible;
- any ad/banner state that naturally appears.

Output:
`evidence/play/runtime/W2_RUNTIME_03_RESULT_PASS_2026_10_06.png`

### 04 — CUSTOM LIMIT

Return to the real limit-selection screen using the app itself.

Open the current custom-limit dialog.

Enter a valid example value without modifying source.

Preferred example:
- `250` KB, unless current runtime validation requires another valid value.

Required visible truth:
- real Custom limit dialog;
- Amount field;
- KB/MB selector;
- current confirm/cancel controls.

Do not need to execute compression from the custom value unless required to expose the dialog.

Output:
`evidence/play/runtime/W2_RUNTIME_04_CUSTOM_LIMIT_2026_10_06.png`

## Runtime-truth checks

For every screenshot:

- verify PNG opens successfully;
- record exact pixel dimensions;
- record SHA-256;
- confirm it came from ADB screencap, not a generated/mock image;
- confirm active foreground package = `com.afradadmedia.reducephotosize` at capture time;
- do not rename a mockup as runtime evidence.

If any image is not a true runtime capture:
`FAILED_RUNTIME_SCREENSHOT_PROVENANCE`

## Visual/privacy inspection

Before committing, inspect the four raw screenshots and ensure:
- no personal notification content is visible;
- no operator identity/email is visible;
- no private filenames or gallery thumbnails outside the chosen non-personal test image are exposed;
- no passwords, MFA, tokens, cookies, or sensitive account data are present.

If sensitive content appears, discard that capture and re-capture safely.

## Evidence report

Create:

`evidence/play/W2_ANDROID_RUNTIME_SCREENSHOT_CAPTURE_2026_10_06_v1.0.md`

Include:

1. terminal disposition;
2. exact source commit;
3. device model / Android / API / resolution;
4. build variant and APK SHA-256;
5. sample-image provenance and SHA-256;
6. capture method = ADB screencap;
7. table for all four screenshots:
   - filename;
   - state;
   - pixel dimensions;
   - SHA-256;
   - foreground package verification;
   - important visible values;
8. actual chosen target and actual result size for Screenshot 03;
9. whether any ad/banner was naturally visible;
10. confirmation no app source was modified;
11. confirmation no Play Console/provider mutation occurred.

## Terminal dispositions

Use exactly one:

- `PASS_ANDROID_RUNTIME_SCREENSHOTS_4_OF_4`
- `PARTIAL_ANDROID_RUNTIME_SCREENSHOTS`
- `BLOCKED_ADB_DEVICE_UNAVAILABLE`
- `BLOCKED_ADB_DEVICE_AMBIGUOUS`
- `BLOCKED_RUNTIME_BUILD_OR_INSTALL`
- `FAILED_RUNTIME_SCREENSHOT_PROVENANCE`

PASS requires all four raw runtime screenshots, validated and hashed.

## Commit boundary

If PASS or PARTIAL and repo workspace is clean except evidence:
- commit only:
  - `evidence/play/runtime/W2_RUNTIME_01_HOME_2026_10_06.png`
  - `evidence/play/runtime/W2_RUNTIME_02_CHOOSE_LIMIT_2026_10_06.png`
  - `evidence/play/runtime/W2_RUNTIME_03_RESULT_PASS_2026_10_06.png`
  - `evidence/play/runtime/W2_RUNTIME_04_CUSTOM_LIMIT_2026_10_06.png`
  - `evidence/play/W2_ANDROID_RUNTIME_SCREENSHOT_CAPTURE_2026_10_06_v1.0.md`
- do not commit generated Play marketing composites in this run.

Return the evidence commit SHA.

## Final response

Return:
- disposition;
- source commit;
- device/build identity;
- four screenshot paths;
- four screenshot SHA-256 hashes;
- actual result target/output values;
- evidence commit SHA;
- confirmation app/source diff = none;
- next ONE action only.

The next action after PASS should be:
`BUILD_FINAL_PLAY_SCREENSHOTS_FROM_RUNTIME_TRUTH`
