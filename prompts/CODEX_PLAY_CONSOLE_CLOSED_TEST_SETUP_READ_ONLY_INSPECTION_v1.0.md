# CODEX — PLAY CONSOLE CLOSED TEST SETUP READ-ONLY INSPECTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current reconciled provider state

Production:
`Inactive`

Release-section inspection found these visible paths:

Closed testing:
- Set up closed test track
- Select countries and regions
- Select testers
- Create new release
- Preview/confirm and send for review locked

Open testing:
- Set up open test track
- Select countries and regions
- Create new release
- Preview/confirm and send for review locked

Pre-registration:
- Upload an app bundle or APK
- Select countries and regions
- Optional reward
- Send release for review

Production:
- Select countries and regions
- Create new release
- Preview/confirm
- Send release for review
- Publish app locked

Publishing overview:
- Managed publishing = off
- Send app for review = disabled
- provider reason:
  `To send changes for review, complete the required steps in the app dashboard`

## Mission

Inspect the Closed testing setup in detail, READ-ONLY, to determine the exact smallest next prerequisite before any track/release mutation.

## Scope

READ-ONLY ONLY.

Do NOT:
- create a closed test track;
- select or save countries/regions;
- create/edit a tester list;
- add emails or Google Groups;
- upload AAB/APK;
- create/edit a release;
- opt into Play App Signing;
- click Save / Next / Confirm if it mutates provider state;
- send for review;
- start rollout;
- publish.

## Required inspection

### A. Closed testing landing/setup screen

Open the Closed testing setup area and record:
- exact page/screen title;
- exact step sequence;
- exact provider wording;
- which steps are currently locked/unlocked;
- visible controls/buttons;
- whether any step can be opened read-only without mutation.

### B. Countries and regions

If inspectable without mutation, record:
- whether no countries are selected yet;
- whether provider offers "all countries/regions" or granular selection;
- any default state;
- any warning about changing availability later;
- whether selection appears mandatory before release creation.

Do not select anything.

### C. Testers

If inspectable without mutation, record:
- supported tester mechanisms shown:
  - email list;
  - Google Groups;
  - other provider mechanism;
- any visible minimum tester count;
- any visible maximum count;
- any invitation-link behavior;
- whether list creation itself is a mutation;
- whether tester count/duration requirements are shown for this account.

Do not create or modify any list.

### D. Release creation entry

Open only if provider permits read-only entry without starting a release.

Record:
- whether AAB/APK upload is required;
- whether an existing artifact is offered;
- whether Play App Signing setup appears;
- whether release notes are required;
- whether version code/name, target API, integrity, symbols, or warnings appear;
- exact controls available.

Do not upload or create anything.

### E. Account-specific gating

Record any provider/account-specific requirement shown, including:
- minimum number of testers;
- minimum testing duration;
- production-access eligibility;
- account age/history requirement;
- identity verification;
- device verification;
- payment/profile requirement;
- other restriction.

If not shown, mark `UNKNOWN`.

### F. Compare closed vs open testing

From visible UI only, determine whether Closed testing is materially lower-friction than Open testing for this account.

Return:
- FACT from provider UI;
- INFERENCE only when necessary;
- UNKNOWN where not visible.

### G. Next action

Return ONE next provider action only, not executed.

Prefer the smallest reversible action that advances toward a valid first release without crossing review/publication.

## Evidence

If repo workspace is available, create:

`evidence/play/W2_CLOSED_TEST_SETUP_READ_ONLY_INSPECTION_2026_10_06_v1.0.md`

Commit only that evidence file.

## Allowed terminal dispositions

- `PASS_CLOSED_TEST_SETUP_PREREQUISITES_IDENTIFIED`
- `PARTIAL_CLOSED_TEST_SETUP_INCOMPLETE_VISIBILITY`
- `HOLD_CLOSED_TEST_SETUP_ACCOUNT_REQUIREMENT_CONFLICT`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Final response

Return:
1. disposition;
2. exact closed-test setup step sequence;
3. countries/regions requirement;
4. tester mechanisms and any count/duration requirements;
5. release artifact/signing requirements;
6. account-specific gating;
7. closed-vs-open friction comparison;
8. next ONE action only;
9. confirmation zero provider mutation;
10. evidence commit SHA if available.
