# CODEX S5 IDENTITY MIGRATION — TASK-S5-002

Continue from branch `task/TASK-S5-002`.

Read `CURRENT_TASK.md` and execute it fully.

Frozen identity:
- Play title EN: `Reduce Photo Size: KB Limit`
- launcher/in-app name: `Reduce Photo Size`
- applicationId + namespace: `com.afradadmedia.reducephotosize`

Important:
- migrate identity comprehensively, not only Gradle applicationId;
- preserve all existing buyer-job semantics;
- do not integrate AdMob/UMP/analytics;
- do not create/invent signing identity;
- do not upload to Play Console;
- do not claim S6, BUILD, Artifact Freeze, release, or publication.

After migration:
- run preflight/build/unit/lint/assembleRelease/bundleRelease;
- verify current + representative older Android install/launch;
- rerun PASS/NOT_MET/REDUCED, original-preservation, Save/Share, orientation/quality, large-input and permission/privacy regression;
- repository-search for stale publication-relevant `com.uploadready.app`;
- generate fresh APK/AAB bytes and SHA-256;
- update TEST_MATRIX, PROJECT_STATE, HANDOFF_CURRENT and evidence index;
- run release-authority validation;
- push ordinary task/evidence commits.

Return final checkpoint with:
branch, HEAD SHA, exact applicationId/namespace/app label, regression results, fresh APK/AAB hashes, stale-reference disposition, signing state, S5-ID acceptance status, and next owner.
