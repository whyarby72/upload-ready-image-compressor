# W2 Minimal Privacy-Link + Artifact Audit Result — 2026-10-05 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Source commit under verification: `8e5b4d66967e81c486affc19f573f699b5feb393`

## Authorization

`USER_OPTION_1_2026-10-05_W2_MINIMAL_COMPLIANCE_FIX_ARTIFACT_AUDIT`

## Source fix

Implemented:
- persistent shared-header control labeled `Privacy policy`;
- explicit user action opens:
  `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`;
- the ACTION_VIEW intent contains only the policy URL;
- no photo bytes, filename, target KB/MB, result metadata, or share destination is attached.

## Deterministic CI

GitHub Actions run:
`37257297047`

Job:
`111597008413`

Result:
`PASS`

PASS:
- `assembleDebug`;
- `assembleRelease`;
- `testDebugUnitTest`;
- `lintDebug`;
- `W2_ARTIFACT_AUDIT_PASS`;
- `CI_VERIFY_PASS`;
- W2 artifact upload.

## Artifact-bound audit

Artifact:
`w2-artifact-audit`

Artifact ID:
`11323640997`

Artifact digest:
`sha256:96224ef93763cf18382ac21eac08b5a67e9bab3ac1afc337fd43dab0ec25f630`

Selected merged release manifest:
`app/build/intermediates/merged_manifest/release/processReleaseMainManifest/AndroidManifest.xml`

Resolved AdMob App ID:
`ca-app-pub-8084313520610270~1492953098`

Release manifest permissions:
- `android.permission.INTERNET`;
- `android.permission.ACCESS_NETWORK_STATE`;
- `android.permission.READ_BASIC_PHONE_STATE`;
- `com.google.android.gms.permission.AD_ID`;
- `android.permission.WAKE_LOCK`;
- `android.permission.FOREGROUND_SERVICE`;
- app-scoped signature `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`.

AD_ID:
`PRESENT`

Android's current API reference describes `READ_BASIC_PHONE_STATE` as non-dangerous. `FOREGROUND_SERVICE`, `INTERNET`, `ACCESS_NETWORK_STATE`, and `WAKE_LOCK` are not dangerous runtime permissions. No photo/media/location dangerous runtime permission was observed in the merged release manifest.

Release dependency focus:
- `com.google.android.libraries.ads.mobile.sdk:ads-mobile-sdk:1.5.0`;
- `com.google.android.gms:play-services-ads-identifier:18.0.0`;
- `com.google.android.gms:play-services-appset:16.0.1`;
- `com.google.android.ump:user-messaging-platform:4.0.0`.

Unsigned release APK:
`app-release-unsigned.apk`

SHA-256:
`df8ad4babe583bae7bf5f125ec7917803a25e01fbdd7a0353312d71a971c936e`

## Reconciliation

Closed:
- persistent in-app privacy-policy surface source gap;
- exact merged release manifest capture;
- exact AD_ID presence;
- release dependency inventory;
- deterministic build/test/lint verification.

Still open:
1. deployed privacy-policy BODY content has not been independently verified against the current post-AdMob data model;
2. Play target-audience declaration is unresolved;
3. final Play Data Safety form must be bound to the exact release artifact/current provider form;
4. Play Ads declaration must be changed to YES when the first ad-enabled artifact is distributed.

## Disposition

`W2_SOURCE_AND_ARTIFACT_AUDIT_PASS / PROVIDER_DECLARATION_AND_POLICY_CONTENT_GATES_OPEN`

No Play Console mutation, Artifact Freeze, or production release is authorized by this result.
