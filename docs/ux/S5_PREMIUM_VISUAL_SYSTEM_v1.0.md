# S5 PREMIUM VISUAL SYSTEM v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Status: FINAL VISUAL SYSTEM / MOCKUP-DERIVED / IMPLEMENTATION NOT YET AUTHORIZED

## 1. Source basis

This system is derived from the human-preferred premium mockup direction:
- warm ivory background;
- deep muted teal/ink primary;
- quiet success and failure surfaces;
- photo-first composition;
- sparse copy;
- large but controlled whitespace;
- pill-shaped actions;
- restrained iconography;
- low-saturation semantic color.

The system intentionally rejects the previous bright-cobalt utility aesthetic.

Mockup values below are normalized into implementation tokens. They are not pixel-for-pixel color samples that must be reproduced exactly.

## 2. Visual identity

Name:
**MEDIA-FIRST PRECISION UTILITY — WARM INK**

Adjectives:
- elegant
- premium
- calm
- exact
- editorial
- trustworthy
- private
- modern Android

Do not become:
- bright utility blue
- gaming
- playful
- neon
- glassmorphism-heavy
- dashboard-like
- corporate SaaS
- developer-tool-like

## 3. Color system

### Core neutrals

`canvas`
#F6F0ED
Warm ivory app background.

`surface`
#FCF9F6
Primary surface / large card.

`surface_subtle`
#EFE9E4
Low-emphasis panels and secondary actions.

`surface_elevated`
#FFFDFC
Dialog / elevated media surface.

`outline`
#DED7D1

`outline_strong`
#CFC5BE

### Ink / primary

`ink_900`
#142629
Primary text and strongest UI ink.

`ink_800`
#1E3335
Primary action fill.

`ink_700`
#2A4749
Pressed/selected state.

`ink_600`
#3E5D5E

`ink_soft`
#E5ECE9
Low-emphasis ink-tinted surface.

### Text

`text_primary`
#142126

`text_secondary`
#5E6C72

`text_muted`
#7C878B

`text_inverse`
#FFFDFC

### Success

`success`
#2F6C59

`success_strong`
#1F5948

`success_surface`
#E3ECE4

`success_outline`
#CADBCF

### Not met / warning

`warning`
#9D4447

`warning_strong`
#803437

`warning_surface`
#F9E2DE

`warning_outline`
#F0C9C4

### Info / reduced

Use ink/neutral family rather than a separate bright blue.

`info`
#4B6668

`info_surface`
#E8EEEC

## 4. Color usage rules

- No bright royal/cobalt blue as the dominant brand color.
- Primary action is deep muted ink/teal.
- Success green appears only for verified success.
- NOT_MET uses muted rose/warm red, not alarm-red.
- REDUCED uses neutral/ink, not success green.
- Surfaces separate through warm tonal contrast before shadows.
- Avoid more than one high-emphasis semantic color on a screen.
- Photos carry the strongest chroma; UI chrome remains restrained.

## 5. Typography

Preferred implementation direction:
Material 3 typography tuned for an editorial utility.

Default family:
system Android sans / Roboto-compatible.

Do not add a custom font in the first implementation pass unless the visual prototype proves the system font is insufficient.

### Type scale

`display_result`
48–56sp
Weight 600–700
Use only for final file size.

`headline_hero`
30–34sp
Weight 600
Line height ~1.12–1.18.

`headline_screen`
26–30sp
Weight 600.

`title_product`
18–20sp
Weight 600.

`title_card`
18sp
Weight 600.

`body_primary`
16sp
Weight 400.

`body_secondary`
14–15sp
Weight 400.

`label_action`
15–16sp
Weight 500–600.

`label_micro`
12–13sp
Weight 500.

`proof`
13–14sp
Weight 500.

## 6. Typography rules

- Do not make every important line bold.
- Large result number is dominant; proof is secondary.
- Technical metadata never uses headline weight.
- Limit labels use medium weight, not heavy bold.
- Avoid all caps except very small semantic status labels if readability benefits.
- No condensed type.
- Keep body width short; prefer one sentence over two.
- Header must remain one line at 320dp where possible.

## 7. Spacing

4dp base grid.

Allowed spacing tokens:
4 / 8 / 12 / 16 / 20 / 24 / 32 / 40 / 48

Screen horizontal padding:
- 20dp minimum at narrow width
- 24dp default
- 28dp where width allows

Major vertical rhythm:
- header → hero: 28–36dp
- title → body: 8–12dp
- body → primary content: 20–28dp
- content → action area: 24–32dp

