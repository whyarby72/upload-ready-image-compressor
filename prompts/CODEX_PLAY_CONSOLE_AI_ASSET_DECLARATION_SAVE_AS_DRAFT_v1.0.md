# CODEX — PLAY CONSOLE AI ASSET DECLARATION SAVE-AS-DRAFT v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider state

Dashboard:
`10 of 11 complete`

Only incomplete item:
`Set up your store listing`

Main store listing:
`Draft`

Review step title:
`AI asset declaration`

Provider wording:
`Regulations require that content that uses AI-generated assets be labeled under certain circumstances.`

Observed choices:
- `Don't label assets`
- `Label assets as created or edited using AI`
- `You will label individual assets on the next step`

Observed controls:
- `Discard`
- `Back`
- `Save as draft`
- `Save`

Observed warning:
`If you save, changes will be saved in Publishing overview, ready for you to send for review`

## Product asset provenance

The current v1.2 Main store listing contains six visual assets:

- app icon;
- feature graphic;
- four phone screenshots.

All six current listing visual assets were created or materially edited with generative AI tools.

The four phone screenshots are marketing composites grounded in user-supplied direct smartphone runtime captures, but the final uploaded visual files were generated/edited using AI.

Therefore `Don't label assets` is not truthful for the current listing.

Because all six current visual listing assets are in-scope AI-created/edited assets, the preferred declaration is:

`Label assets as created or edited using AI`

The per-asset path is unnecessary unless the provider requires it or if mixed AI/non-AI visual assets appear.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not mutate Play Console until CURRENT_TASK explicitly grants:

`AI_ASSET_DECLARATION_LABEL_ALL_SAVE_AS_DRAFT`

## Future authorized scope after explicit approval

Only after that approval:

1. verify active app/package context;
2. verify the Review step is still `AI asset declaration`;
3. verify the three choices and persistence controls remain materially the same;
4. select exactly:
   `Label assets as created or edited using AI`
5. do not choose `Don't label assets`;
6. do not choose per-asset labeling unless schema drift prevents the all-assets declaration;
7. click `Save as draft` only;
8. do not click `Save` if it has broader semantics than `Save as draft`;
9. reload/re-open Main store listing and Dashboard;
10. verify durable declaration state;
11. verify whether Dashboard becomes `11 of 11 complete`;
12. inspect Publishing overview read-only;
13. record whether `Send app for review` becomes enabled or remains disabled;
14. STOP.

## Hard stop boundaries

If any of these occur, STOP before mutation or further confirmation:

- the Review-step title/wording changes materially;
- `Save as draft` disappears;
- provider requires individual-asset labeling;
- provider shows an asset that was not part of v1.2;
- any confirmation implies immediate submission/review/publication/release;
- app/package context is wrong.

Use:
- `BLOCKED_AI_DECLARATION_SCHEMA_DRIFT`
- `BLOCKED_AI_DECLARATION_REQUIRES_PER_ASSET_REVIEW`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_AI_ASSET_DECLARATION_SAVE_AS_DRAFT_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical source HEAD;
- exact Review title/warning;
- selected declaration;
- exact persistence control used;
- durable-state verification;
- Dashboard count after reload;
- Publishing overview observation;
- `Send app for review` state;
- confirmation no review submission, release, rollout, or publication occurred.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_AI_ASSET_DECLARATION_LABEL_ALL_SAVED_AS_DRAFT`
- `PARTIAL_AI_ASSET_DECLARATION_DURABLE_STATE_UNVERIFIED`
- `BLOCKED_AI_DECLARATION_SCHEMA_DRIFT`
- `BLOCKED_AI_DECLARATION_REQUIRES_PER_ASSET_REVIEW`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_PROVIDER_SAVE`

## Final response

Return:
1. disposition;
2. selected declaration;
3. exact persistence control used;
4. durable-state verification;
5. Dashboard completion count;
6. Publishing overview state;
7. `Send app for review` enabled/disabled;
8. evidence commit SHA if available;
9. confirmation no review submission/release/rollout/publication occurred;
10. next ONE action only.
