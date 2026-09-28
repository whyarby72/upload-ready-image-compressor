# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_ACTUAL_ENGINE_GEOMETRY_PROOF
Decision: TEST
Progress: 98%
Current task: TASK-S5-005
Next owner: CODEX
Task status: HOLD_ACTUAL_ENGINE_GEOMETRY_PROOF_REQUIRED

## Accepted from source commit 285ce9fd...

- UI truth-critical previews use Fit.
- Requirement thumbnail alone may Crop.
- NOT_MET guidance is present.
- NOT_MET primary label is Save current copy.
- protected compression/domain source remains unchanged.

## Reopened geometry evidence

Independent audit:
`docs/qa/S5_005_GEOMETRY_PROOF_INDEPENDENT_AUDIT_v1.0.md`

Problem:
current GeometryPreservationTest exercises ScalePlanner with synthetic dimensions only.

Current proof uses placeholder output dimensions such as:
`2400x1600-or-scaled-uniformly`

This does not meet the hard geometry contract requiring actual decoded production-engine output dimensions.

## Next action

Run:
`prompts/CODEX_S5_005_ACTUAL_ENGINE_GEOMETRY_PROOF_REPAIR.md`

Test/evidence only unless real engine output fails.

If real engine output fails geometry:
STOP.
Do not modify protected engine without new explicit human approval.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
