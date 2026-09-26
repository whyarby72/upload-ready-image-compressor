# UPLOAD-READY IMAGE COMPRESSOR — Android/Codex Factory Pilot v0.3.0

Status: `TEST / S3_FUNCTIONAL_VERTICAL_SLICE / FACTORY_v1.0.1 / CODEX_REPO_BOOTSTRAP_AUTHORIZED / ANDROID_PROOF_PENDING`

The canonical working model is **repo-first**. This ZIP is bootstrap transport only; after Codex creates/verifies the private GitHub repository, that repository becomes the durable engineering Source-of-Truth.

Core job: Choose photo → detect CURRENT size/dimensions → specify REQUIRED website limit → actual compression → actual byte verification → PASS / NOT_MET → Save/Share.

Unknown target → `REDUCED` only. Original must never be overwritten.

## Start
Codex reads `prompts/CODEX_START.md`. Repository setup is Codex-owned through `scripts/bootstrap_repo.py`.

Authorized for this task:
- create/connect one private GitHub repo named `upload-ready-image-compressor`;
- initialize Git, branches, initial/routine commits, non-force pushes.

Not authorized:
- public visibility;
- delete/transfer remote;
- force-push/shared-history rewrite;
- billing/account mutation;
- signing/release/publication;
- canonical BUILD promotion.

If GitHub provider authentication is absent, human involvement is limited to the required account authorization.

Existing source/static/host evidence remains provenance, not Android build/device proof.
