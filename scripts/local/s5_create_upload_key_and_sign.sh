#!/usr/bin/env bash
set -euo pipefail
export LC_ALL=C

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$ROOT"

KEYSTORE_DIR="${S5_KEYSTORE_DIR:-$HOME/.android/upload-keys}"
KEYSTORE="${S5_UPLOAD_KEYSTORE:-$KEYSTORE_DIR/photo-compressor-upload.jks}"
ALIAS="${S5_UPLOAD_ALIAS:-photo-compressor-upload}"
OUT_DIR="${S5_SIGNED_OUTPUT_DIR:-$HOME/Downloads/photo-compressor-s5-signing}"
UNSIGNED_AAB="$ROOT/app/build/outputs/bundle/release/app-release.aab"

need() {
  command -v "$1" >/dev/null 2>&1 || {
    echo "ERROR: required command not found: $1" >&2
    exit 1
  }
}

need git
need java
need keytool
need jarsigner

if [[ ! -x "$ROOT/gradlew" ]]; then
  echo "ERROR: gradlew is not executable." >&2
  exit 1
fi

if [[ -e "$KEYSTORE" ]]; then
  echo "ERROR: refusing to overwrite existing keystore: $KEYSTORE" >&2
  echo "If this is the intended existing upload key, stop and request a separate reuse audit." >&2
  exit 1
fi

mkdir -p "$KEYSTORE_DIR" "$OUT_DIR"
chmod 700 "$KEYSTORE_DIR" 2>/dev/null || true

CURRENT_BRANCH="$(git rev-parse --abbrev-ref HEAD)"
if [[ "$CURRENT_BRANCH" != "task/TASK-S5-007" ]]; then
  echo "ERROR: expected branch task/TASK-S5-007, found: $CURRENT_BRANCH" >&2
  exit 1
fi

if [[ -n "$(git status --porcelain)" ]]; then
  echo "ERROR: working tree is not clean. Commit/stash unrelated local changes before signing." >&2
  exit 1
fi

if grep -q "signingConfig" app/build.gradle; then
  echo "ERROR: repository release build unexpectedly contains a signingConfig. Stop for audit." >&2
  exit 1
fi

SOURCE_COMMIT="$(git rev-parse HEAD)"
VERSION_NAME="$(awk -F"'" '/versionName / {print $2; exit}' app/build.gradle)"
VERSION_CODE="$(awk '/versionCode / {print $2; exit}' app/build.gradle)"

if [[ -z "$VERSION_NAME" || -z "$VERSION_CODE" ]]; then
  echo "ERROR: could not read versionName/versionCode from app/build.gradle" >&2
  exit 1
fi

if [[ "$VERSION_NAME" != "0.1.0" || "$VERSION_CODE" != "1" ]]; then
  echo "ERROR: authorized first signing scope expects versionName 0.1.0 / versionCode 1." >&2
  echo "Observed: versionName=$VERSION_NAME versionCode=$VERSION_CODE" >&2
  exit 1
fi

echo "== S5 local upload-key creation =="
echo "Keystore path: $KEYSTORE"
echo "Alias: $ALIAS"
echo "Secrets will be entered interactively and are not written by this script."
echo

keytool -genkeypair -v   -keystore "$KEYSTORE"   -storetype PKCS12   -alias "$ALIAS"   -keyalg RSA   -keysize 4096   -validity 10000   -dname "CN=Photo Compressor Upload Key, OU=Android Upload"

chmod 600 "$KEYSTORE" 2>/dev/null || true

echo
echo "== Fresh release bundle =="
./gradlew clean bundleRelease

if [[ ! -f "$UNSIGNED_AAB" ]]; then
  echo "ERROR: bundleRelease completed but AAB not found: $UNSIGNED_AAB" >&2
  exit 1
fi

SIGNED_AAB="$OUT_DIR/PhotoCompressor-${VERSION_NAME}-vc${VERSION_CODE}-upload-signed.aab"
cp "$UNSIGNED_AAB" "$SIGNED_AAB"

echo
echo "== Local AAB signing =="
jarsigner   -verbose   -sigalg SHA256withRSA   -digestalg SHA-256   -keystore "$KEYSTORE"   "$SIGNED_AAB"   "$ALIAS"

echo
echo "== Signature verification =="
VERIFY_LOG="$OUT_DIR/jarsigner-verify.txt"
jarsigner -verify -verbose -certs "$SIGNED_AAB" | tee "$VERIFY_LOG"

if ! grep -qi "jar verified" "$VERIFY_LOG"; then
  echo "ERROR: jarsigner verification did not report 'jar verified'." >&2
  exit 1
fi

hash_file() {
  if command -v shasum >/dev/null 2>&1; then
    shasum -a 256 "$1" | awk '{print $1}'
  elif command -v sha256sum >/dev/null 2>&1; then
    sha256sum "$1" | awk '{print $1}'
  else
    echo "ERROR: neither shasum nor sha256sum is available." >&2
    exit 1
  fi
}

UNSIGNED_SHA256="$(hash_file "$UNSIGNED_AAB")"
SIGNED_SHA256="$(hash_file "$SIGNED_AAB")"
SIGNED_BYTES="$(wc -c < "$SIGNED_AAB" | tr -d ' ')"

CERT_INFO="$OUT_DIR/upload-certificate-public.txt"
keytool -printcert -jarfile "$SIGNED_AAB" | tee "$CERT_INFO" >/dev/null
UPLOAD_CERT_SHA256="$(awk -F'SHA256: ' '/SHA256:/{print $2; exit}' "$CERT_INFO" | xargs)"

if [[ -z "$UPLOAD_CERT_SHA256" ]]; then
  echo "ERROR: could not extract public upload-certificate SHA-256 fingerprint." >&2
  exit 1
fi

RESULT_JSON="$OUT_DIR/S5_LOCAL_SIGNING_RESULT.json"
cat > "$RESULT_JSON" <<JSON
{
  "schema": "S5_LOCAL_SIGNING_RESULT_v1.0",
  "product": "PHOTO COMPRESSOR: KB LIMIT",
  "package": "com.afradadmedia.reducephotosize",
  "source_commit": "$SOURCE_COMMIT",
  "version_name": "$VERSION_NAME",
  "version_code": $VERSION_CODE,
  "upload_key_alias": "$ALIAS",
  "upload_certificate_sha256": "$UPLOAD_CERT_SHA256",
  "unsigned_aab_sha256": "$UNSIGNED_SHA256",
  "signed_aab_sha256": "$SIGNED_SHA256",
  "signed_aab_bytes": $SIGNED_BYTES,
  "signed_aab_filename": "$(basename "$SIGNED_AAB")",
  "jarsigner_verification": "PASS_JAR_VERIFIED",
  "secret_material_recorded": false,
  "play_upload_performed": false,
  "hard_stop": "STOP_AFTER_LOCAL_SIGNED_AAB_VERIFICATION_BEFORE_ANY_PLAY_UPLOAD"
}
JSON

chmod 600 "$RESULT_JSON" 2>/dev/null || true

echo
echo "PASS: local release AAB signed and verified."
echo "Upload certificate SHA-256: $UPLOAD_CERT_SHA256"
echo "Signed AAB SHA-256: $SIGNED_SHA256"
echo "Signed AAB: $SIGNED_AAB"
echo "Evidence JSON: $RESULT_JSON"
echo
echo "HARD STOP: Do not upload to Play yet."
echo "Return only S5_LOCAL_SIGNING_RESULT.json to CHAT. Never send the keystore or passwords."
