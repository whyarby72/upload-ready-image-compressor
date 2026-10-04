# S7 DNC Provider Preview Reconciliation — 2026-10-05

Product: PHOTO COMPRESSOR: KB LIMIT
Canonical branch: `task/TASK-S7-001`

## FACT — screenshot-observed provider state

The current AdMob European-regulations editor shows:

- message: `Photo Compressor EU Consent v1`;
- app: `Photo Compressor: KB Limit`;
- Consent: ON;
- Manage options: ON;
- Do not consent: ON;
- Close (do not consent): OFF;
- preview first layer visibly contains:
  - `Do not consent`;
  - `Consent`;
  - `Manage options`.
- top-right action is `Publish changes`.

Separate country-selection screenshots show intended target countries ON and `Everywhere else` OFF.

## Interpretation

Provider-side DNC configuration and preview are now reconciled: the editor preview is the intended three-choice first layer.

However, the visible `Publish changes` action means there is at least one unpublished provider delta in the current editor state.

The exact delta is not independently enumerated by the screenshot, but the strongest explanation for the earlier two-button physical-device runtime is that the currently correct DNC configuration/preview is not yet the version served by the published message.

Classification:
- provider configuration: `PASS_IN_EDITOR`;
- provider preview: `PASS_THREE_BUTTON`;
- served/published configuration: `NOT_YET_RECONCILED`;
- next gate: `SCOPED_PUBLISH_CHANGES_APPROVAL`.

## Governance

Do NOT click `Publish changes` without explicit approval bound to:
`Photo Compressor EU Consent v1 — publish current consent-message changes only`.

No app source, AdMob IDs, ad units, Play release, or production Android publication is included in that approval.
