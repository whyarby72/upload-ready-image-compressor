# UPLOAD-READY IMAGE COMPRESSOR
## PRODUCT DEFINITION CONTRACT + EXACT MVP SPECIFICATION
### v1.2.0 — PHOTO-FIRST UKDC WORKFLOW REBASE CANDIDATE

**Canonical working name:** Upload-Ready Image Compressor  
**Working store proposition:** *Know it's ready before you upload.*  
**Primary buyer job:** Make a photo satisfy an upload-size limit, verify that it actually satisfies the limit, preserve usability, and make the resulting file immediately obvious to save/share.  
**Target:** Global / English-first / Android / Google Play / solo-operator / low-maintenance / local-first.  
**Current decision:** `TEST`  
**Artifact state:** `PDC_MVP_REBASED_CANDIDATE / HUMAN_SCOPE_FREEZE_PENDING`  
**Rebase source:** v1.1.0 SHA-256 `aee5e65c26081ae7e744114697b818c2ccdd9d7cd41d26f3033f579d7ed54302`  
**Bound UI candidate:** `UPLOAD_READY_IMAGE_COMPRESSOR_UI_UX_v1.5.2_PHOTO_FIRST_UKDC_FINAL.html` SHA-256 `c0f8fc3cdd4bc409c0d2ac78ddbadddc99be67b65529462c4370a089b22c0975`  
**Monetization profile:** `TRUST_FIRST_ADMOB_v1`  
**Build authorization:** NOT GRANTED  
**Release / publication authorization:** NOT GRANTED  

---

# 1. BUYER JOB

## 1.1 Core job
> “This site says my image must be under X KB/MB. Give me a usable file that I know is under that limit, and make it immediately obvious where to find or share it.”

## 1.2 Buyer success
The buyer begins with the concrete asset they already have: the photo.

### Known-limit path
A session is successful only when all applicable conditions are true:

1. the user selects a photo;
2. the app detects current file size and available dimensions/format locally where supported;
3. the user specifies the website/form upload limit;
4. the app avoids unnecessary compression when the current file already satisfies that limit;
5. otherwise the app produces a candidate output;
6. the app verifies the actual output size against the known limit;
7. the app clearly states `PASS` or `NOT MET`;
8. the original is not overwritten;
9. the user can immediately save/share/open the output;
10. any material quality degradation or metadata behavior is disclosed.

### Unknown-limit path
When the buyer does not know the website/form limit:

1. the app may create a smaller usable copy;
2. the result must be labeled `REDUCED`, not `PASS` / `UPLOAD READY`;
3. the app must state that upload compatibility is not verified because no external limit was provided;
4. the original remains untouched and Save/Share remains available.

“Compression completed” alone is not buyer success.

---

# 2. FROZEN PAIN TAXONOMY

The following pain clusters are the only buyer-pain classes allowed to justify MVP scope changes before the Candidate-Direct TEST unless a new blocker materially breaks the core job.

| ID | Pain cluster | Severity | MVP consequence |
|---|---|---|---|
| P-01 | Intrusive ads/paywalls interrupt a tiny utility task | CRITICAL | No forced full-screen ad before first successful result |
| P-02 | User cannot tell whether target KB/MB was actually achieved | CRITICAL | Actual-byte verification + explicit PASS / NOT MET |
| P-03 | Aggressive target silently destroys useful image quality | CRITICAL | Quality guard + honest fallback/failure semantics |
| P-04 | Result exists but user cannot find/share it | CRITICAL | Explicit destination + Save/Share/Open Folder |
| P-05 | Compressor terminology/onboarding creates cognitive friction | HIGH | Job-first UX; target-limit language; no recurring onboarding |
| P-06 | Metadata changes/loss occur without informed choice | HIGH | Explicit metadata behavior; no silent side effect |
| P-07 | Subscription/trial pricing feels disproportionate for a simple utility | HIGH | No subscription-first MVP monetization |
| P-08 | Original file could be overwritten or user fears destructive behavior | HIGH | Original remains untouched by default |
| P-09 | Batch UX becomes confusing or artificially restricted | MEDIUM | Batch excluded from MVP; future design must be obvious |
| P-10 | Purchase restore/device migration can break paid entitlement | HIGH but non-core | Required only if/when one-time Pro is implemented |
| P-11 | Privacy/cloud uncertainty creates distrust | HIGH | Local-first processing; minimal permissions; no account |
| P-12 | Feature-bloat makes user choose tools instead of completing the job | HIGH | Single-job first screen; toolbox features excluded |

