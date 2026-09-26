package com.uploadready.app;

import java.io.File;

final class CompressionResult {
    enum State { PASS, NOT_MET, REDUCED, ALREADY_READY, ALREADY_SMALL, ERROR }

    final State state;
    final File resultFile;
    final long sourceBytes;
    final long outputBytes;
    final long targetBytes;
    final int width;
    final int height;
    final int jpegQuality;
    final boolean resized;
    final String message;

    CompressionResult(State state, File resultFile, long sourceBytes, long outputBytes,
                      long targetBytes, int width, int height, int jpegQuality,
                      boolean resized, String message) {
        this.state = state;
        this.resultFile = resultFile;
        this.sourceBytes = sourceBytes;
        this.outputBytes = outputBytes;
        this.targetBytes = targetBytes;
        this.width = width;
        this.height = height;
        this.jpegQuality = jpegQuality;
        this.resized = resized;
        this.message = message;
    }
}
