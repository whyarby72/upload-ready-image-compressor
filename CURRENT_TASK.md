# CURRENT_TASK.md

Task ID: W2_TARGET_AUDIENCE_AND_PLAY_DECLARATION_ALIGNMENT
Owner: CHAT_AUDIT + HUMAN_PROVIDER_ACTION
Reviewer: CHAT
Stage: W2_POST_ADMOB_RECONCILIATION
Priority: HIGH
Status: PRIVACY_POLICY_BODY_PASS / TARGET_AUDIENCE_ALIGNMENT_OPEN

## S7

`CLOSED_WITH_DOCUMENTED_PROVIDER_RUNTIME_OBSERVABILITY_EXCEPTION`

## W2 source/artifact

`PASS`

Closed:
- in-app Privacy policy surface;
- merged release manifest;
- AD_ID state;
- release dependency inventory;
- deterministic build/test/lint;
- live Privacy Policy body for current AdMob/GMA/UMP data model.

## Final Privacy Policy evidence

Audit:
`docs/qa/W2_PRIVACY_POLICY_FINAL_RENDERED_BODY_AUDIT_2026_10_05_v1.0.md`

Website production source:
- repo: `whyarby72/apps-afradadmedia`;
- branch: `deploy/production`;
- content blob: `8b01bca9480d341b431ce02c78683e79d52069dd`.

Human browser capture verifies:
- Last updated October 5, 2026;
- affirmative AdMob/UMP wording;
- IP/approximate location;
- user product interactions;
- diagnostics;
- device/account identifiers;
- advertising/analytics/fraud-prevention purposes;
- TLS in transit;
- third-party Google retention boundary;
- developer/privacy contacts.

Disposition:
`PRIVACY_POLICY_BODY_PASS`

## Remaining W2 gates

1. final Play Target audience declaration;
2. final Play Data Safety provider-form reconciliation;
3. Play Ads declaration = YES for the first distributed ad-enabled artifact.

## Target-audience consistency constraint

Current policy statement:
`Photo Compressor: KB Limit is intended for an adult audience aged 18 and over.`

Therefore the current lowest-friction consistent Play declaration candidate is:
`18 and over only`

However, this must be a truthful product-positioning decision, not merely a mechanism to avoid Families requirements.

Do not submit a conflicting age group while the policy remains 18+.

## Next gate

`TARGET_AUDIENCE_DECISION`

Do NOT:
- submit Play declarations yet;
- promote Play tracks;
- Artifact Freeze;
- release/publish the Android app.


## Target audience decision intent — 2026-10-05

Human selection:
`USER_OPTION_1_2026-10-05_PROCEED_TARGET_AUDIENCE_18_PLUS_ONLY`

Current official Google Play baseline rechecked:
- Target audience must reflect the users the app is actually designed for.
- `18 and over` can be selected as the only target group for an adult-designed app.
- Restrict Minor Access is a separate optional control for adult-only apps unless a restricted-content policy specifically requires it.

Product-positioning evidence:
- current listing is a practical utility for strict upload limits, job applications, websites, portals, and email attachments;
- no child-directed characters, school-age positioning, or youth-specific feature set is present in the current listing;
- current live privacy policy already states the app is intended for an adult audience aged 18 and over.

Decision scope:
`PROCEED_TO_PLAY_TARGET_AUDIENCE_REVIEW_WITH_18_AND_OVER_ONLY_AS_CANDIDATE`

Important:
- do not Save/Submit yet;
- do not enable Restrict Minor Access merely to simplify compliance;
- review the actual Play screen first and verify that the declaration remains truthful for the current product positioning.

Next provider action:
open Play Console > Policy > App content > Target audience and content > Start/Manage, then return screenshot before Save.


## Play Ads declaration save — 2026-10-05

Human screenshot-observed state after Save:
- Play Console Publishing overview shows `Changes not yet submitted for review`;
- App content item: `Ads declaration`;
- description: `Update ads declaration`;
- `Send app for review` is disabled;
- Play Console states required app-dashboard steps remain incomplete.

Interpretation:
`ADS_DECLARATION_YES_SAVED_TO_PENDING_CHANGES`

This proves:
- Ads declaration was saved/staged;
- it has NOT been sent for review;
- it has NOT been published/released.

Next prerequisite from the prior Target audience screen:
`SIGN_IN_DETAILS`

After Sign in details is completed, return to Target audience and content and continue the 18+ review flow.

No Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Play Sign in details save — 2026-10-05

