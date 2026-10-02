# S5 CREATE APP DECLARATIONS AUDIT — 2026-10-02 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Scope: Google Play Create app declarations only

## Sources audited

Repository:
- `app/src/main/AndroidManifest.xml`
- `app/build.gradle`
- all main Java/Kotlin source files under `app/src/main/java/`
- `PRODUCT_SPEC.md`
- `store/PLAY_LISTING.md`
- `store/PRIVACY_NOTES.md`

Current external requirements checked against official Google Play policy and U.S. Bureau of Industry and Security guidance on 2026-10-02.

## A. Developer Program Policies

### Evidence PASS

- targetSdk = 36, matching the current Google Play requirement for new phone apps after 2026-08-31;
- no declared runtime permissions in the current manifest;
- no `INTERNET` permission;
- no location, contacts, camera, microphone, broad media/storage, phone, SMS, Bluetooth, or other sensitive permission declared;
- no AdMob, analytics, Firebase, networking, WebView, remote-code, or advertising SDK dependency in the current app module;
- source scan found no network/crypto/analytics/advertising implementation;
- app workflow is local/on-device;
- Share is explicit/user initiated;
- Play listing claims align with implemented scope and do not claim guaranteed portal acceptance;
- source and metadata audits show no material deceptive-behavior, malware, device-abuse, or sensitive-permission conflict.

### Publication compliance debt

Current source tree does not contain an in-app privacy-policy surface/link.
No public privacy-policy URL or completed Play Data safety declaration is bound yet.

Current Google Play policy requires privacy-policy and Data safety compliance before distribution/publication.

These are therefore mandatory pre-upload/pre-publication controls, but they do not require blocking creation of the Play app entry itself because the app entry must exist before the Play Console listing/data-safety configuration can be completed.

### Disposition

`PASS_FOR_CREATE_APP_DECLARATION_SCOPE / PUBLICATION_COMPLIANCE_DEBT_OPEN`

This is not a release/publication PASS.

## B. US export laws

### Repository evidence

- no custom cryptography implementation found in app source;
- no explicit crypto/security dependency in `app/build.gradle`;
- no network implementation or `INTERNET` permission;
- product function is local JPEG/JPG inspection/compression/save/share.

### Interpretation

No app-specific encryption-function blocker is evidenced by the repository.

BIS guidance states encryption software can be subject to separate classification/reporting rules depending on its cryptographic functionality and export status. Those encryption-specific paths are not evidenced by this app's current implementation.

### Disposition

`TECHNICAL_SCOPE_PASS_NO_APP_CRYPTO_FOUND / HUMAN_LEGAL_ATTESTATION_REQUIRED`

The Play Console checkbox is a legal certification by the developer/account holder. CHAT does not make that certification on the human's behalf.

## Gate

Create-app declaration technical audit:
`PASS_WITH_HUMAN_ATTESTATION`

Publication/release compliance:
`HOLD_PRIVACY_POLICY_AND_DATA_SAFETY_PENDING`

No signing, upload, tester mutation, release, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this audit.