Avoid:
- repeated 8dp stacking of unrelated elements;
- large empty zones without hierarchy purpose;
- dense technical blocks.

## 8. Shape system

`radius_xs`
12dp

`radius_sm`
16dp

`radius_md`
20dp

`radius_lg`
24dp

`radius_xl`
28–32dp

Use:
- chips/compact selectors: 16–18dp
- primary button: 22–28dp, pill-like but not cartoonish
- media/result card: 24–28dp
- dialog: 28dp
- bottom action dock: 24–28dp

Avoid:
- 8dp Material-2-looking rectangles;
- every component having the same radius;
- heavy shadow stacks.

## 9. Elevation

Primary depth mechanism:
- tonal contrast
- image layering
- subtle border
- minimal shadow

Recommended:
- normal card: 0dp or very subtle 1dp
- media card: 1–2dp equivalent visual lift
- dialog: standard M3 elevation
- action dock: subtle separation from canvas

No large soft shadows around every card.

## 10. Icon system

Target:
current Material Symbols / contemporary M3 icon language.

Style:
- simple
- geometric
- consistent stroke/optical weight
- 20–24dp typical
- 28dp only for major status/hero icon

Explicitly reject:
- floppy-disk Save icon
- generic desktop-era metaphors
- mixed filled/outline styles without intent
- emoji
- Unicode status symbols

Preferred semantics:
- photo/image
- shield/check for local/privacy
- tune/target for upload limit
- download/save-to-device for Save
- share
- refresh/repeat
- check-circle
- warning triangle
- more-horizontal only if a real action menu exists

## 11. Photo treatment

Photo is a first-class UI object.

### First open
Use a generic media illustration or non-binding photo composition.

Do NOT show an exact promised output such as:
`3.46 MB -> 980 KB`
before the user supplies a real photo/limit.

Acceptable:
- generic `MB -> KB`
- abstract before/smaller visual
- non-numeric media card

### Requirement
Once a real photo is selected:
- real thumbnail is preferred if memory/orientation handling is safe;
- otherwise use a refined photo placeholder;
- file size remains visible but not oversized.

### Result
Real result preview is strongly preferred.

Before/After can be:
- split image comparison;
- stacked before/after thumbnails;
- same image with compact size tags.

Do not fabricate visual quality differences.

## 12. Header / app shell

Goal:
one-line identity.

Preferred:
[small app mark] `Reduce Photo Size`

Trust:
`On-device`
should not compete with title.

Placement options:
- small trailing chip only when width allows;
- supporting micro-row below app title;
- integrated into hero/result surface.

At 320dp:
product name must not wrap because of the privacy chip.

Avoid persistent back/overflow icons unless the action actually exists.

## 13. Button system

### Primary
Deep ink fill.
Height:
56–60dp.
Radius:
24–28dp.
Text:
white.
Optional leading icon.
One primary per screen.

### Secondary
Warm surface or ink-soft surface.
Height:
50–56dp.
Dark ink text/icon.
Thin outline optional.

### Tertiary
Text/icon action.
48dp min touch target.
No full-width box unless necessary.

### Disabled
Warm neutral.
No color ambiguity.
Text still readable but clearly inactive.

## 14. First-open action model

Copy density target:
very low.

Preferred content:
- product identity
- one hero statement
- one short body line
- one visual media surface
- one primary CTA
- one compact trust line

Avoid feature lists.

Reference copy direction:
`Fit your photo to an upload limit.`

`Choose photo`

Trust:
`On-device · Original untouched`

## 15. Requirement control system

Header:
`Choose limit`
or
`What's the upload limit?`

Supporting line max:
one sentence.

Preset selector:
50 KB / 100 KB / 200 KB
500 KB / 1 MB / Custom

Selected state:
- ink fill OR strong ink-tinted fill
- visible check
- readable inverse/primary text

Requirement summary:
`Required ≤ 100 KB`

No per-preset descriptions such as “social media” or “job portals”.

## 16. Custom limit

Use M3 dialog/bottom-sheet quality.

Contents:
- numeric field
- KB / MB connected segmented control
- one compact helper
- inline error

No long explanatory copy.

Invalid input stays in place.

## 17. Progress

The preferred visual mockup shows a percentage ring, but the current engine does not expose real progress percentage.

Binding implementation:
**indeterminate progress only** until real progress data exists.

