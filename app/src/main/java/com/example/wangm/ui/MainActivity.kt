package com.example.wangm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wangm.ui.fragments.boxfind.BoxFindFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDefaultFragment()
    }

    private fun initDefaultFragment() {
        supportFragmentManager.inTransaction { add(R.id.boxBottomTabFragmentContainer, BoxFindFragment()) }
    }

    private inline fun android.support.v4.app.FragmentManager.inTransaction(func: android.support.v4.app.FragmentTransaction.() -> android.support.v4.app.FragmentTransaction) {
        beginTransaction().func().commit()
    }
}









