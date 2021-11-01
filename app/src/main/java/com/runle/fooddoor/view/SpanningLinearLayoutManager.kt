package com.runle.fooddoor.view

import android.content.Context
import android.opengl.ETC1.getHeight

import android.opengl.ETC1.getWidth
import android.util.AttributeSet

import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import kotlin.math.roundToInt


/**
 * Created by elnur on 01.11.21
 */
class SpanningLinearLayoutManager : LinearLayoutManager {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(
        context,
        orientation,
        reverseLayout
    ) {}

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {}

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateDefaultLayoutParams())
    }

    override fun generateLayoutParams(
        c: Context?,
        attrs: AttributeSet?
    ): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(c, attrs))
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams?): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(lp))
    }

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
        return super.checkLayoutParams(lp)
    }

    private fun spanLayoutSize(layoutParams: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        if (orientation == HORIZONTAL) {
            layoutParams.width =
                (getHorizontalSpace() / itemCount.toDouble()).roundToInt()
        } else if (orientation == VERTICAL) {
            layoutParams.height =
                (getVerticalSpace() / itemCount.toDouble()).roundToInt()
        }
        return layoutParams
    }

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return false
    }

    private fun getHorizontalSpace(): Int {
        return width - paddingRight - paddingLeft
    }

    private fun getVerticalSpace(): Int {
        return height - paddingBottom - paddingTop
    }
}
