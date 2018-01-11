package com.example.wangm.ui.CustomRecyclerViewAdapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.wangm.ui.CustomRecyclerViewAdapters.ViewHolders.AbstractBoxFindTopLineHolder
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData
import com.example.wangm.ui.R
import kotlinx.android.synthetic.main.box_find_topline_rv_item.view.*
import kotlinx.android.synthetic.main.box_find_topline_rv_title_item.view.*


/**
 * Created by wangm on 2018/1/1.
 */
class BoxFindTopLineRVAdapter(val context: Context, val items: List<BoxFindTopLineData>):
        RecyclerView.Adapter<AbstractBoxFindTopLineHolder>(){
    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }
    override fun onBindViewHolder(holder: AbstractBoxFindTopLineHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractBoxFindTopLineHolder
    {
        if (viewType == 0){
            return BoxFindTopLineTitleViewHolder(context,LayoutInflater.from(context).inflate
            (R.layout.box_find_topline_rv_title_item,parent,false))
        }
        return BoxFindTopLineItemViewHolder(context,LayoutInflater.from(context).inflate
        (R.layout.box_find_topline_rv_item,parent,false))
    }
    class BoxFindTopLineTitleViewHolder(val context: Context,val view: View):
            AbstractBoxFindTopLineHolder(view){
        override fun bind(item: BoxFindTopLineData) {
            view.boxFindToplineTitleText.text = item.title
            view.boxFindToplineTitleTimeMills.text = item.timemills
            view.boxFindToplineTitleClicks.text = item.clicktimes.toString()
            val target = object : SimpleTarget<Drawable>(){
                override fun onResourceReady(resource: Drawable?, transition: Transition<in Drawable>?) {
                    view.boxFindToplineTitleBackgroundImg.background = resource
                }
            }
            Glide.with(context).load(item.img).into(target)
        }
    }
    class BoxFindTopLineItemViewHolder(val context: Context,val view: View):
            AbstractBoxFindTopLineHolder(view){
        override fun bind(item: BoxFindTopLineData) {
            view.boxFindToplineItemTitleText.text = item.title
            view.boxFindToplineItemTimeMills.text = item.timemills
            view.boxFindToplineItemCLicks.text = item.clicktimes.toString()
            view.boxFindToplineItemReplies.text = item.replies.toString()
            Glide.with(context).load(item.img).into(view.boxFindToplineItemImage)
        }
    }
}

