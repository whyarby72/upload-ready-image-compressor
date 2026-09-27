# CURRENT_TASK.md

Task ID: TASK-S5-005
Owner: CODEX
Reviewer: CHAT + HUMAN_VISUAL
Stage: S5_UI_UX_REDESIGN_V2_IMPLEMENTATION
Priority: HIGH
Status: OPEN_IMPLEMENTATION_AUTHORIZED

## Material approval

Approval token:
`COMPOSE_WARM_INK_IMPLEMENTATION`

Approved by user:
2026-09-27

Approval scope:
implement the exact presentation-layer migration defined by:
- `docs/ux/S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`
- `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`
- `docs/ux/S5_COMPOSE_TOOLCHAIN_BINDING_v1.0.md`

This approval DOES authorize:
- Kotlin/Compose toolchain enablement;
- compileSdk 37 if required by the bound stable Compose toolchain;
- Compose Material 3 presentation layer;
- replacement of the rejected View/XML UI after parity is proven;
- UI state/event bridge;
- safe source/result previews;
- fresh build/test/artifact generation;
- screenshot evidence.

This approval DOES NOT authorize:
- targetSdk change;
- package/applicationId change;
- versionCode/versionName change;
- compression algorithm change;
- target parser change;
- quality-floor change;
- new formats;
- network/backend;
- AdMob/UMP/analytics;
- signing;
- Play upload;
- S6 promotion;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Required starting HEAD

The exact starting HEAD is supplied in the external Codex handoff and must equal the current branch HEAD at execution. Stop on mismatch.

## Product goal

Implement the human-approved `MEDIA-FIRST PRECISION UTILITY — WARM INK` experience in Compose Material 3 while preserving all verified product truth and domain behavior.

## Frozen domain

Do not rewrite the existing Java/domain engine unless an independently proven functional defect is found.

Protected behavior includes:
- JPEG/JPG scope;
- decimal-SI limits;
- no implicit target;
- Custom parser;
- PASS iff exact output <= exact target;
- honest NOT_MET;
- REDUCED/ALREADY_SMALL truth;
- source preservation;
- Save;
- Share;
- orientation;
- metadata behavior;
- privacy/permissions.

## Mandatory implementation phases

M1 Toolchain
M2 State/event bridge
M3 Home/Requirement/Custom
M4 Processing/Result
M5 Safe media preview
M6 View/XML retirement only after parity
M7 Full technical regression + fresh artifacts
M8 Human visual screenshot gate

## Human visual gate

Codex may not declare visual PASS.

Codex may only report:
`READY_FOR_HUMAN_VISUAL_REVIEW`

Actual runtime screenshots are reviewed by CHAT and user.

## Current artifact

Pre-Compose AAB:
`de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

After any product-source mutation:
`PROVENANCE_ONLY`

A fresh AAB is mandatory.

## Done when

- implementation follows exact brief;
- engine semantics remain intact;
- technical regression passes;
- fresh runtime screenshot set exists;
- fresh artifacts/hashes exist;
- status is READY_FOR_HUMAN_VISUAL_REVIEW;
- no Play/signing/release claim.


## Independent first-pass source audit

Audit:
`docs/ux/S5_005_INDEPENDENT_SOURCE_AUDIT_v1.0.md`

First-pass technical migration is accepted, but Warm Ink fidelity is not.

Status:
`REWORK_REQUIRED_BEFORE_HUMAN_VISUAL_REVIEW`

Corrective prompt:
`prompts/CODEX_S5_005_WARM_INK_CORRECTIVE.md`

This corrective is inside the existing `COMPOSE_WARM_INK_IMPLEMENTATION` approval scope.


## Direct human-screen visual audit

Audit:
`docs/ux/S5_005_HUMAN_VISUAL_FORENSIC_AUDIT_v1.0.md`

Status:
`HOLD_NARROW_FINAL_VISUAL_POLISH`

Blocking:
- Requirement above-fold hierarchy.
- Result friendly-size unit wrap.

Corrective:
`prompts/CODEX_S5_005_FINAL_VISUAL_POLISH.md`

The Warm Ink concept itself remains approved.
