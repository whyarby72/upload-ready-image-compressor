# S5 HIGH-FIDELITY MOCKUP V2 REVIEW v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Disposition: IMPLEMENTATION_READY_AFTER_BOUND_CORRECTIONS

## Summary

Mockup v2 successfully establishes the target visual quality bar.

It is approved as the visual reference for:
- First Open;
- Requirement;
- Custom Limit;
- Progress;
- PASS;
- NOT_MET;
- REDUCED.

The eighth “Requirement Helper” screen is deferred from MVP because it adds a new educational surface that is not required to complete the core buyer job.

The mockup is not literal source-of-truth. The corrections below are binding.

## Screen-by-screen disposition

### 1. First Open — PASS WITH MINOR TWEAKS

KEEP:
- compact product identity;
- cobalt icon;
- hero hierarchy;
- one dominant Choose photo CTA;
- bottom trust cues.

CHANGE:
- remove/de-emphasize `KB LIMIT` under the in-app product name;
- do not duplicate `No account` both in header pill and trust row unless it still feels visually quiet;
- illustration must remain generic and must not show an exact promised output size.

Final in-app header:
`Reduce Photo Size`

### 2. Selected Photo / Requirement — PASS WITH MINOR TWEAKS

KEEP:
- selected-photo card;
- large current size;
- 2x3 target tile grid;
- disabled primary CTA before selection;
- secondary unknown-limit route.

Source supports `ImageInfo.displayName`, so showing a filename is allowed.

Filename rules:
- single line;
- ellipsize end;
- never dominate size/dimensions;
- no dependency on filename for truth.

Unknown-limit card/button must map to the existing unknown-limit action.
It must remain explicit:
`I don't know the website limit`

Do not replace the action with vague “Not sure?” education only.

### 3. Custom Limit — PASS WITH CORRECTIONS

KEEP:
- custom modal;
- large numeric input;
- KB / MB segmented unit choice;
- Cancel / Use limit actions.

CHANGE:
- helper must mention both supported decimal separators where useful:
  `Use a dot or comma for decimals · up to 3 decimal places`;
- remove unverified “common limit / forum limit” example claims;
- validation error must appear inline;
- invalid input must not dismiss the dialog;
- cancelled/invalid input must preserve last-valid target state.

### 4. Progress — FAIL AS DRAWN / REPLACE WITH TRUTHFUL INDETERMINATE STATE

The mockup shows:
- `68%`;
- “Analyzing photo”;
- “Finding best compression settings”;
- “Compressing image”;
- “Finalizing result”.

The current compression engine does not expose measured percentage or explicit phase callbacks.

Therefore these indicators would be fabricated.

Required implementation:
- indeterminate progress indicator only;
- title based on actual operation:
  - `Compressing on-device…`
  - or `Verifying actual size…`
  - or `Making a smaller copy…`;
- support:
  `Your original stays untouched.`
- optional privacy row:
  `Processing stays on this device.`

No percentage.
No fake stage checklist.

### 5. PASS / ALREADY_READY — PASS WITH TRUTH CORRECTIONS

KEEP:
- success status surface;
- large final size;
- exact-byte proof;
- before/after comparison;
- metadata/original disclosure;
- Save primary / Share secondary / Compress another tertiary.

Status:
`MEETS LIMIT`

Do not say:
`Your photo is ready to upload.`

Preferred support:
`The file meets the maximum size you entered.`

Reason:
the app verifies maximum file size, not every external portal rule.

Decimal-SI consistency is mandatory.

Example:
- 3,628,114 bytes => 3.63 MB, not 3.46 MB;
- 99,875 bytes => 99.9 KB or 99.88 KB depending display precision, but exact bytes remain authoritative.

### 6. NOT_MET — PASS VISUAL DIRECTION / ACTIONS MUST REMAIN IN-SCOPE

KEEP:
- amber status;
- exact-byte proof;
- buyer-first explanation;
- safe-quality explanation.

Preferred explanation:
`We stopped before quality dropped below the app's safety guard.`

The current engine message may contain technical details such as JPEG quality 40 / 720 px floor.
Do not promote those internals to the primary buyer copy.
They may remain secondary evidence/debug detail if needed.

Do NOT add a new “Choose different limit” navigation flow in this task unless it can be implemented as an explicitly tested state transition without broadening product scope.

MVP action hierarchy for NOT_MET when a result file exists:
1. `Save current copy`
2. `Share`
3. `Compress another`

The screen may advise:
`Try a higher upload limit or a different photo.`

### 7. REDUCED / ALREADY_SMALL — PASS WITH DECIMAL CORRECTION

KEEP:
- blue/info semantic state;
- large result size;
- explicit no-limit disclaimer;
- before/after;
- Save / Share / Compress another.

Status:
`SMALLER COPY`

Support:
`No upload limit was entered, so compatibility isn't verified.`

Decimal-SI consistency mandatory.

Example:
421,312 bytes => approximately 421.3 KB, not 412 KB.

Never show green PASS semantics.

### 8. Requirement Helper — DEFER FROM MVP

The extra “About upload limits” helper is useful conceptually but is not required for the core flow.

Reasons to defer:
- adds another screen/modal;
- adds copy/support surface;
- adds accessibility/navigation QA;
- no behavioral evidence yet that users need it;
- the main requirement screen can explain the task sufficiently.

If internal testing later shows repeated confusion, reopen as a separately validated UX enhancement.

## Implementation architecture decision

Current app has no UI dependency beyond platform Views.

Default TASK-S5-004 implementation:
**dependency-light native XML/View system**

Use:
- XML layout;
- custom shape/state-list drawables;
- vector drawables;
- platform TextView/Button/EditText/ProgressBar/Dialog/AlertDialog as appropriate;
- reusable styles and dimensions.

Do not add Material Components merely to obtain rounded buttons/chips.

A Material Components dependency may be proposed only if a concrete interaction/accessibility requirement cannot be met cleanly with the current View stack.
It must not be added silently.

## Custom-dialog implementation note

Current AlertDialog positive button auto-dismisses on click.

TASK-S5-004 should improve this:
- create/show the dialog;
- attach the positive-button listener after `show()`;
- on invalid input, render inline error and keep dialog open;
- on valid input, apply target and dismiss.

This is an approved UX correction and must preserve parser semantics.

## Result-friendly size rule

All current/result/before/after friendly file sizes must use decimal SI consistently.

Recommended presentation:
- >= 1 MB: up to 2 decimals, trim trailing zero where practical;
- >= 1 KB: up to 1–2 decimals when needed;
- exact byte row remains authoritative.

Do not mix 1024-based friendly values with decimal target values.

## Implementation readiness verdict

READY FOR CODEX after reading:
1. benchmark forensics;
2. design-system blueprint;
3. mockup v1 truth review;
4. this v2 review;
5. final implementation contract.

No additional mockup is required before first implementation pass.
