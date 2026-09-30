# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING
Decision: TEST
Progress: 99%
Current task: S5_PLAY_INTERNAL_TESTING_HANDOFF_REFRESH
Next owner: HUMAN
Task status: HANDOFF_REFRESH_PREPARED_UNSIGNED_CANDIDATE_MATERIALIZATION_APPROVAL_PENDING

## S5 product-quality closure

TASK-S5-005 geometry:
`PASS_HUMAN_APPROVED`

TASK-S5-006 PREMIUM_QUALITY / VISUAL_PRODUCTIZATION:
`PASS_HUMAN_APPROVED_CLOSED`

TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY:
`PASS_HUMAN_APPROVED_CLOSED`

All current S5 product-quality corrective gates are closed.

## Refreshed Google Play Internal testing package

Canonical handoff:
`docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v3.0.md`

Canonical readiness:
`docs/ops/S5_PLAY_INTERNAL_TESTING_READINESS_v2.0.json`

Refresh proof:
`evidence/play/S5_PLAY_INTERNAL_TESTING_HANDOFF_REFRESH_PROOF_v1.0.json`

Prepared next-step prompt:
`prompts/CODEX_S5_PLAY_CANDIDATE_MATERIALIZATION_v1.0.md`

The old v2.0 handoff / v1.0 readiness are superseded for next-action purposes and retained only as provenance.

## Current tested app source

`27199bf6f174e55dc835d0d9898e456d3848001c`

No later reviewed app/source mutation exists after this tested source; later branch changes are evidence/docs/state only.

## Current unsigned QA AAB reference

Build path:
`app/build/outputs/bundle/release/app-release.aab`

Bytes:
`7,968,406`

SHA-256:
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

Signing:
`UNSIGNED`

Repository materialized:
`FALSE`

Play upload eligible:
`FALSE`

This is a QA-proven local artifact reference, not yet the evidence-materialized pre-sign Play candidate.

Older `s5_005*` AABs must not be uploaded as the current candidate.

## Current policy refresh

Official Google sources were rechecked on 2026-09-30.

Current project target:
`API 36`

Current Google Play minimum for new mobile submissions:
`API 36`

Internal testing supports up to:
`100 testers`

For qualifying newer personal developer accounts, later production access may require:
`12 continuously opted-in closed-test testers for at least 14 days`

That production-access rule is account-dependent and is not fulfilled by Internal testing alone.

## Pending exact human decision

`S5 CURRENT UNSIGNED PLAY CANDIDATE MATERIALIZATION ONLY`

If approved, Codex may:
- verify the surviving local QA AAB or rebuild from unchanged source;
- run build/unit/lint checks;
- copy the unsigned AAB into a dedicated evidence artifact location;
- record exact bytes/SHA-256/source binding;
- update repository evidence/docs/state.

It may NOT:
- create/rotate keys;
- sign;
- touch Play Console;
- upload;
- change testers;
- rollout;
- advance S6;
- promote BUILD;
- Artifact Freeze;
- release;
- publish.

## Provider-bound UNKNOWN

Do not infer:
- whether app/package already exists in Play Console;
- account type/date;
- release-to-testing permission;
- Play App Signing state;
- upload-key state/fingerprint;
- versionCode 1 availability;
- tester identities/count;
- feedback channel;
- provider warnings/errors.

These require observation by the legitimately authorized Play Console account holder.
