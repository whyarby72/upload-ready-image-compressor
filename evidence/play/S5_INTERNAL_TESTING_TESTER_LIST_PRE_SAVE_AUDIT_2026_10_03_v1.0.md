# S5 Internal Testing Tester List Pre-Save Audit

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT

Evidence PDF SHA-256: 8fe4a52b74a7cc825a7f13ea5092b9d5943f617a2dbaf6a76537c93e92432bb2

Observed on Google Play Console Internal testing > Testers:
- track status: Inactive;
- draft release: 1 (0.1.0);
- setup progress: 1 of 3 complete;
- selected tester list name: emailaku;
- Users count shown for selected list: 2;
- Save button is available;
- join link is not yet available because the app has not been published to the internal track.

Authorized intended tester count for this scope: 1.

Disposition:
HOLD_TESTER_COUNT_MISMATCH_BEFORE_SAVE

Reason:
The selected email list contains 2 users, which exceeds the explicitly authorized one-tester scope.

No Save action is authorized until the list is reduced to exactly one intended tester or the human explicitly broadens the tester-count authorization.
