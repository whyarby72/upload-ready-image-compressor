# Photo Compressor: KB Limit — Product Truth Audit

Date: 2026-10-04
Audit scope: privacy-policy / support / app-ads.txt preparation
Source repository: `whyarby72/upload-ready-image-compressor`
Source branch audited: `task/TASK-S7-001`
Source branch head observed: `baf63bbc9c793b135796cc70de61013bccd26fca`
AdMob test integration commit: `49829356e02c41357db9bce64463ddead1d1d1f4`

## Verdict

`PASS_FOR_PRIVACY_POLICY_DRAFT / HOLD_FOR_FINAL_AD_ENABLED_DISCLOSURE`

The app has enough source/provider truth to draft a real public privacy policy URL now, but the final ad-enabled disclosure must still be reconciled against the exact production-bound AdMob identifiers, resolved dependencies, merged release manifest, and W2 runtime evidence.

Do not publish a policy claiming "no network", "no ads SDK", or "no third-party data handling" as a timeless app-wide statement.

## Evidence classes

- FACT_SOURCE — direct application source / build configuration.
- FACT_PROVIDER — authenticated Google Play / AdMob provider evidence recorded in the repository.
- FACT_OFFICIAL — current official Google documentation rechecked on 2026-10-04.
- INFERENCE — reasoned conclusion that must not exceed the evidence.
- UNKNOWN — unresolved; do not claim.

## 1. Canonical product identity

FACT_SOURCE / FACT_PROVIDER:

- Public Play title: `Photo Compressor: KB Limit`.
- Launcher label: `Reduce Photo Size`.
- Android application ID: `com.afradadmedia.reducephotosize`.
- Current project decision: `TEST`.
- Current stage on S7 branch: `S7_ADMOB_PRIVACY_TEST_INTEGRATION`.
- Google Play app entry exists and is on the internal-testing path.
- Play provider app identifier recorded in project evidence: `4973120481844433940`.
- Real AdMob App ID captured from authenticated AdMob UI: `ca-app-pub-8084313520610270~1492953098`.
- AdMob app store details are currently unlinked because the Play listing is still private/internal.
- Real production Banner ad-unit ID is not recorded in the audited branch.
- Planned provider ad-unit name: `ResultScreen_Banner_v1`.

## 2. Current distributed vc1 vs S7 test branch

FACT_SOURCE / FACT_PROVIDER:

### Current distributed internal-testing vc1

The S5 internal-testing artifact was built before AdMob integration.

Repository disclosure records state:

- AdMob implementation: none.
- UMP: none.
- Analytics: none.
- Core image workflow: local/on-device.
- No explicit INTERNET permission in the pre-AdMob source manifest.

This truth is artifact-specific to the vc1 internal-testing build.

### S7 test-integration branch

The S7 branch now includes:

- GMA Next-Gen SDK `1.5.0`.
- UMP `4.0.0`.
- Google sample AdMob App ID.
- Google sample Banner ad-unit ID.
- Debug application ID suffix: `.s7test`.
- One test banner on the Result screen.
- No Firebase Analytics.
- No mediation.
- No interstitial.
- No app-open ad.
- No rewarded ad.
- No native ad.

The S7 branch is TEST integration, not production-ID binding.

## 3. Core photo data flow

FACT_SOURCE:

### Photo selection

- Android Photo Picker is used on newer Android versions.
- `ACTION_OPEN_DOCUMENT` is used on older supported versions.
- The app reads the selected JPEG through Android `ContentResolver`.
- The app reads display name, byte size, dimensions, MIME type, and EXIF orientation when available.

### Processing

- JPEG processing occurs on-device.
- Image pixels are decoded locally.
- Orientation is normalized locally before recompression when needed.
- Compression target logic runs locally.
- Result bytes are generated locally.
- PASS / NOT_MET truth is based on actual output bytes.

### Temporary result

- A generated result is stored in app cache at a result file under the app's cache directory.
- The share provider is non-exported and opens the result read-only.
- Share access is granted explicitly through an Android read URI grant.

### Save

- Save is user initiated.
- The generated JPEG is copied to Android MediaStore.
- The intended destination is the user's Pictures area.
- Save creates a separate output; it does not overwrite the source photo.

