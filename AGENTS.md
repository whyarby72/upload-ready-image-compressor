# AGENTS.md

## Read order
1. PROJECT_STATE.json
2. CURRENT_TASK.md
3. PRODUCT_SPEC.md
4. ACCEPTANCE_CRITERIA.md
5. TEST_MATRIX.csv

PRODUCT_SPEC and ACCEPTANCE_CRITERIA define buyer-facing truth. CURRENT_TASK defines active engineering scope.

## Hard rules
- Do not expand product scope merely to make implementation easier.
- Verified success claims require actual verification.
- Unknown external constraints cannot inherit verified-success claims.
- Preserve original user data unless the product spec explicitly says otherwise.
- Core buyer job must remain usable when ads fail unless ads/network are inherently required.
- Do not send sensitive buyer content to ads/analytics unless explicitly required, minimized, approved, and disclosed.
- Prefer scoped Android APIs/permissions.
- Never manufacture steps merely to create ad inventory.


## Repository lifecycle
- Codex owns routine local Git bootstrap, branch setup, commit preparation, and push operations for engineering tasks.
- The canonical repository must remain private unless a separate explicit authority changes that requirement.
- Remote repository creation requires `repository.remote_creation_authorized=true` plus valid provider credentials. Never infer this authorization from credential presence alone.
- If Git/GitHub credentials are absent, stop only the remote step as `AUTH_REQUIRED`; continue safe local preparation where possible.
- Never invent Git identity, tokens, owners, organizations, remotes, or credentials.
- Never commit secrets, keystores, signing material, service-account credentials, or auth tokens.
- Never delete a remote repository, change it to public, transfer ownership, mutate billing, or rewrite shared history without separate explicit authority.
- Codex normally works on `task/<task-id>` and records commit/remote evidence when material.

## Autonomous repair
Do not ask the human about ordinary compiler errors, imports, deterministic test failures, lint, routine dependency conflicts, or non-material refactors.

Loop: failure -> classify -> fix smallest responsible layer -> rerun smallest proving test -> regression -> evidence.

## Escalate only when
- material product scope must change;
- buyer-facing claim must materially change or weaken;
- new material permission/privacy/security behavior is required;
- destructive migration/account action is proposed;
- signing/account identity is required;
- production publication/release authority is required;
- required environment cannot be configured safely.

## Before completing a task
1. `python scripts/preflight.py`
2. build
3. relevant tests
4. repair failures
5. regression
6. lint/static checks
7. update TEST_MATRIX.csv
8. update PROJECT_STATE.json
9. `python scripts/build_evidence_index.py`
10. `python scripts/render_handoff.py`

Never claim PASS when required environment evidence did not run.
