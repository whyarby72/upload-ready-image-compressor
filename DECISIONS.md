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


## D-031 — Exact Compose Warm Ink implementation brief ready; coding remains approval-gated (2026-09-27)

The human-approved premium Warm Ink concept has been translated into an exact implementation contract at `docs/ux/S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`.

The plan replaces the rejected View/XML presentation with a Compose Material 3 presentation layer while retaining the verified Java/domain engine. It defines the state/event bridge, responsive rules, exact screen copy/hierarchy, safe media previews, Warm Ink theme tokens, result action dock, PASS/NOT_MET/REDUCED mappings, custom limit behavior, accessibility, migration order, artifact refresh and runtime screenshot gates.

The brief is complete but does not itself authorize source mutation. Compose implementation remains blocked until explicit human approval of `COMPOSE_WARM_INK_IMPLEMENTATION`.


## D-032 — COMPOSE_WARM_INK_IMPLEMENTATION explicitly authorized (2026-09-27)

The user explicitly approved option 1, authorizing implementation of the exact Compose Warm Ink presentation-layer brief. Authorization is limited to the scope defined by `S5_PREMIUM_VISUAL_SYSTEM_v1.0.md`, `S5_COMPOSE_IMPLEMENTATION_BRIEF_v1.0.md`, and the current stable toolchain binding.

A new implementation task `TASK-S5-005` and branch `task/TASK-S5-005` are opened. The verified Java/domain engine remains protected. Toolchain-only compileSdk upgrade to 37 is authorized because current stable Compose 1.12.x requires compileSdk 37; targetSdk remains 36.

Codex may implement and produce fresh artifacts/evidence but may not self-approve visual quality. Final implementation status must be `READY_FOR_HUMAN_VISUAL_REVIEW`. Signing, Play upload, S6, BUILD promotion, Artifact Freeze, release and publication remain unauthorized.


## D-033 — TASK-S5-005 first-pass Compose migration technically succeeds but fails Warm Ink fidelity gate (2026-09-27)

Independent source review of `ee59fbf78cd0623b83b8bb6785aa479688231a38` confirms that the protected Java/domain engine was not modified and that the Compose presentation/toolchain migration is structurally in place.

However the implementation materially diverges from the human-approved visual contract: Home and Requirement remain copy-heavy, selected chips lack the required visible check, Custom validation closes the dialog, Processing lacks media context, Result recreates the rejected status/number/proof-card/stacked-actions pattern, the floppy Save icon remains, and PreviewLoader lacks mirrored EXIF orientation parity with the engine.

No dedicated TASK-S5-005 runtime screenshot/artifact evidence is committed, and chat-supplied artifact hashes are abbreviated, so technical build/smoke claims are not yet independently artifact-bound.

TASK-S5-005 remains authorized within the existing approval scope for a narrow fidelity corrective. No new product scope is authorized.


## D-034 — TASK-S5-005 technical evidence independently accepted; direct visual gate remains pending (2026-09-28)

CHAT independently reviewed corrective source `5ab842073cfe6dbc507baac499c3af37a9e05183` and evidence closure `4db3e4e8dfa706fa69c92fcc381c666c8cd1b8e0`.

The corrective source satisfies the previously identified implementation defects at source level, protected domain files remain unchanged, and the closure now contains repository-bound build/runtime/artifact evidence with replayable environment/commands and full artifact hashes.

The current connector cannot decode repository PNG/binary files for direct visual inspection, so screenshot existence is accepted but visual quality is not inferred from filenames, Codex attestations, or matrix rows. Technical evidence is PASS; the direct human visual gate remains pending.


## D-035 — Direct runtime visual review accepts Warm Ink direction but requires narrow final hierarchy polish (2026-09-28)

CHAT directly inspected the uploaded TASK-S5-005 runtime screenshots. Home, font-scale Home, Custom invalid state, and overall Warm Ink palette/composition are materially improved and consistent with the approved premium direction.

Two runtime defects block final visual PASS: the Requirement screen's large media card pushes key limit controls/continuation below the initial 360x800 viewport, and the Result screen allows the friendly file size unit to wrap onto a second line (for example `199` / `KB`).

These are narrow layout/hierarchy defects. The visual system is not reopened and no product redesign is authorized. A final polish pass remains within the existing `COMPOSE_WARM_INK_IMPLEMENTATION` scope.


## D-036 — Final visual-polish source and technical closure pass; direct screenshot gate remains (2026-09-28)

Independent review of `ccbea0bd612b0be5a4d72908a92164be1deda1fa` confirms the final polish is intentionally narrow and modifies only `MainActivity.kt`. The Requirement media context is compacted to a 92dp horizontal row, the Result status/value layout is separated, the friendly value is constrained to one line with responsive type sizing, and duplicated Processing trust copy is removed.

Evidence closure `1d932cfb239c3c74b426fa3a16cf8ed703b5df3a` contains fresh builds, artifacts, hashes, API36/API29 captures and matrix rows. Source/technical evidence is accepted. Final visual quality still requires direct inspection of the fresh images; no visual PASS is inferred from proof text alone.


## D-037 — Final visual ZIP proves repository-bound screenshot mislabeling and a 320dp chip clipping defect (2026-09-28)

Direct inspection of the uploaded final-review ZIP shows that several repository-bound screenshots are materially mislabeled. PASS and NOT_MET 360 evidence are byte-identical to REDUCED; PASS 320/font evidence is the Android system photo picker; Requirement font-scale evidence is actually Home; and the Processing file does not show an active processing state.

The uploaded hashes exactly match `evidence/INDEX.json`, so this is not a ZIP packaging error. The screenshot capture/semantic QA gate failed.

Direct visual inspection also finds that the final Requirement layout is materially improved at 360dp, but at 320dp the `Custom` chip is clipped to `Custo`.

A narrow source fix plus semantically verified evidence recapture is required. The Warm Ink system remains accepted and no redesign is authorized.


## D-038 — Final recap source and evidence-integrity gate accepted (2026-09-28)

Independent CHAT audit of source fix `5c586048860c221bf36ccba9fb5f8f3955d7fbb2` and closure `b95ad7d1f9b46149d36f5cb29dd098bf658d1a4a` confirms that the 320dp chip correction is a three-line presentation-only change, protected domain/compression files are unchanged, and the new semantic screenshot sidecar repairs the prior evidence-control failure.

