# CODEX — PLAY CONSOLE BROWSER CONTINUATION v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`
Prepared from HEAD: `d68c8f3df8c5023af5a2940ab2502d5969087fda`

## Operator authorization

Human selected the workflow:
`MOVE_NOW_TO_CODEX_BROWSER_COMPUTER_USE_AND_CONTINUE_PLAY_CONSOLE_DECLARATIONS`

This authorizes Codex Browser/Computer Use to:
- continue filling remaining Google Play Console App content declarations;
- use the already-authenticated Play Console session;
- save non-submitting draft/declaration changes into Publishing overview when the answer is directly supported by current evidence;
- capture browser evidence;
- create an evidence-only repo commit if the repo workspace is available.

This does NOT authorize:
- `Send app for review`;
- production rollout;
- track promotion;
- Managed Publishing changes;
- Artifact Freeze;
- Android app publication/release;
- creating or changing AdMob apps/ad units;
- source feature changes.

If any control would submit for review, publish, roll out, or make an irreversible material provider action, STOP before clicking it.

## Authentication boundary

- Never ask for or store the user's Google password, MFA secret, recovery codes, or other credentials.
- If login/MFA is required, hand control to the human.
- Continue only after the user has completed authentication.

## Current confirmed Play Console state

Already completed/staged in Publishing overview:

1. Ads declaration:
   `YES — app contains ads`.

2. Sign in details:
   `No restricted app access`.
   The app does not require account/login.

3. Target audience and content:
   `18 and over only`.
   Optional minor-restriction control left OFF.

4. Privacy policy:
   `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

5. Data Safety:
   - collects/shares required data = YES;
   - encrypted in transit = YES;
   - no account creation;
   - no external account login;
   - no developer-provided deletion request mechanism;
   - selected data types:
     - Approximate location;
     - App interactions;
     - Diagnostics;
     - Device or other IDs;
   - each selected type:
     - Collected = YES;
     - Shared = YES;
     - Ephemeral = NO;
     - Required = YES;
     - Collected purposes:
       - Analytics;
       - Advertising or marketing;
       - Fraud prevention, security and compliance;
     - Shared purposes:
       - Analytics;
       - Advertising or marketing;
       - Fraud prevention, security and compliance.

These were reconciled against the current GMA Next-Gen SDK disclosure and the release artifact.

## Current browser position

Google Play Console > Content ratings.

Category:
`All Other App Types`

Current step:
`2 Questionnaire`

First visible question:
`Downloaded App — Does the app contain any ratings-relevant content (e.g., sex, violence, language) downloaded as part of the app package (code, assets)?`

Directly supported answer:
`No`

Reason:
the packaged app is a photo-compression utility and does not intentionally include ratings-relevant sexual, violent, or strong-language content in its own code/assets.

## Content Rating execution rules

1. Select `Downloaded App = No`.

2. Continue through:
   - User Content Sharing;
   - Online Content;
   - Promotion or Sale of Age-Restricted Products or Activities;
   - Miscellaneous;
   - any additional IARC questions shown.

3. For every question:
   - use the actual on-screen wording;
   - inspect `Learn more` / definitions when needed;
   - answer only when the current app source, listing, privacy policy, or provider state directly supports the answer;
   - do not infer an answer merely because it seems low-risk.

4. Important semantic distinctions:
   - Android user-initiated Share of an output JPEG to another app is not automatically the same thing as an in-app public UGC/community system; use the IARC definition shown in Play Console before answering any `User Content Sharing` question.
   - AdMob banner/network access may affect `Online Content` questions depending on the exact IARC wording; inspect the definition before answering.
   - The app does not sell/promote alcohol, gambling, tobacco/nicotine, controlled substances, sexual services/products, weapons, or other age-restricted commerce.
   - The app has no social network, chat, public posting, user account system, financial service, health service, news service, or game/betting functionality.

5. If a question is materially ambiguous:
   STOP on that question.
   Return:
   - exact question text;
   - all available answer options;
   - screenshot;
   - why evidence is insufficient.
   Do not guess.

6. If the questionnaire reaches Summary:
   - review every generated rating/result;
   - capture the Summary;
   - STOP before any control that explicitly submits to IARC / finalizes a material provider rating if the UI distinguishes that from a normal non-submitting Save.
   - If the only action is a standard Save that stages the result in Publishing overview without `Send app for review`, Save is permitted under this scoped authorization.

## Remaining App content sweep

After Content ratings is safely staged, return to:
`Policy and programs > App content`

Enumerate remaining incomplete sections.

For clearly supported non-regulated declarations, Codex may fill and save them to Publishing overview.

Current product facts that can be used when exact wording matches:
- not a government/official-government app;
- no financial products/services/features;
- no health/medical functionality;
- not a news app;
- no gambling/betting;
- no age-restricted product sales;
- no user account/login;
- no subscriptions/IAP/access tiers;
- no public UGC/community/chat;
- core job is local JPEG compression;
- ad-enabled build has one AdMob banner;
- privacy policy and Data Safety are already staged.

For any regulated, identity-sensitive, or ambiguous declaration:
STOP and request human review rather than guessing.

## Evidence / completion report

At the end, return:

1. terminal/browser disposition;
2. exact Play Console sections completed;
3. exact answers saved for each section;
4. sections still incomplete;
5. any ambiguity/blocker;
6. confirmation that `Send app for review` was NOT clicked;
7. confirmation that no release/track/publishing action occurred;
8. screenshots or screenshot paths for each completed provider page;
9. if repo workspace is available:
   create
   `evidence/play/W2_PLAY_CONSOLE_BROWSER_CONTINUATION_RESULT_2026_10_05_v1.0.md`
   and commit evidence only.

Allowed terminal dispositions:
- `PASS_PLAY_CONSOLE_BROWSER_DRAFT_COMPLETION`
- `PARTIAL_PLAY_CONSOLE_BROWSER_AMBIGUOUS_DECLARATION`
- `BLOCKED_PLAY_CONSOLE_BROWSER_AUTH_REQUIRED`
- `BLOCKED_PLAY_CONSOLE_BROWSER_UI_OR_PROVIDER_ERROR`

Do not go beyond the scoped draft/declaration work above.
