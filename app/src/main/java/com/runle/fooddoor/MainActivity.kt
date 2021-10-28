package com.runle.fooddoor

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.runle.fooddoor.databinding.ActivityMainBinding
import com.runle.fooddoor.util.setupWithNavigationController

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
        }
    }
    private lateinit var navHostFragment: NavHostFragment

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNavigationBar()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_order,
            R.navigation.nav_fav,
            R.navigation.nav_market,
            R.navigation.nav_profile
        )

        binding.navView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home -> {
                }
                R.id.nav_order -> {
                }
                R.id.nav_fav -> {
                }
                R.id.nav_market -> {
                }
                R.id.nav_profile -> {
                }
            }
            Log.e("Data", it.title.toString())

            return@OnNavigationItemSelectedListener true
        })

        val controller = binding.navView.setupWithNavigationController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )

        controller.observe(this) { navController ->
            /*navController.removeOnDestinationChangedListener(addOnDestinationChangedListener)
            navController.addOnDestinationChangedListener(addOnDestinationChangedListener)
            setupActionBarWithNavController(navController)*/
        }

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        controller.postValue(navController)
    }
}