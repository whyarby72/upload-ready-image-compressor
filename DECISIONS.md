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


## D-015 — Explicit upload-limit selection required before verified path (2026-09-27)

Deep first-open/requirement audit found that the current source preselects 1 MB during app creation. Because PRODUCT_SPEC defines REQUIRED as a user-provided external website/form limit, an implicit app default can validate the wrong requirement. TASK-S5-003 therefore requires an unselected requirement state, a disabled known-limit CTA until explicit valid user selection, defensive target validation, reset of target selection for every newly selected photo, and preservation of the unknown-limit REDUCED-only path. The pre-fix AAB `992a2acddb197796b7aec8be72923c7ec8759a2cb36cf39dcc7f91c32a60c7a6` is HOLD for Play use pending fresh post-fix artifacts. No broad redesign is authorized.


## D-016 — Hold TASK-S5-003 for unresolved Custom KB/MB semantics (2026-09-27)

Pre-code audit found that the frozen PDC defines Custom KB/MB as canonical but does not define decimal-vs-binary unit interpretation, the implementation's 8 KB / 50 MB boundaries, fractional-target display precision, or numeric locale behavior. Current code silently uses 1024-based units and rounds non-integral KB proof text, which can weaken visible requirement truth. TASK-S5-003 is therefore held before source modification until these semantics are explicitly resolved. This HOLD does not change the canonical TEST decision and does not authorize feature expansion.


## D-017 — Decimal-SI maximum upload-limit convention (2026-09-27)

Evidence review resolves TASK-S5-003 Custom semantics. User-facing KB/MB maximum limits use SI decimal units: 1 KB = 1,000 bytes and 1 MB = 1,000,000 bytes. This matches NIST SI terminology and current Android file-size formatting on all supported API levels. PHP demonstrates that binary-style web limits still exist; for maximum-size requirements, the smaller decimal threshold is therefore the conservative cross-convention interpretation when an external portal does not disclose its byte convention. Verification remains exact-byte based.

Custom policy is bounded as a technical/product rule, not a market fact: 1 KB..50 MB, max 3 fractional digits, one dot OR comma decimal separator with no grouping, exact decimal arithmetic, never upward rounding of a maximum, and exact-byte proof for PASS/NOT_MET. Some portals also impose minimum-size or non-size constraints; the app does not infer full portal compliance from maximum-size PASS alone.

Binding decision: `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`.


## D-018 — Reopen TASK-S5-003 for fractional target display truth (2026-09-27)

Independent closure audit found that the core explicit-selection repair passes, but S5-REQ-24 was a false-positive. Fractional Custom target bytes are exact internally while the REQUIREMENT label can be rounded or represented inconsistently (for example 10.5 KB -> ~11 KB; 1.5 MB -> 1500 KB), contrary to the binding decimal-SI display contract. TASK-S5-003 is reopened. The reqfix AAB `968f3ae2928b407aa01efd96b14785c856d75861fe162d7f27bfc0169299c5e4` is HOLD for Play use until a narrow formatter repair, formatter tests, runtime fractional-Custom evidence, and fresh artifacts exist.


## D-019 — TASK-S5-003 technical PASS; S5 distribution gate remains human-bound (2026-09-27)

Independent audit accepts the fractional-display correction at tested source commit `2cc6b4b3d5b8deea1f46ad3f62e83af536ca7b2d` and closure `dc193d5af46efa1332d896b68fced06ecdd7ceb1`. API36 runtime evidence proves faithful `10.5 KB` and `1.5 MB` requirement display, and the fresh unsigned AAB was independently recomputed as 664,211 bytes / SHA-256 `064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc`.

TASK-S5-003 is therefore technically closed. However S5 itself is not declared-route complete because authorized Google Play Internal Testing distribution/install has not yet occurred. The state remains S5_INTERNAL_TEST_READY with next owner HUMAN_PLAY_CONSOLE. No S6/BUILD/release/publication authority is inferred.


## D-020 — Mandatory professional UI/UX modernization before Play Internal Testing (2026-09-27)

User visual review determined that the current Android presentation is materially too dated for the intended product quality bar. Source audit supports that assessment: the app still uses legacy Android Material theme/button primitives, a prototype-like stacked layout, native rectangular preset buttons, and text-glyph branding. Play Internal Testing upload is therefore paused.

TASK-S5-004 is authorized as a controlled UI/UX redesign. It may modernize composition, visual hierarchy, cards, target controls, vector iconography, Custom presentation, progress state, result screen, and result action hierarchy. Save copy becomes primary, Share secondary, and Compress another tertiary. Functional truth, compression behavior, package identity, privacy, permissions, and monetization state remain frozen.

Current AAB `064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc` is HOLD while redesign is active and becomes provenance-only after product source changes.


## D-021 — Benchmark-derived UI archetype frozen for TASK-S5-004 (2026-09-27)

A 30-reference benchmark across current Android photo/file utilities, modern storage/scanner/file-manager visual concepts, Android Material 3 guidance, and Figma UI-kit/component guidance establishes the implementation archetype: `PRECISION UTILITY / COBALT-NEUTRAL / MODERN EDITORIAL ANDROID`.

The redesign must emphasize one dominant buyer action per state, rounded tonal surfaces, modern target chips, compact product identity, explicit privacy cues, strong numeric outcome hierarchy, visible exact-byte proof, before/after comparison, and Save-primary result completion. Decorative cleaner-dashboard patterns, bottom navigation, glassmorphism, neon, oversized gradients, heavy shadows, and feature-density signaling are rejected.

Binding references:
- `docs/ux/S5_UI_UX_BENCHMARK_FORENSICS_v1.0.md`
- `docs/ux/S5_UI_DESIGN_SYSTEM_BLUEPRINT_v1.0.md`
