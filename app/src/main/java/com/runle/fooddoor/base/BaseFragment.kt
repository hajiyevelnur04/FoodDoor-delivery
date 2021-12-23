package com.runle.fooddoor.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.runle.fooddoor.R

open class BaseFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.navigationBarColor = requireActivity().resources.getColor(R.color.primary)
        requireActivity().window.statusBarColor = requireActivity().resources.getColor(R.color.bg_color)
        super.onViewCreated(view, savedInstanceState)
    }
}
