# S5 PLAY APP SIGNING READ-ONLY OBSERVATION — 2026-10-02

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Provider app id: `4973120481844433940`

User-supplied provider screenshot:
- SHA-256: `e97edcb18a41b4c12cbbedf0c932c0b6956d07334fe3ab96d5cace925a16c5b3`;
- bytes: `416790`.

Visible provider state under `Play Store protection`:
- `Protect app signing key` status shows `Releases signed by Play`;
- action available: `Manage Play app signing`;
- Play Store protection total: `6 of 7 services active`;
- `Store listing device checks off`;
- Play Protect scanning always on;
- Play SDK scanning always on;
- Spam protection always on;
- Anomaly protection always on;
- Fairness protection always on.

## Disposition

`PLAY_APP_SIGNING_ACTIVE_PROVIDER_CONFIRMED / UPLOAD_KEY_STATUS_PENDING`

The visible `Releases signed by Play` status is sufficient provider evidence that Play App Signing is active for this app.

This screenshot does not expose:
- app-signing certificate fingerprints;
- upload-key certificate presence/status/fingerprint.

## Next read-only step

Open `Manage Play app signing` and capture the resulting certificate/status page.

Hard stop before:
- changing app signing configuration;
- changing/upgrading the app signing key;
- creating/resetting/rotating/importing any upload key;
- uploading any certificate/key;
- signing or uploading an AAB.

No mutating action is authorized.
