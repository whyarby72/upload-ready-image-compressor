# PRIVACY POLICY REQUIRED PATCH v1.0

Status: COPY CANDIDATE — NOT DEPLOYED
Date: 2026-10-05

This patch is intentionally narrow. Preserve the existing page structure and replace/augment only the affected sections.

## Top advertising summary card

Replace ambiguous wording with:

**Advertising**

An ad-enabled release uses Google Mobile Ads (AdMob) to display a banner advertisement and Google's User Messaging Platform (UMP) to manage consent and privacy choices where required.

## Section 6 — Advertising and Google consent services

Recommended replacement:

### 6. Advertising and Google consent services

When you use an ad-enabled release of Photo Compressor: KB Limit, the app uses Google Mobile Ads (AdMob) to display a banner advertisement and Google's User Messaging Platform (UMP) to request or manage consent and privacy choices where required.

According to Google's current GMA Next-Gen SDK disclosures, Google Mobile Ads automatically collects and shares certain data for advertising, analytics, and fraud-prevention purposes. This can include:

- your device's IP address, which may be used to estimate general or approximate location;
- user product interactions, such as app launches, taps, and ad interaction information;
- diagnostic and performance information about the app and SDK;
- device and account identifiers, including the Android advertising ID, app set ID, and, where applicable, other identifiers related to signed-in accounts on the device.

Google states that data collected by the GMA Next-Gen SDK is encrypted in transit using Transport Layer Security (TLS).

This third-party processing is separate from the JPEG content handled by the app's local compression workflow. The app code does not intentionally send your selected JPEG bytes, generated result image bytes, filenames, the KB/MB target you enter, or your selected Share destination to Google Mobile Ads.

The app does not use Firebase Analytics, custom analytics, or advertising mediation in the current release. Advertising or consent-service failures are not intended to block the core photo-compression workflow.

Google's processing and retention of advertising and consent data are governed by Google's own privacy and retention practices.

## Section 10 — Retention and deletion

Keep the existing local-retention paragraphs and add:

**Third-party advertising and consent data**

Afradad Media does not operate a developer-owned server database for Google Mobile Ads or UMP data. Information processed by Google for advertising, analytics, fraud prevention, or consent services is handled and retained under Google's own privacy and retention practices. Afradad Media does not control Google's independent retention or deletion schedules.

## Section 11 — Security

Recommended replacement/addition:

### 11. Security

The core photo-compression job is designed to operate locally on your device, reducing the need to transmit your selected photo to an Afradad Media server for processing.

Google states that data collected by the GMA Next-Gen SDK is encrypted in transit using Transport Layer Security (TLS). Third-party services used by an ad-enabled release are also governed by their own security practices.

No software, device, network, or transmission method can be guaranteed to be perfectly secure.

## Section 13 — Children's privacy and target audience

Do not change this section until the Play target-audience declaration is intentionally resolved.

If Play Target audience is set to 18 and over, the current text can remain.

If Play Target audience differs, revise this policy section so both surfaces are truthful and consistent.

## Last updated

After deploying this patch, update the page's `Last updated` date to the actual deployment date.
