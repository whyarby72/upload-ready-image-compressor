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
 * Consent + GMA initialization controller.
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
                    InitializationConfig.Builder(AdMobTestConfig.APP_ID).build()
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
    // App identity is provider-backed in every variant so the published UMP message can be
    // exercised. Banner traffic is variant-bound: Google demo unit in debug, production unit
    // in release.
    val APP_ID: String = BuildConfig.ADMOB_APP_ID
    val BANNER_AD_UNIT_ID: String = BuildConfig.ADMOB_BANNER_AD_UNIT_ID
}

internal object AdMobEligibility {
    fun shouldLoadResultBanner(canRequestAds: Boolean, sdkInitialized: Boolean): Boolean =
        canRequestAds && sdkInitialized
}
