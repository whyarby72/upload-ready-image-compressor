package com.afradadmedia.reducephotosize

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AdMobEligibilityTest {
    @Test
    fun resultBannerRequiresConsentAndInitializedSdk() {
        assertFalse(
            AdMobEligibility.shouldLoadResultBanner(
                canRequestAds = false,
                sdkInitialized = false
            )
        )
        assertFalse(
            AdMobEligibility.shouldLoadResultBanner(
                canRequestAds = true,
                sdkInitialized = false
            )
        )
        assertFalse(
            AdMobEligibility.shouldLoadResultBanner(
                canRequestAds = false,
                sdkInitialized = true
            )
        )
        assertTrue(
            AdMobEligibility.shouldLoadResultBanner(
                canRequestAds = true,
                sdkInitialized = true
            )
        )
    }
}
