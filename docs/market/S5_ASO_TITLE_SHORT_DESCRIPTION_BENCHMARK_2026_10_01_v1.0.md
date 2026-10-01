# S5 ASO TITLE + SHORT DESCRIPTION BENCHMARK — 2026-10-01

Product: REDUCE PHOTO SIZE: KB LIMIT
Scope: English Google Play title + short-description naming decision before Create app submission.
Evidence class: current Google Play listings + official Google Play metadata guidance + existing product/review intelligence.
Decision authority: USER_OPTION_3_2026-10-01_ASO_BENCHMARK_THEN_FREEZE_NAME

## Official constraints

- Play app title: maximum 30 characters.
- Short description: maximum 80 characters.
- Metadata must be accurate, clear, non-misleading, non-repetitive, and should avoid keyword stuffing.
- Title should describe functionality while remaining sufficiently distinctive.
- Short description should foreground the largest buyer benefit / unique value.

## 20-title benchmark sample

1. Photo Compressor and Resizer
2. Compress Photo Size - MB to KB
3. Compress Image Size In kb & mb
4. JPEG Image Compressor & Resize
5. Photo & Picture Resizer
6. Image Size - Photo Resizer
7. Puma: Photo Resizer Compressor
8. Photo Compressor: Resize KB
9. Exact KB Photo Compressor
10. Photo Compressor: Resize in KB
11. Photo Resizer & Compressor
12. Compress Image Size: KB & MB
13. Image Compressor – KB & MB
14. Photo Compressor: Size Limit
15. Photo Compressor: KB Size
16. Photo to KB – Compress & Resize
17. Image Compressor - MB to KB
18. Image Compressor: KB/MB Limit
19. Photo Size Reducer
20. FormReady: Photo to Exact KB

Sample title-token prevalence (descriptive sample only; NOT query-volume data):
- photo: 14/20
- compressor: 12/20
- KB: 12/20
- size: 7/20
- image: 7/20
- MB: 6/20
- resizer: 5/20
- compress: 4/20
- exact: 2/20
- limit: 2/20

## Market-anchor evidence

Established/high-install listings show strong buyer/category recognition for:
- Photo / Image
- Compressor / Compress
- Size
- Resizer
- KB / MB

Examples observed:
- Photo & Picture Resizer: 10M+ installs
- Compress Image Size In kb & mb: 10M+ installs
- Image Size - Photo Resizer: 10M+ installs
- Photo Compressor and Resizer: 1M+ installs
- Compress Photo Size - MB to KB: 1M+ installs
- JPEG Image Compressor & Resize: 1M+ installs
- Puma: Photo Resizer Compressor: 1M+ installs

Install counts are category-demand signals only. They do not prove keyword search volume, keyword ranking causality, or conversion rate.

## Direct-job competitor pattern

New/direct competitors increasingly use target-size language:
- exact KB
- KB size
- KB/MB limit
- size limit
- MB to KB
- 50/100/200/500 KB
- forms/uploads

This confirms that strict file-size targeting is an active competitive positioning axis.

## Short-description pattern benchmark

Recurring short-description/value patterns:
1. category utility: compress + resize;
2. target-size control: chosen KB/MB / exact KB;
3. use case: forms, applications, uploads, email;
4. trust/privacy: offline / on-device / originals preserved;
5. output proof: before/after size or verified final size;
6. toolbox expansion: crop, convert, batch, passport/social presets.

Our product should NOT follow the toolbox-expansion pattern in MVP. The current spec intentionally excludes batch, crop, passport templates, converters, PDF, signatures, and similar scope.

## Product-truth constraint

The app contract is:
- user provides a maximum upload limit;
- PASS only when actual bytes <= required bytes;
- NOT_MET is valid when the bounded compressor cannot safely meet the target;
- REDUCED is used when no known upload limit is supplied;
- exact bytes are the canonical proof.

Therefore, avoid title/short-description claims that imply:
- guaranteed exact-equality to the requested KB value;
- universal success at every target;
- conversion from MB to KB as the core product model.

"Exact KB" is competitively common but materially stronger than the product contract. It is rejected for the frozen title.

"MB to KB" has strong category recognition but is semantically weaker for this product because:
- the source may already be measured in KB;
- the job is satisfying a maximum upload limit, not unit conversion;
- it is highly crowded in competitor titles.

## Candidate evaluation

### A — Reduce Photo Size: KB Limit
Characters: 27
Pros:
- accurate;
- buyer-readable;
- preserves prior identity.
Cons:
- weaker established category anchor than "Photo Compressor";
- uses more generic reduction wording;
- less directly aligned with the dominant compressor category label.

### B — Photo Compressor: KB Limit
Characters: 26
Pros:
- combines the strongest sampled category anchor ("Photo" + "Compressor");
- adds the lower-frequency differentiator "KB Limit";
- accurately matches maximum-limit semantics;
- avoids "Exact KB" overclaim;
- avoids crowded "MB to KB" framing;
- leaves short description free to express local processing and exact-byte proof.
Cons:
- category phrase is generic and structurally similar to several competitors; differentiation must come from "KB Limit", icon, screenshots, and proof-oriented short description.

### C — Compress Photo: KB Limit
Characters: 24
Pros:
- action-oriented and accurate.
Cons:
- less natural noun-category framing than "Photo Compressor";
- weaker fit with established high-install category naming pattern.

### D — Photo Compressor: Upload Limit
Characters: 30
Pros:
- very close to the buyer job.
Cons:
- consumes the full title limit;
- loses the explicit high-signal "KB" token;
- "upload limit" is less common in competitor titles.

## Frozen Play title

`Photo Compressor: KB Limit`

Status:
`FROZEN_FOR_PLAY_CREATE_APP_EN_US`

Launcher / in-app label remains:
`Reduce Photo Size`

Package remains:
`com.afradadmedia.reducephotosize`

No source-code mutation is required solely for the Play title.

## Recommended short description

`Set a KB limit, compress locally, and verify the final file in exact bytes.`

Character count:
75 / 80

Status:
`ASO_SHORT_DESCRIPTION_CANDIDATE_V1`

Why:
- does not merely repeat the title;
- exposes the differentiator: exact-byte verification;
- preserves truthful maximum-limit semantics;
- includes local processing as a trust signal;
- avoids guarantees of exact-equality;
- avoids unsupported toolbox features.

## Keyword architecture

Title anchors:
- Photo
- Compressor
- KB
- Limit

Short-description anchors:
- KB limit
- compress
- locally
- verify
- exact bytes

Full-description/supporting vocabulary later:
- reduce photo size
- image size
- MB to KB (as natural buyer vocabulary, not as a conversion promise)
- upload limit
- online form
- application
- file too large
- 50 KB / 100 KB / 200 KB / 500 KB / 1 MB
- original preserved
- on-device
- save / share
- PASS / NOT_MET truth

Do not mechanically repeat these phrases.

## Evidence limits

UNKNOWN:
- Google Play does not publicly expose query-level search volume or conversion by keyword.
- Competitor installs/reviews do not prove which title token caused discovery.
- This benchmark cannot prove that the frozen title will rank above alternatives.

The decision is a best-fit synthesis of:
- observed category language;
- competitor scale signals;
- direct buyer-job semantics;
- Google metadata constraints;
- product-truth constraints;
- differentiation and support-prevention.
