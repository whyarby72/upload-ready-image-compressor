# CURRENT_TASK.md

Task ID: TASK-S5-006
Owner: CODEX
Reviewer: HUMAN + CHAT
Stage: S5_VISUAL_PRODUCTIZATION_REWORK
Priority: HIGH
Status: HOLD_HOME360_SEMANTIC_RECAPTURE_REQUIRED

## Trigger

Direct human emulator review of the current first-open screen exposed a material visual-productization gap:
- no dedicated launcher/app identity asset;
- generic `ic_photo` used as identity/hero symbol;
- first-open `PHOTO → READY` block reads as placeholder-like relative to the approved premium/mockup direction.

## Source-of-truth

Audit:
`docs/qa/TASK_S5_006_VISUAL_PRODUCTIZATION_ESCAPE_AUDIT_v1.0.md`

Corrective spec:
`docs/ux/TASK_S5_006_VISUAL_ASSET_COMPLETENESS_CORRECTIVE_SPEC_v1.0.md`

Project runtime engine correction:
`docs/engine/AI_PROD_ANDROID_NATIVE_VISUAL_PRODUCTIZATION_GATE_PATCH_v1.0.0.md`

## Preserved PASS

The following remain valid within their proven scope:
- compression/domain behavior;
- exact-byte PASS / NOT_MET / REDUCED semantics;
- Save / Share;
- API29/API36 technical evidence;
- actual-engine geometry 10/10;
- full-frame Fit geometry;
- NOT_MET copy/action fidelity.

Do not reopen protected compression/domain source.

## Current HOLD

S5 Internal Testing handoff is paused until this visual corrective is implemented and reverified.

The existing AAB is retained as pre-rework provenance only for next-action purposes. It must not be used as the next Play upload candidate after any UI/resource mutation.

## Material approval recorded

Approval token:
`TASK-S5-006 VISUAL ASSET COMPLETENESS IMPLEMENTATION`

Approval ref:
`USER_OPTION_1_2026-09-28_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION`

Approved by user:
2026-09-28

Current Codex work order:
`prompts/CODEX_TASK_S5_006_EVIDENCE_REPAIR_AND_RECAPTURE.md`

Original implementation work order (completed/provenance):
`prompts/CODEX_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION.md`

Approval authorizes only:
- dedicated local launcher/app mark assets;
- purpose-built first-open hero illustration;
- minimal per-screen visual-asset integration defined by the corrective spec;
- Compose/resource presentation changes required by the spec;
- fresh build/test/runtime screenshot evidence.

It does NOT authorize:
- compression/domain changes;
- new formats;
- backend/network;
- AdMob/analytics;
- package/applicationId change;
- targetSdk change;
- versionCode/versionName change;
- signing;
- Play Console mutation/upload;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Done when

- VAC-01 through VAC-12 are evidenced;
- dedicated launcher/app identity exists;
- first-open hero is purpose-built and no longer placeholder-like;
- real user media remains primary on Requirement/Processing/Result;
- mockup-to-runtime fidelity matrix is complete;
- actual runtime screenshots at 320dp, 360dp and 1.3x are reviewed;
- fresh artifact hashes are recorded;
- human explicitly approves `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION`;
- only then may Play Internal Testing handoff be regenerated/resumed.


## Execution handoff — 2026-09-28

Implementation is now authorized within the scope above.

Next owner:
`CODEX`

Codex must execute:
`prompts/CODEX_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION.md`

After deterministic implementation/build/test/screenshot evidence:
- do not self-approve premium quality;
- return next owner to `CHAT + HUMAN`;
- request scoped `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION` approval;
- keep Play handoff paused until that approval is recorded.


## CHAT evidence-integrity hold — 2026-09-28

Direct CHAT review of the pushed TASK-S5-006 evidence found the machine-QA closure was not semantically valid.

Authoritative audit:
`docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.0.md`

Confirmed defects:
- `home_api36_360x800.png` is splash-only, not Home;
- `result_pass_api36.png` is actually TARGET NOT MET;
- `before_after_landscape_api36.png` does not independently prove a landscape case;
- Custom Limit helper still requires the binding decimal-entry guidance;
- current build metadata requires reconciliation to the fresh TASK-S5-006 artifact.

Current Codex action:
`prompts/CODEX_TASK_S5_006_EVIDENCE_REPAIR_AND_RECAPTURE.md`

Next owner:
`CODEX`

Completion state after repair may be only:
`IMPLEMENTED_MACHINE_QA_PASS_CHAT_PREMIUM_REVIEW_READY`

Do NOT request HUMAN PREMIUM_QUALITY approval until CHAT has directly re-audited the repaired runtime evidence.


## CHAT premium review v1.1 — 2026-09-29

Direct review of evidence closure `d22dff0c0abb568d9a6226984da67e7b7bd8c4fe` confirmed PASS, landscape Before/After, Custom helper, and current artifact metadata are repaired.

One required artifact remains invalid:
`home_api36_360x800.png` is the Android launcher/home screen, not the app Home runtime.

Audit:
`docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.1.md`

Active work order:
`prompts/CODEX_TASK_S5_006_HOME360_SEMANTIC_RECAPTURE.md`

The recapture must persist:
- foreground package proof;
- UIAutomator hierarchy proof with required Home anchors;
- screenshot hash.

Next owner:
`CODEX`

No app/source mutation is required.
Human PREMIUM_QUALITY review remains NOT READY.
