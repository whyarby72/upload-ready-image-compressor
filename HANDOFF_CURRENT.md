# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_FINAL_VISUAL_EVIDENCE_REPAIR
Decision: TEST
Progress: 97%
Current task: TASK-S5-005
Next owner: CODEX
Task status: HOLD_EVIDENCE_INTEGRITY_FAILURE_AND_320DP_LABEL_FIX

## Direct ZIP review

CHAT directly inspected:
`S5_005_FINAL_VISUAL_REVIEW.zip`

ZIP SHA-256:
`8a8c4ba52cd9cacc52bda4ee42bc10416fcb540ef31db2e05ba2e7bee961bf7c`

All screenshot hashes match `evidence/INDEX.json`; therefore the defect is repository-bound.

## Material evidence failures

- PASS 360 is actually REDUCED.
- NOT_MET 360 is byte-identical to PASS/REDUCED.
- PASS 320 is the Android system photo picker.
- PASS 1.3x is the same system picker.
- Requirement 1.3x is Home.
- Reduced 1.3x is byte-identical to normal Reduced 320.
- Processing screenshot is a completed result state.

## Actual visual findings

Requirement 360:
PASS.

Requirement 320:
main hierarchy passes, but `Custom` is clipped to `Custo`.

Reduced Result 360:
PASS for REDUCED.

Reduced Result 320:
PASS_WITH_SCROLL.

## Next action

Run:
`prompts/CODEX_S5_005_FINAL_EVIDENCE_REPAIR.md`

This includes:
- narrow 320dp target-chip label fix;
- semantic screenshot verification before naming;
- fresh recapture;
- duplicate-hash rejection;
- fresh artifacts because source changes.

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
