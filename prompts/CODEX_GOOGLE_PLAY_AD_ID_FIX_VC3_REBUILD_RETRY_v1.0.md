# CODEX — AD_ID FIX + VC3 REBUILD + PRODUCTION RETRY v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider blocker

Google Play final validation blocked submission because:
`Advertising ID declaration is active, but the uploaded artifact does not include com.google.android.gms.permission.AD_ID`

Do NOT change the Advertising ID declaration to "No".
This app intentionally contains AdMob/GMA and the existing privacy/Data Safety model is ad-enabled.

## Source correction already made

Canonical source now contains:

1. explicit main-manifest permission:
`<uses-permission android:name="com.google.android.gms.permission.AD_ID" />`

2. release identity:
- targetSdk = 36
- versionCode = 3
- versionName = 0.1.0

No other product behavior change is authorized.

## Mission

Build, verify, sign, and upload a versionCode 3 production AAB that explicitly contains the AD_ID permission, replace/supersede the vc2 production draft artifact as required by Play Console, resolve only release-blocking validation, and STOP before any review submission / rollout / publication action.

## Preflight

1. Refresh canonical branch.
2. Record exact HEAD.
3. Verify clean worktree.
4. Verify:
   - applicationId = `com.afradadmedia.reducephotosize`
   - targetSdk = 36
   - versionCode = 3
   - versionName = 0.1.0
   - main manifest explicitly contains:
     `com.google.android.gms.permission.AD_ID`

If not:
`BLOCKED_SOURCE_AD_ID_FIX_DRIFT`

## Deterministic build

Run:
`./gradlew test lint bundleRelease`
or repository-equivalent deterministic commands.

Required:
- tests PASS
- lint PASS
- bundleRelease PASS

If not:
`FAILED_RELEASE_ARTIFACT_BUILD`

## Artifact-bound permission verification BEFORE Play upload

Do not rely only on source manifest.

Inspect the actual built release AAB using an available deterministic Android/bundle inspection tool such as:
- bundletool dump manifest
- aapt/aapt2-compatible manifest inspection
- Android Studio/Gradle bundle manifest output

Prove the final vc3 artifact manifest contains exactly:
`com.google.android.gms.permission.AD_ID`

Also record whether AD_ID appears once or is deduplicated by manifest merge.

If final AAB does not contain the permission:
`FAILED_AD_ID_ARTIFACT_VERIFICATION`

## Signing

Reuse the same existing secure upload-key setup that signed vc1/vc2.

Do NOT:
- generate a new upload key;
- print or commit secret values;
- change signing identity.

Produce signed vc3 AAB.

Record:
- path
- SHA-256
- versionCode/versionName
- targetSdk
- safe signing fingerprint if available

## Production retry

Open the correct Google Play Console app.

Verify:
- app = `Photo Compressor: KB Limit`
- package = `com.afradadmedia.reducephotosize`
- global countries/regions still present
- existing launch-related pending changes remain expected

Open the Production draft.

If vc2 must be removed from the draft release before vc3 can be used:
- remove/replace only the vc2 artifact from that draft as required by Play Console;
- do not alter unrelated release/listing/declaration state.

Upload the signed vc3 AAB.

Resolve only mandatory release-blocking fields.

Do NOT change:
- Advertising ID declaration;
- Data Safety;
- Ads declaration;
- privacy policy;
- store listing;
- AI asset labels;
- country scope unless provider says existing global selection is missing.

## Required provider validation

Record exact Play result for:
- versionCode 3 acceptance
- target API
- signing
- Advertising ID declaration/permission mismatch
- bundle integrity
- remaining errors/warnings

Expected result:
the prior AD_ID blocker is gone.

If AD_ID blocker remains:
`BLOCKED_AD_ID_PROVIDER_VALIDATION_PERSISTS`

If another blocker appears:
`BLOCKED_PROVIDER_VALIDATION`

## Stop boundary

Advance only until the FIRST control that would:
- Send app for review
- Send release to Google for review
- submit changes for review
- start rollout
- publish

STOP before clicking it.

Best-case disposition:
`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL_VC3`

## Evidence

Create:
`evidence/play/W2_AD_ID_FIX_VC3_PRODUCTION_RETRY_2026_10_06_v1.0.md`

Include:
- terminal disposition
- canonical HEAD
- source manifest AD_ID evidence
- targetSdk/versionCode/versionName
- tests/lint/bundle result
- signed AAB path + SHA-256
- artifact-bound AD_ID manifest verification
- Production upload result
- exact provider validation
- exact next material control not clicked
- confirmation no review submission/rollout/publication occurred

Commit only the text evidence report.

## Allowed terminal dispositions

- `READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL_VC3`
- `BLOCKED_SOURCE_AD_ID_FIX_DRIFT`
- `FAILED_RELEASE_ARTIFACT_BUILD`
- `FAILED_AD_ID_ARTIFACT_VERIFICATION`
- `BLOCKED_SIGNED_AAB_UNAVAILABLE`
- `BLOCKED_AD_ID_PROVIDER_VALIDATION_PERSISTS`
- `BLOCKED_PROVIDER_VALIDATION`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Final response

Return:
1. disposition
2. canonical HEAD
3. targetSdk/versionCode/versionName
4. build/test/lint result
5. signed vc3 AAB path + SHA-256
6. proof final AAB contains AD_ID permission
7. Production upload/validation result
8. exact next material control not clicked
9. evidence commit SHA if available
10. confirmation no review submission/rollout/publication occurred
