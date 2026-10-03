# DATA_SAFETY_DRAFT.md

Status: PRE-ADMOB W1 DRAFT — NOT A PLAY CONSOLE SUBMISSION
Date: 2026-10-03
Package: `com.afradadmedia.reducephotosize`

## Current vc1 shipped behavior

Current Internal Testing vc1 has no AdMob/analytics/network SDK integration.

Core:
- photo selection/inspection/compression/verification is local;
- Save is user initiated;
- Share is explicit/user initiated;
- original is preserved;
- no INTERNET permission is declared in source manifest.

Internal-testing-only apps are currently exempt from the Play Data safety section.

## Planned AdMob delta — not yet shipped

If the approved AdMob architecture is implemented, the ads SDK can add third-party data handling.

Current official GMA disclosure baseline identifies automatic collection/sharing of:
- IP address;
- user product interactions;
- diagnostic information;
- device/account identifiers;
for advertising, analytics and fraud-prevention purposes.

The exact final Data Safety answers MUST be generated from:
1. the exact resolved GMA/UMP versions;
2. merged release manifest;
3. actual enabled SDK features/settings;
4. target audience / consent configuration;
5. any later analytics/mediation additions.

W1 explicitly does NOT approve Firebase Analytics, mediation, custom user IDs, or sending photo content to ads.

## Planned privacy-minimization defaults

- source JPEG bytes: never sent to ads;
- target KB/MB and compression result values: not sent by app code;
- Firebase Analytics: absent;
- custom analytics: absent;
- custom cross-app identity: absent;
- Publisher first-party ID: disabled initially.

## Gate

`DRAFT_ONLY / RECONCILE_AT_W2_AND_W3`

Do not submit this file verbatim to Play Console without current artifact-bound reconciliation.
