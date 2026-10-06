# CODEX — GOOGLE PLAY MINIMUM PUBLICATION PATH v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Human directive

The operator has explicitly directed:

`DO ONLY WHAT IS ACTUALLY REQUIRED TO PUBLISH`

Interpretation:
- stop micro-inspection gates that do not change the publication outcome;
- prefer the shortest valid path to a release-ready Google Play submission;
- do not set up Closed testing unless the provider/account actually requires it;
- do not create optional pre-registration/open-testing flows;
- do not perform optional marketing/provider changes;
- stop only at a material submission/publication boundary or a real blocker.

## Current known provider state

Completed / staged:
- App content declarations complete/actioned;
- Store settings/category/contact complete;
- Main store listing complete and saved;
- AI asset declaration complete for:
  - App icon
  - Feature graphic
  - all 4 Phone screenshots
- Publishing overview contains changes not yet submitted for review;
- Production = Inactive;
- `Send app for review` currently disabled because release setup is incomplete.

Release section shows:
- Closed testing Alpha exists, inactive, no release;
- Open testing not set up;
- Production path available in UI;
- countries/regions and release creation are required;
- no release artifact has been uploaded yet.

## Current source facts to verify from canonical branch

Expected app config:
- applicationId = `com.afradadmedia.reducephotosize`
- targetSdk = `36`
- versionCode = `1`
- versionName = `0.1.0`

Before doing anything else:
1. refresh canonical branch;
2. record exact HEAD;
3. verify these values from `app/build.gradle`;
4. verify clean worktree.

If targetSdk is below current Play requirement, STOP:
`BLOCKED_TARGET_API_REQUIREMENT`

## Publication artifact first

A new Google Play app must use an Android App Bundle.

### Build checks

Run the existing deterministic checks that are required for a release artifact:
- unit tests;
- lint;
- release bundle build.

Preferred command path:
`./gradlew test lint bundleRelease`
or the repository-equivalent deterministic workflow.

Record:
- exact source commit;
- Gradle result;
- AAB path;
- AAB SHA-256;
- versionCode/versionName;
- targetSdk.

### Signing / upload key

Do NOT commit or print signing secrets.

Inspect local operator-accessible secure configuration for an existing upload key / keystore that is already intended for this app/account.

Allowed:
- inspect configured Gradle signing properties;
- inspect environment-variable names without printing secret values;
- verify keystore existence/fingerprint locally;
- use the existing upload key to create a signed release AAB.

Do NOT:
- commit keystore files;
- commit passwords;
- print passwords/aliases/private key material into evidence;
- upload secrets to GitHub.

If no usable upload key exists, STOP:
`BLOCKED_UPLOAD_KEY_SETUP_REQUIRED`

Do NOT generate a new upload key under this contract because secure backup/password custody needs a separate operator decision.

If the AAB cannot be signed:
`BLOCKED_SIGNED_AAB_UNAVAILABLE`

## Provider decision tree — use shortest valid path

After a signed AAB exists, open Play Console using the existing authenticated Chrome profile.

### Step 1 — Try Production first

Open:
`Testing & release > Production`

Determine from the live provider state whether a production release can actually be created for this account/app.

If Production is directly available:
- DO NOT set up Closed testing;
- DO NOT set up Open testing;
- DO NOT set up Pre-registration;
- use the Production path only.

If Production is explicitly blocked by an account-level testing/production-access requirement:
- record the exact provider wording;
- go to the Closed testing branch below.

If the provider state is ambiguous:
STOP:
`BLOCKED_PRODUCTION_ELIGIBILITY_AMBIGUOUS`

## Production branch — only if direct production is allowed

Perform only the required reversible prerequisites:

1. Countries / regions:
   - use global availability / all available countries and regions when the provider offers a straightforward global option;
   - this matches the project default of Indonesia + global;
   - do not configure exclusions unless provider/legal restrictions require them.

2. Create new Production release.

