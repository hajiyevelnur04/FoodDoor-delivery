package com.runle.fooddoor.presentation.fragment.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.data.enums.FilterType
import com.runle.fooddoor.R
import com.runle.fooddoor.presentation.fragment.FilterBottomFragment

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    private fun openFilter() {
        val bottomSheet = FilterBottomFragment()
        bottomSheet.filterType = FilterType.OPTIONS
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

}