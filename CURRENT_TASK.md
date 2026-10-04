# CURRENT_TASK.md

Task ID: S7_FAST_LANE_ADMOB_PRIVACY_PREPUBLISH
Owner: HUMAN_PROVIDER_ACTION + CHAT_AUDIT
Reviewer: CHAT
Stage: S7_ADMOB_PRIVACY_INTEGRATED_PREPUBLISH
Priority: HIGH
Status: FAST_LANE_ACTIVE / PUBLICATION_HOLD

## Fast-lane activation

Approval ref:
`USER_OPTION_1_2026-10-05_ACTIVATE_FAST_LANE_SIMPLE_APP`

Purpose:
reduce ceremony and repeated screenshot-by-screenshot review for this simple Android utility while preserving required compliance, evidence, and human authority boundaries.

Fast-lane rules:
- batch reversible provider steps where the intended configuration is already resolved;
- do not require a screenshot after every ordinary toggle or navigation step;
- use one consolidated pre-Publish audit instead of repeated micro-gates;
- stop only for material policy/compliance conflict, unexpected provider warning/error, production credential/ID binding, destructive/irreversible action, Artifact Freeze, release, or publication;
- never infer a PASS from a failed/partial provider action.

## Current verified product/provider state

Product:
`Photo Compressor: KB Limit`

Package:
`com.afradadmedia.reducephotosize`

Branch:
`task/TASK-S7-001`

AdMob app:
`CREATED`

Exactly one Banner unit:
`CREATED`

European regulations message:
`Photo Compressor EU Consent v1`

Current message configuration observed:
- default language: English (en);
- Consent: ON;
- Manage options: ON;
- Do not consent: ON;
- Close (do not consent): OFF;
- targeting: Countries subject to GDPR (EEA, UK, and Switzerland);
- country-selection intent: EEA + UK + Switzerland ON, Everywhere else OFF.

Privacy Policy URL supplied:
`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Privacy Policy verification state:
`OPERATOR_ATTESTED_URL / INDEPENDENT_REACHABILITY_CONTENT_VERIFICATION_OPEN`

Production AdMob ID binding:
`NOT_AUTHORIZED`

European-regulations message Publish:
`NOT_AUTHORIZED`

## Fast-lane next action

Operator may perform the following reversible preparation without returning to CHAT after every click:

1. press `Save draft` if the current message has unsaved changes;
2. verify the Privacy Policy URL opens publicly in a normal/private browser without login;
3. do not change account-level GDPR settings unless an explicit warning/error requires investigation;
4. if AdMob shows an unexpected warning, error, policy issue, or configuration conflict, STOP and report it;
5. otherwise return once with the concise result:
   - `DRAFT_SAVED`;
   - `PRIVACY_URL_OPENS`;
   - any visible warning/error, if present.

CHAT then performs one consolidated pre-Publish compliance review.

## Hard stop

Do NOT:
- click `Publish`;
- bind production AdMob IDs into release code;
- mutate signing/key material;
- promote to production;
- grant Artifact Freeze;
- release or publish.

Final publication requires a new explicit human approval bound to the exact reviewed scope.
