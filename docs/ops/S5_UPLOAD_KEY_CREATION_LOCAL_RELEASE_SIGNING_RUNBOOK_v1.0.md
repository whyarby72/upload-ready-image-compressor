# S5 — UPLOAD KEY CREATION + LOCAL RELEASE SIGNING ONLY v1.0

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`

Authorization:
`USER_EXPLICIT_2026-10-03_S5_UPLOAD_KEY_CREATION_LOCAL_RELEASE_SIGNING_ONLY`

## Objective

Create one dedicated developer-held upload key locally, build a fresh release AAB from the verified source, sign it locally, verify the signature, and STOP before any Play upload.

## Current provider state

Play App Signing:
`ACTIVE / APP SIGNING KEY IN USE`

Google-held app-signing SHA-256:
`56:39:62:12:1D:E2:14:C3:C7:53:41:CB:54:8B:A2:C0:71:D7:16:25:F0:5A:34:77:98:21:5B:38:0F:00:9B:47`

Play upload-key certificate:
`NOT_YET_SHOWN_FIRST_BUNDLE_NOT_UPLOADED`

## Security boundary

Private material MUST remain local to the human-controlled device:
- upload keystore;
- keystore password;
- private-key password;
- backups containing the private key.

Never:
- commit the keystore;
- place passwords in Git;
- paste passwords/private keys into CHAT;
- upload the keystore to GitHub;
- put the keystore inside the repository.

Repository may contain only:
- runbook/script;
- public certificate fingerprint;
- non-secret AAB hashes/size/version metadata;
- verification result.

## Key requirements

Use a dedicated upload key, separate from Google's app-signing key.

The local helper uses:
- RSA;
- 4096-bit key;
- PKCS12 keystore;
- 10,000-day validity;
- alias `photo-compressor-upload`;
- default keystore path outside the repository:
  `~/.android/upload-keys/photo-compressor-upload.jks`.

Google Play currently requires upload keys to be RSA 2048 bits or stronger, so RSA 4096 satisfies the provider requirement.

## Execution

From the repository root on the trusted local Mac/Linux machine:

```bash
bash scripts/local/s5_create_upload_key_and_sign.sh
```

The script:
1. verifies required local tools;
2. refuses to overwrite an existing upload keystore;
3. creates the upload keystore using interactive secret prompts;
4. runs `./gradlew clean bundleRelease`;
5. copies the fresh unsigned AAB to a local output directory outside the repo;
6. signs the copied AAB with `jarsigner`;
7. verifies the signed AAB with `jarsigner -verify`;
8. extracts the public upload-certificate SHA-256 fingerprint from the signed AAB;
9. writes a non-secret evidence JSON locally.

## Expected local outputs

Default output directory:
`~/Downloads/photo-compressor-s5-signing/`

Expected files:
- `PhotoCompressor-0.1.0-vc1-upload-signed.aab`
- `S5_LOCAL_SIGNING_RESULT.json`

The keystore remains separately at:
`~/.android/upload-keys/photo-compressor-upload.jks`

## What to return to CHAT

Return only:
- `S5_LOCAL_SIGNING_RESULT.json`
- optionally the terminal PASS lines.

Do NOT return:
- `.jks` / `.keystore`;
- passwords;
- private keys;
- secret environment variables.

## Acceptance

PASS requires:
- fresh `bundleRelease` succeeds;
- signed AAB exists;
- `jarsigner -verify` succeeds;
- public upload-certificate SHA-256 fingerprint is recorded;
- signed AAB SHA-256 and byte size are recorded;
- versionName = `0.1.0`;
- versionCode = `1`;
- no secret material is in repository evidence.

## Hard stop

`STOP_AFTER_LOCAL_SIGNED_AAB_VERIFICATION_BEFORE_ANY_PLAY_UPLOAD`

AAB upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, and publication require separate authorization.
