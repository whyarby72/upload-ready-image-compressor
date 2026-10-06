# CODEX — GOOGLE PLAY AD_ID PROVIDER RECONCILIATION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current conflict

Current Production draft contains only VC3.

VC3:
- versionCode = 3
- versionName = 0.1.0
- targetSdk = 36
- signed AAB SHA-256 = `cc13f4faaf78c15deaa5bb4826659b154ff437fb092931b5b0f1241f4aa15c1f`

Local artifact-bound verification has already proven the signed VC3 AAB contains:
`com.google.android.gms.permission.AD_ID`

Google Play nevertheless continues to show an Advertising ID validation blocker.

Do NOT change the Advertising ID declaration to No.
Do NOT use `Release without permission`.
The app intentionally uses Google Mobile Ads Next-Gen and the current declaration is expected to remain consistent with the ad-enabled release.

## Mission

Reconcile what Google Play itself currently sees for:
1. VC3 manifest permissions;
2. Advertising ID declaration;
3. any other active/referenced artifact/version that could still be causing the mismatch.

Use only the shortest provider inspection needed to resolve the blocker.

## Scope

READ-ONLY unless a provider navigation action is required to expose details.

Do NOT:
- change the Advertising ID declaration;
- click `Release without permission`;
- upload another bundle;
- create another versionCode;
- edit release content;
- send for review;
- rollout/publish.

## A. Verify current Production release

Record:
- only VC3 is attached to the Production draft;
- VC2 is absent;
- exact release status.

If any other artifact is attached:
`HOLD_UNEXPECTED_PRODUCTION_ARTIFACT`

## B. Inspect Play-recognized VC3 manifest / permissions

Open the provider surface that shows bundle/APK details (for example App bundle explorer / bundle details / manifest / permissions) for versionCode 3.

Record whether Google Play itself shows:
`com.google.android.gms.permission.AD_ID`

Classify:
- `PLAY_RECOGNIZES_AD_ID_ON_VC3`
- `PLAY_DOES_NOT_RECOGNIZE_AD_ID_ON_VC3`
- `PLAY_PERMISSION_VISIBILITY_UNKNOWN`

Do not rely on local artifact evidence for this step; this must be provider-visible evidence.

## C. Inspect Advertising ID declaration

Open the current Advertising ID declaration in read-only mode if possible.

Record:
- exact current answer;
- exact provider wording describing the mismatch;
- whether the declaration is tied to Android 13+ / target SDK behavior;
- whether the UI names a specific version code/artifact;
- whether `Update declaration` merely opens the declaration form or would immediately persist a change.

Do NOT save/change the declaration.

## D. Inspect all active/referenced release artifacts

Because versionCode 1 was previously reported as already used, inspect provider-visible tracks/artifact history only as needed to identify whether an older artifact is still active or referenced.

Check:
- Production
- Closed testing Alpha
- Open testing if any artifact exists
- Internal testing if present
- App bundle explorer/artifact library status for VC1, VC2, VC3

Record for each visible version:
- versionCode;
- track/status;
- whether active/inactive/draft/superseded;
- whether provider shows AD_ID permission.

Do not create/edit any track.

## E. Determine root cause

Classify exactly one:

1. `STALE_OR_OTHER_ACTIVE_ARTIFACT_CAUSING_MISMATCH`
2. `PLAY_NOT_RECOGNIZING_AD_ID_IN_VC3`
3. `ADVERTISING_ID_DECLARATION_STATE_MISMATCH`
4. `PLAY_VALIDATION_CACHE_OR_UI_STALE_STATE`
5. `ROOT_CAUSE_AMBIGUOUS`

## F. Smallest corrective action

Return ONE next action only, not executed.

Permitted recommendations may include:
- remove/deactivate one specific stale artifact if provider proves it is the cause;
- reopen/resave the existing Advertising ID declaration with the SAME truthful Yes answer if provider shows stale declaration state;
- rebuild a new version only if Play itself does not recognize AD_ID in VC3 and provider evidence proves VC3 is structurally wrong;
- wait/reload/revalidate only if provider evidence strongly supports stale validation/cache.

Do not recommend switching Advertising ID to No unless provider and artifact evidence prove the app truly does not use Advertising ID.

## Evidence

Create:
`evidence/play/W2_AD_ID_PROVIDER_RECONCILIATION_2026_10_07_v1.0.md`

Include:
- disposition;
- canonical HEAD;
- Production artifact list;
- Play-recognized VC3 AD_ID permission state;
- Advertising ID declaration state;
- all relevant version/track states;
- root-cause classification;
- next one action;
- confirmation zero provider mutation.

Commit only the text evidence report.

## Allowed dispositions

- `PASS_AD_ID_PROVIDER_ROOT_CAUSE_IDENTIFIED`
- `PARTIAL_AD_ID_PROVIDER_ROOT_CAUSE_AMBIGUOUS`
- `HOLD_UNEXPECTED_PRODUCTION_ARTIFACT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Final response

Return:
1. disposition
2. canonical HEAD
3. Production artifact list
4. Play-recognized VC3 AD_ID permission state
5. Advertising ID declaration state
6. relevant VC1/VC2/VC3 track/artifact states
7. root-cause classification
8. next ONE action only
9. confirmation zero provider mutation
10. evidence commit SHA if available
