# CODEX — MAIN STORE LISTING REVIEW STEP INSPECTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current known state

Dashboard:
`10 of 11 complete`

Only incomplete item:
`Set up your store listing`

Provider wording:
`Provide information about your app and set up your store listing`

Current Main store listing state:
`Draft`

Persisted listing already contains:
- app name;
- short description;
- full description;
- app icon;
- feature graphic;
- 4 phone screenshots.

Visible controls:
- `Save as draft`
- `Next`

## IMPORTANT

This is an inspection contract only.

It is NOT authorized for execution until CURRENT_TASK contains a new explicit human approval for:
`MAIN_STORE_LISTING_REVIEW_STEP_INSPECTION`

## Future authorized scope

Only after explicit approval:

1. verify active app/package context;
2. open Main store listing;
3. confirm durable draft state is still present;
4. click `Next` only to inspect the provider Review step;
5. do not edit any listing field;
6. do not click Save / Save as draft / Save and publish;
7. do not confirm, submit, publish, or send for review;
8. record exact Review-step wording, warnings, controls, and whether entering the step itself changes provider state;
9. record whether completing the Review step would only mark Dashboard setup complete or would also stage/submit broader changes;
10. STOP before any action that would persist, submit, publish, or send for review.

## Hard stop

If clicking `Next` causes any immediate mutation, confirmation, submission, publication, or irreversible transition:
- STOP before confirming anything further;
- return `BLOCKED_REVIEW_STEP_EXCEEDS_INSPECTION_SCOPE`.

## Required output

Return:
1. disposition;
2. exact Review-step screen title;
3. exact explanatory/provider wording;
4. exact controls/buttons;
5. whether provider state changed by opening the step;
6. whether Dashboard would become 11/11 merely by completing this Review step;
7. whether any review/submission/publication boundary is present;
8. next ONE action only;
9. confirmation no submit/review/release/publication action occurred.

Allowed dispositions:
- `PASS_MAIN_STORE_LISTING_REVIEW_STEP_INSPECTED`
- `PARTIAL_MAIN_STORE_LISTING_REVIEW_STEP_AMBIGUOUS`
- `BLOCKED_REVIEW_STEP_EXCEEDS_INSPECTION_SCOPE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

If repo workspace is available, create:
`evidence/play/W2_MAIN_STORE_LISTING_REVIEW_STEP_INSPECTION_2026_10_06_v1.0.md`

Commit only that evidence file.
