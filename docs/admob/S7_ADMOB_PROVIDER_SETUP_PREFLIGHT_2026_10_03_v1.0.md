# S7 AdMob provider setup preflight — READ ONLY — 2026-10-03

Product: PHOTO COMPRESSOR: KB LIMIT
Scope: S7 ADMOB PROVIDER SETUP PREFLIGHT ONLY
Mutation authority: NONE

## Current project state

- Android package: `com.afradadmedia.reducephotosize`
- Current Play distribution: internal testing/private, not public production listing.
- S7 code already contains GMA Next-Gen and UMP TEST integration.
- Current TEST build uses Google sample App ID and sample adaptive banner unit ID only.
- Runtime core/offline validation passed; banner/UMP/privacy-options provider-bound paths remain unobserved.

## Official-provider findings

### 1. Published-app linking is not available yet

Google AdMob requires an Android app to be publicly available in a supported store before it can be linked as a published app. Private Google Play apps cannot be linked.

Implication:
the current internal-testing-only Play state is insufficient for published-app linking/readiness review.

### 2. Unpublished AdMob app setup is available for pre-release testing

AdMob supports adding an Android app as unpublished for testing before the app is publicly listed.

Implication:
if later authorized, a bounded provider setup can create an unpublished AdMob app first, then link it to the public Play listing later.

### 3. Full ad serving/readiness remains downstream of public-store linking and review

New apps undergo app readiness review before full ad serving. A review can begin once the app is correctly set up and linked to a supported public store.

### 4. app-ads.txt is part of ownership verification

For new AdMob apps, app ownership verification uses app-ads.txt.
AdMob must be able to find the developer website from the public store listing.
The file must include the account-specific publisher ID snippet.

Current blockers:
- no bound public developer website/domain in project state;
- no publisher-specific app-ads.txt snippet exists yet because the AdMob app/account identity has not been bound;
- current private/internal Play state cannot serve as the final public-store linkage.

### 5. App ID and ad unit ID are provider-created identities

Adding an app to AdMob creates its unique AdMob App ID.
Creating a banner ad unit creates the ad-unit ID that must later replace the Google sample banner ID.

For this product, the planned production format remains:
- one adaptive banner;
- ResultScreen only;
- no interstitial/app-open/rewarded/native;
- no mediation initially.

### 6. Privacy & messaging depends on AdMob app presence

Apps available for Privacy & messaging are sourced from apps already added in AdMob.
UMP must be integrated in the app for messages to display.

Current code already integrates UMP.
Provider-side privacy message configuration is still absent.

### 7. Deterministic UMP test path exists

Google UMP supports registering a physical test device and forcing a debug geography, including EEA, using `ConsentDebugSettings`.
This can later prove the consent-required path without changing the real user's location or targeting all production users.

A provider-side European-regulations message must still exist for the form to be available.

### 8. Firebase/Analytics is not required for the initial ad-serving path

Current AdMob user-metrics functionality relies on Firebase/Google Analytics integration.
The current product architecture deliberately excludes Firebase Analytics/custom analytics.

Preflight recommendation:
do not add Firebase/Analytics merely to make initial banner monetization work. Keep analytics out until a separate business/evidence case justifies it.

## Read-only preflight verdict

`PREFLIGHT_PASS_PROVIDER_MUTATION_NOT_YET_AUTHORIZED`

The safest bounded next provider action, if separately approved, is:

1. add the Android app to AdMob as **unpublished**;
2. record its real AdMob App ID;
3. create exactly one standard banner ad unit for ResultScreen and record its ID;
4. create/configure a European-regulations Privacy & messaging message;
5. do not enable mediation, additional ad formats, Firebase Analytics, or production rollout;
6. use a registered test device / UMP debug geography to prove consent and banner runtime paths;
7. defer final published-app linking, app-ads.txt verification, readiness review, and full ad serving until a public Play listing + developer website exist.

## Hard stop

No AdMob app/account mutation, ad-unit creation, message publication, app-ads.txt publication, Play Console mutation, production-ID binding, release, or publication was performed by this preflight.
