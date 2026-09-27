package com.afradadmedia.reducephotosize;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TargetLimitParserTest {
    @Test public void decimalPresetsUseSiBytes() {
        assertEquals(50_000L, TargetLimitParser.parse("50", false));
        assertEquals(100_000L, TargetLimitParser.parse("100", false));
        assertEquals(200_000L, TargetLimitParser.parse("200", false));
        assertEquals(500_000L, TargetLimitParser.parse("500", false));
        assertEquals(1_000_000L, TargetLimitParser.parse("1", true));
    }

    @Test public void fractionalDotAndCommaAreExact() {
        assertEquals(10_500L, TargetLimitParser.parse("10.5", false));
        assertEquals(1_500_000L, TargetLimitParser.parse("1.5", true));
        assertEquals(1_500_000L, TargetLimitParser.parse("1,5", true));
    }

    @Test public void boundariesAreInclusive() {
        assertEquals(1_000L, TargetLimitParser.parse("1", false));
        assertEquals(50_000_000L, TargetLimitParser.parse("50", true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void belowMinimumIsRejected() { TargetLimitParser.parse("0.999", false); }

    @Test(expected = IllegalArgumentException.class)
    public void aboveMaximumIsRejected() { TargetLimitParser.parse("50.001", true); }

    @Test(expected = IllegalArgumentException.class)
    public void tooManyFractionalDigitsAreRejected() { TargetLimitParser.parse("10.0001", false); }

    @Test(expected = IllegalArgumentException.class)
    public void ambiguousSeparatorsAreRejected() { TargetLimitParser.parse("1,234.5", false); }

    @Test(expected = IllegalArgumentException.class)
    public void groupingNotationIsRejected() { TargetLimitParser.parse("1.000.5", true); }
}
