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


## Privacy-policy deployment observation — 2026-10-05

Human screenshot-observed hosting state:
- deployment target: `apps.afradadmedia.com`;
- repository: `whyarby72/apps-afradadmedia.git`;
- deployment mode: manual;
- provider result: `Success`;
- timestamp shown by provider UI: `0s ago`.

Interpretation:
`PRIVACY_POLICY_PATCH_DEPLOYMENT_ATTESTED_BY_HOSTING_UI`

Independent live-body verification:
`STILL_REQUIRED`

Reason:
current CHAT web retrieval cannot access the live policy URL, so the newly deployed rendered body must be verified through a fresh browser capture/PDF or text export.

Next gate:
`POST_DEPLOY_PRIVACY_POLICY_RENDERED_BODY_VERIFICATION`

No Play Console mutation, Artifact Freeze, or production release is authorized by this deployment alone.


## Post-deploy live capture verification — 2026-10-05

New 3-page browser capture still shows the OLD privacy-policy body:
- Last updated remains `October 4, 2026`;
- advertising summary still says `may use Google Mobile Ads`;
- Section 6 still uses generic device/network/advertising/interaction/diagnostic wording;
- Section 10 lacks an explicit third-party Google retention boundary;
- Section 11 lacks the GMA TLS-in-transit statement.

Root-cause audit:
repository `whyarby72/apps-afradadmedia`, branch `deploy/production`, file
`photo-compressor-kb-limit/privacy/index.html`
was independently read and confirmed to still contain the old policy body. The prior manual hosting deployment therefore redeployed unchanged production-branch content.

Recovery performed under the existing privacy-policy deployment authorization:
- patched the actual website production source file;
- website repo commit:
  `6a9106b74cd02dd5f0d32e6b591246a59f7e040f`;
- updated Last updated to October 5, 2026;
- made AdMob/UMP usage affirmative for ad-enabled release;
- enumerated IP/approximate location, product interactions, diagnostics, and device/account identifiers;
- added advertising/analytics/fraud-prevention purposes;
- added GMA TLS statement;
- added explicit third-party Google retention/deletion boundary.

Next action:
`MANUAL_REDEPLOY_APPS_AFRADADMEDIA_FROM_DEPLOY_PRODUCTION`

After redeploy, capture the live privacy page again and verify the new body before closing W2.

No Play Console mutation, Artifact Freeze, or Android production release is authorized.
