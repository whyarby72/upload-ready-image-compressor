# CODEX S5 START — TASK-S5-001

Continue from branch `task/TASK-S5-001`. Read:
1. PROJECT_STATE.json
2. CURRENT_TASK.md
3. PRODUCT_SPEC.md
4. ACCEPTANCE_CRITERIA.md
5. S5_INTERNAL_TEST_PLAN.md
6. TEST_MATRIX.csv
7. AGENTS.md

Mission: prepare Google Play Internal Testing readiness from the S4-passed baseline.

Hard rules:
- canonical decision remains TEST;
- no AdMob/UMP/analytics;
- no feature expansion;
- no production release/publication;
- do not invent signing identity, keystore, Play Console state, tester identities, or account authorization;
- ordinary build/test/config repair is autonomous;
- account/legal/signing/upload authority must stop at HUMAN_ACTION_REQUIRED.

Execute TASK-S5-001 fully until either:
A) S5 technical readiness is proven and the next step is a human Play Console action; or
B) a real technical blocker remains.

At completion return:
- branch + HEAD SHA;
- exact toolchain;
- versionCode/versionName;
- debug regression results;
- AAB/APK artifact path/bytes/SHA-256;
- bundle/signing state;
- permission regression;
- S5 acceptance disposition;
- human action required, if any;
- changed files/evidence paths;
- updated HANDOFF_CURRENT.

Do not claim S6 and do not claim BUILD.
