# W2 POST-ADMOB PRIVACY + DATA SAFETY + ADS RECONCILIATION — 2026-10-05 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Canonical branch: `task/TASK-S7-001`
Starting HEAD: `1edcdeb4b930dd5c05c3cf04aea10137651ae787`

## Decision carried forward

S7 technical/runtime work is accepted with one documented residual:
`POST_REPUBLISH_THREE_BUTTON_PHYSICAL_DEVICE_OBSERVATION_NOT_REPEATED_DUE_EXECUTION_ENVIRONMENT`

This residual is accepted as an observability exception, not an app failure, because:
- provider editor showed the intended three-button consent preview;
- intended country selection was verified;
- provider state was republished and confirmed Published;
- prior physical-device runtime already proved UMP delivery, refusal semantics through Manage options, Privacy choices, demo-banner rendering, non-obstruction, offline degradation, and cleanup;
- the minimal post-republish rerun was blocked by missing ADB/Android SDK in that Codex execution environment, with no source mutation.

S7 is therefore closed for technical implementation and runtime scope.

## Current artifact/source FACT

- GMA Next-Gen SDK: `1.5.0`
- UMP SDK: `4.0.0`
- production AdMob App ID is bound;
- exactly one production Banner unit is bound to release;
- debug Banner traffic uses Google's demo unit;
- GMA initialization is gated by UMP `canRequestAds()`;
- Publisher first-party ID is disabled;
- app code does not send selected JPEG bytes, result JPEG bytes, target KB/MB, filenames, or share destinations to AdMob/analytics;
- core JPEG selection/compression/verification/save remains on-device;
- Share is explicit and user-initiated;
- no Firebase Analytics, mediation, custom analytics, or custom user ID is integrated;
- the app has a conditional `Privacy choices` entry point when UMP reports it required;
- the app does NOT currently expose a persistent in-app link to the public privacy policy.

## Current official Google FACT used for W2

Google Play Data safety requires SDK-caused off-device collection/sharing to be declared.

Google's current GMA Next-Gen disclosure states that the SDK automatically collects and shares:
- IP address;
- user product interactions;
- diagnostic information;
- device/account identifiers;
for advertising, analytics, and fraud-prevention purposes, with data encrypted in transit.

Google Play states that approximate location inferred from IP must be disclosed as Approximate location.

Google Play states that a data type may be declared optional only when all users, regardless of device or region, can opt in/out or otherwise choose whether it is collected.

Google Play requires a privacy policy in Play Console and within the app itself. The policy must be publicly accessible, non-geofenced, non-editable, identify the app/developer, provide a privacy contact/mechanism, describe data handling/sharing/security, and state retention/deletion practices.

Google Play requires the Ads declaration to be YES when the distributed app contains ads, including banner ads delivered by a third-party ad SDK.

Internal-test-only apps are currently exempt from inclusion in the public Data safety section, but this does not remove the need to prepare truthful declarations before broader distribution.

Official references:
- https://developers.google.com/ad-manager/mobile-ads-sdk/android/next-gen/privacy/play-data-disclosure
- https://support.google.com/googleplay/android-developer/answer/10787469
- https://support.google.com/googleplay/android-developer/answer/10144311
- https://support.google.com/googleplay/android-developer/answer/9859455
- https://support.google.com/googleplay/android-developer/answer/9845334

## W2 Data Safety candidate

For the first ad-enabled artifact, current evidence supports the following candidate mapping.

### Approximate location

Basis:
GMA collects IP address that may be used to estimate general location.

Candidate:
- collected: YES
- shared: YES
- required/optional: REQUIRED_CANDIDATE
- purposes: Advertising or marketing; Analytics; Fraud prevention, security and compliance
- encrypted in transit: YES

### App activity — App interactions

Basis:
GMA collects user product interactions such as app launches/taps/video-view interaction information.

