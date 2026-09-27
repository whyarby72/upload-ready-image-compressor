# HANDOFF_CURRENT

Product: REDUCE PHOTO SIZE: KB LIMIT
Stage: S5_COMPOSE_WARM_INK_IMPLEMENTATION
Decision: TEST
Progress: 87%
Current task: TASK-S5-005
Next owner: CODEX
Task status: OPEN_IMPLEMENTATION_AUTHORIZED

## Material approval

`COMPOSE_WARM_INK_IMPLEMENTATION`

Scope:
presentation-layer migration defined by:
- `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
- `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`
- `docs/ux/S5_COMPOSE_TOOLCHAIN_BINDING_v1.0.md`

## Implementation branch

`task/TASK-S5-005`

## Authority

Authorized:
- Kotlin/Compose enablement;
- compileSdk 37 toolchain update;
- Compose Material 3 UI migration;
- UI state/event bridge;
- safe media preview;
- fresh builds/tests/evidence.

Not authorized:
- targetSdk/package/version changes;
- domain/compression/parser changes;
- network/ads/analytics;
- signing;
- Play upload;
- S6/BUILD/Artifact Freeze/release/publication.

## Visual gate

Codex final state must be:
`READY_FOR_HUMAN_VISUAL_REVIEW`

Codex cannot approve its own visual implementation.

## Current pre-Compose AAB

`de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

Once source mutation occurs:
`PROVENANCE_ONLY`

## Next action

Run:
`prompts/CODEX_S5_COMPOSE_WARM_INK_IMPLEMENTATION.md`
from the exact branch HEAD supplied in the external handoff. Stop on mismatch.
