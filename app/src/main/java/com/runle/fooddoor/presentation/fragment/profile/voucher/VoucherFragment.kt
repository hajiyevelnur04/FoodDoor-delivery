package com.runle.fooddoor.presentation.fragment.profile.voucher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.FragmentVoucherBinding
import org.koin.android.viewmodel.ext.android.viewModel

class VoucherFragment : Fragment() {

    private val mViewModel: VoucherViewModel by viewModel()
    private val binding: FragmentVoucherBinding by lazy {
        FragmentVoucherBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@VoucherFragment
            viewModel = mViewModel
            executePendingBindings()

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