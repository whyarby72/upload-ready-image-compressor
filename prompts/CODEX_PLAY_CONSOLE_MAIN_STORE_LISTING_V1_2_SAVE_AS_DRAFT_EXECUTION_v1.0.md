# CODEX — GOOGLE PLAY MAIN STORE LISTING v1.2 SAVE-AS-DRAFT EXECUTION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## EXPLICIT HUMAN AUTHORIZATION

Authorized scope:
`MAIN_STORE_LISTING_V1_2_SAVE_AS_DRAFT`

The human explicitly authorizes ONLY:

1. verifying the exact v1.2.0 asset package;
2. opening the current Main store listing for the verified app/package;
3. entering the exact canonical v1.2 listing text;
4. uploading the exact six v1.2.0 visual assets;
5. clicking the provider control labeled `Save as draft`;
6. re-opening/reloading the listing and verifying durable saved state;
7. opening Publishing overview read-only;
8. capturing evidence;
9. STOP.

## NOT AUTHORIZED

Do NOT:
- click `Next`;
- click `Send app for review`;
- submit any declaration;
- create or edit a release;
- promote any track;
- roll out to production;
- change Managed Publishing;
- change pricing/countries;
- modify App content;
- Artifact Freeze;
- publish/release the Android app;
- substitute or regenerate listing assets.

## Provider context preflight

Before any mutation:

1. Refresh the canonical branch and record exact HEAD.
2. Verify active Play Console app = `Photo Compressor: KB Limit`.
3. Verify package if visible = `com.afradadmedia.reducephotosize`.
4. Verify current page = Main store listing.
5. Record pre-mutation values and exact visible persistence controls.

If app/account/page context is wrong:
`BLOCKED_WRONG_PROVIDER_CONTEXT`

If the persistence control is no longer exactly `Save as draft`, STOP before mutation:
`BLOCKED_PROVIDER_UI_SCHEMA_DRIFT`

## Exact package identity

Binary package:
`PHOTO_COMPRESSOR_GOOGLE_PLAY_LISTING_PACKAGE_v1.2.0.zip`

Required ZIP SHA-256:
`4294f59c952bc97d21a22350f1adf4121158f6004c730ab06f3d7ccc672248ff`

The binary ZIP may be supplied separately to the Codex/local workspace. Search only reasonable operator-accessible locations already available to the task, such as:
- current worktree;
- a task-specific local-input directory;
- Downloads;
- an explicitly mounted task attachment location.

Do not download an arbitrary internet copy and do not reconstruct missing binaries.

If the ZIP cannot be found:
`BLOCKED_ASSET_PACKAGE_UNAVAILABLE`

If the ZIP hash differs:
`BLOCKED_ASSET_PACKAGE_HASH_MISMATCH`

Extract to a temporary/untracked directory only.

## Exact asset identities

All six files must match exactly:

- `assets/app_icon_512.png`
  SHA-256: `a76535de6908a6a1c67b9b7cadd0ef59b726e43cc593bfd17aaa52451ef64a8a`
  expected: 512×512 RGBA PNG

- `assets/feature_graphic_1024x500.jpg`
  SHA-256: `54b717e453e6a7c6a39be92ef8bda444bea9ee9c42c3a537aadb365ffb19b1ec`
  expected: 1024×500 JPEG

- `assets/phone_01_home_runtime_grounded.png`
  SHA-256: `763b6791cbd3279f0736affb5b70003c15f940ab5dc9adf0a734f46defbb4ae0`
  expected: 1080×1920 PNG

- `assets/phone_02_choose_limit_runtime_grounded.png`
  SHA-256: `005b094fa2b774c3722bfc195a76e61e051990b3877f57940b9f7f47271771f8`
  expected: 1080×1920 PNG

- `assets/phone_03_result_runtime_grounded.png`
  SHA-256: `24fb568a78801df52de97c10d53dd8ef4d7d4e01c1095e8a27cc349bc00bec04`
  expected: 1080×1920 PNG

