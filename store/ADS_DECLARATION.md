# ADS_DECLARATION.md

Status: W2 RECONCILED
Date: 2026-10-05

## Historical Internal Testing vc1

Artifact:
`PhotoCompressor-0.1.0-vc1-upload-signed.aab`

Ads implementation:
`NONE`

Truth for that historical artifact:
`NO / DOES NOT CONTAIN ADS`

## Current S7 source / next ad-enabled artifact

Ads implementation:
- GMA Next-Gen integrated;
- one ResultScreen adaptive Banner;
- release variant bound to the existing production Banner ad unit;
- debug variant uses Google's demo Banner unit;
- no interstitial;
- no app-open;
- no rewarded;
- no native.

Play Ads declaration truth for the first distributed ad-enabled artifact:
`YES / CONTAINS ADS`

Google Play's Ads declaration includes banner/display ads delivered by third-party ad SDKs.

## Provider action timing

Change the Play Console Ads declaration to YES no later than upload/distribution of the first ad-enabled artifact.

Do not leave a NO-ADS declaration once an ad-enabled artifact is distributed.

No Play Console mutation or release is authorized by this file.

Reference:
`docs/qa/W2_POST_ADMOB_PRIVACY_DATA_SAFETY_ADS_RECONCILIATION_2026_10_05_v1.0.md`
