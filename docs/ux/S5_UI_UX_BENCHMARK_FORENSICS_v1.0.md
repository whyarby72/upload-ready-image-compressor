# S5 UI/UX BENCHMARK FORENSICS v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Status: BENCHMARK COMPLETE / DESIGN DIRECTION BOUND

## Method

This benchmark separates three evidence classes:

1. MARKET / WORKFLOW REFERENCES
   Current public Android utility/photo/file apps used to understand buyer vocabulary, workflow density, privacy positioning, target-size flows, Save/Share expectations, and market conventions.

2. VISUAL / COMPOSITION REFERENCES
   Current Dribbble, mobile utility concepts, storage cleaner concepts, file-manager concepts, scanner concepts, and compressor screenshots used only as aesthetic/compositional references. These are not treated as proof of usability or conversion.

3. DESIGN-SYSTEM REFERENCES
   Official Android Material 3 and Figma UI-kit/component guidance used to anchor reusable components, hierarchy, surfaces, buttons, chips, cards, shapes, and implementation discipline.

Pinterest search supplied by the user is treated as a moodboard channel only because the exact search feed could not be deterministically crawled.

## Benchmark set — 30 reference objects

### A. Market / workflow references

1. Files by Google — file utility, storage summary, simple high-trust actions.
2. Adobe Scan — scanner utility, strong primary task framing, large installed base.
3. Puma: Photo Resizer Compressor — exact-size presets and image utility workflow.
4. Photo Compressor and Resizer — established compressor/resizer workflow.
5. LitPhoto — compress/resize utility and one-tap simplification.
6. Photo Compressor: Resize Image — local/private/no-account positioning and before/after size.
7. Image Compressor - MB to KB (Byteforge) — explicit target-size mode + offline promise.
8. Image Compressor: MB to KB (ProEffectMedia) — target exact file size + before/after framing.
9. Image Compressor – KB & MB (Ashmawi) — quick targets + custom target.
10. Photo Compressor & Resizer (SN3 Apps) — pick -> target/quality -> save/share flow.
11. Cx File Explorer — modern file utility, storage analysis, clean information hierarchy.
12. File Manager Plus — utility navigation and at-a-glance storage state.

### B. Visual / composition references

13. Sweeply Storage Cleaner — restrained blue system, dominant primary action, large numeric state, rounded cards.
14. Clean AI Storage Cleaner — soft tonal surfaces and clean data hierarchy.
15. Apps Screenshot / Phone Cleaner — energetic but structured utility dashboard.
16. iClean Storage Cleaner — utility-oriented modern mobile composition.
17. Smart Recycle Bin — premium rounded components and clear task cards; dark/neon treatment rejected for this product.
18. Modern File Manager App — neutral surfaces, structured categories, icon-led information architecture.
19. File Manager / My Files concept — circular/visual storage summary and modular cards.
20. Document Scanner App concept — strong single-purpose utility framing and export actions.
21. QR Code Scanner — one dominant task with supporting controls kept secondary.
22. Scanner App concept — minimal action-forward utility composition.
23. Cam Scanner UI/UX — clean light surface, blue accent, strong scan task.
24. Compressor (Blackhole) — original/compressed side-by-side comparison and metric card.
25. Compress Photos / Size Reducer visual — selected photo card + task-specific controls.
26. FileNest File Manager UI Kit — modern clean storage/productivity component system.
27. File Manager UI Kit / UIworkshop — vector/component-based utility screen system.
28. Vault & Vine / Sleek file-manager template — cool neutral canvas + cobalt accent + hairline structure.

### C. Design-system / implementation references

29. Android Material 3 — tonal elevation, cards, chips, filled/tonal/outlined/text button hierarchy, flexible color/shape system.
30. Figma Mobile UI Kit / Material 3 UI Kit guidance — reusable components, styles, variables, example screens, component instances, design-system consistency.

## What repeats across strong modern references

### FACT — recurring visual patterns
- one dominant task per screen;
- large numeric or outcome data when size/storage is the job;
- rounded containers rather than old raised rectangular buttons;
- tonal surface separation instead of heavy drop shadows;
- icon + label pairs for trust and actions;
- limited accent palette;
- clearly tiered action emphasis;
- modular cards/chips;
- generous but purposeful whitespace;
- visible before/after comparison in compressor/storage use cases.

### INFERENCE — best fit for this product
The best visual archetype is not “phone cleaner”, “photo editor”, or “file manager”.
It is:

**PRECISION UTILITY**

A focused tool that feels modern, calm, trustworthy, and exact.

The design should borrow:
- precision and outcome hierarchy from compressor apps;
- surface/component quality from cleaner/file-manager concepts;
- interaction sanity from Material 3;
- reusable component discipline from Figma UI-kit practice.

## Patterns to adopt

1. Compact product header, not a large navigation shell.
2. One primary CTA on first open.
3. Photo/current-state card with dominant file size.
4. Presets as selectable chips/tiles, not native platform buttons.
5. Explicit requirement state as a small proof/status row.
6. Result state badge + large result size + exact proof.
7. Before -> after comparison card.
8. Save as the concrete completion action.
9. Share as secondary.
10. Tonal surfaces and 1dp outlines instead of obvious legacy elevation.
11. Consistent vector icon family.
12. Tight component tokenization.

## Patterns explicitly rejected

### REJECT — visual-only trends that hurt this product
- glassmorphism;
- oversized gradients;
- neon/accent overload;
- giant 3D illustrations;
- decorative storage charts;
- bottom navigation for a one-job app;
- multiple dashboard tabs;
- card stacking with no information purpose;
- tiny gray labels;
- excessive animation;
- iOS-specific chrome on Android;
- charts that do not answer the buyer job;
- hidden exact-byte proof.

## Competitive-gap interpretation

Many compressor apps compete on feature breadth:
- resize;
- batch;
- crop;
- conversion;
- quality sliders;
- social presets;
- PDF.

This product's differentiation should remain:
- explicit external upload limit;
- exact result verification;
- honest NOT_MET;
- unknown-limit honesty;
- local/privacy-first;
- minimal workflow.

Therefore the UI should communicate **confidence and precision**, not breadth.

## Benchmark verdict

The previous TASK-S5-004 brief direction was correct but too generic.

Binding visual direction after benchmark:
**Precision Utility / Cobalt-Neutral / Modern Editorial Android**

Implementation should now follow:
`docs/ux/S5_UI_DESIGN_SYSTEM_BLUEPRINT_v1.0.md`
