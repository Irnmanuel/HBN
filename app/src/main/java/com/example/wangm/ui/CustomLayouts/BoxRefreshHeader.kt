package com.example.wangm.ui.CustomLayouts

import android.view.View
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshKernel
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.constant.SpinnerStyle

/**
 * Created by wangm on 2018/1/8.
 */
class BoxRefreshHeader: RefreshHeader {
    override fun getSpinnerStyle(): SpinnerStyle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFinish(layout: RefreshLayout, success: Boolean): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInitialized(kernel: RefreshKernel, height: Int, extendHeight: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPrimaryColors(vararg colors: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReleasing(percent: Float, offset: Int, headerHeight: Int, extendHeight: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartAnimator(layout: RefreshLayout, height: Int, extendHeight: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStateChanged(refreshLayout: RefreshLayout?, oldState: RefreshState?, newState: RefreshState?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRefreshReleased(layout: RefreshLayout?, headerHeight: Int, extendHeight: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPullingDown(percent: Float, offset: Int, headerHeight: Int, extendHeight: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSupportHorizontalDrag(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}