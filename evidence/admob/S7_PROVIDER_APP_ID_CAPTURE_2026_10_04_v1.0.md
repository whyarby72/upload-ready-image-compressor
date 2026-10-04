# S7 provider App ID capture — 2026-10-04

Product: PHOTO COMPRESSOR: KB LIMIT
Scope: S7 BOUNDED ADMOB PROVIDER SETUP

## Authenticated AdMob screenshot observation

App settings shows:
- App name: `Photo Compressor: KB Limit`
- AdMob App ID: `ca-app-pub-8084313520610270~1492953098`
- App store details: blank / not linked
- App verification: `Not required`
- Approval status: `Requires review`

No package/application ID is displayed in the current App settings screen.

## Interpretation

This is consistent with the official unpublished-app setup flow: the unpublished setup asks for platform and app name, but does not require a package name at creation. Package/store identity is populated later when the app is linked to a supported public app-store listing.

The current Google Play app is private/internal testing, so it must not be forced-linked as a published Play app at this stage.

Canonical Android application ID remains source-bound:
`com.afradadmedia.reducephotosize`

Provider-bound package/store identity:
`NOT_YET_LINKED / NOT_DISPLAYED`

## Next bounded action

Create exactly one Banner ad unit named `ResultScreen_Banner_v1`.

Do not click App store details > Add merely to force package binding while the Play listing remains private/internal.
