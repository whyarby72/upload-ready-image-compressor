# CURRENT_TASK.md

Task ID: TASK-S3-001
Owner: CODEX
Stage: S3_FUNCTIONAL_VERTICAL_SLICE
Priority: HIGH
Status: OPEN

## Goal
Turn the existing `UPLOAD_READY_ANDROID_VERTICAL_SLICE_v0.1.0` source into a real, replayable Android technical proof without expanding product scope or integrating AdMob.

## In Scope
- establish/verify the canonical private GitHub repository through Factory v1.0.1 repo bootstrap;
- revalidate exact Android toolchain;
- generate/repair Gradle Wrapper if absent;
- compile app; run unit + lint/static checks;
- install/launch on Android emulator/device environments;
- exercise real Android JPEG compression;
- verify output bytes against targets and PASS/NOT_MET/REDUCED truth;
- verify already-ready, original preservation, EXIF orientation/metadata, Save/Share/MediaStore/provider, and large-input safety;
- record repository/build/device evidence and hashes.

## Explicitly Out of Scope
- canonical BUILD promotion;
- UI redesign except defect repair needed for frozen buyer job;
- feature expansion;
- batch/PDF/AI/photo-editor features;
- production AdMob/UMP/analytics integration;
- store publication/signing/release/Artifact Freeze;
- public GitHub repository;
- remote delete/transfer, billing mutation, or force-push;
- human candidate-direct usability testing.

## Acceptance IDs
AC-S3-01 through AC-S3-16.

## Required Commands / Evidence
1. `python scripts/bootstrap_repo.py --create-private-github --push --repo-name upload-ready-image-compressor`
   - expected final repo state: verified PRIVATE GitHub remote plus pushed `main`, `develop`, `task/TASK-S3-001`;
   - if provider authentication is missing: record `AUTH_REQUIRED` and request only the necessary account authorization; never ask the human to run routine Git commands.
2. `python scripts/preflight.py`
3. Record Java/Gradle/SDK/build-tools identities.
4. If `gradlew` is absent, create a compatible Gradle Wrapper in the real environment and record exact toolchain evidence.
5. `./gradlew --no-daemon assembleDebug`
6. `./gradlew --no-daemon testDebugUnitTest`
7. `./gradlew --no-daemon lintDebug`
8. Install/launch with available emulator/device tooling.
9. Run blocking `TEST_MATRIX.csv` cases.
10. Write evidence under `/evidence`.
11. Update state/test matrix/decisions/changelog.
12. `python scripts/build_evidence_index.py`
13. `python scripts/render_handoff.py`
14. `python scripts/validate_release_authority.py`
15. Commit and push ordinary engineering/evidence changes when remote access is available and allowed.

## Repair Loop
Repair ordinary compiler/import/resource/test/lint failures autonomously at the smallest responsible layer; rerun the proving test and then the relevant regression.

## Escalate If
- provider/account authentication is required for the already-authorized private GitHub remote;
- frozen buyer job or PASS definition must change;
- new material permission/privacy/security behavior is necessary;
- source preservation cannot be guaranteed;
- meaningful product scope expansion is required;
- production/account/signing/release/publication action is required.

## Done When
The canonical private repo is verified, blocking S3 criteria have real Android evidence, APK hash is recorded, no blocking core defects remain, evidence index/handoff are regenerated, engineering/evidence commits are pushed where authorized, and canonical decision remains TEST.
