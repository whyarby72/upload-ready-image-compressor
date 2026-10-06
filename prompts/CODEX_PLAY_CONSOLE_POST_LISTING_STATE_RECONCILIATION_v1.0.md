# CODEX — PLAY CONSOLE POST-LISTING STATE RECONCILIATION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Mission

The Main store listing v1.2 draft was reported as successfully saved and durable.

However, the same run reported the following sections as incomplete:
- Content Rating
- Target audience
- Privacy policy
- Ads declaration
- Data safety
- Health apps
- App category

This conflicts with prior provider observations in this project where many of those App content declarations were already completed/saved.

Perform a READ-ONLY reconciliation to determine whether the latest "incomplete" list refers to:
- actual incomplete App content declarations;
- stale dashboard setup cards;
- sections not yet published/reviewed;
- a different Play Console checklist/context;
- or a provider/UI interpretation error.

## Scope

READ-ONLY ONLY.

Do NOT:
- edit any declaration;
- edit listing text/media;
- click Save / Save as draft / Save and publish;
- click Next;
- click Send app for review;
- create/edit releases;
- promote tracks;
- change Managed Publishing;
- publish/release.

## Context preflight

1. Verify active app = `Photo Compressor: KB Limit`.
2. Verify package if visible = `com.afradadmedia.reducephotosize`.
3. Verify current provider account/app context before inspection.
4. If wrong context, STOP with `BLOCKED_WRONG_PROVIDER_CONTEXT`.

## Required reconciliation

Inspect and record exact current visible provider state for:

### A. Dashboard / Set up your app
- list every setup card/task;
- mark each as complete/incomplete;
- capture exact wording.

### B. Policy and programs > App content
For every visible section, record exact status:
- Content ratings
- Target audience and content
- Privacy policy
- Ads
- Data safety
- Health apps
- App access / sign-in details
- Government apps
- Financial features
- News
- any other current section

For each, distinguish:
- completed/saved;
- needs attention;
- incomplete;
- pending review;
- unavailable/not visible.

### C. Store presence > Store settings
Record:
- Application type
- Category
- Contact details
- whether currently saved/published.

### D. Store presence > Main store listing
Record:
- whether v1.2 text/assets are still present;
- whether the page shows draft/saved state;
- exact persistence control wording.

### E. Publishing overview
Record:
- exact pending change groups;
- whether Main store listing changes appear;
- whether App content changes appear;
- whether `Send app for review` is enabled/disabled.

### F. Content rating details
Open read-only and confirm whether ratings are actually assigned/saved.

## Evidence discipline

- Use `VISIBLE_PROVIDER_STATE` for directly observed UI.
- Use `INFERENCE` only when necessary and label it.
- If a section is not opened/visible, mark `UNKNOWN`.
- Do not overwrite prior history merely because a dashboard card uses broad wording.
- Reconcile the exact meaning of "incomplete" before recommending any mutation.

## Output

Return:

1. terminal disposition;
2. exact current app/package context;
3. table/list of Dashboard setup tasks;
4. table/list of App content sections and exact statuses;
5. Store settings current state;
6. Main store listing durable state;
7. Publishing overview pending changes;
8. `Send app for review` enabled/disabled;
9. exact explanation for why the prior run reported those seven sections as incomplete;
10. next ONE provider action only, not executed;
11. confirmation zero provider mutation occurred.

Allowed dispositions:
- `PASS_POST_LISTING_STATE_RECONCILED`
- `PARTIAL_POST_LISTING_STATE_INCOMPLETE_VISIBILITY`
- `HOLD_CONFLICTING_PROVIDER_STATE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

If repo workspace is available, create:
`evidence/play/W2_POST_LISTING_STATE_RECONCILIATION_2026_10_06_v1.0.md`

Commit only that evidence file.
