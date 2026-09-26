# Branch Policy

- `main`: production truth / accepted baseline only.
- `develop`: integrated next candidate.
- `task/<task-id>`: one Codex engineering task.
- `release/<version>`: frozen release candidate.

## Bootstrap
1. Codex initializes local Git when absent.
2. Initial product bootstrap commit is created only with a valid configured Git identity; identity is never fabricated.
3. `develop` is created from the initial baseline.
4. Codex normally works on `task/<task-id>` created from `develop`.
5. A private GitHub remote may be created/connected only when `repository.remote_creation_authorized=true` and authenticated provider access is available.
6. Missing provider auth is `AUTH_REQUIRED`, not a reason to make the human execute routine Git commands.

## Ongoing rules
1. One task branch maps to one CURRENT_TASK scope.
2. Merge into develop only after acceptance evidence exists.
3. Release branch is created only near production-readiness PASS.
4. Production artifact maps to exact commit/tag/hash.
5. Artifact Freeze applies to exact bytes/commit, never a moving branch.
6. Any artifact/hash change invalidates publication approval.
7. Factory automation may not make a repo public, delete/transfer it, mutate billing, or rewrite shared history without separate explicit authority.
