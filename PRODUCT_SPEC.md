# PRODUCT_SPEC.md

## Product Identity
Canonical name: UPLOAD-READY IMAGE COMPRESSOR
Package name: com.uploadready.app
Primary market: Global Android users encountering website/form image upload-size limits
Primary language: English MVP

## Buyer
Primary buyer: A user who has a photo that must satisfy a website/form file-size limit.
Entry context: The buyer already has the photo and encounters a concrete KB/MB upload requirement.
Painful job: Produce a usable photo that actually satisfies the known upload limit and make the result easy to save/share.
First-value event: After choosing a photo, the app detects CURRENT size/dimensions locally and helps the user specify REQUIRED limit.
Repeat-use trigger: Another website/form requires a photo below a specific KB/MB limit.

## Core Promise
Primary promise: Know it's ready before you upload.
Supporting promise: Compress toward the upload limit, verify the actual result, and tell the user honestly whether it meets the requirement.

## UKDC
Buyer definitely has: A photo.
Buyer definitely knows: They need a smaller/acceptable upload file; for the verified path, the website/form limit.
Buyer may not know: Current file size/dimensions before selecting the photo.
System can detect: CURRENT file size, dimensions, and supported format locally where available.
System can derive: Actual RESULT bytes after processing and whether RESULT <= REQUIRED.
External information required: The website/form upload limit for a verified PASS.
Fallback if unknown: REDUCED only; never PASS / UPLOAD READY.

## Core Scope
- F-01: Target limit selection: 50 KB, 100 KB, 200 KB, 500 KB, 1 MB, Custom KB/MB.
- F-02: Photo selection using scoped Android APIs with minimal permission surface.
- F-03: Local on-device compression.
- F-04: MVP minimum JPEG/JPG input and JPEG/JPG output.
- F-05: Actual output-byte verification.
- F-06: Explicit PASS / NOT MET state.
- F-07: Quality guard for material degradation.
- F-08: Output preview with CURRENT / REQUIRED / RESULT facts.
- F-09: Original preservation; never overwrite source by default.
- F-10: Save a new copy with deterministic naming and clear location.
- F-11: Visible Share action.
- F-12: Open saved location / equivalent where supported.
- F-13: Metadata behavior disclosure.
- F-14: Offline/local-first core compression.
- F-15: Minimal-permission posture.

## Explicit Non-Scope
- batch compression / Select All
- PDF tools
- crop / rotate / filters
- image enhancement / AI features
- passport templates
- signature presets
- social-media templates
- background removal
- cloud image processing
- file-manager behavior
- EXIF editor
- production AdMob integration during this S3 technical pilot

## State Semantics
CURRENT: Observed source file size/dimensions/format.
REQUIRED: User-provided external website/form limit.
RESULT: Actual output bytes/dimensions from the produced artifact.
PASS: Only when a known REQUIRED limit exists and actual RESULT bytes <= REQUIRED.
NOT_MET: A known limit exists but RESULT bytes remain above REQUIRED after bounded processing.
REDUCED: Unknown-limit path; a smaller usable copy was produced but upload compatibility is not verified.
ERROR: Processing did not produce a valid verified output.

## Data / Storage
Inputs: User-selected JPEG/JPG for minimum MVP proof.
Outputs: New result file; actual output byte count must be re-read from the output artifact.
Persistence: Save only after explicit save flow; share grants must be scoped/read-only.
Reset/delete: No destructive source reset required for this pilot.
Original preservation: Source image must never be overwritten.

## Permissions
Required: None beyond scoped file/photo access needed by the selected Android API.
Optional: Only if a proven feature requirement later needs it.
Forbidden unless re-approved: Broad storage/media permissions, unnecessary network/image upload permissions.

## Privacy
Local-only behavior: Core inspect/compress/verify/save/share workflow is local-first.
Network behavior: Not required for core job.
Analytics: Not part of this S3 pilot.
Sensitive data: Image content remains local; do not transmit it.
Ads data boundary: AdMob is out of scope until core technical proof is green.

## Monetization
Primary model: ADMOB (future MVP monetization layer, not this S3 pilot)
Allowed surfaces: Deferred until the core buyer job has real Android evidence.
Forbidden surfaces: No ad may block CURRENT detection, result proof, Save, or Share.
First-value protections: No monetization before first verified buyer value.
Ad failure behavior: Core job must remain usable.
Consent/UMP applicability: Revalidate from current official requirements before integration.

## Compatibility
minSdk: 29
targetSdk: 36
compileSdk: 36
Form factors: Phone-first vertical slice.
Offline behavior: Core job must work offline.
Localization: English MVP; localization deferred.

## Support Boundary
Self-service recovery: Clear ERROR / NOT_MET paths; original remains safe.
Unsupported cases: Non-JPEG formats unless explicitly added and verified.

## Kill Criteria
- Core target-fit behavior cannot be made reliable on representative Android environments.
- Actual-byte verification cannot reliably support PASS semantics.
- Original-preservation cannot be guaranteed.
- Real implementation requires disproportionate maintenance/support.
- Later behavioral validation shows no meaningful trust/value distinction from generic compressors.

## Market-Validated Defect Prevention
Current public review intelligence is maintained in `docs/market/MARKET_REVIEW_INTELLIGENCE_v1.0.md`.

Binding product controls derived from that evidence:
- Never weaken actual-byte PASS semantics to satisfy an "exact KB" marketing claim.
- Never imply that every target can always be reached; NOT_MET is a valid truthful outcome.
- Treat Save and Share as core-job completion; output retrieval/location clarity is material.
- Treat silent waiting, unclear progress, and unrecoverable errors as buyer-job defects.
- Preserve the quality guard rather than silently destroying quality to reach an extreme target.
- Protect first verified value from ads/paywalls/subscription prompts or manufactured friction.
- Keep batch/Select-All and general image-toolbox expansion outside MVP unless separately approved.

S6 must exercise these controls on real distributed builds. Market evidence informs defect prevention and positioning; it does not independently authorize feature expansion.

## Source of Truth
Full frozen candidate PDC: `docs/product/UPLOAD_READY_IMAGE_COMPRESSOR_PDC_MVP_SPEC_v1.2.0_PHOTO_FIRST_UKDC_CANDIDATE.md`.
This file is a concise execution projection and must not weaken the PDC.
