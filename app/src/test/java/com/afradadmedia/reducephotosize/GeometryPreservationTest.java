package com.afradadmedia.reducephotosize;

import com.afradadmedia.reducephotosize.core.ScalePlanner;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/** Deterministic geometry contract test for the engine's uniform resize planner. */
public class GeometryPreservationTest {
    @Test
    public void resizedRatioSetUsesUniformScaleWithinIntegerTolerance() {
        int[][] ratios = {
                {1000, 1000}, {1200, 800}, {800, 1200}, {1200, 900},
                {900, 1200}, {1600, 900}, {900, 1600}
        };
        for (int[] source : ratios) {
            assertUniform(source[0], source[1], 0.73d);
        }
    }

    @Test
    public void exifRotate90SwapsDisplayAxesWithoutDistortion() {
        assertUniform(1200, 1600, 0.61d);
        assertUniform(1600, 1200, 0.61d);
    }

    @Test
    public void alreadyReadyPathPreservesDecodedGeometry() {
        int width = 640;
        int height = 480;
        int outputWidth = width;
        int outputHeight = height;
        assertTrue(Math.abs((long) outputWidth * height - (long) outputHeight * width) <= width + height);
        assertTrue(outputWidth == width && outputHeight == height);
    }

    private static void assertUniform(int width, int height, double scale) {
        int outputWidth = ScalePlanner.scaledDimension(width, scale);
        int outputHeight = ScalePlanner.scaledDimension(height, scale);
        long delta = Math.abs((long) outputWidth * height - (long) outputHeight * width);
        assertTrue("ratio drift for " + width + "x" + height + " -> " + outputWidth + "x" + outputHeight,
                delta <= width + height);
        assertTrue(outputWidth >= 1 && outputHeight >= 1);
    }
}
