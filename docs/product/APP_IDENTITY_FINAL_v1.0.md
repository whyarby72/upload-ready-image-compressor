# APP_IDENTITY_FINAL_v1.0

Status: FINAL_FOR_IMPLEMENTATION
Decision date: 2026-09-27
Authority: NAMING_AND_PACKAGE_IDENTITY_FREEZE_ONLY

## Canonical publication identity

- English Play title: `Reduce Photo Size: KB Limit`
- Launcher / in-app name: `Reduce Photo Size`
- Android applicationId: `com.afradadmedia.reducephotosize`
- Namespace root: `com.afradadmedia`

## Supersedes

- `Upload Ready: Photo Compressor`
- `SizeProof: Photo Compressor`
- `Reduce Photo Size: MB to KB`
- package `com.uploadready.app`
- proposed package `com.afradadmedia.sizeproof`

## Product-truth alignment

The final title must remain compatible with:
- actual RESULT byte verification;
- PASS only when RESULT <= REQUIRED;
- honest NOT_MET;
- REDUCED when no known external limit exists;
- quality guard;
- original preservation.

The title must never be interpreted as a guarantee that every KB target will always be reached.

## Required migration

Before any Play upload:
1. applicationId -> `com.afradadmedia.reducephotosize`
2. namespace -> `com.afradadmedia.reducephotosize`
3. migrate Java package declarations/imports and source directory as needed
4. migrate manifest/provider authorities and any hard-coded package references
5. change app label/launcher name -> `Reduce Photo Size`
6. update tests and fixtures
7. update PRODUCT_SPEC / PROJECT_STATE / handoff / evidence identity
8. run preflight, assembleDebug, unit, lint, assembleRelease, bundleRelease
9. install/launch on supported current + representative older Android
10. rerun core truth + Save/Share + permission/privacy regression
11. generate new AAB/APK hashes
12. prove no stale `com.uploadready.app` remains in publication artifacts

## Artifact invalidation rule

Existing S5 AAB:
`96ddc5b59df576c365af1321faf8801d9dbd72c77c482f97911df993ed1f5cea`

is retained as provenance only.
It is NOT eligible for Play upload because it carries the superseded application identity.

## Authority boundary

This document does not authorize Artifact Freeze, signing, Play upload, release, publication, or canonical BUILD promotion.
