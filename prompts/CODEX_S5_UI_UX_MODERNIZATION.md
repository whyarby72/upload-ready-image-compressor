# CODEX TASK-S5-004 — PROFESSIONAL UI/UX MODERNIZATION

Repository:
`whyarby72/upload-ready-image-compressor`

Branch:
`task/TASK-S5-004`

Read:
1. `CURRENT_TASK.md`
2. `docs/ux/S5_UI_UX_BENCHMARK_FORENSICS_v1.0.md`
3. `docs/ux/S5_UI_DESIGN_SYSTEM_BLUEPRINT_v1.0.md`
4. `docs/ux/S5_HIGH_FIDELITY_MOCKUP_REVIEW_v1.0.md`
5. `docs/ux/S5_UI_UX_MODERNIZATION_BRIEF_v1.0.md`
6. `PRODUCT_SPEC.md`
7. `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md`
8. `docs/ux/S5_003_FINAL_INDEPENDENT_AUDIT_v1.0.md`

Execute TASK-S5-004 as a controlled UI/UX redesign.

Important:
- implement the binding `PRECISION UTILITY` design system, not a generic visual refresh;
- redesign composition, not just colors;
- remove legacy platform-button look;
- keep XML/View architecture; do not migrate to Compose;
- preserve every frozen functional/truth rule;
- Save copy becomes primary result action;
- Share becomes secondary;
- Compress another tertiary;
- use modern vector iconography instead of Unicode glyphs;
- preserve accessibility/touch sizes;
- do not add unrelated features.

Before coding, inspect current API36 screenshots and source.

After coding:
- run full required verification;
- capture fresh screenshots;
- generate fresh APK/AAB hashes;
- update TEST_MATRIX, PROJECT_STATE, HANDOFF_CURRENT, evidence index;
- mark prior AAB `064478b56efb5e327dc27c0a37a91cc0626889cad5f6025b767c3a845e2019fc` provenance-only after source changes;
- push ordinary commits to `task/TASK-S5-004`.

Stop for reviewer:
CHAT independent visual/artifact audit.

Do not sign/upload to Play.
Do not integrate AdMob.
Do not claim S6, BUILD, Artifact Freeze, release, or publication.


## Mockup truth guard

The high-fidelity mockup is directional, not literal.

Do NOT implement:
- `Metadata (EXIF) preserved`;
- guaranteed target-success wording;
- inconsistent friendly-size vs exact-byte values;
- a precise promised result on first-open illustration;
- decorative back/overflow controls with no action;
- confetti/celebration decoration.

Default CURRENT PHOTO visual should use a vector/photo icon unless a real thumbnail can be added without broadening product behavior.

Unknown-limit action must remain visible/reachable.

Preferred PASS status:
`MEETS LIMIT`
not `UPLOAD READY` as the sole state.
