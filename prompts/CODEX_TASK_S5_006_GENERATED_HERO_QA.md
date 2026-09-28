# CODEX WORK ORDER — TASK-S5-006 USER-APPROVED GENERATED HOME HERO INTEGRATION QA

Observed: 2026-09-29
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-006`
User decision: use the newly generated elegant Home illustration in the application.

## 0. Current integrated source

The approved raster hero has already been added and wired by CHAT.

Binary asset:
`app/src/main/res/drawable-nodpi/ill_home_fit_to_limit_generated.webp`

Packaged SHA-256:
`558da958fd28db36333a12013607399189689a288bbafa05e3644b0e5095b7be`

Dimensions:
`1000x578`

Source image SHA-256:
`30826729b4e8cd2c6b75aadabd1501a7f7b73596612a370242430e2b14da561b`

Presentation source commit:
`6762878a87a551e53af295e13d60998ca00cde8e`

Asset-manifest binding commit:
`d8709910b1144f3d0a5b33f55ca02eddaa245084`

The asset was only cropped to remove unused outer blank margin, resized, and WebP-optimized. Its visual composition was not redesigned after user approval.

Semantic direction:
`LARGE SOURCE PHOTO (LEFT) → SMALL RESULT PHOTO (RIGHT)`

## 1. Authority boundary

This work order authorizes deterministic build/QA/evidence only for the already-integrated Home hero.

Do NOT redesign or substitute the image.
Do NOT modify compression/domain behavior.
Do NOT change package/version/SDK/privacy/permissions.
Do NOT sign/upload/advance S6/promote BUILD/freeze/release/publish.

If the asset fails to render only because of a mechanical Android resource/presentation issue, you may make the smallest presentation-only repair.

## 2. Synchronize

```bash
git status --short
git fetch origin
git checkout task/TASK-S5-006
git pull --ff-only origin task/TASK-S5-006
git rev-parse HEAD
```

If uncommitted changes exist:
STOP and report. Do not reset/stash/discard.

## 3. Source checks

Verify:
- `MainActivity.kt` references `R.drawable.ill_home_fit_to_limit_generated`;
- Home hero uses proportional display; no stretch/squash;
- asset is local/offline;
- old vector hero is no longer used by Home;
- protected files remain unchanged.

Protected:
- `JpegCompressionEngine.java`
- `TargetLimitParser.java`
- `ImageInspector.java`
- `MediaStoreSaver.java`
- `ResultContentProvider.java`

## 4. Build / regression

Run:
```bash
./gradlew clean assembleDebug
./gradlew test
./gradlew lintDebug
./gradlew assembleRelease
./gradlew bundleRelease
```

Run existing relevant instrumentation/regression if available.

## 5. Required emulator visual evidence

API 36.

Freshly capture the new Home hero at:
- 360x800
- 320x640
- font scale 1.3

Also capture at least:
- Requirement with real photo
- one genuine PASS result

This is to prove the new Home asset did not regress navigation/layout.

Persist under:
`evidence/screenshots/s5_006_visual_productization_generated_hero/`

Required filenames:
- `home_generated_hero_360x800.png`
- `home_generated_hero_320x640.png`
- `home_generated_hero_font_1_3x.png`
- `requirement_smoke.png`
- `result_pass_smoke.png`

## 6. Semantic binding

For each Home screenshot:
- persist foreground package proof;
- persist UIAutomator hierarchy;
- bind screenshot hash + foreground proof + hierarchy anchors.

Home anchors:
- `Reduce Photo Size`
- `Fit your photo to an upload limit.`
- `Choose photo`
- `On-device · original untouched`

Visual hard checks:
- large source illustration is clearly on LEFT;
- arrow points LEFT → RIGHT;
- small result illustration is on RIGHT;
- asset is not clipped;
- no visible stretch/squash;
- hero does not overpower headline/CTA;
- CTA remains reachable at 320x640;
- font scale 1.3 remains usable.

## 7. Evidence reconciliation

Create:
`evidence/play/S5_006_GENERATED_HERO_PROOF.json`

Record:
- exact tested source commit;
- debug APK bytes/SHA-256;
- release APK/AAB hashes;
- packaged hero hash;
- build/test/lint results;
- emulator/environment;
- screenshot hashes;
- semantic-binding evidence paths;
- protected-domain diff.

Update:
- `evidence/INDEX.json`
- `TEST_MATRIX.csv`
- `PROJECT_STATE.json`
- `HANDOFF_CURRENT.md`
- `CHANGELOG.md`
- `docs/ux/TASK_S5_006_VISUAL_ASSET_MANIFEST_v1.0.json`

## 8. Completion

If all deterministic checks pass:
- task status:
  `GENERATED_HERO_MACHINE_QA_PASS_CHAT_HUMAN_REVIEW_READY`
- progress: 98
- next owner: `CHAT + HUMAN`
- premium-quality approval remains pending.

Do NOT self-approve `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION`.

Final report:
- tested source commit;
- evidence closure commit;
- debug APK SHA-256;
- screenshot paths;
- explicit statement that arrow is large-left → small-right;
- protected-domain diff result;
- unresolved visual exceptions, if any.

Then STOP for CHAT + HUMAN review.
