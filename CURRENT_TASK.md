# CURRENT_TASK.md

Task ID: S7_DNC_PROVIDER_RUNTIME_RECONCILIATION
Owner: HUMAN_PROVIDER_OBSERVATION + CHAT_AUDIT
Reviewer: CHAT
Stage: S7_TECHNICAL_RUNTIME_PASS_COMPLIANCE_RECONCILIATION
Priority: HIGH
Status: TECHNICAL_RUNTIME_PASS / COMPLIANCE_HOLD_DNC_PROVIDER_DOC_CONFLICT

## Bound evidence

Canonical branch:
`task/TASK-S7-001`

Runtime evidence commit:
`485cf2413c38e1b6c5a253600514612e02fc208e`

Independent audit v1.1:
`docs/qa/S7_POSTPUBLISH_UMP_SMARTPHONE_CHAT_INDEPENDENT_AUDIT_2026_10_05_v1.1.md`

## PASS

- production AdMob IDs bound;
- deterministic CI PASS;
- provider-backed UMP displayed on physical device;
- refusal semantics through Manage options PASS;
- Privacy choices entry point present;
- demo Banner load PASS;
- buyer-critical controls unobstructed;
- offline/no-ad degradation PASS;
- temporary debug hooks fully cleaned;
- final build/test/lint PASS.

## HOLD

Observed runtime UMP first layer and reopened privacy form showed only:
- Consent
- Manage options

No literal:
- Do not consent

This conflicts with the configured/provider intent and current official Google documentation for the relevant flows.

## Minimal next action

Provider-side read-only recheck of the already-published message only:
- verify Do not consent remains ON;
- verify intended EEA + UK + Switzerland country selections remain active;
- verify published preview shows the three-button first layer.

Do not create a new message or ad unit.
Do not change account-level settings unless drift is found.
Do not proceed to Artifact Freeze or production Play release while this HOLD remains open.

## Authority boundary

Still NOT authorized:
- new ad units;
- Play closed/open/production promotion;
- Artifact Freeze;
- production Android release/publication.
