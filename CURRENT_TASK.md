# CURRENT_TASK.md

Task ID: W2_TARGET_AUDIENCE_AND_PLAY_DECLARATION_ALIGNMENT
Owner: CHAT_AUDIT + HUMAN_PROVIDER_ACTION
Reviewer: CHAT
Stage: W2_POST_ADMOB_RECONCILIATION
Priority: HIGH
Status: PRIVACY_POLICY_BODY_PASS / TARGET_AUDIENCE_ALIGNMENT_OPEN

## S7

`CLOSED_WITH_DOCUMENTED_PROVIDER_RUNTIME_OBSERVABILITY_EXCEPTION`

## W2 source/artifact

`PASS`

Closed:
- in-app Privacy policy surface;
- merged release manifest;
- AD_ID state;
- release dependency inventory;
- deterministic build/test/lint;
- live Privacy Policy body for current AdMob/GMA/UMP data model.

## Final Privacy Policy evidence

Audit:
`docs/qa/W2_PRIVACY_POLICY_FINAL_RENDERED_BODY_AUDIT_2026_10_05_v1.0.md`

Website production source:
- repo: `whyarby72/apps-afradadmedia`;
- branch: `deploy/production`;
- content blob: `8b01bca9480d341b431ce02c78683e79d52069dd`.

Human browser capture verifies:
- Last updated October 5, 2026;
- affirmative AdMob/UMP wording;
- IP/approximate location;
- user product interactions;
- diagnostics;
- device/account identifiers;
- advertising/analytics/fraud-prevention purposes;
- TLS in transit;
- third-party Google retention boundary;
- developer/privacy contacts.

Disposition:
`PRIVACY_POLICY_BODY_PASS`

## Remaining W2 gates

1. final Play Target audience declaration;
2. final Play Data Safety provider-form reconciliation;
3. Play Ads declaration = YES for the first distributed ad-enabled artifact.

## Target-audience consistency constraint

Current policy statement:
`Photo Compressor: KB Limit is intended for an adult audience aged 18 and over.`

Therefore the current lowest-friction consistent Play declaration candidate is:
`18 and over only`

However, this must be a truthful product-positioning decision, not merely a mechanism to avoid Families requirements.

Do not submit a conflicting age group while the policy remains 18+.

## Next gate

`TARGET_AUDIENCE_DECISION`

Do NOT:
- submit Play declarations yet;
- promote Play tracks;
- Artifact Freeze;
- release/publish the Android app.
