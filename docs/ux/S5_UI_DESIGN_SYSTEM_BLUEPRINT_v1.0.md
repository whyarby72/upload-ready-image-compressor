# S5 UI DESIGN SYSTEM + SCREEN BLUEPRINT v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Status: BINDING FOR IMPLEMENTATION

## 1. Design concept

Name:
**PRECISION UTILITY**

Experience adjectives:
- modern;
- exact;
- calm;
- premium;
- trustworthy;
- lightweight;
- private.

Avoid:
- playful cleaner-app gamification;
- photo-editor complexity;
- fake dashboard density;
- visual gimmicks.

## 2. Implementation architecture

Keep Android XML/View architecture.

Allowed:
- Material Components for Views where they materially improve component quality;
- shape drawables;
- vector drawables;
- reusable styles;
- state-list selectors;
- ConstraintLayout or structured nested layouts when useful.

Forbidden:
- Compose migration;
- webview UI;
- heavy animation framework;
- large design dependency only for cosmetics.

## 3. Token system

### Color

Primary / Cobalt:
- primary: #3157F6
- primary_pressed: #2448D8
- primary_soft: #EEF2FF
- primary_soft_strong: #E2E8FF

Background:
- canvas: #F7F9FC
- surface: #FFFFFF
- surface_subtle: #F2F5F9

Text:
- text_primary: #101828
- text_secondary: #475467
- text_muted: #667085

Outline:
- outline: #D7DEE8
- outline_strong: #B8C2D1

Success:
- success: #0F7A57
- success_surface: #EAF7F1

Warning / NOT_MET:
- warning: #8A4B08
- warning_surface: #FFF4E5

Error:
- error: #B42318
- error_surface: #FEECEB

Neutral / REDUCED:
- info: #3857A6
- info_surface: #EEF3FF

Rules:
- never use semantic color alone to communicate state;
- no gradients in MVP;
- no decorative neon;
- maintain readable contrast.

### Spacing
4dp base grid.

Tokens:
- 4
- 8
- 12
- 16
- 20
- 24
- 32
- 40

Screen horizontal gutter:
- 20dp at 320px reference viewport;
- 24dp when width permits.

### Radius
- small control: 12dp
- chip/selector: 14dp
- button: 16dp
- card: 20dp
- dialog/sheet: 24dp

### Elevation
Use tonal separation + outline as primary depth mechanism.
Avoid old raised-button shadow.

Recommended:
- normal card: 0–1dp visual elevation
- primary CTA: minimal 1–2dp only if needed
- modal: standard platform/material overlay elevation

### Typography
Use system sans / Roboto-compatible stack.

- App label: 18sp, semibold/bold
- Eyebrow/overline: 12–13sp, medium/bold
- Hero: 30sp, bold
- Section title: 20sp, bold
- Main numeric data: 36sp on requirement, 44sp on result, bold
- Body: 16sp, regular
- Supporting body: 14–15sp
- Proof / exact bytes: 14sp medium; may use tabular/monospace-compatible treatment only if it remains visually calm
- Button label: 16sp medium/bold
- Chip label: 14sp medium

Do not shrink critical text to fit.

### Iconography
- vector only;
- 20dp secondary inline icons;
- 24dp action icons;
- 28–32dp product/photo utility mark where needed;
- one consistent stroke/weight family;
- no emoji/Unicode symbols as primary interface icons.

Suggested semantic icons:
- image/photo;
- shield/privacy;
- target/limit;
- save/download;
- share;
- refresh/repeat;
- check-circle;
- warning;
- info.

## 4. Component library

### C1 — ProductHeader
Height target: ~52–60dp content zone.

Composition:
[32dp neutral app mark] [Reduce Photo Size]
optional right-side: compact `On-device` privacy pill.

Rules:
- no static checkmark;
- no result-success icon in global header;
- header should feel product-like, not navigation-heavy.

