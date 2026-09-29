# CODEX WORK ORDER — TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY v1.1

Status: IMPLEMENTATION AUTHORIZED
Observed: 2026-09-30
Branch: `task/TASK-S5-007`
Approval scope:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY IMPLEMENTATION`

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_IMPLEMENTATION`

## 0. Read first

Read and follow:
- `docs/qa/TASK_S5_007_OUTPUT_SIZE_DISPLAY_TRUTH_AUDIT_v1.0.md`
- `docs/ux/TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_SPEC_v1.0.md`
- `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md` if present
- `PROJECT_STATE.json`
- `CURRENT_TASK.md`

The human approval above is already recorded. Do not stop waiting for implementation approval.

## 1. Scope and authority

This task authorizes presentation-only Result-screen clarity work plus deterministic QA/evidence.

QA build commands are authorized for this task:
- `assembleDebug`
- unit tests
- `lintDebug`
- `assembleRelease`
- `bundleRelease`
- existing relevant instrumentation/regression

This QA-build authorization does NOT mean canonical BUILD promotion.

Do not:
- change target arithmetic;
- change compression behavior;
- change Save behavior;
- change package/version/SDK;
- sign;
- upload to Play;
- advance S6;
- promote BUILD;
- Artifact Freeze;
- release;
- publish.

## 2. Allowed app-source mutation

Expected app-source files:
- `app/src/main/java/com/afradadmedia/reducephotosize/MainActivity.kt`
- `app/src/main/java/com/afradadmedia/reducephotosize/FormatUtils.java`
- optional new or updated unit test under `app/src/test/java/com/afradadmedia/reducephotosize/` for formatting only

Do not modify other app/source files.

If a mechanical build blocker appears to require another app/source file:
STOP and report the exact blocker before changing that file.

Protected domain files:
- `JpegCompressionEngine.java`
- `TargetLimitParser.java`
- `ImageInspector.java`
- `MediaStoreSaver.java`
- `ResultContentProvider.java`

These must remain unchanged.

## 3. Frozen unit semantics

These are binding:
- 1 KB = 1,000 bytes
- 1 MB = 1,000,000 bytes
- exact bytes are authoritative
- PASS iff `outputBytes <= targetBytes`

Do NOT switch to 1,024-byte arithmetic.
Do NOT change presets or custom-target parsing.

## 4. Formatting implementation

Keep existing `FormatUtils.bytes()` behavior unchanged for the large scan-friendly decimal-SI summary.

Add a separate presentation-only helper for grouped exact byte counts.

Canonical English grouping examples:
- `0` -> `0`
- `999` -> `999`
- `1000` -> `1,000`
- `495669` -> `495,669`
- `1000000` -> `1,000,000`

The grouping helper must never participate in arithmetic or PASS/NOT_MET classification.

Add deterministic unit tests covering at least those examples and proving existing decimal-SI summary behavior is unchanged.

## 5. Result copy

Keep the large rounded result size, for example:
`496 KB`

Immediately below it, use explicit exact-byte truth.

### PASS

Required pattern:
`Actual file: 495,669 bytes ≤ 500,000-byte limit — PASS`

### NOT_MET

Required pattern:
`Actual file: 80,947 bytes > 50,000-byte limit — NOT_MET`

### REDUCED / unknown limit

Required first line:
`Actual file: <grouped exact bytes> bytes · no upload limit entered`

Retain explicit no-PASS semantics, for example:
`No PASS claim`

Do not imply that REDUCED met an unknown target.

## 6. Unit disclosure

Add one quiet secondary helper on Result screens:

`Size units here: 1 KB = 1,000 bytes. Some file managers calculate KB using 1,024 bytes.`

Presentation requirements:
- secondary text color;
- body/label scale below exact proof prominence;
- no modal;
- no tooltip required;
- may wrap;
- main content remains vertically scrollable;
- Save and secondary actions only need to remain reachable by scroll at 320x640;
- no need to force all actions above the fold.

Do not repeat this note under Before/After thumbnails.

## 7. Build and tests

Run:

