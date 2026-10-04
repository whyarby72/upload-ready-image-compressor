# W2 Post-AdMob Artifact-Bound Privacy Audit — 2026-10-04 v1.0

Product: **PHOTO COMPRESSOR: KB LIMIT**  
Package: `com.afradadmedia.reducephotosize`

## Gate

`W2_POST_ADMOB_ARTIFACT_PRIVACY`

## Verdict

`PASS_FOR_S7_RELEASE_MODE_TEST_ARTIFACT / HOLD_FOR_FINAL_PRODUCTION_ARTIFACT`

This audit closes the artifact-bound privacy/permission/dependency questions for the current S7 **release-mode TEST candidate**. It does **not** close final production privacy because the audited release artifact still uses Google's sample AdMob App ID and no production AdMob App ID is bound in source.

## 1. Source binding

Canonical product source head audited:

`baf63bbc9c793b135796cc70de61013bccd26fca`

Audit branch:

`audit/W2-privacy-artifact`

Final audit workflow commit:

`4cb86e5393d857e53437a62ad9868c0f0eaf8091`

Git comparison from product source head to audit head:

- ahead by audit-only commits;
- application/source changes: **NONE**;
- only changed path: `.github/workflows/w2_privacy_audit.yml`.

Therefore the generated application artifacts are bound to the same product source, with audit automation added only on the audit branch.

## 2. Replayable CI evidence

GitHub Actions workflow:

`W2 Privacy Artifact Audit`

Final valid run:

`37208707771`

Run conclusion:

`SUCCESS`

Evidence artifact:

- artifact name: `w2-privacy-artifact-evidence`
- artifact ID: `11305559563`
- GitHub artifact digest: `sha256:8aa255476a714621657ebb0fd6d9076df08891e25831c7ca83cb17f88db947a6`
- retention at creation: 30 days

Environment captured:

- Java: OpenJDK 17.0.20.1
- Gradle: 9.7.1
- Android Gradle Plugin: source-bound 9.4.1

## 3. Exact debug artifact

Package:

`com.afradadmedia.reducephotosize.s7test`

Version:

`0.1.0-s7test`

APK:

`app-debug.apk`

Bytes:

`45,922,793`

SHA-256:

`4b6102adc003f89f17ae9481ec4ed76b065df8087d5d09f698eea3eacd490a03`

Merged manifest:

`app/build/intermediates/merged_manifests/debug/processDebugManifest/AndroidManifest.xml`

## 4. Exact release-mode artifact

Package:

`com.afradadmedia.reducephotosize`

Version code:

`1`

Version name:

`0.1.0`

APK:

`app-release-unsigned.apk`

Bytes:

`36,679,520`

SHA-256:

`147268aa57bbbd7224782104dcfa96018792a73f3dcaff65ceb61c218e6e2d16`

Merged manifest:

`app/build/intermediates/merged_manifests/release/processReleaseManifest/AndroidManifest.xml`

This release artifact is unsigned and is **not** the final Play release artifact.

## 5. Resolved advertising/privacy dependencies

Both debug and release runtime classpaths prove:

- GMA Next-Gen SDK: `com.google.android.libraries.ads.mobile.sdk:ads-mobile-sdk:1.5.0`
- Google UMP: `com.google.android.ump:user-messaging-platform:4.0.0`
- legacy `play-services-ads`: **ABSENT**
- legacy `play-services-ads-lite`: **ABSENT**

Notable GMA transitive dependencies include:

- `androidx.work:work-runtime:2.7.0`
- `com.google.android.gms:play-services-ads-identifier:18.0.0`
- `com.google.android.gms:play-services-appset:16.0.1`

Dependency-tree search found:

- Firebase: **NONE**
- mediation: **NONE**
- custom/Firebase analytics dependency: **NONE**

## 6. Release merged-manifest permissions

Exact release merged manifest declares:

