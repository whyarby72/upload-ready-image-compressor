# TASK-S5-006 Mockup → runtime fidelity matrix

Artifact/source binding: `d165d6b325258346b9f55c76b3dbbfc12aa1a538` / debug APK `3065ce39a568ad3644544c54cd0c7e244c04b005459a74a7deb2ad90bc1d739f`.

| Screen / buyer job | Required visual objects | Actual runtime objects | Intentional deltas | Missing / placeholder-like objects | Composition / signature | Status |
|---|---|---|---|---|---|---|
| Home — understand the job and first action | Brand mark, product name, trust cue, fit-to-limit hero, Choose photo CTA | Compression Frame Mark, Reduce Photo Size, On-device, two-frame fit/reduce vector, Choose photo | Local vector replaces literal mockup art; no baked text or fake numbers | None observed; generic `ic_photo` removed from identity/hero | Headline → designed hero → CTA; DISTINCT | PENDING_HUMAN_REVIEW |
| Requirement — identify photo and choose limit | Real selected photo, size/dimensions, compact target grid, explicit unknown route | Real photo card, metadata, six target chips, Continue, I don't know the limit | Requirement thumbnail remains Crop by contract | No decorative illustration | Media-first; DISTINCT shell | PENDING_HUMAN_REVIEW |
| Custom Limit — enter exact target | Numeric input, KB/MB choice, inline validation, Cancel/Use limit | Warm Ink dialog, segmented KB/MB, inline error path retained | No added illustration | None | Focused utility dialog | PENDING_HUMAN_REVIEW |
| Processing — see safe on-device work | Real source photo, indeterminate progress, original untouched | Real source Fit preview, indeterminate spinner, operation copy, Original untouched | No fabricated percentage/stages | None | Media-first; DISTINCT shell | PENDING_HUMAN_REVIEW |
| PASS — confirm exact limit result | Real result, status, size/proof, Before/After, Save/Share/actions | Real result Fit hero, MEETS LIMIT, exact bytes, Before/After, Save copy, Share, Compress another | Platform Compose spacing retained | None | Result media dominant; DISTINCT shell | PENDING_HUMAN_REVIEW |
| NOT_MET — explain safe stop and preserve output | Real result, warning, `>`, guidance, Save current copy/actions | Real result Fit hero, TARGET NOT MET, exact proof, frozen guidance, Save current copy | Calm factual warning retained | No failure illustration | Media-first; DISTINCT shell | PENDING_HUMAN_REVIEW |
| REDUCED — disclose no guarantee | Real result, neutral/info state, disclaimer, Before/After/actions | Real result Fit hero, SMALLER COPY, no-PASS disclaimer, Before/After/actions | Neutral semantics retained | No success-green claim | Media-first; DISTINCT shell | PENDING_HUMAN_REVIEW |

Machine evidence is complete. Premium taste/visual-quality approval is intentionally not self-declared.
