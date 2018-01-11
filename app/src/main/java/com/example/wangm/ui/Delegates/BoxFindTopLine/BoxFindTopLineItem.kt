package com.example.wangm.ui.Delegates.BoxFindTopLine

import android.content.Context
import com.bumptech.glide.Glide
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData
import com.example.wangm.ui.MutualRVAdapter.Base.DelegateType
import com.example.wangm.ui.MutualRVAdapter.Base.ViewHolder
import com.example.wangm.ui.R
import kotlinx.android.synthetic.main.box_find_topline_rv_item.view.*

/**
 * Created by wangm on 2018/1/4.
 */
class BoxFindTopLineItem: DelegateType<BoxFindTopLineData>{
    override val itemViewLayoutId: Int
        get() = R.layout.box_find_topline_rv_item

    override fun isItemViewType(item: BoxFindTopLineData, position: Int): Boolean = item.type == 1

    override fun convert(context: Context, holder: ViewHolder, item: BoxFindTopLineData, position: Int) {
        with(holder.itemView){
            boxFindToplineItemTitleText.text = item.title
            boxFindToplineItemTimeMills.text = item.timemills
            Glide.with(context).load(item.img).into(boxFindToplineItemImage)
            boxFindToplineItemReplies.text = item.replies.toString()
        }
    }

}