package com.runle.fooddoor.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.runle.fooddoor.presentation.fragment.order.ComingFragment
import com.runle.fooddoor.presentation.fragment.order.DraftFragment
import com.runle.fooddoor.presentation.fragment.order.HistoryFragment

/**
 * Created by elnur on 04.11.21
 */

private const val NUM_TABS = 3

class TabSelectionPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ComingFragment()
            1 -> return HistoryFragment()
            2 -> return DraftFragment()
        }
        return ComingFragment()
    }


}