### Metadata

FACT_SOURCE:

- Recompressed copies are produced by Android bitmap JPEG encoding.
- The UI explicitly discloses that metadata is removed from compressed copies.
- Orientation is applied to pixels before re-encoding when EXIF orientation requires it.
- When the source already meets the requested limit, the source is copied instead of recompressed; therefore the "metadata removed" statement must not be generalized to every possible result without qualification.

## 4. Source photo transmission boundary

FACT_SOURCE:

No audited application-code path passes:

- source JPEG bytes;
- image filename;
- target KB/MB value;
- compression output byte count;
- before/after preview image data

to the Google Mobile Ads SDK, UMP, Firebase Analytics, a custom analytics endpoint, or a remote image-processing service.

The core image-processing job does not require a server.

Claim ceiling:

> "Photo compression is performed on your device. The app does not upload your selected photo to Afradad Media servers for compression."

Do NOT strengthen this to "the app sends no data over the internet" once an ad-enabled build is in scope.

## 5. AdMob / UMP integration truth

FACT_SOURCE:

The S7 test integration:

- requests UMP consent information on every app launch;
- loads/shows the required consent form when UMP requires it;
- gates ad eligibility on `canRequestAds()`;
- initializes GMA only after ad-request permission is available;
- disables Publisher first-party ID before test ad eligibility;
- exposes a visible "Privacy choices" action when UMP says privacy options are required;
- requests one Banner only on the Result screen;
- places that test banner after result proof and after Save / Share / Compress another;
- treats ad failure/no-fill as non-blocking.

FACT_SOURCE:

The current banner implementation uses an anchored-adaptive sizing API while ResultScreen is in a scrollable Compose flow.

Status:

`HOLD_BANNER_PLACEMENT_API_MISMATCH_REVIEW_REQUIRED_BEFORE_PRODUCTION_ID_BINDING`

The existing project plan already identifies inline-adaptive sizing as the likely pattern to review for scrollable content.

## 6. Google Ads SDK data-handling disclosure baseline

FACT_OFFICIAL, rechecked 2026-10-04:

Current Google documentation for GMA Next-Gen says the SDK automatically collects and shares these categories for advertising, analytics, and fraud-prevention purposes:

- IP address;
- user product interactions;
- diagnostic information;
- device/account identifiers.

Google states that this SDK data is encrypted in transit using TLS.

Source:
`https://developers.google.com/ad-manager/mobile-ads-sdk/android/next-gen/privacy/play-data-disclosure`

Privacy-policy consequence:

The public policy for an ad-enabled build must distinguish:

1. local photo content handled by app code; and
2. network data handled by Google advertising/consent SDKs.

It must not state "we do not collect/share any data" merely because photos remain local.

## 7. Permissions claim ceiling

FACT_SOURCE:

The app's own S7 source manifest does not explicitly declare broad photo/storage permissions.

UNKNOWN / FINAL-ARTIFACT REQUIRED:

Third-party SDK manifests can contribute permissions and components to the merged manifest. Therefore the final privacy/Data Safety statement must be based on the merged release manifest of the exact ad-enabled candidate, not the handwritten source manifest alone.

Do NOT reuse the pre-AdMob statement "no INTERNET permission" for the final ad-enabled artifact without merged-manifest evidence.

## 8. Analytics / mediation / identifiers

FACT_SOURCE:

- Firebase Analytics: absent from the audited S7 dependency/configuration path.
- Custom analytics: no audited implementation.
- Mediation: none in scope.
- Publisher first-party ID: explicitly disabled initially.
- Custom user ID / image-derived ad targeting: no audited implementation.
- Photo bytes are not intentionally supplied to the ads SDK by app code.

UNKNOWN:

Final provider-side ad serving, consent, limited-ads behavior, and exact identifier availability must be reconciled during W2 against the exact production-bound configuration.

## 9. Provider identity / AdMob state

FACT_PROVIDER:

- AdMob app name: `Photo Compressor: KB Limit`.
- Real AdMob App ID: `ca-app-pub-8084313520610270~1492953098`.
- AdMob app store details: currently unlinked.
- Provider package identity: not displayed / not yet linked.
- Source package identity remains `com.afradadmedia.reducephotosize`.
- App status observed: `Requires review`.
- European regulations message app selection reached a blocker because the privacy-policy URL is missing.
- Fallback consent collection remained OFF.

