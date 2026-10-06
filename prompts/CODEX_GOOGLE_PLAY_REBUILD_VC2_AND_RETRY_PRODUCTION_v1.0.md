# CODEX — REBUILD VERSIONCODE 2 AND RETRY PRODUCTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current blocker

Provider rejected the prior Production upload with:

`Version code 1 has already been used. Try another version code.`

Prior artifact:
- versionCode = 1
- versionName = 0.1.0
- signed AAB SHA-256 = `f0952b9a5edd3803595171409c9be4c24eb3c1f478a3d9b169dcee42f48f0869`

Production is directly available.
No testing requirement was observed.

## Source change already made

Canonical source now uses:
- targetSdk = 36
- versionCode = 2
- versionName = 0.1.0

Do NOT change versionName unless Play explicitly requires it.
Do NOT make any other source/product change.

## Mission

Rebuild the exact app from canonical source with versionCode 2, sign it using the same existing secure upload key path that successfully signed vc1, retry the Production release upload, resolve only release-blocking validation, and stop before any review submission / rollout / publication action.

## Preflight

1. Refresh canonical branch.
2. Record exact HEAD.
3. Verify:
   - applicationId = `com.afradadmedia.reducephotosize`
   - targetSdk = 36
   - versionCode = 2
   - versionName = 0.1.0
4. Verify clean worktree.

If source differs materially:
`BLOCKED_SOURCE_VERSION_DRIFT`

## Build

Run:
`./gradlew test lint bundleRelease`
or the repository-equivalent deterministic command.

Required:
- tests PASS
- lint PASS
- bundleRelease PASS

If not:
`FAILED_RELEASE_ARTIFACT_BUILD`

## Signing

Reuse the same existing secure upload key setup used for the vc1 signed AAB.

Do not:
- print secret values;
- commit keystore/passwords;
- generate a new upload key;
- change signing identity.

Produce signed vc2 AAB.

Record:
- AAB path
- SHA-256
- versionCode/versionName
- upload-key fingerprint if safely available, without private material

If signing unavailable:
`BLOCKED_SIGNED_AAB_UNAVAILABLE`

## Production retry

Open Google Play Console in the correct authenticated profile.

Verify:
- app = `Photo Compressor: KB Limit`
- package = `com.afradadmedia.reducephotosize`
- Production is directly available
- global countries/regions selection already persisted

Use the existing Production release flow.

Upload the signed versionCode 2 AAB.

Resolve only release-blocking provider fields that are mandatory:
- release name if required;
- release notes if required:
  `Initial release of Photo Compressor: KB Limit.`

Do NOT modify:
- store listing;
- app content declarations;
- AI asset labels;
- country scope unless provider says prior global selection did not persist;
- testing tracks unless Production becomes explicitly blocked.

## Validation

Record exact Play result for:
- version code acceptance;
- target API;
- signing;
- bundle integrity;
- warnings/errors.

If versionCode 2 is also already used:
`BLOCKED_VERSION_CODE_2_ALREADY_USED`

If another provider validation blocks:
`BLOCKED_PROVIDER_VALIDATION`

## Stop boundary

Advance only until the FIRST control that would:
- send the app/release to Google for review;
- submit changes for review;
- start rollout;
- publish the app.

STOP before clicking it.

Expected best-case disposition:
`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL`

## Never do

- do not click `Send app for review`
- do not click `Send release to Google for review`
- do not start rollout
- do not publish
- do not create Closed/Open testing unless Production becomes explicitly blocked

## Evidence

Create:
`evidence/play/W2_PRODUCTION_VC2_RETRY_2026_10_06_v1.0.md`

Include:
- disposition
- canonical HEAD
- targetSdk/versionCode/versionName
- build/test/lint result
- signed AAB path and SHA-256
- production upload result
- exact provider validation
- exact next material control not clicked
- confirmation no review submission/rollout/publication occurred

Commit only the text evidence report.

## Allowed terminal dispositions

- `READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL`
- `BLOCKED_SOURCE_VERSION_DRIFT`
- `FAILED_RELEASE_ARTIFACT_BUILD`
- `BLOCKED_SIGNED_AAB_UNAVAILABLE`
- `BLOCKED_VERSION_CODE_2_ALREADY_USED`
- `BLOCKED_PROVIDER_VALIDATION`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Final response

Return:
1. disposition
2. canonical HEAD
3. targetSdk/versionCode/versionName
4. build/test/lint result
5. signed AAB path + SHA-256
6. Production upload/validation result
7. exact next material control not clicked
8. evidence commit SHA if available
9. confirmation no review submission/rollout/publication occurred
