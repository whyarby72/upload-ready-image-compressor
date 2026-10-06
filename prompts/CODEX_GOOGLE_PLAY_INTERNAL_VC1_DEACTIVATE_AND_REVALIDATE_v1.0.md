# CODEX — DEACTIVATE INTERNAL TESTING VC1 AND REVALIDATE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider root cause

Production:
- only VC3 is attached;
- VC3 = versionCode 3 / versionName 0.1.0 / targetSdk 36;
- Google Play recognizes VC3 contains:
  `com.google.android.gms.permission.AD_ID`.

Other tracks:
- VC1 is still active in Internal testing;
- VC1 does NOT contain AD_ID permission;
- VC2 is inactive;
- Closed/Open testing have no active release.

Root-cause classification:
`STALE_OR_OTHER_ACTIVE_ARTIFACT_CAUSING_MISMATCH`

Smallest corrective action:
deactivate/remove the active Internal testing VC1 release so only the corrected AD_ID-compatible artifact remains active.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not mutate Internal testing until CURRENT_TASK explicitly grants:

`DEACTIVATE_INTERNAL_TESTING_VC1`

## Future authorized scope after explicit approval

Only after approval:

1. Refresh canonical branch and record exact HEAD.
2. Verify Play Console app/package:
   - `Photo Compressor: KB Limit`
   - `com.afradadmedia.reducephotosize`
3. Open Internal testing.
4. Verify the active Internal testing artifact/release is VC1:
   - versionCode 1
   - versionName 0.1.0 if shown
5. Record exact release status and exact available deactivation/removal controls.
6. Use the narrowest provider control that deactivates/removes VC1 from the active Internal testing track.
7. If a confirmation dialog appears:
   - confirm only if it clearly affects Internal testing VC1 / the current internal release;
   - STOP if wording could affect Production, VC3, or all tracks.
8. Verify after mutation:
   - VC1 is no longer active in Internal testing;
   - VC3 remains unchanged in Production;
   - no other active stale artifact remains.
9. Return to Production validation.
10. Re-run/inspect Advertising ID validation.
11. Verify whether the AD_ID blocker is cleared.
12. STOP before any review submission / rollout / publication action.

## Do NOT

- remove or alter Production VC3;
- upload another artifact;
- create VC4;
- change Advertising ID declaration;
- click `Release without permission`;
- change store listing;
- change countries/regions;
- create/edit Closed/Open testing;
- click `Send app for review`;
- rollout;
- publish.

## Hard stops

Use:
- `BLOCKED_INTERNAL_VC1_CONTROL_AMBIGUOUS` if the provider control cannot be proven to affect Internal testing VC1 only;
- `BLOCKED_PRODUCTION_VC3_CHANGED` if VC3 is altered;
- `BLOCKED_AD_ID_PROVIDER_VALIDATION_PERSISTS` if the mismatch remains after VC1 is no longer active;
- `BLOCKED_PROVIDER_VALIDATION` for any new blocking validation.

## Best-case disposition

`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL_VC3`

## Evidence

Create:
`evidence/play/W2_INTERNAL_VC1_DEACTIVATE_REVALIDATE_2026_10_07_v1.0.md`

Include:
- disposition;
- canonical HEAD;
- pre-mutation Internal testing VC1 state;
- exact provider control used;
- confirmation wording if any;
- post-mutation Internal testing state;
- Production VC3 state;
- AD_ID validation result;
- exact next material control not clicked;
- confirmation no review submission/rollout/publication occurred.

Commit only the text evidence report.

## Final response

Return:
1. disposition
2. canonical HEAD
3. pre-mutation Internal testing VC1 state
4. exact provider control used
5. post-mutation Internal testing state
6. Production VC3 state
7. AD_ID validation result
8. any remaining blocker
9. exact next material control not clicked
10. evidence commit SHA if available
11. confirmation no review submission/rollout/publication occurred
