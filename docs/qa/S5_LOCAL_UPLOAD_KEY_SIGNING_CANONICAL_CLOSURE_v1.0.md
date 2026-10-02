# S5 LOCAL UPLOAD-KEY SIGNING — CANONICAL CLOSURE v1.0

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`

## Bound inputs

Human-returned result JSON:
`S5_LOCAL_SIGNING_RESULT.json`

Uploaded result JSON SHA-256:
`8f81f065389442417847bc7b8507e385a1e41283fb1cbcb4ae471b2ee65e86a0`

Repository evidence copy:
`evidence/play/S5_LOCAL_SIGNING_RESULT_v1.0.json`

Terminal screenshot evidence:
`evidence/play/S5_LOCAL_UPLOAD_KEY_SIGNING_SCREENSHOT_OBSERVATION_2026_10_03_v1.0.md`

## Reconciliation

Result JSON reports:
- source commit: `91bb462de8007b6491be5c5ed6c073d60858ae70`;
- versionName: `0.1.0`;
- versionCode: `1`;
- upload-key alias: `photo-compressor-upload`;
- public upload-certificate SHA-256:
  `22:EA:E7:C3:78:69:B8:1A:E7:13:F7:00:7C:11:44:10:EC:A8:67:82:6A:FE:BB:34:9A:B7:B9:61:C9:86:5F:F4`;
- fresh unsigned AAB SHA-256:
  `fe6daf1be52ba9f681f45fd18a9ec0f0f4b0ba16b82dc1b3cc0c31dee510af67`;
- signed AAB SHA-256:
  `d01a0bc609ea57421cbff727aff08109a4433c3d537f927acb8c441fbec1103d`;
- signed AAB bytes: `7984820`;
- signed filename:
  `PhotoCompressor-0.1.0-vc1-upload-signed.aab`;
- jarsigner verification:
  `PASS_JAR_VERIFIED`;
- secret material recorded:
  `false`;
- Play upload performed:
  `false`;
- hard stop:
  `STOP_AFTER_LOCAL_SIGNED_AAB_VERIFICATION_BEFORE_ANY_PLAY_UPLOAD`.

The public upload-certificate fingerprint and signed-AAB SHA-256 exactly match the independently observed terminal screenshot.

## Source binding

The signing execution ran at repository commit:
`91bb462de8007b6491be5c5ed6c073d60858ae70`.

Comparison from the previously verified application-source commit:
`27199bf6f174e55dc835d0d9898e456d3848001c`
through signing commit `91bb462de8007b6491be5c5ed6c073d60858ae70` shows no file changes under `app/`.

Therefore:
- repository/evidence/metadata evolved after the app-source QA commit;
- application source and `app/build.gradle` remained unchanged;
- the fresh signed AAB remains bound to the already-verified application implementation.

The previously materialized unsigned candidate hash
`a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01`
is now provenance-only for the signing path.

The current signing path is bound instead to the fresh bundleRelease output:
`fe6daf1be52ba9f681f45fd18a9ec0f0f4b0ba16b82dc1b3cc0c31dee510af67`
and the locally signed result:
`d01a0bc609ea57421cbff727aff08109a4433c3d537f927acb8c441fbec1103d`.

## Security / authority

Private keystore and passwords were not supplied to CHAT and are not repository evidence.

No Play upload occurred.

No authority is inferred for:
- Play AAB upload;
- tester mutation;
- release creation;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- publication.

## Final disposition

`PASS_LOCAL_UPLOAD_KEY_CREATED_AND_RELEASE_AAB_SIGNED_VERIFIED`

The local signing scope is CLOSED.

Next provider action requires a new explicit authorization.
