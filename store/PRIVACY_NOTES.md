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

## In-app privacy-policy surface

W2 fix authorized on 2026-10-05:
the app now exposes an always-available `Privacy policy` text control in the shared app header.

Behavior:
- explicit user action only;
- opens the existing HTTPS policy URL through a plain ACTION_VIEW intent;
- does not attach photo bytes, target size, filename, result metadata, or share destination.

This closes the app-surface privacy-policy-link gap subject to build/runtime verification.

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
