# TASK-S5-006 — VISUAL ASSET COMPLETENESS CORRECTIVE SPEC v1.0

Observed: 2026-09-28
Product: REDUCE PHOTO SIZE: KB LIMIT
Decision: TEST
Stage: S5_VISUAL_PRODUCTIZATION_REWORK
Implementation authority: NOT YET GRANTED

## 1. Objective

Bring the actual Android runtime presentation up to the approved `MEDIA-FIRST PRECISION UTILITY — WARM INK` quality bar by closing missing brand/illustration/visual-object gaps without changing the verified product domain.

This is not a broad redesign.

Frozen:
- package/applicationId;
- versionCode/versionName;
- JPEG/JPG scope;
- target parser;
- compression engine;
- PASS / NOT_MET / REDUCED semantics;
- exact-byte proof;
- geometry preservation;
- Save / Share;
- privacy/permissions;
- no AdMob/analytics.

## 2. Current gap summary

Current runtime already has:
- Warm Ink palette;
- modern type scale;
- rounded tonal surfaces;
- one dominant CTA;
- real user-photo previews after selection;
- media-first Result;
- Fit/full-frame geometry.

Current runtime lacks:
- dedicated launcher identity;
- dedicated in-app brand mark;
- sufficiently designed first-open hero illustration;
- explicit asset manifest;
- object-level mockup fidelity verification.

The main first-open visual currently resolves to:
`generic photo icon → rounded square → PHOTO → READY`

That is too close to a placeholder/wireframe diagram for the intended premium direction.

## 3. Corrective visual thesis

Keep:
`CALM / PRECISE / PRIVATE / MEDIA-FIRST / WARM INK`

Add:
`BRANDED / PURPOSE-BUILT / VISUALLY EXPLANATORY`

Do not become:
- decorative for decoration's sake;
- cartoonish;
- stock-photo-heavy;
- colorful SaaS;
- gaming;
- gradient/glow driven;
- illustration-first at the expense of the photo workflow.

## 4. Visual identity asset concept

### 4.1 Product mark — required

Create one dedicated product mark distinct from `ic_photo`.

Concept:
**Compression Frame Mark**

Visual semantics:
- a simplified photo/frame outline;
- two subtle inward size/limit cues or compacting corners;
- calm geometric construction;
- recognizable at 20–24dp and at launcher scale;
- no letters;
- no baked text;
- no fake numeric promise.

Use the same visual grammar for:
- launcher icon foreground;
- in-app header mark;
- optional splash/brand presence if later needed.

Do NOT use the exact same generic Material photo glyph as the brand.

### 4.2 Launcher icon — required

Provide:
- adaptive launcher icon;
- standard fallback icon resources;
- round icon if required by current project/platform packaging;
- monochrome/themed foreground where supported and visually coherent.

Palette:
- warm ivory background or quiet warm surface;
- deep ink/teal foreground;
- optional low-saturation secondary tonal layer.

The launcher icon must remain legible at small system sizes.

## 5. First Open / Home

### Buyer question
`What does this app do, and what should I do first?`

### Required objects
1. dedicated app mark in header;
2. product name;
3. quiet `On-device` trust cue;
4. hero statement:
   `Fit your photo to an upload limit.`
5. purpose-built hero illustration;
6. dominant `Choose photo` CTA;
7. compact trust line:
   `On-device · original untouched`.

### Hero illustration direction

Replace `WarmInkArtwork()` with an owned local composition that visually communicates:
`PHOTO → FIT TO LIMIT → SMALLER COPY`
without exact output numbers.

Recommended composition:
- one source-photo frame;
- one smaller output-photo frame;
- subtle inward/limit bracket motif;
- small neutral arrow/motion cue;
- tonal depth from Warm Ink surfaces;
- no text baked inside the asset;
- no fake file sizes;
- no promise of guaranteed success.

The image may use a generic landscape/photo motif, but it must be a designed composition, not a lone photo pictogram.

