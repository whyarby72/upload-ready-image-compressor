# CODEX — PLAY CONSOLE REMAINING DASHBOARD PREREQUISITE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Mission

Current reconciled provider state reports:
- Dashboard = `10 of 11 complete`;
- App content = `You're all caught up`;
- 10 actioned declarations;
- Main store listing = Draft and persisted;
- Store settings/category/contact = completed;
- `Send app for review` = disabled.

Identify the exact remaining Dashboard prerequisite that keeps setup at 10/11 complete.

## Scope

READ-ONLY ONLY.

Do NOT:
- edit any field;
- click Save / Save as draft / Save and publish;
- click Next if it advances or mutates setup;
- click Send app for review;
- create/edit releases or tracks;
- change Managed Publishing;
- upload artifacts;
- publish/release.

## Context preflight

Verify:
- app = `Photo Compressor: KB Limit`;
- package if visible = `com.afradadmedia.reducephotosize`;
- correct provider/account context.

If wrong:
`BLOCKED_WRONG_PROVIDER_CONTEXT`

## Inspection

1. Open Dashboard / Set up your app.
2. Record all 11 setup items exactly as displayed.
3. Mark each item:
   - COMPLETE
   - INCOMPLETE
   - UNKNOWN
4. Identify the single incomplete prerequisite.
5. Open that incomplete item only if it can be inspected without mutation.
6. Record:
   - exact title;
   - exact provider wording;
   - exact required action(s);
   - whether it requires an app bundle/release/test track;
   - whether it is a store/listing item;
   - whether it requires a policy declaration;
   - whether completing it would cross a release/publication boundary;
   - any account-specific requirement shown.
7. Return one recommended next action only; do not execute it.
8. Confirm zero provider mutation.

## Allowed dispositions

- `PASS_REMAINING_DASHBOARD_PREREQUISITE_IDENTIFIED`
- `PARTIAL_REMAINING_DASHBOARD_PREREQUISITE_NOT_FULLY_VISIBLE`
- `HOLD_REMAINING_PREREQUISITE_REQUIRES_MUTATION_TO_INSPECT`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Evidence

If repo workspace is available, create:
`evidence/play/W2_REMAINING_DASHBOARD_PREREQUISITE_2026_10_06_v1.0.md`

Commit only that evidence file.

## Final response

Return:
1. disposition;
2. all 11 dashboard items with status;
3. exact incomplete item;
4. exact provider wording;
5. required action(s);
6. risk/approval boundary;
7. next ONE action only;
8. confirmation zero provider mutation;
9. evidence commit SHA if available.
