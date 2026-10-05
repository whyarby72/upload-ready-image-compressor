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


## Target audience decision intent — 2026-10-05

Human selection:
`USER_OPTION_1_2026-10-05_PROCEED_TARGET_AUDIENCE_18_PLUS_ONLY`

Current official Google Play baseline rechecked:
- Target audience must reflect the users the app is actually designed for.
- `18 and over` can be selected as the only target group for an adult-designed app.
- Restrict Minor Access is a separate optional control for adult-only apps unless a restricted-content policy specifically requires it.

Product-positioning evidence:
- current listing is a practical utility for strict upload limits, job applications, websites, portals, and email attachments;
- no child-directed characters, school-age positioning, or youth-specific feature set is present in the current listing;
- current live privacy policy already states the app is intended for an adult audience aged 18 and over.

Decision scope:
`PROCEED_TO_PLAY_TARGET_AUDIENCE_REVIEW_WITH_18_AND_OVER_ONLY_AS_CANDIDATE`

Important:
- do not Save/Submit yet;
- do not enable Restrict Minor Access merely to simplify compliance;
- review the actual Play screen first and verify that the declaration remains truthful for the current product positioning.

Next provider action:
open Play Console > Policy > App content > Target audience and content > Start/Manage, then return screenshot before Save.
