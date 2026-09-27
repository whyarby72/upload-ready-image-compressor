# S5-004 HUMAN VISUAL REJECTION AUDIT v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Evidence: user-supplied emulator screenshot of current PASS result
Disposition: HUMAN_VISUAL_REJECTION / REOPEN

## Why the previous visual PASS is invalidated

The previous UI gate verified structural modernization:
- rounded controls;
- modernized custom dialog;
- target chips;
- status hierarchy;
- small-screen evidence;
- functional truth.

That gate was too weak for market-facing aesthetic quality.

The user has now reviewed the actual app presentation and explicitly rejected it as still looking materially dated. Subjective market-facing quality requires human approval; therefore the prior visual PASS cannot remain authoritative.

## Screenshot-derived findings

### H1 — Legacy Android foundation is still visible
The UI is still built on:
`android:style/Theme.Material.Light.NoActionBar`

Custom shapes were layered over a legacy View/theme foundation rather than replacing the visual system at its root.

### H2 — Result screen still looks like a stacked utility form
Composition is predominantly:
header -> status pill -> large number -> explanatory text -> proof text -> outlined comparison card -> technical metadata -> large buttons.

This is clearer than the old version but still reads as a utilitarian form, not a premium consumer product.

### H3 — Icon language is dated
The result uses a floppy-disk save icon, classic three-node share icon, and simple back/repeat arrow. These are functional but visually generic and dated.

### H4 — Primary button treatment is generic
The large full-width cobalt rectangle with centered text is modernized relative to legacy Android, but still resembles a basic Material 2 utility CTA.

### H5 — Typography is too coarse
The default sans/Roboto treatment uses many heavy bold weights and a large `980 KB` headline without a more refined type scale.

There is limited distinction between:
- product identity;
- result outcome;
- proof;
- metadata;
- actions.

### H6 — Technical language remains too visually prominent
Examples:
- `980053 bytes ≤ 1000000 bytes — PASS`
- `2400 × 1600 · JPEG quality 48`
- `Metadata removed from compressed copy`

The truth is important, but the presentation feels engineering-facing.

### H7 — Before/After card lacks visual sophistication
The outlined white rectangle with labels and arrow is legible but generic.

It does not create a premium visual focal point or connect strongly to the selected photo.

### H8 — Header is crowded at narrow width
`Reduce Photo Size` wraps to two lines at 320px while the On-device pill occupies the same row.

This makes the app shell look cramped.

### H9 — Screen lacks a strong visual object
There is no photo thumbnail, image surface, brand illustration, or other subtle visual anchor on the result screen.

The entire screen is text + outlined boxes + buttons.

### H10 — The emulator scaling is not the root cause
The user screenshot is visibly scaled/softened by the desktop emulator window, which makes text appear slightly blurrier.

However the underlying composition, iconography, typography, button treatment, and app-shell structure are still materially dated even at native screenshots.

## Root cause

The previous task constrained itself to a dependency-light XML/View redesign and explicitly prohibited Compose.

As of 2026 Android is Compose-first and the legacy View toolkit is in maintenance mode. For a new market-facing UI, continuing to push the same View/theme foundation is now a quality and maintenance tradeoff rather than an obvious risk reduction.

## Reopened design objective

The next redesign must change the **visual system**, not only component skins.

Target:
**premium modern Android utility / editorial precision / Material 3 contemporary**

Required changes include:
- new app-shell composition;
- edge-to-edge treatment;
- one-line identity at narrow width;
- modern typography hierarchy;
- richer result hero;
- modern icon set;
- less developer-like proof presentation;
- compact technical disclosure;
- more sophisticated before/after representation;
- modern action hierarchy;
- optional lightweight photo thumbnail/visual context if safe;
- consistent motion/state transitions;
- no legacy Material Light visual residue.

## Platform direction

Preferred architecture for evaluation:
**Compose UI layer + existing verified compression/domain engine preserved**

Do not rewrite compression semantics.

A Compose migration must be scoped to presentation/state orchestration and preserve:
- package identity;
- parser;
- exact-byte truth;
- PASS / NOT_MET / REDUCED;
- Save/Share;
- original preservation;
- EXIF orientation behavior;
- API29/API36 behavior until separately changed.

## Artifact disposition

Current AAB:
`de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

is functionally valid but:
`HOLD_HUMAN_VISUAL_REJECTION`

Do not upload to Play.

## Gate

TASK-S5-004:
`REOPENED_HUMAN_VISUAL_REJECTION`

Play:
`HOLD`

Next owner:
`CHAT`

Next step:
create a materially different high-fidelity visual concept before authorizing implementation.