### Acceptance
- first impression reads as finished consumer app, not prototype;
- visual focus order:
  headline → illustration → CTA;
- hero adds meaning, not filler;
- CTA remains above/near first viewport at 360×800;
- 320×640 remains usable;
- 1.3x font remains usable;
- no clipping;
- product name remains one line where practical.

## 6. Requirement / Selected Photo

### Buyer question
`What is my current photo, and what limit do I need?`

Primary visual:
`REAL SELECTED PHOTO`

Do not add decorative stock art.

Required:
- real thumbnail remains dominant visual context;
- size and dimensions remain readable;
- upload-limit controls remain compact;
- dedicated app mark persists only in app shell;
- optional subtle target/limit icon may support the `UPLOAD LIMIT` label;
- no separate large illustration.

Acceptance:
- selected image clearly feels like the user's object;
- controls are not pushed below useful viewport;
- real media, not decoration, provides visual richness.

## 7. Custom Limit

No new illustration required.

Improve only if needed for visual coherence:
- use the dedicated target/limit visual grammar;
- retain current Warm Ink dialog;
- keep inline validation;
- keep KB/MB segmented choice;
- no decorative image that competes with numeric entry.

## 8. Processing

### Buyer question
`Is my photo being processed safely?`

Primary visual:
`REAL SOURCE PHOTO`

Required:
- source photo remains full-frame Fit;
- indeterminate progress treatment;
- concise operation message;
- `Original untouched`;
- optional subtle processing halo/tonal frame that does not imply percentage.

Do not insert a generic illustration in place of the real selected photo.

Acceptance:
- state is visibly active;
- photo remains the primary object;
- no fake percentage/stages;
- no visual effect suggesting distortion/crop.

## 9. Result — PASS

### Buyer question
`Did it meet the size limit, and what can I do with the result?`

Primary visual:
`REAL RESULT PHOTO`

Required:
- result photo hero;
- success status icon from the coherent semantic icon family;
- large final size;
- exact-byte proof;
- Before/After using real source/result;
- Save primary;
- Share / Compress another secondary.

No extra decorative illustration.

Acceptance:
- actual output photo is visually dominant;
- status supports, not replaces, the image;
- page feels richer because of real media composition, not decoration.

## 10. Result — NOT_MET

Primary visual:
`REAL CURRENT RESULT PHOTO`

Required:
- warning status icon;
- actual output size;
- exact `>` proof;
- guidance:
  `Try a higher limit or a different photo.`
- real Before/After;
- `Save current copy`;
- Share / Compress another.

No sad-face/cartoon/failure illustration.

The emotional tone is calm and factual.

## 11. Result — REDUCED / ALREADY_SMALL

Primary visual:
`REAL RESULT PHOTO`

Required:
- neutral/info status icon;
- `SMALLER COPY`;
- explicit no-limit disclaimer;
- real Before/After;
- Save / Share / Compress another.

Do not use success-green semantics.

## 12. Inspecting / transient empty state

If the app is briefly reading the selected photo before a preview exists:
- a small branded media mark may be used;
- do not show a full generic hero again;
- transition quickly to real media.

## 13. Error state

No mandatory illustration.

If a visual is used:
- use a small coherent warning/repair motif;
- keep buyer recovery action primary;
- do not create a full decorative error page.

## 14. Asset manifest

Required implementation targets:

```yaml
visual_assets:
  brand_mark:
    proposed_resource: ic_brand_compress_frame
    required: true
    roles:
      - app_header
      - launcher_foreground_basis
  launcher:
    proposed_resources:
      - ic_launcher
      - ic_launcher_round
      - ic_launcher_foreground
      - ic_launcher_background
      - ic_launcher_monochrome_if_supported
    required: true
  home_hero:
    proposed_resource: ill_home_fit_to_limit
    type: LOCAL_VECTOR_OR_OWNED_LOCAL_RASTER
    required: true
    text_baked_in: false
  semantic_icons:
    required:
      - success
      - warning
      - info_or_reduced
      - target
      - download
      - share
      - repeat
  user_media:
    requirement: REAL_SOURCE_PHOTO
    processing: REAL_SOURCE_PHOTO
    result: REAL_RESULT_PHOTO
    before_after: REAL_SOURCE_AND_RESULT
```

