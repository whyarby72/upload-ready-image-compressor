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


## D-022 — High-fidelity mockup approved directionally, not literally (2026-09-27)

The first high-fidelity First Open / Requirement / PASS composite establishes the correct modern Precision Utility direction but contains several implementation-invalid details: a false EXIF-preservation claim, guaranteed target-success wording, a decimal-SI friendly/exact-byte mismatch, an over-specific first-open compression result, decorative navigation/overflow controls, and celebration confetti.

TASK-S5-004 must therefore implement the visual system only after applying the corrections in `docs/ux/S5_HIGH_FIDELITY_MOCKUP_REVIEW_v1.0.md`. Unknown-limit truth, exact-byte verification, original preservation, metadata-removal disclosure, and decimal-SI consistency remain authoritative over visual mockup content.


## D-023 — Mockup v2 accepted as visual bar; implementation contract frozen (2026-09-27)

The eight-screen mockup v2 materially meets the target visual quality, but only seven core screens are approved for MVP implementation. The separate Requirement Helper screen is deferred pending behavioral evidence.

The progress mockup's 68% indicator and staged checklist are explicitly rejected because the current engine exposes neither measured percentage nor phase callbacks. TASK-S5-004 must use truthful indeterminate progress.

All friendly current/result/before/after sizes are now required to use decimal SI consistently with exact-byte verification. PASS copy may only claim that the entered maximum size is met, not full portal compatibility.

The default implementation remains dependency-light XML/View. Material Components must not be silently added merely for styling.

Binding implementation contract:
`docs/ux/S5_UI_IMPLEMENTATION_CONTRACT_v1.0.md`


## D-024 — TASK-S5-004 visual foundation accepted; closure reopened for corrective UI/evidence (2026-09-27)

Independent Chat review finds the main first-open and requirement redesign materially improved and aligned with the Precision Utility direction. However TASK-S5-004 cannot close because the Custom Limit surface remains a legacy platform AlertDialog/RadioButton treatment, `ic_target` is actually a plus symbol, selected target tiles lack the bound visible non-color indicator, and the required result/progress/save/share/API29/360x800/large-font visual evidence is incomplete.

Evidence reconciliation also found a debug APK SHA typo in several matrix rows and an AAB byte-count drift: the fresh AAB SHA-256 is correct at `908755dddc0d030e22172d5ad9650037a513bffa8e86d701337dbff1ed646de6`, while its independently observed size is 677,037 bytes, not 677,122.

TASK-S5-004 is reopened for a narrow corrective pass. No Play upload or S6/BUILD promotion is allowed until independent review passes.


## D-025 — TASK-S5-004 corrective source PASS; evidence-only recapture required (2026-09-27)

Independent review accepts corrective source commit `6c9ce5e00bb497f705bbe26dc020fea1fdbcbfc6`: the Custom Limit modal is modernized, KB/MB is segmented, the target icon is a bullseye, and selected targets have a visible check indicator. No product-truth or compression-engine regression is identified.

However multiple evidence files are mislabeled: both fresh first-open viewport captures are Android splash frames, the progress capture is actually a PASS result, NOT_MET is a system stylus overlay, large-font requirement is the system photo picker, and API29 requirement is the document picker. These cannot close the corresponding acceptance IDs.

The fresh corrective AAB is independently verified at 682,671 bytes / SHA-256 `de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5`. The artifact remains current but HOLD pending evidence-only recapture. No source change is required by this review.


## D-026 — TASK-S5-004 PASS; mandatory UI/UX modernization closed (2026-09-27)

Independent review of evidence-only recapture `d316d2d26edc13f68245544f3dbe412075b72c80` verifies that all previously mislabeled runtime states have been replaced with clean app evidence. API36 first-open at 320x640 and ~360x800, actual indeterminate progress, clean NOT_MET, font-scale 1.3x requirement, and API29 requirement all pass visual/runtime review.

UI-01 through UI-16 are accepted. TASK-S5-004 is therefore closed PASS. The tested product source remains `6c9ce5e00bb497f705bbe26dc020fea1fdbcbfc6`.

The current unsigned AAB remains `de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5` at 682,671 bytes.

This closes the mandatory UI/UX modernization task only. S5 Google Play Internal Testing distribution remains human-bound and incomplete until authorized signing/account setup plus actual Play Internal Testing distribution/install evidence exists.


## D-027 — Human visual rejection supersedes TASK-S5-004 visual PASS (2026-09-27)

The user reviewed the actual emulator result screen and explicitly judged the current UI as still materially dated. Because subjective market-facing quality requires human approval, the previous structural UI-01..UI-16 PASS is not sufficient to authorize Play progression.

The current implementation is functionally accepted but visually rejected. TASK-S5-004 is reopened as `REOPENED_HUMAN_VISUAL_REJECTION`. Current AAB `de446e023a5ec668659f67e7a9fc2bfdb060ea11dffe57c5530624401a1325e5` is HOLD for Play.

Root cause is the decision to preserve a dependency-light legacy View/theme foundation and style over it. The next redesign must evaluate a materially different presentation architecture, with Compose-first UI preferred for evaluation while preserving the verified compression/domain engine and all product-truth semantics.


## D-028 — Premium Android 2025–2026 benchmark binds MEDIA-FIRST PRECISION UTILITY direction (2026-09-27)

A focused benchmark of 14 current/recent Android products and platform references was completed after direct human rejection of the previous View/XML redesign. The strongest transferable patterns are media-first composition, contextual/floating/docked actions, fewer intentional containers, modern connected controls, contemporary iconography, less exposed engineering detail, and Material 3 Expressive typography/shape/motion.

Android's current platform guidance is Compose-first; traditional Views and View-based Material Components are in maintenance mode. For this small one-job app, the preferred next visual prototype is therefore a Compose Material 3 presentation layer over the already-verified domain/compression engine, not another skinning pass over the legacy View/theme foundation.

Binding visual direction:
`MEDIA-FIRST PRECISION UTILITY`

No Compose coding is authorized until new high-fidelity First Open / Requirement / Result mockups receive direct human visual approval.


## D-029 — Premium Warm Ink visual system bound from human-approved mockup direction (2026-09-27)

The user explicitly preferred the latest warm, muted mockup over the previous bright utility directions, describing it as more elegant and premium. That direction is now normalized into a binding implementation-oriented visual system: `MEDIA-FIRST PRECISION UTILITY — WARM INK`.

The system uses a warm ivory canvas, deep muted teal/ink primary actions, restrained success/NOT_MET surfaces, lower text density, media-first result composition, contemporary iconography, pill-like actions, compact exact-byte proof, and a result action dock.

Mockup-only inaccuracies remain non-authoritative. In particular, fake percentage progress, exact promised output before a real input exists, unsupported formats, and unimplemented retry flows are prohibited.

The preferred future presentation architecture remains Compose Material 3 over the existing verified domain/compression engine. Coding remains withheld until exact final screen mockups receive direct human visual approval.


## D-030 — Human approves Warm Ink premium visual concept; implementation remains separately gated (2026-09-27)

The user explicitly approved the latest five-screen `MEDIA-FIRST PRECISION UTILITY — WARM INK` mockup concept. This establishes the visual anchor for the next implementation pass: warm ivory canvas, deep muted teal/ink primary actions, media-first composition, low copy density, premium rounded/pill controls, compact exact-byte proof, restrained semantic colors, and elegant photo comparison.

This is a visual-concept approval only. It does not authorize Compose/source mutation, signing, Play upload, S6, BUILD promotion, Artifact Freeze, release, or publication. The current AAB remains HOLD because it does not implement the newly approved concept.
