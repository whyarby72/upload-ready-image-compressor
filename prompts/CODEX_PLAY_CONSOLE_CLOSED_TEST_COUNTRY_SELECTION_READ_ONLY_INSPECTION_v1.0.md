# CODEX — CLOSED TEST COUNTRY SELECTION READ-ONLY INSPECTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current provider state

Closed testing:
- track = `Closed testing - Alpha`
- status = `Inactive`
- releases = none

Closed testing setup sequence:
1. `Set up your closed test track`
2. `Select countries and regions`
3. `Select testers`
4. `Create and roll out a release`

Countries/regions controls observed:
- `Add countries / regions`
- `Add and sync countries / regions`

No country is currently visibly selected.

Testers:
- email lists supported
- Google Groups supported
- existing email list `emailaku` with 1 user
- no minimum tester count/duration shown

## Mission

Inspect the Closed testing country/region selection state in detail, READ-ONLY, to determine the smallest safe country-scope decision before any provider mutation.

## Scope

READ-ONLY ONLY.

Do NOT:
- select any country/region;
- deselect any country/region;
- click Add / Save / Apply / Confirm;
- use Add and sync countries/regions;
- create/edit a release;
- upload AAB/APK;
- change testers;
- send for review;
- publish/roll out.

## Required inspection

### A. Country-selection entry screen

Open the country/region selection UI without saving anything.

Record:
- exact screen/dialog title;
- exact provider wording;
- whether any countries are already selected;
- total selected count if shown;
- whether there is a search field;
- whether there is a `Select all` / `All countries and regions` option;
- whether there is a `Clear all` option;
- whether territories/regions are grouped;
- visible controls/buttons;
- whether opening the screen itself changes provider state.

### B. Add vs Add-and-sync semantics

Inspect the provider help text/tooltips/visible wording for:
- `Add countries / regions`
- `Add and sync countries / regions`

Determine exactly:
- what each action would do;
- what source track/release is used for sync, if stated;
- whether sync could overwrite current selection later;
- whether either action has broader side effects.

Do not invoke either action.

### C. Recommended initial testing scope

Based ONLY on provider-visible options plus current project default (Indonesia + global, low-maintenance, minimal support), classify:
- `NARROW_SINGLE_COUNTRY_TEST`
- `SMALL_MULTI_COUNTRY_TEST`
- `GLOBAL_CLOSED_TEST`
- `UNKNOWN_NEEDS_DECISION`

Do not make the final country selection yet.

If the provider UI does not expose enough information, mark `UNKNOWN`.

### D. Account-specific restrictions

Record any visible restriction related to:
- country availability;
- legal/compliance;
- tester eligibility by country;
- Play account country;
- payments/merchant profile;
- age/rating limitations;
- release availability.

If none is visible, mark `NONE_VISIBLE`.

### E. Next action

Return ONE next provider action only, not executed.

Prefer the smallest reversible action that allows Closed testing to proceed.

## Evidence

If repo workspace is available, create:

`evidence/play/W2_CLOSED_TEST_COUNTRY_SELECTION_READ_ONLY_INSPECTION_2026_10_06_v1.0.md`

Commit only that evidence file.

## Allowed terminal dispositions

- `PASS_CLOSED_TEST_COUNTRY_STATE_IDENTIFIED`
- `PARTIAL_CLOSED_TEST_COUNTRY_STATE_INCOMPLETE_VISIBILITY`
- `HOLD_CLOSED_TEST_COUNTRY_SCOPE_UNRESOLVED`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Final response

Return:
1. disposition;
2. exact country-selection UI title;
3. current selected-country count/state;
4. available selection controls;
5. Add vs Add-and-sync semantics;
6. any account-specific restrictions;
7. recommended scope classification;
8. next ONE action only;
9. confirmation zero provider mutation;
10. evidence commit SHA if available.
