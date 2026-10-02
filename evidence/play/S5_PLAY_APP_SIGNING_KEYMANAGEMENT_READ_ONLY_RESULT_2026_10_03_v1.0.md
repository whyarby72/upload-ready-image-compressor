# S5 PLAY APP SIGNING KEY-MANAGEMENT READ-ONLY RESULT — 2026-10-03

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Provider app id: `4973120481844433940`

User-supplied Google Play Console evidence:
- page: `Protected with Play > App signing`;
- PDF SHA-256: `7fe1c913adedf1948c0bac8946a8a14a987cd61265a219233e231c118383e1bb`;
- PDF bytes: `1262042`.

## Direct provider facts

Visible on the App signing page:
- `App signing key` status: `In use`;
- current install base: `0.0%`;
- controls include `Change key` and `Download certificates`;
- `Upload key certificate` section states:
  `Certificate fingerprints will be shown here after you upload your first app bundle`;
- Digital Asset Links JSON is generated for:
  `com.afradadmedia.reducephotosize`;
- SHA-256 app-signing certificate fingerprint visible in the Digital Asset Links JSON:
  `56:39:62:12:1D:E2:14:C3:C7:53:41:CB:54:8B:A2:C0:71:D7:16:25:F0:5A:34:77:98:21:5B:38:0F:00:9B:47`.

## Interpretation

Provider-side Play App Signing is fully active.

The provider does not yet show an upload-key certificate fingerprint because no first app bundle has been uploaded for this app.

This does **not** prove whether a private upload keystore exists elsewhere, but the project preflight separately records that no authorized upload key is currently available.

## Current official Play guidance snapshot

Google's current Play App Signing guidance for a new app is:
1. app is enrolled with Google-generated app-signing keys;
2. developer creates a separate upload key/keystore;
3. developer signs the release app bundle with that upload key;
4. upload of the first bundle establishes the upload-key certificate state shown by Play.

## Disposition

`READ_ONLY_APP_SIGNING_AUDIT_PASS`

- Play App Signing: `ACTIVE / APP_SIGNING_KEY_IN_USE`
- App-signing SHA-256 fingerprint: `56:39:62:12:1D:E2:14:C3:C7:53:41:CB:54:8B:A2:C0:71:D7:16:25:F0:5A:34:77:98:21:5B:38:0F:00:9B:47`
- Upload-key certificate in Play: `NOT_YET_SHOWN_FIRST_BUNDLE_NOT_UPLOADED`
- Upload-key private material: `NOT_OBSERVED / NOT_TO_BE_SHARED_IN_CHAT`

## Next recommended material scope

`S5 UPLOAD KEY CREATION + LOCAL RELEASE SIGNING ONLY`

This next scope should:
- create a dedicated upload keystore locally under human control;
- record only public certificate fingerprints and non-secret metadata;
- never commit or transmit the private keystore/passwords;
- sign a fresh release AAB locally;
- verify the signed AAB and its signing certificate;
- STOP before any Play upload.

AAB upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, and publication remain separately gated.
