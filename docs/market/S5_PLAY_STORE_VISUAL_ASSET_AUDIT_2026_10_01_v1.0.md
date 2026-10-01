# S5 PLAY STORE VISUAL ASSET AUDIT — 2026-10-01

Product: PHOTO COMPRESSOR: KB LIMIT
Locale baseline: en-US
Play title: `Photo Compressor: KB Limit`
Short description: `Set a KB limit, compress photos, and verify the final size in exact bytes.`
Visual system: `MEDIA-FIRST PRECISION UTILITY — WARM INK`

Scope:
- app icon for Google Play;
- phone screenshots for Google Play;
- feature graphic;
- alignment to frozen title/short/full-description positioning;
- policy/technical requirements;
- production gaps.

No image/source-code production is authorized by this audit.

## 1. Current official Google Play requirements verified 2026-10-01

Official source:
https://support.google.com/googleplay/android-developer/answer/9866151

### Play app icon
Required:
- 32-bit PNG with alpha;
- 512 x 512 px;
- max 1024 KB;
- compliant with Google Play icon specifications;
- no misleading badges/text related to ranking, price, Play categories, or similar claims.

Important:
The Play store icon is a separate high-fidelity listing asset. It does not replace the Android launcher icon.

### Feature graphic
Required:
- JPEG or 24-bit PNG;
- no alpha;
- 1024 x 500 px.

Recommended:
- communicate the app experience / core value;
- keep focal content near the center;
- avoid fine detail;
- use style/colors complementary to the app and icon;
- do not simply duplicate prominent icon branding;
- avoid pure white / black / dark gray dominance;
- avoid device imagery, Play badges, rankings, prices/promotions, and time-sensitive copy.

### Phone screenshots
Required:
- minimum 2 screenshots across supported device types to publish;
- JPEG or 24-bit PNG, no alpha;
- min dimension 320 px;
- max dimension 3840 px;
- longest dimension must not exceed 2x the shortest dimension.

Recommended for app promotion surfaces:
- at least 4 screenshots;
- minimum 1080 px resolution;
- 9:16 portrait or 16:9 landscape;
- first screenshots should prioritize actual app UI;
- taglines only when useful and no more than 20% of the image;
- no store-ranking, price/promotion, testimonials, or install/download CTA;
- remove irrelevant notification-bar clutter;
- no blurry/stretched/distorted imagery;
- localize added marketing text per locale.

Official best-practice source:
https://support.google.com/googleplay/android-developer/answer/13393723

## 2. Current repository visual-asset inventory

### Android launcher identity — EXISTS

Current adaptive icon resources:
- `app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml`
- `app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml`
- `app/src/main/res/drawable/ic_launcher_foreground.xml`
- `app/src/main/res/drawable/ic_launcher_background.xml`
- `app/src/main/res/drawable/ic_launcher_monochrome.xml`

Current semantic mark:
`Compression Frame Mark`

Observed vector semantics:
- photo/image panel in the center;
- corner/frame cues;
- horizontal inward/compact cues;
- deep ink/teal foreground;
- warm ivory background.

Brand provenance:
project-owned original vector.

Current runtime launcher evidence:
`evidence/screenshots/s5_006_visual_productization/launcher_api36.png`

### Dedicated Google Play 512 icon — MISSING

No dedicated 512x512 Play-store PNG exists under `store/` or another canonical store-asset namespace.

Therefore:
`PLAY_STORE_ICON_DELIVERABLE = MISSING`

### Home visual story — EXISTS AS SOURCE MATERIAL

Current owned Home hero:
`app/src/main/res/drawable-nodpi/ill_home_fit_to_limit_generated.webp`

Dimensions:
`1000 x 578`

Semantics:
`large/source photo LEFT -> right-pointing arrow -> smaller/result photo RIGHT`

This was already machine-QA'd and human-approved for the runtime Home.

### Feature graphic — MISSING

The Home hero is not a compliant feature graphic:
- dimensions are 1000x578, not 1024x500;
- codec is WebP rather than required JPEG / 24-bit PNG;
- it was composed for in-app Home, not Play's crop/focal-zone surfaces.

Therefore:
`PLAY_FEATURE_GRAPHIC_DELIVERABLE = MISSING`

### Runtime screenshots — EXISTS, but store-ready set is MISSING

