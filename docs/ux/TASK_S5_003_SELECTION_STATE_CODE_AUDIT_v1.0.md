# TASK_S5_003_SELECTION_STATE_CODE_AUDIT_v1.0

Observed: 2026-09-27
Audited branch before source repair: `task/TASK-S5-003`
Purpose: Verify TASK-S5-003 against the actual `MainActivity` selection-state code before Codex execution.

## Confirmed original defect
Current source initializes `selectedTargetBytes` to 1 MB and calls `selectTarget(1 MB, index 4)` in `onCreate`, so a valid-looking REQUIRED can exist without explicit buyer input.

## Additional edge cases found

### E1 — Runtime-only reset is insufficient
The XML itself currently contains `REQUIRED: 1 MB` and the known-path CTA is enabled by default.
Fix must make the resource defaults neutral/disabled in addition to Java reset logic.

### E2 — Known target -> unknown path semantic contradiction
The unknown-limit action currently ignores `selectedTargetBytes` but does not clear it.
If a user first selects 100 KB and then deliberately chooses “I don't know”, the app should abandon the known-target state before producing REDUCED semantics.

### E3 — Async worker reads mutable fields
`startKnownCompression()` currently dispatches a worker that reads `imageInfo` and `selectedTargetBytes` fields.
Capture the exact image + target at click time and pass those immutable snapshots to compression. Do the equivalent image snapshot for unknown reduction.

### E4 — Custom target needs a last-valid-selection invariant
A valid Custom should become the only selected target.
Invalid/cancelled Custom with no prior target must stay unselected.
Invalid/cancelled Custom after a valid target must not mutate that previous valid target.
Preset/Custom switching must always make only the latest valid explicit target authoritative.

### E5 — Reset path should clear hidden selection
`reset()` currently clears image/result state but not selectedTargetBytes/visual state.
Use the same target-clear routine there as defense in depth.

### E6 — Older picker route should prove the same requirement state
API29 uses ACTION_OPEN_DOCUMENT while API33+ uses ACTION_PICK_IMAGES.
The requirement state logic is shared, but a post-pick API29 smoke test should prove no default target appears after the older picker route.

## Scope discipline
These findings strengthen requirement truth only.
They do not justify:
- broad UI redesign;
- result CTA reorder;
- monetization work;
- lifecycle/process-death redesign;
- release/publication actions.

## Result
TASK-S5-003 specification and Codex prompt were hardened before source execution.
