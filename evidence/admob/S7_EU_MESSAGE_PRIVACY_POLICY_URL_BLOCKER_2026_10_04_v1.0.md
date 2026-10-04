# S7 EU message privacy-policy URL blocker — 2026-10-04

Product: PHOTO COMPRESSOR: KB LIMIT
Scope: S7 BOUNDED ADMOB PROVIDER SETUP

Authenticated AdMob UI evidence shows the Select your apps dialog.

Observed:
- Photo Compressor: KB Limit is selected.
- Platform: Android.
- Privacy policy URL is missing; UI offers "Add URL".
- Provider warning: "You need to add a privacy policy URL before publishing the message."
- Fallback consent collection is OFF.

Disposition:
`BLOCKED_PRIVACY_POLICY_URL_REQUIRED_FOR_MESSAGE_PUBLICATION`

The app can remain selected for draft configuration, but final message publication must not proceed until a real public privacy-policy URL is available and reviewed.

Do not invent or use a placeholder URL.
Do not enable fallback consent collection under this scope.

Next:
continue draft configuration if the UI permits without publication; otherwise stop and create/bind a real public privacy-policy surface under a separate approved task.
