# Production State Machine

S0 OPPORTUNITY
-> S1 CONCEPT_VALIDATION
-> S2 PDC_SPEC_READY
-> S3 FUNCTIONAL_VERTICAL_SLICE
-> S4 CORE_TECHNICAL_PASS
-> S5 INTERNAL_TEST_READY
-> S6 INTERNAL_TEST_PASS
-> S7 ADMOB_PRIVACY_INTEGRATED
-> S8 MONETIZATION_QA_PASS
-> S9 PLAY_COMPLIANCE_READY
-> S10 CLOSED_TEST_OR_PRODUCTION_ACCESS
-> S11 PRODUCTION_READINESS
-> S12 HUMAN_ARTIFACT_FREEZE
-> S13 HUMAN_PUBLICATION_APPROVAL
-> S14 PRODUCTION
-> S15 OPERATE_OPTIMIZE

Late defect: reopen the earliest owner/control that should have caught it.
Scripts may validate/summarize state but may never self-authorize material scope, Artifact Freeze, release, publication, or irreversible account action.
