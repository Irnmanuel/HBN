package com.example.wangm.ui.fragments.boxfind

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.wangm.ui.R
import kotlinx.android.synthetic.main.box_bottom_tab_find_fragment_layout.view.*
import org.jetbrains.anko.padding
import org.jetbrains.anko.support.v4.toast
import java.lang.reflect.Field


/**
 * Created by wangm on 2017/12/23.
 */
class BoxFindFragment: android.support.v4.app.Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.box_bottom_tab_find_fragment_layout,container,false)
        var boxFindFragmentList = ArrayList<Fragment>()
        boxFindFragmentList.add(BoxFindTopLineFragment())
        boxFindFragmentList.add(BoxFindPUBGFragment())
        boxFindFragmentList.add(BoxFindGameRecommendationsFragment())
        boxFindFragmentList.add(BoxFindHardwareFragment())
        view.inBoxFindFragmentVp.adapter = BoxFindPagerAdapter(childFragmentManager,boxFindFragmentList)
        val tabTitleList = ArrayList<String>()
        tabTitleList.add("头条")
        tabTitleList.add("绝地求生")
        tabTitleList.add("游戏推荐")
        tabTitleList.add("硬件推荐")
        for(i in 0..3){
            view.boxFindTopTabContainer.addTab(view.boxFindTopTabContainer.newTab(),i)
        }
        view.boxFindTopTabContainer.setupWithViewPager(view.inBoxFindFragmentVp)
        for(i in 0..3){
            view.boxFindTopTabContainer.getTabAt(i)?.setText(tabTitleList[i])
        }
        setTabLine(view.boxFindTopTabContainer)
        return view
    }
    //通过反射修改TabLayout下划线宽度
    private fun setTabLine(tabLayout: TabLayout?) {
        var mTabStripField: Field = tabLayout!!::class.java.getDeclaredField("mTabStrip")
        mTabStripField.isAccessible = true
        val mTabStrip: LinearLayout = mTabStripField.get(tabLayout) as LinearLayout
        val scale = resources.displayMetrics.density.toInt()
        val dp18 = scale*18
        toast(mTabStrip.childCount.toString()).show()
        for (i in 0 until mTabStrip.childCount){
            val tabview: View = mTabStrip.getChildAt(i)
            val mTextViewField: Field = tabview::class.java.getDeclaredField("mTextView")
            mTextViewField.isAccessible = true
            val mTextView: TextView = mTextViewField.get(tabview) as TextView
            tabview.padding = 0
            var width: Int = mTextView.width
            if (width == 0){
                mTextView.measure(0,0)
                width = mTextView.measuredWidth
            }
            val params: LinearLayout.LayoutParams = tabview.layoutParams as LinearLayout.LayoutParams
            params.width = width
            params.leftMargin = dp18
            params.rightMargin = dp18
            tabview.layoutParams = params
            tabview.invalidate()
        }

    }

}