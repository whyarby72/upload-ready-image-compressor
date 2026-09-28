# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_FINAL_GEOMETRY_AND_NOT_MET_FIDELITY
Decision: TEST
Progress: 98%
Current task: TASK-S5-005
Next owner: CODEX
Task status: HOLD_FINAL_GEOMETRY_AND_NOT_MET_FIDELITY

## New binding hard invariant

Human decision:
**source/output image geometry must be preserved; output must never stretch/squash.**

Binding contract:
`docs/product/IMAGE_GEOMETRY_PRESERVATION_CONTRACT_v1.0.md`

### Output file
- uniform X/Y scale only;
- no crop as compression strategy;
- EXIF-oriented aspect ratio preserved;
- only integer-pixel rounding drift permitted.

### UI truth surfaces
- Requirement thumbnail: Crop allowed.
- Processing: Fit.
- Result hero: Fit.
- Before/After source + result: Fit.

Current engine source already appears to use uniform scaling, but deterministic decoded-output evidence is now mandatory.

If geometry tests fail, STOP. Do not modify protected compression/domain code without new explicit approval.

## Existing final blocker folded into same pass

NOT_MET must add:
`Try a higher limit or a different photo.`

NOT_MET save label:
`Save current copy`

## Next action

Run:
`prompts/CODEX_S5_005_FINAL_GEOMETRY_AND_NOT_MET_FIDELITY.md`

This supersedes the earlier standalone NOT_MET corrective.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
