# S7 Post-Publish UMP + AdMob Smartphone Runtime Validation

Date: 2026-10-05 (Asia/Jakarta)

## Source and device

- Source HEAD: `ca4f528b7c4f9a470ea7e22e629e13db4f9d07eb`
- Worktree: separate `codex/s7-runtime`
- Device: `RR8N805R27P`, Samsung `SM-N980F`, Android 13 / API 33
- Package: `com.afradadmedia.reducephotosize.s7test`
- Fixture: `app/src/androidTest/assets/fixtures/ratio_1x1.jpg`
- Fixture SHA-256: `de0b90cdf105ff671ff6945f7f5908a8b29c22c019f982e695032196f297018e`
- Final clean debug APK SHA-256: `622c95c6167d4f672ab58faf067b91a052dd7e5a0f00d12b937b0392e5886b04`
- Temporary forced-EEA runtime APK SHA-256: `3eb1d7b96584629559cf34e78c89adb8bed81445d0e007be3d952992f43650c4` (not committed as source/artifact)

## Results

- Source/CI build: PASS (`assembleDebug`, `testDebugUnitTest`, `lintDebug`)
- Natural UMP observation: NOT_OBSERVED; geography did not show the message.
- Forced official UMP test path: PASS; provider-backed first layer displayed and captured.
- UMP first layer: PASS visually; `Consent` and `Manage options` were visible.
- Do not consent: PARTIAL. The published form did not expose a literal `Do not consent` label. Manage options was opened, all consent toggles were left off, and `Confirm choices` was selected. UMP logs recorded `gdprApplies=1` and zero vendor consents. This is refusal behavior evidence, but not a literal-label PASS.
- Privacy choices: PASS/PRESENT; the app returned to Home with `Privacy choices`, and the UMP privacy form was reopened and captured.
- Core compression: PASS; genuine result reached with `124,452 bytes > 100,000-byte limit — NOT_MET`.
- Save: PASS/OBSERVED; `Save current copy` was exercised and MediaStore contained `UploadReady_20261005_055505.jpg` under `Pictures/Reduce Photo Size/`.
- Share and Compress another: PASS/USABLE; both controls were present in the result hierarchy.
- Banner: PASS/DEMO; `ResultTestBanner: Banner loaded.` was recorded. Result UI placed `Test Ad` below buyer-critical proof/actions. No ad was clicked.
- Offline/no-ad degradation: PASS; after reversible Wi-Fi/data disable, Home, picker, processing, and result remained usable. Offline result showed `123,180 bytes > 100,000-byte limit — NOT_MET` and no blocking ad UI.
- Network cleanup: PASS; Wi-Fi re-enabled and reconnected to `Whyarby72`; prior mobile-data and airplane-mode values restored.

## Evidence

Evidence directory: `evidence/admob/s7_postpublish_runtime_20261005_054506/`

- UMP: `ump_first_layer.png/xml`, `ump_manage_options.png/xml`, `ump_after_do_not_consent.png/xml`, `privacy_choices.png/xml`
- Core: `requirement_fixture.png/xml`, `requirement_100kb.png/xml`, `processing.png/xml`, `result_screen.png/xml`, `result_screen_scrolled.png/xml`, `save_result.png/xml`
- Offline: `offline_home.png/xml`, `offline_requirement.png/xml`, `offline_result.png/xml`, `offline_result_logcat.txt`
- Logs and cleanup: `baseline_logcat.txt`, `forced_eea_logcat.txt`, `banner_logcat.txt`, `core_logcat.txt`, `network_before.txt`, `cleanup_network_restored.txt`, `cleanup_proof.txt`

## Terminal disposition

`PARTIAL_S7_POSTPUBLISH_RUNTIME_DO_NOT_CONSENT_LABEL_NOT_OBSERVED`

The only unresolved acceptance nuance is the provider form's missing literal `Do not consent` label; no source change was made to alter provider behavior.
