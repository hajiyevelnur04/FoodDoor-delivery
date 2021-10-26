package com.runle.fooddoor.presentation.fragment.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.FilterType
import com.runle.fooddoor.databinding.FragmentOrderBinding
import com.runle.fooddoor.presentation.fragment.FilterBottomFragment

class OrderFragment : Fragment() {

    var filterType: FilterType? = null

    private val binding:FragmentOrderBinding by lazy {
        FragmentOrderBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.backToolbar.filter.setOnClickListener {
            openFilter()
        }
        return binding.root
    }

    private fun openFilter() {
        val bottomSheet = FilterBottomFragment()
        bottomSheet.filterType = FilterType.OPTIONS
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

}