**Freeze law:** P-01 through P-12 are frozen as the current pain taxonomy. New feature requests do not enter MVP unless they demonstrably resolve one of these pains or a new core-job blocker is evidenced.

---

# 3. PRODUCT PROMISE

## 3.1 Primary promise
> **Know it's ready before you upload.**

## 3.2 Supporting promise
> Make any photo fit the upload limit in a few clear steps.

## 3.3 What the product is NOT
The MVP is not:

- a photo editor;
- a PDF suite;
- an OCR tool;
- a passport-compliance tool;
- a signature-management app;
- a background remover;
- an AI enhancer;
- a social-media resize suite;
- a cloud service;
- a file manager;
- an EXIF editor;
- a batch-production workstation.

---

# 4. MVP SCOPE — FROZEN

## 4.1 IN scope

### F-01 Target limit selection
User can choose:

- 50 KB
- 100 KB
- 200 KB
- 500 KB
- 1 MB
- Custom KB/MB

The presets are convenience/acquisition hooks. `Custom` is the canonical capability.

### F-02 Photo selection
Use a modern Android photo-selection flow with minimal permission surface.

**UKDC sequencing law:** although feature IDs remain stable for traceability, the default interaction order is `F-02 Photo selection → automatic CURRENT-state detection → F-01 Target limit selection`. The buyer must not be required to know current image size before selecting the photo.

After selection, locally detect when available:
- source file size;
- dimensions;
- supported input format.

If source size is already `<= requested_limit_bytes`, do not perform unnecessary recompression; verify and return PASS with `0%` reduction / unchanged copy semantics appropriate to implementation.

### F-03 Local compression
Compression runs locally on device for supported formats.

### F-04 Supported input/output
MVP minimum:
- JPEG/JPG input
- JPEG/JPG output

Optional in MVP only if implementation/QA cost remains low and deterministic:
- PNG input
- WebP input

No format-conversion feature marketing in MVP.

### F-05 Size verification
After processing, calculate and display actual output bytes.

### F-06 PASS / NOT MET state
Example:

`UPLOAD READY ✓`  
`194 KB ≤ 200 KB`

or:

`TARGET NOT MET`  
`31 KB > 20 KB`

### F-07 Quality guard
When a target requires material dimension/quality degradation, show an explicit warning before or immediately after the operation.

No absolute “no quality loss” claim.

### F-08 Preview
Show the output preview and key result facts:
- original size
- result size
- target limit
- output dimensions

### F-09 Original preservation
Never overwrite the source image by default.

### F-10 Save
Save a new copy with deterministic naming and a clear location.

### F-11 Share
Result screen exposes a visible Share action.

### F-12 Open location
Expose the saved location and an Open Folder / equivalent action where supported.

### F-13 Metadata behavior disclosure
The app must state whether material metadata is preserved or removed.

MVP must not silently change metadata behavior without disclosure.

### F-14 Offline/local-first behavior
Core compression must not require an account, remote API, or cloud upload.

### F-15 Minimal-permission posture
Do not request broad storage/media permission if the job can be completed with scoped Android selection APIs.

---

# 5. MVP EXCLUSIONS — HARD BOUNDARY

The following are explicitly `POST_MVP_BACKLOG`:

- batch compression;
- Select All;
- PDF creation/compression;
- crop;
- rotate;
- filters;
- image enhancement;
- AI features;
- passport templates;
- signature presets;
- social-media templates;
- background removal;
- HEIC conversion as a marketed feature;
- EXIF editing;
- metadata inspector;
- cloud sync;
- login/account;
- history library;
- document locker;
- advanced file manager;
- recurring subscription;
- App Open ads;
- rewarded ads / rewarded feature unlocks;
- native ads in MVP;
- custom folder tree management.

