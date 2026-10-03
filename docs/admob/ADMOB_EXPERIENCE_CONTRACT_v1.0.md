# ADMOB EXPERIENCE CONTRACT v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Status: W1 BOUND / IMPLEMENTATION NOT YET AUTHORIZED

```yaml
admob_experience_contract:
  app_id_scope: TEST
  formats:
    banner:
      enabled: true
      variant: anchored_adaptive_in_flow
      screens:
        - ResultScreen
      placement: after_result_proof_and_after_Save_Share_CompressAnother
      placement_rationale: "First verified value and all core completion actions remain ahead of monetization."
    native:
      enabled: false
    interstitial:
      enabled: false
      allowed_transition_points: []
      prohibited_transition_points:
        - app_start
        - Home_to_picker
        - picker_to_requirement
        - requirement_to_processing
        - processing_to_result
        - before_Save
        - before_Share
        - error_recovery
    rewarded:
      enabled: false
    app_open:
      enabled: false

  first_session_ad_policy: "No ad request before the first verified result is rendered."
  request_gate: "UMP canRequestAds() == true"
  accidental_click_guardrails:
    - "No ad adjacent to Save/Share tap targets."
    - "No overlay on system gesture/navigation area."
    - "No deceptive styling that resembles app controls."
  content_obstruction_guardrails:
    - "Never cover result proof, Save, Share, Compress another, errors or recovery."
  loading_failure_behavior: "Collapse to no-ad behavior; never block core."
  offline_behavior: "Core remains fully functional; ad silently absent."
  consent_dependency: "requestConsentInfoUpdate every launch; required form; canRequestAds before ads."
  privacy_options: "Visible Privacy choices entry point when UMP reports REQUIRED."
  analytics: "NONE"
  mediation: "NONE_INITIAL"
  publisher_first_party_id: "DISABLED_INITIAL"
  source_image_data_to_ads: false
  test_ad_strategy: "Google test ads / test device only until separate live-serving authorization."
  result: PASS_W1_BOUND
```

Any format expansion requires a new product/UX decision and W2 regression.
