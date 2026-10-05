# W2 Privacy Policy Body Audit Attempt — 2026-10-05 v1.0

Product: PHOTO COMPRESSOR: KB LIMIT

Policy URL:
`https://apps.afradadmedia.com/photo-compressor-kb-limit/privacy/`

## Result

`BODY_CONTENT_NOT_INDEPENDENTLY_RETRIEVABLE_IN_CHAT_ENVIRONMENT`

The policy URL had previously been operator-confirmed as publicly opening in a browser.

Current independent retrieval attempts:
- CHAT web fetch: inaccessible;
- domain web fetch/search: no retrievable indexed body;
- local HTTP retrieval environment: DNS resolution unavailable.

Therefore the deployed policy BODY cannot be audited from current independent tooling.

This does NOT establish that the URL is broken.

## Current official requirement baseline

Google Play currently requires every app to have a comprehensive privacy policy:
- linked in Play Console;
- accessible within the app;
- accurately describing how the app accesses, collects, uses, and shares user/device data.

The current GMA Next-Gen disclosure states automatic collection/sharing of:
- IP address / general location;
- user product interactions;
- diagnostic information;
- device/account identifiers;
for advertising, analytics, and fraud-prevention purposes, with TLS in transit.

Official references checked:
- https://support.google.com/googleplay/android-developer/answer/18258653
- https://developers.google.com/ad-manager/mobile-ads-sdk/android/next-gen/privacy/play-data-disclosure

## Required policy-body assertions to verify

The deployed body must be checked for truthful coverage of:

1. app/developer identity;
2. privacy contact or inquiry mechanism;
3. local/on-device photo processing;
4. statement that selected photos are not uploaded for compression;
5. AdMob / Google Mobile Ads / UMP involvement;
6. automatic SDK data types:
   - IP address / approximate location;
   - app/user product interactions;
   - diagnostics/performance;
   - device/account identifiers;
7. purposes:
   - advertising;
   - analytics;
   - fraud prevention/security/compliance;
8. third-party sharing / Google advertising services;
9. encryption/security handling where claimed;
10. retention/deletion practices or an accurate statement about publisher-controlled data retention;
11. user privacy-choice / consent mechanism where applicable;
12. no false claim of zero data collection after AdMob integration.

## Disposition

`W2_POLICY_BODY_AUDIT = BLOCKED_ON_DEPLOYED_BODY_ACCESS`

Minimal recovery:
obtain the rendered policy text/HTML or screenshots from the live page, then audit line-by-line against the checklist above.

No Play Console declaration or release action is authorized by this audit attempt.
