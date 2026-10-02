# S5 PLAY INTERNAL TESTING UPLOAD SCOPE — PROVIDER AUDIT — 2026-10-03

Product: PHOTO COMPRESSOR: KB LIMIT
Package: `com.afradadmedia.reducephotosize`

## Trigger

Human selected the prior recommended continuation:
restore the preserved local stash, verify the two local items are intact, then prepare a separate Play Internal Testing upload scope without tester mutation or rollout.

## Current official provider flow

Current Google Play Console Help documents Internal testing as a testing **release** flow.

Official provider path:
`Test and release > Testing > Internal testing > Create new release`.

Google defines a release as the container in which one or more Android App Bundles are prepared for a testing track or production.

Therefore a literal scope:
`AAB UPLOAD ONLY / NO RELEASE CREATION`
is not provider-compatible for the Internal testing track.

Uploading the signed AAB to the Internal testing track requires entering a release draft.

Sources checked 2026-10-03:
- https://support.google.com/googleplay/android-developer/answer/9845334
- https://support.google.com/googleplay/android-developer/answer/9859348

## Least-authority corrected scope

Recommended next scope:

`S5 PLAY INTERNAL TESTING RELEASE-DRAFT + AAB UPLOAD ONLY`

Permitted:
- open `Test and release > Testing > Internal testing`;
- enter `Create new release` only as required to reach the bundle uploader;
- upload exactly the locally signed artifact:
  `PhotoCompressor-0.1.0-vc1-upload-signed.aab`;
- observe provider acceptance/rejection;
- capture the registered upload-key certificate state if surfaced;
- capture bundle/version/package validation results;
- leave the release in draft state.

Mandatory hard stop:
`STOP_AFTER_AAB_PROVIDER_VALIDATION_IN_DRAFT_BEFORE_TESTERS_SAVE_REVIEW_OR_ROLLOUT`

Not authorized:
- adding or changing testers;
- saving tester lists;
- completing release notes unless technically mandatory for validation;
- review release / start rollout / publish;
- production/closed/open testing;
- S6;
- BUILD promotion;
- Artifact Freeze;
- publication.

## Local prerequisite

Before any provider mutation:
1. restore the preserved stash with `git stash apply stash@{0}`;
2. verify both preserved local items return intact;
3. only after verification, drop the stash copy if desired.

This local cleanup does not alter the signed AAB already produced outside the repository.

## Disposition

`PROVIDER_FLOW_CONFLICT_RESOLVED_SCOPE_REQUIRES_DRAFT_RELEASE`

No Play provider mutation is authorized by this audit.
