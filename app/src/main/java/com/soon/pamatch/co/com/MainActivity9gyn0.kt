package com.soon.pamatch.co.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity9gyn0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_9gyn0)
        get9gyn0Preferences().getLastPage9gyn0()?.let {
            startActivity(Intent(this, WebActivity9gyn0::class.java))
            finish()
        }
        setupFirebase9gyn0()
        clickStart9gyn0 {
            TransitionManager.go(Scene.getSceneForLayout(findViewById(R.id.const_9gyn0),R.layout.scene_main_9gyn0,this), ChangeBounds())
            lifecycleScope.launch {
                launch {
                    delay(500)
                    for (i in 5 downTo 0) {
                        findViewById<TextView>(R.id.tv_countDown_9gyn0).text = i.toString()
                        delay(1000)
                    }
                }
                delay(5001)
                getAndSaveURL9gyn0()
                startActivity(Intent(this@MainActivity9gyn0, WebActivity9gyn0::class.java))
                finish()
            }
        }

    }
}