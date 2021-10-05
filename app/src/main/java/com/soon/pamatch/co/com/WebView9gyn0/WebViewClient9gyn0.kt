package com.soon.pamatch.co.com.WebView9gyn0

import android.content.Intent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.soon.pamatch.co.com.get9gyn0Preferences
import com.soon.pamatch.co.com.putLastPage9gyn0

class WebViewClient9gyn0 : WebViewClient() {
    override fun shouldOverrideUrlLoading(view9gyn0: WebView?, request9gyn0: WebResourceRequest?): Boolean {
        val modifiedLinks9gyn0 = listOf ("mailto:","tel:")
        return when {
            modifiedLinks9gyn0.find { request9gyn0
                ?.url.toString().startsWith(it) } != null -> {
                view9gyn0?.context?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        request9gyn0?.url
                    )
                )
                true
            }
            else -> false
        }
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        view?.context?.get9gyn0Preferences()?.putLastPage9gyn0(url?: return)
        super.onPageFinished(view, url)
    }
}