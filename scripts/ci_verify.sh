#!/usr/bin/env bash
set -euo pipefail
python scripts/preflight.py
if [ ! -f ./gradlew ]; then
  echo 'CI_PARTIAL: gradlew not present; repo contract PASS, Android build skipped.'
  python scripts/build_evidence_index.py
  python scripts/render_handoff.py
  exit 0
fi
chmod +x ./gradlew
./gradlew --no-daemon assembleDebug
./gradlew --no-daemon assembleRelease
./gradlew --no-daemon testDebugUnitTest
./gradlew --no-daemon lintDebug

# W2 artifact-bound privacy / Data Safety audit inputs.
mkdir -p build/w2-audit
./gradlew --no-daemon :app:dependencies --configuration releaseRuntimeClasspath > build/w2-audit/releaseRuntimeClasspath.txt
python scripts/w2_artifact_audit.py

python scripts/build_evidence_index.py
python scripts/render_handoff.py
echo CI_VERIFY_PASS
