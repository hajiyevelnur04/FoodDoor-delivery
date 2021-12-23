package com.runle.fooddoor.presentation.fragment.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.R
import com.runle.fooddoor.base.BaseFragment
import com.runle.fooddoor.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment() {

    private val binding: FragmentFavoriteBinding by lazy {
        FragmentFavoriteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.headerToolbar.image.setImageResource(R.drawable.ic_menu_favorite)

        return binding.root
    }
}