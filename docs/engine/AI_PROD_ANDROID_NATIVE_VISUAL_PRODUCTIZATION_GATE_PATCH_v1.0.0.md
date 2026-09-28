# AI-PROD ANDROID NATIVE VISUAL PRODUCTIZATION GATE PATCH v1.0.0

Status: PROJECT-RUNTIME CORRECTIVE / GLOBAL PROMOTION CANDIDATE
Observed: 2026-09-28
Parent runtime: PRIMARY_RUNTIME_ENGINE v5.16.25
Target adapter: Android production workflow / native buyer-facing apps

## 0. Purpose

Close the enforcement gap where a technically correct Android app can pass functional, geometry, and ordinary screenshot review while still shipping with placeholder-like visual identity, missing launcher assets, weak mockup fidelity, or incomplete visual storytelling.

This patch adds no new canonical G0-G12 gate.
It binds native-mobile visual-productization requirements into existing:
- G2 Product / Experience Direction;
- G3 Reproducible Source-of-Truth;
- G5 Buyer-Deliverable Semantic Gate where visual meaning is buyer-critical;
- G7 Engineering / Environment / Accessibility / Localization;
- G8 Buyer Clean-Room Journey;
- G11 Final RED;
- Android S2 / S4 / S5.

## 1. Activation

Activate when ANY is true:
- app is positioned PROFESSIONAL or PREMIUM;
- buyer trust/conversion materially depends on visual quality;
- a high-fidelity mockup or approved creative direction exists;
- first-open comprehension materially affects adoption/support;
- custom brand identity is part of the intended product;
- app-store-facing screenshots will depend on in-app visual polish;
- user explicitly requests visual quality beyond default platform styling.

For a minimal/internal engineering utility where visual quality is immaterial, this adapter may be N_A_WITH_REASON.

## 2. Core law

`FUNCTIONAL + CLEAN != VISUALLY PRODUCTIZED`

A native mobile app may be technically complete while visual productization remains REWORK.

Visual-productization PASS requires both:
1. deterministic implementation evidence; and
2. scoped human judgment when premium/taste quality is material.

## 3. Asset classes

Every activated app must classify buyer-visible assets:

```yaml
native_visual_asset_classes:
  launcher_identity:
    required: true
  in_app_brand_mark:
    required: true
  functional_icons:
    required: true
  hero_or_first_open_media:
    required: CONDITIONAL
  user_media:
    required: CONDITIONAL
  semantic_status_assets:
    required: CONDITIONAL
  empty_error_permission_media:
    required: CONDITIONAL
  store_listing_assets:
    required: LATER_SEPARATE_SURFACE
```

Rules:
- one generic functional glyph must not silently substitute for launcher identity, brand mark, hero art, and state illustration simultaneously;
- user-provided media may be the primary visual object on selected-photo, processing and result screens;
- decorative imagery is not required merely to fill space;
- every asset must serve comprehension, identity, trust, or hierarchy.

## 4. Native visual asset manifest

At G2/S2 create:

```yaml
native_visual_asset_manifest:
  visual_direction_id: ""
  quality_floor: TEST_CREDIBLE | PROFESSIONAL | PREMIUM
  launcher_icon:
    asset_id: ""
    type: ADAPTIVE_VECTOR | VECTOR | RASTER | OTHER
    fallback_ready: false
    themed_or_monochrome_support: N_A | PASS | HOLD
    provenance: OWNED | GENERATED_OWNED | LICENSED | UNKNOWN
    status: PASS | HOLD | FAIL
  in_app_brand_mark:
    asset_id: ""
    distinct_from_generic_function_icon: false
    status: PASS | HOLD | FAIL
  screen_assets:
    - screen_id: ""
      buyer_job: ""
      primary_visual_role: USER_MEDIA | OWNED_ILLUSTRATION | BRAND_MARK | NONE_WITH_REASON
      required_asset_ids: []
      allowed_substitutions: []
      forbidden_placeholders: []
      status: PASS | HOLD | FAIL
  mockup_reference_ids: []
  visual_object_parity_status: PASS | HOLD | REWORK
  provenance_status: PASS | HOLD | FAIL
  result: PASS | HOLD | REWORK
```

No activated app may advance with omitted asset roles hidden inside prose.

## 5. Mockup-to-runtime fidelity matrix

When a mockup/reference exists, record object-level parity:

```yaml
mockup_runtime_fidelity:
  reference_id: ""
  runtime_artifact_digest: ""
  screens:
    - screen_id: ""
      required_visual_objects: []
      implemented_visual_objects: []
      intentional_deltas: []
      missing_objects: []
      placeholder_like_objects: []
      composition_match: PASS | HOLD | REWORK
      visual_signature: DISTINCT | GENERIC | INCONSISTENT | UNKNOWN
      human_quality_status: PASS | HOLD | REWORK
  result: PASS | HOLD | REWORK
```

