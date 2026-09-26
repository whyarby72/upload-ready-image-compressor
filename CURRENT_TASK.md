# CURRENT_TASK.md

Task ID: TASK-S5-001
Owner: CODEX
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY
Priority: HIGH
Status: OPEN

## Goal
Prepare UPLOAD-READY IMAGE COMPRESSOR for a real Google Play Internal Testing route while preserving the S4-proven buyer job and keeping canonical decision `TEST`.

## Proven Baseline
- S4 Core Technical Pass: PASS by independent Chat audit.
- S4 evidence closure commit: `8b2538e63a6cc06beb918439b5c3ce6b9d2f751d`
- Tested source/artifact commit: `772b3a321be6964240d4ac8f16f2fbecf4dc0de7`
- S3 closure base: `3df5a7802582c681b7d610f43167c8884460df3c`
- Debug APK SHA-256: `f170e342a247a758379aa499cd131ad29be363b13fb43823f38a726d1c411b34`
- S3 matrix: 24 PASS / 0 pending/blocking.

## Declared S5 Test Route
Google Play Console -> Internal testing.

The goal of S5 is readiness for distribution through the declared test route, not production release.

## In Scope
- preserve S4 buyer-critical behavior and truth semantics;
- prepare a Play-compatible internal-test artifact;
- verify package/application identity, versionCode/versionName, target/min SDK, and build reproducibility;
- produce a valid Android App Bundle when technically possible;
- verify bundle structure and artifact SHA-256;
- prepare internal-test release notes and tester instructions;
- prepare tester feedback capture focused on buyer job;
- prepare traceability from S4 evidence to S5 test artifact;
- rerun proportional regression after any code/build-config change;
- record all evidence under /evidence;
- update PROJECT_STATE, TEST_MATRIX or S5 matrix, HANDOFF_CURRENT, DECISIONS, CHANGELOG;
- commit and push ordinary engineering/evidence changes to this task branch.

## Human / Account Authority Boundary
Codex may prepare the technical artifact and Play Console handoff.

Codex must STOP for explicit human action before:
- creating/selecting the app identity in Play Console if account/legal identity action is required;
- accepting Play terms or declarations;
- enrolling/configuring Play App Signing where an account decision is required;
- supplying or generating production signing identity/keystore on behalf of the human;
- adding/removing real tester identities if this reveals personal data not already approved;
- uploading/submitting a release to Google Play when that action is treated as release/publication/account action;
- changing pricing, countries, data-safety declarations, production access, or publication state.

A human Play Console action does not promote canonical decision beyond TEST.

## Explicitly Out of Scope
- canonical BUILD promotion;
- AdMob / UMP / analytics;
- production release;
- closed/open testing;
- production-access application;
- Artifact Freeze;
- store listing optimization;
- feature expansion;
- UI redesign unless a blocking S5 defect is proven;
- force-push, public repo, remote delete/transfer, billing mutation.

## Required Technical Work
1. Confirm branch ancestry from S4 closure.
2. Run `python scripts/preflight.py`.
3. Record exact JDK/Gradle/AGP/SDK/build-tools identities.
4. Inspect current versionCode/versionName and document S5 test version policy.
5. Build debug regression:
   - `./gradlew --no-daemon assembleDebug`
   - `./gradlew --no-daemon testDebugUnitTest`
   - `./gradlew --no-daemon lintDebug`
6. Build a Play-compatible bundle:
   - prefer `./gradlew --no-daemon bundleRelease` only if it can be produced without inventing signing/account identity;
   - if release signing is unavailable, use the safest technically valid preparation path and record the exact blocker rather than fabricating release readiness.
7. Inspect resulting AAB/APK identity and hashes.
8. Verify no AdMob/network/broad-storage permissions were introduced.
9. Prepare internal-test release notes + tester instructions.
10. Prepare an S5 traceability matrix.
11. Regenerate evidence index + handoff.
12. Run `python scripts/validate_release_authority.py`.
13. Commit/push ordinary S5 preparation evidence.

## S5 Acceptance
- S5-01: S4 baseline provenance is preserved.
- S5-02: branch/task/repo state is correct and private.
- S5-03: preflight/build/unit/lint regression remains green.
- S5-04: Play-compatible installable/distributable test artifact is produced or an exact human/account signing blocker is recorded.
- S5-05: artifact identity/version/hash is recorded.
- S5-06: permission/privacy regression remains green.
- S5-07: internal-test route, release notes, tester instructions, and feedback plan are documented.
- S5-08: evidence is artifact-bound, environment-bound, and replayable.
- S5-09: authority validation remains fail-safe; no production/release authority is inferred.
- S5-10: HANDOFF_CURRENT clearly identifies whether the next owner is HUMAN_PLAY_CONSOLE or CHAT/S5_REVIEW.

## Done When
S5 may be reported READY only when the app has a real test artifact and the remaining action, if any, is a clearly identified human Play Console/account step. S5 does not authorize S6 PASS and does not authorize BUILD, AdMob, release, or publication.
