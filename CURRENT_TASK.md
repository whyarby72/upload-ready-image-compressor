# CURRENT_TASK.md

Task ID: TASK-S5-005
Owner: CHAT + HUMAN
Reviewer: CHAT + HUMAN_VISUAL
Stage: S5_INTERNAL_TEST_READY
Priority: HIGH
Status: CLOSED_HUMAN_VISUAL_PASS

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


## Final visual evidence integrity failure

Audit:
`docs/ux/S5_005_FINAL_VISUAL_EVIDENCE_INTEGRITY_AUDIT_v1.0.md`

Status:
`HOLD_EVIDENCE_INTEGRITY_FAILURE_AND_320DP_LABEL_FIX`

Corrective:
`prompts/CODEX_S5_005_FINAL_EVIDENCE_REPAIR.md`

This is a narrow source/evidence correction within the existing Compose approval.


## Final direct visual review

Audit:
`docs/ux/S5_005_FINAL_DIRECT_VISUAL_REVIEW_v1.0.md`

Status:
`HOLD_FINAL_NOT_MET_COPY_FIDELITY`

All reviewed states pass except the documented NOT_MET guidance/save-label fidelity.

Corrective:
`prompts/CODEX_S5_005_FINAL_NOT_MET_COPY_FIDELITY.md`


## Hard image-geometry invariant

Binding:
`docs/product/IMAGE_GEOMETRY_PRESERVATION_CONTRACT_v1.0.md`

Human requirement:
source/output display geometry MUST remain proportional; no stretch/squash.

Current preview renderer uses Crop globally. The next corrective MUST:
- keep Requirement thumbnail Crop if desired;
- set Processing to Fit;
- set Result hero to Fit;
- set both Before/After images to Fit;
- add deterministic decoded-output geometry proof.

If geometry proof fails against protected engine behavior, STOP for new approval rather than modifying protected domain/compression source.

Combined corrective:
`prompts/CODEX_S5_005_FINAL_GEOMETRY_AND_NOT_MET_FIDELITY.md`

This supersedes:
`prompts/CODEX_S5_005_FINAL_NOT_MET_COPY_FIDELITY.md`


## Actual engine geometry proof reopened

Independent audit:
`docs/qa/S5_005_GEOMETRY_PROOF_INDEPENDENT_AUDIT_v1.0.md`

Status:
`HOLD_ACTUAL_ENGINE_GEOMETRY_PROOF_REQUIRED`

The existing GeometryPreservationTest only tests ScalePlanner arithmetic and cannot substantiate the TEST_MATRIX claim that decoded production output preserves ratio.

Repair prompt:
`prompts/CODEX_S5_005_ACTUAL_ENGINE_GEOMETRY_PROOF_REPAIR.md`

Protected compression/domain source remains closed. If the real engine fails, STOP for explicit approval.


## Final geometry visual human closure — 2026-09-28

Status:
`PASS / TASK-S5-005 CLOSED`

Approval ref:
`USER_OPTION_1_2026-09-28_FINAL_GEOMETRY_VISUAL_GATE_ONLY`

Audit:
`docs/qa/S5_005_FINAL_GEOMETRY_VISUAL_HUMAN_CLOSURE_v1.0.md`

The human explicitly approved only the final TASK-S5-005 geometry visual Fit/full-frame gate after CHAT directly reviewed the current geometry-final screenshots.

This approval closes:
- final Fit/full-frame visual acceptance;
- TASK-S5-005 human visual gate.

It does NOT authorize:
- signing;
- Play upload;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

Next owner:
`HUMAN_PLAY_CONSOLE`

Broader S5 remains open until actual Google Play Internal Testing distribution/install evidence exists.
