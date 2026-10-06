# CODEX — GOOGLE PLAY FINAL SEND-FOR-REVIEW v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current release-ready state

- Production release draft exists.
- Production upload accepted.
- Signed AAB:
  - versionCode = 2
  - versionName = 0.1.0
  - targetSdk = 36
  - SHA-256 = `da4b862c70fd65f779890ae45339b16f6fb159ff607d37be6bb4957b337eaeb8`
- Global countries/regions selection is present.
- Store listing and required app-content declarations are staged.
- AI asset labeling is complete for:
  - App icon
  - Feature graphic
  - all 4 phone screenshots
- Current next material provider control:
  `Send app for review`
- No review submission has occurred yet.

## IMPORTANT

THIS FILE IS AN EXECUTION CONTRACT, NOT AN AUTHORIZATION.

Do not click `Send app for review` until CURRENT_TASK explicitly grants:

`GOOGLE_PLAY_FINAL_SEND_FOR_REVIEW`

This is a MATERIAL LAUNCH BOUNDARY.

With Managed publishing off, approved changes can be published automatically by Google Play after review. Treat this as the final review/submission action for the first production launch.

## Future authorized scope after explicit approval

Only after approval:

1. Refresh canonical branch and record exact HEAD.
2. Verify correct Play app/package:
   - `Photo Compressor: KB Limit`
   - `com.afradadmedia.reducephotosize`
3. Verify Production release still references versionCode 2 / versionName 0.1.0.
4. Verify no provider validation errors.
5. Verify the pending review set contains the intended launch changes only:
   - Production release vc2
   - Store listing
   - App content declarations
   - Content rating
   - Target audience
   - Privacy policy
   - Ads declaration
   - Data safety
   - Health apps
   - Store settings / App category
   - AI asset declaration / labeled assets where surfaced
6. Verify global countries/regions remain selected.
7. Verify Managed publishing state exactly as shown.
8. If any unexpected pending change is present, STOP:
   `BLOCKED_UNEXPECTED_PENDING_CHANGE`
9. If the provider shows a pre-submit summary/confirmation, inspect it and verify it is only review submission for this app/release.
10. Click `Send app for review` exactly once.
11. If a confirmation dialog appears with materially matching review-submission semantics, confirm exactly once.
12. Do NOT make any other provider mutation.
13. After submission, record:
   - resulting review status;
   - Production release status;
   - Publishing overview state;
   - whether any further action is required;
   - whether the app is waiting for review, in review, approved, ready to publish, or published.
14. STOP.

## Hard stop boundaries

STOP before confirming if:
- app/package is wrong;
- production artifact is not vc2;
- an unexpected pending change is included;
- provider asks to change countries/regions, testers, pricing, signing, or declarations;
- provider shows a rollout percentage or publication control not clearly part of the already-prepared production release;
- any new validation blocker appears.

Allowed blockers:
- `BLOCKED_UNEXPECTED_PENDING_CHANGE`
- `BLOCKED_PRODUCTION_ARTIFACT_MISMATCH`
- `BLOCKED_PROVIDER_VALIDATION`
- `BLOCKED_REVIEW_SUBMISSION_SCHEMA_DRIFT`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Never do under this contract

- do not modify store listing;
- do not modify app content declarations;
- do not upload another artifact;
- do not change countries/regions;
- do not create testing tracks;
- do not change Managed publishing;
- do not manually start any extra rollout/publish action beyond the exact review submission flow.

## Evidence

Create:
`evidence/play/W2_GOOGLE_PLAY_FINAL_SEND_FOR_REVIEW_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- app/package;
- production versionCode/versionName/targetSdk;
- AAB SHA-256;
- exact pending change set;
- Managed publishing state;
- exact review-submission control clicked;
- confirmation wording if any;
- resulting provider status;
- whether any further action remains;
- confirmation no unrelated provider mutation occurred.

Commit only the text evidence report.

## Allowed terminal dispositions

- `PASS_GOOGLE_PLAY_SENT_FOR_REVIEW`
- `PASS_GOOGLE_PLAY_ALREADY_PUBLISHED_AFTER_REVIEW`
- `BLOCKED_UNEXPECTED_PENDING_CHANGE`
- `BLOCKED_PRODUCTION_ARTIFACT_MISMATCH`
- `BLOCKED_PROVIDER_VALIDATION`
- `BLOCKED_REVIEW_SUBMISSION_SCHEMA_DRIFT`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

## Final response

Return:
1. disposition
2. canonical HEAD
3. production versionCode/versionName/targetSdk
4. AAB SHA-256
5. exact pending change set
6. Managed publishing state
7. exact control/confirmation used
8. resulting provider review/publication status
9. whether any further action remains
10. evidence commit SHA if available
11. confirmation no unrelated provider mutation occurred