Candidate:
- collected: YES
- shared: YES
- required/optional: REQUIRED_CANDIDATE
- purposes: Advertising or marketing; Analytics; Fraud prevention, security and compliance
- encrypted in transit: YES

### App info and performance — Diagnostics

Basis:
GMA collects diagnostic/performance information.

Candidate:
- collected: YES
- shared: YES
- required/optional: REQUIRED_CANDIDATE
- purposes: Advertising or marketing; Analytics; Fraud prevention, security and compliance
- encrypted in transit: YES

### Device or other IDs

Basis:
GMA collects Android advertising ID, app set ID, and where applicable other device/account identifiers.

Candidate:
- collected: YES
- shared: YES
- required/optional: REQUIRED_CANDIDATE
- purposes: Advertising or marketing; Analytics; Fraud prevention, security and compliance
- encrypted in transit: YES

Why REQUIRED_CANDIDATE:
the current product does not expose a universal all-region opt-out that disables all SDK collection for every user. Play's definition does not permit calling a data type optional merely because some regions have consent choices.

## Data Safety exclusions currently supported

Not declared as app/SDK collection based on current source:
- photo/JPEG content;
- target file-size values;
- generated result bytes;
- filenames;
- share destination;
- name/email/phone/account profile;
- contacts;
- precise GPS location;
- health/financial data;
- custom analytics events.

Explicit Share remains user-initiated. Play's Data safety guidance provides a user-initiated-transfer sharing exception when the user reasonably expects the transfer.

## Ads declaration reconciliation

Historical Internal Testing vc1:
`NO / DOES NOT CONTAIN ADS`

Current S7 source and the next ad-enabled artifact:
`YES / CONTAINS ADS`

Provider/Play action:
change the Play Ads declaration to YES no later than the upload/distribution of the first ad-enabled artifact.

No Play Console mutation is authorized by this document.

## Privacy-policy reconciliation

Known:
- URL supplied: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`
- operator previously confirmed that it opens publicly;
- AdMob has the URL bound to the app.

Independent content verification:
`OPEN`

Reason:
the current CHAT web fetch cannot retrieve the page contents and the repository does not contain the deployed policy body.

Therefore W2 cannot assert that the deployed policy currently discloses:
- GMA/AdMob automatic data collection/sharing;
- UMP/privacy choices;
- third-party advertising parties;
- encryption/security handling;
- retention/deletion practices;
- developer/privacy contact;
- app/developer identification.

## Material source gap

Current app source exposes `Privacy choices` only when UMP requires it.

It does not expose an always-available in-app `Privacy policy` link/text.

Google Play's current User Data policy requires the privacy policy to be available within the app as well as in Play Console.

Disposition:
`BLOCKER_BEFORE_BROADER_RELEASE`

Recommended minimal source fix:
add a persistent `Privacy` or `Privacy policy` control in the app header/about surface that opens the existing HTTPS policy URL through an explicit user action.

This should not upload photos or send photo metadata to the policy site.

## Other open W2 evidence

1. exact merged release manifest after GMA/UMP integration;
2. whether `com.google.android.gms.permission.AD_ID` is present in the merged release manifest;
3. exact release dependency inventory;
4. deployed privacy-policy content;
5. final Play target-audience declaration;
6. final Play Data safety form answers before non-internal distribution.

## W2 verdict

`W2_RECONCILIATION_PARTIAL_PASS_WITH_MATERIAL_PRIVACY_SURFACE_BLOCKER`

PASS:
- post-AdMob data-handling model is now reconciled at source/SDK level;
- Data Safety candidate is defined;
- Ads declaration truth for the next ad-enabled artifact is YES;
- photo content isolation remains consistent with source/runtime evidence.

HOLD before broader Play release:
- persistent in-app privacy-policy link missing;
- deployed privacy-policy content not independently verified;
- merged release manifest / AD_ID exact state not yet captured;
- target-audience declaration remains unresolved.

No Artifact Freeze or production Play release is authorized.
