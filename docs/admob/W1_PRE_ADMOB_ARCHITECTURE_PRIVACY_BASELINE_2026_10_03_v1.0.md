# W1 PRE-ADMOB ARCHITECTURE + PRIVACY BASELINE — 2026-10-03 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Canonical decision: `TEST`
Input baseline: S5 closed PASS with Play-distributed physical-device runtime PASS
Scope: architecture/reconciliation only; no AdMob source integration is authorized by this document.

## Verdict

`W1_PASS_ARCHITECTURE_BASELINE_READY_FOR_S7_IMPLEMENTATION_APPROVAL`

The core app is suitable for a deliberately small AdMob layer without changing the buyer job.

## 1. Source/product reconciliation

Binding product law:
- core job is photo -> explicit KB/MB limit -> local compression -> exact-byte result truth -> Save/Share;
- no ad may block CURRENT detection, result proof, Save, or Share;
- no monetization before first verified buyer value;
- ad failure must not block the core job;
- source image content must remain local and must not be sent to ads/analytics.

Current implementation matches the non-monetized baseline:
- `MainActivity` has Home, Requirement, Processing, Result, Failure states;
- ResultScreen exposes result proof before Save/Share/Compress another;
- core processing is local;
- no AdMob, analytics, Firebase, networking SDK, or backend dependency is present.

## 2. Current permission / manifest baseline

Current source manifest:
- no explicit Android permissions;
- no INTERNET permission;
- no broad storage/media permission;
- only MainActivity is exported for launcher;
- ResultContentProvider is not exported;
- allowBackup=false.

This is the W1 pre-AdMob permission truth.

Expected post-AdMob delta:
- GMA/UMP may contribute network/data-related manifest entries through merged manifests;
- final merged release manifest must be audited after integration;
- no new photo/storage/sensitive runtime permission is allowed solely for monetization.

Any new sensitive permission requirement => HOLD.

## 3. SDK strategy

Preferred fresh-integration candidate:
- Google Mobile Ads GMA Next-Gen SDK, current official line at W1 research: `1.4.0`;
- Google UMP SDK, current official line: `4.0.0`;
- no mediation in first monetization iteration;
- no Firebase Analytics;
- no custom analytics;
- no dynamic dependency versions;
- resolved dependency graph must be recorded by Codex after implementation.

Reason:
- this is a new AdMob integration rather than a migration;
- current app minSdk 29 / compileSdk 37 satisfies current Next-Gen prerequisites;
- keeping mediation/analytics out minimizes data, policy, supply-chain and maintenance surface.

Implementation version numbers are mutable facts and must be reverified immediately before coding.

## 4. Monetization experience contract

Initial monetization format:
`ONE_IN_FLOW_ADAPTIVE_BANNER_ON_RESULT_ONLY`

Placement:
- only on ResultScreen;
- after result proof;
- after Save / Share / Compress another controls;
- never between result proof and buyer-critical actions;
- not sticky over navigation or gesture areas;
- no banner on Home, Requirement, Processing, Failure, dialogs, picker or permission flows.

Request timing:
- never before first verified result exists;
- only when UMP says ads may be requested;
- one banner container per ResultScreen instance;
- no custom rapid refresh/frequency manipulation.

Failure behavior:
- no fill / timeout / offline / consent denial must collapse to no-ad behavior;
- no blocking spinner;
- no retry loop visible to the user;
- core result, Save, Share and Compress another remain fully usable.

Deferred formats:
- interstitial: OFF for initial monetization integration;
- app open: OFF;
- rewarded: OFF;
- native: OFF.

Rationale:
this utility has no feed or value-exchange surface, and early interstitial/app-open monetization would add first-value, accidental-click and retention risk without behavioral evidence.

## 5. Consent architecture

Required sequence:
1. On each app launch, obtain fresh consent information through UMP.
2. Display required privacy form when applicable.
3. Check `canRequestAds()`.
4. Only when ads may be requested, initialize/configure the GMA SDK and allow ad loading.
5. Make initialization idempotent so repeated consent callbacks cannot duplicate setup.
6. If consent flow errors and ads cannot be requested, continue core app with ads disabled.

Privacy options:
- when UMP reports that a privacy-options entry point is required, expose a visible, interactive `Privacy choices` control;
- do not hide the entry point behind the ad itself;
- privacy controls must remain usable independent of ad load state.

## 6. Privacy-policy surface architecture