All 11 recap captures are bound to foreground package, viewport, font scale, expected state, required/forbidden semantic tokens and unique hashes. Independent duplicate-hash checking finds no duplicates. The prior final screenshot namespace remains provenance-only invalidated.

Source, technical evidence, evidence integrity and semantic state binding are PASS. Direct visual quality remains pending until the actual recap PNGs are inspected by CHAT + HUMAN.


## D-039 — Final direct visual recap passes except frozen NOT_MET guidance/save-label fidelity (2026-09-28)

Direct inspection of the semantically verified recap accepts Requirement at 360/320/1.3x, Processing, PASS Result and REDUCED Result. The previously blocking 320dp chip clipping and result-value wrapping are resolved.

One final presentation-copy defect remains against the frozen Warm Ink visual system and Compose implementation brief: NOT_MET does not render the required guidance `Try a higher limit or a different photo.`, and the shared Result action currently labels the primary save action `Save copy` rather than the NOT_MET-specific `Save current copy`.

This is a narrow presentation-copy fidelity fix only; the visual system, product behavior and compression/domain engine remain closed.


## D-040 — Image geometry preservation becomes a hard product invariant (2026-09-28)

Human explicitly requires that original and compressed output preserve image proportion and never become stretched/squashed.

A new binding contract defines geometry using EXIF-oriented display dimensions, requires uniform scaling for actual output, prohibits cropping as a compression strategy, and permits only integer-pixel rounding drift.

Current compression source already derives width and height from the same scale factor, so protected engine code is not reopened. Instead, deterministic decoded-output geometry regression is now mandatory. If that test fails, Codex must STOP and request separate material approval before changing protected compression/domain code.

Truth-critical UI is tightened: Processing, Result hero, and both Before/After images must use full-frame Fit presentation; Requirement thumbnail may remain Crop because it is identification-only.

The pending NOT_MET copy fidelity correction is folded into the same final corrective to avoid another independent iteration.


## D-041 — Geometry source intent accepted but actual output proof rejected (2026-09-28)

Independent audit accepts the new Fit presentation policy and NOT_MET copy fidelity, and confirms protected production compression/domain source was not changed.

However the geometry acceptance is reopened because the new unit test exercises only `ScalePlanner.scaledDimension` using synthetic widths/heights and synthetic scale values. It does not invoke the production `JpegCompressionEngine` or decode actual output JPEGs.

The geometry proof JSON also uses non-observed placeholders such as `2400x1600-or-scaled-uniformly`, omits required output dimensions/cross-product deltas/tolerances, and does not contain actual-output coverage for the full mandatory aspect-ratio matrix.

TEST_MATRIX row S5-24 is therefore a false-positive and must return to HOLD until actual production-engine output is tested. This is a test/evidence repair only; protected engine source remains closed unless a real failure is demonstrated.


## D-042 — Actual production-engine geometry invariant closes PASS (2026-09-28)

Independent CHAT audit of `c736a5d1e9beeb663b9bc336618171bbefe82a28` and `3fc36df49da0616412efbe71425446626fd4c3af` confirms the geometry harness invokes the real production `JpegCompressionEngine.compressKnown()` through MediaStore URIs, retains the actual result JPEGs, decodes those files, and hash-binds source/output artifacts.

All 10 mandatory cases pass. Actual decoded dimensions preserve source display geometry with cross-product delta exactly zero for 1:1, 3:2, 2:3, 4:3, 3:4, 16:9, 9:16, EXIF rotate-90, mirrored EXIF, and ALREADY_READY. No protected compression/domain production file was modified.

The hard file-output geometry invariant is therefore closed PASS. The only remaining TASK-S5-005 gate is direct human review of the new Fit/full-frame UI screenshots.


## D-043 — Human approves final TASK-S5-005 geometry visual gate only (2026-09-28)

After independent actual-engine geometry closure and direct CHAT inspection of the repository-bound `s5_005_geometry_final` screenshots, the human explicitly selected the scoped Option 1 approving only the final geometry visual Fit/full-frame gate for TASK-S5-005.

The approval closes TASK-S5-005 visual acceptance. It does not authorize signing, Play upload, S6, canonical BUILD promotion, Artifact Freeze, release, or publication.

Broader S5 therefore returns to `S5_INTERNAL_TEST_READY` with next owner `HUMAN_PLAY_CONSOLE`. Actual Google Play Internal Testing distribution/install evidence is still required before S5 can be treated as route-complete.

Approval ref:
`USER_OPTION_1_2026-09-28_FINAL_GEOMETRY_VISUAL_GATE_ONLY`

Closure audit:
`docs/qa/S5_005_FINAL_GEOMETRY_VISUAL_HUMAN_CLOSURE_v1.0.md`


## D-044 — Google Play Internal Testing handoff prepared without provider authority (2026-09-28)

Current Google Play requirements were reverified from official Google sources before preparing the handoff.

The app targets API 36, matching the current mobile new-app/update submission target requirement effective 2026-08-31.

The exact current pre-signing candidate is:
`evidence/artifacts/s5_005_geometry_final/app-release.aab`
— 7,951,808 bytes
— SHA-256 `e1a83becf5f0dfaab2dce38be5d1dc5f212a6c313a8155810317d0d878104e02`.

The candidate remains unsigned and therefore is not Play-upload-eligible. Signing/account/provider state remains owned by the authorized Play Console account holder.

Canonical handoff:
`docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v2.0.md`

This preparation grants no signing, app creation/mutation, upload, tester mutation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority.


## D-045 — Reopen S5 for native visual productization completeness (2026-09-28)

Direct human emulator review exposed a late buyer-facing visual defect that prior functional, geometry and ordinary visual reviews did not catch.

The current first-open runtime uses the generic `ic_photo` glyph as both app/header identity and the core hero symbol, and the repository contains no dedicated launcher mipmap/adaptive-icon asset system. The current `WarmInkArtwork()` is a tonal card with a generic photo glyph plus `PHOTO → READY`, which is materially below the intended premium/mockup richness.

The defect is classified as a visual-productization acceptance escape, not a domain/geometry defect.

