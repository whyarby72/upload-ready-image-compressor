# S5 Upload Key Certificate Read-Only Recheck Result

Date: 2026-10-03
Product: PHOTO COMPRESSOR: KB LIMIT

Evidence PDF SHA-256: ba74873a43f0b7042ae0722c024b0c538daad7e7a669725307375f46ccde85c1
Evidence PDF bytes: 1251372

Observed on Google Play Console App signing page:
- Upload key certificate section is now populated.
- MD5 certificate fingerprint is visible.
- SHA-1 certificate fingerprint is visible.
- SHA-256 certificate fingerprint is visible.
- The SHA-256 value visibly matches the locally recorded expected fingerprint through:
  22:EA:E7:C3:78:69:B8:1A:E7:13:F7:00:7C:11:44:10:EC:A8:67:82:6A:FE:BB:34:9A:B7:B9:61:C9
- The screenshot view truncates the final bytes before the copy icon, so the full 32-byte SHA-256 equality is not independently proven from pixels alone.
- Expected local SHA-256:
  22:EA:E7:C3:78:69:B8:1A:E7:13:F7:00:7C:11:44:10:EC:A8:67:82:6A:FE:BB:34:9A:B7:B9:61:C9:86:5F:F4
- Request upload key reset is available but was not used.

Disposition:
PASS_UPLOAD_KEY_CERTIFICATE_REGISTERED_PROVIDER_CONFIRMED
EXACT_FULL_SHA256_TEXT_RECHECK_OPTIONAL

The provider has registered an upload-key certificate after the first bundle upload. Current scope hard stop is satisfied. No key mutation was performed.
