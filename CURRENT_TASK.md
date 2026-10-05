# CURRENT_TASK.md

Task ID: W2_POST_ADMOB_PRIVACY_DATA_SAFETY_ADS_RECONCILIATION
Owner: CHAT_AUDIT + CODEX_FOR_ARTIFACT_CHECKS + HUMAN_FOR_PROVIDER_ACTIONS
Reviewer: CHAT
Stage: W2_POST_ADMOB_RECONCILIATION
Priority: HIGH
Status: S7_CLOSED_WITH_ACCEPTED_OBSERVABILITY_EXCEPTION / W2_PARTIAL_PASS_WITH_PRIVACY_SURFACE_BLOCKER

## S7 closure

Human decision:
`USER_OPTION_1_2026-10-05_ACCEPT_RESIDUAL_AND_PROCEED_W2`

Accepted residual:
`POST_REPUBLISH_THREE_BUTTON_PHYSICAL_DEVICE_OBSERVATION_NOT_REPEATED_DUE_EXECUTION_ENVIRONMENT`

S7 closure basis:
- provider three-button preview PASS;
- intended DNC country configuration PASS;
- consent message republished and provider status Published;
- prior physical-device UMP/refusal/privacy/banner/offline runtime evidence PASS except literal first-layer DNC observation before republish;
- minimal post-republish rerun blocked by ADB/Android SDK environment, not app failure;
- no source mutation occurred during blocked rerun.

S7 disposition:
`CLOSED_WITH_DOCUMENTED_PROVIDER_RUNTIME_OBSERVABILITY_EXCEPTION`

## W2 audit

Primary audit:
`docs/qa/W2_POST_ADMOB_PRIVACY_DATA_SAFETY_ADS_RECONCILIATION_2026_10_05_v1.0.md`

Reconciled store docs:
- `store/DATA_SAFETY_DRAFT.md`
- `store/ADS_DECLARATION.md`
- `store/PRIVACY_NOTES.md`

## W2 PASS

- GMA/UMP post-AdMob data model reconciled.
- Photo/JPEG content remains isolated from ads/analytics in app code.
- Data Safety candidate defined for:
  - Approximate location;
  - App interactions;
  - Diagnostics;
  - Device or other IDs.
- Play Ads declaration truth for the first ad-enabled distributed artifact is:
  `YES / CONTAINS ADS`
- UMP/privacy choices implementation is present.
- Publisher first-party ID disabled.

## W2 HOLD / blockers before broader release

1. persistent in-app Privacy policy link/text is missing;
2. deployed privacy-policy body is not independently verified against the post-AdMob data model;
3. exact merged release manifest / AD_ID state is not captured;
4. final release dependency inventory should be captured;
5. Play target-audience declaration remains unresolved;
6. final Play Data safety answers must be reconciled against the actual release artifact and current Play Console form.

## Next recommended action

Authorize a narrow W2 fix/verification bundle:

- add a persistent in-app `Privacy policy` link opening:
  `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`
- do not transmit photo content/metadata when opening it;
- have Codex capture merged release manifest, AD_ID permission state, and release dependency inventory;
- rerun build/test/lint;
- produce W2 artifact-bound evidence.

Do NOT change Play Console declarations yet.
Do NOT promote Play tracks.
Do NOT Artifact Freeze or release.


## W2 minimal compliance fix authorization — 2026-10-05

Human selection:
`USER_OPTION_1_2026-10-05_W2_MINIMAL_COMPLIANCE_FIX_ARTIFACT_AUDIT`

Authorized:
- add a persistent in-app Privacy policy link to the existing HTTPS URL;
- preserve explicit user action and send no photo content/metadata;
- generate artifact-bound merged release manifest / AD_ID / dependency evidence;
- rerun build/test/lint.

Not authorized:
- Play Console declaration mutation;
- target-audience provider submission;
- track promotion;
- Artifact Freeze;
- Android production release.

Implementation intent:
- persistent header control labeled `Privacy policy`;
- URL: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`;
- GitHub Actions uploads `w2-artifact-audit` containing merged release manifest, permission audit, release dependency inventory, and release APK hash when available.
