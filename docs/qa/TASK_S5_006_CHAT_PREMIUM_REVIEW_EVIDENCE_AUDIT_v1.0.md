# TASK-S5-006 — CHAT PREMIUM REVIEW / EVIDENCE INTEGRITY AUDIT v1.0

Observed: 2026-09-28
Product: REDUCE PHOTO SIZE: KB LIMIT
Branch: `task/TASK-S5-006`
Reviewed HEAD: `171c70ba7112c29f3fab3ff234a37ef32e104062`
Implemented source commit: `d165d6b325258346b9f55c76b3dbbfc12aa1a538`

## Disposition

`HOLD_MACHINE_EVIDENCE_INCOMPLETE`

Do NOT request human `PREMIUM_QUALITY / VISUAL_PRODUCTIZATION` approval yet.

The source implementation is materially improved and the bounded source diff respects the protected domain boundary, but the evidence pack contains deterministic semantic misbindings that invalidate the claim that the required runtime matrix is complete.

## Source / scope verification

Implementation diff from pre-task HEAD to source commit changes only:
- `app/src/main/AndroidManifest.xml`;
- `app/src/main/java/com/afradadmedia/reducephotosize/MainActivity.kt`;
- new brand / launcher / Home illustration vector resources;
- adaptive launcher resources.

No protected compression/domain file is changed in the implementation commit.

Confirmed source improvements:
- header now uses `ic_brand_compress_frame`, not generic `ic_photo`;
- manifest binds explicit `android:icon` and `android:roundIcon`;
- Home uses `ill_home_fit_to_limit`;
- launcher adaptive/round/monochrome resources exist;
- Requirement/Processing/Result continue to use real user media paths.

## Direct visual review

### Launcher
`launcher_api36.png`
- dedicated Compression Frame Mark is visible in the Android launcher;
- identity is distinct from the prior generic photo glyph;
- no blocking launcher defect observed.

### Home 320x640
`home_api36_320x640.png`
- actual Home is captured;
- new header mark is present;
- purpose-built fit-to-limit illustration is present;
- CTA is visible and usable;
- no clipping observed.

### Home font scale 1.3
`home_font_1_3x_api36.png`
- actual Home is captured;
- hierarchy remains usable;
- CTA remains visible;
- no blocking overlap observed.

### Requirement / Custom / Processing / REDUCED / portrait result
Directly reviewed and broadly coherent with the Warm Ink / real-media direction.

## Deterministic evidence defects

### DEFECT E1 — required Home 360 screenshot is not Home

File:
`evidence/screenshots/s5_006_visual_productization/home_api36_360x800.png`

Observed content:
Android launch/splash frame showing only the centered Compression Frame Mark.

It does NOT show:
- app header;
- Home headline;
- Home hero illustration;
- Choose photo CTA;
- Home trust line.

Therefore the manifest semantic:
`branded hero and Choose photo CTA`
is false for this artifact.

Impact:
- required 360x800 Home runtime evidence is missing;
- S5-VAC-02 cannot remain PASS.

### DEFECT E2 — file named result_pass is NOT_MET

File:
`evidence/screenshots/s5_006_visual_productization/result_pass_api36.png`

Observed content explicitly renders:
- `TARGET NOT MET`;
- `85 KB`;
- `84884 bytes > 50000 bytes — NOT_MET`;
- `Try a higher limit or a different photo.`

It is not a PASS state.

Impact:
- required fresh PASS screenshot is absent/mislabeled;
- screenshot manifest claim `PASS result with real media and exact-byte proof` is false for this artifact;
- S5-VAC-03 cannot remain PASS.

### DEFECT E3 — landscape Before/After artifact is the same semantic capture as NOT_MET portrait flow

`before_after_landscape_api36.png` and `result_not_met_api36.png` are recorded with the same byte size and SHA-256:
`c998c97539c47f29d331a5b35914a5bffc6f5855ce81dec8fc5ce3492082b0cb`.

The directly rendered image shows the same NOT_MET result capture and does not independently prove a landscape-source Before/After case.

Impact:
- required fresh landscape Before/After evidence is not independently established.

### DEFECT E4 — current state metadata is internally stale

`PROJECT_STATE.json → artifacts.current_build.apk_sha256` still records an older debug APK digest:
`fedcffb39d4e0cbe3b811d7e6e1e66c235a0de2bd1a0f92c7776e75409ec87d3`

while `S5_006_ARTIFACT_PROOF.json` records the TASK-S5-006 debug APK:
`3065ce39a568ad3644544c54cd0c7e244c04b005459a74a7deb2ad90bc1d739f`.

This is a Source-of-Truth reconciliation defect.

### DEFECT E5 — Custom Limit helper still diverges from binding mockup review

Current runtime/source helper:
`Decimal KB or MB · 1 KB to 50 MB`

Binding mockup review required the helper to expose decimal-entry semantics where useful:
`Use a dot or comma for decimals · up to 3 decimal places`

The parser behavior itself remains correct; this is buyer-facing guidance / mockup-fidelity drift.

Impact:
- fix is presentation-only and remains within the already authorized TASK-S5-006 scope;
- no domain change is required.

## Visual quality assessment so far

The new Home at 320dp and 1.3x is a material improvement:
- dedicated visual identity now exists;
- the hero explains the compression job instead of using only a generic photo glyph;
- the visual language remains restrained and coherent with Warm Ink;
- real media appropriately provides richness after photo selection.

However premium-quality approval must not be requested on a manifest that falsely labels splash as Home and NOT_MET as PASS.

## Evidence status

- source implementation: `PASS_WITHIN_AUTHORIZED_SCOPE`
- protected domain diff: `PASS`
- launcher identity: `PASS`
- Home 320: `PASS`
- Home font 1.3: `PASS`
- Home 360: `HOLD / RECAPTURE_REQUIRED`
- PASS state: `HOLD / RECAPTURE_REQUIRED`
- landscape Before/After: `HOLD / RECAPTURE_REQUIRED`
- Custom helper fidelity: `REWORK_PRESENTATION_ONLY`
- screenshot manifest: `INVALIDATED_BY_SEMANTIC_MISBINDING`
- mockup-runtime fidelity matrix finality: `INVALIDATED_PENDING_RECAPTURE`
- human premium-quality gate: `NOT_READY`

## Required repair

Codex must:
1. update the Custom Limit helper to the binding decimal-entry guidance while preserving parser/range truth;
2. rebuild/retest after that presentation source change;
3. capture actual Home 360x800 after splash has exited;
4. capture an actual PASS result using a deterministic target/fixture that produces PASS;
5. capture an independent landscape-source Before/After result;
6. revalidate all required screenshot paths and semantic labels before writing PASS;
7. update screenshot manifest hashes/semantics;
8. update fidelity matrix;
9. reconcile `PROJECT_STATE.artifacts.current_build` and current TASK-S5-006 artifact hashes;
10. update evidence index and test matrix;
11. return to CHAT for direct visual review.

No new human approval is required for this deterministic repair; it stays inside the already approved TASK-S5-006 visual implementation scope.

No signing / Play upload / S6 / BUILD promotion / Artifact Freeze / release / publication.
