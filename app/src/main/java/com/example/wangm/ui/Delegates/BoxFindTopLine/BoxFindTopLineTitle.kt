package com.example.wangm.ui.Delegates.BoxFindTopLine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData
import com.example.wangm.ui.MutualRVAdapter.Base.DelegateType
import com.example.wangm.ui.MutualRVAdapter.Base.ViewHolder
import com.example.wangm.ui.R
import kotlinx.android.synthetic.main.box_find_topline_rv_title_item.view.*

/**
 * Created by wangm on 2018/1/4.
 */
class BoxFindTopLineTitle: DelegateType<BoxFindTopLineData>{
    override val itemViewLayoutId: Int
        get() = R.layout.box_find_topline_rv_title_item

    override fun isItemViewType(item: BoxFindTopLineData, position: Int): Boolean = item.type == 0

    override fun convert(context: Context, holder: ViewHolder, item: BoxFindTopLineData, position: Int) {
        with(holder.itemView){
            val simpleTarget = object : SimpleTarget<Drawable>(){
                override fun onResourceReady(resource: Drawable?, transition: Transition<in Drawable>?) {
                    boxFindToplineTitleBackgroundImg.background = resource
                }
            }

            Glide.with(context).load(item.img).into(simpleTarget)
            boxFindToplineTitleTimeMills.text = item.timemills
            boxFindToplineTitleClicks.text = item.clicktimes.toString()
            boxFindToplineTitleText.text = item.title

        }

    }

}