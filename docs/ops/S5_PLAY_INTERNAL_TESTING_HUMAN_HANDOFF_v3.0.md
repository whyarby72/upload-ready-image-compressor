# S5 — GOOGLE PLAY INTERNAL TESTING HUMAN HANDOFF v3.0

Observed: 2026-09-30
Product: REDUCE PHOTO SIZE: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Launcher: `Reduce Photo Size`
Decision: `TEST`
Stage: `S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING`
Status: `REFRESHED_CURRENT_SOURCE / PROVIDER_ACTION_NOT_AUTHORIZED`

This v3.0 handoff supersedes `docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v2.0.md` for next-action purposes.
The v2.0 document is provenance only.

## 0. Authority boundary

This package PREPARES the human Google Play Internal testing workflow only.

It does NOT authorize or perform:
- upload-key / keystore creation or rotation;
- signing;
- Play Console app creation or mutation;
- AAB upload;
- tester-account mutation;
- release creation or rollout;
- S6;
- canonical BUILD promotion;
- Artifact Freeze;
- production release;
- publication.

Any account, identity, legal, payment, signing, tester, upload, or provider action requires separately scoped human authorization.

Use only the legitimately authorized Google Play account holder. Do not bypass age, identity, account, organization, tax, payment, or platform requirements.

## 1. Canonical identity — repository FACT

Current source configuration:
- Play title: `Reduce Photo Size: KB Limit`
- Launcher: `Reduce Photo Size`
- applicationId / namespace: `com.afradadmedia.reducephotosize`
- versionCode: `1`
- versionName: `0.1.0`
- minSdk: `29`
- targetSdk: `36`
- compileSdk: `37`

Binding source:
`app/build.gradle`

Manifest review:
- `android:allowBackup="false"`;
- no INTERNET permission declared;
- no broad-storage permission declared;
- launcher activity exported only for launcher entry;
- local result ContentProvider is `exported="false"`.

No AdMob or analytics dependency is present in the current app Gradle dependencies.

## 2. Current tested source and artifact evidence — repository FACT

Latest tested app source:
`27199bf6f174e55dc835d0d9898e456d3848001c`

Current repository head at handoff preparation start:
`13b88c9ac7eb8e578cd9459d215530a49facd8a3`

Comparison from tested source to that head shows no later app/source mutation; intervening changes are evidence/docs/state only.

Latest TASK-S5-007 machine proof:
`evidence/play/S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_PROOF.json`

Latest QA artifacts recorded by that proof:

Debug APK:
- path at build time: `app/build/outputs/apk/debug/app-debug.apk`
- bytes: `29,926,362`
- SHA-256: `843c6321febc8b1756c7ed3ba0f0d547fa74bad69bc7a9fef121f44a138e64ce`

Unsigned release APK:
- path at build time: `app/build/outputs/apk/release/app-release-unsigned.apk`
- bytes: `23,001,458`
- SHA-256: `801e503a40b9551141de0d592e62ca18795bad3fdaf8fb8e9c09f7a5b45121c1`

