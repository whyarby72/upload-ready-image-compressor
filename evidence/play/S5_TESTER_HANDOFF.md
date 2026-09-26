# S5 Internal Testing Handoff

Route: Google Play Console -> Internal testing

Artifact prepared: `evidence/play/app-release-0.1.0-vc1-unsigned.aab`

The artifact is technically generated and identity-checked, but unsigned. Human action is required to use the authorized Play App Signing/upload-key identity and complete the Play Console upload. No upload or publication was performed by Codex.

## Tester instructions

Use non-sensitive JPEG sample photos only. Record device and Android version, approximate source size, selected website limit, displayed RESULT state, Save outcome, Share outcome, and any confusion or error. Do not submit personal images or account data.

Focus on the buyer job: choose a JPEG, confirm CURRENT facts, select the website limit, verify PASS/NOT_MET/REDUCED truth, then Save and Share while confirming the original remains unchanged.

## Feedback categories

- BLOCKER: cannot install, open, or complete the core job
- TRUTH_DEFECT: PASS/NOT_MET/REDUCED claim is wrong
- DATA_SAFETY: original changed/lost or unexpected permission/network behavior
- FUNCTIONAL: picker, compression, Save, or Share defect
- UX: wording or flow materially prevents completion
- COSMETIC: non-blocking presentation issue

## Release notes draft

Internal test build 0.1.0 (versionCode 1): local JPEG inspection and compression; explicit PASS, NOT_MET, and REDUCED result semantics; Save and Share output flow; original-preservation and metadata disclosures. Core processing remains on-device. Known limitation: the prepared bundle still requires authorized release/upload signing before Play Console upload.
