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


## Play Data Safety — Diagnostics handling screen — 2026-10-05

Human screenshot-observed question:
`Diagnostics — Is this data collected, shared, or both?`

Artifact/official-doc answer:
- `Collected` = selected;
- `Shared` = selected.

Expected follow-up profile:
- processed ephemerally: `No`;
- collection: `Required`;
- purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

Basis:
current GMA Next-Gen disclosure states diagnostic information is automatically collected/shared for advertising, analytics, and fraud-prevention purposes.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Diagnostics follow-up screen — 2026-10-05

Human screenshot-observed current questions for `Diagnostics`:
- ephemeral processing;
- required vs optional collection;
- collection purposes.

Use the same artifact/official-doc profile as Approximate location:
- processed ephemerally: `No`;
- collection: `Required`;
- collected purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

When the shared-purpose section appears, use the same three shared purposes.

Do not select:
- App functionality;
- Developer communications;
- Personalization;
- Account management.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Diagnostics shared-purpose screen — 2026-10-05

Human screenshot-observed question:
`Why is this user data shared? Select all that apply.`

For `Diagnostics`, select exactly:
- `Analytics`;
- `Advertising or marketing`;
- `Fraud prevention, security, and compliance`.

Do not select:
- App functionality;
- Developer communications;
- Personalization;
- Account management.

This matches the current GMA Next-Gen disclosure for diagnostic data.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — App interactions handling screen — 2026-10-05

Human screenshot-observed question:
`App interactions — Is this data collected, shared, or both?`

Artifact/official-doc answer:
- `Collected` = selected;
- `Shared` = selected.

Expected follow-up profile:
- processed ephemerally: `No`;
- collection: `Required`;
- purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

Basis:
current GMA Next-Gen disclosure states user product interactions are automatically collected/shared for advertising, analytics, and fraud-prevention purposes.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — App interactions follow-up and shared-purpose screens — 2026-10-05

Human screenshots show the same handling fields as prior types:
- ephemeral processing;
- required vs optional collection;
- collected purposes;
- shared purposes.

For `App interactions`, use:
- processed ephemerally: `No`;
- collection: `Required`;
- collected purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`;
- shared purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

Do not select:
- App functionality;
- Developer communications;
- Personalization;
- Account management.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Device or other IDs handling screen — 2026-10-05

Human screenshot-observed question:
`Device or other IDs — Is this data collected, shared, or both?`

Current official GMA Next-Gen disclosure states Device and Account identifiers are automatically collected and shared, including Android advertising ID, app set ID, and, where applicable, other identifiers related to signed-in accounts.

Answer:
- `Collected` = selected;
- `Shared` = selected.

Expected follow-up profile, subject to the exact Play wording shown next:
- processed ephemerally: `No`;
- collection: `Required` for the current distributed configuration because the SDK automatically collects identifier data and the app does not provide a universal all-user opt-out;
- purposes:
  - `Analytics`;
  - `Advertising or marketing`;
  - `Fraud prevention, security and compliance`.

Caveat:
Google notes Android advertising ID collection itself can be prevented by manifest/configuration and users can reset/delete the ad ID. The Data Safety answer must still reflect the sum of identifier collection actually performed by the current app/SDK configuration, including app set ID and other applicable identifiers.

No final Data Safety submission or Send for review is authorized.


## Play Data Safety — Preview audit — 2026-10-05

Human-provided Preview capture shows:

PASS:
- Approximate location shared purposes = Analytics; Fraud prevention, security, and compliance; Advertising or marketing.
- Diagnostics shared/collected purposes = Analytics; Fraud prevention, security, and compliance; Advertising or marketing.
- App interactions shared/collected purposes = Analytics; Fraud prevention, security, and compliance; Advertising or marketing.
- Device or other IDs shared/collected purposes = Analytics; Fraud prevention, security, and compliance; Advertising or marketing.
- Data deletion summary = Developer hasn't provided a way to request data deletion.
- Security practices = Data is encrypted in transit.

BLOCKER 1 — Approximate location collected-purpose mismatch:
Preview shows Approximate location collected purposes including:
- Analytics;
- Advertising or marketing;
- Personalization;
- Account management.

This is inconsistent with the intended/official GMA mapping. Expected collected purposes:
- Analytics;
- Advertising or marketing;
- Fraud prevention, security, and compliance.

Required correction:
remove Personalization and Account management; add Fraud prevention, security, and compliance.

BLOCKER 2 — Play Privacy policy field missing:
Preview shows:
`To submit, provide a link to your privacy policy on the Privacy policy page`

Required provider action:
set Play Console Privacy policy URL to:
`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Do not submit Data Safety / Send for review until both blockers are corrected and Preview is rechecked.


## Play Data Safety — Approximate location shared-purpose correction verified — 2026-10-05

Human screenshot-observed state for `Approximate location > Why is this user data shared?`:
- Analytics = selected;
- Advertising or marketing = selected;
- Fraud prevention, security, and compliance = selected;
- App functionality = not selected;
- Developer communications = not selected;
- Personalization = not selected;
- Account management = not selected.

Disposition:
`APPROXIMATE_LOCATION_SHARED_PURPOSES = PASS`

Still not independently re-verified from this screenshot:
`Approximate location > Why is this user data collected?`

Required collected purposes remain:
- Analytics;
- Advertising or marketing;
- Fraud prevention, security, and compliance.

Do not treat Approximate location as fully reconciled until the collected-purpose section is visibly confirmed with only those three purposes selected.


## Play Data Safety — final Preview reconciliation — 2026-10-05

Human-provided 2-page Preview capture shows the corrected declaration state.

