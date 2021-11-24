package com.runle.fooddoor.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.runle.fooddoor.R

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FoodDoor_Intro)
        setContentView(R.layout.activity_launch)
    }
}