Human attestation:
- `Is any part of your app restricted?` = `No`;
- declaration was saved in Play Console.

Interpretation:
`SIGN_IN_DETAILS_NO_SAVED`

This is consistent with the current app architecture:
- no account/login requirement;
- no subscription/IAP/access tier;
- no referral/PIN/2-step verification;
- no biometric gate;
- no cross-device action requirement.

Evidence class:
`HUMAN_PROVIDER_ATTESTATION`

Next gate:
`TARGET_AUDIENCE_AND_CONTENT`

Proceed to the Target audience questionnaire and review `18 and over` only before saving/submitting.

No Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Play Target audience draft selection — 2026-10-05

Human screenshot-observed draft state:
- `18 and over` = selected;
- `13-15` = not selected;
- `16-17` = not selected;
- optional `Restrict users that Google has determined to be minors from my app` = not selected.

Interpretation:
`TARGET_AUDIENCE_18_PLUS_ONLY_DRAFT_SELECTED`

The optional minor-restriction control is not required merely because the target audience is 18+. Current product positioning is a general adult utility, not age-restricted/adult-content functionality.

Next action:
continue the questionnaire and inspect any remaining questions before Save.

No Save/Submit, Send for review, track promotion, Artifact Freeze, or Android production release is authorized by this draft selection.


## Play Target audience summary — 2026-10-05

Human screenshot-observed summary state:
- questionnaire reached step 5 `Summary`;
- Play Console summary states:
  `The target age group for your app is: 18 and over`;
- Save button is active;
- Play Console states that Save will stage the change in Publishing overview, ready to be sent for review later.

Interpretation:
`TARGET_AUDIENCE_18_PLUS_ONLY_READY_TO_SAVE`

This is consistent with:
- current live privacy policy: adult audience aged 18 and over;
- current product positioning;
- no child-directed content/features;
- optional minor-restriction control left off.

No Save has been authorized by this observation alone.

Next gate:
`EXPLICIT_SAVE_TARGET_AUDIENCE_18_PLUS_ONLY_APPROVAL`

No Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Play Target audience save — 2026-10-05

Human screenshot-observed state after Save:
- Publishing overview shows `Target audience and content` under `Changes not yet submitted for review`;
- description states target age is `18 and older`;
- Ads declaration is also staged under App content;
- Sign in details is summarized as all functionality available without special access;
- `Send app for review` remains disabled because required dashboard setup steps are still incomplete.

Interpretation:
`TARGET_AUDIENCE_18_PLUS_ONLY_SAVED_TO_PENDING_CHANGES`

This proves:
- the 18+ declaration was saved/staged;
- it has NOT been sent for review;
- it has NOT been published/released.

Next recommended gate:
`PLAY_DATA_SAFETY_FORM_RECONCILIATION`

Use the existing W2 artifact-bound candidate:
- Approximate location;
- App activity / App interactions;
- App info and performance / Diagnostics;
- Device or other IDs;
all as collected/shared candidates for the AdMob-enabled artifact, with purposes Advertising or marketing, Analytics, and Fraud prevention/security/compliance, subject to actual current Play form wording.

Do not Send for review, promote tracks, Artifact Freeze, or release.


## Play Data safety entry screen — 2026-10-05

Human screenshot-observed state:
- Data safety questionnaire opened successfully;
- current step: `1 Overview`;
- remaining steps visible:
  - `2 Data collection and security`;
  - `3 Data types`;
  - `4 Data usage and handling`;
  - `5 Preview`;
- `Next` is available;
- no Data Safety answers have been saved from this screen.

Interpretation:
`DATA_SAFETY_QUESTIONNAIRE_READY`

Next action:
advance to `Data collection and security`, then review the exact current Play wording before selecting any answer.

No Save draft, provider submission, Send for review, track promotion, Artifact Freeze, or Android production release is authorized from this overview screen.


## Play Data safety — collection/security screen observed — 2026-10-05

Human screenshot-observed current questionnaire state:
- `Does your app collect or share any required user data types?` = `Yes` selected;
- next question visible: `Is all of the user data collected by your app encrypted in transit?`;
- account-creation methods visible, including `My app does not allow users to create an account`;
- a lower `No` radio is visible without its full question label in the provided capture.

Artifact/SDK evidence supports:
- encryption-in-transit answer candidate: `Yes`, because current GMA Next-Gen disclosure states SDK-collected data is encrypted in transit using TLS;
- account-creation method candidate: `My app does not allow users to create an account`, consistent with source/product behavior and the previously saved Sign in details = No.

