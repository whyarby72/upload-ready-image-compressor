# Photo Compressor: KB Limit — Google Play Listing Package v1.2.0

## Status

`USER_VISUAL_APPROVED / RUNTIME_GROUNDED / PROVIDER_UPLOAD_NOT_YET_AUTHORIZED`

The human operator explicitly approved the latest four Google Play marketing screenshots and instructed the project to use them.

These screenshots were built from four user-supplied direct smartphone captures of the running Android app.

Evidence class for the raw source images:
`USER_SUPPLIED_RUNTIME_CAPTURE`

The final marketing screenshots are presentation composites grounded in those real captures. They are not raw runtime screenshots and must not be described as raw captures.

## Binary package

`PHOTO_COMPRESSOR_GOOGLE_PLAY_LISTING_PACKAGE_v1.2.0.zip`

SHA-256:
`4294f59c952bc97d21a22350f1adf4121158f6004c730ab06f3d7ccc672248ff`

## Final assets

- `assets/app_icon_512.png` — 512×512 RGBA PNG
- `assets/feature_graphic_1024x500.jpg` — 1024×500 JPEG
- `assets/phone_01_home_runtime_grounded.png` — 1080×1920 PNG
- `assets/phone_02_choose_limit_runtime_grounded.png` — 1080×1920 PNG
- `assets/phone_03_result_runtime_grounded.png` — 1080×1920 PNG
- `assets/phone_04_save_share_runtime_grounded.png` — 1080×1920 PNG

All six files are within the provider schema size limits observed during the prior Play Console preflight.

## Runtime source truth used

The user-supplied smartphone bundle contained four screenshots:
1. Home / Choose photo
2. Choose limit
3. Result / PASS
4. Result actions / Save / Share / Compress another

Observed factual runtime values used by the marketing set include:
- current photo = `130 KB`
- dimensions = `750 × 562`
- format = `JPEG`
- known-target result = `99 KB`
- provider-visible result statement = `99,480 bytes ≤ 100,000-byte limit — PASS`
- result screen states `MEETS LIMIT`
- Save copy / Share / Compress another are visible runtime actions
- original-untouched messaging is present

## Listing copy

App name:
`Photo Compressor: KB Limit`

Short description:
`Compress JPEG photos to a target KB or MB limit and verify the final file size`

Full description:
reuse the canonical v1.0.0 copy unless superseded by an explicit later copy revision.

## Provider mutation boundary

This package does NOT authorize:
- Main store listing upload;
- `Save as draft`;
- `Next`;
- `Send app for review`;
- release creation;
- track promotion;
- production rollout;
- Managed Publishing changes;
- Artifact Freeze;
- Android publication/release.

## Next gate

`MAIN_STORE_LISTING_V1_2_UPLOAD_APPROVAL`
