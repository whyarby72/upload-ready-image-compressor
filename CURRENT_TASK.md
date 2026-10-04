# CURRENT_TASK.md

Task ID: S7_FAST_LANE_ADMOB_RUNTIME_VALIDATION
Owner: HUMAN_RUNTIME_EXECUTION + CHAT_AUDIT
Reviewer: CHAT
Stage: S7_PRODUCTION_ID_BOUND_CI_PASS_RUNTIME_PENDING
Priority: HIGH
Status: SOURCE_AND_CI_PASS / POSTPUBLISH_RUNTIME_VALIDATION_PENDING

## Authorization

Approval ref:
`USER_OPTION_1_2026-10-05_S7_PRODUCTION_ADMOB_ID_BINDING_POSTPUBLISH_UMP_RUNTIME_VALIDATION`

Authorized scope:
`S7 PRODUCTION ADMOB ID BINDING + POST-PUBLISH UMP RUNTIME VALIDATION`

No new ad unit creation and no Play production release are authorized.

## Bound source state

Branch:
`task/TASK-S7-001`

Production-ID binding commit:
`91b90466e0d5df6f61b5e00c12130264f85ee3e1`

Implementation:
- production AdMob App ID bound;
- release variant uses the single existing production Banner ID;
- debug variant uses Google's demo Banner ID for safe test traffic;
- published UMP message remains provider-backed through the production App ID.

## Deterministic CI closure — PASS

Evidence:
`evidence/admob/S7_PRODUCTION_ID_BINDING_CI_CLOSURE_2026_10_05_v1.0.md`

GitHub Actions run:
`37233806993`

Job:
`111528832328`

PASS:
- assembleDebug;
- assembleRelease;
- testDebugUnitTest;
- lintDebug;
- CI_VERIFY_PASS.

Disposition:
`PASS_SOURCE_AND_CI`

## Runtime validation still required

Run one short real-device validation using the debug/provider-backed path:

1. launch from a fresh app state;
2. verify core photo-compression flow remains usable;
3. exercise the UMP consent-required path if presented;
4. verify `Do not consent` can be selected when the message is shown;
5. verify Privacy choices / manage-options path when UMP reports it required;
6. reach ResultScreen and confirm demo Banner behavior does not obstruct result proof, Save, Share, or Compress another;
7. test offline/no-ad degradation;
8. stop after recording the concise result.

Do not deliberately generate clicks on ads.

## Authority boundary

Still NOT authorized:
- creating additional ad units;
- live-ad testing through deliberate impressions/clicks outside normal validation;
- Play closed/open/production promotion;
- Artifact Freeze;
- production release/publication of the Android app.

## Next action

Human runs the short real-device runtime checklist and returns only:
- `CORE_PASS` or failure;
- `UMP_SHOWN` / `UMP_NOT_SHOWN`;
- `DO_NOT_CONSENT_PASS` / not observed;
- `PRIVACY_CHOICES_PASS` / not observed;
- `BANNER_NONOBSTRUCTIVE_PASS` / not observed;
- `OFFLINE_PASS` / failure;
- any unexpected warning/error.


## Codex physical-smartphone execution handoff — 2026-10-05

Human selected:
`USER_OPTION_1_2026-10-05_USE_CODEX_FOR_SMARTPHONE_RUNTIME_VALIDATION`

Codex prompt:
`prompts/CODEX_S7_POSTPUBLISH_UMP_SMARTPHONE_RUNTIME_VALIDATION_v1.0.md`

Execution intent:
- use Codex with a physically connected Android smartphone through ADB;
- build/install the DEBUG variant;
- keep Google demo Banner traffic in debug;
- use provider-backed production App ID for UMP;
- if the message is not naturally observable outside Europe, use Google's official test-device + forced-EEA mechanism temporarily;
- revert all temporary UMP debug-geography/test-device/reset code before any commit;
- produce artifact-bound runtime evidence.

Chat runtime limitation:
`NO_DIRECT_CODEX_RUNNER_EXPOSED_IN_THIS_CHAT`

Therefore execution is ready for Codex Desktop/CLI attached to this repository and smartphone. CHAT must not claim smartphone-runtime PASS until Codex returns evidence.


## Codex smartphone runtime attempt — BLOCKED — 2026-10-05

Terminal disposition:
`BLOCKED_S7_POSTPUBLISH_RUNTIME_NO_ADB_DEVICE`

Reported by Codex:
- `adb devices -l` returned no physical device;
- UMP: NOT_OBSERVED;
- Do not consent: NOT_OBSERVED;
- Privacy choices: NOT_OBSERVED;
- Banner: NOT_OBSERVED;
- Offline: NOT_RUN;
- S7 worktree remained clean;
- HEAD remained `1563b08d3a9d88df2908eedf58d8246642aa5b0d`;
- no temporary UMP debug patch remained;
- original S5 working tree was not modified;
- Android SDK availability/path was checked during retry, but the terminal blocker remained lack of an ADB device.

Evidence classification:
`CODEX_REPORTED_RUNTIME_BLOCKER / NO_DEVICE_ARTIFACT_EVIDENCE`

Interpretation:
- source + deterministic CI remain PASS;
- real-device S7 runtime validation is still OPEN;
- no source rollback is required;
- next action is device connectivity recovery only, then rerun the existing Codex prompt.
