# CODEX — REMOVE VC2 WITH ROW-BOUND CONFIRMATION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current blocker

Both VC2 and VC3 are visible in the Production draft.

Opening the overflow/menu on the VC2 row and choosing:
`Remove app bundle`

opens a generic confirmation dialog:
`Remove app bundle from release?`

The dialog itself does not repeat the versionCode, so the prior task correctly stopped.

## Mission

Allow removal of VC2 only by proving the removal action is row-bound to the visible VC2 entry immediately before confirmation.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not confirm removal until CURRENT_TASK explicitly grants:
`REMOVE_VC2_USING_ROW_BOUND_CONFIRMATION`

## Required proof before confirmation

Immediately before opening the row menu:

1. Verify both artifacts are visible.
2. Identify the exact row/card for:
   - versionCode = 2
3. Record enough visible row identity to distinguish it from VC3, including any available:
   - versionCode;
   - versionName;
   - file name;
   - upload status;
   - bundle identifier/details.
4. Open the overflow/menu from THAT VC2 row only.
5. Select `Remove app bundle`.
6. Verify the generic dialog appears directly as the immediate result of the VC2-row action.
7. Do not interact with VC3's menu at any point.

If the UI focus/menu origin becomes ambiguous, STOP:
`BLOCKED_VC2_ROW_ORIGIN_NOT_PROVABLE`

## Authorized future action after explicit approval

Only after `REMOVE_VC2_USING_ROW_BOUND_CONFIRMATION` is present:

- confirm the generic removal dialog exactly once;
- verify VC2 disappears;
- verify VC3 remains;
- verify vc3 is still:
  - versionCode 3
  - versionName 0.1.0
- re-run/inspect provider validation;
- confirm whether the Advertising ID blocker is gone;
- STOP before any review submission, rollout, or publication.

## Hard stops

STOP if:
- VC2/VC3 row identity is not visually distinct;
- more than one row menu is open/active;
- the generic dialog was not opened directly from the VC2 row;
- provider state changes so the target row cannot be re-identified;
- vc3 disappears after removal;
- any new confirmation extends beyond removal of one bundle.

Allowed blockers:
- `BLOCKED_VC2_ROW_ORIGIN_NOT_PROVABLE`
- `BLOCKED_VC3_MISSING_AFTER_REMOVAL`
- `BLOCKED_AD_ID_PROVIDER_VALIDATION_PERSISTS`
- `BLOCKED_PROVIDER_VALIDATION`

## Best-case disposition

`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL_VC3`

## Evidence

Create:
`evidence/play/W2_REMOVE_VC2_ROW_BOUND_2026_10_06_v1.0.md`

Include:
- canonical HEAD;
- pre-removal artifact list;
- exact VC2 row identity used;
- proof the menu was opened from VC2 row;
- generic dialog wording;
- whether confirmation occurred;
- post-removal artifact list;
- vc3 presence;
- AD_ID validation result;
- exact next material control not clicked;
- confirmation no review submission/rollout/publication occurred.

Commit only the text evidence report.

## Final response

Return:
1. disposition
2. canonical HEAD
3. exact VC2 row identity used
4. proof of row-bound menu origin
5. generic dialog wording
6. post-removal artifact list
7. AD_ID validation result
8. any remaining blocker
9. exact next material control not clicked
10. evidence commit SHA if available
11. confirmation no review submission/rollout/publication occurred
