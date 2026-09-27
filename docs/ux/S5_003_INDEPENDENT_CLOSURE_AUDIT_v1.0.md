# S5_003_INDEPENDENT_CLOSURE_AUDIT_v1.0

Observed: 2026-09-27
Audited branch: `task/TASK-S5-003`
Audited closure: `bd690e8ac592d92ee2e3b1cd07698b2b87c22720`
Source fix: `99c635ddb1f2de40f5d665523e154385ce5ee55d`
Reviewer: CHAT
Disposition: HOLD_FRACTIONAL_TARGET_DISPLAY_TRUTH

## What independently passed

- Remote branch HEAD equals the reported closure commit.
- Starting HEAD -> source fix is exactly one source commit.
- Source fix -> closure contains evidence/docs/artifacts only; no app/build-logic source changes.
- Default 1 MB requirement is removed.
- Requirement screen is neutral on API36 and API29.
- Known CTA is disabled until explicit selection.
- Preset targets use decimal SI constants.
- Custom parsing uses BigDecimal and the bound range/separator rules.
- Known and unknown workers snapshot state before async dispatch.
- Unknown-limit action clears stale known target.
- Exact-byte PASS/NOT_MET proof is implemented.
- Fresh release AAB binary was independently decoded from the repo and SHA-256 verified:
  `968f3ae2928b407aa01efd96b14785c856d75861fe162d7f27bfc0169299c5e4`
  at 663,874 bytes.

## Material defect found

Binding decision:
`docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`

requires friendly decimal-SI display and gives examples:
- 1,500,000 bytes -> 1.5 MB
- fractional Custom values must not create rounded/misleading requirement proof.

Current code:

`selectTarget(...)` displays:
`REQUIRED: <= ` + `FormatUtils.target(bytes)`

Current `FormatUtils.target`:
- returns MB only when bytes divide exactly by 1,000,000;
- otherwise returns KB only when bytes divide exactly by 1,000;
- otherwise falls back to `FormatUtils.bytes`, which rounds KB to zero decimal places.

Deterministic examples:
- Custom 10.5 KB -> 10,500 bytes -> displayed as approximately `11 KB` instead of `10.5 KB`.
- Custom 1.5 MB -> 1,500,000 bytes -> displayed as `1500 KB` instead of `1.5 MB`.

The exact result proof later uses bytes correctly, but the REQUIREMENT surface itself is not faithful to the user's explicit fractional input.

## Evidence-control defect

`S5-REQ-24` was marked PASS from source inspection:
“FormatUtils decimal SI; proof exposes bytes.”

That control was too weak because it did not test the binding examples for fractional target display.

The earliest missed control is therefore:
- unit test for friendly target formatter;
- runtime/UI test for at least one fractional Custom target.

## Required repair

Keep TASK-S5-003 open.

Minimum source repair:
1. format target thresholds with exact decimal-SI friendly representation;
2. for >=1 MB, display MB with up to 3 useful fractional digits and no unnecessary trailing zeros;
3. for <1 MB, display KB with up to 3 useful fractional digits and no unnecessary trailing zeros;
4. never round the displayed maximum upward;
5. keep exact-byte result proof unchanged.

Required examples:
- 10,500 bytes -> `10.5 KB`
- 1,500,000 bytes -> `1.5 MB`
- 1,000 bytes -> `1 KB`
- 50,000,000 bytes -> `50 MB`
- 1,001 bytes -> `1.001 KB`

Required evidence:
- formatter unit tests;
- Custom 10.5 KB runtime requirement screenshot/hierarchy;
- Custom 1.5 MB runtime requirement screenshot/hierarchy;
- build/unit/lint/release/bundle;
- proportional PASS/NOT_MET/unknown regression;
- fresh APK/AAB hashes.

## Artifact disposition

Current reqfix AAB:
`968f3ae2928b407aa01efd96b14785c856d75861fe162d7f27bfc0169299c5e4`

is valid evidence for the current source but is HOLD for Play use because the source contains the fractional target display defect.

After repair, generate a fresh AAB and mark this AAB provenance-only.

## Gate

TASK-S5-003: REOPENED
S5-REQ-24: FAIL
S5 overall: HOLD
Next owner: CODEX
