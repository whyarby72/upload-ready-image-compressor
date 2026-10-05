# W2 Privacy Policy Final Rendered-Body Audit — 2026-10-05 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Policy URL: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

## Evidence

Human-provided fresh 3-page browser capture after the corrected production-branch patch and manual redeploy.

Website production source:
- repository: `whyarby72/apps-afradadmedia`;
- branch: `deploy/production`;
- file: `photo-compressor-kb-limit/privacy/index.html`;
- verified content blob: `8b01bca9480d341b431ce02c78683e79d52069dd`.

## FACT — rendered live policy

Page 1:
- `Last updated: October 5, 2026`;
- Advertising summary now states the ad-enabled release uses Google Mobile Ads (AdMob) for a banner and UMP for consent/privacy choices where required;
- core local JPEG processing, no Afradad Media server upload for compression, and no-account workflow remain visible.

Page 2:
- Section 6 is now affirmative for the ad-enabled release;
- it explicitly lists:
  - IP address / approximate location;
  - user product interactions;
  - diagnostic/performance information;
  - device/account identifiers including Android advertising ID and app set ID;
- it states advertising, analytics, and fraud-prevention purposes;
- it states GMA data is encrypted in transit using TLS;
- it preserves the separation between local JPEG content and Google advertising processing;
- it states the app does not use Firebase Analytics, custom analytics, or advertising mediation.

Page 3:
- Section 10 now contains a distinct third-party advertising/consent retention boundary;
- Section 11 now contains the GMA TLS-in-transit statement;
- Section 13 still states the app is intended for an adult audience aged 18 and over;
- developer/privacy/support identity and contacts remain present.

## Current official Google baseline checked

Google Play User Data policy:
- privacy policy must be linked in Play Console and accessible in-app;
- must disclose data access/collection/use/sharing and receiving parties;
- must describe secure handling and retention/deletion;
- must identify developer/app and provide privacy contact;
- Data Safety must stay consistent with policy.

Google GMA Next-Gen disclosure:
- IP address;
- user product interactions;
- diagnostics;
- device/account identifiers;
are automatically collected/shared for advertising, analytics, and fraud-prevention purposes, with TLS in transit.

## Verdict

`PRIVACY_POLICY_BODY = PASS_FOR_CURRENT_AD_ENABLED_DATA_MODEL`

The previously identified policy-body blockers are closed:
- AdMob/UMP usage is no longer ambiguous;
- GMA automatic data types are explicit;
- purposes are explicit;
- TLS is explicit;
- third-party retention boundary is explicit;
- page update date reflects the new deployment.

## Remaining independent gate

`TARGET_AUDIENCE_ALIGNMENT = OPEN`

The policy says:
`adult audience aged 18 and over`

This must match the final Play Console Target audience selection. Do not select a contradictory age group.

## Authority boundary

This PASS does not authorize:
- Play Console declaration submission;
- track promotion;
- Artifact Freeze;
- Android production release/publication.
