# MARKET_REVIEW_INTELLIGENCE_v1.0

Observed: 2026-09-27
Scope: Android photo/image compression utilities relevant to strict website/form upload-size limits.
Purpose: Convert current public review evidence into buyer-language, product constraints, defect-prevention controls, and S6 test obligations.
Evidence class: public marketplace reviews/listings + model inference. This is not a statistically representative review census.

## FACT — Review / Listing Signals

### R1 — Ad and subscription friction can destroy a simple utility flow
- Compress Image - MB to KB has recent reviews complaining about long video ads, automatic audio, repeated onboarding/subscription pressure, and difficulty locating the free path.
- Puma: Photo Resizer Compressor has reviews describing lengthy/unskippable/loud ads as making the utility unusable.
Sources:
- https://play.google.com/store/apps/details?id=com.psoffritti.compress.image
- https://play.google.com/store/apps/details?id=com.compressphotopuma

### R2 — Users care about actual target-size truth
- Competitor listings strongly market target sizes such as 50/100/200/500 KB and MB-to-KB conversion.
- Public reviews in this category include complaints that outputs do not behave as expected, including reports of files becoming larger after processing.
Source:
- https://www.appbrain.com/app/photo-compressor-and-resizer/com.photocompress.photoeditor

### R3 — Save/output-location confusion is a real failure mode
- A Compress Image - MB to kB review reports difficulty locating compressed outputs and says the save location should be clearer.
- The same listing includes a job-application upload use case, showing the real job continues beyond compression into successful file retrieval/upload.
Source:
- https://play.google.com/store/apps/details?id=aculix.bulk.image.compressor

### R4 — Simple and fast is valued
- Current Indonesian reviews for Puma explicitly praise ease of use and speed for reducing photo size.
Source:
- https://play.google.com/store/apps/details?hl=id&id=com.compressphotopuma

## INFERENCE — Product Implications

I1. The core job is not "compress an image"; it is "make a photo acceptable for an external upload constraint, verify the result, then give me the usable file."

I2. A truthful NOT_MET state is a trust feature. The product must never imply guaranteed exact-KB success when the artifact remains above REQUIRED.

I3. Save and Share are core-job completion actions, not secondary conveniences. Output location must be understandable.

I4. First-value friction must stay low. The primary path should remain:
Choose photo -> CURRENT -> REQUIRED -> Process -> verified RESULT -> Save/Share.

I5. Monetization must not interrupt the path above. Ads/paywalls before first verified value would recreate a documented competitor complaint pattern.

I6. Quality guard is preferable to silently destroying output quality to hit an extreme target.

I7. Batch/Select-All has demand signals in the category but remains out of MVP scope because it materially increases memory, progress, cancellation, multi-output, and support complexity.

## UNKNOWN / EVIDENCE LIMITS
- Public review samples are not a representative statistical sample of the entire market.
- Public Google Play data does not expose query-level keyword volume or conversion rate.
- Review complaints do not establish prevalence percentages.
- WTP for ad-free, one-time, or subscription models remains unvalidated for this product.

## Buyer Vocabulary To Preserve
Problem:
- photo too large
- file too big
- MB to KB
- target size
- upload limit
- form/application

Success:
- works
- quick
- simple
- accurate
- under the limit
- easy to save/share

Failure:
- wrong size
- still too large
- became larger
- cannot find result
- cannot save/share
- too many ads
- slow / unclear progress

## Defect-Prevention Controls

### MR-C01 — Truthful target result
PASS only when actual RESULT bytes <= known REQUIRED bytes.
Aggressive targets that cannot be safely met must return NOT_MET.

### MR-C02 — No absolute "exact size guaranteed" claim
Store/UI copy must not imply every target can always be reached.

### MR-C03 — Result-size sanity
For a source that requires compression, unexpected output growth is a material defect unless explicitly justified and disclosed.
Already-ready files should avoid unnecessary recompression.

### MR-C04 — Save discoverability
After a successful result, Save must be visible and the saved destination/result must be understandable and verifiable.

### MR-C05 — Share discoverability
Share must be visible from the result state and must share the actual produced artifact.

### MR-C06 — Visible progress / recovery
No silent waiting during inspect/compression/save. Errors must provide a usable recovery path.

### MR-C07 — Quality / orientation safety
No silent orientation/color corruption. Extreme target pursuit must respect the quality guard.

### MR-C08 — First-value protection
No ad, paywall, subscription prompt, or manufactured step may block:
Choose -> CURRENT -> REQUIRED -> Process -> Result proof -> Save/Share.

### MR-C09 — Offline/privacy truth
Core job remains usable without network and image content stays local for the current scope.

### MR-C10 — Scope discipline
Batch, PDF, converter, passport, crop, AI, and other toolbox features do not enter MVP merely because competitors offer them.

## S6 Required Coverage
The S6 internal-test plan must explicitly cover MR-C01 through MR-C09 on real distributed builds. MR-C10 is enforced as scope governance rather than a runtime test.

## Decision Use
This artifact informs product, UX, ASO, S6 testing, and later AdMob placement. It does not independently authorize scope expansion, BUILD promotion, AdMob integration, release, or publication.
