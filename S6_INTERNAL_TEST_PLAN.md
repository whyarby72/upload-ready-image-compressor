# S6_INTERNAL_TEST_PLAN.md

## Objective
Prove that the Play-distributed core app is stable and that real users can complete the buyer job without the material failure modes identified in public competitor reviews.

S6 does not authorize AdMob, BUILD promotion, Artifact Freeze, release, or publication.

## Preconditions
- S5 declared-route artifact is signed and distributed through Google Play Internal Testing.
- Exact distributed versionCode/versionName and artifact identity are recorded.
- Canonical decision remains TEST.
- MARKET_REVIEW_INTELLIGENCE_v1.0 is current for this test cycle.

## Test population
Use non-sensitive JPEG sample photos only.
Capture device model, Android version, app version, source approximate bytes/dimensions, target selected, RESULT state, Save outcome, Share outcome, and confusion/recovery notes.
Do not ask testers to submit personal images.

## Required S6 Cases

### S6-01 — First-value completion
Tester can independently:
Choose photo -> understand CURRENT -> choose/enter REQUIRED -> process -> understand RESULT -> Save or Share.
Record material confusion and whether assistance was required.

### S6-02 — Verified PASS truth
For a known achievable target, displayed PASS must agree with actual output bytes <= REQUIRED.

### S6-03 — Honest NOT_MET
For an aggressive target that cannot safely be met, show NOT_MET; never false PASS or "upload ready".

### S6-04 — Unknown-limit truth
Unknown-limit path may produce REDUCED but never implies upload compatibility.

### S6-05 — Result-size sanity
When compression is required, flag any output unexpectedly larger than source.
Already-ready input must avoid unnecessary recompression.

### S6-06 — Save discoverability and retrieval
Save is visible after result.
Tester can locate/open the saved output without guessing obscure storage paths.
The saved file is the same result artifact represented by the UI.

### S6-07 — Share discoverability and correctness
Share is visible after result and shares the actual readable result artifact, not the original/wrong/stale file.

### S6-08 — Progress and recovery
Inspect/compress/save operations show understandable progress.
No silent indefinite wait.
Picker cancel, invalid/unsupported input, and recoverable processing failure return the user to a usable state.

### S6-09 — Quality/orientation acceptance
No silent orientation or obvious color corruption.
Tester records whether output quality remains usable for the upload job.
Quality guard must win over a false target-success claim.

### S6-10 — Original preservation
Source remains unchanged after PASS, NOT_MET, REDUCED, Save, and Share paths.

### S6-11 — Offline/privacy behavior
Core flow works with network unavailable after app installation.
No unexpected INTERNET/broad-storage permission or image transmission behavior is observed.

### S6-12 — Crash/ANR stability
No repeatable crash/ANR on the core flow across the declared internal-test device set.
Any crash/ANR on the buyer job is BLOCKING until fixed/retested.

### S6-13 — Compatibility
Exercise at least one supported older Android environment and one current environment through the distributed/internal-test route where practical; record exact devices/versions.

### S6-14 — Basic readability/accessibility
Core actions and result truth remain understandable at larger system text size.
Buttons/actions remain reachable; important state is not communicated only by color.

### S6-15 — First-value monetization baseline
For this pre-AdMob build there must be no ad/paywall/subscription interruption in the core path.
This case becomes a mandatory regression test again at S7/S8 after monetization is introduced.

### S6-16 — Error/support-surface check
Error text explains what happened sufficiently for self-service recovery.
Tester should not need developer intervention for ordinary invalid input or retryable failure.

## Severity / Gate Rules

BLOCK S7 immediately for:
- false PASS;
- source overwrite/corruption;
- saved/shared artifact mismatch;
- Save claims success but file cannot be retrieved;
- repeated crash/ANR in core flow;
- silent/indefinite processing with no recovery;
- severe orientation/color corruption;
- unexpected network dependency for the core job;
- any monetization/prompt blocking first verified value.

Also BLOCK when recurring UX confusion prevents independent completion of the buyer job, even if the underlying code technically works.

Non-blocking cosmetic issues may be deferred only when they do not impair comprehension, trust, completion, or accessibility.

## Evidence
For every S6 case record:
- distributed app version;
- device/Android version;
- fixture identifier or non-sensitive sample description;
- expected;
- observed;
- PASS / FAIL / BLOCKED;
- screenshot/log/artifact path where appropriate;
- defect ID and retest evidence when repaired.

## Exit
S6_INTERNAL_TEST_PASS only when the core app is stable in real internal testing and no material core defect remains open.

Do not move to S7 monetization while material core defects remain open.
