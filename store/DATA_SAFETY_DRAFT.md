# DATA_SAFETY_DRAFT.md

Status: W2 RECONCILED CANDIDATE — NOT YET A PLAY CONSOLE SUBMISSION
Date: 2026-10-05
Package: `com.afradadmedia.reducephotosize`

## Artifact scope

This draft applies to the first AdMob-enabled artifact derived from the current S7 source.

Current monetization stack:
- GMA Next-Gen SDK `1.5.0`;
- UMP SDK `4.0.0`;
- one ResultScreen Banner;
- no Firebase Analytics;
- no mediation;
- no custom analytics;
- no custom user ID;
- Publisher first-party ID disabled.

## Core user-content handling

- JPEG selection/inspection/compression/verification is local/on-device.
- Save is explicit and user initiated.
- Share is explicit and user initiated.
- Original is preserved.
- App code does not send source/result JPEG bytes, target KB/MB, filenames, or share destinations to AdMob/analytics.

## Third-party SDK collection/sharing candidate

Google's current GMA Next-Gen disclosure states the SDK automatically collects and shares the following for advertising, analytics, and fraud prevention.

### Approximate location

Source:
IP address may be used to estimate general location.

Play candidate:
- collected: YES
- shared: YES
- optional: NO / REQUIRED_CANDIDATE
- purposes:
  - Advertising or marketing
  - Analytics
  - Fraud prevention, security and compliance
- encrypted in transit: YES

### App activity — App interactions

Source:
user product interactions including app launch/taps/interaction information.

Play candidate:
- collected: YES
- shared: YES
- optional: NO / REQUIRED_CANDIDATE
- purposes:
  - Advertising or marketing
  - Analytics
  - Fraud prevention, security and compliance
- encrypted in transit: YES

### App info and performance — Diagnostics

Play candidate:
- collected: YES
- shared: YES
- optional: NO / REQUIRED_CANDIDATE
- purposes:
  - Advertising or marketing
  - Analytics
  - Fraud prevention, security and compliance
- encrypted in transit: YES

### Device or other IDs

Source:
Android advertising ID, app set ID, and where applicable other device/account identifiers.

Play candidate:
- collected: YES
- shared: YES
- optional: NO / REQUIRED_CANDIDATE
- purposes:
  - Advertising or marketing
  - Analytics
  - Fraud prevention, security and compliance
- encrypted in transit: YES

## Why not optional

Google Play says a data type may be declared optional only when all users, regardless of device or region, can choose whether that data is collected.

The current app does not provide a universal all-region opt-out that disables all GMA collection for every user.

## Not currently evidenced as collected by app code

- JPEG/photo content;
- generated result image bytes;
- target KB/MB value;
- filenames;
- share destination;
- name;
- email;
- phone;
- contacts;
- precise GPS location;
- health or financial data.

User-initiated Share is treated separately under Play's user-initiated transfer guidance.

## Security

Google's current GMA disclosure states SDK-collected user data is encrypted in transit using TLS.

## Open evidence before final submission

- capture exact merged release manifest;
- determine exact AD_ID permission state;
- capture final release dependency inventory;
- independently verify deployed privacy-policy content;
- reconcile target-audience declaration;
- reconcile actual Play Console form wording at time of submission.

## Internal testing note

Apps active only on the Internal Testing track are currently exempt from inclusion in the public Data safety section.

This exemption does not justify inaccurate later declarations and does not authorize broader release.

## Gate

`W2_CANDIDATE_READY / FINAL_PLAY_SUBMISSION_HOLD`

Reference:
`docs/qa/W2_POST_ADMOB_PRIVACY_DATA_SAFETY_ADS_RECONCILIATION_2026_10_05_v1.0.md`


## W2 artifact-bound release reconciliation — 2026-10-05

Source commit:
`8e5b4d66967e81c486affc19f573f699b5feb393`

CI:
`PASS` — run `37257297047`

Merged release manifest:
`CAPTURED`

AD_ID permission:
`PRESENT`

Resolved release dependency focus:
- GMA Next-Gen `1.5.0`;
- UMP `4.0.0`;
- Play Services Ads Identifier `18.0.0`;
- Play Services App Set `16.0.1`.

Merged manifest also contains `READ_BASIC_PHONE_STATE`; Android documents this as a non-dangerous permission. No photo/media/location dangerous runtime permission is present.

Artifact audit:
`docs/qa/W2_MINIMAL_PRIVACY_LINK_ARTIFACT_AUDIT_RESULT_2026_10_05_v1.0.md`
