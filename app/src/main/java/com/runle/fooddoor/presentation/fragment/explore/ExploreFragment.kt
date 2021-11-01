package com.runle.fooddoor.presentation.fragment.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.FragmentExploreBinding
import com.runle.fooddoor.databinding.FragmentHomeBinding
import com.runle.fooddoor.model.BannerListEvent
import com.runle.fooddoor.model.ExploreListEvent
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kotlinx.android.synthetic.main.partial_item_explore.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {

    private val exploreViewModel: ExploreViewModel by viewModel()
    private val binding: FragmentExploreBinding by lazy {
        FragmentExploreBinding.inflate(layoutInflater).apply {
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exploreViewModel.eventsExplore.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionExplore(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this@ExploreFragment
        binding.exploreContainer.explore_container.layoutManager = GridLayoutManager(requireContext(),2)
        binding.viewModel = exploreViewModel

        return binding.root
    }

    private fun handleActionExplore(it: ExploreListEvent) {
        when(it){
            is ExploreListEvent.ShowSelectedPopular -> showItemDetail()
        }
    }

    private fun showItemDetail() {
        // to do something when item clicked
    }
}