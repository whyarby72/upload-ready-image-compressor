# CODEX — CLOSED TEST COUNTRY SELECTOR OPEN / INSPECTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current blocker

Closed testing country/region page is empty.

Observed controls:
- `Add countries / regions`
- `Add and sync countries / regions`

Search, Select all, Clear all, and country rows are not visible until `Add countries / regions` is opened.

The prior read-only contract intentionally stopped before pressing `Add countries / regions`.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not interact with the country selector until CURRENT_TASK explicitly grants:

`CLOSED_TEST_COUNTRY_SELECTOR_OPEN_INSPECTION`

## Future authorized scope after explicit approval

Only after approval:

1. verify app/package context;
2. navigate to Closed testing > Countries / regions;
3. verify current list is still empty/unconfigured;
4. click `Add countries / regions` ONLY to open the selector;
5. inspect and record:
   - exact dialog/screen title;
   - search field;
   - Select all / Clear all controls;
   - visible country rows;
   - selection count/status;
   - Save/Add/Apply/Cancel controls;
   - whether any country is preselected;
   - any warning or availability text;
6. do NOT select any country;
7. do NOT deselect any country;
8. do NOT click Save/Add/Apply/Confirm;
9. close/cancel the selector only if that does not mutate provider state;
10. STOP.

## Hard stop

If clicking `Add countries / regions` itself immediately persists a country selection or causes broader mutation:
STOP and return:
`BLOCKED_COUNTRY_SELECTOR_OPEN_CAUSES_MUTATION`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_CLOSED_TEST_COUNTRY_SELECTOR_OPEN_INSPECTION_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- exact selector title;
- available controls;
- current selection count;
- whether any preselection exists;
- any warning/restriction wording;
- confirmation zero country selection/save mutation;
- next ONE action only.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_CLOSED_TEST_COUNTRY_SELECTOR_INSPECTED`
- `PARTIAL_CLOSED_TEST_COUNTRY_SELECTOR_INCOMPLETE_VISIBILITY`
- `BLOCKED_COUNTRY_SELECTOR_OPEN_CAUSES_MUTATION`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Final response

Return:
1. disposition;
2. exact selector title;
3. current selected-country count/state;
4. available controls;
5. whether any country is preselected;
6. warnings/restrictions;
7. next ONE action only;
8. confirmation zero provider mutation;
9. evidence commit SHA if available.
