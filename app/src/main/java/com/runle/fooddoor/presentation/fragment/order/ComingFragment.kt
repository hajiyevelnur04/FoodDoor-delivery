package com.runle.fooddoor.presentation.fragment.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.runle.fooddoor.R
import com.runle.fooddoor.adapter.TabSelectionPageAdapter
import com.runle.fooddoor.databinding.FragmentCommingBinding

class ComingFragment : Fragment() {

    private val binding: FragmentCommingBinding by lazy {
        FragmentCommingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}