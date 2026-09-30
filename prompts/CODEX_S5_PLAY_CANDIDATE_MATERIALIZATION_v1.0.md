# CODEX — S5 CURRENT UNSIGNED PLAY CANDIDATE MATERIALIZATION v1.0

Status: PREPARED / NOT AUTHORIZED
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-007`

Do NOT execute this work order until the human explicitly authorizes:
`S5 CURRENT UNSIGNED PLAY CANDIDATE MATERIALIZATION ONLY`

This work order does NOT authorize signing or any Play Console action.

## Goal

Materialize one exact unsigned current-source AAB into repository evidence so the later signing request can be artifact-bound.

## Source binding

Required tested app source:
`27199bf6f174e55dc835d0d9898e456d3848001c`

Current product-quality gates:
- TASK-S5-006: PASS_HUMAN_APPROVED_CLOSED
- TASK-S5-007: PASS_HUMAN_APPROVED_CLOSED

Read:
- `docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v3.0.md`
- `docs/ops/S5_PLAY_INTERNAL_TESTING_READINESS_v2.0.json`
- `evidence/play/S5_PLAY_INTERNAL_TESTING_HANDOFF_REFRESH_PROOF_v1.0.json`
- `PROJECT_STATE.json`

## Safety preflight

Run:
`git status --short`

If uncommitted changes exist:
STOP.
Do not reset, stash, discard, clean, overwrite, or force.

Synchronize the active branch with `git pull --ff-only`.

Verify that no app/source file changed after tested source `27199bf6...`.
Docs/evidence/state changes are allowed.

## Artifact decision

First inspect whether:
`app/build/outputs/bundle/release/app-release.aab`
exists and has:

bytes:
`7,968,406`

SHA-256:
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

If it matches:
use that exact unsigned AAB as the materialization input.

If missing or not matching:
rebuild from the unchanged app source:

`./gradlew clean test lintDebug assembleRelease bundleRelease`

Then record the new exact bytes and SHA-256.

A rebuild is allowed to produce a different binary hash.
Do not claim it is the previous QA artifact unless the hash is identical.

## Materialization

Copy the verified unsigned AAB to:

`evidence/artifacts/s5_current_play_candidate/app-release-0.1.0-vc1-unsigned.aab`

Record:
- bytes;
- SHA-256;
- source commit;
- build commands/results;
- signing state = UNSIGNED;
- Play upload eligibility = FALSE until separately authorized signing is complete.

Create:
`evidence/play/S5_CURRENT_UNSIGNED_PLAY_CANDIDATE_PROOF.json`

Update:
- `evidence/INDEX.json`
- `PROJECT_STATE.json`
- `CURRENT_TASK.md`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`
- `docs/ops/S5_PLAY_INTERNAL_TESTING_READINESS_v2.0.json`

## Hard boundaries

Do NOT:
- change app/source;
- change versionCode/versionName;
- change package/SDK;
- create/rotate an upload key;
- sign the AAB;
- put keystore/password/private-key material in Git or chat;
- create/mutate Play Console app;
- upload;
- modify tester lists;
- rollout;
- advance S6;
- promote BUILD;
- Artifact Freeze;
- release;
- publish.

If source drift, build failure, or artifact identity conflict appears:
STOP and report.

## Completion state

Allowed final status:
`UNSIGNED_CURRENT_PLAY_CANDIDATE_MATERIALIZED_SIGNING_APPROVAL_REQUIRED`

Next owner:
`HUMAN`

Then STOP.
