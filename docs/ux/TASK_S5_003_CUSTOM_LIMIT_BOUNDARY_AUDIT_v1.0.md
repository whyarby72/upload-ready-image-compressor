# TASK_S5_003_CUSTOM_LIMIT_BOUNDARY_AUDIT_v1.0

Observed: 2026-09-27
Audited branch: `task/TASK-S5-003`
Source basis:
- `MainActivity.java`
- `FormatUtils.java`
- `JpegCompressionEngine.java`
- `CompressionResult.java`
- `PRODUCT_SPEC.md`
- frozen PDC `UPLOAD_READY_IMAGE_COMPRESSOR_PDC_MVP_SPEC_v1.2.0_PHOTO_FIRST_UKDC_CANDIDATE.md`

Disposition: HOLD_CODING_PENDING_CUSTOM_UNIT_SEMANTICS

## Source-supported facts

The frozen PDC defines:
- presets 50 KB, 100 KB, 200 KB, 500 KB, 1 MB;
- `Custom KB/MB` as the canonical target-selection capability;
- REQUIRED as a website/form upload limit provided by the user;
- PASS only when actual output bytes are <= requested_limit_bytes.

The PDC does NOT define:
- whether KB/MB use decimal (1000/1,000,000) or binary (1024/1,048,576) byte units;
- a minimum custom limit of 8 KB;
- a maximum custom limit of 50 MB;
- whether fractional KB/MB are allowed;
- how fractional limits must be rendered back to the user.

Therefore those semantics cannot be treated as source-of-truth decisions yet.

## Current implementation

Custom dialog:
- accepts decimal numeric input;
- defaults unit radio to KB;
- parses via `Double.parseDouble(...)`;
- converts KB with x1024 and MB with x1024x1024;
- rounds to a long byte count;
- rejects converted values below 8 KiB or above 50 MiB;
- valid input calls `selectTarget(bytes, Custom)`.

## Material finding C1 — Unit-base ambiguity

Current code interprets:
- 100 KB = 102,400 bytes;
- 1 MB = 1,048,576 bytes.

The product promise is about satisfying an external website/form limit, but the source specification never states that the external service uses those binary byte definitions.

If an external service interprets a displayed “100 KB” limit differently, the app can truthfully pass its internal threshold while the external service rejects the file.

This is a product-truth ambiguity, not merely a formatting preference.

Disposition:
- do not silently choose decimal or binary semantics inside TASK-S5-003;
- resolve and document the convention or adopt a conservative compatibility rule before coding.

## Material finding C2 — Fractional custom limits can render misleading proof

`FormatUtils.target(bytes)` returns a whole KB/MB only when the byte count divides evenly by those binary units. Otherwise it falls back to `FormatUtils.bytes(bytes)`, which displays KB with zero decimal places.

Because Custom accepts decimal values, examples such as 8.5 KB or 0.1 MB can create exact byte thresholds that are later shown as rounded whole-KB text.

This can make the visible proof less precise than the actual comparison and can even produce visually confusing inequalities where rounded labels appear equal while the underlying byte values differ.

Disposition:
- custom-limit display/proof must preserve enough precision that the visible <= or > statement matches the actual byte comparison;
- do not use whole-KB rounding for a fractional target in the proof line.

## Finding C3 — 8 KB lower boundary is undocumented

The 8 KB minimum exists only in current implementation.

The PDC says Custom KB/MB is canonical and does not define this lower bound.
The compression engine itself already has a quality guard and honest NOT_MET behavior.

Therefore the source materials do not support claiming that <8 KB is invalid product input.

Disposition:
- 8 KB floor requires a documented product/technical rationale, or it should be removed/replaced by a clearly justified representable minimum.

## Finding C4 — 50 MB upper boundary is undocumented

The 50 MB maximum also exists only in current implementation.

The PDC does not define this upper bound.

Disposition:
- 50 MB ceiling requires a documented technical/product rationale;
- do not present it as a frozen product rule without such evidence.

## Finding C5 — Locale-sensitive decimal parsing risk

The field advertises decimal input, but parsing uses `Double.parseDouble`, which expects a dot-style numeric representation.

For a global product, a valid fractional value entered with another decimal separator may fail.

This is code-derived risk; the current source does not define a locale policy for numeric custom input.

Disposition:
- if fractional custom input remains supported, parsing behavior must be explicitly defined and tested for the supported locale policy.

## Finding C6 — Invalid input closes the dialog

The custom dialog uses the standard positive-button callback.
Validation errors return from the callback after showing a Toast, but the standard dialog positive action dismisses the dialog.

Result:
- invalid input does not corrupt target state;
- however the user must reopen Custom to correct the value.

Disposition:
P1 usability debt, not a truth blocker. Fix only if it stays narrow.

## Finding C7 — Existing-selection invariant is mostly sound but must stay explicit

Current behavior:
- opening/cancelling Custom does not change the prior selected target;
- invalid Custom does not call `selectTarget`, so prior target remains;
- valid Custom replaces the prior target.

This matches the hardened last-valid-selection rule, provided TASK-S5-003 preserves it while removing default selection.

## Required pre-code decision

Before Codex changes source, define all of the following:

1. KB/MB byte convention for presets and Custom.
2. Whether fractional KB and fractional MB are supported.
3. Precision/format rule for displaying custom REQUIRED and proof comparisons.
4. Supported minimum custom limit.
5. Supported maximum custom limit.
6. Locale parsing rule for fractional input.

Until those are resolved, TASK-S5-003 is held because the task is explicitly repairing requirement truth and should not freeze undocumented unit semantics by accident.

## Boundary test set required after resolution

At minimum:
- minimum allowed value exactly;
- immediately below minimum;
- maximum allowed value exactly;
- immediately above maximum;
- 100 KB preset byte threshold;
- 1 MB preset byte threshold;
- fractional KB if supported;
- fractional MB if supported;
- decimal-separator behavior per supported locale policy;
- custom target just above/below an output artifact to prove visible comparison matches actual bytes;
- prior valid preset -> invalid Custom preserves prior target;
- no prior target -> invalid Custom remains unselected.
