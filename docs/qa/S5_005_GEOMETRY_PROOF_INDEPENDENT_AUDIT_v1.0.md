# S5-005 GEOMETRY PROOF INDEPENDENT AUDIT v1.0

Observed: 2026-09-28
Reviewer: CHAT
Branch: `task/TASK-S5-005`
Source commit: `285ce9fd724678da4a1097b6d4d3b74c6a734f54`
Evidence closure: `cbf33ad6920a93db520536d885c94836779f1f8e`

Disposition:
`UI_PRESENTATION_PASS / NOT_MET_FIDELITY_PASS / GEOMETRY_PROOF_REWORK_REQUIRED`

## 1. Source scope

PASS.

Source changes from the bound starting HEAD are limited to:
- `MainActivity.kt`
- new test `GeometryPreservationTest.java`

Protected compression/domain source is unchanged.

## 2. Preview presentation

PASS at source.

Observed policy:
- Requirement thumbnail: `ContentScale.Crop`
- Processing: `ContentScale.Fit`
- Result hero: `ContentScale.Fit`
- Before source: `ContentScale.Fit`
- After/result: `ContentScale.Fit`

No FillBounds or anisotropic UI scaling is introduced.

## 3. NOT_MET fidelity

PASS at source/evidence level.

Observed:
- guidance: `Try a higher limit or a different photo.`
- primary save label for NOT_MET: `Save current copy`
- PASS/REDUCED retain `Save copy`

The final NOT_MET proof records the required semantic tokens.

## 4. Geometry test defect

FAIL for the bound hard geometry contract.

`GeometryPreservationTest.java` does not exercise the actual JPEG compression engine.

It only calls:
`ScalePlanner.scaledDimension(width, scale)`

with synthetic dimensions and fixed synthetic scale factors.

Therefore it proves:
- the pure scale-planner formula is proportional under those inputs;

but it does NOT prove:
- `JpegCompressionEngine.compressKnown()` / reduction path actually emits a JPEG with the expected decoded dimensions;
- EXIF-oriented source geometry is preserved through real decoding + resizing + encoding;
- actual output files preserve full-frame geometry;
- no future integration bug around decode/orient/encode changes the real output ratio.

## 5. Geometry proof JSON defect

`evidence/geometry/S5_005_GEOMETRY_PROOF.json` is insufficient against the binding contract.

Examples:
- `display_result = "2400x1600-or-scaled-uniformly"`
- `display_result = "1200x1600-or-scaled-uniformly"`

These are assertions/placeholders, not observed decoded output dimensions.

Missing per-fixture required fields include:
- actual decoded output width;
- actual decoded output height;
- source ratio numeric value;
- output ratio numeric value;
- cross-product delta;
- allowed integer-rounding tolerance;
- resized true/false from actual run;
- actual output JPEG SHA-256;
- actual engine state;
- explicit PASS/FAIL derived from observed dimensions.

## 6. Required fixture coverage is incomplete

Binding contract requires at minimum:
1. 1:1
2. 3:2
3. 2:3
4. 4:3
5. 3:4
6. 16:9
7. 9:16
8. EXIF rotate-90
9. mirrored EXIF where supported
10. ALREADY_READY/no-resize path

Current proof JSON records only:
- 3:2
- 3:4
- 1:1
- EXIF orientation 6
- 4:3 already-ready

The 2:3, 16:9, 9:16 and mirrored-orientation runtime/output proof is absent.

The unit test contains synthetic 2:3/16:9/9:16 inputs, but again this is ScalePlanner-only and does not substitute for actual engine output.

## 7. TEST_MATRIX overclaim

Current row `S5-24` states:

`Decoded output preserves display ratio with uniform scale`

But the bound evidence does not contain actual decoded output dimensions sufficient to substantiate that claim.

Disposition:
`FALSE_POSITIVE / REOPEN`

## 8. Required repair

This is TEST/EVIDENCE ONLY unless real engine output fails.

Do not modify protected compression/domain source.

Run actual production engine on deterministic JPEG fixtures and then decode each output JPEG.

For each fixture record:
- source EXIF-oriented display W0/H0;
- actual decoded output W1/H1;
- source/output ratios;
- `delta = abs(W1*H0 - H1*W0)`;
- `tolerance = W0 + H0`;
- resized flag;
- compression state;
- source/output byte sizes;
- output JPEG SHA-256;
- PASS iff delta <= tolerance and full-frame output is decoded without crop/stretch.

At least one path for each required ratio must force a real resize where practical.

Retain an ALREADY_READY path separately.

For EXIF:
- prove post-orientation display dimensions;
- include rotate-90;
- include mirrored orientation if current fixture/test pipeline supports it.

If actual production engine violates the invariant:
STOP.
Do not change protected engine source without new explicit human approval.

## 9. Evidence output

Replace/upgrade:
`evidence/geometry/S5_005_GEOMETRY_PROOF.json`

Add actual engine-output JPEGs or equivalent replayable output artifacts under:
`evidence/geometry/s5_005_actual_outputs/`

Each output should be hash-bound.

Update TEST_MATRIX so S5-24 is PASS only after actual decoded-output proof exists.

## 10. Gate

UI Fit policy:
PASS

NOT_MET fidelity:
PASS

Build/tests:
PASS as operator evidence

Geometry engine implementation:
NOT FAILED

Geometry artifact proof:
FAIL / REWORK REQUIRED

Final geometry gate:
HOLD

No signing, Play upload, S6, BUILD promotion, Artifact Freeze, release, or publication.
