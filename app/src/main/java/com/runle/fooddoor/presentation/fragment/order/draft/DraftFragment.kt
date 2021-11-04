package com.runle.fooddoor.presentation.fragment.order.draft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.databinding.FragmentDraftBinding
import com.runle.fooddoor.model.ItemListEvent
import org.koin.android.viewmodel.ext.android.viewModel

class DraftFragment : Fragment() {

    private val draftViewModel: DraftViewModel by viewModel()
    private val binding: FragmentDraftBinding by lazy {
        FragmentDraftBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        draftViewModel.eventsPopular.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionDraft(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this@DraftFragment
        binding.viewModel = draftViewModel
        return binding.root
    }


    private fun handleActionDraft(it: ItemListEvent) {
        when(it){
            is ItemListEvent.ShowSelectedModel -> showPopularItemDetail()
        }
    }

    private fun showPopularItemDetail() {
        // to do something when item clicked
    }

}