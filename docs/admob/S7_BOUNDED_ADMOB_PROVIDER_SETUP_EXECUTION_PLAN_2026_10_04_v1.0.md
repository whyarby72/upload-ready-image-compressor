# S7 bounded AdMob provider setup execution plan — 2026-10-04 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT  
Scope: `S7 BOUNDED ADMOB PROVIDER SETUP`  
Authorization: `USER_OPTION_1_2026-10-04_S7_BOUNDED_ADMOB_PROVIDER_SETUP`

## Safety precheck

Before creating anything in AdMob:
1. Open AdMob > Apps > View all apps.
2. Search for an existing app matching the product/app identity.
3. If an existing candidate is found, STOP and reconcile instead of creating a duplicate.

Reason: AdMob apps cannot be deleted after setup; they can only be hidden.

## App setup

Create only if no existing candidate exists.

- Platform: Android
- Listed on supported app store?: No
- AdMob state: Unpublished
- App name: `Photo Compressor: KB Limit`
- Intended Android package identity: `com.afradadmedia.reducephotosize`
- Firebase / Google Analytics: do not link
- User metrics: do not enable if the UI presents it as optional

Record:
- provider-generated AdMob App ID
- app status/state
- creation timestamp

## One banner ad unit only

Create exactly one Banner ad unit.

Recommended internal name:
`ResultScreen_Banner_v1`

Keep default ad-type configuration unless the UI requires an explicit selection.
Do not create:
- interstitial;
- app-open;
- rewarded;
- native;
- second banner;
- mediation group.

Record the generated banner ad-unit ID.

## European regulations Privacy & messaging

Create/configure one European regulations message for this app.

Bounded configuration:
- select only this app;
- use a clear non-deceptive consent surface;
- prefer the three-choice structure when offered: Do not consent / Consent / Manage options;
- do not enable unrelated analytics integrations;
- do not add custom vendor/legal-basis overrides without a separate compliance review.

If the provider presents `Publish`, `Activate`, or equivalent as a distinct final action:
STOP before that action under the current authorization.

Record:
- message name;
- selected app;
- message status (draft/configured);
- whether a distinct publish action is pending.

## Important code evidence debt discovered before production binding

Current ResultScreen is inside a vertically scrollable Compose column, while the S7 TEST implementation calls:
`AdSize.getLargeAnchoredAdaptiveBannerAdSize(...)`.

Google's banner guidance distinguishes:
- anchored adaptive banners: anchored to top/bottom;
- inline adaptive banners: intended for scrollable content.

Therefore:
`BANNER_PLACEMENT_API_MISMATCH_REVIEW_REQUIRED`

Do not bind real provider IDs into production/release code until this is resolved under a separate code-change authorization.

## Hard stop

Stop after:
- unpublished app exists;
- real AdMob App ID is recorded;
- exactly one Banner ad unit exists and its ID is recorded;
- one European regulations message is configured as draft/configured;
- no distinct final message publication has been executed.

No Play mutation, public linking, app-ads.txt publication, production-ID code binding, mediation, Firebase Analytics, S8, BUILD promotion, Artifact Freeze, release, or publication.
