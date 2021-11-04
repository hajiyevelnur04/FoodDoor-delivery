package com.runle.fooddoor.view

import android.content.Context
import com.google.android.material.tabs.TabLayout
import android.widget.TextView
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import com.runle.fooddoor.R

/**
 * Created by elnur on 04.11.21
 */
class CustomTabLayout : TabLayout {

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun newTab(): Tab {
        val tab = super.newTab()
        tab.setCustomView(R.layout.partial_item_tab)
        if (tabTextColors != null) {
            //apply our color treatment to tabs when we create them.
            setTabTextColor(tab, tabTextColors!!)
        }
        return tab
    }

    override fun setTabTextColors(textColor: ColorStateList?) {
        super.setTabTextColors(textColor)

        //Custom views don't get the color treatment set it here whenever setTabTextColors gets called
        for (tabIter in 0 until this.tabCount) {
            setTabTextColor(getTabAt(tabIter)!!, textColor!!)
        }
    }

    private fun setTabTextColor(tab: Tab, textColor: ColorStateList) {
        val textView = tab!!.customView!!.findViewById<View>(R.id.text) as TextView
        textView?.setTextColor(textColor)
    }
}