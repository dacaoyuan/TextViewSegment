package com.ypk.textviewsegment.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.TextView
import androidx.core.content.ContextCompat

/**
 * @Author:         YuanPeikai
 * @CreateDate:     2019/12/20 15:33
 * @Description:
 */
class DensityUtils private constructor() {


    init {
        /* cannot be instantiated */
        throw UnsupportedOperationException("cannot be instantiated")
    }

    companion object {
        fun dpToPx(dp: Float, resources: Resources): Int {
            val px =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
            return px.toInt()
        }

        /**
         * dp转px
         */
        fun dp2px(context: Context, dpVal: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.resources.displayMetrics
            ).toInt()
        }

        /**
         * sp转px
         */
        fun sp2px(context: Context, spVal: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                spVal, context.resources.displayMetrics
            ).toInt()
        }

        /**
         * px转dp
         */
        fun px2dp(context: Context, pxVal: Float): Float {
            val scale = context.resources.displayMetrics.density
            return pxVal / scale
        }

        /**
         * px转sp
         */
        fun px2sp(context: Context, pxVal: Float): Float {
            return pxVal / context.resources.displayMetrics.scaledDensity
        }

        /**
         * drawableResId：Drawable的id，例如：R.drawable.wenda_select
         * size: Drawable的宽和高相等，是资源id。例如：R.dimen.x50
         */
        fun setDrawableTop(
            context: Context,
            mTextView: TextView,
            drawableResId: Int,
            sizeDimenId: Int
        ) {
            val viewDrawable = ContextCompat.getDrawable(context, drawableResId)
            viewDrawable!!.setBounds(
                0,
                0,
                context.resources.getDimension(sizeDimenId).toInt(),
                context.resources.getDimension(sizeDimenId).toInt()
            )
            mTextView.setCompoundDrawables(null, viewDrawable, null, null)
        }

        /**
         * drawableResId：Drawable的id，例如：R.drawable.wenda_select
         * widthDimenId: Drawable的宽，是资源id。例如：R.dimen.x50
         * heightDimenId:Drawable的高，是资源id。例如：R.dimen.x50
         */
        fun setDrawableTop(
            context: Context,
            mTextView: TextView,
            drawableResId: Int,
            widthDimenId: Int,
            heightDimenId: Int
        ) {
            val viewDrawable = ContextCompat.getDrawable(context, drawableResId)
            viewDrawable!!.setBounds(
                0,
                0,
                context.resources.getDimension(widthDimenId).toInt(),
                context.resources.getDimension(heightDimenId).toInt()
            )
            mTextView.setCompoundDrawables(null, viewDrawable, null, null)
        }

        /**
         * drawableResId：Drawable的id，例如：R.drawable.wenda_select
         * widthDimenId: Drawable的宽，是资源id。例如：R.dimen.x50
         * heightDimenId:Drawable的高，是资源id。例如：R.dimen.x50
         */
        fun setDrawableLeft(
            context: Context,
            mTextView: TextView,
            drawableResId: Int,
            widthDimenId: Int
        ) {
            val viewDrawable = ContextCompat.getDrawable(context, drawableResId)
            viewDrawable!!.setBounds(
                0,
                0,
                context.resources.getDimension(widthDimenId).toInt(),
                context.resources.getDimension(widthDimenId).toInt()
            )
            mTextView.setCompoundDrawables(viewDrawable, null, null, null)
        }


    }
}