### C2 — TrustPill
Rounded 14dp.
Soft success/neutral surface.
Shield icon 16–18dp.
Text: `On-device`.

Secondary reassurance can be text below hero:
`Original stays untouched · No account`

### C3 — PrimaryButton
Height: 56dp.
Radius: 16dp.
Filled cobalt.
White text.
Optional leading icon.
No all caps.
Clear disabled state:
- muted surface;
- muted text;
- no ambiguous blue.

### C4 — SecondaryButton
Height: 52–56dp.
Outlined or filled-tonal.
Radius 16dp.

### C5 — TertiaryButton
Text/low-emphasis.
Height >=48dp.
No old gray raised-button appearance.

### C6 — DataCard
Radius 20dp.
White surface.
1dp outline.
Padding 16dp.

Use for:
- current photo;
- before/after comparison;
- result metadata.

### C7 — TargetChip
Height: 48dp minimum.
Radius: 14dp.
Unselected:
- white/surface;
- outline;
- text primary.

Selected:
- primary_soft_strong;
- 1.5–2dp primary outline;
- text primary;
- optional small check/selection indicator.

Disabled:
- low-contrast neutral.

Grid:
2 rows x 3 columns, equal visual widths.

### C8 — StatusBadge
Compact pill.

PASS:
- check-circle + `MEETS LIMIT`
- success_surface / success

NOT_MET:
- warning icon + `TARGET NOT MET`
- warning_surface / warning

REDUCED:
- info icon + `SMALLER COPY`
- info_surface / info

Do not use `UPLOAD READY ✓` as the only truth statement.

### C9 — ExactProofRow
Example:
`99,875 bytes ≤ 100,000 bytes`

Style:
- 14sp medium;
- semantic text color;
- no excessive visual weight;
- never hidden behind expansion.

### C10 — ComparisonCard
Two-column or horizontal flow:

BEFORE
3.46 MB

arrow

AFTER
99.9 KB

Optional third microstat:
`97% smaller`
only if computed accurately and useful.

### C11 — CustomLimitDialog
Radius 24dp.
Title:
`Custom upload limit`

Content:
- numeric text field;
- KB / MB segmented choice;
- helper `1 KB–50 MB`;
- inline validation;
- Cancel;
- `Use limit`.

Rules:
- keep dialog open on validation error;
- preserve last-valid target;
- no error Toast as sole feedback;
- no parser semantic changes.

## 5. Screen blueprint

### Screen A — First Open

Reference 320x640 target composition:

Top 20–24dp:
ProductHeader.

Gap 28–32dp.

Hero:
`Make your photo ready to upload.`
30sp bold, max ~2 lines.

Supporting copy:
`Choose a JPEG, set the website limit, and verify the result.`

Visual utility panel:
- compact photo/file illustration made from simple vector/surface geometry;
- optional mini labels `MB → KB`;
- no large decorative illustration.

Primary CTA:
[image icon] `Choose photo`

Trust row:
[shield] `On-device`
`Original stays untouched · No account`

First viewport goal:
- product identity;
- buyer job;
- primary action;
- privacy reassurance;
all visible without scrolling.

### Screen B — Requirement / Target

Header stays compact.

Current photo card:
eyebrow: `CURRENT PHOTO`
large size: `3.46 MB`
metadata row:
`2400 × 1600` · `JPEG`
small local badge:
`On-device`

Section:
`What's the upload limit?`
support:
`Choose the maximum size shown on the website or form.`

TargetChip grid:
50 KB | 100 KB | 200 KB
500 KB | 1 MB | Custom

Neutral proof:
`Choose the upload limit`

After selection:
target summary surface:
[target icon] `Required ≤ 100 KB`

Primary CTA:
`Make it upload-ready`

Secondary:
[info] `I don't know the website limit`

Rules:
- no target selected by default;
- CTA disabled before explicit valid target;
- unknown action visually secondary but discoverable.

