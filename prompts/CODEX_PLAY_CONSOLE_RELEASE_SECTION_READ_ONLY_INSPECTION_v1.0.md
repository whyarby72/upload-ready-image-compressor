# CODEX — PLAY CONSOLE RELEASE SECTION READ-ONLY INSPECTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current reconciled state

Main store listing Review was saved successfully.

Observed provider result:
`Change saved. Send for review in Publishing overview.`

After reload:
- prior `Set up your store listing` incomplete card disappeared;
- prior `10 of 11 complete` checklist disappeared;
- `Release your app` section is now open;
- Publishing overview shows `Changes not yet submitted for review`;
- `Send app for review` remains disabled;
- no review submission, release, track, rollout, or publication occurred.

## Mission

Inspect the newly exposed `Release your app` section and identify the exact remaining prerequisites before any release/test-track mutation.

## Scope

READ-ONLY ONLY.

Do NOT:
- upload an AAB/APK;
- create or edit any release;
- create/select/promote any test or production track;
- opt into Play App Signing;
- change countries/regions;
- change managed publishing;
- click Save / Save as draft / Next if it mutates provider state;
- click Send app for review;
- start rollout;
- publish/release.

## Required inspection

### A. Dashboard / Release your app

Record every visible card/task under `Release your app` exactly as displayed.

For each item record:
- title;
- exact provider wording;
- completion state;
- visible control/button;
- whether opening it is read-only or could mutate state.

### B. Testing / release prerequisites

If visible without mutation, determine:
- whether Google Play requires internal, closed, open, or production track setup;
- whether an app bundle (AAB) is required;
- whether Play App Signing setup is required;
- whether a tester list / testing requirement appears;
- whether a production access requirement appears;
- whether any account-specific testing threshold/duration is shown;
- whether country/region selection is required;
- whether release notes are required;
- whether version code/version name expectations are visible.

Do not infer missing account-specific requirements. Mark `UNKNOWN` if not shown.

### C. App bundle / artifact readiness boundary

Record any visible artifact requirements:
- Android App Bundle;
- target API;
- signing;
- integrity;
- deobfuscation/native debug symbols if shown;
- warnings/errors if shown.

Do not upload anything.

### D. Publishing overview

Read-only:
- record current pending change groups;
- record whether `Send app for review` is enabled/disabled;
- record any wording that explains why it remains disabled.

### E. Next action

Return ONE next provider action only, not executed.

Prefer the smallest reversible prerequisite that unlocks the next gate.

## Evidence discipline

Use:
- `VISIBLE_PROVIDER_STATE` for directly observed UI;
- `INFERENCE` only when necessary;
- `UNKNOWN` where not visible.

Do not confuse:
- release setup;
- review submission;
- rollout/publication.

## Allowed dispositions

- `PASS_RELEASE_SECTION_PREREQUISITES_IDENTIFIED`
- `PARTIAL_RELEASE_SECTION_INCOMPLETE_VISIBILITY`
- `HOLD_RELEASE_SECTION_CONFLICTING_STATE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Evidence

If repo workspace is available, create:

`evidence/play/W2_RELEASE_SECTION_READ_ONLY_INSPECTION_2026_10_06_v1.0.md`

Commit only that evidence file.

## Final response

Return:
1. disposition;
2. exact app/package context;
3. all visible `Release your app` items;
4. exact incomplete item(s);
5. exact artifact/testing/signing prerequisites;
6. any account-specific requirement shown;
7. Publishing overview state;
8. `Send app for review` enabled/disabled and why if visible;
9. next ONE action only;
10. confirmation zero provider mutation;
11. evidence commit SHA if available.
