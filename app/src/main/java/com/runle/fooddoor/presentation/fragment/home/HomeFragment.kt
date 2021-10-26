package com.runle.fooddoor.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.runle.fooddoor.databinding.FragmentHomeBinding
import com.runle.fooddoor.model.PopularListEvent

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater).apply {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel.events.observe(viewLifecycleOwner,{
            it.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun handleAction(it: PopularListEvent) {
        when(it){
            is PopularListEvent.ShowSelectedPopular -> showPopularItemDetail()
        }
    }

    private fun showPopularItemDetail() {
        // to do something when item clicked
    }
}