A feature can move into MVP only if it resolves a frozen critical buyer pain and the scope change is explicitly approved.

---

# 6. CORE UX FLOW

## Screen 1 — Photo first
Headline:
**Make your photo ready to upload.**

Primary CTA:
**Choose Photo**

Supporting promise:
- size is detected automatically;
- original remains untouched;
- no account required.

No upload-limit number is shown as the dominant first-screen value.
No tool dashboard.
No tutorial carousel.
No forced monetization screen.

## Screen 2 — Requirement
After photo selection, show the detected `CURRENT` state:
- filename only in local UI, not analytics;
- current file size;
- dimensions when available;
- input format when useful.

Then ask:
**What does the website require?**

Controls:
`50 KB` `100 KB` `200 KB`
`500 KB` `1 MB` `Custom`

Explicitly separate:
- `CURRENT`;
- `REQUIRED`;
- `RESULT`.

Primary CTA:
**Make it upload-ready**

Secondary:
**I don't know the website limit**

## Screen 2A — Already satisfies known limit
If `source_size_bytes <= requested_limit_bytes`:
- do not recompress merely to create activity;
- verify the existing/current file satisfies the requirement;
- show `UPLOAD READY`;
- show actual size `<=` limit;
- reduction may be `0%`;
- preserve original.

## Screen 3 — Processing
Use only when processing is actually required.

Show:
- selected image;
- current source size;
- known target, or `No website limit provided` for the reduced-only path;
- progress only if processing is perceptible.

No ad interruption.

## Screen 4 — Result: PASS
Headline:
**UPLOAD READY ✓**

Allowed only when a requirement is known and:
`output_size_bytes <= requested_limit_bytes`.

Facts:
- `CURRENT` / source size;
- `REQUIRED` / limit;
- `RESULT` / output size;
- proof such as `194 KB ≤ 200 KB`;
- dimensions;
- original unchanged;
- metadata behavior;
- saved location.

Primary actions:
**Share**
**Save / Done**

Secondary:
**Open Folder**
**Compress Another**

## Screen 4A — Result: REDUCED
Used only when the buyer chose the unknown-limit path.

Headline:
**REDUCED**

Show:
- source size → reduced size;
- reduction percentage;
- dimensions;
- original unchanged;
- explicit statement that upload compatibility is **not verified** because no website/form limit was provided.

Never display:
- `PASS`;
- `UPLOAD READY`;
- `Requirement verified`.

Actions:
**Share**
**Done**
**Set a website limit instead**

The unknown-limit path must not receive more aggressive monetization than the known-limit path.

## Screen 4B — Result: NOT MET
Headline:
**TARGET NOT MET**

Show:
- requested limit;
- best usable result;
- reason/quality guard;
- original unchanged;
- truthful recovery action.

No forced interstitial.

# 7. RESULT-STATE CONTRACT

```yaml
compression_result:
  source_file_ref: ""
  source_size_bytes: 0
  requested_limit_bytes: 0
  output_file_ref: ""
  output_size_bytes: 0
  output_width_px: 0
  output_height_px: 0
  original_overwritten: false
  metadata_behavior: PRESERVED | PARTIALLY_PRESERVED | REMOVED | UNKNOWN
  quality_guard_triggered: false
  target_state: PASS | NOT_MET | ERROR
  saved_state: SAVED | NOT_SAVED | UNKNOWN
  share_ready: true | false
```

Rules:

- `PASS` requires `output_size_bytes <= requested_limit_bytes`.
- `PASS` cannot be inferred from compressor completion alone.
- `original_overwritten` must remain `false` in MVP.
- `saved_state: SAVED` requires actual successful persistence.
- `share_ready: true` requires a real accessible output artifact.
- metadata state may not be silently UNKNOWN in final result if the implementation alters metadata.

---

# 8. MONETIZATION CONTRACT — MVP
## `TRUST_FIRST_ADMOB_v1`

