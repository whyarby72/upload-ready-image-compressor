# S5 UI/UX MODERNIZATION BRIEF v1.0

Product: REDUCE PHOTO SIZE: KB LIMIT
Decision: TEST
Stage: pre-Play Internal Testing
Priority: REQUIRED

## Why this redesign exists

The product's functional truth layer is strong, but the current presentation is below the desired professional bar.

The problem is structural rather than merely cosmetic:
- legacy Android theme/component styling;
- old platform button geometry;
- weak app-shell identity;
- prototype-like stacked composition;
- preset controls look like generic system buttons;
- static checkmark branding conflicts with result-state language;
- result actions do not prioritize the concrete saved-file completion job.

A successful redesign must improve perceived quality immediately on first open without changing buyer-truth semantics.

## Experience target

The app should feel:
- focused;
- modern;
- trustworthy;
- lightweight;
- fast;
- private;
- professionally shipped.

It should not feel:
- experimental;
- developer-tool-like;
- old Android;
- template-driven;
- cluttered;
- overdesigned.

## Screen concept

### First open
Compact header + privacy badge.
Strong hero.
Short support copy.
Modern primary Choose photo button.
Quiet reassurance row.

### Requirement
Modern photo information card.
Clear one-line section title.
Preset chips/segmented controls.
Explicit selected requirement.
Primary compression CTA.
Secondary unknown-limit action.

### Progress
Contained local-processing state.

### Result
Semantic status badge.
Very large final size.
Exact verification proof.
Before -> after comparison card.
Save primary.
Share secondary.
Compress another tertiary.

## Visual system

Use one coherent token system for:
- spacing;
- radius;
- typography;
- surfaces;
- borders;
- semantic states;
- iconography.

Avoid individually styled one-off controls.

## Product constraints

Truth > beauty.
A redesign that makes a false PASS easier to misunderstand is a regression.
A redesign that hides exact proof is a regression.
A redesign that adds significant maintenance/dependency burden without buyer benefit is a regression.
