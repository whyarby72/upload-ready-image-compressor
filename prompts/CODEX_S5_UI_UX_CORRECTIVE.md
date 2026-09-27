# CODEX TASK-S5-004 CORRECTIVE PASS

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-004`

Read first:
1. `CURRENT_TASK.md`
2. `docs/ux/S5_004_INDEPENDENT_VISUAL_ARTIFACT_AUDIT_v1.0.md`
3. `docs/ux/S5_UI_IMPLEMENTATION_CONTRACT_v1.0.md`
4. `docs/ux/S5_HIGH_FIDELITY_MOCKUP_V2_REVIEW_v1.0.md`

This is a narrow corrective pass. Do not redesign the already-improved first-open and requirement composition from scratch.

## Required source corrections

### C1 — Modern Custom Limit modal
Replace the legacy visual treatment of raw platform AlertDialog/RadioButtons.

Required:
- rounded modern dialog/surface;
- styled numeric input;
- KB/MB segmented/toggle controls;
- visible selected state not color-only;
- Cancel low emphasis;
- Use limit primary;
- existing helper text;
- inline validation;
- invalid input keeps dialog open;
- Cancel/invalid preserves last-valid target.

Do not change parser semantics.

### C2 — Replace plus icon
Replace `ic_target.xml` plus sign with a semantically correct target/bullseye/limit vector.

Use it in:
- selected requirement summary;
- Make it upload-ready CTA where appropriate.

### C3 — visible selected target indicator
Each selected 50/100/200/500 KB, 1 MB, or Custom control must have:
- tonal selected surface;
- strong outline;
- visible check/selection indicator.

Do not rely only on fill/border color or contentDescription.

## Required runtime/evidence closure

Capture actual post-correction screenshots:
1. first open 320x640;
2. first open approximately 360x800;
3. requirement unselected 320x640;
4. 100 KB selected;
5. Custom dialog open;
6. Custom 10.5 KB selected;
7. invalid Custom inline error;
8. indeterminate progress;
9. PASS result;
10. NOT_MET result;
11. REDUCED result;
12. Save success;
13. Share sheet;
14. API29 requirement state;
15. large-font >=1.3x first-open and requirement smoke.

For PASS/NOT_MET/REDUCED:
- verify actual bytes and truth state;
- preserve exact proof;
- verify Save-primary / Share-secondary / Compress-another-tertiary visually.

Re-run:
- preflight;
- assembleDebug;
- unit;
- lint;
- assembleRelease;
- bundleRelease;
- API36;
- API29;
- Custom 10.5 KB / 1.5 MB;
- no default target;
- target reset;
- Save;
- Share;
- original preservation;
- EXIF orientation;
- large input;
- permission/privacy.

Generate fresh debug APK/release APK/AAB bytes + SHA-256.

## Evidence reconciliation

- create one-to-one matrix closure for UI-01 through UI-16;
- fix the debug APK hash typo;
- record actual AAB byte count;
- do not reuse stale screenshot paths as evidence for a screen they do not show;
- mark the current S5-004 AAB `908755dd...` provenance-only after corrective source changes.

## Stop boundary

Return to CHAT for independent visual/artifact audit.

No signing.
No Play upload.
No AdMob/analytics.
No S6/BUILD/Artifact Freeze/release/publication.