- `android.permission.INTERNET`
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.READ_BASIC_PHONE_STATE`
- `com.google.android.gms.permission.AD_ID`
- `android.permission.WAKE_LOCK`
- `android.permission.FOREGROUND_SERVICE`
- app-scoped signature permission:
  `com.afradadmedia.reducephotosize.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`

Artifact assertions prove the release manifest does **not** declare:

- `android.permission.CAMERA`
- `android.permission.RECORD_AUDIO`
- fine/coarse location permissions
- `android.permission.READ_CONTACTS`
- `android.permission.READ_MEDIA_IMAGES`
- `android.permission.READ_EXTERNAL_STORAGE`
- `android.permission.WRITE_EXTERNAL_STORAGE`

The source app still relies on Android system picker/document flows for the user's selected image rather than broad photo-library permission.

Android's current API reference classifies `READ_BASIC_PHONE_STATE` as a non-dangerous permission for basic phone-state information. It is not the dangerous `READ_PHONE_STATE` permission.

## 7. Provider-ID binding result

Both debug and release merged manifests contain Google's sample/test AdMob App ID:

`ca-app-pub-3940256099942544~3347511713`

Both explicitly do **not** contain the real provider AdMob App ID:

`ca-app-pub-8084313520610270~1492953098`

Therefore:

`PRODUCTION_ADMOB_APP_ID_BOUND = NO`

The provider-side production Banner unit exists separately, but this W2 artifact does not prove production ad serving.

## 8. Google SDK data-handling reconciliation

Official Google documentation rechecked on 2026-10-04 states that the latest GMA Next-Gen SDK automatically collects and shares these categories for advertising, analytics, and fraud-prevention purposes:

- IP address, which can be used to estimate general location;
- user product interactions;
- diagnostic information;
- device and account identifiers.

Google states these SDK data are encrypted in transit using TLS.

Official source:
`https://developers.google.com/ad-manager/mobile-ads-sdk/android/next-gen/privacy/play-data-disclosure`

Google Play's Data Safety guidance requires SDK/library off-device transmission to be included in the developer's declarations.

Official source:
`https://support.google.com/googleplay/android-developer/answer/10787469`

This does not change the source-bound fact that app code does not intentionally pass the user's JPEG bytes or entered KB/MB target to GMA.

## 9. UMP reconciliation

Source + dependency + current official UMP guidance align on:

- UMP version `4.0.0`;
- consent-information refresh on each app launch;
- `loadAndShowConsentFormIfRequired()`;
- ad-request gate through `canRequestAds()`;
- privacy-options entry point when UMP reports it required.

Official source:
`https://developers.google.com/admob/android/privacy`

Provider-side EU message publication remains a separate provider action and is not proven by this artifact.

## 10. Data Safety candidate truth

For an ad-enabled artifact with materially equivalent GMA behavior, the privacy/Data Safety model must distinguish:

### Core photo workflow

- selected JPEG content: processed locally;
- developer-owned server upload for compression: none;
- Save: user initiated;
- Share: user initiated;
- original source: preserved;
- no account/login required for core job.

### Google advertising / consent layer

Data transmitted by Google's SDK must be represented according to the exact final configuration and current Google guidance. Current GMA disclosure baseline includes:

- IP address / general-location inference;
- user product interactions;
- diagnostics;
- device/account identifiers.

Do **not** describe the ad-enabled app as "zero data collection."

## 11. Verification-control defect and repair

Run 2 (`37208301703`) completed technically but its release-manifest capture was **INVALID FOR RELEASE-MANIFEST CLAIMS**.

Defect:

The manifest finder used a broad pattern and selected the debug merged manifest for the release evidence slot.

Observed symptom:

`release-BUILD_METADATA.txt` incorrectly pointed to:

`.../merged_manifests/debug/processDebugManifest/AndroidManifest.xml`

Disposition:

`PARTIAL / RELEASE MANIFEST CLAIMS REJECTED`

Repair:

Run 3 changed capture logic to bind each variant to its explicit directory:

- `merged_manifests/debug/`
- `merged_manifests/release/`

It also added package assertions:

- debug must equal `com.afradadmedia.reducephotosize.s7test`
- release must equal `com.afradadmedia.reducephotosize`

Run 3 passed these assertions. This is the valid W2 evidence set.

## 12. Remaining final-production blockers

W2 cannot be closed as final production truth until a later exact candidate proves:

1. real AdMob App ID is bound;
2. real Banner ad-unit ID is bound;
3. banner placement API mismatch is resolved;
4. exact signed/Play candidate is built;
5. merged release manifest is regenerated;
6. release runtime dependency graph is regenerated;
7. production-like UMP/ad runtime is validated;
8. Play Ads declaration is reconciled to the actual ad-enabled artifact;
9. Play Data Safety is completed against that exact artifact/configuration;
10. public Privacy Policy URL and in-app privacy link are verified;
11. provider EU privacy message is separately approved/published when ready.

## Final disposition

`W2_S7_RELEASE_MODE_TEST_ARTIFACT = PASS`

`W2_FINAL_PRODUCTION_PRIVACY = HOLD`

No production-ID binding, Play mutation, provider-message publication, release, Artifact Freeze, or public publication is authorized by this audit.