Do not answer the lower unlabeled `No` until its question text is visible.

No Save draft, provider submission, Send for review, track promotion, Artifact Freeze, or Android production release is authorized by this observation.


## Play Data safety — account/deletion follow-up observed — 2026-10-05

Human screenshot-observed state:
- `My app does not allow users to create an account` = selected;
- question visible: `Can users login to your app with accounts created outside of the app?`;
- deletion question visible: `Do you provide a way for users to request that their data is deleted? (Optional)`;
- deletion answer choices visible:
  - Yes;
  - No;
  - No, but user data is automatically deleted within 90 days;
- another lower standalone `No` radio is visible without its question label.

Recommended answers supported by current evidence:
- external-account login: `No`;
- deletion request mechanism: `No` unless a clearly discoverable deletion-request mechanism is intentionally established.

Do NOT select:
- `No, but user data is automatically deleted within 90 days`, because current evidence does not establish that all Google Mobile Ads / UMP data is automatically deleted or anonymized within 90 days.

Do not answer the lower unlabeled `No` until its question text is visible.

No Save draft, provider submission, Send for review, track promotion, Artifact Freeze, or Android production release is authorized by this observation.


## Play Data Safety — data types saved / usage handling reached — 2026-10-05

Human screenshot evidence:
- Step 3 Data types was saved.
- Questionnaire advanced to Step 4 Data usage and handling.
- Selected types shown in the form include:
  - Approximate location;
  - App interactions;
  - Diagnostics;
  - Device or other IDs.
- Approximate location is currently Not started.

Next handling profile for each of the four selected types, subject to exact current Play wording:
- Collected: Yes;
- Shared: Yes;
- Ephemeral processing: No;
- Collection optional: No / required;
- Purposes: Advertising or marketing; Analytics; Fraud prevention, security and compliance.

No final Data Safety Save/Submit or Send for review is authorized yet.


## Play Data Safety — Approximate location handling screen — 2026-10-05

Human screenshot-observed wording:
`Is this data collected, shared, or both?`

Available choices:
- `Collected`
- `Shared`

Artifact/SDK-backed answer for Approximate location:
- `Collected` = selected;
- `Shared` = selected.

Basis:
the ad-enabled release uses Google Mobile Ads; current GMA disclosure states IP address may be used to estimate general location and is automatically collected/shared for advertising, analytics, and fraud-prevention purposes.

Next action:
select both checkboxes, then inspect the follow-up questions before saving this data type.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Approximate location follow-up — 2026-10-05

Human screenshot-observed current questions:
- ephemeral processing;
- required vs optional collection;
- collection purposes.

Artifact/official-doc answer profile for `Approximate location`:
- processed ephemerally: `No`;
- collection: `Required` (users cannot universally turn off collection across all regions/devices);
- purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

Do not select:
- App functionality;
- Developer communications;
- Personalization;
- Account management.

Basis:
- GMA Next-Gen automatically collects/shares IP address, which may estimate general location;
- Google states the automatic purposes are advertising, analytics, and fraud prevention;
- Play says optional collection may be declared only when all users can choose whether collection occurs;
- Play says data used to build advertising/user profiles is not ephemeral.

Next action:
apply this profile to Approximate location, then inspect/save the data-type dialog before proceeding to the remaining three types.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Approximate location shared-purpose screen — 2026-10-05

Human screenshot-observed question:
`Why is this user data shared? Select all that apply.`

Current official GMA Next-Gen disclosure states automatically collected/shared data is used for:
- advertising;
- analytics;
- fraud prevention.

Therefore for `Approximate location` shared purposes select exactly:
- `Analytics`;
- `Advertising or marketing`;
- `Fraud prevention, security, and compliance`.

Do not select:
- App functionality;
- Developer communications;
- Personalization;
- Account management.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Approximate location completed — 2026-10-05

Human screenshot-observed state:
- `Approximate location` status = `Completed`;
- `App info and performance` = `0 of 1 completed`;
- `App activity` = `0 of 1 completed`;
- `Device or other IDs` = `0 of 1 completed`;
- Play Console confirms changes have been saved.

Interpretation:
`APPROXIMATE_LOCATION_HANDLING_COMPLETE`

Next data type:
`App info and performance > Diagnostics`

Expected handling profile subject to exact current Play wording:
- Collected = Yes;
- Shared = Yes;
- Ephemeral = No;
- Required = Yes;
- purposes = Analytics; Advertising or marketing; Fraud prevention, security and compliance.

No final Data Safety submission or Send for review is authorized.
