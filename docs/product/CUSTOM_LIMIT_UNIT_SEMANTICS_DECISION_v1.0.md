# CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0

Observed: 2026-09-27
Scope: Requirement-size semantics for `REDUCE PHOTO SIZE: KB LIMIT`.
Status: BINDING_FOR_TASK_S5_003

## Verdict

For all user-entered/preset maximum upload limits:

- `1 KB = 1,000 bytes`
- `1 MB = 1,000,000 bytes`
- verification is performed against exact output bytes;
- binary units are not represented as KB/MB; if binary units are ever introduced, use KiB/MiB explicitly.

This is deliberately conservative for an unknown external website implementation when the website only exposes a maximum “KB/MB” label.

## FACT — standards and platform behavior

### SI / NIST
NIST defines SI prefixes as powers of 10 and explicitly says kilo must not be used to mean 2^10 and mega must not be used to mean 2^20. Binary powers have separate IEC-style prefixes such as Ki/Mi.

Source:
https://www.nist.gov/pml/special-publication-811/nist-guide-si-chapter-4-two-classes-si-units-and-si-prefixes

### Android
Android `android.text.format.Formatter.formatFileSize` uses SI meanings from Android O onward:
- kB = 1,000 bytes
- MB = 1,000,000 bytes

Our minSdk is 29, so all supported runtime versions are newer than Android O.

Source:
https://developer.android.com/reference/android/text/format/Formatter

### Web File API
Browser File/Blob size is exposed as an exact number of bytes. Therefore exact-byte verification is the stable comparison primitive independent of display units.

Source:
https://developer.mozilla.org/en-US/docs/Web/API/Blob/size

## FACT — web implementation ambiguity still exists

PHP's documented shorthand uses:
- 1K = 1,024 bytes
- 1M = 1,048,576 bytes

Therefore real web infrastructure can use binary-style semantics even while user-facing sites write “KB/MB”.

Source:
https://www.php.net/manual/en/faq.using.php

## INFERENCE — conservative maximum-limit rule

For maximum file-size limits, decimal SI is the safer compatibility interpretation when the external site does not disclose its byte convention.

Example:
- entered 100 KB -> internal maximum = 100,000 bytes;
- a decimal site requiring <=100,000 bytes is satisfied;
- a binary-style site allowing <=102,400 bytes is also satisfied.

Likewise:
- entered 1 MB -> 1,000,000 bytes;
- <=1,000,000 also satisfies a binary-style 1 MiB-like threshold of 1,048,576 bytes.

This compatibility inference applies to maximum-size checks only. It does not prove compliance with:
- minimum file-size requirements;
- image dimensions;
- aspect ratio;
- MIME/format;
- portal-specific validation;
- other form rules.

## FACT — observed market/portal ranges

Current official/public examples include:
- SWAYAM: photograph 10 KB–200 KB; signature 4 KB–30 KB.
- Indian government/education application examples: photo 10 KB–200 KB, photo <20 KB, photo max 500 KB, photo max 2 MB.
- NSW MyHousing: photos/documents up to 10 MB.
- Current Play competitors expose presets around 20/50/100/200/500 KB and custom ranges such as 10–1000 KB or 20–5000 KB.

Sources:
https://www.swayam.gov.in/faq
https://empmission.odisha.gov.in/Exchange/CandDeclaration.jsp
https://sites.fssai.gov.in/trainers/applyonline.php
https://ncpcrvacancies.wcd.gov.in/
https://www.nsw.gov.au/departments-and-agencies/homes-nsw/social-housing-resources/myhousing-repairs-faqs
https://play.google.com/store/apps/details?id=com.ammartahircheema.photocompressor
https://play.google.com/store/apps/details?id=com.moneyflow.exactkbphoto

## Custom input contract

### Unit base
Use decimal SI only:
- KB multiplier = 1,000
- MB multiplier = 1,000,000

### Supported range
- minimum converted limit: 1,000 bytes (1 KB)
- maximum converted limit: 50,000,000 bytes (50 MB)

Evidence classification:
- 1 KB minimum is a conservative technical floor, not a demand claim. It is below all observed current photo constraints and avoids the undocumented 8 KB product rule.
- 50 MB maximum is a technical safety/UX guard, not a market maximum. Current observed photo/form limits are materially lower (up to 10 MB in the reviewed set), so 50 MB preserves substantial headroom while keeping the input domain bounded.

