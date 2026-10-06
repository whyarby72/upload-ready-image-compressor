# CODEX — MAIN STORE LISTING REVIEW SAVE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current reconciled provider state

- Dashboard = `10 of 11 complete`
- only incomplete item = `Set up your store listing`
- Main store listing = `Draft`
- Review step = `AI asset declaration`
- AI labels survive reload for:
  - App icon
  - Feature graphic
  - all 4 Phone screenshots
- `Save as draft` = disabled
- `Save` = enabled
- no validation/error message
- warning:
  `If you save, changes will be saved in Publishing overview, ready for you to send for review`
- Publishing overview already contains pending changes
- `Send app for review` = disabled

Provider-state classification:
`NO_UNSAVED_CHANGES_AI_DIALOG_ALREADY_PERSISTED`

Interpretation:
the AI asset dialog state is already durable, but the broader Review step still requires the enabled `Save` control to complete the store-listing prerequisite. The provider warning indicates this action persists the Review step into Publishing overview; it does not itself say that it sends the app for review.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not mutate Play Console until CURRENT_TASK explicitly grants:

`MAIN_STORE_LISTING_REVIEW_SAVE`

## Future authorized scope after explicit approval

Only after approval:

1. verify app/package context;
2. verify Dashboard remains `10 of 11 complete`;
3. open Main store listing Review step;
4. verify AI declaration and all six asset labels remain present;
5. verify `Save as draft` remains disabled;
6. verify `Save` remains enabled;
7. verify warning still materially says changes will be saved in Publishing overview and be ready to send for review later;
8. click `Save` exactly once;
9. handle no broader confirmation unless separately covered by this contract;
10. reload/re-open Dashboard;
11. verify whether Dashboard becomes `11 of 11 complete`;
12. verify whether `Set up your store listing` now has a check;
13. inspect Publishing overview read-only;
14. record whether `Send app for review` becomes enabled or remains disabled;
15. confirm no review submission occurred;
16. STOP.

## Hard stop boundaries

STOP before further confirmation if:

- `Save` wording or warning changes materially;
- a confirmation says the app/listing will be submitted for review immediately;
- a confirmation says the app/listing will be published/released/rolled out;
- additional unrelated changes are bundled into an irreversible action;
- app/package context is wrong.

Allowed blockers:
- `BLOCKED_REVIEW_SAVE_SCHEMA_DRIFT`
- `BLOCKED_REVIEW_SAVE_IMMEDIATE_SUBMISSION`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_MAIN_STORE_LISTING_REVIEW_SAVE_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- pre-save Dashboard count;
- exact Review-step title;
- AI declaration/category state;
- exact `Save` warning;
- exact action clicked;
- any confirmation text;
- post-save Dashboard count;
- whether `Set up your store listing` has a check;
- Publishing overview observation;
- `Send app for review` state;
- confirmation no review submission, release, rollout, or publication occurred.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_MAIN_STORE_LISTING_REVIEW_SAVED`
- `PARTIAL_REVIEW_SAVE_DURABLE_STATE_UNVERIFIED`
- `BLOCKED_REVIEW_SAVE_SCHEMA_DRIFT`
- `BLOCKED_REVIEW_SAVE_IMMEDIATE_SUBMISSION`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_PROVIDER_SAVE`

## Final response

Return:
1. disposition;
2. pre-save Dashboard count;
3. exact action clicked;
4. post-save Dashboard count;
5. whether Store listing item now has a check;
6. Publishing overview state;
7. `Send app for review` enabled/disabled;
8. evidence commit SHA if available;
9. confirmation no review submission/release/rollout/publication occurred;
10. next ONE action only.
