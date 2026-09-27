# CODEX S5 REQUIREMENT TRUTH FIX — TASK-S5-003

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-003`

Read `CURRENT_TASK.md` and execute it fully.

The task is deliberately narrow:
- remove implicit 1 MB target;
- no preset selected when requirement screen opens;
- clear target again whenever a newly selected photo enters the requirement screen;
- disable known-limit CTA until explicit valid preset/custom selection;
- add a defensive known-path target-validity guard;
- preserve unknown-limit -> REDUCED-only semantics;
- change heading to `What's the upload limit?`;
- do not broad-redesign the UI.

After the source fix, run all required verification from CURRENT_TASK.md, capture fresh first-open/requirement/result evidence, rebuild release APK/AAB, and record fresh hashes.

The prior AAB:
`992a2acddb197796b7aec8be72923c7ec8759a2cb36cf39dcc7f91c32a60c7a6`

must become provenance/superseded after the source changes.

Do not:
- upload to Play;
- create/select signing identity;
- integrate AdMob/UMP/analytics;
- reorder Save/Share merely as polish;
- expand product scope;
- claim S6, BUILD, Artifact Freeze, release, or publication.

Return:
- final branch HEAD;
- source fix commit;
- exact changed source files;
- proof of no default selected target;
- API36/API29 results;
- PASS/NOT_MET/REDUCED + Custom + new-photo-target-reset results;
- Save/Share/preservation/privacy results;
- fresh debug APK/release APK/AAB bytes + SHA-256;
- signing state;
- S5-REQ acceptance matrix;
- next owner.
