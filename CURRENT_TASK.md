# CURRENT_TASK.md

Task ID: TASK-S5-002
Owner: CODEX
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY
Priority: HIGH
Status: OPEN

## Goal
Migrate the Android application identity from the superseded `com.uploadready.app` / working-name state to the frozen keyword-led identity:

- English Play title: `Reduce Photo Size: KB Limit`
- Launcher / in-app name: `Reduce Photo Size`
- applicationId / namespace: `com.afradadmedia.reducephotosize`

Then rebuild, retest, and regenerate S5 artifact evidence before any Play upload.

## Authority

This task is authorized for reversible engineering/package migration and verification only.

It does NOT authorize:
- Play Console upload;
- signing identity creation/selection;
- Artifact Freeze;
- release;
- publication;
- BUILD promotion;
- AdMob / UMP / analytics integration.

Stop at HUMAN_ACTION_REQUIRED if account/signing/upload action is required.

## Source of truth

Read first:
1. `docs/product/APP_IDENTITY_FINAL_v1.0.md`
2. `docs/market/TITLE_FINAL_SCREEN_REDUCE_PHOTO_SIZE_KB_LIMIT_v1.0.md`
3. `PRODUCT_SPEC.md`
4. `S5_INTERNAL_TEST_PLAN.md`
5. `S6_INTERNAL_TEST_PLAN.md`
6. `AGENTS.md`

## In Scope

- migrate `applicationId` to `com.afradadmedia.reducephotosize`;
- migrate Android namespace to `com.afradadmedia.reducephotosize`;
- migrate Java package declarations/imports/source directories where needed;
- migrate provider authorities and any hard-coded package references;
- change launcher/app label to `Reduce Photo Size`;
- update tests/fixtures/evidence references to the final identity;
- search repository for stale publication-relevant `com.uploadready.app` references;
- preserve buyer-job semantics and existing S4/S5 core behavior;
- rebuild debug/release/AAB artifacts;
- rerun unit/lint/install/launch/core regression;
- regenerate exact artifact hashes and S5 evidence;
- commit/push ordinary engineering/evidence changes to this task branch.

## Explicit Non-Scope

- feature expansion;
- UI redesign except identity-related strings or defect repair;
- batch/PDF/converter/passport/crop/AI features;
- AdMob/UMP/analytics;
- Play Console upload;
- production release/publication;
- signing account decisions;
- Artifact Freeze.

## Required Verification

1. `python scripts/preflight.py`
2. repository-wide stale-identity search
3. `./gradlew --no-daemon assembleDebug`
4. `./gradlew --no-daemon testDebugUnitTest`
5. `./gradlew --no-daemon lintDebug`
6. `./gradlew --no-daemon assembleRelease`
7. `./gradlew --no-daemon bundleRelease`
8. inspect package/application identity in generated artifacts
9. install/launch current Android environment
10. install/launch representative older supported Android environment
11. rerun buyer-critical truth cases:
   - CURRENT detection
   - known target PASS
   - aggressive target NOT_MET
   - unknown limit REDUCED
   - original preservation
   - Save
   - Share
   - orientation/quality safety
   - large input
12. permission/privacy regression:
   - no INTERNET
   - no broad storage/media permissions
   - no AdMob/UMP/analytics
13. generate new AAB/APK hashes
14. update evidence index/state/handoff
15. `python scripts/validate_release_authority.py`

## Acceptance

- S5-ID-01: exact final applicationId is `com.afradadmedia.reducephotosize`.
- S5-ID-02: namespace/source/provider/test references are internally consistent.
- S5-ID-03: launcher/app label is `Reduce Photo Size`.
- S5-ID-04: no publication-relevant stale `com.uploadready.app` remains.
- S5-ID-05: preflight/build/unit/lint/release/bundle regression PASS.
- S5-ID-06: current + representative older Android install/launch PASS.
- S5-ID-07: core PASS/NOT_MET/REDUCED truth remains correct.
- S5-ID-08: original preservation + Save/Share remain correct.
- S5-ID-09: permission/privacy regression remains green.
- S5-ID-10: new AAB/APK identity/bytes/SHA-256 are recorded.
- S5-ID-11: old AAB `96ddc5b59df576c365af1321faf8801d9dbd72c77c482f97911df993ed1f5cea` remains provenance only and is not eligible for Play upload.
- S5-ID-12: handoff stops at HUMAN_PLAY_CONSOLE if signing/upload is still required.

## Done When

The final keyword-led identity is proven in fresh build artifacts and all buyer-critical regressions pass. The resulting unsigned/signed state must be described exactly. Do not claim S6, BUILD, Artifact Freeze, release, or publication.
