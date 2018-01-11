package com.example.wangm.ui.Beans.BoxFindTopLine
import com.example.wangm.ui.Beans.ModelBase
import com.google.gson.annotations.SerializedName


/**
 * Created by wangm on 2017/12/27.
 */

data class BoxFindTopLineData(
		@SerializedName("img") val img: String = "",
		@SerializedName("timemills") val timemills: String = "",
		@SerializedName("clicktimes") val clicktimes: Int = 0,
		@SerializedName("title") val title: String = "",
		@SerializedName("replies") val replies: Int = 0,
		@SerializedName("type") val type: Int = 0
): ModelBase()