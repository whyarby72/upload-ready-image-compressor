# FINAL_KEYWORD_SELECTION_v1.0

Status: KEYWORD_STRATEGY_SELECTED / TITLE_PENDING_FINAL_CONFIRMATION
Observed: 2026-09-27
Scope: Google Play English title strategy for the current JPEG/photo upload-limit MVP.

## Selected Keyword Architecture

Primary problem-intent cluster:
- `Reduce Photo Size`

Secondary high-intent cluster:
- `MB to KB`

Recommended title basis:
- `Reduce Photo Size: MB to KB`
- Character count: 27 / 30

## Evidence

### Demand proxies
These are app-level market signals, not Google Play query-volume measurements.

1. `Reduce Photo Size - Downsize`
   - 5M+ downloads
   - 116K reviews
   - demonstrates large demand around "reduce photo size" language.

2. `Compress Photo Size - MB to KB`
   - 1M+ downloads
   - 19.1K reviews
   - demonstrates established demand for photo-size + MB-to-KB language.

3. `Compress Image - MB to KB`
   - 1M+ downloads
   - ~69K reviews
   - demonstrates established MB-to-KB intent.

4. `Photo Compressor and Resizer`
   - 1M+ downloads
   - 62.9K reviews
   - demonstrates strong demand for the photo-compressor category.

5. `Puma: Photo Resizer Compressor`
   - 1M+ downloads
   - 81.3K reviews
   - demonstrates that brand+category can scale, but does not prove brand-first is optimal for a new zero-awareness utility.

## Candidate Evaluation

### Photo Compressor
Strength:
- established category phrase;
- accurate for current JPEG/photo MVP.

Weakness:
- extremely saturated;
- many near-identical titles;
- weak differentiation by itself.

Disposition:
- important metadata keyword, but not sufficient as the whole title strategy.

### MB to KB
Strength:
- direct user problem language;
- strong presence in 1M+ competitor titles;
- highly aligned with upload-size jobs.

Weakness:
- heavily saturated;
- by itself does not say what object is being transformed.

Disposition:
- retain as secondary title keyword.

### Compress Photo to KB
Strength:
- strong task intent;
- concise and readable.

Weakness:
- current Play competitors already use close/exact variants;
- recent exact-phrase listings have limited visible traction;
- weaker broad-market demand evidence than "Reduce Photo Size".

Disposition:
- secondary long-tail keyword.

### Photo Size Reducer
Strength:
- clear functional meaning;
- aligned with category vocabulary.

Weakness:
- active exact-title competitor;
- weaker visible demand evidence as an exact title than "Reduce Photo Size";
- noun-heavy and less natural as a user query/action phrase.

Disposition:
- description/semantic support keyword.

### Reduce Photo Size
Strength:
- strongest visible app-level demand proxy among evaluated clusters;
- maps directly to user problem;
- accurate without promising exact success;
- works for upload-limit and storage intents.

Weakness:
- generic/common phrase;
- needs a second phrase to sharpen job intent.

Disposition:
- SELECTED PRIMARY CLUSTER.

## Recommended Title

`Reduce Photo Size: MB to KB`

Why:
- uses the strongest observed demand-proxy phrase;
- includes the high-intent MB-to-KB phrase;
- 27 characters, within the 30-character Google Play limit;
- accurately describes the current app;
- does not claim guaranteed exact KB;
- current public search did not surface an exact-title collision for this full title;
- remains more differentiated than repeating crowded `Photo Compressor: MB to KB` titles.

## Policy / Metadata Guardrails

Google Play currently:
- limits titles to 30 characters;
- requires metadata to be truthful and relevant;
- recommends unique titles and avoiding overly common terms;
- prohibits deceptive/spammy keyword use.

Therefore keyword-led naming should remain readable and descriptive, not a keyword block.

## Important Evidence Limitation

Google does not expose public query-level Google Play keyword volume in these sources.
Downloads/reviews are app-level demand proxies and cannot prove that a specific title keyword caused installs or rankings.

## Localization Direction

English working title:
`Reduce Photo Size: MB to KB`

Indonesian localization candidate:
`Kompres Foto: MB ke KB`

Localized title should be validated separately against Indonesian search language before publication.

## Package-ID Boundary

Do not derive the package ID mechanically from the full keyword title.
Recommended stable namespace pattern remains:
`com.afradadmedia.<stable_product_slug>`

Package ID must be selected only after title confirmation and collision check, before the first Play upload.

## Current Authority

This file selects the keyword architecture and recommended title basis.
It does not authorize:
- source/package migration;
- Play upload;
- signing;
- Artifact Freeze;
- release;
- publication.
