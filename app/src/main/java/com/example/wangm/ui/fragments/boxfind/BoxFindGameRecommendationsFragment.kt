package com.example.wangm.ui.fragments.boxfind

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wangm.ui.R

/**
 * Created by wangm on 2017/12/23.
 */
class BoxFindGameRecommendationsFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.box_find_game_recommendations_layout,container,false)
    }
}