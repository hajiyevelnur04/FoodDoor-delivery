package com.runle.fooddoor.presentation.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.FragmentSplashBinding
import com.runle.fooddoor.presentation.fragment.welcome.model.WelcomeModel
import com.runle.fooddoor.presentation.fragment.welcome.model.WelcomeModels
import com.runle.fooddoor.util.PreferenceHelper
import org.koin.ext.getOrCreateScope

class SplashFragment : Fragment() {

    private var isIntro = true
    private val binding: FragmentSplashBinding by lazy {
        FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(isIntro){
            val welcomeModels = WelcomeModels()
            welcomeModels.add(WelcomeModel("","Brow the largest variety of food, groceries, drink and more.","description1", R.drawable.bg_test,1500,"","Get started"))
            welcomeModels.add(WelcomeModel("","Track your delivery in realtime.","description1",R.drawable.bg2_test,2500,"","Get started"))
            welcomeModels.add(WelcomeModel("","Pickup delivery at door step and enjoy your meal & groceries.","description1",R.drawable.bg3_test,3500,"","Get started"))
            welcomeModels.add(WelcomeModel("","Welcome","Fooddoor satisfies your food cravings with your favourite food delivered to you, wherever you are",R.color.primary,6000,"#0F6657","Get started",true))
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment(welcomeModels))
            isIntro = false
        } else {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainActivity())
            isIntro = true
        }

        return binding.root
    }

}