### 8.1 Monetization objective
Monetization must occur **after value**, not in place of value.

Optimization order:

`buyer-job completion → trust/retention → compliant ad opportunities → impressions → revenue`

Revenue growth is not considered a product win if it materially harms:
- first successful completion;
- Save/Share completion;
- repeat usage;
- review sentiment;
- stability;
- policy posture.

### 8.2 Ad format allowlist — MVP

**Allowed**
1. **Anchored adaptive banner**
   - result surface only;
   - positioned below the core result and primary actions;
   - must not resemble a result/CTA;
   - must not shift controls under the user's finger when it loads.

2. **Interstitial**
   - only on an eligible natural transition **after** a successful completed job;
   - never required for ordinary compression;
   - absence/failure of an ad must never delay or block navigation.

**Disabled / excluded in MVP**
- App Open ads;
- Rewarded ads;
- Native ads;
- recurring subscription;
- forced rewarded unlock for ordinary compression.

Optional future monetization hedge:
- one-time `Remove Ads`, subject to separate billing QA and explicit scope approval.

### 8.3 Absolute placement prohibitions

A forced full-screen ad must never appear:
- before or during photo selection;
- before CURRENT-state detection needed for the buyer journey;
- before requirement selection/resolution;
- during compression;
- before the first result is visible;
- before Save/Share is available;
- on `TARGET NOT MET`;
- on `ERROR`;
- immediately after another interstitial;
- as an unexpected response to ordinary navigation.

No autoplay-audio experience may be intentionally introduced by the app outside the ad format's normal SDK behavior.

No deceptive close/skip/free path is permitted.

### 8.4 Banner placement rule

The result hierarchy remains:

1. result state (`UPLOAD READY ✓` / `TARGET NOT MET`);
2. target proof;
3. quality / original-preservation facts;
4. `Share`, `Save/Done`, `Open Folder`, `Compress Another`;
5. **then** the banner slot.

Banner rules:
- banner may be requested on a result screen;
- banner may be visible on the first successful result because it does not block the core job;
- it must remain visually separated from primary actions;
- if banner loading fails, no placeholder delay or blocking state is allowed;
- the core UI must remain stable with or without an ad.

### 8.5 Interstitial eligibility state machine

`INTERSTITIAL_ELIGIBLE = true` only when **all** conditions are true:

```yaml
interstitial_gate:
  package_runtime_valid: true
  consent_allows_ad_request: true
  current_job_target_state: PASS
  current_job_result_visible: true
  current_job_primary_actions_available: true
  transition_is_natural: true
  lifetime_successful_jobs: ">= 3"
  successful_jobs_since_last_interstitial: ">= 3"
  seconds_since_last_interstitial: ">= 300"
  interstitial_loaded: true
  app_in_foreground: true
```

**TEST DEFAULTS / ASSUMPTIONS, not Google policy facts:**
- first two successful jobs: `NO_INTERSTITIAL`;
- third and later successful jobs: may become eligible;
- at least three successful completions between shown interstitials;
- at least 300 seconds between shown interstitials.

The preferred show point is a user-initiated transition **away from the completed PASS result** (for example, `Compress Another` or return to the photo-first home), not before the user has seen or can act on the result. The `REDUCED` unknown-limit path does not create extra interstitial eligibility in MVP.

If an eligible interstitial is not already loaded:
- continue immediately;
- do not wait for it;
- do not replace it with another blocking monetization surface.

`TARGET NOT MET` and `ERROR` reset no entitlement and trigger no forced interstitial.

### 8.6 Frequency-cap governance

Frequency-cap values are **test parameters**, not permanent universal constants.

They may be made less aggressive if:
- task completion falls;
- repeat use falls;
- ad-related review complaints appear;
- accidental-click risk increases;
- policy/review evidence indicates the current cadence is too intrusive.

They may only become more aggressive after:
- first-party evidence shows no material buyer-job degradation;
- current AdMob policy is revalidated;
- the change receives explicit versioned monetization review.

