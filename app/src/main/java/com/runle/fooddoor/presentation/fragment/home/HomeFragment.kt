package com.runle.fooddoor.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.runle.fooddoor.R
import org.koin.android.viewmodel.ext.android.viewModel
import com.runle.fooddoor.databinding.FragmentHomeBinding
import com.runle.fooddoor.model.BannerListEvent
import com.runle.fooddoor.model.CategoryListEvent
import com.runle.fooddoor.model.PopularListEvent
import com.runle.fooddoor.model.VoucherListEvent
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater).apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.eventsBanner.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionBanner(it)
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

        binding.category.seeAll.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_categoryDetailFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun handleActionBanner(it: BannerListEvent) {
        when(it){
            is BannerListEvent.ShowSelectedPopular -> showPopularItemDetail()
        }
    }

    private fun handleActionPopular(it: PopularListEvent) {
        when(it){
            is PopularListEvent.ShowSelectedPopular -> showPopularItemDetail()
        }
    }

    private fun handleActionCategory(it: CategoryListEvent) {
        when(it){
            is CategoryListEvent.ShowSelectedPopular -> showPopularItemDetail()
        }
    }
    private fun handleActionVoucher(it: VoucherListEvent) {
        when(it){
            is VoucherListEvent.ShowSelectedPopular -> showPopularItemDetail()
        }
    }

    private fun showPopularItemDetail() {
        // to do something when item clicked
    }
}