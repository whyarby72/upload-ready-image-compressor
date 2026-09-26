package com.uploadready.app.core;

/** Pure Java scale planner; host-testable without Android SDK. */
public final class ScalePlanner {
    private ScalePlanner() {}

    public static double nextScale(int encodedBytes, int targetBytes) {
        if (encodedBytes <= 0 || targetBytes <= 0) throw new IllegalArgumentException();
        double raw = Math.sqrt((double) targetBytes / (double) encodedBytes) * 0.92d;
        return Math.max(0.50d, Math.min(0.90d, raw));
    }

    public static int scaledDimension(int current, double scale) {
        return Math.max(1, (int) Math.floor(current * scale));
    }
}
