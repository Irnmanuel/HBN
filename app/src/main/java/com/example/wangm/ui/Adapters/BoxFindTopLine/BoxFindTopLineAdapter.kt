package com.example.wangm.ui.Adapters.BoxFindTopLine

import android.content.Context
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData
import com.example.wangm.ui.Delegates.BoxFindTopLine.BoxFindTopLineItem
import com.example.wangm.ui.Delegates.BoxFindTopLine.BoxFindTopLineTitle
import com.example.wangm.ui.MutualRVAdapter.Adapter.DelegateItemAdapter

/**
 * Created by wangm on 2018/1/4.
 */
class BoxFindTopLineAdapter(context: Context,list: List<BoxFindTopLineData>): DelegateItemAdapter<BoxFindTopLineData>(context, list){
    init {
        addItemViewDelegate(BoxFindTopLineTitle())
        addItemViewDelegate(BoxFindTopLineItem())
    }
}