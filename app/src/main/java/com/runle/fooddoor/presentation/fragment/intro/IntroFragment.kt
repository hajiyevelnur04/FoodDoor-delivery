package com.runle.fooddoor.presentation.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.FragmentIntroBinding
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

        binding.lifecycleOwner = this

        binding.viewModel = introViewModel
        binding.viewPager.addOnPageChangeListener(introViewModel.pageChangeListener)
        binding.viewPager.adapter = IntroAdapter()

        introViewModel.currentPosition.observe(viewLifecycleOwner, {
            binding.viewPager.setCurrentItem(it, true)
        })

        introViewModel.navigateToLogin.observe(viewLifecycleOwner, {
            /*if (it == true) {
                prefs?.setIntroPassed()
                findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToAuthActivity())
                viewModel.doneLoginNavigation()
            }*/
        })

        introViewModel.navigateToMain.observe(viewLifecycleOwner, {
            /*if (it == true) {
                prefs?.setIntroPassed()
                findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToMainActivity())
                (activity as LauncherActivity).finish()
                startIntroPicker()
            }*/
        })


        return binding.root
    }

}
