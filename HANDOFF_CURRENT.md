# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_OUTPUT_SIZE_TRUTH_CLARITY_REWORK
Decision: TEST
Progress: 98%
Current task: TASK-S5-007
Next owner: CODEX
Task status: IMPLEMENTATION_AUTHORIZED_HARDENED_WORK_ORDER_READY

## Why S5 reopened

Human manual evidence found a support-risk discrepancy between the app's decimal-SI rounded KB display and Android file-manager size labels.

Observed verified case:
- app exact result: `495,669 bytes`;
- app rounded decimal-SI label: `496 KB`;
- saved file: `495,669 bytes`;
- engine result SHA-256 = saved file SHA-256:
  `f30a022df6c6c447a5c2d22aefc715277310d6455ce285d8f6db0fcd6992790b`;
- Android file-manager label approximately `484 KB`.

This proves no Save mutation. The difference is display-unit convention.

## Canonical truth remains

- 1 KB = 1,000 bytes;
- 1 MB = 1,000,000 bytes;
- exact bytes are authoritative;
- PASS iff output bytes <= target bytes.

Do not switch arithmetic to 1024-byte units.

## Corrective package

Audit:
`docs/qa/TASK_S5_007_OUTPUT_SIZE_DISPLAY_TRUTH_AUDIT_v1.0.md`

Spec:
`docs/ux/TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_SPEC_v1.0.md`

Prepared work order:
`prompts/CODEX_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY.md`

## Previous visual state

TASK-S5-006 generated hero machine QA and CHAT premium review remain valid within scope. Human premium approval was still pending when this new Result-copy issue was found.

## Next approval

Required exact scope:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY IMPLEMENTATION`

No source mutation is authorized by opening this task.

No signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication.


## TASK-S5-007 implementation authorization — 2026-09-30

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_IMPLEMENTATION`

Execution owner:
`CODEX`

Canonical work order:
`prompts/CODEX_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY.md`

Scope is presentation-only Result-size clarity plus fresh verification.

Compression/domain arithmetic and Save behavior remain protected.

No signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication authority is granted.


## TASK-S5-007 pre-execution hardening — 2026-09-30

The implementation approval remains valid. No new human approval is required.

Hardened work order:
`prompts/CODEX_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY.md` (v1.1)

Execution is now explicitly constrained to:
- `MainActivity.kt`;
- `FormatUtils.java`;
- optional formatting-only unit test;
- evidence/docs/state reconciliation.

Protected compression/domain/Save files remain unchanged.

QA build execution is authorized for this task:
- assembleDebug;
- unit tests;
- lintDebug;
- assembleRelease;
- bundleRelease;
- existing relevant instrumentation/regression.

This does NOT authorize canonical BUILD promotion.

Evidence hardening now requires:
- foreground package + UIAutomator hierarchy + screenshot hash for PASS / NOT_MET / REDUCED;
- grouped exact-byte formatting unit tests;
- real UI Save action;
- exact byte-count and SHA-256 equality between app result JPEG and MediaStore saved JPEG.

Canonical disclosure copy:
`Size units here: 1 KB = 1,000 bytes. Some file managers calculate KB using 1,024 bytes.`

Play Internal Testing handoff remains paused until TASK-S5-007 machine QA plus CHAT/HUMAN closure.

Next owner:
`CODEX`

No signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication.