Current quality evidence includes:
- Home 360x800 / 320x640 / font scale;
- Requirement;
- Processing;
- PASS;
- NOT_MET;
- REDUCED;
- Before/After variants.

Latest relevant evidence paths include:
- `evidence/screenshots/s5_006_visual_productization_generated_hero/home_generated_hero_360x800.png`
- `evidence/screenshots/s5_006_visual_productization_generated_hero/home_generated_hero_320x640.png`
- `evidence/screenshots/s5_006_visual_productization_generated_hero/requirement_smoke.png`
- `evidence/screenshots/s5_007_output_size_display_clarity/pass_360/screenshot.png`
- `evidence/screenshots/s5_007_output_size_display_clarity/not_met_360/screenshot.png`
- `evidence/screenshots/s5_007_output_size_display_clarity/reduced_360/screenshot.png`

These are QA/evidence captures, not a Play marketing screenshot set.

Important compliance finding:
- 360x800 has a 2.22:1 long-to-short dimension ratio, which exceeds Play's current 2:1 screenshot limit.
- 320x640 is exactly 2:1 and technically dimension-compliant, but it is below Google's 1080px promotional recommendation.
- Current QA captures also do not form a deliberate store-conversion story and may include evidence-oriented framing not optimized for listing presentation.

Therefore:
`PLAY_PHONE_SCREENSHOT_SET = RECAPTURE_REQUIRED`

## 3. Visual-positioning alignment audit

Frozen positioning:
`Photo Compressor: KB Limit`

Core differentiator:
`user-selected KB/MB maximum + exact-byte verification + honest PASS / NOT_MET`

The store visuals should therefore communicate:

1. PHOTO
2. LIMIT
3. VERIFIED RESULT

They should NOT primarily communicate:
- generic gallery cleanup;
- storage saving;
- crop/resizer toolbox;
- social-media editing;
- batch editing;
- "MB to KB converter";
- guaranteed exact equality.

## 4. App icon audit

### What works

The current Compression Frame Mark is directionally aligned:
- photo semantics are visible;
- inward/frame cues communicate fitting/compression;
- Warm Ink palette is distinctive versus common bright-blue utility icons;
- no letters/numbers reduce localization and small-size clutter;
- the mark already matches the in-app brand shell.

### Risk

At very small search-result size, the corner-frame motif can be read as:
- crop;
- scanner;
- photo framing;

before it is read as "compression to a file-size limit."

This is not a blocker for the runtime launcher, but the Play 512 version should increase the visual weight of the "compact / fit-to-limit" cue without adding text.

### Store-icon direction

Create a dedicated `512x512` PNG derived from the same mark:
- warm ivory field;
- deep ink photo tile;
- stronger paired inward compression/limit cues;
- preserve ample negative space;
- no "KB" text;
- no app-name initials;
- no checkmark that could imply guaranteed success;
- no rank/price/badge text.

Disposition:
`ICON_CONCEPT_PASS / STORE_EXPORT_REQUIRED / SMALL-SIZE_SEMANTIC_REFINEMENT_RECOMMENDED`

## 5. Feature graphic audit

### Recommended conceptual direction

Do NOT make a giant copy of the icon.

Use the already approved Home compression story as the base visual grammar:
- left: a larger photo object;
- center: restrained limit/bracket/compression cue;
- right: a smaller result object with calm verification cue;
- Warm Ink surfaces;
- no device frame;
- no dense UI;
- no fake "exact target" guarantee.

Recommended:
`TEXT-LIGHT OR TEXT-FREE`

Reason:
- title + short description already carry keyword/semantic load;
- feature-graphic text does not need to repeat SEO phrases;
- text-free art reduces localization maintenance;
- Google recommends minimizing duplicated messaging across assets.

If text is used, keep one concise statement only, such as:
`Set a limit. Verify the result.`

Do NOT use:
- "Exact KB";
- "Guaranteed";
- "#1";
- "Best";
- "Free";
- "Download now";
- pricing/discounts;
- fixed result numbers presented as a universal promise.

Required output:
`1024x500 PNG-24 or JPEG, no alpha`

Disposition:
`FEATURE_GRAPHIC_CONCEPT_READY / ASSET_MISSING`

## 6. Phone screenshot conversion architecture

