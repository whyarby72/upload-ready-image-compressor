# S5 HIGH-FIDELITY MOCKUP REVIEW v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Mockup scope: First Open / Requirement / PASS Result
Disposition: REWORK_BEFORE_IMPLEMENTATION

## Overall verdict

The mockup establishes the correct visual direction and is materially better than the current legacy Android UI.

KEEP:
- compact product identity;
- high-trust cobalt/neutral palette;
- rounded modern surfaces;
- strong hero hierarchy;
- selector tiles/chips;
- dominant numeric result;
- exact-byte proof;
- before/after comparison;
- Save primary / Share secondary / Compress another tertiary;
- restrained icon-led trust cues.

However, several details are not implementation-safe yet because they create misleading promises, conflict with frozen product truth, or introduce unnecessary scope.

## Material truth corrections

### M1 — False EXIF preservation claim

Mockup result says:
`Metadata (EXIF) preserved`

This is NOT compatible with the current product contract.

Current behavior:
- source/original remains untouched;
- EXIF orientation is respected/applied for correct visual orientation;
- metadata is removed from compressed copies.

Required replacement:
`Orientation corrected · metadata removed`

or:
`Original untouched · metadata removed from compressed copy`

Do not claim EXIF metadata is preserved.

### M2 — Requirement promise is too strong

Mockup says:
`We'll make the smallest possible file that meets your limit.`

This implies guaranteed success.

Frozen truth allows NOT_MET when the quality guard prevents safe compression to the requested threshold.

Required replacement:
`We'll try to meet this limit and verify the actual result.`

Preferred:
`We'll verify the actual result against this limit.`

No UI copy may imply the target will always be reached.

### M3 — Friendly size / exact-byte inconsistency

Mockup comparison shows:
`3.46 MB`
and
`3,628,114 bytes`

Under the bound decimal-SI convention, 3,628,114 bytes is approximately 3.63 MB, not 3.46 MB.

Required rule:
- every friendly KB/MB number shown near an exact byte count must derive from the same decimal-SI bytes;
- no binary-MiB-style display under KB/MB labels.

### M4 — First-open illustration must not imply an unearned result

Mockup hero illustration displays a specific transformation such as:
`3.46 MB -> 99.8 KB`

Before the user supplies an upload limit, this can read like a promised default result.

Required treatment:
- use generic `MB -> KB`, or
- use non-binding illustrative labels such as `Before` / `Smaller`,
- avoid a precise output number on first open.

## Scope-control corrections

### S1 — Photo thumbnail is optional, not required

The requirement mockup uses a real image thumbnail.

Current product does not require thumbnail rendering.

A thumbnail adds:
- decode/render work;
- memory surface;
- orientation handling surface;
- new visual regression surface.

Default implementation:
- use a clean vector/photo icon in the CURRENT PHOTO card.

Thumbnail may be implemented only if it is already available safely without broadening memory/EXIF behavior and passes API29/API36 tests.

### S2 — Remove nonfunctional back and overflow controls

Mockup requirement/result screens show back and vertical-ellipsis controls.

Do not ship decorative navigation/settings affordances.

If an icon has no defined action, remove it.

The one-job app does not need an overflow menu for the MVP.

### S3 — No confetti / celebration decoration

PASS result mockup includes colored celebration marks around the success icon.

Remove them.

Reason:
- unnecessary decoration;
- conflicts with calm Precision Utility direction;
- result truth should feel verified, not gamified.

A simple status icon + badge is sufficient.

### S4 — Keep unknown-limit action visible/reachable

Requirement mockup emphasizes the known-limit flow but the unknown-limit action is not visible in the shown viewport.

Implementation must preserve:
`I don't know the website limit`

It can remain secondary, but must be visibly reachable and not hidden behind ambiguous navigation.

## Visual refinements

### V1 — Product header

Keep:
- compact app mark;
- `Reduce Photo Size`;
- small `On-device` pill.

Remove or de-emphasize:
- `KB LIMIT` as a pseudo-sub-brand.

The Play title may be `Reduce Photo Size: KB Limit`, but in-app identity should remain clean:
`Reduce Photo Size`.

### V2 — First-open trust cues

Three large trust icons at the bottom are visually clean but slightly repetitive.

Preferred:
- one compact trust row with 2–3 short items;
- do not let trust badges compete with the primary CTA.

Keep:
- On-device
- Original untouched
- No account

### V3 — Requirement target selector

The selector treatment is approved.

Required:
- 48dp min touch height;
- selected state = color + border + indicator;
- no default selection;
- exact target text remains legible at 320px width.

### V4 — Result composition

The result hierarchy is approved with corrections:

1. status badge;
2. final size;
3. exact-byte proof;
4. before/after;
5. dimensions + metadata/original disclosure;
6. Save;
7. Share;
8. Compress another.

Do not hide exact proof below fold if the status/number are visible.

### V5 — PASS language

Preferred status:
`MEETS LIMIT`

Avoid:
`UPLOAD READY`
as the primary state because the app verifies only the entered maximum file size and not every portal rule.

## Approved screen text direction

### First open

Header:
`Reduce Photo Size`

Hero:
`Make your photo ready to upload.`

Body:
`Choose a JPEG, set the website limit, and verify the result.`

CTA:
`Choose photo`

Trust:
`On-device · Original untouched · No account`

### Requirement

Title:
`What's the upload limit?`

Body:
`Choose the maximum size shown on the website or form.`

Neutral:
`Choose the upload limit`

Selected:
`Required ≤ 100 KB`

Optional support:
`We'll verify the actual result against this limit.`

CTA:
`Make it upload-ready`

Secondary:
`I don't know the website limit`

### PASS result

Badge:
`MEETS LIMIT`

Proof:
`99,875 bytes ≤ 100,000 bytes`

Disclosure:
`Original untouched · metadata removed from compressed copy`

Primary:
`Save copy`

Secondary:
`Share`

Tertiary:
`Compress another`

## Implementation gate

The current mockup is NOT a literal implementation specification.

It is approved only after applying M1-M4 and S1-S4 above.

Codex must use:
- benchmark document;
- design-system blueprint;
- this mockup review;
- frozen product truth.

No source implementation should reproduce the false EXIF claim, guaranteed-target copy, decimal/binary inconsistency, decorative overflow controls, or confetti.
