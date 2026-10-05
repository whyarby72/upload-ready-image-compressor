# PRIVACY_NOTES.md

Status: W2 POST-ADMOB RECONCILED NOTES
Date: 2026-10-05

## Core data flow

- JPEG selection, inspection, compression, verification, Save, and Share remain local/on-device.
- Original photo is preserved.
- Share is explicit/user initiated.
- App code does not transmit the selected photo or result image to AdMob/analytics.

## Advertising/privacy SDK data flow

Integrated:
- GMA Next-Gen SDK `1.5.0`;
- UMP SDK `4.0.0`.

Current official GMA disclosure states automatic collection/sharing of:
- IP address / approximate general location;
- user product interactions;
- diagnostic information;
- device/account identifiers;
for advertising, analytics, and fraud-prevention purposes.

Google states SDK-collected user data is encrypted in transit.

Publisher first-party ID is disabled in app code.

No Firebase Analytics, mediation, custom analytics, or custom user ID is integrated.

## Consent/privacy controls

- UMP consent information refreshes on launch.
- ad initialization/loading is gated by `canRequestAds()`.
- a `Privacy choices` control is shown when UMP reports that privacy options are required.
- European regulations message is published in AdMob.

## Public privacy-policy URL

`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Known:
- operator confirmed it opens publicly;
- URL is bound in AdMob.

Open:
- CHAT cannot independently fetch the deployed body in the current environment;
- deployed content therefore remains unverified against the current post-AdMob data model.

## Material app-surface gap

The app does not currently provide a persistent in-app `Privacy policy` link/text.

Google Play's current User Data policy requires the privacy policy in Play Console and within the app.

Required before broader release:
add an always-available, explicit in-app Privacy/Privacy policy control opening the existing HTTPS URL.

## Policy-content checklist to verify

The deployed privacy policy should accurately cover at least:
- app/developer identity;
- privacy contact or inquiry mechanism;
- local/on-device photo processing;
- no photo upload for compression;
- AdMob/GMA/UMP involvement;
- SDK data types and purposes;
- third parties/data sharing;
- encryption/security handling;
- retention/deletion practices;
- user privacy-choice mechanism.

## Gate

`PRIVACY_MODEL_RECONCILED / IN_APP_POLICY_LINK_AND_DEPLOYED_CONTENT_VERIFICATION_OPEN`
