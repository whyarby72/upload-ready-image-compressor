# S7 AdMob + UMP TEST Integration — CI Closure

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`
Branch: `task/TASK-S7-001`

## Authorized scope

`S7 CODEX ADMOB+UMP TEST-INTEGRATION ONLY`

No AdMob account/app mutation, production ad-unit creation, Play declaration mutation, S8 promotion, BUILD promotion, Artifact Freeze, broader testing, release or publication was authorized.

## Implementation baseline

Final integration head:
`49829356e02c41357db9bce64463ddead1d1d1f4`

Pinned dependencies:
- GMA Next-Gen `1.5.0`
- UMP `4.0.0`
- AndroidX Fragment `1.9.0` to satisfy the ActivityResult lint requirement exposed by the integrated dependency graph.

TEST-only provider identifiers:
- Google sample App ID
- Google sample adaptive-banner ad-unit ID

Bound product behavior:
- UMP consent-info refresh on app launch;
- consent form path when required;
- `canRequestAds()` gates ad eligibility;
- Privacy choices entry point exposed when required;
- GMA initialization is idempotent and performed off the UI thread;
- Publisher first-party ID disabled before ad eligibility;
- one ResultScreen adaptive banner only;
- banner is placed after verified result proof and after Save / Share / Compress another;
- ad failure/no-fill does not block the buyer job;
- no analytics, mediation, interstitial, app-open, rewarded or native ad format.

## CI repair history

### Attempt 1 — FAIL / repaired

Run ID: `37116803362`
Commit: `999564b4549dac3910e2be360fb441863baf4808`

Failure:
`ResultBannerAd.kt` instantiated Next-Gen `AdLoadCallback<BannerAd>` as if it had a constructor.

Disposition:
`PARTIAL / NOT PASS`

Repair:
`de3ea56b60bcb3b2931049fc588126eb09743b0c`
changed callback implementation to the Kotlin interface form.

### Attempt 2 — FAIL / repaired

Run ID: `37117064758`
Commit: `de3ea56b60bcb3b2931049fc588126eb09743b0c`

Evidence:
- `assembleDebug`: PASS
- `testDebugUnitTest`: PASS
- `lintDebug`: FAIL

Lint blocker:
`InvalidFragmentVersionForActivityResult`

Disposition:
`PARTIAL / NOT PASS`

Repair:
`49829356e02c41357db9bce64463ddead1d1d1f4`
pins `androidx.fragment:fragment:1.9.0`.

### Attempt 3 — PASS

Run ID: `37117336418`
Commit: `49829356e02c41357db9bce64463ddead1d1d1f4`

Observed CI evidence:
- `PREFLIGHT_PASS`
- `:app:assembleDebug` — `BUILD SUCCESSFUL`
- `:app:testDebugUnitTest` — `BUILD SUCCESSFUL`
- `:app:lintDebug` — `BUILD SUCCESSFUL`
- `CI_VERIFY_PASS`

Final run conclusion:
`success`

## Non-blocking tooling debt

CI reported infrastructure/tooling notices:
- deprecated Gradle behavior that will require attention before Gradle 10;
- `actions/setup-java@v4` deprecation;
- GitHub Actions Node.js runtime deprecation notices for some action versions.

These do not invalidate the current application build/test/lint PASS.

## Gate interpretation

Code + deterministic CI:
`PASS`

Provider/live-AdMob readiness:
`NOT_RUN`

Real-device UMP/ad runtime validation:
`NOT_RUN`

Public privacy-policy/domain/app-ads.txt:
`NOT_READY`

W2 post-AdMob privacy/monetization audit:
`NOT_RUN`

## Final disposition

`S7_TEST_INTEGRATION_CODE_CI_PASS_PROVIDER_CONFIG_AND_RUNTIME_PENDING`

The code-integration scope is closed as PASS, but S7 as a full AdMob/privacy stage is not yet closed.