A visual delta is allowed when it protects truth, accessibility, performance, platform conventions, or buyer-job clarity.
Unexplained loss of richness/identity is not an acceptable delta.

## 6. Placeholder-escape controls

`REWORK` if any material condition applies:
- no dedicated launcher icon for a buyer-facing app;
- platform/default/generic photo glyph is used as final brand identity without explicit design rationale;
- first-open hero is a symbolic placeholder that is materially weaker than the approved mockup;
- custom illustration promised by the reference is replaced by a generic card+icon without review;
- screenshots were reviewed for clipping/geometry but not for visual-signature/asset completeness;
- screen can be described as a wireframe/prototype with finished colors;
- the app uses technically valid empty space where the approved direction required meaningful media/visual storytelling;
- stock/generative art is used without provenance/licensing control;
- decorative art obscures buyer action, truth, accessibility, or performance.

## 7. Native visual QA contract

```yaml
native_visual_productization_qa:
  launcher_identity: PASS | HOLD | FAIL
  in_app_brand_mark: PASS | HOLD | FAIL
  functional_icon_consistency: PASS | HOLD | FAIL
  hero_asset_quality: PASS | HOLD | FAIL | N_A
  per_screen_visual_role_completeness: PASS | HOLD | FAIL
  mockup_runtime_fidelity: PASS | HOLD | REWORK | N_A
  actual_runtime_screens_reviewed: false
  visual_signature: DISTINCT | GENERIC | INCONSISTENT | UNKNOWN
  placeholder_escape_count: 0
  asset_provenance: PASS | HOLD | FAIL
  small_width_320dp: PASS | HOLD | FAIL
  standard_width_360dp: PASS | HOLD | FAIL
  font_scale_1_3x: PASS | HOLD | FAIL
  accessibility_semantics: PASS | HOLD | FAIL
  performance_budget: PASS | HOLD | FAIL
  human_premium_quality:
    required: false
    status: N_A | PENDING | APPROVE | REWORK
    evidence_reference: ""
  result: PASS | HOLD | REWORK
```

## 8. Stage binding

### S2 / G2
If activated:
- creative direction is insufficient unless visual asset roles are named;
- mockup-derived hero/brand/state assets become explicit requirements;
- distinguish functional icons from identity/illustration assets.

### S3/S4
Codex may implement assets and prove:
- resource packaging;
- rendering;
- density/scaling;
- performance;
- accessibility semantics;
- no remote dependency for core visuals where local/offline behavior is promised.

Technical rendering PASS does not equal premium-quality PASS.

### S5
Before `INTERNAL_TEST_READY` when visual quality is material:
- actual runtime screenshots must be reviewed;
- asset manifest must have no material HOLD;
- mockup fidelity must be reconciled;
- launcher identity must be present;
- visual signature must not be GENERIC unless explicitly accepted;
- applicable human premium-quality review must be current.

If these are missing:
`S5_HOLD_VISUAL_PRODUCTIZATION`.

## 9. Human approval semantics

Separate scopes:

`CREATIVE_DIRECTION`
approves what the product should look/feel like.

`PREMIUM_QUALITY`
approves the actual implemented runtime presentation at the declared visual-quality scope.

`GEOMETRY_VISUAL`
approves proportional/crop/Fit behavior only.

One must not be silently substituted for another.

An approval that reviewed geometry/copy only cannot close asset-completeness/premium-quality requirements.

## 10. Evidence

Minimum:
- actual launcher/device home-screen icon capture or equivalent packaged-resource proof;
- actual first-open screenshot;
- all materially distinct buyer states;
- 320dp;
- representative 360dp;
- 1.3x font scale when applicable;
- asset manifest;
- runtime/mockup fidelity matrix;
- asset provenance;
- exact source/artifact identity.

## 11. Asset-quality rules

Prefer:
- local vector assets for brand/semantic shapes;
- local raster only where richer image treatment requires it;
- coherent stroke/radius/optical grammar;
- no baked text in illustration unless localization is intentionally impossible/not applicable;
- restrained visual storytelling that supports the buyer job.

Avoid:
- random stock photography;
- decorative AI-art filler;
- multiple unrelated illustration styles;
- gradients/glows merely to appear modern;
- large images that push the primary action below the useful first viewport without evidence.

## 12. Late-defect recovery

When this defect appears late:
1. preserve valid functional/technical evidence by scope;
2. reopen the earliest visual control that was under-specified;
3. pause release/provider handoff;
4. create visual asset manifest/spec;
5. repair presentation only;
6. invalidate only affected visual/artifact evidence;
7. rebuild and rerun affected runtime QA;
8. obtain scoped human premium-quality approval if material;
9. resume provider/release workflow only after closure.

## 13. Promotion criterion

This patch should be promoted beyond the current product only if:
- it is demonstrated to prevent a second independent native-app visual escape; or
- review confirms the Android SOP lacks an equivalent binding and the patch introduces no capability collision.

Until then it is a project-runtime corrective and reusable promotion candidate, not a replacement Primary Runtime Engine.