Target:
`6 portrait screenshots @ 1080x1920`

This exceeds the minimum and satisfies Google's current promotion-surface recommendation for 4+ 1080px app screenshots.

### Screenshot 1 — strongest differentiator
Runtime state:
`PASS result`

Marketing message:
`Verify the final size`

Must visibly show:
- result photo;
- MEETS LIMIT;
- large result size;
- exact byte inequality;
- target context.

Why first:
The title already explains "Photo Compressor." The first screenshot should prove why this compressor is different.

### Screenshot 2 — buyer input
Runtime state:
`Requirement / target selection`

Marketing message:
`Set your KB limit`

Must visibly show:
- selected photo;
- CURRENT facts;
- 50 / 100 / 200 / 500 KB / 1 MB / Custom;
- explicit Required target.

### Screenshot 3 — completion
Runtime state:
`PASS result / actions visible`

Marketing message:
`Save or share the verified file`

Must visibly show:
- real result;
- Save;
- Share;
- Before / After where practical.

### Screenshot 4 — flexible target
Runtime state:
`Custom Limit`

Marketing message:
`Use a custom KB or MB limit`

Must visibly show:
- valid numeric custom limit UI;
- KB / MB selection;
- clean inline guidance.

### Screenshot 5 — trust / local processing
Runtime state:
`Home or Processing`

Marketing message:
`Photo compression stays on-device`

Must visually support:
- real/owned media;
- "Original untouched" or equivalent truthful cue.

Note:
After AdMob integration, this wording remains safe because it refers specifically to photo compression, not the entire app's network behavior.

### Screenshot 6 — truthful failure behavior
Runtime state:
`NOT_MET`

Marketing message:
`No false success when a target is too small`

Must visibly show:
- TARGET NOT MET;
- actual result > required limit;
- calm recovery guidance.

Purpose:
Trust differentiation; do not place this before the positive core-value screenshots.

## 7. Screenshot production rules

- actual current app UI only;
- no fake screen states;
- no device frames;
- no third-party logos;
- no store badges;
- no install/download CTA;
- no "best", "#1", ratings, downloads, testimonials, or price;
- tagline area <=20%;
- headline/tagline must be localized if additional locales are added;
- use one consistent Warm Ink background/typographic system;
- keep the actual UI visually dominant;
- do not cover exact-byte proof with marketing text;
- remove notification clutter;
- capture from exact current source/artifact or from a later artifact after approved AdMob changes.

## 8. Important timing finding

The app is not yet AdMob-integrated.

Store screenshots created now may remain valid if they depict screens whose visible experience is unchanged after S7.

However:
- if AdMob changes any captured screen materially, affected screenshots must be recaptured;
- the final listing must reflect the actual distributed build.

Therefore:
- icon and feature graphic can be produced now;
- screenshot storyboard can be frozen now;
- final upload-ready screenshots should receive a post-AdMob visual-drift check before publication.

## 9. Store-asset inventory verdict

| Asset | Current state | Technical compliance | Positioning alignment | Action |
|---|---|---|---|---|
| Android launcher icon | EXISTS | runtime only | GOOD | preserve |
| Play 512 icon | MISSING | FAIL as deliverable | concept GOOD | create |
| Feature graphic | MISSING | FAIL as deliverable | concept READY | create |
| QA screenshots | EXISTS | mixed; 360x800 invalid ratio | source UI GOOD | do not upload as-is |
| Play screenshot set | MISSING | HOLD | storyboard READY | recapture/design |
| Alt text | MISSING | not prepared | N/A | author with assets |

## 10. Gate conclusion

`STORE_VISUAL_ASSET_AUDIT = PASS`

`STORE_VISUAL_ASSET_PRODUCTION = REQUIRED`

There is no reason to reopen the app UI or broad redesign.

Required next asset-production scope:
`S5 PLAY STORE VISUAL ASSET PACK PRODUCTION`

Expected outputs:
1. Play icon 512x512;
2. feature graphic 1024x500;
3. six-screen 1080x1920 screenshot storyboard/templates;
4. final screenshot captures or composites bound to actual app UI;
5. alt-text manifest;
6. provenance/hash manifest;
7. direct human visual review.

This audit does not authorize image production, source mutation, final Create app submission, package registration mutation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.
