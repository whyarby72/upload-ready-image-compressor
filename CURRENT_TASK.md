# CURRENT_TASK.md

Task ID: TASK-S5-003
Owner: CODEX
Reviewer: CHAT
Stage: S5_INTERNAL_TEST_READY
Priority: HIGH
Status: OPEN

## Goal

Repair the known requirement-capture defect before any Google Play Internal Testing upload.

Current defect:
- the requirement screen preselects `1 MB`;
- `REQUIRED` can therefore exist without an explicit user-provided website/form limit;
- this can produce a mathematically correct PASS against an app default while failing the user's real external requirement.

Required product truth:
- known external limit -> explicit user selection -> eligible for PASS / NOT_MET;
- unknown external limit -> deliberate unknown path -> REDUCED only.

## Authorized scope

This task authorizes a narrow reversible source/UI defect repair plus proportional verification.

It does NOT authorize:
- broad visual redesign;
- Save/Share CTA reordering;
- NOT_MET/REDUCED copy redesign beyond what is required by this task;
- new features;
- AdMob/UMP/analytics;
- Play Console upload;
- signing identity creation/selection;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Source of truth

Read first:
1. `docs/ux/FIRST_OPEN_REQUIREMENT_DEEP_AUDIT_v1.0.md`
2. `PRODUCT_SPEC.md`
3. `S5_INTERNAL_TEST_PLAN.md`
4. `S6_INTERNAL_TEST_PLAN.md`
5. `docs/product/APP_IDENTITY_FINAL_v1.0.md`
6. `AGENTS.md`

## Required source changes

### RTF-01 — Remove implicit 1 MB REQUIRED
- Do not call `selectTarget(1 MB, ...)` during `onCreate`.
- Do not initialize a valid target that can be used without deliberate user action.
- Use a safe unselected state such as target bytes = 0 / null-equivalent.

### RTF-02 — Reset requirement state for each newly selected photo
When `showRequirement(...)` opens:
- clear any previous target selection;
- ensure no preset appears selected;
- display neutral requirement text such as `Choose the upload limit`;
- disable `Make it upload-ready`.

This prevents a target chosen for a prior photo from silently carrying into a new buyer job.

### RTF-03 — Explicit selection enables verified path
For 50 KB / 100 KB / 200 KB / 500 KB / 1 MB / valid Custom:
- set the target only after explicit user action;
- show `REQUIRED: <= X` using the existing UI glyph/style where appropriate;
- enable `Make it upload-ready`.

### RTF-04 — Defensive known-path guard
`startKnownCompression()` must not execute unless:
- an image exists; and
- a valid explicit target exists.

Do not rely only on the button-disabled state.

### RTF-05 — Preserve unknown path
`I don't know the upload limit` remains independently usable with no target selected.
It must continue to produce REDUCED / no upload-compatibility PASS claim.

### RTF-06 — Shorten requirement heading
Change:
`What does the website require?`

to:
`What's the upload limit?`

Helper copy:
`Choose the maximum size shown on the website or form.`

Do not reduce font sizes or preset touch targets merely to fit content.

## Required verification

1. `python scripts/preflight.py`
2. `./gradlew --no-daemon assembleDebug`
3. `./gradlew --no-daemon testDebugUnitTest`
4. `./gradlew --no-daemon lintDebug`
5. `./gradlew --no-daemon assembleRelease`
6. `./gradlew --no-daemon bundleRelease`
7. API 36 install/launch
8. API 29 install/launch
9. fresh first-open screenshot
10. fresh requirement-screen screenshot proving:
   - no preset selected;
   - neutral `Choose the upload limit`;
   - known-limit CTA disabled;
   - unknown-limit path visible/reachable
11. explicit 100 KB selection -> known-path PASS case remains truthful
12. aggressive explicit 50 KB -> honest NOT_MET
13. no-selection known-path cannot execute
14. unknown-limit path -> REDUCED only
15. valid Custom target -> selected target shown and verified path enabled
16. invalid Custom value -> no target/known-path authorization created
17. select target for photo A -> choose another photo -> target is cleared for photo B
18. Save/Share regression
19. original preservation regression
20. permission/privacy regression: no INTERNET, broad storage/media, AdMob/UMP/analytics
21. fresh APK/AAB bytes + SHA-256
22. update TEST_MATRIX, PROJECT_STATE, HANDOFF_CURRENT, evidence index
23. `python scripts/validate_release_authority.py`

## Acceptance

- S5-REQ-01: requirement screen opens with no selected target.
- S5-REQ-02: no valid REQUIRED exists before explicit selection.
- S5-REQ-03: known-path CTA is disabled until explicit valid target selection.
- S5-REQ-04: known compression has a defensive target-validity guard.
- S5-REQ-05: preset selection enables known path and displays the exact selected limit.
- S5-REQ-06: Custom target succeeds only after valid explicit input.
- S5-REQ-07: selecting a new photo clears any prior target.
- S5-REQ-08: unknown-limit path remains deliberate and REDUCED-only.
- S5-REQ-09: PASS / NOT_MET semantics remain actual-byte truthful.
- S5-REQ-10: heading is `What's the upload limit?` and standard 320x640 composition remains usable.
- S5-REQ-11: API36/API29, build/unit/lint/release/bundle, Save/Share, preservation, permission/privacy regressions PASS.
- S5-REQ-12: fresh post-fix APK/AAB identity, bytes, SHA-256 and signing state are recorded.
- S5-REQ-13: previous AAB `992a2acddb197796b7aec8be72923c7ec8759a2cb36cf39dcc7f91c32a60c7a6` is marked superseded/ineligible for Play upload after source change.
- S5-REQ-14: next owner is HUMAN_PLAY_CONSOLE only after all technical acceptance evidence passes.

## Done when

A fresh artifact proves the user must explicitly supply a known upload limit before any PASS/NOT_MET path, while the unknown path remains REDUCED-only.

Stop at HUMAN_PLAY_CONSOLE after producing the fresh unsigned/signed-state evidence. Do not claim S6, BUILD, Artifact Freeze, release, or publication.
