# APP_IDENTITY_DECISION_v1.0

Status: SUPERSEDED_BY_KEYWORD_LED_NAMING_RESEARCH
Decision date: 2026-09-27
Scope: Google Play application identity before first Play upload

## Superseded Identity

- Play Store title (EN): `SizeProof: Photo Compressor`
- Launcher / in-app brand: `SizeProof`
- Android applicationId / package ID: `com.afradadmedia.sizeproof`
- Developer namespace root: `com.afradadmedia`

## Why this replaces the previous working identity

The previous working title/brand `Upload Ready` and package `com.uploadready.app` are retired for publication identity.

Current public-market research found:
1. A live Google Play app titled `UploadReady Photo PDF` already uses package ID `com.uploadready.app`.
2. Active web products also use the `UploadReady` / `Upload Ready` name for upload-fixing and image-compression utilities.
3. Therefore `Upload Ready` has direct market collision in the same job/category and `com.uploadready.app` cannot be used as this app's final unique Play package identity.

## Why SizeProof

`SizeProof` describes the product's differentiated behavior without promising that every requested target can always be reached:
- the app measures actual output bytes;
- PASS is shown only when RESULT <= REQUIRED;
- NOT_MET remains an honest valid outcome;
- REDUCED does not inherit upload-compatibility claims.

The Play title `SizeProof: Photo Compressor` preserves the strong category phrase `Photo Compressor` while adding a distinct brand/job concept. It is 27 characters, within Google Play's current 30-character title limit.

## Naming collision screen

Current public Google Play/web searches did not surface an exact mobile-app title collision for `SizeProof: Photo Compressor` or an indexed package collision for `com.afradadmedia.sizeproof`.

This is a public-index collision screen, not formal legal trademark clearance. Final Play Console package availability is established only when Google accepts the application ID.

## Rejected / avoided names

- `Upload Ready`: direct same-category collision; live Google Play app and active upload-tool websites.
- `UnderLimit`: active iOS utility in the same file-size-limit job.
- `LimitFit`: active iOS photo-size utility.
- `ByteFit`: active app/product names in photo-compression and fitness/nutrition contexts.
- `PhotoLimit`: active Google Play app name.
- `PhotoPass`: avoid due strong existing Disney PhotoPass mark/use.
- `ExactKB`: active Google Play competitor and implies a stronger exact-target promise than this product should make.
- `SizeReady`: active Google Play competitor.

## Implementation boundary

This decision authorizes naming/package migration planning, not Play publication, release, Artifact Freeze, signing, or production launch.

Before any Play upload:
- replace `com.uploadready.app` with `com.afradadmedia.sizeproof` across applicationId, namespace, Java packages/imports, provider authorities, tests, manifests, and evidence;
- change launcher/app label to `SizeProof`;
- preserve buyer-job semantics;
- rerun build/unit/lint/install/launch/core regression;
- regenerate S5 AAB/APK hashes and evidence;
- ensure no stale `com.uploadready.app` publication artifact is used.

## ASO working copy

EN Play title: `SizeProof: Photo Compressor`

Working short-description direction:
`Compress photos to KB/MB upload limits and verify the actual result.`

Localization and final store copy remain separate ASO work and do not alter the package ID.


## Supersession Note — 2026-09-27
Subsequent keyword-led market research changed the naming strategy. The `SizeProof: Photo Compressor` title and `com.afradadmedia.sizeproof` package are no longer authorized for implementation. No source/package migration was performed from this superseded decision.

See: `docs/market/FINAL_KEYWORD_SELECTION_v1.0.md`.
