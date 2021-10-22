package com.runle.fooddoor.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.runle.fooddoor.FilterType
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.FragmentFilterBottomBinding

class FilterBottomFragment : BottomSheetDialogFragment() {

    var filterType: FilterType? = null

    private val binding:FragmentFilterBottomBinding by lazy {
        FragmentFilterBottomBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}