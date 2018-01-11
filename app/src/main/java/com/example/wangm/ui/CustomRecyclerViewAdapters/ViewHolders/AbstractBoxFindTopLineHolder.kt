package com.example.wangm.ui.CustomRecyclerViewAdapters.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData


/**
 * Created by wangm on 2018/1/1.
 */
abstract class AbstractBoxFindTopLineHolder(view: View):RecyclerView.ViewHolder(view){
    open fun bind(item: BoxFindTopLineData){}
}
