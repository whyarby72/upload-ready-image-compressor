# W2 Privacy Policy Body Audit — 2026-10-05 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Policy URL: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`
Evidence: user-provided 3-page rendered capture of the live policy page.

## Verdict

`PARTIAL_PASS_WITH_REQUIRED_REVISION_BEFORE_BROADER_RELEASE`

The live policy is materially stronger than the prior unknown state and already covers most product-specific privacy facts. It is not yet a clean final PASS for the ad-enabled release because several Google Mobile Ads disclosures are still too generic and the policy's 18+ audience statement must be reconciled with the Play target-audience declaration.

## PASS — source/page evidence

The live policy visibly includes:
- clear title: Privacy Policy;
- app name: Photo Compressor: KB Limit;
- Android package: `com.afradadmedia.reducephotosize`;
- last-updated date;
- Afradad Media identity;
- privacy and support contact emails;
- website;
- core on-device JPEG compression;
- statement that selected photos are not uploaded to Afradad Media servers for compression;
- local handling of file metadata and EXIF orientation;
- temporary-result, Save, Share, and original-photo behavior;
- no account/login requirement;
- no developer-owned cloud photo store for the core job;
- Google Mobile Ads / AdMob and UMP named;
- no Firebase Analytics, custom analytics, or mediation;
- consent/privacy choices discussion;
- permissions/system-access discussion;
- local retention/deletion behavior;
- security section;
- user choices;
- children's privacy / target-audience section;
- changes-to-policy section.

## Required revision 1 — make GMA data types explicit

Current section 6 says Google services may process broad classes such as device, network, advertising, interaction, diagnostic, or fraud-prevention related information.

For the current GMA Next-Gen SDK baseline, the policy should explicitly name:
- IP address, which may be used to estimate general/approximate location;
- user product interactions;
- diagnostic/performance information;
- device and account identifiers, including Android advertising ID and app set ID where applicable.

It should also explicitly say these are collected/shared by Google Mobile Ads for:
- advertising;
- analytics;
- fraud prevention/security/compliance.

Reason:
Google Play requires the privacy policy to disclose the types of user/device data and the parties with which data is shared, while Google's current GMA Next-Gen disclosure names these specific automatic data types.

## Required revision 2 — remove uncertainty for the ad-enabled release

The current wording:
`may use Google Mobile Ads`

is too conditional for the ad-enabled artifact now being prepared.

For the ad-enabled release, use affirmative wording such as:
`The ad-enabled release uses Google Mobile Ads (AdMob) to display a banner advertisement and uses Google's User Messaging Platform (UMP) to manage consent/privacy choices where required.`

If the same policy intentionally governs both old no-ads and new ad-enabled releases, keep the version distinction explicit rather than using ambiguous `may use`.

## Required revision 3 — concrete secure handling

The current security section correctly says no method is perfectly secure, but it does not state a concrete transport-security fact for the advertising SDK.

Add:
`Google states that data collected by the GMA Next-Gen SDK is encrypted in transit using Transport Layer Security (TLS).`

Do not imply that local photos are uploaded or cloud-encrypted by Afradad Media when they are not.

## Required revision 4 — third-party retention boundary

The current retention section clearly covers:
- temporary local cache;
- saved copies;
- shared files;
- no Afradad Media server copy of selected photos.

Add an explicit third-party boundary:
- Afradad Media does not control Google's retention/deletion of advertising and consent data;
- Google-handled data is subject to Google's own retention/privacy practices.

This prevents the local-only retention section from being read as if it also governs AdMob data.

## Required reconciliation 5 — 18+ target-audience statement

Section 13 says:
`Photo Compressor: KB Limit is intended for an adult audience aged 18 and over.`

This is a binding policy statement and must match the final Play Console Target audience and content declaration.

Current project state:
`TARGET_AUDIENCE_PLAY_DECLARATION = OPEN`

Do not submit a contradictory Play target-audience selection.

## Recommended maintenance edits

- change the policy updated date when these revisions are deployed;
- keep app/developer identity exactly aligned with the Play listing;
- retain the statement that source JPEG bytes and entered KB/MB targets are not intentionally sent to Google Mobile Ads;
- optionally link to Google's privacy policy / advertising privacy information for third-party details.

## Current official baseline used

Google Play privacy-policy requirements:
- in-app and Play Console access;
- developer information / privacy contact;
- types of personal/sensitive user data and sharing parties;
- secure data handling;
- retention/deletion policy;
- active public non-geofenced non-editable web URL.

GMA Next-Gen current automatic data disclosure:
- IP address/general location;
- user product interactions;
- diagnostics;
- device/account identifiers;
- advertising, analytics, fraud-prevention purposes;
- TLS encryption in transit.

## Final disposition

`POLICY_STRUCTURE_AND_PRODUCT_TRUTH = PASS`

`POST_ADMOB_DATA_SPECIFICITY = REVISION_REQUIRED`

`SECURITY_SPECIFICITY = REVISION_REQUIRED`

`THIRD_PARTY_RETENTION_BOUNDARY = REVISION_REQUIRED`

`TARGET_AUDIENCE_ALIGNMENT = HOLD_PENDING_PLAY_DECLARATION`

No Play production release / Artifact Freeze is authorized by this audit.
