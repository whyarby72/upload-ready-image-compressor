# CURRENT_TASK.md

Task ID: W2_PRIVACY_POLICY_REVISION_AND_TARGET_AUDIENCE_ALIGNMENT
Owner: HUMAN_WEB_DEPLOYMENT + CHAT_AUDIT
Reviewer: CHAT
Stage: W2_POST_ADMOB_RECONCILIATION
Priority: HIGH
Status: PRIVACY_POLICY_BODY_PARTIAL_PASS / REVISION_REQUIRED / TARGET_AUDIENCE_OPEN

## S7

`CLOSED_WITH_DOCUMENTED_PROVIDER_RUNTIME_OBSERVABILITY_EXCEPTION`

## W2 source/artifact

`PASS`

Closed:
- in-app Privacy policy surface;
- merged release manifest evidence;
- AD_ID state;
- release dependency inventory;
- deterministic build/test/lint.

## Live privacy-policy body evidence

Evidence:
user-provided 3-page rendered capture of:
`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Audit:
`docs/qa/W2_PRIVACY_POLICY_BODY_AUDIT_2026_10_05_v1.0.md`

Patch candidate:
`store/PRIVACY_POLICY_REQUIRED_PATCH_v1.0.md`

## Policy PASS

The current live page includes:
- app/developer identity;
- privacy contact;
- local photo-processing truth;
- Save/Share/temporary-file behavior;
- no account/cloud requirement;
- AdMob + UMP disclosure;
- privacy choices;
- analytics statement;
- retention/deletion section;
- security section;
- children's privacy/target-audience section;
- policy-change section.

## Required revisions before broader release

1. explicitly enumerate GMA automatic data types:
   - IP / approximate location;
   - user product interactions;
   - diagnostics;
   - device/account identifiers;
2. explicitly state advertising / analytics / fraud-prevention purposes and Google sharing;
3. replace ambiguous `may use AdMob` wording for the ad-enabled release;
4. add concrete GMA TLS-in-transit security statement;
5. add Google third-party retention/deletion boundary;
6. reconcile policy's `18 and over` statement with the final Play Target audience declaration;
7. update Last updated date when revisions are deployed.

## Next recommended gate

`DEPLOY_PRIVACY_POLICY_PATCH`

After deployment:
- capture the live page again;
- CHAT verifies the rendered body;
- then resolve Play Target audience;
- then bind final Data Safety + Ads declarations to the exact release artifact/current Play form.

Do NOT:
- promote Play tracks;
- Artifact Freeze;
- release/publish the Android app.
