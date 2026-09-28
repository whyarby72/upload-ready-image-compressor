# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_FINAL_GEOMETRY_AND_NOT_MET_FIDELITY
Decision: TEST
Progress: 98%
Current task: TASK-S5-005
Next owner: CHAT/HUMAN
Task status: READY_FOR_FINAL_GEOMETRY_AND_VISUAL_HUMAN_REVIEW

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

Current engine source uses uniform scaling; GeometryPreservationTest and decoded foreground evidence are recorded in `evidence/geometry/S5_005_GEOMETRY_PROOF.json`.

If geometry tests fail, STOP. Do not modify protected compression/domain code without new explicit approval.

## Existing final blocker folded into same pass

NOT_MET must add:
`Try a higher limit or a different photo.`

NOT_MET save label:
`Save current copy`

## Next action

Next owner: CHAT/HUMAN for independent visual review. Do not claim S6, BUILD promotion, Artifact Freeze, release, or publication.

This supersedes the earlier standalone NOT_MET corrective.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
