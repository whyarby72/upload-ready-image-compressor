# S7 Post-Publish UMP + AdMob Smartphone — CHAT Independent Audit v1.1

Date: 2026-10-05
Product: PHOTO COMPRESSOR: KB LIMIT
Runtime evidence commit: `485cf2413c38e1b6c5a253600514612e02fc208e`

Supersedes:
`docs/qa/S7_POSTPUBLISH_UMP_SMARTPHONE_CHAT_INDEPENDENT_AUDIT_2026_10_05_v1.0.md`

## Revised verdict

`TECHNICAL_RUNTIME_PASS / COMPLIANCE_HOLD_DNC_RUNTIME_PROVIDER_DOC_CONFLICT`

The technical runtime evidence is valid and artifact-bound, but the exact European-regulations first-layer/refusal UX cannot be closed because observed runtime behavior conflicts with current official Google documentation.

## FACT — artifact-bound

- UMP provider-backed message displayed on a physical Samsung SM-N980F / Android 13 under the official forced-EEA debug path.
- The observed first layer displayed only:
  - Consent
  - Manage options
- A literal `Do not consent` button was not displayed.
- The app's `Privacy choices` entry point successfully reopened a UMP form, but the captured reopened first layer again displayed only Consent + Manage options.
- Manage options showed consent toggles off by default.
- Confirming choices with those toggles off persisted zero purpose consents and zero vendor consents.
- Banner/demo-ad, core flow, Save/Share/Compress another, offline degradation, cleanup, and final build/test/lint all passed.
- Runtime evidence commit contains evidence only; no app source mutation.

## FACT — current official Google documentation

Current Google AdMob documentation states:
- European regulations message button choices can be configured per country.
- When `Do not consent` is ON, the selected countries should receive a single-click `Do not consent` option on the first page.
- When a European regulations message reappears through an app privacy/revocation entry point, Google documents a standardized three-option display: `Do not consent`, `Consent`, and `Manage options`.
- UMP debug geography can force an EEA-region simulation, but the public Android API does not expose a specific-country debug selector.

## Conflict

Observed:
`TWO_BUTTON_RUNTIME_FORM`

Configured/provider intent:
`DNC_ON_FOR_SELECTED_EEA_UK_SWITZERLAND_COUNTRIES`

Documented privacy-revocation expectation:
`THREE_BUTTON_REAPPEARANCE`

Because the runtime evidence and official documentation do not fully reconcile, the DNC issue is upgraded from nonblocking observability debt to a bounded compliance HOLD.

## What is still proven

The user can withhold consent through Manage options:
- consent toggles default OFF;
- `Confirm choices` completes with zero purpose/vendor consents.

This proves refusal semantics, but does not prove the configured single-click first-layer DNC UX.

## What is not proven

- Why the published provider-backed form omitted `Do not consent` under forced-EEA runtime.
- Whether a real user in each selected target country receives the configured three-button first layer.
- Why the privacy-options reopening did not show the three-button layout described by current Google documentation.

## Disposition

Technical runtime:
`PASS`

Consent/refusal semantics:
`PASS_VIA_MANAGE_OPTIONS`

Configured single-click DNC:
`NOT_PROVEN`

European-message compliance closure:
`HOLD_PENDING_PROVIDER_CONFIGURATION_RECHECK_OR_PROVIDER_BEHAVIOR_RECONCILIATION`

## Minimal next gate

Perform one targeted provider-side recheck of the already-published message:
1. confirm `Do not consent = ON`;
2. confirm the country selection still includes all intended EEA countries + UK + Switzerland;
3. confirm the published preview renders the three-button first layer.

If all three remain correct, retain the runtime discrepancy as a Google debug/provider behavior issue and proceed with a documented residual provider observability exception. If any setting drifted, correct it and republish before S7 close.