No optimization system may increase ad frequency based solely on eCPM.

### 8.7 Consent / privacy / request guard

Before requesting ads:
- obtain current consent state using the current Google-supported UMP flow where required;
- refresh consent information on app launch as required by the current SDK guidance;
- expose a privacy-options entry point when the active privacy message requires it;
- request ads only when the active consent state permits ad requests.

Core compression must remain usable if:
- consent is not granted;
- an ad request fails;
- the device is offline;
- AdMob is unavailable.

Ad/analytics integration must never upload:
- image bytes;
- image previews;
- filenames;
- filesystem paths;
- EXIF payloads;
- GPS/location metadata from selected photos.

### 8.8 Development / QA ad-safety rules

During build, automated testing, screenshots, and QA:
- use Google-provided test ad units or registered test devices;
- never click live ads for testing;
- live ad units are release configuration, not development fixtures;
- ad load/show failures are non-blocking app events;
- full-screen callbacks must restore the user cleanly to the intended app state.

### 8.9 Analytics event contract

Analytics is for proving whether monetization damages or supports the buyer job.

#### Core product events

```yaml
events:
  app_session_start:
    properties: [session_index]

  photo_selected:
    properties: [input_format, input_size_bucket]
    prohibited: [filename, path, image_content, exif, gps]

  source_state_detected:
    properties: [input_format, input_size_bucket, dimension_bucket]
    prohibited: [filename, path, image_content, exif, gps]

  requirement_path_selected:
    properties: [path]
    allowed_path_values: [known_limit, unknown_limit]

  limit_selected:
    properties: [target_bucket, is_custom]

  compression_started:
    properties: [target_bucket, requirement_path]

  compression_result:
    properties:
      [target_state, output_size_bucket, output_dimension_bucket,
       quality_guard_triggered, processing_duration_bucket]

  result_action:
    properties: [action]
    allowed_action_values:
      [share, save_done, open_folder, compress_another]

  result_exit:
    properties: [target_state, action_taken]
```

#### Monetization events

```yaml
ad_events:
  banner_request:
    properties: [surface]
  banner_loaded:
    properties: [surface]
  banner_impression:
    properties: [surface]
  banner_failed:
    properties: [surface, error_class]

  interstitial_eligible:
    properties:
      [lifetime_successful_jobs, jobs_since_last_interstitial,
       cooldown_bucket, transition_type]

  interstitial_request:
    properties: [transition_type]

  interstitial_loaded:
    properties: []

  interstitial_shown:
    properties:
      [transition_type, lifetime_successful_jobs,
       jobs_since_last_interstitial]

  interstitial_dismissed:
    properties: []

  interstitial_failed:
    properties: [error_class]

  ad_revenue_paid:
    properties:
      [ad_format, value_micros, currency_code, precision_type]
```

#### Consent telemetry

Only non-sensitive state is allowed:

```yaml
consent_event:
  properties:
    [can_request_ads, privacy_options_required, consent_flow_result]
```

Do **not** log raw consent strings or selected-photo metadata.

### 8.10 Monetization health metrics

Primary monetization metrics:
- banner impressions / successful jobs;
- interstitial impressions / eligible transitions;
- show rate;
- match/fill indicators available from AdMob reporting;
- eCPM;
- estimated earnings;
- finalized earnings when available;
- ad revenue / successful job;
- Ads ARPU / ARPDAU where statistically meaningful.

Mandatory buyer-job countermetrics:
- first successful completion rate;
- PASS result rate by target bucket;
- Save/Share action rate;
- repeat successful jobs / user;
- D1/D7 retention when sample size supports interpretation;
- crash/ANR;
- ad-related negative review themes.

A monetization change is not accepted solely because revenue or eCPM rises.

### 8.11 Hard monetization invariants

```yaml
trust_first_admob_invariants:
  forced_fullscreen_before_first_result: 0
  forced_fullscreen_on_not_met: 0
  forced_fullscreen_on_error: 0
  ad_wait_required_for_core_job: false
  subscription_required_for_core_job: false
  rewarded_required_for_core_job: false
  original_image_sent_to_ad_or_analytics_system: false
  filename_or_path_sent_to_ad_or_analytics_system: false
```

