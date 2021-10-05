package com.soon.pamatch.co.com

import android.animation.AnimatorSet
import android.animation.FloatEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.soon.pamatch.co.com.WebView9gyn0.WebView9gyn0
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class WebActivity9gyn0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity_9gyn0)
        setChrome9gyn0 ()
        onRefresh9gyn0 {
            it.isRefreshing = false
            findViewById<WebView9gyn0>(R.id.wv_9gyn0).run {
                loadUrl(this.url ?: return@run)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onResume() {
        lifecycleScope.launch {
            while (isActive) {
                if (!checkInternet9gyn0() && !isShown9gyn0) {
                    findViewById<WebView9gyn0>(R.id.wv_9gyn0).setOnTouchListener { view9gyn0, motionEvent9gyn0 -> true }
                    findViewById<SwipeRefreshLayout>(R.id.srl_9gyn0).isEnabled = false
                    playAnimationInternet9gyn0 ()
                    isShown9gyn0 = true
                }
                if (checkInternet9gyn0() && isShown9gyn0) {
                    findViewById<WebView9gyn0>(R.id.wv_9gyn0).setOnTouchListener { view9gyn0, motionEvent9gyn0 -> false }
                    findViewById<SwipeRefreshLayout>(R.id.srl_9gyn0).isEnabled = true
                    ValueAnimator.ofFloat(1f,0f).apply {
                        setEvaluator(FloatEvaluator())
                        duration = 2000
                        addUpdateListener {
                            findViewById<LottieAnimationView>(R.id.animation_lottie_9gyn0).progress =
                                it.animatedValue.toString().toFloat()
                        }
                        start()
                    }.doOnEnd {
                        playCloseAnimation9gyn0()
                    }
                    isShown9gyn0 = false
                }
                delay(500)
            }
        }
        super.onResume()
    }

    override fun onBackPressed() = findViewById<WebView9gyn0>(R.id.wv_9gyn0).run {
        if (canGoBack() && isFocused) goBack() else super.onBackPressed()
    }

    override fun onActivityResult(requestCode9gyn0: Int, resultCode9gyn0: Int, data9gyn0: Intent?) {
        if (filePathCallBack9gyn0 != null && requestCode9gyn0 == REQUEST_CODE_9gyn0) {
            val uriResult9gyn0 =
                if (data9gyn0 == null || resultCode9gyn0 != RESULT_OK) null else data9gyn0.data
            if (uriResult9gyn0 != null) {
                filePathCallBack9gyn0?.onReceiveValue(arrayOf(uriResult9gyn0))
            } else {
                filePathCallBack9gyn0?.onReceiveValue(arrayOf(uriView9gyn0))
            }
            filePathCallBack9gyn0 = null
        }
        super.onActivityResult(requestCode9gyn0, resultCode9gyn0, data9gyn0)
    }

    private fun checkInternet9gyn0(): Boolean {
        val connectivityManager9gyn0 =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val networkCapabilities9gyn0 =
                connectivityManager9gyn0.getNetworkCapabilities(connectivityManager9gyn0.activeNetwork)
                    ?: return false
            return networkCapabilities9gyn0.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            for (network9gyn0 in connectivityManager9gyn0.allNetworks) {
                connectivityManager9gyn0.getNetworkInfo(network9gyn0)?.let {
                    if (it.isConnected) return true
                }
            }
            return false
        }
    }

    @SuppressLint("Recycle")
    private fun playAnimationInternet9gyn0 () {
        AnimatorSet()
            .play(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.ALPHA, 0f, 1f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.srl_9gyn0), View.ALPHA, 1f, 0.5f).apply {
                duration = 300
                start()
            })
            .with(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.SCALE_X, 0.5f, 1f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.SCALE_Y, 0.5f, 1f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.animation_lottie_9gyn0), View.ALPHA, 0f, 1f).apply {
                duration = 300
                start()
            }).before(ValueAnimator.ofFloat(0f,1f).apply {
                duration = 2000
                addUpdateListener {
                    findViewById<LottieAnimationView>(R.id.animation_lottie_9gyn0).progress = it.animatedValue.toString().toFloat()
                }
                start()
            })
    }

    @SuppressLint("Recycle")
    private fun playCloseAnimation9gyn0 () {
        AnimatorSet()
            .play(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.ALPHA, 1f, 0f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.srl_9gyn0), View.ALPHA, 0.5f, 1f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.SCALE_X, 1f, 0.5f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.circle_9gyn0), View.SCALE_Y, 1f, 0.5f).apply {
                duration = 300
                start()
            }).with(ObjectAnimator.ofFloat(findViewById(R.id.animation_lottie_9gyn0), View.ALPHA, 1f, 0f).apply {
                duration = 300
                start()
            })
    }


}