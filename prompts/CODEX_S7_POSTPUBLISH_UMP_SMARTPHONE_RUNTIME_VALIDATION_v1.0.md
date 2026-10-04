# CODEX — S7 POST-PUBLISH UMP + ADMOB SMARTPHONE RUNTIME VALIDATION v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Repository: whyarby72/upload-ready-image-compressor
Branch: task/TASK-S7-001
Authorized scope: S7 production AdMob ID binding + post-publish UMP runtime validation
Execution owner: CODEX
Target: one authorized physical Android smartphone connected by ADB

## Objective

Prove the current post-publish S7 behavior on a real Android device while keeping ad traffic safe:

1. the provider-backed UMP configuration can be exercised;
2. the published European regulations message can be displayed in a controlled debug test;
3. Do not consent can be selected;
4. Privacy choices / manage-options behavior can be exercised when required;
5. the ResultScreen banner path is non-obstructive;
6. core compression remains functional;
7. offline/no-ad degradation does not block the buyer job.

## Hard safety / governance boundaries

DO NOT:
- create another AdMob app or ad unit;
- change AdMob/Play provider settings;
- click any ad;
- intentionally generate live production ad impressions for testing;
- change signing keys;
- upload/promote any Play release;
- commit a UMP test-device hash;
- commit forced EEA/debug-geography code;
- commit consentInformation.reset() test hooks;
- leave device networking disabled after the test;
- claim PASS from source inspection alone.

Debug builds are already configured to use Google's dedicated demo Banner ad unit.
Release builds are bound to the existing production Banner unit.
Use DEBUG build for smartphone runtime testing.

## Starting-state guard

1. Checkout `task/TASK-S7-001`.
2. Confirm HEAD equals the repository HEAD that contains this prompt.
3. Confirm working tree is clean.
4. Record:
   - git HEAD;
   - device serial;
   - model;
   - Android version/API;
   - package target: `com.afradadmedia.reducephotosize.s7test`.
5. Run `adb devices -l`.
6. Require exactly one physical device in state `device`.

If no device:
`BLOCKED_NO_ADB_DEVICE`

If unauthorized/offline:
`BLOCKED_ADB_AUTH_OR_OFFLINE`

Do not ask the human to relay routine logs. If the phone displays the standard USB-debugging trust dialog, the human may approve that device-level dialog once.

## Phase A — clean debug build + install

Run:

```bash
./gradlew --no-daemon clean assembleDebug testDebugUnitTest lintDebug
```

Require PASS.

Locate the debug APK and record SHA-256.

Install/update:

```bash
adb install -r <debug-apk>
```

Clear app data before first consent test:

```bash
adb shell pm clear com.afradadmedia.reducephotosize.s7test
```

Start a fresh logcat capture scoped to app/UMP/GMA-related output.

Launch the app.

## Phase B — baseline provider-backed UMP observation

Observe for a bounded interval.

Capture:
- screenshot;
- UIAutomator XML;
- relevant UMP/GMA log lines.

If the European-regulations message naturally appears, continue to Phase D.

If it does NOT appear, this is expected for a device outside EEA/UK/Switzerland. Continue to Phase C; do not mark failure.

## Phase C — temporary DEBUG-ONLY forced-EEA test

Google's official UMP test path permits:
- registering a test device with `ConsentDebugSettings`;
- forcing `DEBUG_GEOGRAPHY_EEA`;
- using `consentInformation.reset()` for testing only.

Use the hashed test-device ID emitted by UMP logcat.

Create a TEMPORARY LOCAL-ONLY debug test patch in `AdMobTestController.kt`:

- import/use `ConsentDebugSettings`;
- only under `BuildConfig.DEBUG`:
  - add the current hashed test-device ID;
  - set debug geography to EEA;
- feed the resulting debug settings into `ConsentRequestParameters`;
- reset consent state only for the bounded test run if required.

Do not place the test-device ID in any committed artifact.

Build/install debug again.

If necessary:
```bash
adb shell pm clear com.afradadmedia.reducephotosize.s7test
```

Launch again.

After the test is complete, REVERT every temporary debug-geography/test-ID/reset source change before any commit.

The final committed source must remain free of:
- test-device hashes;
- forced geography;
- consent reset test hooks.

## Phase D — UMP interaction proof

Using UIAutomator hierarchy plus screenshots:

