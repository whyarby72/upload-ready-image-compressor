package com.afradadmedia.reducephotosize;

import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    static String exactBytes(long bytes) {
        return String.format(Locale.US, "%,d", bytes);
    }

    static String target(long bytes) {
        if (bytes >= 1_000_000L) return decimalSi(bytes, 1_000_000L, "MB");
        if (bytes >= 1_000L) return decimalSi(bytes, 1_000L, "KB");
        return bytes + " B";
    }

    private static String decimalSi(long bytes, long unit, String suffix) {
        BigDecimal value = BigDecimal.valueOf(bytes)
                .divide(BigDecimal.valueOf(unit), 3, RoundingMode.DOWN)
                .stripTrailingZeros();
        return value.toPlainString() + " " + suffix;
    }
}
