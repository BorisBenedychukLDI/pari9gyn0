package com.soon.pamatch.co.com.Application9gyn0

import android.app.Application
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import com.soon.pamatch.co.com.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Application9gyn0 : Application() {
    override fun onCreate() {
        OneSignal.initWithContext(this)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.setAppId(decodeBase649gyn0(BuildConfig.ONE_SIGNAL_KEY_9gyn0))
        MobileAds.initialize(this)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                AID9gyn0 =
                    AdvertisingIdClient.getAdvertisingIdInfo(this@Application9gyn0)?.id
            } catch (e49hus2: Exception) {

            }
        }
        val appsFlyerConversion49hus2 = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(dataMap49hus2: MutableMap<String, Any>?) {
                dataMap49hus2?.run {

                    status9gyn0 =
                        if (getValue(APPSFLYER_STATUS_TAG_9gyn0).toString() == ORGANIC_TAG_9gyn0) ORGANIC_TAG_9gyn0 else NON_ORGANIC_TAG_9gyn0

                    val paramsArray49hus2 = mutableListOf<String>()
                    getValue(APPSFLYER_CAMPAIGN_TAG_9gyn0)
                        .toString()
                        .split("||").drop(1)
                        .map {
                            paramsArray49hus2.add(it.split(":")[1])
                        }

                    key9gyn0 = if (paramsArray49hus2.size >= 1) paramsArray49hus2[0] else EMPTY_TAG_9gyn0
                    sub29gyn0 = if (paramsArray49hus2.size >= 2) paramsArray49hus2[1] else EMPTY_TAG_9gyn0
                    sub39gyn0 = if (paramsArray49hus2.size >= 3) paramsArray49hus2[2] else EMPTY_TAG_9gyn0


                    mediaSource9gyn0 = getValue(APPSFLYER_MEDIA_SOURCE_TAG_9gyn0).toString()
                    afChannel9gyn0 = getValue(APPSFLYER_AF_CHANNEL_TAG_9gyn0).toString()
                    adGroup9gyn0 = getValue(APPSFLYER_ADGROUP_TAG_9gyn0).toString()
                    adSet29gyn0 = getValue(APPSFLYER_ADSET_TAG_9gyn0).toString()



                }
            }

            override fun onConversionDataFail(p0: String?) {
            }

            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            }

            override fun onAttributionFailure(p0: String?) {
            }
        }
        AppsFlyerLib.getInstance().run {
            APPSFLYER_UID9gyn0 = getAppsFlyerUID(this@Application9gyn0)
            init(
                decodeBase649gyn0(BuildConfig.APPS_KEY_9gyn0),
                appsFlyerConversion49hus2,
                this@Application9gyn0
            )
            start(this@Application9gyn0)
        }
        super.onCreate()

    }
}