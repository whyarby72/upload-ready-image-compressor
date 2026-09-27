# CODEX FULL MANUAL-LIKE APP TEST — QA-ONLY

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-003`

Required starting HEAD:
`a539a912f0e5ed05790f02cbe7ad1a77ebf7316e`

Product:
`REDUCE PHOTO SIZE: KB LIMIT`

Package:
`com.afradadmedia.reducephotosize`

Mode:
`QA_ONLY / NON_MUTATING_PRODUCT_SOURCE`

## Purpose

Test the current Android app as if a careful human tester were manually using it screen by screen.

This is NOT a coding task.

Do not modify:
- `app/**`
- Gradle/build logic
- AndroidManifest
- resources
- package/applicationId
- versionCode/versionName
- signing
- AdMob/UMP/analytics
- Play Console state

If a real product defect is found:
1. capture evidence;
2. classify severity;
3. STOP;
4. report the defect;
5. do NOT fix source in this run.

Evidence-only files may be written under:
- `evidence/manual_like/**`
- `docs/qa/**`

An evidence-only commit is allowed only after testing. It must contain no product-source/build-logic changes.

## Read first

1. `PRODUCT_SPEC.md`
2. `CURRENT_TASK.md`
3. `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`
4. `docs/ux/S5_003_FINAL_INDEPENDENT_AUDIT_v1.0.md`
5. `S5_INTERNAL_TEST_PLAN.md`
6. `S6_INTERNAL_TEST_PLAN.md`
7. `PROJECT_STATE.json`
8. `HANDOFF_CURRENT.md`

## Environment identity

Record before testing:
- git branch;
- HEAD;
- product-source commit affecting `app/**`;
- OS;
- JDK;
- Gradle;
- AGP;
- Android SDK/build-tools;
- emulator/device names;
- API levels;
- screen size/density;
- locale;
- orientation.

Required Android environments:
- API 36
- API 29

Preferred reference viewport:
- 320 x 640 where practical for visual evidence.

## Phase A — deterministic technical preflight

Run:

```bash
python scripts/preflight.py
./gradlew --no-daemon assembleDebug
./gradlew --no-daemon testDebugUnitTest
./gradlew --no-daemon lintDebug
./gradlew --no-daemon assembleRelease
./gradlew --no-daemon bundleRelease
python scripts/validate_release_authority.py
```

Record:
- command exit status;
- failures/warnings;
- debug APK bytes + SHA-256;
- release APK bytes + SHA-256;
- release AAB bytes + SHA-256;
- signing state.

Do not claim PASS if any command is skipped or fails.

## Phase B — first-open manual-like test

On API 36:

1. clean-install current debug APK;
2. launch app;
3. capture screenshot + UI hierarchy.

Verify:
- app launches without crash/ANR;
- header says `Reduce Photo Size`;
- buyer job is understandable;
- `Choose photo` is the primary first action;
- `Private · on-device` visible;
- original/no-account reassurance visible;
- no ad/subscription/paywall interruption;
- no unexpected permission prompt;
- no network dependency.

Repeat launch smoke on API 29.

## Phase C — photo selection and requirement-state truth

Use a valid JPEG fixture.

After choosing the photo, verify:
- CURRENT photo size is detected;
- dimensions are shown;
- no preset is selected by default;
- text says `Choose the upload limit`;
- `Make it upload-ready` is disabled;
- `I don’t know the website limit` is visible/reachable;
- no hidden/default `REQUIRED` value exists.

Capture screenshot + UI hierarchy on:
- API 36
- API 29

## Phase D — preset target behavior

Test each preset:
- 50 KB = 50,000 bytes
- 100 KB = 100,000 bytes
- 200 KB = 200,000 bytes
- 500 KB = 500,000 bytes
- 1 MB = 1,000,000 bytes

For every preset:
1. select target;
2. verify exact selected target is shown;
3. verify only one target is visually selected;
4. run compression;
5. read the actual output file bytes;
6. verify state truth:
   - PASS / ALREADY_READY only when output bytes <= target;
   - NOT_MET only when output bytes > target;
7. confirm visible exact-byte proof agrees with the actual file size.

Do NOT pre-assume which state a fixture must produce. The byte comparison is authoritative.

Capture at least:
- one successful known-limit result;
- one honest NOT_MET result.

## Phase E — Custom target manual-like test

Test valid values:

### E1
Input:
`10.5 KB`

Verify:
- Custom selected;
- `REQUIRED: ≤ 10.5 KB`;
- internal threshold = 10,500 bytes;
- known-path CTA enabled.

### E2
Input:
`1.5 MB`

Verify:
- `REQUIRED: ≤ 1.5 MB`;
- threshold = 1,500,000 bytes.

### E3
Input:
`1,5 MB`

Verify:
- accepted as 1,500,000 bytes;
- displayed faithfully as `1.5 MB` or equivalent normalized decimal-SI representation.

### E4 boundary
Verify:
- `1 KB` valid;
- `50 MB` valid;
- `0.999 KB` rejected;
- `50.001 MB` rejected.

### E5 invalid/ambiguous
Verify rejection for:
- `10.0001 KB`
- `1,234.5`
- `1.234,5`
- blank input

State invariant:
- no prior target + invalid Custom => remains unselected / known CTA disabled;
- prior valid target + invalid/cancelled Custom => previous valid target remains unchanged.

Capture evidence for:
- 10.5 KB;
- 1.5 MB;
- at least one invalid Custom case.

## Phase F — target switching / stale-state defense

Test manually:

1. select 100 KB;
2. switch to 500 KB;
3. verify only 500 KB remains authoritative.

Then:

1. select 100 KB;
2. choose `I don’t know the website limit`;
3. verify known target is abandoned;
4. result must be REDUCED / ALREADY_SMALL / ERROR as applicable;
5. it must never claim PASS/NOT_MET against the abandoned 100 KB target.

Then:

1. choose photo A;
2. select a valid target;
3. complete a result;
4. tap `Compress another`;
5. choose photo B;
6. verify requirement state is reset:
   - no target selected;
   - neutral text;
   - known CTA disabled.

## Phase G — Save test

For a result file:

1. record result file size + SHA-256;
2. tap `Save copy`;
3. verify save success;
4. locate the saved JPEG;
5. record saved file size + SHA-256;
6. verify saved output matches the intended generated result;
7. verify source/original file remains unchanged.

If the UI claims save success but the file cannot be retrieved, FAIL.

## Phase H — Share test

1. tap Share;
2. verify Android Sharesheet opens;
3. verify MIME = image/jpeg;
4. verify scoped content URI is supplied;
5. verify the shared URI resolves to the current result;
6. verify no broad storage permission was added.

Capture Sharesheet evidence.

## Phase I — original-preservation test

For each selected source fixture:
- hash source before processing;
- hash source after processing;
- verify unchanged.

Fail if the original is overwritten or modified.

## Phase J — unknown-limit truth

With no target selected:

1. choose `I don’t know the website limit`;
2. run reduction;
3. verify state is REDUCED / ALREADY_SMALL / ERROR as applicable;
4. verify there is no PASS claim;
5. verify copy makes clear upload compatibility was not verified.

## Phase K — EXIF / orientation / quality

Use EXIF orientation fixture.

Verify:
- displayed/output orientation is correct;
- no silent rotation corruption;
- result dimensions make sense;
- no severe visual corruption;
- quality guard remains honest;
- impossible/aggressive limits prefer NOT_MET over destructive degradation.

Capture result screenshot.

## Phase L — large-input stability

Use the large fixture.

Verify:
- no crash;
- no ANR;
- no OOM;
- progress state appears;
- operation completes or fails safely;
- source remains unchanged;
- result truth remains correct.

Record approximate elapsed time.

## Phase M — offline/privacy smoke

Disable network connectivity before launch.

Verify core flow still works:
- choose photo;
- choose target;
- compress;
- verify;
- save/share preparation.

Inspect final manifest/APK for:
- no INTERNET permission;
- no broad storage/media permissions;
- no AdMob;
- no UMP;
- no analytics SDK.

## Phase N — relaunch/recovery smoke

1. close app normally;
2. relaunch;
3. verify clean first-open state;
4. verify no stale REQUIRED target appears;
5. verify no crash.

Exploratory only:
- background/foreground during idle requirement state;
- rotate/recreate Activity if environment supports it.

If state resets on rotation without crash/data corruption, record as S6 UX observation unless current source-of-truth requires persistence.
If it crashes, corrupts data, or creates a false target/result, FAIL.

## Phase O — crash/ANR/log audit

For the full session:
- inspect logcat for fatal exceptions;
- note ANRs;
- note repeated warnings tied to core flow;
- record any error surfaced to the user.

No absence-of-evidence PASS: explicitly state what log window was checked.

## Phase P — visual/manual review

For each main screen:
- first open;
- requirement unselected;
- preset selected;
- Custom 10.5 KB;
- Custom 1.5 MB;
- PASS/ALREADY_READY;
- NOT_MET;
- REDUCED;
- Save;
- Share;

review:
- clipping;
- truncation;
- overlap;
- unreadable text;
- disabled-state clarity;
- selected-state clarity;
- CTA hierarchy;
- scroll accessibility;
- obvious touch-target problems.

Do not redesign. Record observations only.

## Required evidence output

Create:

`docs/qa/FULL_MANUAL_LIKE_APP_TEST_REPORT_v1.0.md`

and an evidence folder:

`evidence/manual_like/`

Include:
- environment identity;
- tested git/source commit;
- artifact hashes;
- scenario table;
- expected vs actual;
- screenshot paths;
- UI hierarchy paths where useful;
- source hash before/after;
- Save/Share evidence;
- crash/ANR/log summary;
- visual observations;
- unresolved defects;
- final disposition.

## Final disposition vocabulary

Use exactly one:

### PASS_FOR_PLAY_INTERNAL_TESTING
Only if:
- no material defect found;
- truth semantics intact;
- builds/tests pass;
- API36/API29 core smoke pass;
- artifacts/evidence are coherent.

### FAIL_STOP
Use if any material buyer-job, truth, crash, save/share, source-preservation, privacy, or artifact-integrity defect is found.

### PARTIAL
Use if the test environment/tooling prevents required checks.

Do not convert PARTIAL into PASS.

## Source mutation guard

Before finalizing, run:

```bash
git diff --name-only a539a912f0e5ed05790f02cbe7ad1a77ebf7316e..HEAD
```

If any product source/build file changed during this QA-only run:
- STOP;
- disposition = FAIL_STOP or PARTIAL as appropriate;
- do not claim the existing AAB remains valid.

If only evidence/docs files changed, an evidence-only commit may be pushed.

## Final response to user

Return:
- final disposition;
- tested HEAD;
- tested product-source commit;
- API36 result;
- API29 result;
- artifact hashes;
- PASS/FAIL/PARTIAL count;
- material defects;
- nonblocking UX observations;
- evidence-only commit SHA if created;
- whether current AAB remains eligible as the technical Play candidate;
- next owner.

Do not sign.
Do not upload to Play.
Do not integrate AdMob.
Do not claim S6, BUILD, Artifact Freeze, release, or publication.
