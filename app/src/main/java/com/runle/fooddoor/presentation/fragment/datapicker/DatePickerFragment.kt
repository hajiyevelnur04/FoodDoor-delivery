package com.runle.fooddoor.presentation.fragment.datapicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.runle.fooddoor.databinding.FragmentDatePickerBinding

class DatePickerFragment : Fragment() {

    private val binding: FragmentDatePickerBinding by lazy {
        FragmentDatePickerBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}