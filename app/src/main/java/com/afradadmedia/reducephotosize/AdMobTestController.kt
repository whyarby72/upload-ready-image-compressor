package com.afradadmedia.reducephotosize

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.android.libraries.ads.mobile.sdk.MobileAds
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationConfig
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import java.util.concurrent.atomic.AtomicBoolean

/**
 * TEST-only consent + GMA initialization controller.
 *
 * Product invariants:
 * - UMP consent information is refreshed on every app launch.
 * - GMA is initialized only when UMP says ads may be requested.
 * - Publisher first-party ID is disabled before this controller exposes the SDK as ready.
 * - Consent/ad failures never block the core photo-compression flow.
 */
internal class AdMobTestController(private val activity: Activity) {
    private val consentInformation: ConsentInformation =
        UserMessagingPlatform.getConsentInformation(activity)

    var canRequestAds by mutableStateOf(false)
        private set

    var privacyOptionsRequired by mutableStateOf(false)
        private set

    val sdkInitialized: Boolean
        get() = AdMobSdkRuntime.initialized

    fun refreshConsentOnLaunch() {
        val params = ConsentRequestParameters.Builder().build()

        consentInformation.requestConsentInfoUpdate(
            activity,
            params,
            {
                publishConsentState()
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) {
                    publishConsentState()
                    maybeInitializeAds()
                }
                // UMP explicitly permits checking canRequestAds immediately after the update as
                // prior-session consent may already be valid.
                maybeInitializeAds()
            },
            {
                // A consent refresh error must never block the buyer job. If prior consent is
                // still sufficient, canRequestAds() remains the authoritative gate.
                publishConsentState()
                maybeInitializeAds()
            }
        )
    }

    fun showPrivacyOptions() {
        UserMessagingPlatform.showPrivacyOptionsForm(activity) {
            publishConsentState()
            maybeInitializeAds()
        }
    }

    private fun publishConsentState() {
        activity.runOnUiThread {
            canRequestAds = consentInformation.canRequestAds()
            privacyOptionsRequired =
                consentInformation.privacyOptionsRequirementStatus ==
                    ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
        }
    }

    private fun maybeInitializeAds() {
        if (!consentInformation.canRequestAds()) return

        if (AdMobSdkRuntime.initialized) {
            publishConsentState()
            return
        }

        if (!AdMobSdkRuntime.initializationStarted.compareAndSet(false, true)) return

        Thread(
            {
                MobileAds.initialize(
                    activity.applicationContext,
                    InitializationConfig.Builder(AdMobTestConfig.SAMPLE_APP_ID).build()
                ) {
                    // W1 privacy-minimization default. Apply before any banner request is enabled.
                    MobileAds.putPublisherFirstPartyIdEnabled(false)
                    activity.runOnUiThread {
                        AdMobSdkRuntime.initialized = true
                        publishConsentState()
                    }
                }
            },
            "gma-next-gen-init"
        ).start()
    }
}

private object AdMobSdkRuntime {
    val initializationStarted = AtomicBoolean(false)

    var initialized by mutableStateOf(false)
}

internal object AdMobTestConfig {
    // Official Google sample IDs. These are deliberately not tied to the user's AdMob account.
    const val SAMPLE_APP_ID = "ca-app-pub-3940256099942544~3347511713"
    const val SAMPLE_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/9214589741"
}

internal object AdMobEligibility {
    fun shouldLoadResultBanner(canRequestAds: Boolean, sdkInitialized: Boolean): Boolean =
        canRequestAds && sdkInitialized
}
