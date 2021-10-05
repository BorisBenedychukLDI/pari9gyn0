package com.soon.pamatch.co.com

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

fun Context.get9gyn0Preferences (): SharedPreferences = getSharedPreferences(
    SHARED_PREFERENCE_TAG_9gyn0, MODE_PRIVATE)

fun SharedPreferences.putLastPage9gyn0 (str9gyn0: String) {
    edit().putString(LAST_PAGE_9gyn0, str9gyn0).apply()
}

fun SharedPreferences.getLastPage9gyn0 () = getString(LAST_PAGE_9gyn0, null)

fun SharedPreferences.getURL9gyn0 () = getString (webURL_9gyn0, null)

fun SharedPreferences.putURL9gyn0 (url9gyn0: String) {
    edit().putString(webURL_9gyn0, url9gyn0).apply()
}