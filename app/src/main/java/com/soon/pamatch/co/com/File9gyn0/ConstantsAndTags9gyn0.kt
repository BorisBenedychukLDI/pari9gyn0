package com.soon.pamatch.co.com

import android.util.Base64
import android.util.Log

const val EMPTY_TAG_9gyn0 = "empty"

const val APPSFLYER_CAMPAIGN_TAG_9gyn0 = "campaign"
const val APPSFLYER_STATUS_TAG_9gyn0 = "af_status"
const val APPSFLYER_ADGROUP_TAG_9gyn0 = "adgroup"
const val APPSFLYER_ADSET_TAG_9gyn0 = "adset"
const val APPSFLYER_AF_CHANNEL_TAG_9gyn0 = "af_channel"
const val APPSFLYER_MEDIA_SOURCE_TAG_9gyn0 = "media_source"

const val KEY_TAG_9gyn0 = "key"
const val BUNDLE_TAG_9gyn0 = "bundle"
const val SUB2_TAG_9gyn0 = "sub2"
const val SUB3_TAG_9gyn0 = "sub3"
const val SUB4_TAG_9gyn0 = "sub4"
const val SUB5_TAG_9gyn0 = "sub5"
const val SUB6_TAG_9gyn0 = "sub6"
const val SUB7_TAG_9gyn0 = "sub7"
const val SUB10_TAG_9gyn0 = "sub10"

const val DEFAULT_TAG_9gyn0 = "Default"
const val SHARED_PREFERENCE_TAG_9gyn0 = "sp_9gyn0"
const val ORGANIC_TAG_9gyn0 = "Organic"
const val NON_ORGANIC_TAG_9gyn0 = "Non-organic"
const val LAST_PAGE_9gyn0 = "last_page_9gyn0"
const val webURL_9gyn0 = "webUrl_9gyn0"

const val FB_DEFAULT_KEY_9gyn0 = "soondefaultpage"
const val FB_BLACK_KEY_9gyn0 = "soonblackpage"
const val FB_WHITE_KEY_9gyn0 = "soonwhitepage"

const val REQUEST_CODE_9gyn0 = 0


fun decodeBase649gyn0 (str9gyn0: String): String {
    String(Base64.decode(str9gyn0, Base64.DEFAULT)).let {
        return it
    }
}