# CODEX — GOOGLE PLAY MAIN STORE LISTING UPLOAD GATE v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Package source

Use:
`play-store/listing/v1.0.0/README.md`

Binary asset bundle:
`PHOTO_COMPRESSOR_GOOGLE_PLAY_LISTING_PACKAGE_v1.0.0.zip`

Expected ZIP SHA-256:
`3e14faba0961152f9173c139f52b5e588363f308b8033427b46582a54fe866a6`

## Current authorization boundary

THIS PROMPT IS PREPARATION-ONLY.

It does not authorize:
- Main store listing mutation;
- Save / Save and publish;
- Send app for review;
- release creation;
- track promotion;
- production rollout;
- Managed Publishing changes;
- Artifact Freeze;
- Android publication/release.

A separate explicit human approval is required before provider mutation.

## Preflight

1. Verify active Play Console app = `Photo Compressor: KB Limit`.
2. Verify package if visible = `com.afradadmedia.reducephotosize`.
3. Verify canonical branch HEAD before using package content.
4. Verify the extracted ZIP hash.
5. Read the repo listing manifest.
6. Inspect current Main store listing schema and report exact fields/buttons before mutation.
7. Compare the four screenshot candidates against the current app runtime.

## Screenshot parity gate

The supplied phone screenshots are SOURCE_RENDERED_CANDIDATES, not direct Android runtime captures.

For each screenshot:
- compare visible labels, button ordering, app header, palette, major layout hierarchy, and feature semantics against the current release-candidate runtime;
- if materially accurate, record `RUNTIME_PARITY_PASS`;
- if materially different or uncertain, capture a direct runtime screenshot and replace the candidate;
- never upload a misleading screenshot;
- do not infer runtime truth from source-rendered artwork.

## Intended listing payload after separate approval

Locale: `en-US`

App name:
`Photo Compressor: KB Limit`

Short description:
`Compress JPEG photos to a target KB or MB limit and verify the final file size`

Full description:
use the exact full description in:
`play-store/listing/v1.0.0/README.md`

Graphics:
- `assets/app_icon_512.png`
- `assets/feature_graphic_1024x500.jpg`
- four numbered 1080×1920 phone screenshots after runtime parity PASS

## Future execution sequence after explicit approval

1. Record pre-mutation state.
2. Enter exact listing copy; do not rewrite or SEO-stuff.
3. Upload icon.
4. Upload feature graphic.
5. Upload four phone screenshots in numbered order, only after parity PASS.
6. Review form.
7. Persist only within the separately approved scope.
8. Re-open and verify durable state.
9. Inspect Publishing overview read-only.
10. STOP before `Send app for review`.

## Required output for this preparation run

- exact current Main store listing schema;
- missing/filled fields;
- exact persistence button wording;
- screenshot runtime-parity disposition for each candidate;
- any required asset replacement;
- one proposed next action;
- confirmation no provider mutation occurred.
