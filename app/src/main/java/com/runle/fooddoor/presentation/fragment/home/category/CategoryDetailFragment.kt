package com.runle.fooddoor.presentation.fragment.home.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import com.runle.fooddoor.databinding.FragmentCategoryDetailBinding
import com.runle.fooddoor.model.ItemListEvent

class CategoryDetailFragment : Fragment() {

    private val categoryDetailViewModel: CategoryDetailViewModel by viewModel()
    private val binding: FragmentCategoryDetailBinding by lazy {
        FragmentCategoryDetailBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryDetailViewModel.eventsCategory.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionBanner(it)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this@CategoryDetailFragment
        binding.categoryDetailContainer.layoutManager = GridLayoutManager(requireContext(),3)
        binding.viewModel = categoryDetailViewModel

        return binding.root
    }

    private fun handleActionBanner(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun showPopularItemDetail() {
        // to do something when item clicked
    }
}