# S5 COMPOSE TOOLCHAIN BINDING v1.0

Observed: 2026-09-27
Task: TASK-S5-005
Status: BINDING FOR IMPLEMENTATION

## Official-current baseline checked on 2026-09-27

Official Android documentation currently shows:

- Android Gradle Plugin 9.4 supports API level 37.
- AGP 9.4 requires Gradle >= 9.6.0.
- JDK 17 remains the compatibility baseline.
- Current Android build examples use Kotlin Gradle plugin 2.4.10 with AGP 9.4.
- Compose Compiler Gradle plugin is the current setup path for Kotlin 2.0+.
- Official Compose setup currently specifies Compose BOM `2026.09.00`.
- Current stable Compose UI/foundation/runtime family is 1.12.1.
- Current stable Compose Material 3 is 1.4.0.
- Official setup lists `androidx.activity:activity-compose:1.13.0`.
- Compose 1.12.0+ requires compileSdk 37.

Official sources:
- https://developer.android.com/develop/ui/compose/setup-compose-dependencies-and-compiler
- https://developer.android.com/jetpack/androidx/releases/compose
- https://developer.android.com/jetpack/androidx/releases/compose-material3
- https://developer.android.com/build/releases/agp-9-4-0-release-notes
- https://developer.android.com/build/releases/about-agp

## Bound project toolchain

Retain:
- AGP: 9.4.1
- Gradle wrapper: 9.7.1
- JDK: 17
- targetSdk: 36
- minSdk: 29
- versionCode/versionName: unchanged

Add:
- Kotlin Android plugin: 2.4.10
- Compose Compiler plugin: 2.4.10
- Compose BOM: 2026.09.00
- Compose Material 3 through BOM
- Compose UI/foundation/tooling through BOM
- activity-compose: 1.13.0

compileSdk:
- upgrade from 36 to 37 because current stable Compose 1.12.x requires compileSdk 37.
- this is a build-time API visibility/toolchain change only.
- DO NOT change targetSdk 36 in this task.

Android API 37 SDK may be installed in the build environment if absent.

## Version discipline

No dynamic versions.
No alpha/beta dependencies unless a stable implementation blocker is documented and separately reviewed.

Record the final resolved versions in evidence.

If current official dependencies resolve differently at execution time, STOP and report before changing this binding rather than silently drifting.
