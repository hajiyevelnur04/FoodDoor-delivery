package com.runle.fooddoor.presentation.fragment.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.databinding.FragmentDraftBinding

class DraftFragment : Fragment() {

    private val binding: FragmentDraftBinding by lazy {
        FragmentDraftBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}