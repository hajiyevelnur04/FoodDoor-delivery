package com.runle.fooddoor.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.runle.fooddoor.R
import com.runle.fooddoor.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel
import com.runle.fooddoor.databinding.FragmentHomeBinding
import com.runle.fooddoor.model.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater).apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.statusBarColor = requireActivity().resources.getColor(R.color.primary)

        homeViewModel.eventsBanner.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionBanner(it)
            }
        })

        homeViewModel.bannerDataSize.observe(viewLifecycleOwner,{
            binding.banner.indicator.setDotCount(it.size)
        })

        binding.banner.bannerRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                layoutManager.findFirstCompletelyVisibleItemPosition().let {
                    if (it >= 0)
                        binding.banner.indicator.setCurrentPosition(it)
                }
            }
        })
        homeViewModel.eventsPopular.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionPopular(it)
            }
        })
        homeViewModel.eventsVoucher.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionVoucher(it)
            }
        })
        homeViewModel.eventsCategory.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionCategory(it)
            }
        })
        homeViewModel.eventsCollection.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionCollection(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.lifecycleOwner = this@HomeFragment
        binding.popular.viewModel = homeViewModel
        binding.banner.viewModel = homeViewModel
        binding.category.categoryContainer.layoutManager = GridLayoutManager(requireContext(),4)
        binding.category.viewModel = homeViewModel
        binding.voucher.viewModel = homeViewModel
        binding.collection.viewModel = homeViewModel

        binding.category.seeAll.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_categoryDetailFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun handleActionBanner(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun handleActionCollection(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun handleActionPopular(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun handleActionCategory(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }
    private fun handleActionVoucher(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun showPopularItemDetail() {
        // to do something when item clicked
    }
}