# S7 ADB install evidence conflict — 2026-10-03

Product: PHOTO COMPRESSOR: KB LIMIT
Branch: `task/TASK-S7-001`

## Conflict

Human/Codex report supplied in chat:
- scoped S5 stash/restore: PASS;
- S7 assembleDebug/testDebugUnitTest/lintDebug: PASS;
- APK SHA-256: `4fc626e4f274a711dfdfbb71408c684ba332ae034aac7439b1e3bf4936afd1c6`;
- ADB install/launch: BLOCKED because `no devices/emulators found`;
- reported S7 HEAD: `724b5191b9d27e234edae5f279b14103d54425c8`.

Repository evidence at that same HEAD records:
- device serial `RR8N805R27P`;
- model `SM-N980F` / Android 13 API 33;
- ADB install PASS;
- ADB launch PASS;
- foreground app `com.afradadmedia.reducephotosize.s7test/.MainActivity`.

These two records cannot both describe the same terminal state without additional chronology/explanation.

## Disposition

`HOLD_MATERIAL_EVIDENCE_CONFLICT`

Do not claim:
- S7 device install PASS;
- S7 device install FAIL;
- RT-01..RT-07 PASS.

## Required reconciliation

Run a fresh, timestamped device check and report:
- `git rev-parse HEAD`
- `adb devices -l`
- `adb shell getprop ro.product.model`
- `adb shell getprop ro.build.version.release`
- `adb shell pm list packages | grep com.afradadmedia.reducephotosize`
- if the S7 package is present, `adb shell dumpsys package com.afradadmedia.reducephotosize.s7test | grep -E "versionName|versionCode"`
- if present, launch it and record the command result.

No provider/Play mutation is required to reconcile this conflict.
