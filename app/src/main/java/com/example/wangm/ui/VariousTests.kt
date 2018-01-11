package com.example.wangm.ui

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_various_tests.*
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import org.jetbrains.anko.UI
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

class VariousTests : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_various_tests)
        loadingTestImg.setImageResource(R.drawable.box_loading_anim)
        val animationDrawable = loadingTestImg.drawable as AnimationDrawable
        var testi = 0
        async {
            UI {

                testBtn.onClick {
                    testi++
                    if (testi < animationDrawable.numberOfFrames)
                        loadingTestImg.setImageDrawable(animationDrawable.getFrame(testi))
                    else
                        toast("角标越界").show()
                }
            }
        }


    }
}
