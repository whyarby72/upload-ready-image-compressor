# CI
Default CI performs repo-contract preflight and, once an Android Gradle wrapper exists, assembleDebug + unit tests + lintDebug. It then regenerates evidence index and handoff.

CI never publishes to Play, changes AdMob, signs production artifacts, or advances human approvals.
