# S5 — PLAY CREATE-APP FLOW + PACKAGE STATUS CHECK v1.0

Approved: 2026-10-01
Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`

Approval ref:
`USER_OPTION_1_2026-10-01_S5_PLAY_CREATE_APP_FLOW_PACKAGE_STATUS_CHECK_ONLY`

## Authorized scope

The human authorizes only:

`S5 PLAY CREATE-APP FLOW + PACKAGE STATUS CHECK ONLY`

Permitted:
- open Google Play Console;
- enter the Create app flow;
- enter the canonical app name/package name when the UI requests them;
- select non-destructive form fields only as necessary to reveal package-name status;
- observe Play's package-name eligibility/registration result;
- capture a screenshot/report of that result.

Not authorized:
- final Create app submission if it creates/registers the app;
- manual package registration;
- ownership-proof submission;
- key creation/rotation/import;
- signing;
- upload;
- Play App Signing configuration changes;
- tester mutation;
- release creation;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

## Canonical identity

Play title:
`Photo Compressor: KB Limit`

Package:
`com.afradadmedia.reducephotosize`

Current version:
`0.1.0`

Current versionCode:
`1`

## Execution sequence

1. Open Play Console.
2. Open `All apps`.
3. Choose `Create app`.
4. If the page contains an App name field, enter:
   `Photo Compressor: KB Limit`
5. If the page contains a Package name field, enter:
   `com.afradadmedia.reducephotosize`
6. Observe the package-name status immediately.
7. STOP at the first package-status/ownership checkpoint.

If Play shows that the package can be registered automatically/new:
- capture the screen;
- do not submit Create app yet.

If Play says the package has been seen before or requires ownership proof/private-key proof:
- capture the screen;
- STOP;
- do not perform proof or key action.

If no package-name status appears until later form fields:
- fill only reversible/non-sensitive fields needed to reveal the status;
- do not accept irreversible terms or submit the final Create app action without separate approval.

## Terminal states

`PACKAGE_STATUS_NEW_OR_AUTO_REGISTERABLE_OBSERVED`

or

`PACKAGE_STATUS_OWNERSHIP_PROOF_REQUIRED_OBSERVED`

or

`PACKAGE_STATUS_UNKNOWN_UI_BLOCKER`

Then STOP and report to CHAT.
