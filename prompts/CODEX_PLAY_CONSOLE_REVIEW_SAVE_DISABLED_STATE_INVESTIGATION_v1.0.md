# CODEX — PLAY CONSOLE REVIEW SAVE-DISABLED STATE INVESTIGATION v1.0

Product: `Photo Compressor: KB Limit`
Package: `com.afradadmedia.reducephotosize`
Repository: `whyarby72/upload-ready-image-compressor`
Canonical branch: `task/TASK-S7-001`

## Current observed state

Review step:
`AI asset declaration`

AI labeling state observed before blocker:
- App icon selected/labeled;
- Feature graphic selected/labeled;
- all 4 Phone screenshots selected/labeled.

Prior dialog action:
`Label assets and submit`

Current Review controls:
- `Save as draft` visible but disabled;
- `Save` visible;
- no listing-level persistence control was clicked after the AI labeling dialog.

Last disposition:
`BLOCKED_REVIEW_SAVE_AS_DRAFT_SCHEMA_DRIFT`

## Mission

Determine, READ-ONLY, why `Save as draft` is disabled and whether the AI labeling dialog itself already persisted the declaration.

Do not assume that disabled means failure. Reconcile the actual provider state.

## Scope

READ-ONLY ONLY.

Do NOT:
- change any field or selection;
- open/change AI asset category selections;
- click `Save`;
- click `Save as draft`;
- click `Send app for review`;
- edit store listing text/media;
- create/edit releases or tracks;
- publish/roll out.

## Required investigation

### 1. Reload persistence check

Reload/re-open the Main store listing Review step without editing anything.

Record:
- whether `AI asset declaration` remains selected;
- whether App icon remains labeled;
- whether Feature graphic remains labeled;
- whether all 4 Phone screenshots remain labeled;
- whether the Review step reopens directly or must be reached via `Next`.

If labels survive a clean reload, mark:
`AI_LABEL_STATE_DURABLY_PERSISTED`

If labels disappear after reload, mark:
`AI_LABEL_STATE_NOT_PERSISTED`

### 2. Dashboard check

Open Dashboard read-only.

Record exact completion count:
- `10 of 11 complete`
- `11 of 11 complete`
- other exact wording

Record whether `Set up your store listing` has a check.

### 3. Publishing overview check

Open Publishing overview read-only.

Record exact pending change groups.

Specifically determine whether a new or changed item corresponding to:
- Main store listing;
- AI asset declaration;
- store listing review;
appears after the prior `Label assets and submit` action.

Record `Send app for review` enabled/disabled.

### 4. Review control-state check

Return to Review step read-only.

Record:
- `Save as draft`: enabled/disabled;
- `Save`: enabled/disabled;
- any visible validation message, warning, required-field message, or incomplete indicator;
- any provider wording explaining why save is disabled.

Do NOT click either control.

### 5. Determine the most likely provider-state semantics

Classify exactly one:

A. `NO_UNSAVED_CHANGES_AI_DIALOG_ALREADY_PERSISTED`
- labels survive reload;
- Dashboard/Publishing overview shows resulting state;
- disabled Save as draft is consistent with no dirty changes.

B. `REVIEW_HAS_UNSAVED_STATE_BUT_DRAFT_CONTROL_DISABLED`
- labels do not survive reload or other state indicates unsaved work;
- provider presents a separate persistence path.

C. `VALIDATION_BLOCKS_SAVE_AS_DRAFT`
- visible validation/incomplete requirement prevents save.

D. `PROVIDER_UI_STATE_AMBIGUOUS`
- evidence does not resolve why control is disabled.

### 6. Next action

Return ONE recommended next action only.
Do not execute it.

## Evidence

If repo workspace is available, create:

`evidence/play/W2_REVIEW_SAVE_DISABLED_STATE_INVESTIGATION_2026_10_06_v1.0.md`

Include:
- terminal disposition;
- canonical HEAD;
- reload persistence result;
- Dashboard completion count;
- Publishing overview pending groups;
- `Send app for review` state;
- exact Save / Save-as-draft enabled states;
- validation/warning text;
- provider-state classification;
- next one action;
- confirmation zero provider mutation.

Commit only the evidence report.

## Allowed terminal dispositions

- `PASS_REVIEW_SAVE_DISABLED_STATE_RECONCILED`
- `PARTIAL_REVIEW_SAVE_DISABLED_STATE_AMBIGUOUS`
- `HOLD_REVIEW_SAVE_DISABLED_VALIDATION_BLOCK`
- `BLOCKED_WRONG_PROVIDER_CONTEXT`
- `BLOCKED_PROVIDER_AUTH_REQUIRED`
- `BLOCKED_PROVIDER_UI_ERROR`

## Final response

Return:
1. disposition;
2. reload persistence result;
3. Dashboard completion count;
4. Publishing overview pending groups;
5. `Send app for review` enabled/disabled;
6. Save and Save-as-draft enabled states;
7. any validation/warning text;
8. provider-state classification;
9. next ONE action only;
10. confirmation zero provider mutation;
11. evidence commit SHA if available.