PASS — Data shared:
- Approximate location:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- Diagnostics:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- App interactions:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- Device or other IDs:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.

PASS — Data collected:
- Approximate location:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- Diagnostics:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- App interactions:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.
- Device or other IDs:
  - Analytics;
  - Fraud prevention, security and compliance;
  - Advertising or marketing.

PASS — Other Preview sections:
- Data deletion: developer hasn't provided a way to request data deletion.
- Security practices: data is encrypted in transit.
- Privacy policy URL is present:
  `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

Disposition:
`DATA_SAFETY_PREVIEW_RECONCILED_PASS`

The previous two blockers are closed:
1. Approximate location collected-purpose mismatch corrected.
2. Play Privacy policy URL field populated.

Next gate:
`EXPLICIT_SAVE_DATA_SAFETY_DECLARATION_APPROVAL`

Save scope, if approved:
- save the current Data Safety declaration to Publishing overview only;
- do NOT Send for review;
- do NOT promote tracks;
- do NOT Artifact Freeze;
- do NOT release/publish the Android app.


## Play Data Safety save — 2026-10-05

Human screenshot-observed Publishing overview state:
- `Data safety` appears under `Changes not yet submitted for review`;
- description: `Complete Data safety questionnaire`;
- `Privacy policy` is staged with URL:
  `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`;
- `Target audience and content` is staged with target age 18 and older;
- `Ads declaration` is staged;
- `Send app for review` remains disabled because required dashboard setup steps are still incomplete.

Interpretation:
`DATA_SAFETY_SAVED_TO_PENDING_CHANGES`

This proves:
- Data Safety is saved/staged in Publishing overview;
- Privacy policy URL is saved/staged;
- neither has been sent for review;
- nothing has been published/released.

Next recommended gate:
`CONTENT_RATING`

No Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Play Content ratings — Category screen — 2026-10-05

Human screenshot-observed state:
- step 1 `Category`;
- required email field is empty;
- category choices:
  - Game;
  - Social or Communication;
  - All Other App Types;
- IARC Terms of Use checkbox is available;
- Next is currently disabled.

Recommended profile for Photo Compressor: KB Limit:
- Email address: use an actively monitored developer/support email that can receive rating-related notices and is consistent with the app's published support identity.
- Category: `All Other App Types`.
- Terms: check `I agree to the Terms of Use ... IARC` only if the human operator accepts those terms.

Rationale:
the app is a utility/photo-compression tool, not a game, betting app, social network, or communication app.

Next gate:
complete Category inputs, then inspect the IARC questionnaire before answering content questions.

No final rating submission, Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Play Content ratings — Questionnaire entry — 2026-10-05

Human screenshot-observed state:
- Category = `All Other App Types`;
- questionnaire step 2 opened;
- first visible question under `Downloaded App`:
  `Does the app contain any ratings-relevant content (e.g., sex, violence, language) downloaded as part of the app package (code, assets)?`

Artifact/source-backed answer for the current app:
- `Downloaded App` = `No`.

Basis:
the app package is a photo-compression utility and does not intentionally include ratings-relevant sexual, violent, or strong-language content in its own packaged code/assets.

The remaining sections visible but not yet expanded are:
- User Content Sharing;
- Online Content;
- Promotion or Sale of Age-Restricted Products or Activities;
- Miscellaneous.

Next gate:
answer `Downloaded App = No`, then expand the next section and inspect its exact wording before continuing.

No final IARC rating submission, Send for review, track promotion, Artifact Freeze, or Android production release is authorized.


## Codex Browser/Computer Use handoff — 2026-10-05

Human selection:
`USER_OPTION_2_2026-10-05_MOVE_NOW_TO_CODEX_BROWSER_COMPUTER_USE`

Prompt:
`prompts/CODEX_PLAY_CONSOLE_BROWSER_CONTINUATION_v1.0.md`

Authorized scope:
- continue Play Console Content Rating and remaining App content declarations using Browser/Computer Use;
- save non-submitting declaration/draft changes to Publishing overview when directly evidence-supported;
- stop on ambiguity;
- evidence-only repo commit permitted.

Explicitly NOT authorized:
- Send app for review;
- production rollout;
- track promotion;
- Managed Publishing changes;
- Artifact Freeze;
- Android app publication/release.

Current Content Rating state:
- Category = `All Other App Types`;
- Step 2 Questionnaire;
- first directly supported answer:
  `Downloaded App = No`.

Next operator action:
open Codex Desktop with Browser/Computer Use in the authenticated Play Console session and run the prompt above.


## Codex Chrome-profile binding revision — 2026-10-05

Human authorization:
`USER_OPTION_1_2026-10-05_REQUIRE_EXISTING_CHROME_PROFILE`

Supersedes for execution:
`prompts/CODEX_PLAY_CONSOLE_BROWSER_CONTINUATION_v1.0.md`

New active handoff:
`prompts/CODEX_PLAY_CONSOLE_CHROME_PROFILE_CONTINUATION_v1.1.md`

Execution binding:
- use Codex Chrome extension;
- use the operator-selected existing Chrome profile that is already authenticated to the authorized Google Play Console account;
- do NOT use ChatGPT built-in browser for this task;
- do NOT persist or commit the Google account email address;
- verify active Play Console app = `Photo Compressor: KB Limit` before mutation;
- if account/app mismatch is visible, STOP for human intervention.

Authority remains unchanged:
- draft/declaration filling and non-submitting Save are allowed when evidence-backed;
- `Send app for review`, release, rollout, track promotion, Managed Publishing changes, Artifact Freeze, and publication remain forbidden without new explicit approval.
