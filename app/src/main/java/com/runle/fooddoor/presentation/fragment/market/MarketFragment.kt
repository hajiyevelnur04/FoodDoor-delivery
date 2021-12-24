package com.runle.fooddoor.presentation.fragment.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.runle.fooddoor.R
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.FragmentMarketBinding


class MarketFragment : BaseFragment() {

    private val binding: FragmentMarketBinding by lazy {
        FragmentMarketBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MarketFragment

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}