Before broader release / AdMob consent-message readiness:
- create a public HTTPS privacy-policy URL;
- bind the same URL in Play Console;
- add an in-app `Privacy` entry point available from the app UI;
- policy must distinguish local photo processing from third-party advertising data processing.

Opening the privacy-policy URL must be explicit/user initiated.

## 7. Data boundary after AdMob

Core user content:
- JPEG bytes remain local;
- no photo content, derived image bytes, target KB/MB values, result bytes, filenames or Share destinations may be sent to AdMob/analytics by app code.

Current official GMA disclosure baseline indicates the ads SDK can automatically collect/share:
- IP address / approximate general location derived from IP;
- user product interactions;
- diagnostic information;
- device/account identifiers;
for advertising, analytics and fraud-prevention purposes.

This creates a real privacy/Data Safety delta from the current local-only core.

No Firebase Analytics or optional advanced reporting is approved in this W1 architecture.

## 8. Identifier minimization

W1 default:
- disable Publisher first-party ID in the first AdMob integration unless a later evidence-backed monetization test justifies enabling it;
- do not create a custom user ID;
- do not add cross-app identity;
- do not link Firebase Analytics.

Advertising-ID / other default GMA identifier behavior must be reconciled against the exact SDK/configuration during W2/W3; do not guess Data Safety answers from architecture alone.

## 9. Google Play disclosure delta

Current vc1:
- no ads integrated;
- current ads declaration truth remains `NO ADS` for vc1.

First ad-enabled artifact:
- Play Ads declaration must change to `YES / CONTAINS ADS`;
- privacy policy must cover ads/SDK data practices;
- Data Safety must be completed/reconciled before closed/open/production as applicable;
- internal-testing-only exemption does not remove the need to prepare truthful later-stage declarations.

Do not change Play declarations before an ad-enabled artifact actually exists.

## 10. app-ads.txt / AdMob readiness architecture

Before full monetization readiness:
- establish a developer website/domain;
- link that developer website from the Play listing;
- publish app-ads.txt at the required site location with the exact AdMob publisher entry;
- verify app-ads.txt in AdMob;
- complete AdMob app verification / readiness review.

New AdMob apps are currently subject to app-ads.txt verification and app-readiness review before full ad serving.

Unknown:
whether the current internal-only Play state will be sufficient for every AdMob published-app/readiness step. Verify in the account UI when AdMob app setup is authorized.

## 11. Target audience / child constraints

Current project artifacts do not establish a final Play target-audience declaration.

Therefore:
`TARGET_AUDIENCE_AD_POLICY = UNKNOWN_PENDING_TRUTHFUL_PLAY_DECLARATION`

Do not hard-code child-directed / under-age treatment flags merely to simplify policy.

If the app later includes children in its declared audience, Families/child-directed ad constraints must be re-audited before ad serving.

## 12. Account actions still human-controlled

W1 does not authorize:
- creating/linking the AdMob app;
- creating production ad units;
- publishing Privacy & messaging messages;
- changing Play ads/Data Safety declarations;
- publishing a privacy-policy website;
- production/live ad serving.

Those provider actions require separately bounded execution when needed.

## 13. Coding acceptance for next step

A future S7/Codex integration should prove at minimum:
- core baseline remains green;
- no source image content reaches ads code;
- no new sensitive runtime permission;
- UMP refresh on launch;
- privacy form path;
- privacy-options path;
- ad request gate on `canRequestAds()`;
- idempotent SDK initialization;
- test ads only in QA;
- result-only banner placement after core actions;
- ad/no-fill/error/offline never blocks buyer job;
- merged manifest + dependency inventory recorded;
- first-party publisher ID disabled per W1 default;
- exact post-integration artifact hash/version recorded.

## 14. W1 blockers vs later blockers

No blocker to architecture completion.

External dependencies before real ad serving:
- AdMob app/account setup;
- AdMob App ID and banner ad-unit ID;
- public privacy-policy URL;
- developer website/domain for app-ads.txt;
- target-audience declaration;
- Privacy & messaging configuration.

These are provider/configuration dependencies, not reasons to contaminate core source before the S7 coding scope is approved.

## Final disposition

`W1_PRE_ADMOB_RECONCILIATION = PASS`

`S7_ADMOB_PRIVACY_IMPLEMENTATION = NOT_AUTHORIZED`

Recommended next step:
authorize a narrow Codex implementation contract for GMA Next-Gen + UMP + one ResultScreen banner using test ads and no production account mutation.
