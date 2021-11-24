package com.runle.fooddoor.presentation.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.FragmentIntroBinding
import com.runle.fooddoor.presentation.view.lang.LanguageBottomSheet
import org.koin.android.viewmodel.ext.android.viewModel

class IntroFragment : BaseFragment() {

    private val introViewModel: IntroViewModel by viewModel()

    private val binding: FragmentIntroBinding by lazy {
        FragmentIntroBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.lifecycleOwner = this@IntroFragment

        binding.viewModel = introViewModel
        binding.viewPager.addOnPageChangeListener(introViewModel.pageChangeListener)
        binding.viewPager.adapter = IntroAdapter()

        binding.lang.setOnClickListener {
            val bottomSheet = LanguageBottomSheet()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }

        introViewModel.currentPosition.observe(viewLifecycleOwner, {
            binding.viewPager.setCurrentItem(it, true)
        })

        introViewModel.navigateToLogin.observe(viewLifecycleOwner, {
            if (it == true) {
                findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToMainActivity())
                requireActivity().finish()
            }
        })

        introViewModel.navigateToMain.observe(viewLifecycleOwner, {
            if (it == true) {
                findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToMainActivity())
                requireActivity().finish()
            }
        })


        return binding.root
    }

}
