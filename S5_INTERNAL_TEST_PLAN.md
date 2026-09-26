# S5_INTERNAL_TEST_PLAN.md

## Objective
Prepare and verify an installable/distributable build for Google Play Internal Testing without changing canonical decision TEST.

## Buyer-job test focus
A tester must be able to:
1. choose a JPEG;
2. see CURRENT file facts;
3. enter/select the website limit;
4. produce a real result;
5. distinguish PASS vs NOT_MET vs REDUCED correctly;
6. Save and Share;
7. confirm original remains untouched.

## Pre-distribution technical checks
- preflight PASS
- assembleDebug PASS
- unit PASS
- lint PASS
- bundle preparation PASS or exact signing/account blocker
- package/version identity recorded
- artifact SHA-256 recorded
- no INTERNET/broad-storage permission regression
- no AdMob/analytics added

## Internal tester instructions
Ask testers to report only:
- device + Android version;
- source JPEG approximate size;
- target limit used;
- whether RESULT matched the shown target status;
- Save outcome;
- Share outcome;
- confusion/error encountered;
- screenshot only when comfortable sharing it.

Do not request personal/sensitive images. Testers should use non-sensitive sample photos.

## Feedback categories
- BLOCKER: cannot install/open/complete core job
- TRUTH_DEFECT: PASS/NOT_MET/REDUCED claim is wrong
- DATA_SAFETY: original changed/lost or unexpected permission/network behavior
- FUNCTIONAL: Save/Share/picker/compression defect
- UX: unclear wording/flow that materially affects completion
- COSMETIC: non-blocking presentation issue

## Exit
S5_INTERNAL_TEST_READY when a real declared-route test artifact is prepared and all remaining account/signing/upload actions are explicitly assigned to the human.
