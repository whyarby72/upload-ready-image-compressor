# CURRENT_TASK.md

Task ID: TASK-S5-007
Owner: CHAT
Reviewer: HUMAN + CHAT
Stage: S5_OUTPUT_SIZE_TRUTH_CLARITY_REWORK
Priority: MEDIUM
Status: SPEC_READY_IMPLEMENTATION_NOT_AUTHORIZED

## Trigger

Human manual testing found that the app can show a rounded decimal-SI size such as `496 KB` while Android Files may show approximately `484 KB` for the exact same 495,669-byte file.

Independent evidence confirms the produced result and saved copy in the observed case are byte-identical:
- bytes: `495,669`
- SHA-256: `f30a022df6c6c447a5c2d22aefc715277310d6455ce285d8f6db0fcd6992790b`

Therefore this is a cross-display unit-label ambiguity, not compression or Save mutation.

## Source-of-truth

Audit:
`docs/qa/TASK_S5_007_OUTPUT_SIZE_DISPLAY_TRUTH_AUDIT_v1.0.md`

Corrective spec:
`docs/ux/TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_SPEC_v1.0.md`

Prepared Codex work order:
`prompts/CODEX_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY.md`

## Preserved PASS

- compression/domain behavior;
- target parser;
- decimal-SI semantics;
- PASS / NOT_MET / REDUCED classification;
- exact output byte count;
- Save fidelity;
- Share;
- geometry;
- generated Home hero and visual productization evidence.

## Required correction

Presentation-only:
- make exact bytes explicitly read as `Actual file`;
- group exact byte counts for readability;
- keep decimal-SI rounded KB/MB summary;
- disclose `1 KB = 1,000 bytes`;
- explain compactly that some file managers may show 1,024-byte units.

## Pending material approval

Required exact scope:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY IMPLEMENTATION`

Approval would authorize only:
- Result-screen copy/layout adjustments defined by the spec;
- presentation-only exact-byte formatting helper;
- fresh build/test/emulator/saved-file evidence.

It would NOT authorize:
- target arithmetic change;
- compression/domain change;
- Save behavior change;
- package/version/SDK change;
- signing;
- Play upload;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.
