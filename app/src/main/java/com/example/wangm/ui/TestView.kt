package com.example.wangm.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.windowManager



/**
 * Created by wangm on 2018/1/6.
 */
class TestView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,attributeSet: AttributeSet): super(context, attributeSet){
        val pathMeasure = PathMeasure()
        val path = Path()
        val canvas = Canvas()
        val paint = Paint()
        val point = Point()
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val pathMeasure = PathMeasure()
        val path = Path()
        val paint = Paint()
        val point = Point()
        context.windowManager.defaultDisplay.getSize(point)
        canvas?.translate(point.x.toFloat()/2,point.y.toFloat()/2)
//        path.lineTo(0f,200f)
//        path.lineTo(200f,200f)
//        path.lineTo(200f,0f)
        paint.color = Color.parseColor("#ff0000")
        paint.strokeWidth = 50f
        canvas?.drawRect(Rect(0, 0, 400, 400), paint)
    }
}