### Screen C — Custom Limit Dialog

Title:
`Custom upload limit`

Numeric input:
large enough for values such as `10.5`.

Unit segmented control:
`KB` | `MB`

Helper:
`1 KB–50 MB · up to 3 decimal places`

Inline error examples:
`Enter a value between 1 KB and 50 MB.`
`Use either a dot or comma, not both.`

Actions:
Cancel
`Use limit` primary.

### Screen D — Progress

Centered contained card or clean center layout.

Icon / small circular progress.
Title:
`Making a smaller copy…`

Sub:
`Processing on-device. Your original stays untouched.`

No fake percent.
No unnecessary spinner-plus-large-empty-screen feel.

### Screen E — PASS Result

StatusBadge:
`MEETS LIMIT`

Large result:
`99.9 KB`

ExactProofRow:
`99,875 bytes ≤ 100,000 bytes`

ComparisonCard:
BEFORE 3.46 MB → AFTER 99.9 KB

Metadata:
`1200 × 800 · JPEG`
`Original untouched · Metadata removed from compressed copy`

Actions:
1. Primary: [save] `Save copy`
2. Secondary: [share] `Share`
3. Tertiary: [repeat] `Compress another`

Optional trust microcopy:
`Verified against the maximum size you entered.`

### Screen F — NOT_MET Result

StatusBadge:
`TARGET NOT MET`

Large result:
actual final safe size.

Exact proof:
`52,410 bytes > 50,000 bytes`

Buyer-first explanation:
`We couldn't safely reach 50 KB without making the photo too blurry.`

Secondary technical detail only if needed:
`Smallest safe result under the current quality guard.`

Actions:
- Save copy may remain available if result is useful;
- Share secondary;
- Compress another tertiary.

Never style NOT_MET as success.

### Screen G — REDUCED Result

StatusBadge:
`SMALLER COPY`

Large result.

Explanation:
`No upload limit was entered, so compatibility isn't verified.`

No green success state.
No PASS wording.

Actions:
Save copy / Share / Compress another.

## 6. Small-screen rules

At 320x640:
- first-open primary CTA visible without scroll;
- requirement primary target grid + primary CTA should fit with intentional scroll at most for secondary unknown action;
- result must show state, final size, proof, and at least primary Save CTA in first meaningful viewport where feasible;
- no clipped half-button caused by accidental spacing;
- scrolling must feel intentional.

At 360x800:
- all major content should breathe with 24dp horizontal gutter where possible.

## 7. Interaction hierarchy

Global:
one primary action per state.

First open:
Choose photo.

Requirement:
Make it upload-ready.

Result:
Save copy.

Secondary:
Share / unknown-limit route.

Tertiary:
Compress another / low-emphasis navigation.

## 8. Animation

Allowed:
- 100–200ms state/color transitions;
- subtle press/ripple;
- simple progress motion.

Not needed:
- hero animation;
- parallax;
- card morphing;
- celebration animation;
- confetti.

## 9. Accessibility

- minimum 48dp touch targets;
- icons with content descriptions when actionable;
- selected target uses shape/border/icon + color;
- state badge uses icon + text + color;
- contrast checked;
- no critical info conveyed only by color;
- font-scale smoke required.

## 10. Quality gate

A redesign FAILS even if prettier when:
- exact proof becomes less visible;
- selected target becomes ambiguous;
- Save/Share result URI behavior changes;
- no-target state becomes unclear;
- old raised-button appearance remains;
- app resembles a dashboard/cleaner rather than a focused upload-limit utility;
- first screen needs explanation before the buyer understands the job.

## 11. Implementation acceptance preview

Visual reviewer should be able to say YES to all:
- current 2026 utility aesthetic;
- visually coherent system;
- clear buyer job;
- strong requirement selection;
- result confidence;
- no legacy Android button feel;
- no decorative clutter;
- truthful semantics;
- usable on 320x640.
