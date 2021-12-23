package com.runle.fooddoor.presentation.fragment.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.runle.fooddoor.R
import com.runle.fooddoor.adapter.TabSelectionPageAdapter
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.FragmentOrderBinding
import org.koin.android.ext.android.bind

class OrderFragment : BaseFragment() {
    val headerArray = arrayOf(
        "Coming",
        "History",
        "Draft"
    )

    private val binding: FragmentOrderBinding by lazy {
        FragmentOrderBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.headerToolbar.image.setImageResource(R.drawable.my_order)
        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = TabSelectionPageAdapter(childFragmentManager,lifecycle)
        binding.viewPager.isSaveEnabled = false
        TabLayoutMediator(binding.tabs,binding.viewPager){ tab, position->
            tab.text = headerArray[position]
        }.attach()
    }

}