Primary Runtime v5.16.25 already states that a technically functional interface below the selected market-quality floor is REWORK and that late defects should strengthen the earliest reusable control. The reusable weakness is the Android adapter/SOP binding: native visual asset completeness, launcher identity, mockup-object parity and placeholder-escape controls were not explicit hard requirements.

Therefore:
- canonical decision remains TEST;
- progress reopens from 99% to 96%;
- stage becomes `S5_VISUAL_PRODUCTIZATION_REWORK`;
- TASK-S5-006 is opened;
- Play Internal Testing handoff is paused;
- prior geometry approval remains valid only for geometry Fit/full-frame scope;
- core technical and geometry evidence remain valid within scope;
- no product-source mutation is authorized yet.

Binding corrective documents:
- `docs/qa/TASK_S5_006_VISUAL_PRODUCTIZATION_ESCAPE_AUDIT_v1.0.md`
- `docs/ux/TASK_S5_006_VISUAL_ASSET_COMPLETENESS_CORRECTIVE_SPEC_v1.0.md`
- `docs/engine/AI_PROD_ANDROID_NATIVE_VISUAL_PRODUCTIZATION_GATE_PATCH_v1.0.0.md`

Next material approval must explicitly authorize:
`TASK-S5-006 VISUAL ASSET COMPLETENESS IMPLEMENTATION`.


## D-046 — Human authorizes TASK-S5-006 visual asset completeness implementation (2026-09-28)

The human explicitly selected Option 1 after it was scoped to:
`TASK-S5-006 VISUAL ASSET COMPLETENESS IMPLEMENTATION`.

Authorization includes only:
- dedicated local launcher/app mark assets;
- purpose-built first-open hero illustration;
- minimal per-screen visual-asset integration defined by the corrective spec;
- Compose/resource presentation changes required by the spec;
- fresh build/test/runtime screenshot evidence.

Authorization explicitly excludes:
- compression/domain changes;
- new formats;
- backend/network;
- AdMob/analytics;
- package/applicationId, SDK, version changes;
- signing;
- Play Console mutation/upload;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

Approval ref:
`USER_OPTION_1_2026-09-28_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION`

Execution owner:
`CODEX`

Work order:
`prompts/CODEX_TASK_S5_006_VISUAL_ASSET_COMPLETENESS_IMPLEMENTATION.md`


## D-047 — Do not spend human premium-review attention on invalid TASK-S5-006 evidence (2026-09-28)

CHAT directly rendered the TASK-S5-006 runtime evidence before requesting human PREMIUM_QUALITY approval.

The evidence pack contains deterministic semantic misbindings: the required 360x800 Home capture is splash-only, the file named result_pass renders TARGET NOT MET, and the landscape Before/After artifact does not independently prove a landscape case.

Therefore the human premium-quality gate is NOT READY. The source implementation remains within scope, but machine evidence must be repaired first.

Codex may perform the bounded presentation/evidence repair under the existing TASK-S5-006 implementation authorization; no new human scope approval is required.

Audit:
`docs/qa/TASK_S5_006_CHAT_PREMIUM_REVIEW_EVIDENCE_AUDIT_v1.0.md`

Repair work order:
`prompts/CODEX_TASK_S5_006_EVIDENCE_REPAIR_AND_RECAPTURE.md`


## D-048 — Use the user-approved generated Home compression illustration (2026-09-29)

The user explicitly selected the newly generated illustration for the Android Home hero.

Binding visual semantics:
- large/source photo on the left;
- right-pointing transition arrow;
- smaller/result photo on the right;
- Warm Ink-compatible restrained visual treatment.

The approved image was integrated locally as an optimized WebP:
`app/src/main/res/drawable-nodpi/ill_home_fit_to_limit_generated.webp`

Packaged SHA-256:
`558da958fd28db36333a12013607399189689a288bbafa05e3644b0e5095b7be`

The optimization only removed unused outer blank margin, resized, and encoded to WebP; it did not redesign the user-approved composition.

Home now references this asset. Previous Home runtime screenshots are superseded for premium review and fresh machine/emulator evidence is required.

This decision does not authorize signing, Play upload, S6, BUILD promotion, Artifact Freeze, release, or publication.


## D-049 — Treat file-manager size mismatch as display ambiguity, not compression/save defect (2026-09-30)

Human manual evidence showed the app displaying `496 KB` while Android Files displayed approximately `484 KB` for a saved JPEG.

The underlying result and saved file were independently verified at exactly `495,669 bytes` with identical SHA-256:
`f30a022df6c6c447a5c2d22aefc715277310d6455ce285d8f6db0fcd6992790b`.

Decision:
- retain decimal-SI target semantics: 1 KB = 1,000 bytes;
- retain exact-byte verification as authoritative;
- do not change compression or Save behavior;
- add compact Result-screen disclosure to prevent cross-display confusion;
- open TASK-S5-007 as presentation-only rework.

Implementation is not authorized by this decision alone.


## D-050 — Human authorizes TASK-S5-007 output-size display clarity implementation (2026-09-30)

The human explicitly selected Option 1 after the scope was bound to:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY IMPLEMENTATION`.

Authorized:
- presentation-only Result copy/layout adjustment;
- exact-byte grouping/display helper;
- compact disclosure that this app uses 1 KB = 1,000 bytes and some file managers may display 1,024-byte units;
- fresh build/test/emulator evidence;
- saved-file byte/hash fidelity proof.

Not authorized:
- target arithmetic changes;
- compression/domain changes;
- Save behavior changes;
- package/version/SDK changes;
- signing;
- Play upload;
- S6;
- BUILD promotion;
- Artifact Freeze;
- release;
- publication.

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_IMPLEMENTATION`


## D-051 — Human approves TASK-S5-007 output-size display clarity (2026-09-30)

The human explicitly selected Option 1 for:
`TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY`.

Decision:
- close TASK-S5-007 as `PASS_HUMAN_APPROVED_CLOSED`;
- preserve decimal-SI semantics and exact-byte truth;
- retain the Result disclosure explaining possible 1,024-byte file-manager calculations;
- TASK-S5-007 no longer blocks S5.

