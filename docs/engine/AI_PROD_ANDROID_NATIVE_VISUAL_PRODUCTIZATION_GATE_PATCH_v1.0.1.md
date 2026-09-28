# AI-PROD ANDROID NATIVE VISUAL PRODUCTIZATION GATE PATCH v1.0.1

Status: PROJECT-RUNTIME CORRECTIVE / PROMOTION CANDIDATE
Supersedes: v1.0.0 for current project runtime
Observed: 2026-09-29
Parent runtime: PRIMARY_RUNTIME_ENGINE v5.16.25

## Delta from v1.0.0

v1.0.1 adds deterministic screenshot semantic binding after repeated evidence mislabeling showed that filename + manifest prose + manual claim are insufficient.

All v1.0.0 controls remain active.

## Screenshot Semantic Binding Guard

For every screenshot used to satisfy a named acceptance state, bind all three at capture time:

```yaml
android_screenshot_semantic_binding:
  screenshot_path: ""
  screenshot_sha256: ""
  foreground_package:
    expected: ""
    observed: ""
    evidence_path: ""
    status: PASS | HOLD
  ui_hierarchy:
    evidence_path: ""
    required_anchors: []
    forbidden_anchors: []
    status: PASS | HOLD
  fixture_or_state_precondition: ""
  semantic_label: ""
  result: PASS | HOLD
```

Rules:

1. A screenshot filename is not evidence of its semantic state.
2. Manifest prose is not evidence of visible content.
3. Before screenshot capture, verify foreground package with `dumpsys window` or equivalent.
4. Capture a UI hierarchy from the same state/session where practical.
5. Required visible text/semantic anchors must exist in the hierarchy.
6. Forbidden state anchors must be absent where material.
7. If the foreground package or hierarchy does not match, do not save/accept the screenshot as PASS.
8. Splash screen, Android launcher/home screen, system picker, sharesheet, and app runtime must be distinguished explicitly.
9. A screenshot that is visually plausible but semantically unbound is `HOLD`.
10. Direct CHAT/HUMAN visual review remains required when premium taste is material, but deterministic semantic binding must pass first.

## Minimum examples

### Home runtime
Required:
- foreground package = app package;
- `Reduce Photo Size`;
- `Fit your photo to an upload limit.`;
- `Choose photo`.

Forbidden:
- Android launcher/home as foreground.

### PASS result
Required:
- `MEETS LIMIT`;
- exact `≤` or equivalent PASS proof.

Forbidden:
- `TARGET NOT MET`;
- `NOT_MET`.

### NOT_MET result
Required:
- `TARGET NOT MET`;
- exact `>` proof.

### REDUCED result
Required:
- `SMALLER COPY`;
- no PASS claim.

## Repeated-failure escalation

If the same screenshot-semantic defect recurs after one repair instruction:
- stop relying on manual inspection claims from the executor;
- require persisted foreground-package evidence and UI hierarchy evidence;
- keep the human quality gate closed until deterministic binding is independently reconciled.

## Stage binding

At Android S5, an activated visual-productization screen set cannot be marked machine-complete unless every required screenshot row has:
- screenshot hash;
- foreground-package PASS;
- semantic-anchor PASS;
- exact source/artifact binding.

This patch does not add release/publication authority.
