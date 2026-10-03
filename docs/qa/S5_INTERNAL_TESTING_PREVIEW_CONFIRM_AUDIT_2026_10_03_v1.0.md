# S5 Internal Testing Preview + Confirm Audit

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT

Provider evidence PDF SHA-256: f085b9e20e1925baff9bbf6871045ef3e67156fb559af197d5f246d0fe4ac691
Provider evidence PDF bytes: 923478

## Observed Play Console state

Page: Create internal testing release > Preview and confirm

Provider message:
- "We found some problems with your release"
- 2 warnings
- no visible error

Warnings:
1. No deobfuscation file is associated with this App Bundle. Play says a deobfuscation file is useful if R8/ProGuard obfuscation is used.
2. The App Bundle contains native code and no debug symbols were uploaded.

Release row:
- App bundle
- version 1 (0.1.0)
- API 29+
- Target SDK 36
- 4 screen layouts
- 4 ABIs
- 1 required feature

Release notes are empty.

Final provider action shown:
- "Save and publish"
- provider text states changes will be published to Google Play immediately.

## Repository reconciliation

Current release build config has:
- minifyEnabled false

Therefore warning 1 is non-blocking for this exact vc1 artifact because Java/Kotlin code is not being minified/obfuscated by the current release build.

Warning 2 is diagnostic-quality debt, not a provider rejection. Google Play can accept the bundle, but native crash stack traces may be less useful without symbols.

Current Android documentation says native debug symbols improve symbolication of native crashes in Play Console. This should be addressed before production readiness where feasible, but does not require replacing the already provider-validated internal-test baseline artifact.

## Disposition

PASS_PREVIEW_WITH_NON_BLOCKING_WARNINGS

Rollout is not authorized by the current scope.

Hard stop:
STOP_BEFORE_SAVE_AND_PUBLISH

Recommended next bounded scope:
S5 INTERNAL TESTING ROLLOUT ONLY
