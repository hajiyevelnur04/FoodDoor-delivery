package com.runle.fooddoor.presentation.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.runle.fooddoor.databinding.FragmentSplashBinding
import com.runle.fooddoor.util.PreferenceHelper
import org.koin.ext.getOrCreateScope

class SplashFragment : Fragment() {

    private val binding: FragmentSplashBinding by lazy {
        FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToIntroFragment())
        return binding.root
    }

}