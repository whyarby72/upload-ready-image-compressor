# S5-004 CORRECTIVE INDEPENDENT REVIEW v1.0

Observed: 2026-09-27
Branch: `task/TASK-S5-004`
Required corrective start: `4012b36e2136416dac18ee9a9e582a81ef4a43cb`
Corrective source commit: `6c9ce5e00bb497f705bbe26dc020fea1fdbcbfc6`
Evidence/handoff closure: `a25f683f3cd1f10bf760aeec6f8a020d6af07677`
Reviewer: CHAT

Disposition:
`SOURCE_CORRECTIVE_PASS / EVIDENCE_RECAPTURE_REQUIRED`

## Source corrective — PASS

The narrow corrective source scope is accepted.

Verified source changes:
- modern custom Dialog replaces legacy AlertDialog presentation;
- custom rounded surface and styled numeric input;
- KB/MB segmented control;
- invalid input remains in-dialog with inline validation;
- parser semantics unchanged;
- bullseye/target vector replaces the plus icon;
- selected target receives a visible check indicator;
- no compression-engine changes;
- no Compose;
- no AdMob/analytics;
- no signing or Play upload.

The main functional correction requested by the prior Chat audit is therefore implemented.

## Visual runtime evidence that is valid

Validated actual runtime frames:
- API36 requirement unselected;
- API36 100 KB selected with visible check;
- modern Custom dialog open;
- Custom 10.5 KB selected;
- invalid Custom inline error;
- PASS result;
- REDUCED result;
- Save success;
- Share sheet.

These frames materially support the Precision Utility direction.

## Evidence files that are mislabeled / invalid for their claimed acceptance

### E1 — first-open 320x640
`api36_first_open_320x640.png`

Actual content:
Android launch/splash screen, not the app first-open screen.

### E2 — first-open 360x800
`api36_first_open_360x800.png`

Actual content:
Android launch/splash screen, not the app first-open screen.

### E3 — progress
`api36_progress_indeterminate.png`

Actual content:
PASS result screen, not progress state.

### E4 — NOT_MET
`api36_not_met_result.png`

Actual content:
system “Try out your stylus” overlay, not the app NOT_MET result.

### E5 — large-font requirement
`api36_large_font_requirement.png`

Actual content:
system photo picker / permission education surface, not requirement screen.

### E6 — API29 requirement
`api29_requirement_unselected.png`

Actual content:
system document picker, not the app requirement screen.

Therefore file naming alone cannot be accepted as proof.

## AAB verification

Fresh corrective AAB:
`evidence/play/app-release-0.1.0-vc1-s5-004-corrective-unsigned.aab`

Independent binary verification:
- bytes: `682671`
- SHA-256: `de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`

This exactly matches the corrective proof.

The artifact is valid and remains the current technical candidate, but Play use remains HOLD until evidence closure and later human signing/distribution.

## Acceptance disposition

PASS:
- UI-03 modern target controls;
- UI-04 no default target;
- UI-05 Custom flow;
- UI-06 modern result hierarchy using PASS evidence;
- UI-07 Save/Share/Compress-another hierarchy;
- UI-08 legacy control treatment removed;
- UI-12 build/unit/lint/release/bundle;
- UI-14 no new permission/network/AdMob/analytics.

PENDING / RECAPTURE:
- UI-01 first-open current-artifact runtime frame;
- UI-02 professional first-open at required current-artifact viewports;
- UI-09 NOT_MET state completeness;
- UI-10 small-screen closure because the required fresh first-open frame is splash-only;
- UI-11 API29 requirement runtime frame;
- UI-13 buyer-critical runtime regression because NOT_MET is not evidenced;
- UI-15 complete screenshot/evidence set;
- UI-16 final independent reviewer closure.

Large-font requirement smoke also remains pending because the provided file is a system picker.

## Required follow-up

This is an evidence-only follow-up by default.

Do not modify product source.

Using the exact current debug APK:
- verify SHA-256 before install:
  `690318caca04be7a43d7d5d1debf17613ea20a8b66bf0c18639ede86dd1f5370`
- recapture only after the app has fully rendered;
- dismiss/avoid system education overlays before capture;
- confirm the target Activity/package is foreground.

Required clean captures:
1. API36 first open 320x640 after splash;
2. API36 first open around 360x800 after splash;
3. API36 indeterminate progress while actual work is active;
4. API36 clean NOT_MET result;
5. API36 requirement at font-scale >=1.3x;
6. API29 requirement unselected after the document picker returns to the app.

Update:
- `S5_UI_UX_CORRECTIVE_PROOF.json`;
- `TEST_MATRIX.csv`;
- `evidence/INDEX.json`;
- `PROJECT_STATE.json`;
- `HANDOFF_CURRENT.md`.

If no source files change, do NOT rebuild merely to create a new artifact identity; keep the current artifact binding.
If any source/build file changes, stop and generate fresh artifacts.

## Gate

TASK-S5-004:
`SOURCE_CORRECTIVE_PASS_EVIDENCE_HOLD`

S5:
`HOLD`

Canonical decision:
`TEST`

No S6 / BUILD / Artifact Freeze / release / publication claim.
