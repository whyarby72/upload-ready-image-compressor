# CURRENT_TASK.md

Task ID: S5_PLAY_INTERNAL_TESTING_HANDOFF_REFRESH
Owner: HUMAN
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING
Priority: HIGH
Status: HANDOFF_REFRESH_PREPARED_UNSIGNED_CANDIDATE_MATERIALIZATION_APPROVAL_PENDING

## Product-quality status

TASK-S5-005 geometry:
`PASS_HUMAN_APPROVED`

TASK-S5-006 PREMIUM_QUALITY / VISUAL_PRODUCTIZATION:
`PASS_HUMAN_APPROVED_CLOSED`

TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY:
`PASS_HUMAN_APPROVED_CLOSED`

No current S5 product-quality corrective gate remains open.

## Refreshed Play handoff package

Human handoff:
`docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v3.0.md`

Readiness:
`docs/ops/S5_PLAY_INTERNAL_TESTING_READINESS_v2.0.json`

Refresh proof:
`evidence/play/S5_PLAY_INTERNAL_TESTING_HANDOFF_REFRESH_PROOF_v1.0.json`

The v3.0 handoff supersedes the old v2.0 handoff for next-action purposes.

## Current tested source

`27199bf6f174e55dc835d0d9898e456d3848001c`

No later app/source mutation exists in the reviewed branch history through the handoff preparation base.

## Current QA AAB reference

Build path:
`app/build/outputs/bundle/release/app-release.aab`

Recorded bytes:
`7,968,406`

Recorded SHA-256:
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

Signing:
`UNSIGNED`

Repository materialization:
`FALSE`

Play upload eligibility:
`FALSE`

Disposition:
`QA_PROVENANCE_REFERENCE_MUST_BE_MATERIALIZED_AND_REHASHED_BEFORE_SIGNING`

## Current provider facts

Verified from official Google sources on 2026-09-30:
- new mobile submissions require target API 36 or higher;
- current project targets API 36;
- Internal testing supports up to 100 testers;
- new personal accounts created after 2023-11-13 may have the later 12-testers / 14-days closed-test production-access requirement;
- Play App Signing uses a developer-held upload key to sign the bundle before upload.

## Pending human decision

Required exact scope:
`S5 CURRENT UNSIGNED PLAY CANDIDATE MATERIALIZATION ONLY`

Prepared work order:
`prompts/CODEX_S5_PLAY_CANDIDATE_MATERIALIZATION_v1.0.md`

If authorized, this scope allows only:
- verify or rebuild the unsigned current-source release AAB;
- run non-provider build/test checks;
- copy the unsigned AAB into a dedicated evidence artifact namespace;
- record bytes/SHA-256 and source binding;
- update evidence/docs/state.

It does NOT authorize:
- upload-key/keystore creation or rotation;
- signing;
- Play Console app creation/mutation;
- upload;
- tester-list mutation;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Provider unknowns

Remain unknown until a legitimately authorized human checks Play Console:
- whether the app already exists;
- account type/date;
- release-to-testing permission;
- Play App Signing state;
- upload-key state/fingerprint;
- versionCode 1 availability;
- tester identities/count;
- feedback channel;
- provider warnings/errors.