1. Confirm the message corresponds to the app/provider-backed flow.
2. Confirm visible choices include:
   - `Do not consent`;
   - `Consent`;
   - `Manage options`.
3. Select `Do not consent`.
4. Confirm app remains usable after dismissal.
5. Record resulting logs/state; do not infer personalized/non-personalized serving beyond what UMP/GMA directly reports.

Then exercise the privacy-options/manage-options path if the app exposes `Privacy choices` because UMP reports it REQUIRED.

Expected:
- privacy options form opens;
- closing/saving returns safely to app;
- buyer job is not blocked.

If Privacy choices is not required after the exercised state, record:
`PRIVACY_CHOICES_NOT_REQUIRED_IN_OBSERVED_STATE`
rather than FAIL.

## Phase E — core flow + safe demo Banner

Use a repository fixture, not a personal/sensitive image. Prefer:

`app/src/androidTest/assets/fixtures/ratio_1x1.jpg`

Push it to a temporary device-visible location if required.

Drive the real app through:
- Choose JPEG;
- select/enter a KB limit;
- process;
- reach ResultScreen.

Capture:
- screenshot;
- UIAutomator XML;
- relevant logcat.

Verify:
- genuine result proof visible;
- Save visible/usable;
- Share visible/usable;
- Compress another visible/usable;
- banner is after buyer-critical controls;
- banner does not overlay or obstruct core controls;
- demo/test ad traffic only;
- no ad click.

A demo banner load may be proven through UI and/or the app's `Banner loaded.` log.
A no-fill/failure is acceptable only if core behavior remains unaffected and the failure is directly observed.

## Phase F — offline/no-ad degradation

Before changing connectivity, record current Wi-Fi/mobile-data state.

Temporarily disable network connectivity using reversible ADB commands.

Relaunch/reuse the app with the local fixture and verify the core compression job still works without an ad.

Then restore the exact prior connectivity state in a guaranteed cleanup/finally step.

If safe restoration cannot be guaranteed, do not toggle networking; record:
`OFFLINE_TEST_SKIPPED_RESTORE_RISK`

## Required evidence

Create a new evidence directory under:
`evidence/admob/s7_postpublish_runtime_<timestamp>/`

Include, where applicable:
- device_info.txt
- git_head.txt
- debug_apk_sha256.txt
- build_test_lint.log or concise command/result transcript
- baseline_logcat.txt
- forced_eea_logcat.txt
- ump_first_layer.png
- ump_first_layer.xml
- ump_after_do_not_consent.png
- privacy_choices.png / xml if applicable
- result_screen.png
- result_screen.xml
- banner_logcat.txt
- offline_result.txt
- cleanup_proof.txt

Write:
`evidence/admob/S7_POSTPUBLISH_UMP_SMARTPHONE_RUNTIME_RESULT_2026_10_05_v1.0.md`

The result must distinguish:
- PASS;
- NOT_OBSERVED;
- NOT_REQUIRED;
- BLOCKED;
- FAIL.

## Required cleanup proof

Before committing evidence:

1. `git diff -- app/src/main/java/com/afradadmedia/reducephotosize/AdMobTestController.kt`
   must show no temporary debug-test modifications remaining.
2. Search tracked source for the captured UMP test-device hash. It must not exist.
3. Search for `DEBUG_GEOGRAPHY_EEA` and any temporary `reset()` hook. They must not remain unless they existed before this task.
4. Confirm debug banner configuration still uses Google's demo banner unit.
5. Confirm networking was restored.
6. Re-run:
   `./gradlew --no-daemon assembleDebug testDebugUnitTest lintDebug`

## Commit policy

Commit only:
- runtime evidence;
- result markdown;
- deterministic documentation/state updates justified by observed evidence.

Do NOT commit temporary testing source hooks.

## Terminal disposition

Use exactly one:

`PASS_S7_POSTPUBLISH_UMP_SMARTPHONE_RUNTIME`

or

`PARTIAL_S7_POSTPUBLISH_RUNTIME_<reason>`

or

`BLOCKED_S7_POSTPUBLISH_RUNTIME_<reason>`

or

`FAIL_S7_POSTPUBLISH_RUNTIME_<reason>`

Stop after the runtime evidence commit. Do not promote Play tracks, create new ad units, freeze artifacts, or release/publish the Android app.
