# CODEX — PLAY CONSOLE AI ASSET PER-ASSET LABELING v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider state

Review step:
`AI asset declaration`

Selecting:
`Label assets as created or edited using AI`

opens a provider dialog:

Title:
`Label AI-generated assets`

Wording:
`Declare if any of your assets were generated or edited with AI.`

Instruction:
`Select all assets that were generated or edited with AI`

Asset categories shown:
- `App icon`
- `Feature graphic`
- `Phone screenshots`

Controls:
- `Cancel`
- `Label assets and submit`

## Provenance decision for current v1.2 listing

Select ALL THREE asset categories:

- `App icon` = YES, AI-created/edited
- `Feature graphic` = YES, AI-created/edited
- `Phone screenshots` = YES, AI-created/edited marketing composites grounded in direct smartphone runtime captures

This declaration applies to the exact v1.2 visual set currently in the Main store listing.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not mutate Play Console until CURRENT_TASK explicitly grants:

`AI_ASSET_PER_ASSET_LABELING_ALL_THREE_SUBMIT`

## Future authorized scope after explicit approval

Only after the approval above:

1. verify app/package context;
2. verify Review step is still `AI asset declaration`;
3. verify the dialog title, asset categories, and controls remain materially the same;
4. select exactly:
   - App icon
   - Feature graphic
   - Phone screenshots
5. click `Label assets and submit` ONLY for this AI asset labeling dialog;
6. observe the result of that dialog submission;
7. if returned to the Review step, record the new selected state and all visible controls;
8. do NOT click `Save`, `Save as draft`, `Send app for review`, or any broader provider persistence/review/publication control unless separately authorized;
9. inspect Dashboard/Publishing overview only if possible read-only after the dialog action;
10. STOP.

## Hard stop boundaries

STOP before further action if:

- additional asset categories appear;
- individual files/screenshots must be selected one-by-one;
- any current v1.2 asset is missing from the provider dialog;
- `Label assets and submit` indicates app review submission, listing publication, release, or broader submission rather than only the AI-label declaration;
- a second confirmation appears with broader semantics;
- app/package context is wrong.

Allowed blockers:
- `BLOCKED_AI_ASSET_DIALOG_SCHEMA_DRIFT`
- `BLOCKED_AI_ASSET_REQUIRES_FILE_LEVEL_SELECTION`
- `BLOCKED_AI_ASSET_SUBMIT_SCOPE_AMBIGUOUS`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_AI_ASSET_PER_ASSET_LABELING_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- exact dialog title/instruction;
- exact categories selected;
- exact control clicked;
- whether the dialog action persisted any provider state;
- resulting Review-step state;
- Dashboard count if visible read-only;
- Publishing overview observation if visible read-only;
- `Send app for review` state if visible;
- confirmation that no listing Save/Save-as-draft, review submission, release, rollout, or publication occurred.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_AI_ASSET_PER_ASSET_LABELING_ALL_THREE_SUBMITTED`
- `PARTIAL_AI_ASSET_DIALOG_RESULT_UNVERIFIED`
- `BLOCKED_AI_ASSET_DIALOG_SCHEMA_DRIFT`
- `BLOCKED_AI_ASSET_REQUIRES_FILE_LEVEL_SELECTION`
- `BLOCKED_AI_ASSET_SUBMIT_SCOPE_AMBIGUOUS`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_AI_ASSET_DIALOG_SUBMIT`

## Final response

Return:
1. disposition;
2. exact categories selected;
3. exact control clicked;
4. resulting Review-step state;
5. whether any provider state persisted;
6. Dashboard/Publishing overview observation if available read-only;
7. `Send app for review` state if visible;
8. evidence commit SHA if available;
9. confirmation no listing Save/Save-as-draft, review submission, release, rollout, or publication occurred;
10. next ONE action only.
