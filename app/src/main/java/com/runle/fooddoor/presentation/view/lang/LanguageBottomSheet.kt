package com.runle.fooddoor.presentation.view.lang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.databinding.ViewLanguageBottomSheetBinding
import com.runle.fooddoor.util.bottomsheet.BaseBottomSheet
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by elnur on 24.11.21
 */
class LanguageBottomSheet : BaseBottomSheet() {

    private val mViewModel: LanguageBottomSheetViewModel by viewModel()
    private val binding by lazy {
        ViewLanguageBottomSheetBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@LanguageBottomSheet
            viewModel = mViewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
}