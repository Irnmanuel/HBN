package com.example.wangm.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.Window
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)
        val alphaAnimation = AlphaAnimation(0f, 1f).apply {
            duration = 1200
            fillAfter = true
        }
        window.attributes.systemUiVisibility = SYSTEM_UI_FLAG_HIDE_NAVIGATION
        newsIconSplash.animation = alphaAnimation
        streamIconSplash.animation = alphaAnimation
        pubgIconSplash.animation = alphaAnimation
        alphaAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                startActivity<VariousTests>()
                finish()
            }
        })

    }
}