Allowed visual:
- photo preview
- subtle indeterminate ring/linear indicator
- single status line:
  `Compressing…`

Optional:
`On-device`

Do not display:
- 72%
- fabricated phases
- estimated time unless measured

## 18. Result hero

This is the most important screen.

### PASS

Hero surface:
quiet success tonal background.

Structure:
`Meets limit`
`980 KB`
compact proof:
`980,053 ≤ 1,000,000 bytes`

Then:
photo result / before-after visual.

Do not repeat:
“The file meets the maximum size you entered”
if the badge + proof already convey it.

### NOT_MET

Hero:
warning tonal surface.

Structure:
`Target not met`
actual size
compact proof

One guidance line max:
`Try a higher limit or a different photo.`

Do not imply automatic quality-lowering retries if that behavior does not exist.

### REDUCED

Neutral/ink hero.
`Smaller copy`
result size
compact line:
`No limit was entered.`

No green success treatment.

## 19. Exact-byte proof

Truth remains mandatory.

Visual treatment changes:
proof becomes a compact verification strip / small supporting line.

Example:
`Verified · 980,053 ≤ 1,000,000 bytes`

Do not visually compete with final size.

Full technical detail may live in a secondary details surface if later validated.

## 20. Before / after

Do not use a plain white outlined engineering card as the primary visual.

Preferred:
- visual photo comparison
- sizes embedded as subtle tags
- minimal labels Before / After

Optional compact textual summary:
`3.46 MB -> 980 KB`

No fake visual degradation.

## 21. Technical metadata

Main result surface should not foreground:
- JPEG quality 48
- metadata implementation detail
- low-level compression internals

Primary compact metadata:
`JPEG · 2400 × 1600`

Preservation disclosure may remain in a quiet secondary line:
`Original untouched`

Metadata-removal disclosure can be in details/supporting text, not headline hierarchy.

## 22. Result action dock

### PASS / REDUCED

Primary:
`Save copy`

Secondary dock:
`Share`
`Compress another`

Preferred visual:
- one large primary pill
- below or adjacent compact two-cell dock
- contemporary download/save icon
- no floppy disk

### NOT_MET

Do not create an unimplemented “Try again” workflow.

Use current supported actions:
- `Save current copy` if result exists
- `Share`
- `Compress another`

Optional guidance:
`Try a higher limit or a different photo.`

## 23. Motion

Use only after static quality is approved.

Allowed:
- 150–250ms tonal state transitions
- subtle content fade/slide
- photo/result crossfade
- indeterminate progress animation
- pressed state

Avoid:
- bounce
- confetti
- celebratory particle effects
- decorative parallax

## 24. Accessibility

- 48dp minimum tap targets
- semantic labels for icons
- no color-only state
- contrast verified against warm canvas
- font-scale smoke
- result size may scale but cannot push primary action into an unusable state
- selected limit uses fill + check
- status uses icon + text + color

## 25. Compose mapping

Preferred implementation:
Compose Material 3 / Material 3 Expressive where stable and appropriate.

Suggested primitives:
- `Scaffold`
- `Surface`
- `Card`
- `AssistChip` / custom segmented control
- `Button`
- `FilledTonalButton`
- `IconButton`
- `AlertDialog` or custom `Dialog`
- `CircularProgressIndicator` / `LinearProgressIndicator`
- `AnimatedContent` sparingly

Do not force every default M3 component appearance.
Apply the token system above.

Existing Java/domain engine remains authoritative.

## 26. Truth guards

The premium mockup is a visual source, not functional authority.

Do not implement from the mockup:
- fake `72%` progress;
- exact output numbers before a real photo/limit exists;
- unsupported image formats;
- unimplemented retry behavior;
- full portal-compliance claims;
- fake quality claims.

## 27. Visual acceptance criteria

Reject implementation if:
- dominant brand returns to bright cobalt;
- result screen becomes text-first rather than media-first;
- product title wraps at standard 320dp due to trust chip;
- Save uses a floppy icon;
- technical proof becomes the visual headline;
- three large full-width action buttons are stacked;
- white outlined rectangles dominate the screen;
- default Material appearance is shipped without visual-system tuning;
- more text is added than the premium mockup direction requires;
- the result could still be described as “old Android with rounded corners”.

## 28. Current authority

This visual system is approved as the next design basis.

It does NOT authorize coding yet.

Required next step:
create exact high-fidelity First Open / Requirement / PASS / NOT_MET / REDUCED screens using this design system, then obtain direct human visual approval.
