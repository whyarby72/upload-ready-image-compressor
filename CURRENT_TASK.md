# CURRENT_TASK.md

Task ID: S7_FAST_LANE_ADMOB_PRIVACY_PREPUBLISH
Owner: HUMAN_PROVIDER_ACTION + CHAT_AUDIT
Reviewer: CHAT
Stage: S7_ADMOB_PRIVACY_INTEGRATED_PREPUBLISH
Priority: HIGH
Status: CONSOLIDATED_PREPUBLISH_AUDIT_PASS / PUBLICATION_APPROVAL_REQUIRED

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
- country-selection intent: EEA + UK + Switzerland ON, Everywhere else OFF;
- selected app: Photo Compressor: KB Limit;
- privacy policy URL attached to selected app.

Privacy Policy URL:
`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Operator provider results — 2026-10-05:
- `DRAFT_SAVED`;
- `PRIVACY_URL_OPENS`.

Evidence classification:
- draft-save result: HUMAN_ATTESTED_PROVIDER_ACTION;
- public URL reachability: HUMAN_ATTESTED_BROWSER_CHECK;
- app-selection/privacy-URL binding: SCREENSHOT_OBSERVED.

Fallback consent collection:
`OFF / ACCEPTED_FOR_PRIMARY_UMP_SDK_PATH`

Rationale:
Google documents fallback consent collection as a temporary/secondary mechanism for gaps in the primary CMP path and strongly recommends UMP for apps using Google's CMP. This product already uses the UMP SDK as the primary consent path, so per-app fallback consent collection is not required for the current configuration. Re-evaluate only if maximize-message-coverage/account-level settings create a material conflict.

Production AdMob ID binding:
`NOT_AUTHORIZED`

European-regulations message Publish:
`NOT_AUTHORIZED`

## Consolidated pre-Publish audit — 2026-10-05

Disposition:
`PASS_READY_FOR_SCOPED_EU_MESSAGE_PUBLICATION_APPROVAL`

PASS:
- correct app selected;
- required privacy-policy URL is present and operator-confirmed publicly reachable;
- message draft saved;
- three-choice consent layout configured;
- regional targeting limited to EEA + UK + Switzerland;
- fallback consent collection may remain OFF because UMP is the primary CMP implementation;
- no provider warning/error was reported in the fast-lane completion result.

Open but non-blocking for EU-message publication:
- production AdMob IDs are still not bound to release code;
- post-publication UMP/runtime behavior with real app configuration remains to be verified;
- broader Play production compliance and Data Safety remain later-stage work.

## Next action

Human must explicitly choose whether to authorize:
`PUBLISH EUROPEAN REGULATIONS MESSAGE ONLY`

If approved, permitted:
- click `Publish` for `Photo Compressor EU Consent v1`;
- wait for provider confirmation;
- report the resulting message state.

Hard stop immediately after message publication confirmation.

Not authorized by this approval:
- production AdMob ID binding;
- source-code mutation;
- new ad-unit creation;
- Play release/promotion;
- Artifact Freeze;
- production release/publication of the Android app.

## Hard stop

Do NOT publish the European-regulations message until the scoped approval above is explicit.
