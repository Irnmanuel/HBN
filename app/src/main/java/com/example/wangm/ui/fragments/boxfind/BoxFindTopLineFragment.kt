package com.example.wangm.ui.fragments.boxfind

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangm.ui.Adapters.BoxFindTopLine.BoxFindTopLineAdapter
import com.example.wangm.ui.CustomRecyclerViewAdapters.BoxFindTopLineRVAdapter
import com.example.wangm.ui.Beans.BoxFindTopLine.BoxFindTopLineData
import com.example.wangm.ui.Beans.ModelBase
import com.example.wangm.ui.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.box_find_topline_fragment_layout.view.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast

/**
 * Created by wangm on 2017/12/23.
 */
class BoxFindTopLineFragment: Fragment(){
    val json: String = """
[
   {
        "img": "http://img1.gamersky.com/upimg/pic/2017/12/07/201712071046266435_small.jpg",
        "title": "赌场Pecado攻略：如何满队做P城霸主？附无敌攻红楼秘籍",
        "timemills": "12:12",
        "clicktimes": 10,
        "": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
	"type":"0"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 70,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 71,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 72,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 73,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 74,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 75,
	"type":"1"
    }

]
    """.trimIndent()

    val json2: String = """
[
   {
        "img": "http://img1.gamersky.com/upimg/pic/2017/12/07/201712071046266435_small.jpg",
        "title": "赌场Pecado攻略：如何满队做P城霸主？附无敌攻红楼秘籍",
        "timemills": "12:12",
        "clicktimes": 10,
        "": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
	"type":"0"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/12/07/201712071046266435_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 70,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 71,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 72,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 73,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 74,
	"type":"1"
    },
    {
        "img": "http://img1.gamersky.com/upimg/pic/2017/05/05/201705050959078771_small.jpg",
        "timemills": "12:12",
        "clicktimes": 10,
        "title": "《绝地求生》沙漠地图攻略：东航线重要节点impala市解析",
        "replies": 75,
	"type":"1"
    }

]
    """.trimIndent()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.box_find_topline_fragment_layout,container,false)
        val lists: ArrayList<BoxFindTopLineData> = Gson().fromJson(json,object: TypeToken<List<BoxFindTopLineData>>(){}.type)
        view.boxFindTopLineRv.layoutManager = LinearLayoutManager(activity)
        val adapter = BoxFindTopLineAdapter(view.context,lists)
        view.boxFindTopLineRv.adapter = adapter
//        view.swipe.
        view.boxHeaderLoadingImg.setImageResource(R.drawable.box_loading_anim)
        val animationDrawable = view.boxHeaderLoadingImg.drawable as AnimationDrawable


        view.boxHeaderLoadingImg
        view.swipe.setOnRefreshListener {

            lists.apply {
                clear()
                addAll(Gson().fromJson(json2,object: TypeToken<List<BoxFindTopLineData>>(){}.type))
            }
            adapter.notifyDataSetChanged()
            view.swipe.finishRefresh()

        }

        view.swipe.setOnLoadmoreListener {
            lists.addAll(lists)
            adapter.notifyDataSetChanged()
            view.swipe.finishLoadmore()
        }

        return view
    }
}