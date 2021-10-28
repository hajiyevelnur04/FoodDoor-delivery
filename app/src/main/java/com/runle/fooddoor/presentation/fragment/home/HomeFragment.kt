package com.runle.fooddoor.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import com.runle.fooddoor.databinding.FragmentHomeBinding
import com.runle.fooddoor.model.PopularListEvent

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater).apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.events.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.popular.viewModel = homeViewModel
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