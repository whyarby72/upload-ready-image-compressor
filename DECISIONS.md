# DECISIONS.md

## D-001 — Canonical decision remains TEST
This pilot is a bounded technical experiment. Factory invocation does not promote TEST to BUILD.

## D-002 — Reuse existing vertical slice
Use `UPLOAD_READY_ANDROID_VERTICAL_SLICE_v0.1.0` as baseline; do not rewrite from scratch without demonstrated defect.

## D-003 — Frozen truth semantics
Known requirement: PASS only when actual output bytes <= requested limit. Unknown requirement: REDUCED only. Original never overwritten.

## D-004 — AdMob deferred
No AdMob/UMP/analytics in TASK-S3-001; core buyer-job technical proof comes first.

## D-005 — Source evidence ceiling
Prior source/static/host evidence is retained but cannot substitute for Android compile/APK/device evidence.

## D-006 — Toolchain baseline
Preserve AGP 9.4.1 / compileSdk 36 / targetSdk 36 unless real environment proves a compatibility defect. Record any material change.


## D-007 — Factory v1.0.1 repo lifecycle
Factory v1.0.1 supersedes v1.0.0 for this pilot. Codex owns routine Git bootstrap/branch/commit/push operations. Current user authorization permits creation/connection of one PRIVATE GitHub repository `upload-ready-image-compressor`. Public visibility, delete/transfer, force-push, billing, signing, release and publication remain unauthorized.

## D-008 — Environment evidence ceiling
The local packaging environment has JDK 25 but no Gradle/Gradle Wrapper, Android SDK, `adb`, emulator, or `sdkmanager`. Android compile, APK, and device claims remain NOT_RUN; no wrapper or dependency was fabricated without the required Android toolchain.

## D-009 — Remote bootstrap authentication boundary
Local Git bootstrap completed on `task/TASK-S3-001`; private GitHub creation/push stopped at `AUTH_REQUIRED` because GitHub CLI/provider authentication is unavailable. No public remote or destructive remote action was attempted.

## D-010 — Verified Gradle distribution availability
Gradle 9.6.4 and 9.6.3 distribution URLs returned HTTP 404. The available installed Gradle 9.7.1 is used for the wrapper/build proof, with the deviation recorded rather than claiming an unavailable 9.6.x runtime.

## D-011 — Android proof remains bounded
API 36 build/install/launch, CURRENT detection, 1 MB actual-byte PASS, Save, Share, and permission inspection are artifact-bound PASS. Older API and remaining compression/metadata/safety cases remain open; canonical decision remains TEST.
D-012 — S5 internal-test artifact signing boundary (2026-09-27)

The S5 branch produces a Play-compatible bundle structure and identity metadata, but the generated release AAB/APK are unsigned because no authorized release/upload signing identity was provided. Codex records the exact artifacts and hashes, stops at HUMAN_PLAY_CONSOLE for signing/account/upload, and does not infer BUILD, release, publication, or S6 authority.

D-013 — Final Android identity migration (2026-09-27)

TASK-S5-002 migrates the applicationId, namespace, Java packages, provider authority, and visible app label to the frozen identity `Reduce Photo Size` / `com.afradadmedia.reducephotosize`. The superseded `com.uploadready.app` artifact remains provenance only; fresh identity artifacts are the only candidates for any future human-authorized Play action.


## D-014 — S5 identity closure and canonical/public naming reconciliation (2026-09-27)

Independent Chat audit of HEAD `2b787b5781aa8851420a71326db757364230660f` accepted TASK-S5-002 as PASS_WITH_HUMAN_SIGNING_UPLOAD_ACTION. The publication/canonical product name is now `REDUCE PHOTO SIZE: KB LIMIT`; `UPLOAD-READY IMAGE COMPRESSOR` is retained only as a historical/internal provenance alias. The S5-06 permission/privacy row is rebound to the fresh-identity debug artifact SHA-256 `cc7272ecd43a23818065d1cdcae584bef8eeba348860a81d4432318299fcb3c0`. No product source or build logic is changed by this closure. S5 remains blocked on authorized human signing / Google Play Internal Testing distribution; no S6, BUILD, Artifact Freeze, release, or publication authority is inferred.
