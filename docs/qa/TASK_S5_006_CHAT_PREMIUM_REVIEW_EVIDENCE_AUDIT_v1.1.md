# TASK-S5-006 — CHAT PREMIUM REVIEW EVIDENCE AUDIT v1.1

Observed: 2026-09-29
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-006`
Reviewed evidence closure: `d22dff0c0abb568d9a6226984da67e7b7bd8c4fe`
Repair source: `bfd3c329efbc58b82e99c101d744c3746c711468`

## Disposition

`HOLD_SINGLE_EVIDENCE_DEFECT / HUMAN PREMIUM REVIEW NOT READY`

The repair materially fixed most prior defects, but one required runtime artifact is still semantically invalid.

## Confirmed repaired items

Direct CHAT review confirms:

- `result_pass_api36.png` is now a genuine PASS state:
  - `MEETS LIMIT`;
  - `980 KB`;
  - `979637 bytes ≤ 1000000 bytes — PASS`;
  - real result media;
  - Before/After visible.

- `before_after_landscape_api36.png` now independently proves a landscape case:
  - landscape source/result visible;
  - metadata shows `2400 × 1600`;
  - PASS semantics;
  - capture is not the NOT_MET image.

- `custom_limit_api36.png` now visibly shows:
  `Use a dot or comma for decimals · up to 3 decimal places`.

- `PROJECT_STATE.artifacts.current_build` now binds the repaired debug APK:
  `34c6af2c5f42d18893608b923dac28fef2ba8710802ae4fbe55bde9839c05814`.

- Requirement, Processing, NOT_MET, REDUCED, Home 320 and Home font-scale 1.3 captures are coherent with the intended Warm Ink / real-media direction.

## Remaining deterministic defect

### E6 — Home 360 screenshot is Android launcher/home screen, not app Home

File:
`evidence/screenshots/s5_006_visual_productization/home_api36_360x800.png`

Directly rendered content shows:
- Android wallpaper;
- date;
- dock icons;
- Google search bar.

It does NOT show the app Home screen.

Therefore these current claims are false for this artifact:
- screenshot manifest semantic says actual Home;
- `semantic_controls.home360_not_splash=true`;
- S5-VAC-02 says actual Home was recaptured at 360x800;
- S5-VAC-AUDIT-01 says Home360 is actual Home.

This is not a source/UI defect. It is a screenshot semantic-binding defect.

## Why the previous control still failed

The prior repair prompt required semantic inspection, but the closure still accepted a screenshot that was neither splash nor app content.

Conclusion:
`MANUAL/DECLARATIVE SCREENSHOT SEMANTICS ARE INSUFFICIENT`.

The next capture must bind:
1. foreground package evidence at capture time;
2. UI hierarchy semantic anchors at capture time;
3. screenshot bytes from the same capture session.

## Visual quality status

Based on valid reviewed screens, the implemented visual direction is materially improved and no blocking premium-quality defect has yet been observed in:
- launcher identity;
- Home 320;
- Home 1.3x;
- Custom Limit;
- Requirement;
- Processing;
- PASS;
- NOT_MET;
- REDUCED;
- landscape/portrait Before-After.

However the required 360x800 Home state remains unproven.

## Gate

- source implementation: PASS_WITHIN_SCOPE
- machine build/test/lint: PASS
- protected domain diff: PASS
- screenshot set: HOLD_SINGLE_ARTIFACT
- human PREMIUM_QUALITY / VISUAL_PRODUCTIZATION: NOT_READY

No signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication.

## Required next action

Evidence-only recapture. No source change required.

Capture Home 360x800 only after:
- `dumpsys` confirms foreground package `com.afradadmedia.reducephotosize`;
- UIAutomator hierarchy from the same state contains:
  - `Reduce Photo Size`;
  - `Fit your photo to an upload limit.`;
  - `Choose photo`;
  - `On-device · original untouched`.

Persist the hierarchy as companion evidence and update hashes/manifests/state.
