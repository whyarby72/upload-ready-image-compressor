package com.afradadmedia.reducephotosize;

import java.util.Locale;

final class FormatUtils {
    private FormatUtils() {}

    static String bytes(long bytes) {
        if (bytes >= 1_000_000L) {
            return String.format(Locale.US, "%.2f MB", bytes / 1_000_000d);
        }
        if (bytes >= 1_000L) {
            return String.format(Locale.US, "%.0f KB", bytes / 1_000d);
        }
        return bytes + " B";
    }

    static String target(long bytes) {
        if (bytes % 1_000_000L == 0) return (bytes / 1_000_000L) + " MB";
        if (bytes % 1_000L == 0) return (bytes / 1_000L) + " KB";
        return bytes(bytes);
    }
}
