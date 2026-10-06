# CODEX — MAIN STORE LISTING REVIEW SAVE-AS-DRAFT v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider state

- Main store listing = `Draft`
- Review step = `AI asset declaration`
- AI declaration choice = `Label assets as created or edited using AI`
- Provider category dialog completed for:
  - `App icon`
  - `Feature graphic`
  - `Phone screenshots` (all 4)
- Category dialog control previously used:
  - `Label assets and submit`
- After that dialog action:
  - returned to Review step;
  - listing remained Draft;
  - Dashboard remained `10 of 11 complete`;
  - Publishing overview remained `Changes not yet submitted for review`;
  - `Send app for review` remained disabled;
  - listing `Save` / `Save as draft` were NOT clicked.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not mutate Play Console until CURRENT_TASK explicitly grants:

`MAIN_STORE_LISTING_REVIEW_SAVE_AS_DRAFT`

## Future authorized scope after explicit approval

Only after approval:

1. verify active app/package context;
2. open Main store listing Review step;
3. verify the AI declaration is still selected;
4. verify the three AI asset categories remain represented as labeled;
5. verify controls still include `Save as draft`;
6. click `Save as draft` ONLY;
7. do NOT click `Save` if it has broader semantics;
8. reload/re-open Main store listing and Dashboard;
9. verify durable Review-step declaration state;
10. verify whether Dashboard becomes `11 of 11 complete`;
11. inspect Publishing overview read-only;
12. record whether `Send app for review` becomes enabled or remains disabled;
13. STOP.

## Hard stop boundaries

STOP before mutation or further confirmation if:
- AI declaration/category state is missing or changed;
- `Save as draft` is no longer available;
- a second confirmation implies review submission, publication, release, or rollout;
- app/package context is wrong.

Allowed blockers:
- `BLOCKED_REVIEW_SAVE_AS_DRAFT_SCHEMA_DRIFT`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_MAIN_STORE_LISTING_REVIEW_SAVE_AS_DRAFT_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- exact Review-step title;
- AI declaration state;
- AI category state;
- exact persistence control used;
- durable-state verification;
- Dashboard count after reload;
- Publishing overview observation;
- `Send app for review` state;
- confirmation no review submission/release/rollout/publication occurred.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_MAIN_STORE_LISTING_REVIEW_SAVED_AS_DRAFT`
- `PARTIAL_REVIEW_DURABLE_STATE_UNVERIFIED`
- `BLOCKED_REVIEW_SAVE_AS_DRAFT_SCHEMA_DRIFT`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_PROVIDER_SAVE`

## Final response

Return:
1. disposition;
2. exact Review-step title;
3. AI declaration state;
4. AI category state;
5. exact persistence control used;
6. durable-state verification;
7. Dashboard completion count;
8. Publishing overview state;
9. `Send app for review` enabled/disabled;
10. evidence commit SHA if available;
11. confirmation no review submission/release/rollout/publication occurred;
12. next ONE action only.
