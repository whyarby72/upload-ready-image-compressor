package com.afradadmedia.reducephotosize;

import java.util.Locale;

final class FormatUtils {
    private FormatUtils() {}

    static String bytes(long bytes) {
        if (bytes >= 1024L * 1024L) {
            return String.format(Locale.US, "%.2f MB", bytes / (1024d * 1024d));
        }
        if (bytes >= 1024L) {
            return String.format(Locale.US, "%.0f KB", bytes / 1024d);
        }
        return bytes + " B";
    }

    static String target(long bytes) {
        if (bytes % (1024L * 1024L) == 0) return (bytes / (1024L * 1024L)) + " MB";
        if (bytes % 1024L == 0) return (bytes / 1024L) + " KB";
        return bytes(bytes);
    }
}
