# Repository Bootstrap Contract — v1.0.1

## Purpose
Make repository setup a Codex-owned engineering operation instead of a recurring human handoff.

## Required state
`PROJECT_STATE.json.repository` is the Source-of-Truth for bootstrap status.

Default policy:
- provider: `GITHUB`
- visibility_required: `PRIVATE`
- local Git bootstrap: autonomous/reversible engineering work
- remote creation: requires explicit `remote_creation_authorized=true`
- remote delete/transfer/public visibility: never authorized by this bootstrap capability

## Normal path
```text
Factory product workspace
→ Codex local git init/validation
→ initial product commit
→ develop branch
→ task/<task-id>
→ [if authorized] authenticated private GitHub remote create/connect
→ push main/develop/task branch
→ verify remote visibility PRIVATE
→ write evidence/build/REPO_BOOTSTRAP.json
→ update PROJECT_STATE.json
```

## Human interruption boundary
Human involvement is limited to account/provider authorization when credentials are not already available, or to higher-authority actions outside this contract.

Do not ask the human to run `git init`, create branches, stage ordinary files, create routine commits, or push ordinary engineering changes when Codex has the required environment/credentials.

## Fail-safe states
- `READY_LOCAL`: local Git/branches ready; no remote required or authorized yet.
- `READY_REMOTE`: authenticated private remote exists and required branches are pushed.
- `AUTH_REQUIRED`: remote creation/push was authorized but provider authentication is unavailable.
- `IDENTITY_REQUIRED`: no Git commit identity is configured; do not fabricate one.
- `HOLD`: repository state conflicts materially with policy (for example public visibility when private is required, ambiguous/mismatched origin, or destructive action required).

## Security
Never write credentials/tokens to repository evidence. Evidence may record provider, remote URL, visibility, commit SHA, branch names, and command result classes only.