This decision does not approve TASK-S5-006 premium visual productization and does not grant signing, Play upload, S6, BUILD promotion, Artifact Freeze, release, or publication authority.

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_APPROVAL`


## D-052 — Human approves TASK-S5-006 premium visual productization (2026-09-30)

The human explicitly selected Option 1 for:
`TASK-S5-006 PREMIUM_QUALITY / VISUAL_PRODUCTIZATION`.

Decision:
- close TASK-S5-006 as `PASS_HUMAN_APPROVED_CLOSED`;
- preserve the generated Home hero and Warm Ink visual direction;
- recognize TASK-S5-007 Result presentation as separately reviewed and human-closed PASS;
- remove TASK-S5-006 as an S5 blocker.

The existing Play Internal Testing candidate remains stale pre-rework provenance and must be refreshed before any upload.

This decision does not authorize signing, Play upload/submission, S6, BUILD promotion, Artifact Freeze, release, or publication.

Approval ref:
`USER_OPTION_1_2026-09-30_TASK_S5_006_PREMIUM_QUALITY_VISUAL_PRODUCTIZATION_APPROVAL`


## D-053 — Refresh Google Play Internal testing handoff to current tested source (2026-09-30)

After TASK-S5-006 and TASK-S5-007 were both human-closed PASS, the previous Play Internal testing handoff became stale because it referenced a pre-rework AAB.

Decision:
- promote `docs/ops/S5_PLAY_INTERNAL_TESTING_HUMAN_HANDOFF_v3.0.md` as the canonical next-action handoff;
- promote `docs/ops/S5_PLAY_INTERNAL_TESTING_READINESS_v2.0.json` as the canonical readiness record;
- bind the latest tested app source to `27199bf6f174e55dc835d0d9898e456d3848001c`;
- retain the latest QA release AAB hash `a25a3a08e8c65c84afc74fe065ac5ce6648cfaafe5d04bfa2994cbe940949f01` as an UNSIGNED local QA artifact reference only;
- require explicit unsigned candidate materialization + fresh hash binding before any signing request;
- treat old v2.0/v1.0 Play handoff/readiness files as provenance only for next-action purposes.

No signing, key creation/rotation, Play Console mutation, upload, tester mutation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized.

Next material approval scope:
`S5 CURRENT UNSIGNED PLAY CANDIDATE MATERIALIZATION ONLY`


## D-054 — ASO refreeze Play title after 20-competitor benchmark (2026-10-01)

The human selected Option 3 to run one additional ASO title + short-description benchmark across 15–20 current Google Play competitors and then freeze the name.

Benchmark:
`docs/market/S5_ASO_TITLE_SHORT_DESCRIPTION_BENCHMARK_2026_10_01_v1.0.md`

Observed 20-title sample token prevalence:
- photo: 14/20;
- compressor: 12/20;
- KB: 12/20;
- size: 7/20;
- image: 7/20;
- MB: 6/20;
- resizer: 5/20;
- exact: 2/20;
- limit: 2/20.

Decision:
- refreeze en-US Play title as `Photo Compressor: KB Limit`;
- retain launcher/in-app label `Reduce Photo Size`;
- retain package `com.afradadmedia.reducephotosize`;
- reject `Exact KB` as an over-strong product claim because the product contract is maximum-limit PASS (RESULT <= REQUIRED), not guaranteed target equality;
- do not use `MB to KB` as the primary title framing because it is crowded and semantically narrower than the actual buyer job;
- use `KB Limit` as the buyer-job differentiator on top of the established `Photo Compressor` category anchor.

Short-description candidate:
`Set a KB limit, compress locally, and verify the final file in exact bytes.`

This decision changes Play metadata only. It does not authorize source mutation, final Play app creation submission, package registration mutation, key creation/rotation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.

Approval ref:
`USER_OPTION_3_2026-10-01_ASO_BENCHMARK_THEN_FREEZE_NAME`


## D-055 — Audit Play short description and full-description keyword architecture (2026-10-01)

The human selected Option 2 to run a focused ASO audit of the short description and full-description keyword architecture before continuing Play app creation.

Audit:
`docs/market/S5_ASO_SHORT_FULL_DESCRIPTION_ARCHITECTURE_AUDIT_2026_10_01_v1.0.md`

Decision:
- keep Play title frozen as `Photo Compressor: KB Limit`;
- recommend short description:
  `Compress photos under a KB limit and verify the final size in exact bytes.`
- supersede the earlier short-description candidate that began with `Set a KB limit...`;
- freeze the full-description keyword architecture and truth boundaries, but do not freeze final full-description prose yet;
- prioritize natural semantic coverage over keyword repetition;
- preserve maximum-limit truth: PASS means RESULT <= REQUIRED, not guaranteed exact equality;
- do not use unsupported batch, PNG/WebP, passport/visa, crop, converter, or "no ads" claims.

This decision does not authorize final Create app submission, package registration mutation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.

Approval ref:
`USER_OPTION_2_2026-10-01_SHORT_FULL_DESCRIPTION_ASO_AUDIT`


## D-056 — Freeze en-US Play listing copy after policy and keyword audit (2026-10-01)

The human selected Option 1 to produce the final en-US full description, audit it against current Google Play metadata guidance and the product-truth contract, and freeze the copy if the audit passed.

Audit:
`docs/market/S5_PLAY_FULL_DESCRIPTION_FINAL_POLICY_KEYWORD_AUDIT_2026_10_01_v1.0.md`

Decision:
- keep Play title frozen as `Photo Compressor: KB Limit`;
- freeze short description as:
  `Set a KB limit, compress photos, and verify the final size in exact bytes.`
- freeze the final en-US full description stored in `store/PLAY_LISTING.md`;
- replace the prior short-description candidate because "under a KB limit" could be read as a universal success guarantee;
- preserve truthful PASS semantics: result bytes must be <= the user-provided limit;
- preserve NOT_MET as a valid outcome;
- preserve the JPEG/JPG, Save/Share, original-preservation, local-compression, and exact-byte truth boundaries;
- exclude unsupported feature claims, ranking/performance claims, pricing claims, "ad-free" wording, exact-equality guarantees, and keyword stuffing.

Audit result:
`PASS_NO_MATERIAL_METADATA_POLICY_CONFLICT_FOUND`

Keyword result:
`PASS_NATURAL_SEMANTIC_COVERAGE`

This is a metadata freeze only. It does not authorize final Create app submission, package registration mutation, signing, key operations, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.

Approval ref:
`USER_OPTION_1_2026-10-01_FULL_DESCRIPTION_FINAL_POLICY_KEYWORD_AUDIT`


## D-057 — Audit Play icon, screenshots, and feature graphic (2026-10-01)

The human selected Option 2 to audit Play visual assets before continuing Create app.

Audit:
`docs/market/S5_PLAY_STORE_VISUAL_ASSET_AUDIT_2026_10_01_v1.0.md`

Decision:
- preserve the existing Compression Frame Mark as the brand basis;
- require a dedicated 512x512 Play-store icon export rather than treating the adaptive launcher XML as the store asset;
- use the approved Home large-photo -> limit -> smaller-result story as the feature-graphic visual grammar, but create a separate compliant 1024x500 JPEG/PNG asset;
- do not upload current QA screenshots as the final Play screenshot set;
- target six portrait 1080x1920 screenshots;
- prioritize exact-byte verification in screenshot 1, KB-limit selection in screenshot 2, and Save/Share completion in screenshot 3;
- keep feature graphic text-light or text-free and avoid keyword stuffing in graphics;
- perform a post-AdMob visual-drift check before publication.

Current result:
`STORE_VISUAL_ASSET_AUDIT_PASS / PRODUCTION_REQUIRED`

Next material scope:
`S5 PLAY STORE VISUAL ASSET PACK PRODUCTION`

No asset generation, source mutation, final Create app submission, package mutation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this decision.


## D-058 — Competitor visual benchmark before Play asset production (2026-10-01)

The human selected Option 2 to benchmark 10–15 competitor Play listings before producing store assets.

Benchmark:
`docs/market/S5_PLAY_VISUAL_COMPETITOR_BENCHMARK_2026_10_01_v1.0.md`

Sample:
13 direct / near-direct Android competitors.

Decision:
- no broad app redesign is justified;
- preserve the existing Warm Ink visual system and Compression Frame Mark;
- differentiate through evidence-led verified-result visuals rather than feature breadth;
- lead the screenshot sequence with exact-byte PASS proof;
- avoid mascot-led identity, generic blue-toolbox sameness, giant percentage-reduction claims, and feature-grid collage;
- retain the six-screen store storyboard, with refined ordering:
  1. verified result;
  2. set KB limit;
  3. save/share;
  4. custom KB/MB;
  5. on-device compression;
  6. honest NOT_MET;
- keep feature graphic text-light / text-free;
- require a post-AdMob visual-drift audit before publication.

Benchmark result:
`PASS`

Next material scope:
`S5 PLAY STORE VISUAL ASSET PACK PRODUCTION`

No asset generation, source mutation, final Create app submission, package mutation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this decision.


## D-059 — Produce Play store visual asset pack (2026-10-02)

The human selected Option 1 and explicitly authorized:
`S5 PLAY STORE VISUAL ASSET PACK PRODUCTION`

Production result:
`docs/market/S5_PLAY_STORE_VISUAL_ASSET_PACK_PRODUCTION_RESULT_v1.0.md`

Produced:
- dedicated 512x512 Play icon candidate;
- 1024x500 text-free feature graphic candidate;
- 1024x500 text-light feature graphic alternate;
- six 1080x1920 screenshot templates;
- alt-text/provenance/hash manifest;
- downloadable conversation-local bundle.

Decision:
- keep text-free feature graphic as the recommended primary candidate;
- treat icon + feature graphic as ready for explicit human visual review;
- do not pretend screenshot finalization is complete;
- final screenshot composites remain blocked until truthful current runtime UI captures can be materialized or captured;
- do not substitute fake UI or stale UI;
- repository binary materialization remains pending human visual selection.

No Android app source mutation, final Create app submission, package mutation, signing, upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this production result.


## D-059 — Real Play screenshots must come from Android emulator (2026-10-02)

The human selected Option 1 to replace synthetic/recreated app-store UI with a Codex Android-emulator capture pipeline.

Prompt:
`prompts/CODEX_S5_REAL_PLAY_SCREENSHOT_CAPTURE_ANDROID_EMULATOR_v1.0.md`

Decision:
- Play screenshots must originate from the real installed app;
- capture target is Android API36 at 1080x1920 portrait when environment supports it;
- every screenshot must bind same-session raw screencap, foreground package proof, UIAutomator hierarchy and SHA-256;
- PASS and NOT_MET must be generated by the real engine;
- marketing composites may only frame/scale the captured pixels, not redraw/retouch app UI;
- synthetic app screens are prohibited;
- if emulator capability is unavailable, report BLOCKED instead of substituting fake UI.

Six screenshot jobs remain:
1. verified PASS result;
2. KB-limit selection;
3. Save/Share;
4. Custom KB/MB;
5. on-device Home/Processing;
6. genuine NOT_MET.

No Play Console mutation, signing, upload, testers, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized.


## D-060 — Codex screenshot execution requested; current chat has no runner (2026-10-02)

The human selected Option 1 to execute the prepared real-emulator screenshot prompt.

CHAT verified:
- the prompt exists;
- the repository is reachable;
- the prompt requires artifact-bound API36 emulator capture.

The current chat exposes no Codex execution runner, terminal session, Android emulator, or Work/Computer-use surface capable of launching the task.

Decision:
- do not pretend execution occurred;
- preserve status as `READY_FOR_EXTERNAL_CODEX_RUN / BLOCKED_IN_CHAT_NO_CODEX_RUNNER`;
- require the prompt to be run in a Codex/terminal environment with Android SDK + adb + API36 emulator;
- after execution, bring terminal result + evidence summary back to CHAT for independent audit.

No provider mutation, signing, upload, testers, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized.


## D-061 — Real screenshot capture passes evidence gate; store creative remains HOLD (2026-10-02)

The real API36 screenshot capture was committed and independently audited.

Capture commit:
`5e575b22f50c8309aefd71ff84db6dfb881ae122`

Independent audit:
`docs/qa/S5_REAL_PLAY_SCREENSHOT_CAPTURE_CHAT_INDEPENDENT_AUDIT_v1.0.md`

Decision:
- accept the six emulator captures as truthful artifact-bound runtime evidence;
- accept genuine PASS / NOT_MET semantics;
- accept raw/store byte identity as proof that no synthetic UI or retouching was introduced;
- do NOT accept the current identity-copy store PNGs as final premium listing creatives;
- do not reopen app UI or broad product design;
- require targeted recapture of 02 with a selected preset and 04 with a populated valid custom limit;
- clean status/notification clutter;
- optionally improve 03 framing to preserve PASS context plus actions;
- then build premium external compositions around original captured pixels.

Status:
`CAPTURE_EVIDENCE_PASS / STORE_VISUAL_HOLD`

Next scope:
`S5 PLAY SCREENSHOT PREMIUM COMPOSITION + TARGETED RECAPTURE`

No Play Console mutation, signing, upload, testers, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this decision.


## D-062 — Authorize premium Play screenshot v2 with targeted recapture (2026-10-02)

The human selected Option 1 after independent review of the real API36 screenshot capture.

Authorized scope:
`S5 PLAY SCREENSHOT PREMIUM COMPOSITION + TARGETED RECAPTURE`

Prompt:
`prompts/CODEX_S5_PLAY_SCREENSHOT_PREMIUM_COMPOSITION_TARGETED_RECAPTURE_v1.0.md`

Decision:
- preserve v1 raw capture evidence unchanged;
- mandatory recapture 02 with 200 KB selected and enabled Continue;
- mandatory recapture 04 with 750 KB populated and KB selected;
- optionally recapture 03 only if a stronger truthful single frame is possible;
- remove avoidable emulator/system clutter where safe;
- otherwise crop only system chrome in final composition;
- create six premium 1080x1920 Warm Ink creatives around genuine screenshot pixels;
- no phone hardware mockup, stock/lifestyle background, mascot, percentage claims, or synthetic UI;
- every embedded screenshot must pass deterministic pixel-fidelity verification against its source crop;
- human visual approval remains pending after Codex QA.

Expected terminal state:
`PLAY_SCREENSHOT_V2_PREMIUM_COMPOSITION_READY_HUMAN_REVIEW_REQUIRED`

No Play Console mutation, signing, upload, testers, release/rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized by this decision.


## D-063 — Play screenshot v2 passes final CHAT visual audit with one brand-consistency polish (2026-10-02)

V2 production commit:
`84ea8527343394b86898e8a2db96782e5cb4c75e`

Audit:
`docs/qa/S5_PLAY_SCREENSHOT_V2_CHAT_FINAL_VISUAL_AUDIT_v1.0.md`

Decision:
- accept the v2 composition system, sequence, truth binding, and visual differentiation;
- no broad redesign and no further emulator recapture are justified;
- retain the six-screen ordering;
- recommend one composition-only micro-polish before final human approval:
  replace external kicker `REDUCE PHOTO SIZE` with `PHOTO COMPRESSOR: KB LIMIT`;
- preserve the in-app `Reduce Photo Size` label exactly;
- preserve embedded screenshot pixels exactly;
- regenerate final hashes/contact sheet/manifest after the kicker-only change.

Current status:
`V2_VISUAL_AUDIT_PASS_WITH_BRAND_KICKER_MICRO_POLISH_RECOMMENDED / HUMAN_APPROVAL_PENDING`

Next scope:
`S5 PLAY SCREENSHOT V2.1 BRAND KICKER MICRO-POLISH`

No Play Console mutation, signing, upload, testers, release/rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized.


## D-064 — Authorize and complete Play screenshot V2.1 brand-kicker micro-polish (2026-10-02)

The human selected Option 1 and explicitly authorized:
`S5 PLAY SCREENSHOT V2.1 BRAND KICKER MICRO-POLISH`.

Final result commit:
`f787c438e23bc5fd14afe7968f4d2c72944d052e`

Decision:
- replace only external store-composition kicker on all six screenshots from `REDUCE PHOTO SIZE` to `PHOTO COMPRESSOR: KB LIMIT`;
- preserve embedded application screenshot pixels exactly;
- preserve in-app `Reduce Photo Size`;
- do not perform emulator recapture;
- regenerate screenshot hashes, contact sheet, composition manifest, and replayable proof.

Verification result:
`PASS_READY_FOR_HUMAN_VISUAL_APPROVAL`

The first orchestration workflow attempt failed before artifact mutation because its temporary YAML was malformed. It was repaired; the successful run produced the bound result above and removed the temporary workflow from the final tree. The failed attempt is not counted as PASS.

Authorization ref:
`USER_OPTION_1_2026-10-02_S5_PLAY_SCREENSHOT_V2_1_BRAND_KICKER_MICRO_POLISH`

No Play Console mutation, signing, upload, tester mutation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication is authorized.


## D-065 — Human approves exact Play screenshot V2.1 set (2026-10-02)

The human selected Option 1 for the explicitly bound:
`HUMAN PLAY STORE SCREENSHOT VISUAL APPROVAL`.

Approval is restricted to the exact six V2.1 assets bound to:
- result commit `f787c438e23bc5fd14afe7968f4d2c72944d052e`;
- manifest SHA-256 `5e7388b40d4039c285622d32b2a75f39d3980c492f77b902a0b06eb486ed78b4`;
- contact-sheet SHA-256 `1d4f99a757bedeabcad1d3bf2c476ba33d8dc88438f5313e4bd877b181bb6932`;
- six individual asset hashes in `evidence/store/S5_PLAY_SCREENSHOT_V2_1_HUMAN_VISUAL_APPROVAL_v1.0.json`.

Decision:
- close V2.1 screenshot visual review as `PASS_HUMAN_VISUAL_APPROVED_CLOSED`;
- authorize current visual/listing use of this exact hash-bound screenshot set;
- do not generalize approval to changed screenshot bytes or a future screenshot revision.

This approval does not grant Play Console mutation, package registration, signing/key operations, AAB upload, tester mutation, release/rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority.

Next authorized provider action remains:
`S5 PLAY CREATE-APP FLOW + PACKAGE STATUS CHECK ONLY`.

Approval ref:
`USER_OPTION_1_2026-10-02_HUMAN_PLAY_STORE_SCREENSHOT_VISUAL_APPROVAL`


## D-066 — HOLD package-status-only execution after current Play provider-flow revalidation (2026-10-02)

The human selected Option 1 to continue the previously authorized:
`S5 PLAY CREATE-APP FLOW + PACKAGE STATUS CHECK ONLY`.

Before any provider mutation, CHAT reverified current official Google Play Console documentation.

Finding:
- current official Create app flow documents language/name, app-or-game, free-or-paid, contact email, declarations, then final `Create app`;
- it does not document a package-name field or package-status checkpoint before the final Create app action;
- package names are described as unique and permanent for app files.

Decision:
`HOLD_PROVIDER_FLOW_CONFLICT`.

The existing package-status-only runbook assumed a pre-create package checkpoint that current official documentation does not support.

Because final Create app creation remains outside the current authorization, CHAT did not instruct or perform that irreversible provider action.

Audit:
`docs/ops/S5_PLAY_CREATE_APP_PACKAGE_STATUS_CURRENT_PROVIDER_AUDIT_2026_10_02_v1.0.md`

No Play Console mutation, signing/key action, upload, tester mutation, release/rollout, S6, BUILD promotion, Artifact Freeze, release, or publication occurred or is authorized.


## D-067 — Human authorizes final Google Play Create app action only (2026-10-02)

The human selected Option 1 after the current-provider-flow audit established that a pre-create package-status checkpoint is not documented.

Authorized:
`FINAL CREATE APP CREATION ONLY`

Canonical identity:
- Play title: `Photo Compressor: KB Limit`;
- package target: `com.afradadmedia.reducephotosize`.

The authorization permits the final Google Play `Create app` action and confirmation that the app entry exists.

Hard stop:
`IMMEDIATELY_AFTER_APP_ENTRY_CREATION`

This authorization does not extend to ownership proof, key creation/rotation/import, signing, AAB upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication.

Approval ref:
`USER_OPTION_1_2026-10-02_FINAL_CREATE_APP_CREATION_ONLY`

Evidence:
`evidence/play/S5_PLAY_FINAL_CREATE_APP_CREATION_ONLY_AUTHORIZATION_v1.0.json`


## D-068 — Direct Play Console UI supersedes generic provider-flow assumption (2026-10-02)

The user supplied a direct PDF capture of the actual Google Play Console Create app screen.

The capture visibly proves the account-specific UI contains a `Package name` field and a `Check availability` action before final `Create app`.

PDF SHA-256:
`7eb0c95038c87ea8154c9865513ca0751e1866914d4b64d0d725d2712e3799a2`

Decision:
- supersede the prior `HOLD_PROVIDER_FLOW_CONFLICT` execution disposition;
- restore the reversible package-status checkpoint;
- use least authority: check package availability before consuming the broader final Create app authorization;
- stop after the package-status result for CHAT review.

Canonical values:
- App name: `Photo Compressor: KB Limit`;
- Package name: `com.afradadmedia.reducephotosize`.

No signing, key operation, AAB upload, tester mutation, release/rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority is added.


## D-069 — Play package availability PASS; final Create app action is next (2026-10-02)

Direct user-supplied Play Console evidence shows:
- app name `Photo Compressor: KB Limit`;
- package `com.afradadmedia.reducephotosize`;
- green provider confirmation `Package name available`;
- default language `English (United States) – en-US`.

Screenshot SHA-256:
`5923b11e6455be89ded4b8220a68500bdaa2ab182a87866734eb3b1b8fee9a88`

Decision:
- close package-status checkpoint as `PACKAGE_STATUS_NEW_OR_AUTO_REGISTERABLE_OBSERVED`;
- package availability = PASS;
- activate the already-authorized `FINAL CREATE APP CREATION ONLY` scope;
- stop immediately after app entry creation.

No authority is added beyond the already-bound create-app-only scope.


## D-070 — Create app declarations technical audit passes with human attestation (2026-10-02)

Audit:
`docs/compliance/S5_CREATE_APP_DECLARATIONS_AUDIT_2026_10_02_v1.0.md`

Developer Program Policies:
`PASS_FOR_CREATE_APP_DECLARATION_SCOPE / PUBLICATION_COMPLIANCE_DEBT_OPEN`.

US export laws:
`TECHNICAL_SCOPE_PASS_NO_APP_CRYPTO_FOUND / HUMAN_LEGAL_ATTESTATION_REQUIRED`.

No material technical blocker was found for creating the Play app entry.

Publication remains blocked until privacy-policy and Data safety controls are completed.

The legal/developer declarations remain the responsibility of the account holder.

No authority beyond the existing `FINAL CREATE APP CREATION ONLY` scope is added.


## D-071 — Google Play app entry creation confirmed; hard stop honored (2026-10-02)

Direct post-create Play Console evidence shows the app Dashboard for:
`Photo Compressor: KB Limit`.

PDF SHA-256:
`82a0da061a94e6ee44256131c24b72a35c308d1859eb2c4c2002d796769d5f91`

Provider app id observed from the captured dashboard URL:
`4973120481844433940`.

Decision:
- close `FINAL CREATE APP CREATION ONLY` as PASS;
- mark app entry creation as provider-confirmed;
- record that the mandated post-create hard stop was honored;
- do not infer signing/key/upload/tester/release authority.

Next recommended provider scope:
`S5 PLAY APP SIGNING + UPLOAD KEY READ-ONLY STATUS AUDIT`.

This next scope is observation-only unless separately authorized.


## D-072 — Authorize Play App Signing + upload-key read-only status audit (2026-10-02)

The human selected Option 1 and explicitly authorized:
`S5 PLAY APP SIGNING + UPLOAD KEY READ-ONLY STATUS AUDIT`.

This is observation-only.

Allowed:
- navigate to the Play App Signing status page;
- inspect app-signing and upload-key certificate status;
- capture visible fingerprints/status/warnings.

Not allowed:
- key creation, change, reset, rotation, import, or upload;
- signing;
- AAB upload;
- tester mutation;
- release creation;
- rollout;
- S6;
- BUILD promotion;
- Artifact Freeze;
- publication.

Approval ref:
`USER_OPTION_1_2026-10-02_S5_PLAY_APP_SIGNING_UPLOAD_KEY_READ_ONLY_STATUS_AUDIT`

Evidence:
`evidence/play/S5_PLAY_APP_SIGNING_UPLOAD_KEY_READ_ONLY_STATUS_AUDIT_AUTHORIZATION_v1.0.json`


## D-073 — Protected with Play overview observed; signing audit remains partial (2026-10-02)

Direct provider evidence shows:
- `Good protection`;
- Automatic protection `1/1 active`;
- Play Integrity API `0/7 active`;
- Play Store protection `6/7 active`;
- Play Billing protection `0/4 active`.

This does not prove Play App Signing enrollment details or upload-key certificate state.

Decision:
continue only within the existing read-only signing audit authorization by opening the Play Store protection / Play app signing detail page.

No key/signing/upload mutation is authorized.


## D-074 — Play App Signing active; upload-key status still unknown (2026-10-02)

Direct provider screenshot shows:
`Protect app signing key — Releases signed by Play`.

Decision:
- mark Play App Signing as provider-confirmed active;
- do not infer upload-key certificate state;
- continue only within the authorized read-only audit by opening `Manage Play app signing`.

Screenshot SHA-256:
`e97edcb18a41b4c12cbbedf0c932c0b6956d07334fe3ab96d5cace925a16c5b3`.

No signing/key/upload mutation is authorized.


## D-075 — Close read-only Play App Signing audit; upload-key setup is next material decision (2026-10-03)

Direct provider key-management evidence shows:
- Play app-signing key status `In use`;
- app-signing SHA-256 fingerprint:
  `56:39:62:12:1D:E2:14:C3:C7:53:41:CB:54:8B:A2:C0:71:D7:16:25:F0:5A:34:77:98:21:5B:38:0F:00:9B:47`;
- upload-key fingerprints are not yet shown because the first app bundle has not yet been uploaded.

Decision:
- close `S5 PLAY APP SIGNING + UPLOAD KEY READ-ONLY STATUS AUDIT` as PASS;
- preserve the hard stop against key/signing/upload mutation;
- do not infer any existing authorized developer-held upload key;
- recommend a separate bounded scope:
  `S5 UPLOAD KEY CREATION + LOCAL RELEASE SIGNING ONLY`.

No Play upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority is added.


## D-076 — Authorize dedicated local upload key creation and fresh release AAB signing only (2026-10-03)

The human explicitly authorized:
`S5 UPLOAD KEY CREATION + LOCAL RELEASE SIGNING ONLY`.

Decision:
- create one dedicated developer-held upload key locally;
- keep all private material and passwords only on the human-controlled device;
- build a fresh release AAB from the verified repository source;
- sign that AAB locally with the upload key;
- verify the signature and record only public/non-secret evidence;
- stop before any Google Play upload.

Operational controls:
- `.gitignore` already excludes `*.jks`, `*.keystore`, `keystore.properties`, `secrets.properties`, and `.env*`;
- no Gradle signing configuration or secret path is added to application source;
- local helper signs outside the repository to minimize secret/artifact leakage.

Authorization ref:
`USER_EXPLICIT_2026-10-03_S5_UPLOAD_KEY_CREATION_LOCAL_RELEASE_SIGNING_ONLY`

Runbook:
`docs/ops/S5_UPLOAD_KEY_CREATION_LOCAL_RELEASE_SIGNING_RUNBOOK_v1.0.md`

Helper:
`scripts/local/s5_create_upload_key_and_sign.sh`

No Play upload or downstream release authority is granted.


## D-077 — Local upload-key signing passes screenshot review; canonical closure waits for result JSON (2026-10-03)

Direct terminal screenshot shows:
- fresh build success;
- local AAB signing success;
- signature verification PASS;
- public upload-certificate SHA-256:
  `22:EA:E7:C3:78:69:B8:1A:E7:13:F7:00:7C:11:44:10:EC:A8:67:82:6A:FE:BB:34:9A:B7:B9:61:C9:86:5F:F4`;
- signed AAB SHA-256:
  `d01a0bc609ea57421cbff727aff08109a4433c3d537f927acb8c441fbec1103d`;
- no Play upload performed.

Decision:
- accept the screenshot as strong execution evidence;
- keep final local-signing closure open until `S5_LOCAL_SIGNING_RESULT.json` is ingested and reconciled;
- preserve hard stop before any Play upload.

No AAB upload, tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority is added.


## D-078 — Close local upload-key creation + release-AAB signing as PASS (2026-10-03)

The returned `S5_LOCAL_SIGNING_RESULT.json` reconciles exactly with the previously observed terminal PASS for the public upload certificate fingerprint and signed-AAB SHA-256.

Accepted:
- source commit `91bb462de8007b6491be5c5ed6c073d60858ae70`;
- version `0.1.0` / versionCode `1`;
- upload certificate SHA-256 `22:EA:E7:C3:78:69:B8:1A:E7:13:F7:00:7C:11:44:10:EC:A8:67:82:6A:FE:BB:34:9A:B7:B9:61:C9:86:5F:F4`;
- signed AAB SHA-256 `d01a0bc609ea57421cbff727aff08109a4433c3d537f927acb8c441fbec1103d`;
- signed bytes `7984820`;
- jarsigner `PASS_JAR_VERIFIED`;
- no secret material recorded;
- no Play upload performed.

Repository comparison confirms no `app/` changes after verified application-source commit `27199bf6f174e55dc835d0d9898e456d3848001c` through signing commit `91bb462de8007b6491be5c5ed6c073d60858ae70`.

Decision:
`PASS_LOCAL_UPLOAD_KEY_CREATED_AND_RELEASE_AAB_SIGNED_VERIFIED`.

The earlier unsigned materialized candidate is provenance-only for signing. The fresh signed candidate is the current local Play-upload candidate, but Play acceptance has not been tested and upload remains unauthorized.

No tester mutation, release creation, rollout, S6, BUILD promotion, Artifact Freeze, release, or publication authority is granted.


## D-079 — Correct Internal Testing upload scope to provider-compatible release-draft upload (2026-10-03)

The human selected the prior recommendation to restore the preserved stash and prepare an Internal Testing upload-only scope.

Current official Google Play documentation was rechecked.

Finding:
Internal Testing AAB upload is performed inside an Internal testing release flow. A literal `AAB UPLOAD ONLY` action that forbids entering/creating a release draft is not provider-compatible.

Decision:
prepare, but do not yet authorize, the least-authority scope:
`S5 PLAY INTERNAL TESTING RELEASE-DRAFT + AAB UPLOAD ONLY`.

This scope would permit entering the mandatory release draft and uploading the already signed vc1 AAB solely to obtain provider validation, then stop before testers, review, rollout, or publication.

No Play mutation has been performed or authorized by this decision.
