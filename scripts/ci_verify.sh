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
./gradlew --no-daemon testDebugUnitTest
./gradlew --no-daemon lintDebug
python scripts/build_evidence_index.py
python scripts/render_handoff.py
echo CI_VERIFY_PASS