These boundaries may be revised later from behavioral evidence without changing the unit convention.

### Fractions
Support fractional Custom values with at most 3 digits after the decimal separator.

Examples:
- `10.5 KB` -> 10,500 bytes
- `1.5 MB` -> 1,500,000 bytes
- `0.001 MB` -> 1,000 bytes

Use decimal arithmetic (`BigDecimal` or equivalent), not binary floating-point `double`, for requirement conversion.

If a valid decimal value would mathematically produce a fractional byte, floor to the next-lower whole-byte maximum before comparison. The app must never round a maximum upward.

### Decimal separator / locale policy
For the English-first global MVP:
- accept ASCII digits;
- accept at most one decimal separator;
- accept either `.` or `,` as the decimal separator;
- reject input containing both `.` and `,`;
- reject grouping separators/thousands notation;
- reject more than 3 fractional digits;
- normalize internally to a decimal point before `BigDecimal` parsing.

Examples:
- `1.5 MB` -> valid
- `1,5 MB` -> valid
- `1,234.5 MB` -> reject as ambiguous/grouped
- `1.234,5 MB` -> reject as ambiguous/grouped

### Invalid/cancelled Custom
- no previous target -> remain unselected and known-path CTA disabled;
- previous valid target -> preserve that exact previous target;
- invalid input must not mutate target bytes or selection visuals;
- cancellation must not mutate target state.

Keeping the dialog open after validation error is desirable P1 usability polish, but not required for truth semantics.

## Display / proof contract

### Friendly display
All user-facing KB/MB display uses decimal SI.

Examples:
- 100,000 bytes -> 100 KB
- 1,500,000 bytes -> 1.5 MB

Do not reuse the old binary formatter.

### Exact proof
The result proof must not rely on rounded KB/MB text near the threshold.

For known-limit PASS/NOT_MET, include exact-byte proof, for example:
- `99,875 bytes <= 100,000 bytes — PASS`
- `100,001 bytes > 100,000 bytes`

The large result number may remain friendly decimal KB/MB.

This removes the current fractional-target rounding ambiguity.

## Preset contract

Presets are exact decimal thresholds:
- 50 KB = 50,000 bytes
- 100 KB = 100,000 bytes
- 200 KB = 200,000 bytes
- 500 KB = 500,000 bytes
- 1 MB = 1,000,000 bytes

All pre-existing 1024-based preset evidence becomes historical provenance after TASK-S5-003 source changes.

## Minimum-limit caveat

The product verifies a user-entered maximum size. Some portals also impose a minimum size (for example 10 KB–200 KB). The current MVP does not claim to validate a minimum threshold unless such a feature is separately specified.

Do not claim full portal compliance solely from a maximum-size PASS.

## Implementation requirements

TASK-S5-003 must:
1. replace 1024-based target multipliers with decimal constants;
2. update `FormatUtils` to decimal display semantics;
3. parse Custom via exact decimal arithmetic;
4. enforce the 1 KB–50 MB converted-byte range;
5. accept one dot OR comma decimal separator and reject ambiguous grouping;
6. preserve at most 3 fractional digits;
7. use exact-byte proof for PASS/NOT_MET;
8. retain actual output-file byte re-read/verification;
9. rerun all preset and custom boundary evidence;
10. mark all old 1024-based Play-candidate artifacts superseded.

## Evidence classification

FACT:
- SI/NIST and current Android supported versions use decimal KB/MB.
- PHP demonstrates that 1024-based server-side shorthand still exists.
- browser file size is available in exact bytes.
- current portals/competitors use ambiguous KB/MB labels and a broad range of limits.

INFERENCE:
- decimal SI thresholds are conservative across decimal-vs-binary interpretations for a maximum-size requirement.

ASSUMPTION / technical policy:
- Custom range 1 KB–50 MB.
- maximum 3 fractional digits.
- accepting both dot and comma as ungrouped decimal separators.

UNKNOWN:
- any specific external portal's hidden byte convention unless that portal documents it.
- whether a portal will accept a file based on size alone.
