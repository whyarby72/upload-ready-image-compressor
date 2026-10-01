# S5 ASO SHORT DESCRIPTION + FULL DESCRIPTION KEYWORD ARCHITECTURE AUDIT — 2026-10-01

Product: PHOTO COMPRESSOR: KB LIMIT
Play title en-US: `Photo Compressor: KB Limit`
Launcher label: `Reduce Photo Size`
Package: `com.afradadmedia.reducephotosize`

Scope:
- audit short-description wording after the title refreeze;
- audit full-description keyword architecture;
- keep all copy inside current product truth;
- do not expand MVP scope.

## Official Google Play constraints

- App title: max 30 characters.
- Short description: max 80 characters.
- Full description: max 4,000 characters.
- Metadata must be accurate, clear, concise, non-misleading, and not keyword-stuffed.
- Short description should communicate the app's biggest benefit / unique value quickly.
- Full description should not simply repeat the short description.

## Current category/competitor patterns observed

Large/category incumbents commonly emphasize:
- photo / image;
- compressor / compress;
- resize / reducer;
- KB / MB;
- desired file size;
- quick/simple output.

Direct target-size competitors commonly emphasize:
- chosen KB/MB maximum;
- 50/100/200/500 KB and 1 MB;
- forms / applications / uploads;
- local/on-device processing;
- before/after file size;
- save/share;
- original preservation;
- "exact KB" claims.

## Product-truth filter

Allowed factual claims:
- user can choose 50 KB, 100 KB, 200 KB, 500 KB, 1 MB, or custom KB/MB limit;
- core compression runs locally/on-device;
- exact output bytes are re-read and used for PASS/NOT_MET truth;
- PASS only if actual result bytes <= known required bytes;
- NOT_MET is a valid truthful outcome;
- unknown-limit path returns REDUCED, not PASS;
- original photo is not overwritten by default;
- result can be saved/shared;
- JPEG/JPG is the minimum MVP format.

Do not claim:
- guaranteed exact equality to the chosen KB value;
- guaranteed success at every target;
- batch compression;
- PNG/WebP output;
- passport/visa presets;
- crop/rotate/filter/toolbox features;
- "no ads" or "ad-free";
- no-internet requirement for the future monetized app as an absolute store-wide claim after AdMob integration;
- government affiliation;
- performance/ranking claims such as "#1", "best", "fastest".

## Short-description audit

Previous candidate:
`Set a KB limit, compress locally, and verify the final file in exact bytes.`

Assessment:
- truthful;
- strong privacy/trust cue;
- exposes exact-byte verification;
- but starts with a configuration action ("Set") rather than the buyer outcome;
- does not explicitly say "photo" in the body copy;
- "locally" is useful but can be moved to full description because the title already supplies the category.

### Candidate A
`Compress photos under a KB limit and verify the final size in exact bytes.`
Length: 74/80

Strengths:
- immediately states buyer action and outcome;
- contains natural "compress photos" language;
- preserves KB-limit semantics;
- exposes exact-byte verification;
- does not imply exact-equality to target;
- no unsupported feature claim.

### Candidate B
`Meet KB upload limits with exact-byte verification and on-device compression.`
Length: 77/80

Strengths:
- strongest upload-job framing;
- includes trust/privacy cue;
- compact.

Weakness:
- less natural category/action phrasing than Candidate A;
- "meet" can read as universal success even though NOT_MET exists.

### Candidate C
`Compress photos for upload limits, then verify the final size in exact bytes.`
Length: 77/80

Strengths:
- explicit upload-job language;
- exact-byte differentiation.

Weakness:
- less explicit about KB in the short description.

## Recommended short description

`Compress photos under a KB limit and verify the final size in exact bytes.`

Status:
`RECOMMENDED_FOR_FREEZE`

Reason:
It combines category language, target-limit semantics, and the strongest defensible trust differentiator without overclaiming universal exact-KB success.

## Full-description keyword architecture

Goal:
Use natural buyer vocabulary and semantic coverage, not mechanical repetition.

### Layer 1 — Opening problem + promise
Purpose:
Explain the buyer job in the first 2–3 sentences.

Primary terms:
- photo compressor
- KB limit
- upload limit
- file too large
- exact bytes

Message:
A website/form rejects a photo because it is too large. Choose the maximum KB/MB limit, compress locally, and verify the actual output size before saving or sharing.

