# CURRENT_TASK.md

Task ID: S7_FAST_LANE_POST_ADMOB_RECONCILIATION
Owner: CHAT_AUDIT + HUMAN_APPROVAL_WHERE_REQUIRED
Reviewer: CHAT
Stage: S7_RUNTIME_PASS_W2_RECONCILIATION_PENDING
Priority: HIGH
Status: RUNTIME_PASS_WITH_NONBLOCKING_DNC_OBSERVABILITY_DEBT / W2_PENDING

## Authorization

Approval ref:
`USER_OPTION_1_2026-10-05_S7_PRODUCTION_ADMOB_ID_BINDING_POSTPUBLISH_UMP_RUNTIME_VALIDATION`

## Bound source and provider state

Product:
`Photo Compressor: KB Limit`

Package:
`com.afradadmedia.reducephotosize`

Canonical branch:
`task/TASK-S7-001`

Production AdMob App ID:
bound in source.

Exactly one production Banner ad unit:
bound to release variant.

Debug ad traffic:
Google demo Banner ad unit.

European regulations message:
`Photo Compressor EU Consent v1`

Provider status:
`PUBLISHED`

## Deterministic CI

Production-ID binding commit:
`91b90466e0d5df6f61b5e00c12130264f85ee3e1`

CI run:
`37233806993`

Result:
`PASS_SOURCE_AND_CI`

## Physical smartphone runtime

Evidence commit:
`485cf2413c38e1b6c5a253600514612e02fc208e`

Evidence result:
`PARTIAL_S7_POSTPUBLISH_RUNTIME_DO_NOT_CONSENT_LABEL_NOT_OBSERVED`

Independent CHAT audit:
`docs/qa/S7_POSTPUBLISH_UMP_SMARTPHONE_CHAT_INDEPENDENT_AUDIT_2026_10_05_v1.0.md`

CHAT disposition:
`PASS_S7_RUNTIME_WITH_NONBLOCKING_COUNTRY_SPECIFIC_DNC_OBSERVABILITY_DEBT`

Validated:
- provider-backed UMP display;
- consent-management/refusal path;
- Privacy choices;
- genuine core compression;
- Save / Share / Compress another availability;
- safe demo Banner load below buyer-critical controls;
- no ad click;
- offline/no-ad degradation;
- cleanup of all temporary UMP debug hooks;
- final clean build/test/lint.

Residual evidence debt:
`COUNTRY_SPECIFIC_DNC_FIRST_LAYER_NOT_RUNTIME_PROVEN`

This residual is nonblocking for S7 technical runtime because UMP debug geography simulates EEA but does not expose deterministic country-specific selection, while the provider configuration separately records `Do not consent = ON` for selected target countries.

## Next gate

`W2 POST-ADMOB PRIVACY + PLAY DECLARATION RECONCILIATION`

Required reconciliation:
- app/source behavior versus Privacy Policy claims;
- AdMob/UMP data handling versus `store/DATA_SAFETY_DRAFT.md`;
- ads declaration versus actual implementation;
- privacy choices/revocation surface;
- source-image isolation from ads/analytics;
- current Play/Data Safety mutable requirements before broader release.

## Authority boundary

Still NOT authorized:
- new ad units;
- Play closed/open/production promotion;
- Artifact Freeze;
- production Android release/publication.
