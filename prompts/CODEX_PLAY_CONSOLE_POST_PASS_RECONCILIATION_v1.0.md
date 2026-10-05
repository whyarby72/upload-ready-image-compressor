# CODEX — PLAY CONSOLE POST-PASS RECONCILIATION v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Mission

The prior Codex Chrome provider workflow was reported by the human operator as PASS, but the canonical branch does not yet contain a machine-captured positive-run provider evidence pack.

Perform a READ-ONLY reconciliation of the current Google Play Console state before any further provider mutation.

## Browser binding

Use the Codex Chrome extension with the operator-selected existing Chrome profile/session already authenticated to the authorized Google Play Console account.

Before inspection:
- verify active app = `Photo Compressor: KB Limit`;
- verify package if visible = `com.afradadmedia.reducephotosize`;
- if the account/app context is wrong, STOP immediately.

Never expose or store passwords, MFA secrets, recovery codes, cookies, session tokens, or account-email identity.

## Mutation boundary

THIS RUN IS READ-ONLY.

Do NOT:
- change form values;
- click Save, Submit, or Send for review;
- create/edit releases;
- promote tracks;
- change Managed Publishing;
- create/edit AdMob configuration;
- Artifact Freeze;
- publish/release.

If a mutation is required to reveal a later screen, stop and report that blocker.

## Required current-state inventory

Capture the exact visible state of:

1. Dashboard
   - especially Set up your app / required setup tasks;
   - list every completed and incomplete task exactly as shown.

2. Policy and programs > App content
   - enumerate every visible section and its status;
   - include Ads, App access/Sign in details, Target audience, Privacy policy, Data safety, Content ratings, Government apps, Financial features, Health, News, and any other current section when present.

3. Publishing overview
   - list all Changes not yet submitted for review;
   - record whether Send app for review is enabled or disabled;
   - do not click it.

4. Content ratings
   - inspect saved/result state only;
   - record questionnaire/result completeness and visible rating summaries.

5. Store presence / Main store listing
   - record completeness/status;
   - report missing required fields/assets without editing.

6. Testing / Release
   - record visible tracks and setup requirements;
   - report any account-specific testing prerequisite;
   - do not create/edit a release.

7. Any other visible dashboard blocker preventing review readiness.

## Evidence rules

- distinguish VISIBLE_PROVIDER_STATE from inference;
- unseen/unopened sections = UNKNOWN, not PASS;
- do not rely on prior chat state when the current provider UI differs.

## Output

Return:
1. terminal disposition;
2. active-app/context verification;
3. exact completed sections;
4. exact incomplete sections;
5. exact Publishing overview pending changes;
6. Send app for review enabled/disabled;
7. remaining blockers in execution order;
8. screenshots/evidence paths;
9. NEXT ONE provider action only, not executed;
10. confirmation that no provider mutation occurred.

Allowed dispositions:
- PASS_PLAY_CONSOLE_CURRENT_STATE_RECONCILED
- PARTIAL_PLAY_CONSOLE_CURRENT_STATE_INCOMPLETE_VISIBILITY
- BLOCKED_WRONG_PROVIDER_CONTEXT
- BLOCKED_PROVIDER_AUTH_REQUIRED
- BLOCKED_PROVIDER_UI_ERROR

If repo workspace is available, create:
`evidence/play/W2_PLAY_CONSOLE_POST_PASS_RECONCILIATION_2026_10_05_v1.0.md`
and commit only that evidence file.

Do not modify source/product files.
