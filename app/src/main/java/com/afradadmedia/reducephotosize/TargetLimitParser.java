package com.afradadmedia.reducephotosize;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Exact decimal-SI conversion for explicit upload limits. */
final class TargetLimitParser {
    static final long MIN_BYTES = 1_000L;
    static final long MAX_BYTES = 50_000_000L;

    private TargetLimitParser() {}

    static long parse(String raw, boolean megabytes) {
        if (raw == null) throw new IllegalArgumentException("Enter a valid number");
        String value = raw.trim();
        if (value.isEmpty() || value.indexOf('.') >= 0 && value.indexOf(',') >= 0
                || value.indexOf('.') != value.lastIndexOf('.')
                || value.indexOf(',') != value.lastIndexOf(',')) {
            throw new IllegalArgumentException("Use one decimal separator only");
        }
        if (value.indexOf('.') >= 0) value = value.replace('.', '.');
        else if (value.indexOf(',') >= 0) value = value.replace(',', '.');
        if (!value.matches("[0-9]+(?:\\.[0-9]{1,3})?")) {
            throw new IllegalArgumentException("Use a number with up to 3 decimal places");
        }
        BigDecimal multiplier = BigDecimal.valueOf(megabytes ? 1_000_000L : 1_000L);
        long bytes;
        try {
            bytes = new BigDecimal(value).multiply(multiplier)
                    .setScale(0, RoundingMode.FLOOR).longValueExact();
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException("Limit is too large", ex);
        }
        if (bytes < MIN_BYTES || bytes > MAX_BYTES) {
            throw new IllegalArgumentException("Use a limit between 1 KB and 50 MB");
        }
        return bytes;
    }
}
