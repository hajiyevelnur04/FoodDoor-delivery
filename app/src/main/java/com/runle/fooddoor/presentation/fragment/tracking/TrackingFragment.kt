package com.runle.fooddoor.presentation.fragment.tracking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.R
import com.runle.fooddoor.databinding.FragmentTrackingBinding

class TrackingFragment : Fragment() {

    private val binding: FragmentTrackingBinding by lazy {
        FragmentTrackingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}