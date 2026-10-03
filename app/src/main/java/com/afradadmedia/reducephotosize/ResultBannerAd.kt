package com.afradadmedia.reducephotosize

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.libraries.ads.mobile.sdk.banner.AdSize
import com.google.android.libraries.ads.mobile.sdk.banner.AdView
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAd
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAdRequest
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError

/**
 * TEST-only banner surface.
 *
 * It is composed only on ResultScreen after result proof and all buyer-critical completion
 * controls. No-fill/failure is silent and never alters the core flow.
 */
@Composable
internal fun ResultTestBanner() {
    val context = LocalContext.current
    val activity = context as? Activity ?: return
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    val bannerWidthDp = (screenWidthDp - 40).coerceAtLeast(280)

    val adView = remember(activity, bannerWidthDp) {
        AdView(activity).apply {
            val adSize = AdSize.getLargeAnchoredAdaptiveBannerAdSize(activity, bannerWidthDp)
            val request =
                BannerAdRequest.Builder(
                    AdMobTestConfig.SAMPLE_BANNER_AD_UNIT_ID,
                    adSize
                ).build()

            loadAd(
                request,
                object : AdLoadCallback<BannerAd>() {
                    override fun onAdLoaded(ad: BannerAd) {
                        Log.d(TAG, "TEST banner loaded.")
                    }

                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        // Product law: no-fill/error degrades to no-ad behavior.
                        Log.d(TAG, "TEST banner unavailable: $adError")
                    }
                }
            )
        }
    }

    DisposableEffect(adView) {
        onDispose {
            adView.destroy()
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = { adView }
        )
    }
}

private const val TAG = "ResultTestBanner"
