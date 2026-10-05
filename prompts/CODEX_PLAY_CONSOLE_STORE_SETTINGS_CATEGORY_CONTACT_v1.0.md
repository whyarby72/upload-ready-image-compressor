# CODEX — PLAY CONSOLE STORE SETTINGS: CATEGORY + CONTACT v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Human authorization

Explicit scoped authorization:
`STORE_SETTINGS_CATEGORY_CONTACT_SAVE`

This authorization permits ONLY:
- setting Application type = `App`;
- setting Category = `Photography`;
- filling public store contact details from canonical published source-of-truth;
- clicking the ordinary non-submitting `Save` for this Store settings section;
- capturing evidence after Save.

This authorization does NOT permit:
- Send app for review;
- any release/track creation or promotion;
- Managed Publishing changes;
- store-listing copy/media edits;
- pricing/country changes;
- app-content declaration changes;
- Artifact Freeze;
- publication/release.

## Browser/context preflight

Use Codex Chrome extension with the operator-selected existing authenticated Chrome profile.

Before mutation:
1. verify active app = `Photo Compressor: KB Limit`;
2. verify package if visible = `com.afradadmedia.reducephotosize`;
3. verify current page is the Store settings/category/contact area;
4. if account/app context mismatches, STOP with `BLOCKED_WRONG_PROVIDER_CONTEXT`.

Never store or expose passwords, MFA secrets, cookies, session tokens, or recovery codes.

## Canonical values

Use these values:

- Application type: `App`
- Category: `Photography`
- Support email: `afradadmedia@gmail.com`
- Website:
  - preferred app-specific public page: `https://apps.afradadmedia.com/photo-compressor-kb-limit/`
  - before entering it, verify it opens successfully;
  - if that app-specific page is unavailable, use the canonical developer website `https://apps.afradadmedia.com/`
- Phone: leave blank unless a canonical public support phone number is already present in the provider form or a current canonical source; do not invent one.

Canonical source for support identity:
the published Photo Compressor privacy policy identifies Afradad Media as developer/publisher, uses `afradadmedia@gmail.com` for privacy/support contact, and `https://apps.afradadmedia.com/` as website.

## Execution

1. Navigate to the exact Store settings section that contains app category and contact details.
2. Record the pre-mutation visible values.
3. Apply only the authorized values above.
4. Do not touch unrelated fields.
5. Review the resulting form before persistence.
6. Click the ordinary `Save` only if it does not submit the app for review or trigger publication.
7. Re-open/re-check the saved section and verify durable provider state.
8. Capture evidence.

## Stop conditions

STOP without mutation or further mutation if:
- category `Photography` is unavailable;
- Save wording indicates submission/review/publication rather than ordinary persistence;
- provider UI schema differs materially from expected;
- support email/website field semantics are ambiguous;
- active app/account context changes;
- any unexpected required field appears.

## Required output

Return:

1. terminal disposition;
2. active app/package context verification;
3. exact pre-save values;
4. exact saved values;
5. durable-save verification result;
6. screenshots/evidence paths;
7. confirmation that Send app for review was NOT clicked;
8. confirmation that no release/publishing action occurred;
9. next ONE remaining setup blocker, not executed.

Allowed dispositions:
- `PASS_STORE_SETTINGS_CATEGORY_CONTACT_SAVED`
- `PARTIAL_STORE_SETTINGS_SAVE_UNVERIFIED`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_UI_SCHEMA_DRIFT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`

If repo workspace is available, create evidence-only file:
`evidence/play/W2_STORE_SETTINGS_CATEGORY_CONTACT_2026_10_05_v1.0.md`
and commit only that evidence file.
