# S5-005 FINAL DIRECT VISUAL REVIEW v1.0

Observed: 2026-09-28
Reviewer: CHAT
Direct review package:
`S5_005_FINAL_RECAP_VISUAL_REVIEW.zip`
ZIP SHA-256:
`d823428ae2b77b446125f14e0d5b64f415b29bf8217c738082e5155b494d85b2`

Repository source under review:
`5c586048860c221bf36ccba9fb5f8f3955d7fbb2`

Disposition:
`PASS_ALL_REVIEWED_STATES_EXCEPT_NOT_MET_COPY_FIDELITY`

## 1. Package integrity

PASS.

Directly recomputed uploaded PNG hashes match the semantic sidecar and repository evidence index for all reviewed files.

## 2. Requirement — 360x800

PASS.

Direct observations:
- one-line product identity;
- compact current-photo context;
- all six target choices visible;
- selected 100 KB has check;
- Required ≤ 100 KB visible;
- Continue visible;
- unknown-limit action remains low emphasis;
- Warm Ink hierarchy is calm and coherent.

## 3. Requirement — 320x640

PASS.

Previously observed defects are fixed:
- `Custom` renders fully;
- selected `100 KB` renders fully with check;
- all six options visible;
- summary and Continue visible.

No critical clipping.

## 4. Requirement — font scale 1.3x

PASS.

- all target labels remain complete;
- selected state is legible;
- Continue remains visible;
- typography remains controlled.

## 5. Processing

PASS_WITH_MINOR_POLISH.

- actual media preview is dominant;
- active indeterminate state is semantically correct;
- `Compressing…` and `Original untouched` are clear;
- duplicate On-device body copy is gone.

The small progress arc can appear visually minimal in a static frame, but this is not a blocker.

## 6. PASS result

PASS.

360x800:
- actual result preview is dominant;
- `MEETS LIMIT` is restrained;
- `80 KB` remains one line;
- exact proof is secondary and readable;
- before/result comparison is visible.

320x640:
- `80 KB` remains one line;
- primary result hierarchy survives narrow width;
- lower content naturally continues by scroll.

1.3x:
- `80 KB` remains one line;
- exact proof remains readable;
- no material clipping.

## 7. REDUCED result

PASS.

360x800:
- `SMALLER COPY` is neutral, not success-green;
- result size remains one line;
- `No upload limit entered — no PASS claim` is explicit;
- visual hierarchy is coherent.

320x640:
- same truth hierarchy survives narrow width;
- lower content is scrollable.

1.3x:
- body proof wraps intentionally and remains readable;
- result size remains one line.

## 8. NOT_MET result

`HOLD_NARROW_COPY_FIDELITY`

What passes:
- `TARGET NOT MET` warning treatment is restrained;
- actual size `77 KB` is one line;
- exact proof `76,867 bytes > 50,000 bytes — NOT_MET` is truthful;
- media comparison is visible.

Blocking documented fidelity defect:

The frozen Warm Ink system explicitly requires one guidance line:

`Try a higher limit or a different photo.`

The current runtime screenshot does not show that guidance because the current source does not implement it.

The Compose implementation brief also requires the same guidance.

Additionally, the frozen result-action contract requires NOT_MET to use:

`Save current copy`

if a result file exists.

Current source uses unconditional:

`Save copy`

for PASS, REDUCED and NOT_MET.

This distinction matters because NOT_MET is not upload-compliant; `Save current copy` avoids implying that the saved artifact met the requested limit.

## 9. Final visual gate

Requirement:
PASS

Processing:
PASS_WITH_MINOR_POLISH

PASS result:
PASS

REDUCED result:
PASS

NOT_MET:
HOLD_NARROW_COPY_FIDELITY

Warm Ink design system:
PASS

No redesign is required.

## 10. Required final source correction

Presentation only:

1. For NOT_MET, add the exact guidance:
   `Try a higher limit or a different photo.`

2. For NOT_MET primary save action, use:
   `Save current copy`

3. PASS and REDUCED remain:
   `Save copy`

4. Preserve current exact-byte proof and all domain semantics.

## 11. Required visual proof after correction

Capture fresh:
- NOT_MET 360x800
- NOT_MET 320x640
- NOT_MET 1.3x
- NOT_MET scrolled action area showing `Save current copy`, Share and Compress another

Run a quick PASS/REDUCED semantic regression to confirm their save label remains `Save copy`.

No signing, Play upload, S6, BUILD promotion, Artifact Freeze, release or publication.
