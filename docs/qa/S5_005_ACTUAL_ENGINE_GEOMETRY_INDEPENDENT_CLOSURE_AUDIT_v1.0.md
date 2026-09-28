# S5-005 ACTUAL ENGINE GEOMETRY INDEPENDENT CLOSURE AUDIT v1.0

Observed: 2026-09-28
Reviewer: CHAT
Branch: `task/TASK-S5-005`
Actual-engine test commit: `c736a5d1e9beeb663b9bc336618171bbefe82a28`
Evidence closure: `3fc36df49da0616412efbe71425446626fd4c3af`

Disposition:
`GEOMETRY_ENGINE_PASS / HUMAN_VISUAL_FIT_REVIEW_PENDING`

## 1. Lineage

PASS.

- Required starting HEAD:
  `b7a19f5d56721b80c6ae95b5065f1a53a55ed110`
- Actual-engine test commit is one descendant.
- Evidence closure follows the test commit.
- No protected production compression/domain file is changed.

## 2. Actual production-engine invocation

PASS.

Harness:
`app/src/androidTest/java/com/afradadmedia/reducephotosize/GeometryProofInstrumentation.java`

The harness:
1. materializes real JPEG fixtures;
2. publishes them through MediaStore;
3. constructs production ImageInfo using oriented display dimensions;
4. invokes:
   `JpegCompressionEngine.compressKnown(getTargetContext(), info, target)`
5. obtains `actual.resultFile`;
6. retains the real output JPEG;
7. decodes the retained JPEG with BitmapFactory;
8. records actual decoded width/height;
9. records source/output SHA-256.

This satisfies the previous audit defect. It is not ScalePlanner-only proof.

## 3. Actual output matrix

PASS 10/10.

Observed actual engine cases:

- 1:1:
  1200×1200 → 720×720
  delta 0

- 3:2:
  2400×1600 → 720×480
  delta 0

- 2:3:
  1200×1800 → 480×720
  delta 0

- 4:3:
  1600×1200 → 720×540
  delta 0

- 3:4:
  1200×1600 → 540×720
  delta 0

- 16:9:
  1600×900 → 720×405
  delta 0

- 9:16:
  900×1600 → 405×720
  delta 0

- EXIF rotate-90:
  raw 1600×1200, display 1200×1600 → 540×720
  delta 0

- EXIF mirrored:
  display 2400×1600 → 720×480
  delta 0

- ALREADY_READY:
  640×480 → 640×480
  resized false
  delta 0
  source/output SHA-256 identical

All decoded outputs are within the binding tolerance; in fact all cross-product deltas are exactly zero.

## 4. Artifact binding

PASS.

All retained source/output JPEG files are present under:
`evidence/geometry/s5_005_actual_outputs/`

Repository byte sizes match the proof records.

`evidence/INDEX.json` independently binds full SHA-256 values for every retained source and output JPEG, and those SHA-256 values match the geometry proof JSON.

## 5. Resize truth

PASS.

Nine aggressive 1,000-byte target cases execute actual resize paths and return honest `NOT_MET` under the quality guard with `resized=true`.

The ALREADY_READY case separately proves the no-resize path.

The fact that aggressive cases finish NOT_MET does not weaken geometry proof: the retained files are the actual engine results after real resize and encode operations.

## 6. EXIF truth

PASS for required current matrix.

- Orientation 6 rotate-90 swaps display axes correctly before output comparison.
- Mirrored orientation 2 is exercised and output display geometry remains proportional.
- No protected EXIF/compression production source changed.

## 7. Hard invariant disposition

Binding contract:
`docs/product/IMAGE_GEOMETRY_PRESERVATION_CONTRACT_v1.0.md`

Actual output geometry:
`PASS`

Observed stretch/squash at file geometry level:
`NONE`

Cross-product delta:
`0 for all 10 mandatory cases`

Compression-engine change required:
`NO`

Protected engine remains frozen.

## 8. Presentation policy

Source-level Fit policy was already accepted:
- Processing: Fit
- Result hero: Fit
- Before/After: Fit
- Requirement thumbnail: Crop allowed

The remaining gate is direct visual inspection of the new geometry-final screenshots to ensure the full-frame Fit presentation is visually acceptable and no UI crop/stretch perception remains.

## 9. Final status

Actual production-engine geometry:
PASS

Artifact-bound geometry evidence:
PASS

Replayable harness:
PASS

NOT_MET source fidelity:
PASS

Human visual Fit review:
PENDING

No signing, Play upload, S6, BUILD promotion, Artifact Freeze, release, or publication.
