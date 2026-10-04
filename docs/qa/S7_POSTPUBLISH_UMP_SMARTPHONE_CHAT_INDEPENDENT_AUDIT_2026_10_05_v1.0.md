# S7 Post-Publish UMP + AdMob Smartphone — CHAT Independent Audit

Date: 2026-10-05
Product: PHOTO COMPRESSOR: KB LIMIT
Canonical branch: `task/TASK-S7-001`
Runtime evidence commit: `485cf2413c38e1b6c5a253600514612e02fc208e`

## Verdict

`PASS_S7_RUNTIME_WITH_NONBLOCKING_COUNTRY_SPECIFIC_DNC_OBSERVABILITY_DEBT`

The runtime evidence is accepted as valid and artifact-bound for the tested device/environment. The only unresolved nuance is that the forced-EEA debug geography did not expose a literal first-layer `Do not consent` button.

This is classified as `NOT_PROVEN_FOR_COUNTRY_SPECIFIC_FIRST_LAYER_LABEL`, not a runtime failure, because Google's European-regulations UI can configure first-layer choices per country, while UMP's Android debug geography exposes an EEA-region simulation rather than a specific EEA country.

## FACT — artifact-bound findings

- Evidence commit exists and is exactly one evidence-only commit ahead of the prior canonical S7 HEAD.
- No app source file changed in the runtime evidence commit.
- Physical device: Samsung SM-N980F, Android 13 / API 33.
- Final clean source HEAD under test: `ca4f528b7c4f9a470ea7e22e629e13db4f9d07eb`.
- Final clean debug APK SHA-256: `622c95c6167d4f672ab58faf067b91a052dd7e5a0f00d12b937b0392e5886b04`.
- UMP European-regulations first layer displayed under the temporary official forced-EEA debug path.
- First layer visibly contained `Consent` and `Manage options`; literal `Do not consent` was not visible.
- Manage-options screen showed consent toggles off by default.
- After confirming choices with consent toggles off, UMP persisted `IABTCF_gdprApplies=1`, `IABTCF_PurposeConsents=00000000000`, and vendor consent bits all zero.
- `Privacy choices` was present in the app and the UMP privacy form was reopened.
- Genuine compression result was reached.
- Save was exercised; Share and Compress another were present/usable.
- Google demo/test banner loaded below buyer-critical result/actions and no ad was clicked.
- Offline core flow remained functional and reached a truthful NOT_MET result.
- Temporary UMP test-device/geography/reset code was removed before evidence commit.
- Final build/test/lint passed after cleanup.
- Network state was restored after offline validation.

## INFERENCE

The missing literal first-layer `Do not consent` label in the forced-EEA test does not by itself prove that selected real EEA/UK/Swiss countries will receive a two-button message. Google documents that button choices can be configured per country, while Android debug geography only simulates the EEA region. Therefore exact country-specific button rendering is not established by this debug mode.

The tested refusal behavior through Manage options is functionally valid evidence that a user can withhold consent; however it is not equivalent evidence for the configured single-click first-layer `Do not consent` button.

## UNKNOWN / residual evidence debt

- Exact first-layer button set for a real user located in each configured EEA/UK/Swiss country.
- Whether Google's forced-EEA debug mode maps country-specific user-choice rules to a deterministic country.
- A natural, non-debug EEA/UK/Swiss runtime observation.

## Risk disposition

Severity:
`LOW / NONBLOCKING_FOR_S7_TECHNICAL_RUNTIME`

Reason:
- provider configuration evidence previously showed `Do not consent = ON` with selected countries;
- UMP/provider-backed message delivery is proven;
- refusal semantics are proven through Manage options and persisted TCF consent state;
- the remaining gap is exact country-specific first-layer rendering, which the available debug geography cannot deterministically prove.

Escalate to blocker only if:
- a real target-country device/user sees no configured `Do not consent` button where the provider configuration says it should appear; or
- AdMob later reports a policy/configuration warning related to user choices.

## S7 technical runtime disposition

PASS:
- provider-backed UMP delivery;
- consent-management path;
- privacy-options path;
- ad-request/banner path under safe demo traffic;
- non-obstruction;
- offline degradation;
- cleanup;
- deterministic final build/test/lint.

Residual:
`COUNTRY_SPECIFIC_DNC_FIRST_LAYER_NOT_RUNTIME_PROVEN`

Next recommended gate:
`W2 POST-ADMOB PRIVACY + PLAY DECLARATION RECONCILIATION`
