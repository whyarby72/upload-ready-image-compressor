# S7 European regulations message editor screen — 2026-10-04

Product: PHOTO COMPRESSOR: KB LIMIT
Scope: S7 BOUNDED ADMOB PROVIDER SETUP

Authenticated AdMob UI shows the European regulations message editor.

Observed:
- Message title: Untitled European regulations message
- Default language: English (en)
- No app selected yet; "Select apps" is visible
- User choices:
  - Consent: On
  - Manage options: On
  - Do not consent: not yet selected
  - Close (do not consent): Off
- Publish control is visible but currently outside the approved execution boundary.

Recommended draft configuration:
- Select only Photo Compressor: KB Limit
- Rename message to: Photo Compressor EU Consent v1
- Keep Consent: On
- Keep Manage options: On
- Enable Do not consent to create the three-choice structure
- Keep Close (do not consent): Off
- Keep English as default language for this initial controlled test
- Do not publish yet
- Review Targeting before final publication; production intent is countries subject to GDPR (EEA, UK, Switzerland), not Everywhere, unless separately approved.

Rationale:
Google documents the three-choice structure as Consent / Do not consent / Manage options. The close button is optional and is unnecessary when an explicit Do not consent control is enabled.
