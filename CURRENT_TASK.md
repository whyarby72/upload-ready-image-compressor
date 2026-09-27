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

## RESOLVED UNIT / CUSTOM CONTRACT

The pre-code Custom semantics blocker is resolved by:
`docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`

Binding rules:
- KB = 1,000 bytes; MB = 1,000,000 bytes.
- Presets become exact decimal thresholds: 50,000 / 100,000 / 200,000 / 500,000 / 1,000,000 bytes.
- Custom converted range = 1,000..50,000,000 bytes.
- Custom supports at most 3 fractional digits.
- Accept one decimal separator, either dot or comma; reject both/grouped notation.
- Use exact decimal arithmetic, not `double`.
- Never round a maximum upward; floor fractional-byte conversion.
- Friendly KB/MB display uses decimal SI.
- PASS/NOT_MET proof includes exact bytes to avoid rounded-threshold ambiguity.
- Existing 1024-based artifact evidence becomes provenance after source changes.

## Required source changes

### RTF-01 — Remove implicit 1 MB REQUIRED
- Do not call `selectTarget(1 MB, ...)` during `onCreate`.
- Do not initialize a valid target that can be used without deliberate user action.
- Use a safe unselected state such as target bytes = 0 / null-equivalent.

### RTF-02 — Reset requirement state for each newly selected photo
Create one deterministic `clearTargetSelection()` / equivalent path and use it whenever a new requirement job begins.

When `showRequirement(...)` opens:
- clear any previous target selection;
- set target bytes to the safe unselected sentinel;
- ensure every preset/Custom button uses the unselected/default visual;
- display neutral requirement text `Choose the upload limit`;
- disable `Make it upload-ready`.

Also call the same reset from `reset()` so returning to first-open cannot retain a hidden stale target.

This prevents a target chosen for a prior photo from silently carrying into a new buyer job.

### RTF-03 — Explicit selection enables verified path
For 50 KB / 100 KB / 200 KB / 500 KB / 1 MB / valid Custom:
- set the target only after explicit user action;
- show `REQUIRED: <= X` using the existing UI glyph/style where appropriate;
- exactly one preset/Custom visual state may be selected;
- the latest valid explicit selection is authoritative;
- enable `Make it upload-ready` only when an image exists and the explicit target is valid.

### RTF-04 — Defensive known-path guard + immutable operation snapshot
`startKnownCompression()` must not execute unless:
- an image exists; and
- a valid explicit target exists.

Do not rely only on the button-disabled state.

Before dispatching work:
- snapshot the current `ImageInfo` into a local immutable reference;
- snapshot the explicit target bytes into a local value;
- use those snapshots for the progress decision and worker/compression call.

Do not let an asynchronous worker read a mutable target field as the authoritative requirement after dispatch.

### RTF-05 — Preserve unknown path and abandon stale known-target semantics
`I don't know the upload limit` remains independently usable with no target selected.
It must continue to produce REDUCED / no upload-compatibility PASS claim.

If the user previously selected a known target and then explicitly chooses the unknown-limit action:
- clear/abandon the known target before dispatch;
- do not carry `REQUIRED` into the unknown result semantics;
- result must still be REDUCED / ALREADY_SMALL / ERROR as applicable, never PASS / NOT_MET against the abandoned target.

Snapshot the current image for the unknown worker path as well.

### RTF-06 — Safe XML defaults + shortened requirement heading
The layout resource itself must be fail-safe before Java state mutation:
- `selectedTargetText` default text = `Choose the upload limit`;
- `makeReadyButton` default `android:enabled="false"`;
- do not ship XML with `REQUIRED: 1 MB` as the default visible state.

Change heading:
`What does the website require?`

to:
`What's the upload limit?`

Helper copy:
`Choose the maximum size shown on the website or form.`

Do not reduce font sizes or preset touch targets merely to fit content.

### RTF-07 — Custom-target invariants
- valid Custom input creates the explicit target and selects only the Custom visual state;
- invalid Custom input with no prior valid target leaves the screen unselected and known-path CTA disabled;
- invalid/cancelled Custom input after a prior valid target must not silently replace or corrupt that prior target; the displayed REQUIRED and enabled state must continue to match the last valid explicit selection;
- switching from Custom to a preset, or preset A to preset B, must use only the latest valid explicit target.

### RTF-08 — Error/retry selection semantics
- known-path processing error may return to the requirement screen with the same explicit target still visible/valid for retry;
- unknown-path processing must not resurrect an abandoned known target on error/retry;
- no error path may create a valid REQUIRED value from the unselected sentinel.

## Custom-limit verification additions