```bash
./gradlew clean assembleDebug
./gradlew test
./gradlew lintDebug
./gradlew assembleRelease
./gradlew bundleRelease
```

Run existing relevant instrumentation/regression suites where available.

Do not weaken assertions to obtain PASS.

Verify protected domain diff is NONE.

## 8. Required API 36 runtime evidence

Capture fresh evidence for:
- PASS at 360x800
- NOT_MET at 360x800
- REDUCED at 360x800
- PASS at 320x640
- PASS at font scale 1.3

Persist each screenshot with deterministic semantic binding:
1. screenshot PNG + SHA-256;
2. foreground-package proof from the same state/session;
3. UIAutomator hierarchy from the same state/session.

Expected foreground package:
`com.afradadmedia.reducephotosize`

### PASS required anchors
- `MEETS LIMIT`
- `Actual file:`
- exact grouped output bytes
- exact grouped target bytes
- `PASS`
- unit-disclosure text

PASS forbidden anchors:
- `TARGET NOT MET`
- `NOT_MET`

### NOT_MET required anchors
- `TARGET NOT MET`
- `Actual file:`
- `>`
- `NOT_MET`
- unit-disclosure text

### REDUCED required anchors
- `SMALLER COPY`
- `Actual file:`
- `no upload limit entered`
- `No PASS claim`
- unit-disclosure text

REDUCED forbidden anchor:
- `MEETS LIMIT`

Do not mark screenshot evidence PASS from filename or manifest prose alone.

## 9. Saved-file fidelity proof

Exercise the actual in-app Save action.

Use a deterministic PASS case.

After Save:
- identify the app result cache file for the same result;
- identify the MediaStore saved JPEG created by the UI Save path.

For debug/emulator evidence, the app result cache is expected under:
`cache/share/result.jpg`
inside `com.afradadmedia.reducephotosize`.

Use the debug package context to retrieve/hash the internal result file and normal shared-storage/MediaStore access for the saved JPEG.

Record for both:
- exact bytes;
- SHA-256;
- saved display name/path or URI evidence;
- result state/target used;
- equality result.

PASS only if:
- saved bytes == result bytes; and
- saved SHA-256 == result SHA-256.

Do not change `MediaStoreSaver.java` to make this proof easier.

## 10. Layout/density acceptance

Verify:
- large rounded size remains the visual focal point;
- exact proof is readable;
- unit disclosure is visually secondary;
- no clipping/overlap at 360x800;
- 320x640 remains usable by vertical scroll;
- font scale 1.3 remains usable;
- Save, Share, Compress another remain reachable;
- Before/After compact labels remain unchanged unless a mechanical layout fix is required.

## 11. Evidence and Source-of-Truth reconciliation

Create:
`evidence/play/S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_PROOF.json`

Record:
- exact tested source commit;
- debug APK bytes/SHA-256;
- release APK/AAB hashes if built;
- build/test/lint/instrumentation results;
- protected-domain diff;
- formatting unit-test results;
- screenshot hashes;
- foreground/hierarchy evidence paths;
- saved-file result-vs-saved byte/hash proof.

Update:
- `evidence/INDEX.json`
- `TEST_MATRIX.csv`
- `PROJECT_STATE.json`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`

Reconcile Play handoff state so it cannot resume until TASK-S5-007 is also closed.

## 12. Completion state

If deterministic QA is complete:

Set:
`IMPLEMENTED_MACHINE_QA_PASS_CHAT_HUMAN_REVIEW_READY`

Next owner:
`CHAT + HUMAN`

Do not self-approve final product/visual clarity.

Do not resume Play handoff yourself.

## 13. Final report

Report:
- implementation source commit;
- evidence closure commit;
- debug APK SHA-256;
- exact changed app/source files;
- protected-domain diff result;
- formatting unit-test result;
- PASS/NOT_MET/REDUCED evidence paths;
- foreground + UI hierarchy binding result;
- saved-file byte/hash equality proof;
- 320x640/font-scale usability result;
- unresolved exceptions, if any.

Then STOP for CHAT review.
