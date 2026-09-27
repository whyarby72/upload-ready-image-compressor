# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Historical working name: UPLOAD-READY IMAGE COMPRESSOR (provenance only)
Stage: S5_INTERNAL_TEST_READY
Decision: TEST
Progress: 76%
Current task: TASK-S5-003
Next owner: CODEX
Task status: OPEN

## Current gate

The Custom-limit semantics gap is now resolved and binding.

Use:
`docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`

Core rule:
- KB/MB are decimal SI (1,000 / 1,000,000 bytes);
- exact output bytes remain the verification primitive;
- Custom = 1 KB..50 MB, max 3 fractional digits;
- accept one dot OR comma decimal separator, no grouping;
- exact-byte proof is required for PASS/NOT_MET.



S5 requirement-truth repair is required before Play Console.

Known defect:
- current build preselects 1 MB;
- verified PASS/NOT_MET path must instead require an explicit user-provided upload limit.

## Artifact disposition

Current pre-fix AAB:
`992a2acddb197796b7aec8be72923c7ec8759a2cb36cf39dcc7f91c32a60c7a6`

Status:
`HOLD_KNOWN_REQUIREMENT_CAPTURE_DEFECT`

Do not upload it to Google Play if TASK-S5-003 source repair is adopted.

## Authority

- build_authorized: False
- artifact_freeze: False
- release_authorized: False
- publication_authorized: False

## Blockers

1. TASK-S5-003 requirement-truth defect repair + fresh regression/artifact evidence.
2. Release signing / Google Play Internal Testing upload remains HUMAN_ACTION_REQUIRED after technical PASS.

## Next action

CODEX executes the current `CURRENT_TASK.md` and `prompts/CODEX_S5_REQUIREMENT_TRUTH_FIX.md` on `task/TASK-S5-003`, then returns fresh artifact-bound evidence.
