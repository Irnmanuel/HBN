package com.example.wangm.ui.CustomLayouts

import android.content.Context
import android.graphics.*
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet


/**
 * Created by wangm on 2017/12/24.
 */
class RoundedCornerConstraintlayout : ConstraintLayout {
    private var maskBitmap: Bitmap? = null
    private var paint: Paint? = null
    private var cornerRadius: Float = 0.toFloat()
    constructor(context: Context):super(context){init(context, null, 0)}
    constructor(context: Context, attrs: AttributeSet):super(context,attrs){init(context, attrs, 0)}
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {init(context, attrs, defStyle)}

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)

        setWillNotDraw(false)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        if (maskBitmap == null) {
            // This corner radius assumes the image width == height and you want it to be circular
            // Otherwise, customize the radius as needed
            cornerRadius = 20f
            maskBitmap = createMask(canvas.width, canvas.height)
        }

        canvas.drawBitmap(maskBitmap, 0f, 0f, paint)
    }

     fun createMask(width: Int, height: Int): Bitmap {
        val mask = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(mask)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.parseColor("#F1F2F3") // TODO set your background color as needed
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)//先画一个#F1F2F3色矩形
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        canvas.drawRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), cornerRadius,cornerRadius, paint)//在画一个透明圆角矩形将其覆盖，因为上一个是白色，透明将其覆盖显示底色红色
        return mask
    }
}