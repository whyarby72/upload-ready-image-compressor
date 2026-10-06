# CODEX — REMOVE VC2 FROM PRODUCTION DRAFT AND REVALIDATE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Explicit human authorization

Authorized scope:
`REMOVE_VC2_FROM_PRODUCTION_DRAFT_ONLY`

## Current known state

Production draft currently contains:
- versionCode 2 — obsolete artifact lacking AD_ID permission
- versionCode 3 — corrected artifact with AD_ID permission

Corrected vc3 artifact:
- versionCode = 3
- versionName = 0.1.0
- targetSdk = 36
- signed AAB SHA-256 = `cc13f4faaf78c15deaa5bb4826659b154ff437fb092931b5b0f1241f4aa15c1f`

## Mission

Remove ONLY versionCode 2 from the existing Production draft, keep versionCode 3 attached, then re-run/inspect provider validation.

## Required sequence

1. Refresh canonical branch and record exact HEAD.
2. Open the correct app/package in Google Play Console.
3. Open the current Production draft.
4. Verify both vc2 and vc3 are visible before mutation.
5. Verify the target removal control refers specifically to versionCode 2.
6. Click `Remove app bundle` for vc2 only.
7. If a confirmation dialog appears:
   - confirm only if it clearly refers to vc2 only;
   - otherwise STOP.
8. Verify vc2 is gone.
9. Verify vc3 remains attached.
10. Re-run or inspect release validation.
11. Record whether the prior Advertising ID blocker is cleared.
12. Record any new blocker exactly.
13. STOP before any review submission / rollout / publication action.

## Do NOT

- remove vc3;
- remove both artifacts;
- upload another artifact;
- modify declarations;
- modify store listing;
- modify countries/regions;
- click `Send app for review`;
- click `Send release to Google for review`;
- rollout;
- publish.

## Hard stops

Use:
- `BLOCKED_VC2_REMOVAL_AMBIGUOUS` if artifact identity is unclear;
- `BLOCKED_VC3_MISSING_AFTER_REMOVAL` if vc3 is no longer attached;
- `BLOCKED_AD_ID_PROVIDER_VALIDATION_PERSISTS` if AD_ID mismatch remains;
- `BLOCKED_PROVIDER_VALIDATION` for any other blocking validation.

## Best-case disposition

`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL_VC3`

## Evidence

If repo workspace is available, create:
`evidence/play/W2_REMOVE_VC2_REVALIDATE_2026_10_06_v1.0.md`

Include:
- disposition;
- canonical HEAD;
- pre-removal artifact list;
- exact removal control used;
- post-removal artifact list;
- vc3 SHA-256 reference;
- validation result;
- exact next material control not clicked;
- confirmation no review submission/rollout/publication occurred.

Commit only the evidence report.

## Final response

Return:
1. disposition
2. canonical HEAD
3. pre-removal artifact list
4. exact removal action
5. post-removal artifact list
6. AD_ID validation result
7. any remaining blocker
8. exact next material control not clicked
9. evidence commit SHA if available
10. confirmation no review submission/rollout/publication occurred