Violation of any invariant is a release blocker.

### 8.12 Current-policy revalidation gate

Before any production release or material ad-cadence change, reverify from current official Google sources:
- permitted interstitial placement;
- current Google Mobile Ads SDK requirements;
- banner implementation guidance;
- UMP / consent requirements;
- test-ad requirements;
- any relevant Google Play / AdMob policy changes.

The engine must not freeze SDK versions, policy wording, or privacy rules as permanent facts.


# 9. PRIVACY / DATA CONTRACT

MVP target posture:

- no account;
- no server-side image processing;
- no image upload to developer infrastructure;
- no broad library access when scoped picker is sufficient;
- originals remain local;
- outputs remain local unless user explicitly shares them.

If analytics/crash tooling is added, its data scope must be separately documented and must not include image content.

**Network boundary clarification:** the core compression job remains local-first/offline-capable, while AdMob/consent/analytics services may use network connectivity when enabled. Their unavailability must not prevent compression, verification, Save, or Share.

The monetization telemetry allowlist/prohibitions in §8.9 is authoritative for MVP ad/analytics event payloads.

---

# 10. NON-FUNCTIONAL REQUIREMENTS

## NFR-01 Speed
Ordinary single-image jobs should feel immediate on a representative modern Android device.

## NFR-02 Determinism
Same source + same target + same algorithm version should produce stable result semantics, even if byte output is not bit-identical across all codec/device conditions.

## NFR-03 Recovery
Processing failure must not corrupt or overwrite the original.

## NFR-04 Accessibility
Primary controls require accessible names, readable contrast, and sensible focus order.

## NFR-05 Device compatibility
No release PASS without device/API verification appropriate to the supported Android range.

## NFR-06 Low-support design
Common failures must be recoverable without contacting the developer.

## NFR-07 Monetization non-blocking
Ad loading, consent refresh, analytics transmission, or AdMob failure must not delay or block the core compression/result/save/share job.

---

# 11. PAIN → REQUIREMENT TRACEABILITY

| Pain | Requirements |
|---|---|
| P-01 ads interrupt task | §8 |
| P-02 target uncertainty | F-05, F-06, §7 |
| P-03 quality collapse | F-07, NOT MET recovery |
| P-04 result hard to find/share | F-10, F-11, F-12 |
| P-05 confusing workflow | §6, F-02 → F-01 UKDC sequence |
| P-06 metadata surprise | F-13, §7 |
| P-07 subscription fatigue | §8.2 |
| P-08 destructive anxiety | F-09, §7 |
| P-09 batch friction | §5 backlog |
| P-10 restore failure | post-MVP billing QA |
| P-11 privacy distrust | F-14, F-15, §9 |
| P-12 feature bloat | §3.3, §5, §6 |
| P-01/P-07 monetization trust | §8.1–§8.12, NFR-07 |

---

# 12. CANDIDATE-DIRECT TEST HYPOTHESES

## H1 — Positioning
Users understand **“Know it's ready before you upload”** faster than generic “image compressor / MB to KB” positioning.

## H2 — Result proof
`194 KB ≤ 200 KB — PASS` materially increases trust versus generic “Compression successful”.

## H3 — First-action comprehension
A photo-first flow (`Choose photo → detect CURRENT → ask REQUIRED`) is easier to understand than the prior limit-first flow and toolbox-mode selection for this buyer job.

## H4 — Monetization restraint
A non-interruptive first journey improves user preference/trust versus competitors that show aggressive ads/paywalls.

## H5 — Global relevance
Generic upload-limit positioning is more globally transferable than signature/exam/passport-specific positioning.

---

# 13. TEST PASS / HOLD / KILL CRITERIA

These are test-design criteria, not claims of current performance.

## PASS toward BUILD consideration
Advance only if candidate-direct testing shows:

