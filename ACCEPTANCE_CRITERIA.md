# ACCEPTANCE_CRITERIA.md

## Scope
These criteria authorize only a bounded S3 functional-vertical-slice technical proof under canonical decision `TEST`.
They do not authorize canonical `BUILD`, AdMob integration, Artifact Freeze, release, or publication.

- **AC-S3-01 Factory/repo:** Codex runs `python scripts/bootstrap_repo.py --create-private-github --push`; canonical remote is verified `PRIVATE`, `main` / `develop` / `task/TASK-S3-001` are pushed without force, `evidence/build/REPO_BOOTSTRAP.json` records exact repo/commit/branch evidence, and `python scripts/preflight.py` => `PREFLIGHT_PASS`. If provider authentication is unavailable, record `AUTH_REQUIRED`; do not delegate routine Git commands to the human.
- **AC-S3-02 Toolchain:** record JDK 17, AGP 9.4.1, compatible Gradle 9.6.x, Android SDK/API 36; create Gradle Wrapper if absent.
- **AC-S3-03 Compile:** `./gradlew --no-daemon assembleDebug` PASS; record APK path/bytes/SHA-256.
- **AC-S3-04 Unit/static:** `testDebugUnitTest` + `lintDebug` PASS with no blocking failures; host QualitySearch test remains green.
- **AC-S3-05 Install/launch:** run on API 36 plus one representative supported older API (preferably API 29-35); record exact environment.
- **AC-S3-06 CURRENT detection:** after choose-photo, display actual source size and available dimensions/format.
- **AC-S3-07 Known-limit truth:** test 50/100/200/500 KB and 1 MB across fixtures; PASS only when re-read output bytes <= target.
- **AC-S3-08 NOT_MET truth:** bounded failure to hit known target yields NOT_MET, never false PASS.
- **AC-S3-09 Already-ready:** current <= target avoids unnecessary recompression and returns verified PASS.
- **AC-S3-10 Unknown-limit:** if exposed, result is REDUCED only; never PASS / UPLOAD READY.
- **AC-S3-11 Original preservation:** no tested path overwrites/corrupts source.
- **AC-S3-12 Save/share:** successful Save means real persistence; Share means real accessible output with scoped/read-only grant.
- **AC-S3-13 Orientation/metadata:** EXIF-orientation fixture has no silent visual corruption; metadata behavior is disclosed.
- **AC-S3-14 Large input:** completes or fails safely; no source corruption/runaway retry/false PASS.
- **AC-S3-15 Permission/privacy:** core requires no INTERNET or broad storage/media permission; no image content transmitted.
- **AC-S3-16 Evidence integrity:** update test rows and regenerate evidence index + handoff.

## S3 Exit
S3 is technically proven only when blocking criteria have artifact-bound, environment-bound evidence.
S3 proof does not change canonical decision `TEST`; behavioral testing remains required before BUILD consideration.