- `assets/phone_04_save_share_runtime_grounded.png`
  SHA-256: `90b7862a2615ff2c5525a0c4da40bea70994627988fedda46752da412b83b18f`
  expected: 1080×1920 PNG

If any asset is missing, corrupted, has a mismatched hash, or has mismatched dimensions:
`BLOCKED_ASSET_INTEGRITY_FAILURE`

## Exact listing text

Use the repo source:
`play-store/listing/v1.2.0/README.md`

App name:
`Photo Compressor: KB Limit`

Short description:
`Compress JPEG photos to a target KB or MB limit and verify the final file size`

Full description:
use the exact canonical full description from:
`play-store/listing/v1.0.0/README.md`

Do not rewrite, shorten, expand, translate, or SEO-stuff the text.

## Execution sequence

1. Record current field values and existing media.
2. Enter exact App name.
3. Enter exact Short description.
4. Enter exact Full description.
5. Upload exact v1.2 App icon.
6. Upload exact v1.2 Feature graphic.
7. Upload the four exact phone screenshots in this order:
   1. Home
   2. Choose limit
   3. Result
   4. Save/share
8. Wait for all provider-side uploads/previews to complete.
9. Verify each visual preview corresponds to the intended file.
10. Verify no provider validation error is visible.
11. Review all text and media once.
12. Click `Save as draft` ONLY.
13. Do not click `Next`.
14. Re-open or refresh Main store listing.
15. Verify durable provider state:
    - exact app name;
    - exact short description;
    - full description persisted;
    - exact icon preview present;
    - exact feature graphic preview present;
    - four phone screenshots present in the intended order.
16. Open Publishing overview read-only.
17. Record:
    - pending change group(s);
    - whether `Send app for review` is enabled or disabled.
18. Do NOT click `Send app for review`.
19. Capture evidence and STOP.

## Critical second-confirmation boundary

If `Save as draft` unexpectedly opens a second dialog that indicates:
- review submission;
- publication;
- release/rollout;
- broader unrelated changes;

STOP before confirming:
`BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`

## Evidence

If repo workspace is available, create text evidence only:

`evidence/play/W2_MAIN_STORE_LISTING_V1_2_SAVE_AS_DRAFT_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical source HEAD used;
- ZIP SHA-256;
- all six asset hashes;
- exact text values saved;
- provider upload/preview status;
- exact Save-as-draft behavior;
- durable-state verification;
- Publishing overview observation;
- `Send app for review` state;
- screenshots/evidence locations;
- confirmation that no `Next`, review submission, release, rollout, or publication action occurred.

Commit only the evidence report. Do not commit private session data, browser credentials, cookies, tokens, or account identity.

## Allowed terminal dispositions

- `PASS_MAIN_STORE_LISTING_V1_2_SAVED_AS_DRAFT`
- `PARTIAL_MAIN_STORE_LISTING_DURABLE_STATE_UNVERIFIED`
- `BLOCKED_ASSET_PACKAGE_UNAVAILABLE`
- `BLOCKED_ASSET_PACKAGE_HASH_MISMATCH`
- `BLOCKED_ASSET_INTEGRITY_FAILURE`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_UI_SCHEMA_DRIFT`
- `BLOCKED_SECOND_CONFIRMATION_EXCEEDS_SCOPE`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `FAILED_PROVIDER_UPLOAD`

PASS requires:
- exact package/hash verified;
- all six exact assets uploaded;
- exact listing text persisted;
- durable state verified after reload/re-open;
- no action beyond `Save as draft`.

## Final response

Return:
1. disposition;
2. canonical source HEAD;
3. exact ZIP SHA-256;
4. six uploaded asset hashes;
5. exact persisted listing text;
6. durable-state verification;
7. Publishing overview status;
8. `Send app for review` enabled/disabled;
9. evidence commit SHA if available;
10. confirmation no `Next`, review submission, release, rollout, or publication occurred;
11. next ONE blocker/action only.
