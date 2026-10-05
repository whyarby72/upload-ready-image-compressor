# Photo Compressor: KB Limit — Google Play Listing Package v1.0.0

## Status

- source audit: PASS
- listing copy: READY
- app icon: READY_CANDIDATE
- feature graphic: READY_CANDIDATE
- phone screenshots: SOURCE_RENDERED_CANDIDATES / HOLD_RUNTIME_PARITY_QA
- Play Console upload: NOT AUTHORIZED BY THIS package
- Send for review / release / publication: NOT AUTHORIZED

## Canonical listing copy — en-US

### App name

`Photo Compressor: KB Limit`

Character count: 26 / 30

### Short description

`Compress JPEG photos to a target KB or MB limit and verify the final file size`

Character count: 78 / 80

### Full description

Need a JPEG to fit a website upload limit? Photo Compressor: KB Limit helps you choose a photo, set a target size, compress a separate copy on your device, and check the actual result before you upload it.

Choose a common target such as 50 KB, 100 KB, 200 KB, 500 KB, or 1 MB, or enter a custom KB/MB limit. If you do not know the website limit, you can make a smaller copy without claiming that a specific target was met.

What you can do

- Choose a JPEG/JPG from your device
- Set a known upload limit or enter a custom KB/MB target
- Compress the photo on your device
- See whether the result meets the selected limit
- Compare the current and result file sizes
- Save a separate copy or share the result
- Start another compression without changing the original

Built around file-size verification

When you enter a target, the result screen shows the actual output size and whether it is within that byte limit. The app displays decimal file-size units: 1 KB = 1,000 bytes. Some file managers use 1,024-byte units, so their displayed number may differ slightly.

Your original stays untouched

The normal compression workflow creates a separate result file and does not overwrite the source photo.

No account required

You do not need to create an account or sign in for the core compression workflow.

Important

- JPEG/JPG input only
- Very small targets may not be achievable for every image
- Core photo compression runs on-device
- An ad-enabled release can use Google advertising and consent services; see the privacy policy for details.

## Source-audit truth

Current source establishes:
- Android package `com.afradadmedia.reducephotosize`;
- manifest/app label `Reduce Photo Size`;
- home promise `Fit your photo to an upload limit.`;
- JPEG-only picker;
- 50 KB / 100 KB / 200 KB / 500 KB / 1 MB presets;
- custom KB/MB limit;
- `I don't know the limit` path;
- target PASS / NOT_MET semantics based on actual output bytes;
- Save copy / Share / Compress another;
- original-untouched messaging;
- on-device core-processing positioning;
- decimal unit disclosure `1 KB = 1,000 bytes`;
- in-app privacy-policy surface;
- ad-enabled result banner subject to consent/SDK eligibility.

Observed source hashes:
- AndroidManifest.xml: `5a8ae28959516bda1cd079eeffa9cc49f6a8f33e`
- strings.xml: `10d8e7a13db47c782063102061291cff9ff90729`
- MainActivity.kt: `c9fe787e80ab3255a4626d10a838beb13a3ec79a`
- ic_brand_compress_frame.xml: `138470e4fe79aa6fad29972b30ce49c25ee13f49`
- ic_launcher_foreground.xml: `9afc7892c49a2a39d066beda4ba52510f2637a5d`
- ic_launcher_background.xml: `686e00b181240b3aa2b01deb4197cbb9182adf84`
- ill_home_fit_to_limit_generated.webp: `bf2bf62489903ea0f062d7dea90d44160e85c240`

## Asset contract

Binary asset package:
`PHOTO_COMPRESSOR_GOOGLE_PLAY_LISTING_PACKAGE_v1.0.0.zip`

Package SHA-256:
`3e14faba0961152f9173c139f52b5e588363f308b8033427b46582a54fe866a6`

Expected files:
- app icon: `assets/app_icon_512.png` — 512×512 PNG
- feature graphic: `assets/feature_graphic_1024x500.jpg` — 1024×500 JPEG
- four phone screenshot candidates — 1080×1920 portrait

## Screenshot truth boundary

The four screenshot PNGs are deterministic source-rendered candidates derived from the current UI code, palette, labels, and flows. They are not direct Android runtime captures.

Before upload:
1. compare each candidate against the current release-candidate runtime;
2. PASS only when labels, button ordering, visible capabilities, layout intent, and result semantics remain materially accurate;
3. if any material mismatch exists, replace the candidate with a direct runtime capture;
4. never treat source-rendered appearance as stronger evidence than runtime behavior.

## Store settings already established

- Application type: App
- Category: Photography
- Support email: `afradadmedia@gmail.com`
- Website: `https://apps.afradadmedia.com/photo-compressor-kb-limit/`
- Phone: blank
- Privacy policy: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

## Copy truth constraints

Do not:
- claim guaranteed target success for every image;
- claim lossless compression;
- claim the entire app is network-free/offline-only;
- claim PNG/HEIC/WebP input support;
- collapse the no-limit smaller-copy mode into a verified target PASS;
- add rankings, awards, promotional-price language, testimonials, or keyword stuffing.