## 15. Provenance / IP

Every new asset must be:
- original/project-owned;
- generated specifically for this product with project ownership/provenance recorded; or
- properly licensed for redistribution.

Do not copy competitor icons, compositions or illustrations.

Do not depend on remote runtime image URLs.

Record:
- asset source;
- author/generation method;
- license/provenance;
- file hash;
- resource path.

## 16. Performance constraints

Prefer vector for:
- mark;
- launcher foreground;
- semantic icons;
- simple hero illustration.

If raster is used:
- optimize dimensions/codec;
- no oversized source bundled without need;
- no visible decode jank;
- no network dependency.

Visual polish must not materially worsen first-open latency or memory.

## 17. Mockup fidelity matrix — mandatory

Before closure, compare actual runtime against the approved mockup direction for:

1. Home;
2. Requirement;
3. Custom Limit;
4. Processing;
5. PASS;
6. NOT_MET;
7. REDUCED.

For each:
- required visual objects;
- actual objects;
- intentional deltas;
- missing objects;
- placeholder-like objects;
- hierarchy;
- asset richness;
- visual signature;
- result = PASS / HOLD / REWORK.

## 18. Screenshot evidence set

Minimum actual runtime:
- launcher icon visible on emulator/device home/app launcher;
- Home 360×800;
- Home 320×640;
- Home 1.3x font;
- Requirement with real photo;
- Custom Limit;
- Processing with real photo;
- PASS;
- NOT_MET;
- REDUCED;
- Before/After landscape;
- Before/After portrait.

All evidence must bind to exact source/artifact hash.

## 19. Acceptance criteria

### VAC-01 Brand identity
Dedicated brand mark exists and is visually distinct from generic functional `ic_photo`.

### VAC-02 Launcher identity
App has explicit launcher icon resources and manifest/application packaging resolves them.

### VAC-03 Home hero
Purpose-built hero art communicates fit/reduce-to-limit without fake numbers or guarantees.

### VAC-04 Mockup fidelity
No material visual object from the approved direction is silently downgraded to placeholder treatment.

### VAC-05 Real-media priority
Requirement/Processing/Result use real buyer media where available.

### VAC-06 State coherence
PASS / NOT_MET / REDUCED have consistent but semantically distinct visual treatment.

### VAC-07 Small-width usability
320×640 remains usable; no hero causes action loss/clipping.

### VAC-08 Standard-width quality
360×800 first-open composition feels complete and balanced.

### VAC-09 Font scale
1.3x remains usable.

### VAC-10 Asset provenance
Every new visual asset has provenance/license record.

### VAC-11 Offline/local integrity
Core visual assets are packaged locally; no hidden remote dependency.

### VAC-12 Human premium-quality review
Human reviews the actual runtime implementation, not only mockup/source, and explicitly approves `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION`.

## 20. Explicit non-goals

Do not:
- change compression;
- change target semantics;
- add new formats;
- add onboarding carousel;
- add bottom navigation;
- add account/cloud;
- add animation-heavy scenes;
- add photos to every screen merely to fill space;
- change Play/signing state;
- upload anywhere.

## 21. Implementation gate

Current disposition:
`SPEC_READY / IMPLEMENTATION_NOT_AUTHORIZED`

Next material approval must explicitly authorize:
`TASK-S5-006 VISUAL ASSET COMPLETENESS IMPLEMENTATION`

After approval, Codex may:
- create local visual assets;
- wire launcher icon;
- replace generic Home artwork;
- apply minimal per-screen visual adjustments;
- build/test/capture evidence.

Protected domain source remains closed.