3. Upload the exact signed AAB built from the canonical commit.

4. If Play App Signing enrollment is automatically presented as the required normal setup for a new app:
   - use the default Google-managed Play App Signing path;
   - do not choose advanced/custom app-signing-key migration options;
   - do not export/transfer private signing keys.

5. Resolve only release-blocking provider fields:
   - required release name if provider auto-generates/requests it;
   - required release notes using concise factual text:
     `Initial release of Photo Compressor: KB Limit.`
   - required declarations directly tied to this release artifact.

6. Record provider validation:
   - version code;
   - target API;
   - signing;
   - bundle validation;
   - any blocking warning/error.

7. Advance only until the FIRST control that would:
   - send the release/app to Google for review;
   - submit changes for review;
   - start rollout;
   - publish the app.

STOP BEFORE clicking that control.

Terminal disposition:
`READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL`

## Closed testing branch — ONLY if Google explicitly requires it

Use this branch only when the provider explicitly blocks Production pending testing/production-access eligibility.

1. Record exact provider requirement.

2. If the provider requires a specific tester count and/or duration:
   - compare it with current tester availability;
   - current known list `emailaku` has 1 user.

3. If the required tester count is not satisfied:
STOP:
`BLOCKED_CLOSED_TEST_TESTERS_REQUIRED`
Return exact required count/duration.

4. If tester requirement is satisfied:
   - use existing `Closed testing - Alpha`;
   - select global/all available countries and regions unless provider restriction requires narrower scope;
   - use the existing valid tester mechanism;
   - create the closed-test release;
   - upload the exact signed AAB;
   - complete only release-blocking fields;
   - STOP before `Send release to Google for review`.

Terminal disposition:
`READY_FOR_CLOSED_TEST_REVIEW_SUBMISSION_APPROVAL`

## Never do under this contract

- do not click `Send app for review`;
- do not click `Send release to Google for review`;
- do not start rollout;
- do not publish;
- do not change Managed Publishing;
- do not create optional Open testing;
- do not create optional Pre-registration;
- do not add fabricated testers;
- do not create fake tester accounts;
- do not bypass any Google eligibility requirement;
- do not modify app source merely to get past Play validation without returning a blocker first.

## Evidence

Create:
`evidence/play/W2_MINIMUM_PUBLICATION_PATH_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical source HEAD;
- targetSdk/versionCode/versionName;
- build/test/lint results;
- signed AAB path + SHA-256;
- upload-key readiness WITHOUT secret material;
- direct Production eligibility result;
- exact provider testing requirement if Production is blocked;
- country scope chosen if reached;
- release validation results if reached;
- exact next material control that was NOT clicked;
- confirmation no review submission/rollout/publication occurred.

Commit only the text evidence file. Never commit AAB signing secrets or keystores.

## Allowed terminal dispositions

- `READY_FOR_PRODUCTION_REVIEW_SUBMISSION_APPROVAL`
- `READY_FOR_CLOSED_TEST_REVIEW_SUBMISSION_APPROVAL`
- `BLOCKED_UPLOAD_KEY_SETUP_REQUIRED`
- `BLOCKED_SIGNED_AAB_UNAVAILABLE`
- `BLOCKED_TARGET_API_REQUIREMENT`
- `BLOCKED_PRODUCTION_ELIGIBILITY_AMBIGUOUS`
- `BLOCKED_CLOSED_TEST_TESTERS_REQUIRED`
- `BLOCKED_PROVIDER_VALIDATION`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_RELEASE_ARTIFACT_BUILD`

## Final response

Return:
1. disposition;
2. canonical HEAD;
3. targetSdk / versionCode / versionName;
4. build/test/lint result;
5. signed AAB SHA-256 if available;
6. direct Production eligibility;
7. exact testing requirement if any;
8. exact release/provider blockers if any;
9. exact next material control not clicked;
10. evidence commit SHA if available;
11. confirmation no review submission/rollout/publication occurred.
