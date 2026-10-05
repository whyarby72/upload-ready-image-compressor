# CODEX — S7 MINIMAL THREE-BUTTON RUNTIME RECHECK v1.0

Product: PHOTO COMPRESSOR: KB LIMIT
Repository: whyarby72/upload-ready-image-compressor
Canonical branch: task/TASK-S7-001
Expected starting HEAD: 375a0dd24744d547bbc0a7091ef330290e8559f5

## Goal

Do one minimal physical-device check only:

Confirm that the currently republished AdMob European regulations message now shows all three first-layer choices on the smartphone:

- Do not consent
- Consent
- Manage options

Do NOT repeat compression, banner, offline, Save/Share, or full runtime regression.

## Guardrails

- Use the existing separate S7 worktree.
- Do not touch the original S5 working tree.
- Use DEBUG build only.
- Do not click ads.
- Do not create AdMob app/ad units.
- Do not change Play Console.
- Do not change signing.
- Do not modify production source permanently.
- Any forced-EEA/test-device/reset hook must be temporary and fully reverted before commit.

## Steps

1. Refresh S7 worktree:
   ```bash
   git fetch origin refs/heads/task/TASK-S7-001:refs/remotes/origin/task/TASK-S7-001
   git merge --ff-only origin/task/TASK-S7-001
   git rev-parse HEAD
   ```

2. Require HEAD:
   `375a0dd24744d547bbc0a7091ef330290e8559f5`

3. Confirm one physical ADB device:
   ```bash
   adb devices -l
   ```

   If none:
   `BLOCKED_S7_MINIMAL_RECHECK_NO_ADB_DEVICE`

4. Reuse the prior official temporary UMP test method:
   - current hashed test-device ID from fresh UMP log if needed;
   - DEBUG-only ConsentDebugSettings;
   - DEBUG_GEOGRAPHY_EEA;
   - consentInformation.reset() only if needed to force fresh display.

5. Build/install DEBUG only.

6. Launch app and capture first-layer consent screen.

7. PASS requires the screenshot to visibly show all three:
   - `Do not consent`
   - `Consent`
   - `Manage options`

8. Do not interact further than needed to capture the first layer.

9. Revert all temporary test-only code.

10. Prove cleanup:
    - no hashed test-device ID in tracked source;
    - no DEBUG_GEOGRAPHY_EEA left;
    - no reset() test hook left;
    - git diff for app source clean.

11. Create minimal evidence only:
    `evidence/admob/S7_MINIMAL_THREE_BUTTON_RUNTIME_RECHECK_2026_10_05_v1.0.md`

    Include:
    - source HEAD;
    - device model / Android;
    - screenshot path;
    - observed button labels;
    - cleanup proof;
    - final disposition.

12. Commit only evidence if produced.

## Terminal dispositions

If all three labels are visible:
`PASS_S7_THREE_BUTTON_RUNTIME_RECHECK`

If first layer appears but one or more labels are missing:
`FAIL_S7_THREE_BUTTON_RUNTIME_RECHECK_LABEL_MISMATCH`

If UMP does not appear:
`PARTIAL_S7_THREE_BUTTON_RUNTIME_RECHECK_UMP_NOT_SHOWN`

If no device:
`BLOCKED_S7_MINIMAL_RECHECK_NO_ADB_DEVICE`

Stop immediately after the evidence commit. No other runtime or release work.
