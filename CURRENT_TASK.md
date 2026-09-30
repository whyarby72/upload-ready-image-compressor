# CURRENT_TASK.md

Task ID: S5_PLAY_PROVIDER_PREFLIGHT
Owner: HUMAN
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING
Priority: HIGH
Status: PROVIDER_PREFLIGHT_REQUIRED_BEFORE_SIGNING_APPROVAL

## Product-quality status

TASK-S5-005 geometry:
`PASS_HUMAN_APPROVED`

TASK-S5-006 PREMIUM_QUALITY / VISUAL_PRODUCTIZATION:
`PASS_HUMAN_APPROVED_CLOSED`

TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY:
`PASS_HUMAN_APPROVED_CLOSED`

Physical smartphone final manual review:
`PASS_HUMAN_ATTESTED`

No current product-quality corrective gate is open.

## Current unsigned Play candidate

Source commit:
`27199bf6f174e55dc835d0d9898e456d3848001c`

Materialization commit:
`f191462281354dc9329b157c27de10919e463983`

Evidence-binding commit:
`5c61065768b131d14ffc6beddaac15842fc74cb8`

Artifact:
`evidence/artifacts/s5_current_play_candidate/app-release-0.1.0-vc1-unsigned.aab`

Bytes:
`7,968,406`

SHA-256:
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

Signing:
`UNSIGNED`

Repository materialized:
`TRUE`

Play upload eligible:
`FALSE`

Rebuild required:
`FALSE`

CHAT audit:
`docs/qa/S5_CURRENT_UNSIGNED_PLAY_CANDIDATE_CHAT_AUDIT_v1.0.md`

## Current gate

Before any signing approval, human must perform a provider-bound Play Console preflight.

Read-only observations required:
- whether the app/package already exists in the intended Play Console account;
- account type/date where relevant;
- permission to release apps to testing;
- Play App Signing enrollment/configuration;
- authorized upload-key availability and non-secret certificate fingerprint;
- whether versionCode 1 is available;
- intended internal tester setup;
- feedback email/URL;
- any provider warnings/blockers.

Do not infer provider state from repository state.

## Authority boundary

Not authorized:
- key creation or rotation;
- signing;
- Play Console mutation;
- app creation;
- AAB upload;
- tester mutation;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Next action

Human performs the read-only/provider-bound preflight and reports the observed facts to CHAT.

Only after reconciliation may a separately scoped signing approval be requested.
