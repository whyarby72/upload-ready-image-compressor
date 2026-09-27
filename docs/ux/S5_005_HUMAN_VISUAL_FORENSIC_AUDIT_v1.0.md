# S5-005 HUMAN VISUAL FORENSIC AUDIT v1.0

Observed: 2026-09-28
Reviewer: CHAT from direct uploaded runtime screenshots
Source under review: `5ab842073cfe6dbc507baac499c3af37a9e05183`
Evidence closure: `4db3e4e8dfa706fa69c92fcc381c666c8cd1b8e0`
Approved visual anchor: premium Warm Ink five-screen mockup

Disposition:
`VISUAL_REWORK_NARROW_REQUIRED`

This is not a redesign rejection. The Warm Ink direction is accepted. The remaining issues are layout/hierarchy polish defects visible in the actual runtime screenshots.

## Screenshot-by-screenshot

### 1. Home — `home_api36_360x800.png`

Status:
`PASS_WITH_MINOR_POLISH`

What works:
- warm ivory canvas;
- deep muted ink primary;
- product identity is one line;
- headline is concise;
- CTA is visible above the navigation bar;
- spacing is calm;
- no bright-cobalt utility feel;
- visual impression is materially more premium than the rejected View/XML version.

Minor observations:
- the media artwork is more abstract/generic than the approved mockup's photographic/media-rich focal object;
- the top `On-device` cue consumes a separate row, but is not a blocker.

No redesign is required.

### 2. Home 1.3x font — `home_font_1_3x_api36.png`

Status:
`PASS`

- headline remains readable;
- identity remains one line;
- CTA remains visible;
- no critical clipping;
- visual rhythm remains acceptable.

### 3. Requirement — `requirement_100kb_api36.png`

Status:
`FAIL_MATERIAL_HIERARCHY`

Observed at 360x800:
- header;
- Choose limit;
- large source-photo card;
- current size/meta;
- UPLOAD LIMIT;
- only first preset row (50 / 100 / 200 KB) is visible.

The second preset row (500 KB / 1 MB / Custom), selected requirement summary and primary Continue action are pushed below the first viewport.

Why this is material:
the buyer's primary job on this screen is choosing a limit and continuing. The large media card consumes too much vertical budget, so the critical control set is not visible together at first glance.

This diverges from the approved mockup, where all six choices, selected target summary and Continue action are immediately legible.

Required correction:
- shrink the source-photo block substantially or convert it to a compact horizontal thumbnail/info row;
- all six limit choices should fit in the first 360x800 viewport;
- selected `Required ≤ ...` should remain visible;
- primary `Continue` should preferably be visible without scrolling;
- preserve the selected check indicator.

Do not remove photo context entirely unless necessary; reduce its dominance on the Requirement screen.

### 4. Processing — `processing_api36.png`

Status:
`PASS_WITH_POLISH`

What works:
- media-first preview is present;
- no fake percentage;
- processing state is clear;
- restrained color system is preserved.

Polish:
- the small spinner/text cluster beneath a very large preview feels slightly detached;
- the header already contains `On-device`, while another trust line repeats `On-device · original untouched`.

Recommended correction:
- integrate the indeterminate indicator more tightly with the image/processing composition;
- remove duplicated trust copy from the body when the header cue is already present.

Not a release blocker by itself.

### 5. Result — `result_api36.png`

Status:
`FAIL_MATERIAL_RESULT_HIERARCHY`

What works:
- actual result preview is dominant;
- warm surfaces and rounded media card look materially more premium;
- success badge is restrained;
- no floppy icon visible in this top viewport;
- result is clearly more media-first than the rejected legacy screen.

Blocking visual defect:
the final size wraps as:

`199`
`KB`

instead of a controlled single-line result such as:
`199 KB`

This makes the most important value look accidental rather than designed.

The current badge + result-size row also becomes visually unbalanced: a small left status pill competes with a very large two-line number.

Required correction:
- guarantee friendly result size stays on one line at 320/360dp for realistic values;
- use responsive result typography rather than allowing unit wrap;
- keep status + value composition balanced;
- preserve exact-byte proof as secondary information.

Preferred implementation options:
- place status above the value rather than in the same constrained row;
- or reserve result-value width and scale typography responsively;
- do not truncate actual size.

### 6. Custom invalid — `custom_invalid_inline_api36.png`

Status:
`PASS`

- dialog stays open;
- invalid value remains visible;
- inline error is clear;
- KB/MB control remains present;
- action hierarchy is understandable.

Minor polish:
the validation copy could eventually become slightly more concise, but it is not a blocker.

## Overall visual assessment

The actual Compose implementation is now:
- materially more modern;
- materially more elegant;
- closer to the approved premium Warm Ink anchor;
- no longer the old-fashioned UI previously rejected.

However, direct runtime inspection exposes two buyer-facing layout defects that prevent final visual PASS:

1. Requirement controls are pushed below the first viewport by an oversized photo card.
2. Result value wraps the unit onto a second line.

These are narrow hierarchy/layout defects, not a failure of the visual system.

## Gate

TASK-S5-005 visual gate:
`HOLD_NARROW_FINAL_POLISH`

Technical evidence:
`PASS`

Warm Ink concept:
`PASS`

Actual runtime visual implementation:
`REWORK_REQUIRED_NARROW`

No signing / Play upload / S6 / BUILD / Artifact Freeze / release / publication.
