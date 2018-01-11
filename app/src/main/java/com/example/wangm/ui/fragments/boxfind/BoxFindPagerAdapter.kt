package com.example.wangm.ui.fragments.boxfind

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by wangm on 2017/12/23.
 */
class BoxFindPagerAdapter(fm: FragmentManager,var list: List<Fragment>): FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

}