- users correctly understand the product's job without explanation;
- users understand that they do not need to know the current photo size before choosing a photo;
- users understand `CURRENT` versus `REQUIRED` versus `RESULT`;
- users can identify how to set a known target limit after photo selection;
- users correctly interpret PASS / NOT MET;
- users understand that the unknown-limit path is only `REDUCED`, not verified upload readiness;
- users can identify where to save/share the result;
- the value proposition is distinguishable from generic compressor language;
- no material buyer confusion requires adding a toolbox or tutorial;
- monetization concept does not materially block the perceived core job.

## HOLD / REWORK
Use when:
- product job is understood but naming/visual hierarchy is weak;
- users understand the job but do not understand the photo-first → requirement sequence;
- users mistake CURRENT size for REQUIRED limit or RESULT;
- users interpret `REDUCED` as a verified PASS without a known requirement;
- quality/failure explanation is confusing;
- save/share path is unclear;
- store creative fails to differentiate despite product clarity.

## KILL / REJECT
Kill the candidate before full build if:
- users perceive no meaningful difference from generic compressors;
- the core promise cannot be communicated without feature bloat;
- trust advantage is not understood or valued;
- current Play competition makes the entry wedge indistinguishable at listing level;
- the simplest credible implementation still requires disproportionate maintenance/support;
- AdMob economics would require intrusive monetization to be viable.

---

# 14. BUILD BOUNDARY

This frozen PDC does **not** authorize full production.

Required next step:

`Candidate-Direct TEST Package`

Minimum test artifacts:
- title hypotheses;
- short-description hypotheses;
- six Play screenshot concepts;
- first-screen prototype;
- result-screen prototype;
- monetization proposition;
- test script;
- pass/hold/kill rubric.

Only after behavioral/candidate-direct evidence is strong enough may the canonical decision move toward `BUILD`.

---

# 15. FROZEN CHANGE CONTROL

Version: `v1.1.0`

Frozen scope:
- buyer job;
- pain taxonomy P-01..P-12;
- IN-scope F-01..F-15;
- MVP exclusions;
- UX flow;
- PASS/NOT MET semantics;
- monetization boundary;
- `TRUST_FIRST_ADMOB_v1` format allowlist, placement invariants, eligibility rules, analytics payload boundary;
- privacy/local-first boundary;
- test hypotheses and kill criteria.

Allowed without version bump:
- copy refinement;
- visual styling;
- non-material implementation detail;
- bug clarification.

Requires version bump + explicit scope review:
- new core feature;
- remote/cloud dependency;
- subscription;
- batch as MVP;
- PDF/editor/passport/signature scope;
- metadata-editor scope;
- altered buyer job;
- altered PASS definition;
- changed original-overwrite behavior;
- monetization before first successful result.

---


# 15A. VERSION DELTA — v1.0.0 → v1.1.0

This version does **not** change:
- buyer job;
- frozen pain taxonomy;
- core compression scope;
- PASS / NOT MET semantics;
- original-preservation rule;
- no-cloud image-processing rule;
- current canonical decision `TEST`.

It **does** formalize the previously approved monetization direction into:
- MVP ad-format allowlist;
- result-screen banner placement;
- conservative interstitial eligibility and frequency-cap defaults;
- no-ad failure semantics;
- UMP/consent guard;
- development test-ad safety;
- analytics event allowlist/prohibited payloads;
- monetization health metrics and hard invariants.

Because the PDC is frozen and monetization behavior is release-relevant, this integration is issued as **v1.1.0**, not an in-place edit of v1.0.0.

---

# 16. STATUS

```yaml
product:
  canonical_name: UPLOAD_READY_IMAGE_COMPRESSOR
  pdc_version: v1.2.0
  pdc_state: PHOTO_FIRST_UKDC_REBASE_CANDIDATE
  human_scope_freeze_pending: true
  decision: TEST
  build_authorized: false
  artifact_freeze: false
  release_authorized: false
  publication_authorized: false
  prior_limit_first_test_package_state: SUPERSEDED_PENDING_REBASE
  next_required_action: CANDIDATE_DIRECT_TEST_PACKAGE_REBASE
```