UNKNOWN / NOT YET EVIDENCED:

- production Banner ad-unit ID;
- published European regulations message;
- public Play-store linkage from AdMob;
- final app review/readiness state;
- personalized app-ads.txt snippet captured from AdMob.

## 10. app-ads.txt architecture

FACT_OFFICIAL, rechecked 2026-10-04:

AdMob crawls `app-ads.txt` based on the developer-website hostname in the app-store listing.

For a developer website such as:

`https://apps.afradadmedia.com/photo-compressor-kb-limit/`

the intended first-level-subdomain location is:

`https://apps.afradadmedia.com/app-ads.txt`

Source:
`https://support.google.com/admob/answer/9363762`

Current architecture therefore remains valid:

- app page: `https://apps.afradadmedia.com/photo-compressor-kb-limit/`
- privacy: `https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`
- support: `https://apps.afradadmedia.com/photo-compressor-kb-limit/support/`
- shared app-ads.txt: `https://apps.afradadmedia.com/app-ads.txt`

UNKNOWN:

The exact app-ads.txt line is not yet authorized from inference. Capture the personalized snippet from AdMob before publication.

## 11. Stale / conflicting repository truth found

### A. `store/PRIVACY_NOTES.md`

It says:

- AdMob not integrated;
- UMP not integrated;
- no network behavior.

That remains valid only for the pre-AdMob/current vc1 shipped artifact. It is stale if read as app-wide truth for the S7 branch.

Disposition:

`RELEASE_SCOPED_PROVENANCE_ONLY_FOR_VC1`

### B. `PROJECT_STATE.json`

The same state file records the real AdMob App ID:

`ca-app-pub-8084313520610270~1492953098`

but an older blocker still says the AdMob App ID does not exist.

Disposition:

`STALE_BLOCKER_CONFLICT_REQUIRES_STATE_RECONCILIATION`

The Banner ad-unit ID portion remains unresolved.

### C. European regulations message

Project state says the message is not yet created/configured and the privacy-policy URL is missing.

This matches the latest provider evidence.

Disposition:

`BLOCKED_ON_REAL_PUBLIC_PRIVACY_POLICY_URL`

## 12. Public privacy-policy truth contract

A draft policy may now be written, but it must preserve these invariants:

- developer/product identity;
- app title and package identity where useful;
- selected-photo processing is local/on-device;
- no Afradad Media server is used to upload/process the photo for compression;
- original photo is not overwritten by the normal workflow;
- Save and Share are explicit user actions;
- generated copies may remove image metadata when recompressed;
- ad-enabled versions may use Google Mobile Ads SDK;
- consent/privacy choices may use Google's UMP;
- Google ads SDK data handling must be disclosed at the evidence-supported category level;
- no Firebase Analytics/custom analytics claim unless later added;
- no mediation claim unless later added;
- contact method;
- retention/deletion semantics that match actual app behavior;
- policy-effective/update date;
- no claim that all network/data collection is absent once ads are enabled.

## 13. Required pre-publication evidence

Before the privacy page is treated as final for the first ad-enabled artifact:

1. resolve anchored-vs-inline adaptive banner implementation;
2. capture/verify the real Banner ad-unit ID;
3. bind production AdMob App ID/ad-unit ID only under separate authorization;
4. build the exact candidate;
5. inspect the merged release manifest;
6. inspect the resolved dependency graph;
7. run W2 consent/ad runtime validation;
8. reconcile Google Play Data Safety against the exact artifact;
9. capture the personalized app-ads.txt snippet;
10. verify the public privacy URL and support URL over HTTPS;
11. only then publish/activate the European regulations message under explicit approval.

## 14. Current decision

Privacy URL blocker can now move from "unknown product truth" to:

`READY_TO_DRAFT_REAL_PUBLIC_PRIVACY_POLICY_FROM_AUDITED_TRUTH`

Final ad-enabled compliance remains:

`HOLD_PENDING_EXACT_ARTIFACT_AND_W2_RECONCILIATION`
