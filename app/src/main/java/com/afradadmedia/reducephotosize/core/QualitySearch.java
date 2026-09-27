package com.afradadmedia.reducephotosize.core;

/** Pure Java quality search; host-testable without Android SDK. */
public final class QualitySearch {
    public interface Probe {
        int encodedSizeAt(int quality) throws Exception;
    }

    public static final class Result {
        public final int quality;
        public final int sizeBytes;
        public Result(int quality, int sizeBytes) {
            this.quality = quality;
            this.sizeBytes = sizeBytes;
        }
    }

    private QualitySearch() {}

    public static Result highestQualityUnderTarget(
            Probe probe, int minQuality, int maxQuality, int targetBytes) throws Exception {
        if (minQuality < 1 || maxQuality > 100 || minQuality > maxQuality) {
            throw new IllegalArgumentException("Invalid quality range");
        }
        if (targetBytes <= 0) throw new IllegalArgumentException("targetBytes must be > 0");

        int minSize = probe.encodedSizeAt(minQuality);
        if (minSize > targetBytes) return null;

        int lo = minQuality;
        int hi = maxQuality;
        int bestQ = minQuality;
        int bestSize = minSize;

        while (lo <= hi) {
            int q = lo + (hi - lo) / 2;
            int size = probe.encodedSizeAt(q);
            if (size <= targetBytes) {
                bestQ = q;
                bestSize = size;
                lo = q + 1;
            } else {
                hi = q - 1;
            }
        }
        return new Result(bestQ, bestSize);
    }
}
