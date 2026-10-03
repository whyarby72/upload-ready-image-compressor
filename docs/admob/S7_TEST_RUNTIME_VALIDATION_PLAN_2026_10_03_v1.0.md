# S7 TEST RUNTIME VALIDATION PLAN — 2026-10-03 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT  
Branch: `task/TASK-S7-001`  
Implementation commit: `49829356e02c41357db9bce64463ddead1d1d1f4`  
Authorization: `USER_OPTION_1_2026-10-03_S7_TEST_RUNTIME_VALIDATION_ONLY`

## Purpose

Prove that the already-CI-green AdMob/UMP TEST integration behaves safely at runtime without any AdMob/Play provider mutation.

This plan does **not** prove production ad readiness.

## Environment record

Record:
- device model or emulator profile;
- Android version / API;
- install route;
- app build identity if available;
- network state for each case.

Use only non-sensitive JPEG fixtures.

## Runtime matrix

### RT-01 Launch / no core regression

Expected:
- app launches without crash/ANR;
- Home UI remains usable;
- no ad blocks first interaction.

### RT-02 Core buyer job before monetization

Run:
Choose JPEG → CURRENT → explicit limit → process → Result.

Expected:
- all S5 core behavior remains correct;
- no ad/consent surface prevents reaching verified result.

### RT-03 ResultScreen placement

Expected:
- ad surface is only on ResultScreen;
- verified result proof is above monetization;
- Save / Share / Compress another remain above monetization and usable;
- ad does not overlay or resemble app controls.

If no ad is returned, record `NO_FILL/NO_AD_OBSERVED`; do not treat that as core failure.

### RT-04 Consent gate

Observe launch-time UMP behavior.

Record one of:
- `CONSENT_FORM_OBSERVED`;
- `CONSENT_NOT_REQUIRED`;
- `NOT_OBSERVABLE_WITH_TEST_PROVIDER_STATE`;
- `FAIL`.

Expected:
- ad requests are not eligible until UMP allows them;
- consent/UMP error does not block the core app.

### RT-05 Privacy choices

If UMP reports privacy options required:
- `Privacy choices` must appear;
- tapping it must open the privacy-options flow;
- returning must leave the app usable.

If UMP does not report it required, record `NOT_APPLICABLE/NOT_OBSERVABLE`. Do not fabricate a PASS.

### RT-06 Offline degradation

Disable network before launch or before result flow.

Expected:
- app launches;
- Choose JPEG / CURRENT / compression / result / Save / Share remain usable;
- no permanent ad spinner, modal block, or retry loop prevents buyer-job completion;
- ad may be absent.

### RT-07 Ad failure/no-fill behavior

If an ad error/no-fill is naturally observed:
- core UI must remain unaffected;
- result and actions remain usable.

If not naturally observed, record `NOT_OBSERVED`; do not force provider mutation merely to create a failure.

## Exit rule

PASS requires:
- RT-01 PASS;
- RT-02 PASS;
- RT-03 placement PASS if an ad renders, otherwise placement code remains CI-bound and runtime is `NO_AD_OBSERVED`;
- RT-04 no core-blocking consent failure;
- RT-06 PASS;
- no material buyer-job regression.

Conditional UMP/provider paths may remain `NOT_OBSERVABLE` until bounded provider setup exists.

## Hard stop

`STOP_AFTER_TEST_ONLY_RUNTIME_VALIDATION_RESULTS_ARE_CAPTURED`

No production IDs or provider mutations are allowed.
