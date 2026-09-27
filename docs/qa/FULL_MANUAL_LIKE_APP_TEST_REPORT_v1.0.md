# Full Manual-Like App Test Report v1.0

Date: 2026-09-27  
Disposition: `PARTIAL`  
Mode: QA-only / non-mutating product source

## Identity

- Repository: `whyarby72/upload-ready-image-compressor`
- Branch: `task/TASK-S5-003`
- Tested HEAD: `aa950611ffabc2d45ba7f7db608ed9d41b48a02a`
- Product-source commit affecting `app/**`: `2cc6b4b3d5b8deea1f46ad3f62e83af536ca7b2d`
- Required QA start verified: `aa950611ffabc2d45ba7f7db608ed9d41b48a02a`
- OS: macOS Darwin 25.5.0 arm64
- Gradle: 9.7.1; AGP: 9.4.1; build used Temurin JDK 17.0.16
- Android SDK/build-tools: compile/target 36; build-tools 36.0.0; platform-tools 37.0.1
- Devices: `emulator-5554` API36 and `emulator-5556` API29
- Viewport: 320x640, density 160, rotation 0

## Artifact verification

Build commands all passed: preflight, assembleDebug, testDebugUnitTest, lintDebug, assembleRelease, bundleRelease, and authority validation. Release artifacts are unsigned and not Play-upload eligible without human signing.

| Artifact | Bytes | SHA-256 |
|---|---:|---|
| Debug APK | 2,630,064 | `138403cc37259588cbc56e20c7a90b4892c6cb8de9c3e78d3151b0ce6f98c1aa` |
| Release APK | 2,142,882 | `85781c516bc80de803b098274e9d3895c8b9edcd0b25400b835430ec3f83b4f9` |
| Release AAB | 664,211 | `b5fa67117c87f62f38507ede72c2fba006b63bdaf2155b4d45c41d2d65a4c9ca` |

Package identity: `com.afradadmedia.reducephotosize`, versionCode 1, versionName 0.1.0. Manifest has no declared permissions, including no INTERNET or broad storage/media permission.

## Scenario results

| Area | Result | Evidence / actual |
|---|---|---|
| First open API36/API29 | PASS | Header, Choose photo, private/on-device, original/no-account reassurance; screenshots and hierarchies in `evidence/manual_like/api36_first_open*` and `api29_first_open*`. |
| Requirement state API36/API29 | PASS | Current size/dimensions shown; neutral `Choose the upload limit`; CTA disabled; unknown action reachable. |
| Known 100 KB path | PASS | Actual result 97,220 bytes; UI proof `97220 bytes ≤ 100000 bytes — PASS`; `evidence/manual_like/api36_result_100kb*`. |
| Save | PASS | MediaStore output `UploadReady_20260927_125816.jpg`, 97,220 bytes; matching result size; source fixture remained present. |
| Share | PASS | Android Sharesheet opened from Share; `evidence/manual_like/api36_sharesheet*`. |
| Unknown-limit path | PASS | UI result `REDUCED`, 48 KB, explicit “upload compatibility is not verified”; `api36_unknown_result*`. |
| Privacy/permissions | PASS | APK permission dump empty; no AdMob/UMP/analytics identifiers observed in manifest/source scope. |
| Crash/ANR/log audit | PASS for checked window | Cleared logcat before relaunch smoke; checked 500-line API36 window for FATAL EXCEPTION, ANR, AndroidRuntime, OOM, StrictMode; none found. |
| Fractional Custom values | NOT RUN in this QA session | Prior artifact-bound evidence exists, but this manual-like session did not repeat the Custom dialog matrix. |
| All five presets and NOT_MET | NOT RUN | 100 KB PASS was exercised; 50/200/500/1 MB and an aggressive NOT_MET result were not repeated here. |
| EXIF orientation and large-input stability | NOT RUN | Existing evidence remains in repository; not repeated in this QA-only session. |
| Target switching, invalid Custom, photo-A/photo-B reset | NOT RUN | Not repeated in this QA-only session. |
| Offline-network-disabled flow | NOT RUN | Network was not disabled during this session. |

## Source mutation guard

`git diff --name-only aa950611ffabc2d45ba7f7db608ed9d41b48a02a..HEAD` returned no paths. `git diff --name-only -- app` returned no paths. Only evidence/report files are added by this QA run; product source, Gradle/build logic, manifest, resources, identity, signing, and Play state were not modified.

## Visual observations

The exercised first-open, requirement, PASS, REDUCED, Save, and Share surfaces fit the 320x640 viewport without observed clipping, overlap, or truncation. Disabled known CTA is visibly present and the neutral requirement state is understandable. No product redesign was made.

## Defects and disposition

No new material defect was observed in the executed scenarios. Final disposition is `PARTIAL`, not PASS, because the prompt-required full matrix was not completely repeated in this session. The current unsigned AAB remains a technical candidate subject to the existing human signing/Play Internal Testing distribution boundary; this QA run does not authorize upload or claim S6/BUILD/release/publication.

Evidence directory: `evidence/manual_like/`.
