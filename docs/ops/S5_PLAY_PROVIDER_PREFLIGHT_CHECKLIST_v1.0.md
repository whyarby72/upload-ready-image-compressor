# S5 — PLAY CONSOLE PROVIDER PREFLIGHT CHECKLIST v1.0

Observed/prepared: 2026-10-01
Product: REDUCE PHOTO SIZE: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Stage: `S5_INTERNAL_TEST_READY_PROVIDER_ACTION_PENDING`

Status:
`READ_ONLY_PROVIDER_PREFLIGHT_REQUIRED_BEFORE_SIGNING APPROVAL`

## Purpose

Collect provider-bound facts from the intended authorized Google Play Console account before any signing, app creation, AAB upload, tester mutation, or rollout.

This checklist is read-only. Do not mutate provider state while completing it.

## Canonical unsigned candidate

Source:
`27199bf6f174e55dc835d0d9898e456d3848001c`

Artifact:
`evidence/artifacts/s5_current_play_candidate/app-release-0.1.0-vc1-unsigned.aab`

Bytes:
`7,968,406`

SHA-256:
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`

Signing:
`UNSIGNED`

Play upload eligible:
`FALSE`

## Provider preflight observations required

1. Account authorization
   - Confirm the intended Play Console developer account.
   - Confirm the person using it is legitimately authorized.
   - Confirm the account has permission to release apps to testing tracks.
   - Do not bypass identity, age, organization, payment, tax, or account requirements.

2. App/package existence
   - Search/select the intended app if it already exists.
   - Report whether `com.afradadmedia.reducephotosize` already exists in this account.
   - If it exists, report the visible app title and package.
   - If it does not exist, report only `NOT_CREATED`; do not create it yet.

3. Android developer verification / package registration
   - Check current developer-verification status in Play Console.
   - Confirm whether the package is already registered/eligible for registration under the account.
   - Do not initiate an identity/package-registration workaround.

4. Account type/date
   - Report whether the developer account is Personal or Organization when visible.
   - If Personal, report whether it was created before or after 2023-11-13 if Play Console exposes enough information to determine this.
   - Do not guess if unavailable.

5. Play App Signing
   - Report whether Play App Signing is already configured for this app.
   - If the app does not exist yet, report `NOT_CONFIGURED_APP_NOT_CREATED`.
   - Do not enroll, accept terms, or create a signing setup yet unless separately authorized.

6. Upload key
   - Report whether an authorized existing upload key is available for this app/account workflow.
   - If a non-secret upload certificate SHA-256 fingerprint is visible, record it.
   - Never copy keystore files, private keys, passwords, recovery codes, or secret credentials into Git/chat.
   - Do not create or rotate a key yet.

7. versionCode availability
   - Current candidate uses versionCode `1`, versionName `0.1.0`.
   - Report whether versionCode 1 appears unused/available for the intended app.
   - If app does not exist yet, report `N/A_NEW_APP_PREUPLOAD`.
   - Do not upload an artifact to test availability.

8. Internal testing route
   - Confirm the Internal testing page/track is accessible.
   - Report whether an existing internal track/release already exists.
   - Do not create a release yet.
   - Do not add/remove testers yet.

9. Tester setup
   - Report intended tester count.
   - Report whether you will use an email list or another supported tester-group mechanism.
   - Do not send raw tester email addresses to Git/chat.

10. Feedback channel
    - Report intended feedback email or URL category, e.g. `EMAIL_READY`, `URL_READY`, or `NOT_DECIDED`.
    - Do not put private contact details in repository evidence unless intentionally public.

11. Provider warnings/blockers
    - Report any visible Play Console warnings or blockers relevant to:
      - account verification;
      - package registration;
      - testing access;
      - app signing;
      - versioning;
      - policy;
      - developer account eligibility.
    - Copy exact warning text when practical, but redact personal/account-sensitive information.

## Current official-platform facts used for this preflight

- Internal testing can be used before an app is fully configured and supports a limited trusted tester group.
- Package name becomes fixed for an app after artifact upload.
- Each new update must use a higher versionCode than prior uploaded versions.
- New mobile submissions currently need target API 36 or higher; this project targets 36.
- Personal developer accounts created after 2023-11-13 have a separate later production-access closed-test requirement.
- Effective 2026-09-30, Play package-name registration is part of Android developer verification requirements.

## Response template

Return only provider observations:

```
PLAY_PROVIDER_PREFLIGHT
account_authorized: YES / NO / UNKNOWN
release_to_testing_permission: YES / NO / UNKNOWN
app_exists_in_account: YES / NO
visible_app_title: <title / N_A>
visible_package: <package / N_A>
developer_verification_status: VERIFIED / ACTION_REQUIRED / UNKNOWN
package_registration_status: REGISTERED / AUTO_REGISTERED / ACTION_REQUIRED / UNKNOWN / N_A
account_type: PERSONAL / ORGANIZATION / UNKNOWN
account_created_after_2023_11_13: YES / NO / UNKNOWN / N_A
play_app_signing: CONFIGURED / NOT_CONFIGURED_APP_NOT_CREATED / ACTION_REQUIRED / UNKNOWN
authorized_upload_key_available: YES / NO / UNKNOWN
upload_certificate_sha256: <fingerprint / NOT_VISIBLE / N_A>
version_code_1_status: AVAILABLE / USED / N_A_NEW_APP_PREUPLOAD / UNKNOWN
internal_testing_accessible: YES / NO / UNKNOWN
existing_internal_release: YES / NO / UNKNOWN
intended_tester_count: <number / UNKNOWN>
tester_group_mode: EMAIL_LIST / OTHER / UNKNOWN
feedback_channel: EMAIL_READY / URL_READY / NOT_DECIDED
provider_warnings: <exact non-sensitive text / NONE>
```

## Hard stop

After collecting the observations:
STOP.

Do not:
- create an app;
- accept/change signing configuration;
- create/rotate keys;
- sign;
- upload;
- modify testers;
- create or roll out a release;
- advance S6;
- promote BUILD;
- Artifact Freeze;
- release;
- publish.
