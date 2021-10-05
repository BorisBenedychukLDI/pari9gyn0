package com.soon.pamatch.co.com.WebView9gyn0

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.soon.pamatch.co.com.get9gyn0Preferences
import com.soon.pamatch.co.com.getLastPage9gyn0
import com.soon.pamatch.co.com.getURL9gyn0

class WebView9gyn0(context9gyn0: Context, attributeSet9gyn0: AttributeSet) : WebView(context9gyn0, attributeSet9gyn0) {

    init {
        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        settings.run {
            displayZoomControls = false
            domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false
            loadWithOverviewMode = true
            displayZoomControls = false
            useWideViewPort = true
            javaScriptEnabled = true
            loadsImagesAutomatically = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            builtInZoomControls = true

        }
        webViewClient = WebViewClient9gyn0()

        context9gyn0.get9gyn0Preferences().getLastPage9gyn0().let {
            lastPage9gyn0 ->
            if (lastPage9gyn0 != null) {
                loadUrl(lastPage9gyn0)
            } else {
                loadUrl(context9gyn0.get9gyn0Preferences().getURL9gyn0()?: return@let)
            }

        }
    }


    fun setWebChromeClient (activity9gyn0: AppCompatActivity) {
        webChromeClient = WebChromeClient9gyn0(activity9gyn0)
    }

}