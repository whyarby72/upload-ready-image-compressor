# CURRENT_TASK.md

Task ID: W2_PROVIDER_POLICY_CONTENT_AND_PLAY_DECLARATIONS
Owner: CHAT_AUDIT + HUMAN_PROVIDER_ACTION
Reviewer: CHAT
Stage: W2_POST_ADMOB_RECONCILIATION
Priority: HIGH
Status: SOURCE_AND_ARTIFACT_AUDIT_PASS / PROVIDER_POLICY_CONTENT_AND_DECLARATIONS_OPEN

## S7

`CLOSED_WITH_DOCUMENTED_PROVIDER_RUNTIME_OBSERVABILITY_EXCEPTION`

## W2 source fix

Human authorization:
`USER_OPTION_1_2026-10-05_W2_MINIMAL_COMPLIANCE_FIX_ARTIFACT_AUDIT`

Implemented:
- persistent in-app `Privacy policy` control;
- explicit ACTION_VIEW to:
  `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`;
- no photo content or photo metadata attached to the intent.

Source commit:
`8e5b4d66967e81c486affc19f573f699b5feb393`

## W2 deterministic verification

Audit:
`docs/qa/W2_MINIMAL_PRIVACY_LINK_ARTIFACT_AUDIT_RESULT_2026_10_05_v1.0.md`

GitHub Actions:
- run `37257297047`;
- job `111597008413`;
- assembleDebug PASS;
- assembleRelease PASS;
- unit tests PASS;
- lint PASS;
- W2_ARTIFACT_AUDIT_PASS;
- CI_VERIFY_PASS.

Artifact:
- name: `w2-artifact-audit`;
- id: `11323640997`;
- digest: `sha256:96224ef93763cf18382ac21eac08b5a67e9bab3ac1afc337fd43dab0ec25f630`.

## Merged release manifest FACT

AdMob App ID:
`ca-app-pub-8084313520610270~1492953098`

Permissions:
- INTERNET;
- ACCESS_NETWORK_STATE;
- READ_BASIC_PHONE_STATE;
- AD_ID;
- WAKE_LOCK;
- FOREGROUND_SERVICE;
- app-scoped signature dynamic-receiver permission.

AD_ID:
`PRESENT`

No photo/media/location dangerous runtime permission observed.

## Release dependency FACT

- GMA Next-Gen `1.5.0`;
- UMP `4.0.0`;
- Play Services Ads Identifier `18.0.0`;
- Play Services App Set `16.0.1`.

Unsigned release APK SHA-256:
`df8ad4babe583bae7bf5f125ec7917803a25e01fbdd7a0353312d71a971c936e`

## W2 closed

- in-app privacy-policy source surface;
- merged release manifest evidence;
- AD_ID state;
- dependency inventory;
- deterministic build/test/lint.

## W2 open

1. deployed privacy-policy body content verification;
2. final target-audience declaration;
3. final Play Data Safety provider-form reconciliation;
4. Ads declaration must become YES for the first distributed ad-enabled artifact.

## Next recommended gate

`PRIVACY_POLICY_BODY_VERIFICATION`

Audit the deployed policy body against the current post-AdMob data model before any broader Play release/provider declaration submission.

Do NOT:
- promote Play tracks;
- Artifact Freeze;
- release/publish the Android app.


## Privacy-policy body audit attempt — 2026-10-05

Human selected:
`USER_OPTION_1_2026-10-05_AUDIT_DEPLOYED_PRIVACY_POLICY_BODY`

Audit:
`docs/qa/W2_PRIVACY_POLICY_BODY_AUDIT_ATTEMPT_2026_10_05_v1.0.md`

Independent retrieval result:
`BODY_CONTENT_NOT_INDEPENDENTLY_RETRIEVABLE_IN_CHAT_ENVIRONMENT`

Important:
- operator previously confirmed the URL opens publicly;
- current tooling cannot fetch/read the deployed body;
- this is evidence-access debt, not proof that the URL is broken.

Current official Google baseline was refreshed and confirms the policy must comprehensively describe app + SDK data handling, while GMA Next-Gen automatically collects/shares IP/general location, user product interactions, diagnostics, and device/account identifiers for advertising, analytics, and fraud prevention.

Next minimal recovery:
provide the rendered policy text/HTML or screenshots from the live page for line-by-line audit.

Provider mutation, Artifact Freeze, and production release remain unauthorized.
