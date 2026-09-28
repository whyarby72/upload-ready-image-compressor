# IMAGE GEOMETRY PRESERVATION CONTRACT v1.0

Status: **BINDING / HARD PRODUCT INVARIANT**
Product: **REDUCE PHOTO SIZE: KB LIMIT**
Bound: 2026-09-28
Authority: explicit human decision in chat
Scope: compression output geometry + truth-critical image presentation

## 1. Non-negotiable invariant

Compression may change:
- encoded byte size;
- JPEG quality;
- pixel dimensions when proportional downscaling is required.

Compression MUST NOT change the visual geometry of the image.

Therefore the output MUST NOT:
- stretch horizontally;
- stretch vertically;
- squash / flatten;
- widen / narrow disproportionately;
- crop pixels to satisfy a file-size target;
- pad pixels into the saved JPEG to force a different aspect ratio;
- use different X and Y scale factors.

Canonical rule:

> **Same image geometry, fewer bytes.**

## 2. Canonical aspect ratio

All ratio comparisons are based on **display-oriented dimensions after EXIF orientation is applied**.

Let:
- source display width = W0
- source display height = H0
- output display width = W1
- output display height = H1

If no resize is needed:
- displayed aspect ratio MUST be unchanged;
- copied source may retain original EXIF metadata.

If resize is needed:
- W1 and H1 MUST be derived from one uniform scale factor;
- integer-pixel rounding is permitted;
- only rounding-level ratio drift is permitted;
- anisotropic scaling is forbidden.

Engineering acceptance for integer rounding:

`abs(W1 * H0 - H1 * W0) <= W0 + H0`

AND the implementation must demonstrate that both dimensions came from the same scale operation / source ratio, not from independent target dimensions.

This tolerance exists only for integer-pixel rounding. It is not permission for visible distortion.

## 3. Output-file rules

The compression engine MUST:
- resize the full oriented bitmap;
- preserve the full image content;
- use uniform scale;
- encode the resulting full bitmap as JPEG;
- keep output dimensions >= 1 px;
- never center-crop or edge-crop as a compression strategy.

The current verified engine already scales width and height from the same scale factor. That behavior is now a frozen invariant.

If any new test proves a geometry violation, STOP. Do not silently rewrite protected compression/domain code without separate material approval.

## 4. EXIF / orientation

Orientation transforms may:
- rotate;
- flip;
- transpose;
- transverse

only as needed to reproduce the source's intended displayed orientation.

They MUST NOT introduce nonuniform scale.

For orientation 90/270/transpose/transverse, display width/height may swap; the resulting display aspect ratio remains equivalent.

## 5. UI anti-distortion rule

No application preview may visually stretch an image.

Forbidden:
- `ContentScale.FillBounds`;
- unequal scaleX / scaleY;
- forced width + height rendering that ignores intrinsic ratio;
- any custom transform that changes X/Y scale differently.

## 6. Truth-critical preview policy

### Requirement thumbnail
Purpose: identify the selected photo.

Allowed:
- `ContentScale.Crop`

Reason:
thumbnail context is not the authoritative before/after geometry proof.

It must not modify the actual file.

### Processing preview
Purpose: maintain source context during compression.

Required:
- `ContentScale.Fit`

Show the complete frame.
Letterbox/pillarbox space uses Warm Ink subtle surface.

### Result hero
Purpose: authoritative visual representation of the produced file.

Required:
- `ContentScale.Fit`

The complete output frame MUST be visible.
No crop.

### Before / After comparison
Purpose: prove visually that the image geometry/content is preserved.

Required for BOTH source and output:
- `ContentScale.Fit`
- equal comparison container policy;
- complete image visible;
- no crop;
- no stretch.

If source/output aspect ratios differ beyond permitted pixel rounding, the gate FAILS.

## 7. Deterministic geometry regression set

Minimum fixtures:
1. square 1:1
2. landscape 3:2
3. portrait 2:3
4. landscape 4:3
5. portrait 3:4
6. landscape 16:9
7. portrait 9:16
8. EXIF rotate-90 source
9. EXIF mirrored source where supported by existing fixture pipeline

For each applicable fixture:
- force a compression path that actually resizes;
- record source display dimensions;
- record output display dimensions;
- compute ratio/cross-product invariant;
- verify no crop;
- verify output decodes successfully.

Also cover an ALREADY_READY/no-resize path.

## 8. Required evidence

Create a machine-readable geometry proof containing for each fixture:
- fixture;
- source display W x H;
- output display W x H;
- source ratio;
- output ratio;
- cross-product delta;
- allowed rounding tolerance;
- resized true/false;
- state;
- PASS/FAIL.

A geometry PASS cannot be inferred only from code review.

## 9. Visual evidence

Capture at minimum:
- landscape source/result comparison;
- portrait source/result comparison;
- square source/result comparison.

The Result hero and Before/After must visibly show the complete frame.

Use a fixture with visually obvious edge content so crop/stretch would be detectable. A homogeneous texture-only image is insufficient for the final visual geometry proof.

## 10. Gate

Any of the following is a blocking FAIL:
- visible stretch;
- source/output X/Y scale factors materially differ;
- result crop hides source edges;
- output ratio differs beyond integer-rounding tolerance;
- evidence uses only a homogeneous image that cannot reveal distortion;
- semantic metadata claims geometry preservation without decoded output-dimension proof.

This contract is binding for all later builds and supersedes any weaker preview behavior.