### Layer 2 — How it works
Purpose:
Explain the real workflow.

Natural terms:
- choose photo
- current file size
- target size
- compress photo
- result size
- save
- share

Workflow:
Choose photo -> inspect CURRENT -> choose REQUIRED -> compress -> verify RESULT -> Save/Share.

### Layer 3 — Target-size controls
Purpose:
Capture concrete high-intent size vocabulary.

Natural terms:
- 50 KB
- 100 KB
- 200 KB
- 500 KB
- 1 MB
- custom KB
- custom MB
- reduce photo size
- image size

Important:
Describe these as maximum limits, not guaranteed exact-equality outputs.

### Layer 4 — Truth / verification differentiation
Purpose:
Make the product defensible versus generic compressor copy.

Natural terms:
- exact output bytes
- under the limit
- PASS
- NOT MET
- verified result
- actual file size

Message:
The app re-checks the produced file. It only claims PASS when actual result bytes are <= the chosen limit. If the target cannot be safely reached, it reports NOT_MET.

### Layer 5 — Use cases
Purpose:
Capture buyer-context language.

Natural terms:
- online form
- application
- job application
- website upload
- email attachment
- portal
- file-size limit

Avoid:
government-specific/passport/visa claims unless separately implemented and verified.

### Layer 6 — Privacy / file safety
Purpose:
Trust and support prevention.

Natural terms:
- on-device
- local processing
- original preserved
- new copy
- no source overwrite

After AdMob integration:
Do not say the whole app is "offline" or "no internet" without qualification. Safer future wording:
`Photo compression itself runs on your device; your selected photo is not uploaded for compression.`

### Layer 7 — Save/share completion
Purpose:
Close the buyer job.

Natural terms:
- save compressed photo
- share result
- new copy
- final file

### Layer 8 — Supported-format truth
Purpose:
Prevent support mismatch.

MVP wording:
`JPEG/JPG is supported in the current release.`

Do not imply support for PNG/WebP/HEIC/PDF until implemented and tested.

## Keyword tiers

### Tier A — must appear naturally
- photo compressor
- KB limit
- compress photo / compress photos
- upload limit
- exact bytes / exact file size verification

### Tier B — use where contextually natural
- reduce photo size
- image size
- target size
- file too large
- 50 KB
- 100 KB
- 200 KB
- 500 KB
- 1 MB
- custom KB / MB
- save / share

### Tier C — buyer vocabulary allowed but do not over-optimize
- MB to KB
- photo size reducer
- image compressor
- online form
- job application
- email attachment

"MB to KB" may appear once as buyer vocabulary, e.g.:
`Useful when a large photo needs to fit a KB or MB upload limit.`
Do not frame the product as a unit converter.

## Full-description recommended section order

1. Opening buyer problem + product promise
2. How it works
3. Choose your KB/MB limit
4. Verified result: PASS / NOT_MET
5. Save and share
6. On-device photo processing + original preservation
7. Common use cases
8. Supported format / honest limitations

## Anti-patterns to avoid

- keyword chains such as "photo compressor, image compressor, photo reducer, image reducer, MB to KB converter" in one sentence;
- all-caps headings repeated excessively;
- emoji-heavy feature lists;
- "exact KB" if it implies guaranteed target equality;
- "best quality" / "highest quality" unless objectively proven and scoped;
- "fastest", "#1", "best";
- irrelevant toolbox terms;
- government/passport/visa targeting;
- repeating the short description verbatim at the top of the full description.

## Recommended opening draft for later full-description production

`Photo Compressor: KB Limit helps when a website, form, or portal rejects a photo because the file is too large. Choose a maximum KB or MB limit, compress the photo on your device, and check the actual result size before you save or share it.`

Follow with:
`Choose 50 KB, 100 KB, 200 KB, 500 KB, 1 MB, or enter a custom limit. The app verifies the produced file in exact bytes and only shows PASS when the result is at or below your selected limit. If the target cannot be reached safely, it tells you instead of claiming success.`

Status:
`FULL_DESCRIPTION_ARCHITECTURE_READY / FULL_COPY_NOT_YET_FROZEN`

## Decision

- Keep Play title frozen as `Photo Compressor: KB Limit`.
- Replace the previous short-description candidate with Candidate A.
- Do not freeze full-description final prose yet; freeze the architecture and truth boundaries first.