Add explicit tests for:
- 50 KB = 50,000 bytes;
- 100 KB = 100,000 bytes;
- 200 KB = 200,000 bytes;
- 500 KB = 500,000 bytes;
- 1 MB = 1,000,000 bytes;
- minimum 1 KB exactly and immediately below;
- maximum 50 MB exactly and immediately above;
- `10.5 KB` -> 10,500 bytes;
- `1.5 MB` and `1,5 MB` -> 1,500,000 bytes;
- >3 fractional digits rejected;
- inputs containing both dot and comma rejected;
- visible friendly size uses decimal SI;
- PASS/NOT_MET proof exposes exact byte comparison;
- output immediately above/below a custom threshold;
- prior valid target -> invalid/cancelled Custom preserves prior target;
- no prior target -> invalid Custom remains unselected.

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
13. no-selection known-path cannot execute, including direct/programmatic invocation of the guarded method
14. unknown-limit path from a clean unselected state -> REDUCED only
15. select 100 KB, then deliberately choose unknown-limit -> known target is abandoned and result remains REDUCED-only
16. valid Custom target -> selected target shown and verified path enabled
17. invalid Custom with no prior selection -> still unselected / known CTA disabled
18. valid 100 KB -> invalid/cancelled Custom -> 100 KB remains the last valid explicit target; no silent mutation
19. switch 100 KB -> 500 KB -> only 500 KB is visually/semantically authoritative and compression uses 500 KB
20. select valid target for photo A -> complete/reset via `Compress another` -> choose photo B -> requirement target is cleared for photo B
21. API29 requirement-screen smoke after selecting a JPEG -> no default target and known CTA disabled
22. Save/Share regression
23. original preservation regression
24. known-path error/retry preserves only the explicit target; unknown-path error/retry does not resurrect one
25. permission/privacy regression: no INTERNET, broad storage/media, AdMob/UMP/analytics
26. fresh APK/AAB bytes + SHA-256
27. update TEST_MATRIX, PROJECT_STATE, HANDOFF_CURRENT, evidence index
28. `python scripts/validate_release_authority.py`

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
- S5-REQ-15: XML/resource defaults are fail-safe: neutral requirement text + known CTA disabled before runtime selection.
- S5-REQ-16: unknown-limit action clears/abandons any prior known target semantics.
- S5-REQ-17: the worker uses snapshotted image/target values captured at dispatch, not mutable target state.
- S5-REQ-18: target switching and invalid/cancelled Custom interactions preserve a single truthful last-valid-selection invariant.
- S5-REQ-19: API29 JPEG picker reaches the same unselected requirement state as API36.
- S5-REQ-20: presets use decimal byte thresholds (50k/100k/200k/500k/1,000k bytes).
- S5-REQ-21: Custom range is exactly 1,000..50,000,000 bytes.
- S5-REQ-22: Custom decimal parser accepts one dot OR comma separator, rejects ambiguous/grouped input, and allows at most 3 fractional digits.
- S5-REQ-23: requirement conversion uses exact decimal arithmetic and never rounds a maximum upward.
- S5-REQ-24: friendly size display uses decimal SI; known-limit proof includes exact bytes.
- S5-REQ-25: old 1024-based S5 artifacts/evidence remain provenance only after fresh artifacts are generated.

## Done when

A fresh artifact proves the user must explicitly supply a known upload limit before any PASS/NOT_MET path, while the unknown path remains REDUCED-only.

The Custom semantics blocker is resolved. Execute the repaired task and stop at HUMAN_PLAY_CONSOLE after producing fresh unsigned/signed-state evidence. Do not claim S6, BUILD, Artifact Freeze, release, or publication.


## Independent closure review — corrective repair required

Binding audit:
`docs/ux/S5_003_INDEPENDENT_CLOSURE_AUDIT_v1.0.md`

The reported closure is not accepted as final because `S5-REQ-24` is false-positive for fractional Custom target display.

Required correction:
- `FormatUtils.target(10_500)` -> `10.5 KB`
- `FormatUtils.target(1_500_000)` -> `1.5 MB`
- `FormatUtils.target(1_000)` -> `1 KB`
- `FormatUtils.target(50_000_000)` -> `50 MB`
- `FormatUtils.target(1_001)` -> `1.001 KB`

Rules:
- decimal SI only;
- up to 3 useful fractional digits;
- trim trailing zeros;
- do not round the displayed maximum upward;
- preserve exact-byte PASS/NOT_MET proof.

Add deterministic formatter unit tests and runtime Custom requirement evidence for 10.5 KB and 1.5 MB.

Current AAB `968f3ae2928b407aa01efd96b14785c856d75861fe162d7f27bfc0169299c5e4` is HOLD and becomes provenance after the correction.
