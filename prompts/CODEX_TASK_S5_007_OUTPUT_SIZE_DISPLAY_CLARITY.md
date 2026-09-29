# CODEX WORK ORDER — TASK-S5-007 OUTPUT SIZE DISPLAY CLARITY

Status: PREPARED / DO NOT EXECUTE UNTIL EXPLICIT TASK-S5-007 IMPLEMENTATION APPROVAL
Branch: `task/TASK-S5-007`

Read:
- `docs/qa/TASK_S5_007_OUTPUT_SIZE_DISPLAY_TRUTH_AUDIT_v1.0.md`
- `docs/ux/TASK_S5_007_OUTPUT_SIZE_DISPLAY_CLARITY_SPEC_v1.0.md`
- `docs/product/CUSTOM_LIMIT_UNIT_SEMANTICS_DECISION_v1.0.md` if present
- `PROJECT_STATE.json`
- `CURRENT_TASK.md`

When explicitly authorized, implement presentation-only changes:

1. Add exact-byte formatting helper with thousands grouping.
2. Update Result proof copy:
   - PASS: `Actual file: <output> bytes ≤ <target>-byte limit — PASS`
   - NOT_MET: `Actual file: <output> bytes > <target>-byte limit — NOT_MET`
   - REDUCED: `Actual file: <output> bytes · no upload limit entered` plus no-PASS semantics.
3. Add quiet helper:
   `Size units here: 1 KB = 1,000 bytes. Some file managers may show 1,024-byte units.`
4. Preserve large rounded decimal-SI KB/MB result display.
5. Do not change target arithmetic/domain/compression/Save behavior.
6. Build/test/lint and run relevant instrumentation.
7. Capture PASS/NOT_MET/REDUCED at 360x800, PASS 320x640, PASS font scale 1.3.
8. Produce saved-file byte/hash evidence proving no Save mutation.
9. Update TEST_MATRIX / PROJECT_STATE / HANDOFF_CURRENT / CHANGELOG / evidence index.
10. Stop at CHAT + HUMAN review; no Play/signing/S6/BUILD/freeze/release/publication.

Protected domain files:
- JpegCompressionEngine.java
- TargetLimitParser.java
- ImageInspector.java
- MediaStoreSaver.java
- ResultContentProvider.java

If any protected/domain change appears necessary, STOP and report.
