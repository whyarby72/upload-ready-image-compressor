# W2 Data Safety Reconciliation Candidate — 2026-10-04

Product: **PHOTO COMPRESSOR: KB LIMIT**  
Status: `CANDIDATE_ONLY / FINAL_PLAY_SUBMISSION_HOLD`

## Artifact basis

Valid W2 release-mode TEST artifact:

- package: `com.afradadmedia.reducephotosize`
- version: `0.1.0` / versionCode 1
- APK SHA-256: `147268aa57bbbd7224782104dcfa96018792a73f3dcaff65ceb61c218e6e2d16`
- W2 run: `37208707771`
- GMA Next-Gen: `1.5.0`
- UMP: `4.0.0`
- production AdMob IDs bound: **NO**

## Core app

Artifact/source evidence supports:

- selected JPEG/JPG is processed locally for compression;
- source JPEG is not uploaded to an Afradad Media server for compression;
- original source is not overwritten by the normal workflow;
- Save and Share are explicit user actions;
- no account/login is required;
- no Firebase Analytics;
- no custom analytics;
- no mediation.

## SDK-mediated off-device data

Current official Google GMA disclosure states automatic collection/sharing of:

- IP address;
- user product interactions;
- diagnostic information;
- device/account identifiers;

for advertising, analytics, and fraud-prevention purposes, with TLS encryption in transit.

This means an ad-enabled Play Data Safety declaration cannot use a global "no data collected/shared" answer solely because photo processing is local.

## Exact merged-manifest permission facts

Release-mode W2 artifact declares:

- INTERNET
- ACCESS_NETWORK_STATE
- READ_BASIC_PHONE_STATE
- AD_ID
- WAKE_LOCK
- FOREGROUND_SERVICE
- app-scoped DYNAMIC_RECEIVER_NOT_EXPORTED permission

It does not declare:

- CAMERA
- RECORD_AUDIO
- fine/coarse location
- READ_CONTACTS
- READ_MEDIA_IMAGES
- READ_EXTERNAL_STORAGE
- WRITE_EXTERNAL_STORAGE

## What this candidate does NOT decide

The following Play Console answers remain artifact/configuration dependent and must be finalized later:

- whether each Google-handled data type is marked collected and/or shared under the exact Play definitions;
- optional vs required status;
- processing purposes beyond Google's current documented baseline;
- retention/deletion choices where the form requests developer-specific treatment;
- effect of final consent configuration;
- effect of final production AdMob binding;
- any future SDK/configuration changes.

## Gate

`READY_FOR_FINAL_DATA_SAFETY_FORM_RECONCILIATION_AFTER_PRODUCTION_BINDING`

Do not submit this file verbatim to Play Console.