Release AAB:
- path at build time: `app/build/outputs/bundle/release/app-release.aab`
- bytes: `7,968,406`
- SHA-256: `a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

Important:
the TASK-S5-007 AAB is recorded by artifact-bound QA, but the binary itself is not currently persisted under `evidence/artifacts/` in the repository.

Therefore its current disposition is:
`UNSIGNED_LOCAL_QA_ARTIFACT_REFERENCE / NOT YET MATERIALIZED AS THE PLAY PRE-SIGN CANDIDATE`

Do not upload any older `s5_005*` AAB. Those are provenance only.

## 3. Current product-quality closure — repository FACT

Closed human gates:

TASK-S5-005 geometry:
`PASS_HUMAN_APPROVED`

TASK-S5-006 PREMIUM_QUALITY / VISUAL_PRODUCTIZATION:
`PASS_HUMAN_APPROVED_CLOSED`

Closure:
`docs/qa/TASK_S5_006_HUMAN_PREMIUM_VISUAL_PRODUCTIZATION_CLOSURE_v1.0.md`

TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY:
`PASS_HUMAN_APPROVED_CLOSED`

Closure:
`docs/qa/TASK_S5_007_HUMAN_OUTPUT_SIZE_DISPLAY_CLARITY_CLOSURE_v1.0.md`

Current buyer-facing truth remains:
- explicit upload limit is deliberate;
- exact bytes are authoritative;
- PASS iff output bytes <= target bytes;
- NOT_MET remains truthful;
- REDUCED makes no PASS claim;
- 1 KB = 1,000 bytes;
- original is not overwritten;
- image geometry remains proportional;
- Save/Share are preserved.

## 4. Current Google Play facts — verified 2026-09-30 from official Google sources

### Target API

For new mobile apps and app updates submitted from 2026-08-31, Google Play requires Android 16 / API 36 or higher.

Current project:
`targetSdk 36`

Status:
`MEETS CURRENT MOBILE SUBMISSION TARGET-API MINIMUM`

Official source:
Google Play Console Help — Target API level requirements for Google Play apps.

### Internal testing track

Google Play Internal testing supports up to 100 testers per app and is intended for rapid distribution to a trusted tester group.

This project is preparing the `Internal testing` track, not `Internal app sharing`.

Official source:
Google Play Console Help — Set up an open, closed, or internal test.

### New personal-account production-access rule

If the developer account is a personal account created after 2023-11-13, later production access requires a closed test with at least 12 testers continuously opted in for at least 14 days before applying for production access.

This rule is account-dependent and concerns later production access. It is not satisfied merely by running this internal test.

Official source:
Google Play Console Help — App testing requirements for new personal developer accounts.

### Signing model

For Play App Signing, the developer keeps an upload key and uses it to sign the app bundle before Play Console upload; Google Play holds/uses the app-signing key for delivered APKs.

The repository currently has no release signing configuration.

Therefore:
`CURRENT_RELEASE_AAB_REFERENCE = UNSIGNED / NOT PLAY-UPLOAD-ELIGIBLE`

Official source:
Google Play Console Help — Use Play App Signing.

## 5. Artifact materialization gate — required before signing

Before any signing approval is requested, establish one exact current pre-sign AAB in a controlled local environment.

Preferred path:
1. synchronize the exact current branch;
2. confirm no app/source drift after tested source `27199bf6...`;
3. if the original QA AAB still exists, verify its bytes and SHA-256 against `a25a3a...`;
4. if it does not exist or does not match, rebuild from the unchanged tested source and rerun build/unit/lint checks;
5. copy the verified unsigned AAB into a dedicated evidence artifact namespace;
6. record its bytes and SHA-256;
7. do not sign it in this step.

A rebuilt AAB must not be assumed byte-identical to the previous QA AAB until hashed and verified.

Prepared but NOT authorized execution prompt:
`prompts/CODEX_S5_PLAY_CANDIDATE_MATERIALIZATION_v1.0.md`

## 6. Provider preflight — HUMAN observation required before any signing/upload

Record these as FACT from Play Console; do not infer them:

- [ ] correct authorized developer account selected;
- [ ] whether this app/package already exists in Play Console;
- [ ] developer account type and account creation date;
- [ ] whether the account has permission to release apps to testing tracks;
- [ ] current Play App Signing enrollment/configuration;
- [ ] existing upload-key availability and non-secret certificate fingerprint;
- [ ] whether versionCode `1` is available;
- [ ] intended internal tester count/list;
- [ ] feedback email/URL;
- [ ] any provider warnings or blockers.

Do not store tester email addresses, keystore files, private keys, passwords, recovery secrets, or other credentials in Git or chat.

## 7. Existing-app vs new-app fork

### If package already exists in Play Console

- verify package exactly `com.afradadmedia.reducephotosize`;
- verify versionCode `1` is available;
- use the existing authorized upload-key process;
- do not create an unrelated signing identity;
- if upload-key access is unavailable or mismatched, STOP and use the official provider recovery/reset workflow.

### If this is a new Play Console app

- verify final title and package before first artifact upload;
- use the intended Play App Signing configuration;
- establish one authorized upload key under secure custody only after separate human authorization;
- never commit keystore/private-key material.

Any versionCode or app/source mutation after candidate materialization invalidates the candidate binding and requires fresh verification.

## 8. Internal test release draft

Suggested release name:
`0.1.0-internal-1`

Suggested release notes:

`Internal test 0.1.0: on-device JPEG size reduction for explicit upload limits, exact byte verification, PASS / TARGET NOT MET / SMALLER COPY result semantics, proportional image presentation, and Save / Share. Original photo remains untouched.`

Do not claim:
- guaranteed portal acceptance;
- lossless compression;
- EXIF preservation;
- non-JPEG support;
- cloud backup/sync;
- production readiness.

## 9. Play Console route — not authorized by this package

When separately authorized, the human provider workflow is expected to use:
`Test and release → Testing → Internal testing`

The provider-bound stage includes tester setup, signed AAB upload, warning/error review, release review, and rollout.

None of those provider actions are authorized here.

If Play reports a package, version, signing, policy, target API, identity, or other material warning/error:
`STOP → capture exact provider message → return to CHAT/CODEX`

Do not improvise around provider controls.

## 10. Evidence required after separately authorized Internal testing distribution

### Release identity

Record:
- Play Console package/app identity;
- track = Internal testing;
- signed AAB bytes + SHA-256;
- upload-certificate SHA-256 fingerprint only;
- versionCode/versionName;
- Play release identifier if exposed;
- upload and rollout timestamps;
- provider warnings/errors and disposition.

### Tester route

Record:
- tester count only in repository evidence;
- opt-in route exists;
- authorized tester can opt in;
- Play-distributed build installs;
- foreground package is `com.afradadmedia.reducephotosize`;
- installed versionCode/versionName match the intended release.

### Buyer-critical smoke

Using a non-sensitive JPEG:
1. launch;
2. choose JPEG;
3. verify CURRENT facts;
4. select explicit limit;
5. compress;
6. verify exact-byte PASS / NOT_MET / REDUCED truth;
7. verify proportional full-frame presentation;
8. Save;
9. Share;
10. confirm original remains unchanged.

Classify defects:
`BLOCKER / TRUTH_DEFECT / DATA_SAFETY / FUNCTIONAL / UX / COSMETIC`

## 11. S5 disposition

Current:
`S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING`

Product-quality gates are closed.

Remaining pre-provider requirement:
`CURRENT UNSIGNED AAB MATERIALIZATION + HASH BINDING`

Provider actions remain human-controlled and separately authorized.

Internal testing does not itself:
- promote TEST to BUILD;
- authorize S6;
- satisfy account-dependent closed-test production-access requirements;
- authorize Artifact Freeze;
- authorize production release/publication.

## 12. Current unknowns

`UNKNOWN / PROVIDER-BOUND`:
- Play app existence;
- account type/date;
- Play App Signing state;
- upload-key state;
- versionCode 1 availability;
- tester identities/count;
- feedback channel;
- provider warnings/errors.

No model or repository assumption should replace these observations.
