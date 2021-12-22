package com.runle.fooddoor.presentation.view.lang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.runle.fooddoor.databinding.ViewLanguageBottomSheetBinding
import com.runle.fooddoor.model.ItemListEvent
import com.runle.fooddoor.util.bottomsheet.BaseBottomSheet
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by elnur on 24.11.21
 */
class LanguageBottomSheet : BaseBottomSheet() {

    private val mViewModel: LanguageBottomSheetViewModel by viewModel()
    private val binding: ViewLanguageBottomSheetBinding by lazy {
        ViewLanguageBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding.lifecycleOwner = this@LanguageBottomSheet
        binding.langRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.viewModel = mViewModel

        mViewModel.eventsLanguage.observe(viewLifecycleOwner,{ event ->
            event.getContentIfNotHandled()?.let {
                handleActionBanner(it)
            }
        })

        binding.close.setOnClickListener {
            dismiss()
        }
        mViewModel.disMiss.observe(viewLifecycleOwner, {
            if (it) {
                dismiss()
                /*(parentFragment as ProfileFragment).recreateLanguage()
                viewModel.doneDisMiss()*/
            }
        })
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