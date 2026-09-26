# CODEX START — UPLOAD-READY IMAGE COMPRESSOR — FACTORY v1.0.1

Execute `TASK-S3-001`. Treat `AGENTS.md` as mandatory.

Read in order:
1. `PROJECT_STATE.json`
2. `CURRENT_TASK.md`
3. `PRODUCT_SPEC.md`
4. `ACCEPTANCE_CRITERIA.md`
5. `TEST_MATRIX.csv`
6. `FACTORY_BINDING.json`
7. `docs/REPO_BOOTSTRAP.md`
8. `AGENTS.md`

## Repository bootstrap — Codex owned
Before ordinary engineering, establish the canonical private repository:

```bash
python scripts/bootstrap_repo.py --create-private-github --push --repo-name upload-ready-image-compressor
```

The current task contains explicit authorization for creation of this **private** GitHub repository. The authorization does not permit public visibility, remote deletion/transfer, billing changes, force-push, signing/release, or publication.

If provider credentials are not available, record `AUTH_REQUIRED` and request only the necessary GitHub/account authorization. Do **not** ask the human to run `git init`, create branches, commit routine files, or push routine engineering changes. Continue safe local preparation where practical.

Required repository evidence:
- local Git state;
- verified private remote metadata;
- remote URL;
- exact baseline/task commit SHA;
- `main`, `develop`, `task/TASK-S3-001` branch state;
- `evidence/build/REPO_BOOTSTRAP.json`;
- updated `PROJECT_STATE.json`.

## S3 mission
Produce real, replayable Android technical evidence for the existing vertical slice. Do not expand scope and do not integrate AdMob.

After repository bootstrap:
1. Run `python scripts/preflight.py`.
2. Record exact JDK, Gradle, Android SDK, build-tools, emulator/device identities.
3. Inspect the existing Gradle files.
4. If Gradle Wrapper is absent, create one compatible with the existing AGP 9.4.1 baseline using the real environment; record exact toolchain evidence.
5. Run `./gradlew --no-daemon assembleDebug`.
6. Run `./gradlew --no-daemon testDebugUnitTest`.
7. Run `./gradlew --no-daemon lintDebug`.
8. Repair ordinary deterministic failures autonomously at the smallest responsible layer.
9. Install/run and execute the blocking test matrix on real Android environment(s).
10. Record logs/screenshots/artifact hashes under `/evidence`.
11. Update `PROJECT_STATE.json`, `TEST_MATRIX.csv`, `DECISIONS.md`, `CHANGELOG.md`.
12. Run `python scripts/build_evidence_index.py`.
13. Run `python scripts/render_handoff.py`.
14. Commit and push engineering/evidence changes when remote access is available and authorized.

## Hard invariants
- Known REQUIRED limit: PASS only when actual re-read output bytes <= REQUIRED.
- Unknown limit: `REDUCED` only; never PASS / UPLOAD READY.
- Never overwrite original.
- Never infer Android/device PASS from source inspection or CI configuration.
- No production AdMob/UMP/analytics in this task.
- No canonical BUILD promotion, Artifact Freeze, signing, release, or publication.
- No public Git repository.
- No fabricated Git identity or credentials.

## Completion
Return exact repository URL/visibility, commit SHAs, commands, environment identities, build/test/lint results, APK path+SHA-256 if produced, device matrix, acceptance dispositions, blockers, changed files, evidence paths, and updated `HANDOFF_CURRENT.md`. Canonical decision remains `TEST`.
