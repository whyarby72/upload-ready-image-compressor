# S5 — HUMAN_PLAY_CONSOLE / GOOGLE PLAY INTERNAL TESTING HANDOFF v2.0

Observed: 2026-09-28
Product: REDUCE PHOTO SIZE: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Launcher: `Reduce Photo Size`
Decision: TEST
Current stage: S5_INTERNAL_TEST_READY
Owner for next provider-bound action: HUMAN_PLAY_CONSOLE

## 0. Authority boundary

This document PREPARES the human Play Console workflow only.

It does NOT authorize or perform:
- keystore/upload-key creation;
- signing;
- Play Console app creation;
- AAB upload;
- tester-account mutation;
- rollout/start release;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

Any account/legal/signing/upload/provider action requires a separately scoped human action/authorization.

Do not bypass Google account, age, identity, tax, payment, developer-account, or organizational requirements. Use the legitimately authorized Play Console account holder.

## 1. Canonical product identity

- Play title: `Reduce Photo Size: KB Limit`
- Launcher name: `Reduce Photo Size`
- applicationId/package: `com.afradadmedia.reducephotosize`
- versionCode: `1`
- versionName: `0.1.0`
- minSdk: `29`
- targetSdk: `36`
- compileSdk: `37`

Package identity is frozen for this test candidate.

Google notes that after an artifact is uploaded, the app package name is fixed. Verify the package one final time in Play Console before the first upload.

## 2. Current exact release candidate

Current post-geometry source/evidence candidate:

- tested source commit: `c736a5d1e9beeb663b9bc336618171bbefe82a28`
- later commits through current task branch are test/evidence/docs-only closure after that tested source
- AAB path:
  `evidence/artifacts/s5_005_geometry_final/app-release.aab`
- AAB bytes: `7951808`
- AAB SHA-256:
  `e1a83becf5f0dfaab2dce38be5d1dc5f212a6c313a8155810317d0d878104e02`
- unsigned release APK path:
  `evidence/artifacts/s5_005_geometry_final/app-release-unsigned.apk`
- unsigned APK SHA-256:
  `2bbaa8cfb71bed882c6e53eee5562d84c1a3adef242fe2beb616268fae69ed7b`

Technical geometry:
- 10/10 actual-engine matrix PASS;
- all cross-product deltas = 0;
- final Fit/full-frame visual gate = HUMAN PASS;
- protected compression/domain source unchanged.

### Critical signing state

The Gradle release build has no release signing configuration.

Therefore:
`CURRENT_AAB = UNSIGNED / NOT READY FOR PLAY UPLOAD`

Do not upload the unsigned candidate and do not replace it with an older signed/stale artifact.

The exact production bytes uploaded to Play must be traceably derived from the approved source candidate and signed with the authorized upload key.

## 3. Current Google Play facts verified 2026-09-28

Official sources:
- Internal testing:
  https://support.google.com/googleplay/android-developer/answer/9845334
- Prepare/roll out a release:
  https://support.google.com/googleplay/android-developer/answer/9859348
- Play App Signing:
  https://support.google.com/googleplay/android-developer/answer/9842756
- Target API requirements:
  https://support.google.com/googleplay/android-developer/answer/11926878
- Personal-account production testing requirements:
  https://support.google.com/googleplay/android-developer/answer/14151465

Verified facts:

1. Internal testing supports up to 100 testers and may start before the app is fully configured.
2. Internal test builds are distributed through Google Play to selected testers and are not generally discoverable by search.
3. The tester list may be managed by email address.
4. A user opted into internal testing is not simultaneously eligible for open/closed testing until they opt out of internal.
5. A new release requires the account permission to release apps to testing tracks.
6. For a new app, Play App Signing is the normal path; the developer retains an upload key used to sign the bundle before upload, while Google Play holds the app-signing key used for distributed APKs.
7. Since 2026-08-31, new mobile apps and updates submitted to Google Play must target Android 16 / API 36 or higher. This project currently targets API 36.
8. If the developer account is a personal account created after 2023-11-13, later production access has a separate CLOSED-test requirement: at least 12 opted-in testers continuously for at least 14 days before applying for production access. This is ACCOUNT-DEPENDENT and is NOT satisfied merely by this internal test.

## 4. Human preflight — STOP unless every applicable item is resolved

### Account / provider
- [ ] Authorized Play Console account holder is present.
- [ ] Correct developer account selected.
- [ ] Account has permission to release apps to testing tracks.
- [ ] No account/identity/legal requirement is being bypassed.
- [ ] Confirm whether the app already exists in Play Console.

### Existing-app fork

If `com.afradadmedia.reducephotosize` ALREADY EXISTS in Play Console:
- [ ] Verify the package matches exactly.
- [ ] Verify versionCode 1 is still available; if not, STOP and return to Chat/Codex for a versionCode-only controlled rebuild.
- [ ] Verify the registered upload key / app-signing state.
- [ ] Do not create a second unrelated signing identity.

If this is a NEW Play Console app:
- [ ] Confirm final package `com.afradadmedia.reducephotosize`.
- [ ] Confirm final app title.
- [ ] Let Play App Signing use the account's intended configuration.
- [ ] Establish one authorized upload key under secure custody before signing the AAB.

