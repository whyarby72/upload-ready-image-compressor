# S7 TEST side-by-side install result

## Scope

S7 TEST runtime validation only. No Play Console action, signing, upload, tester mutation, rollout, release, or publication was performed.

## Build identity

- Source branch: `task/TASK-S7-001`
- Source commit: `9d5b7ff59d479ee9a283c69af540a4dd114f44a2`
- S7 implementation baseline: `49829356e02c41357db9bce64463ddead1d1d1f4`
- Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
- APK bytes: `45922793`
- APK SHA-256: `4fc626e4f274a711dfdfbb71408c684ba332ae034aac7439b1e3bf4936afd1c6`
- Debug application ID: `com.afradadmedia.reducephotosize.s7test`
- Debug version: `0.1.0-s7test` / versionCode `1`
- Release application ID remains `com.afradadmedia.reducephotosize`.

## Deterministic gates

- `./gradlew --no-daemon assembleDebug`: PASS
- `./gradlew --no-daemon testDebugUnitTest`: PASS
- `./gradlew --no-daemon lintDebug`: PASS
- GMA Next-Gen: `1.5.0`
- UMP: `4.0.0`
- AdMob identifiers: Google sample/test identifiers only; no production IDs found.

## Device/install

- Device serial: `RR8N805R27P`
- Device model: `SM-N980F` (Samsung Galaxy Note 20)
- Android: `13` / API `33`
- Play baseline package present before install: `NO` (no `com.afradadmedia.reducephotosize` package was listed)
- S7 TEST package: `com.afradadmedia.reducephotosize.s7test`
- ADB install: PASS; package path and package metadata verified after install
- ADB launch: PASS; `MainActivity` start returned `Status: ok`
- Foreground activity binding: `mFocusedApp` reported `com.afradadmedia.reducephotosize.s7test/.MainActivity`
- Provider authority: `com.afradadmedia.reducephotosize.s7test.result`
- Play baseline preserved: `NOT_APPLICABLE_BASELINE_ABSENT`; no uninstall or overwrite was performed.

## Runtime verdict

- RT-01..RT-07: `NOT_RUN`
- AdMob/UMP runtime PASS: `NOT_CLAIMED`

## Terminal state

`STOP_AFTER_S7_TEST_BUILD_IS_INSTALLED_AND_LAUNCHED_ON_DEVICE`
