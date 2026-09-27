# S5 UI IMPLEMENTATION CONTRACT v1.0

Observed: 2026-09-27
Product: REDUCE PHOTO SIZE: KB LIMIT
Task: TASK-S5-004
Status: BINDING / CODE-READY

## 1. Source architecture

Keep:
- single-activity View/XML app;
- Java 17;
- minSdk 29 / targetSdk 36;
- existing compression engine and state model;
- existing package/applicationId.

No Compose migration.
No backend/network.
No ads/analytics.

Default: do not add a new UI framework dependency.

## 2. Files expected to change

Expected UI-source scope may include:
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/values/styles.xml`
- `app/src/main/res/values/colors.xml`
- `app/src/main/res/values/strings.xml`
- `app/src/main/res/values/dimens.xml` if created
- `app/src/main/res/drawable/*.xml`
- `app/src/main/java/com/afradadmedia/reducephotosize/MainActivity.java`
- UI-focused tests/evidence.

Compression-engine changes are out of scope unless required to fix a discovered regression.

## 3. First Open contract

Header:
- vector app/photo utility mark;
- `Reduce Photo Size`;
- compact `On-device` trust pill if layout permits.

Hero:
`Make your photo ready to upload.`

Body:
`Choose a JPEG, set the website limit, and verify the result.`

Primary:
`Choose photo`

Trust:
`On-device`
`Original untouched`
`No account`

No exact predicted output size.

## 4. Requirement contract

Current-photo card may show:
- filename from `ImageInfo.displayName` with ellipsis;
- dominant current size;
- width × height;
- JPEG;
- on-device cue.

Target grid:
- 50 KB
- 100 KB
- 200 KB
- 500 KB
- 1 MB
- Custom

State rules:
- no default target;
- neutral `Choose the upload limit`;
- known CTA disabled until selection;
- selected tile uses border + tonal fill + indicator, not color only;
- 48dp min target.

Selected summary:
`Required ≤ {target}`

Optional support:
`We'll verify the actual result against this limit.`

Primary:
`Make it upload-ready`

Secondary:
`I don't know the website limit`

## 5. Custom contract

Modal:
`Custom upload limit`

Input:
numeric text field.

Unit:
KB / MB.

Helper:
`1 KB–50 MB · use a dot or comma · up to 3 decimal places`

Inline error.
Dialog remains open when invalid.

Actions:
Cancel
`Use limit`

No parser-rule changes.

## 6. Progress contract

Indeterminate only.

Known path:
- `Compressing on-device…`
or if source already <= target:
- `Verifying actual size…`

Unknown:
- `Making a smaller copy…`

Support:
`Your original stays untouched.`

Optional trust:
`Processing stays on this device.`

No percent.
No fabricated phases.

## 7. Result-state contract

### PASS / ALREADY_READY

Badge:
`MEETS LIMIT`

Support:
`The file meets the maximum size you entered.`

Large:
friendly decimal-SI result size.

Proof:
`{outputBytes} bytes ≤ {targetBytes} bytes`

Comparison:
BEFORE / AFTER using same decimal-SI formatter.

Disclosure:
`Original untouched · metadata removed from compressed copy`

Actions:
1. `Save copy`
2. `Share`
3. `Compress another`

### NOT_MET

Badge:
`TARGET NOT MET`

Support:
`We stopped before quality dropped below the app's safety guard.`

Proof:
`{outputBytes} bytes > {targetBytes} bytes`

Guidance:
`Try a higher upload limit or a different photo.`

If result file exists:
1. `Save current copy`
2. `Share`
3. `Compress another`

Do not add a new retry/limit-navigation feature in TASK-S5-004.

### REDUCED / ALREADY_SMALL

Badge:
`SMALLER COPY`

Support:
`No upload limit was entered, so compatibility isn't verified.`

No PASS styling.

Actions:
1. `Save copy`
2. `Share`
3. `Compress another`

## 8. Friendly size formatting

Target formatting remains exact as already bound.

General file-size display must move to decimal SI for consistency.

For example:
- 3,628,114 bytes -> approximately 3.63 MB
- 421,312 bytes -> approximately 421.3 KB
- 99,875 bytes -> approximately 99.9 KB

Exact bytes remain shown in proof for known-limit states.

## 9. Visual components

Primary CTA:
- 56dp;
- 16dp radius;
- cobalt fill.

Secondary:
- 52–56dp;
- outline/tonal.

Tertiary:
- >=48dp;
- text/low emphasis.

Card:
- 20dp radius;
- 1dp outline;
- low/no elevation.

Target tile:
- 48–56dp;
- 14dp radius.

Status surfaces:
- semantic icon + label + color.

No Unicode status glyphs.

## 10. Small-screen contract

At 320×640:
- First Open: hero + Choose photo + trust cues must be usable without accidental clipping.
- Requirement: title + target grid + selection summary + primary CTA must remain reachable with intentional scrolling.
- Result: status + result size + exact proof + Save must be reachable without layout breakage.

At 360×800:
- no excessive dead space;
- no stretched oversized cards.

## 11. Accessibility contract

- 48dp targets;
- actionable icon content descriptions;
- selected target not color-only;
- status not color-only;
- font-scale smoke at >=1.3x where environment supports;
- no horizontal clipping at standard large-font smoke;
- logical focus order.

## 12. Regression contract

Must re-prove:
- no default target;
- Custom 10.5 KB / 1.5 MB;
- PASS;
- NOT_MET;
- REDUCED;
- Save;
- Share;
- original preservation;
- EXIF orientation correctness;
- API29;
- API36;
- offline/no INTERNET permission;
- no broad media/storage permissions.

## 13. Artifact rule

Pre-redesign AAB:
`064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc`

becomes provenance-only as soon as TASK-S5-004 changes app source/resources.

Fresh:
- debug APK;
- release APK;
- release AAB;
- bytes;
- SHA-256;
- signing state
are required.

## 14. Visual evidence contract

Capture:
1. first open 320×640;
2. first open 360×800;
3. requirement unselected;
4. 100 KB selected;
5. Custom 10.5 KB;
6. progress;
7. PASS;
8. NOT_MET;
9. REDUCED;
10. Save success;
11. Share sheet;
12. API29 requirement;
13. large-font first open/requirement smoke.

## 15. Final reviewer gate

Codex may report implementation complete, but TASK-S5-004 is not PASS until CHAT independently verifies:
- source scope;
- screenshots;
- behavior;
- fresh artifact hashes;
- visual quality against Precision Utility benchmark.

Play remains HOLD until that review passes.