### Artifact
- [ ] Use only the exact candidate described in Section 2 as the pre-signing source artifact.
- [ ] Do not use any older `identity`, `fractional`, `reqfix`, `s5_004`, `s5_005_final`, or `s5_005_final_recap` AAB as the upload candidate.
- [ ] Record the signed AAB byte count and SHA-256 after signing.
- [ ] Record the upload certificate SHA-256 fingerprint; never commit the private key, keystore, alias password, or store password.

### Tester input
- [ ] Prepare at least 1 trusted internal tester for initial route validation.
- [ ] Internal testing may contain up to 100 testers.
- [ ] Store raw tester emails only where operationally necessary; do not commit personal tester addresses to this repository.
- [ ] Choose a feedback email/URL.

## 5. Play Console navigation — HUMAN action, not yet authorized here

When separately authorized:

1. Sign in to Play Console.
2. Select or create the intended app.
3. Confirm package identity before the first artifact upload.
4. Go to:
   `Test and release → Testing → Internal testing`.
5. Open the `Testers` tab.
6. Create/select the internal tester email list.
7. Set the feedback channel.
8. Save tester configuration.
9. Go to the internal-test release page.
10. Choose `Create new release`.

STOP before any signing/upload action unless separately authorized.

## 6. Signing handoff — HUMAN-authorized secure environment only

For a NEW app with no existing upload key:

- create one authorized upload key in a secure local environment;
- keep the keystore and credentials out of Git and out of chat;
- sign the exact candidate AAB;
- compute and record the signed AAB SHA-256;
- record only the non-secret upload certificate fingerprint in evidence.

For an EXISTING Play app:

- use the existing authorized upload-key process;
- do not silently generate a replacement key;
- if upload-key access is lost or registration does not match, STOP and use the official Play Console recovery/reset workflow.

Expected signed artifact identity must remain:
- applicationId: `com.afradadmedia.reducephotosize`
- versionCode: `1`, unless Play Console proves it is unavailable;
- versionName: `0.1.0`
- targetSdk: `36`

Any versionCode/source/build mutation invalidates the exact unsigned AAB hash above and requires fresh artifact-bound verification before upload.

## 7. Internal release draft

Suggested release name:
`0.1.0-internal-1`

Release notes draft:

`Internal test build 0.1.0: on-device JPEG size reduction for explicit upload limits, exact PASS / TARGET NOT MET / SMALLER COPY result semantics, proportional full-frame image geometry, and Save / Share output flow. Original photo remains untouched.`

Do not add claims that are not proven, including:
- guaranteed portal acceptance;
- lossless compression;
- EXIF preservation;
- support for non-JPEG formats;
- cloud backup/sync;
- production-readiness.

## 8. Upload/rollout boundary — separate approval required

After a signed AAB exists, the human would normally:

- upload the signed AAB to the Internal testing release;
- inspect Play Console warnings/errors;
- review package/version/target API truth;
- review release notes;
- save/review the release;
- start rollout to Internal testing.

Those actions are NOT authorized by preparation of this handoff.

If Play Console reports any material warning/error:
`STOP → capture exact provider message → return to Chat/Codex`

Do not improvise around policy, signing, package, targetSdk, or version conflicts.

## 9. Evidence required after authorized Internal Testing distribution

Provider-bound evidence must include:

### Release identity
- Play Console app/package identity;
- track = Internal testing;
- versionCode/versionName;
- signed AAB SHA-256 and bytes;
- upload-certificate SHA-256 fingerprint;
- Play-generated release identifier if exposed;
- upload/rollout timestamp.

### Tester route
- tester-list count only in repo, not personal email addresses;
- opt-in route/link existence;
- tester can opt in;
- tester receives the Play-distributed build;
- install succeeds from Google Play;
- foreground package is `com.afradadmedia.reducephotosize`;
- installed versionCode/versionName match the intended release.

### Buyer-critical smoke test on Play-distributed build
At minimum:
1. launch;
2. choose a non-sensitive JPEG;
3. CURRENT facts appear;
4. choose an explicit limit;
5. run compression;
6. verify PASS / TARGET NOT MET / SMALLER COPY truth as applicable;
7. verify proportional full-frame presentation;
8. Save succeeds;
9. Share sheet opens;
10. original remains unchanged.

Record:
- device model;
- Android version/API;
- result state;
- blocker/truth/functional/UX/cosmetic defects;
- screenshots/logs only when non-sensitive.

## 10. S5 gate after provider execution

S5 remains:
`S5_INTERNAL_TEST_READY_PLAY_DISTRIBUTION_PENDING`

It may advance only after actual Google Play distribution/install evidence is reconciled.

Internal testing alone does NOT:
- authorize S6;
- promote TEST to BUILD;
- satisfy any later account-dependent closed-test requirement;
- authorize Artifact Freeze;
- authorize production release/publication.

## 11. Current unresolved human/provider inputs

These are UNKNOWN until the authorized human checks Play Console:

- whether the app already exists under this developer account;
- developer account type/date and whether later 12-testers/14-days closed-test production-access rule applies;
- current Play App Signing enrollment state;
- existing upload-key availability/fingerprint;
- whether versionCode 1 is available;
- tester email identities;
- feedback channel;
- provider warnings/errors at first signed upload.

No assumption should replace these provider observations.
