package com.uploadready.app;

final class ImageInfo {
    final android.net.Uri uri;
    final String displayName;
    final String mimeType;
    final long sizeBytes;
    final int width;
    final int height;

    ImageInfo(android.net.Uri uri, String displayName, String mimeType, long sizeBytes, int width, int height) {
        this.uri = uri;
        this.displayName = displayName;
        this.mimeType = mimeType;
        this.sizeBytes = sizeBytes;
        this.width = width;
        this.height = height;
    }
}
