package com.runle.fooddoor.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.WindowManager
import com.runle.fooddoor.R
import java.io.IOException
import java.io.InputStream

/**
 * Created by elha on 14.09.2021.
 */
class AndroidUtils constructor(private val context: Context) {

    fun setEnabled(isEnabled: Boolean, vararg views: View) {
        for (view in views) {
            view.isEnabled = isEnabled
        }
    }

    fun setFocusable(isEnabled: Boolean, vararg views: View) {
        for (view in views) {
            view.isFocusable = isEnabled
        }
    }

    fun setClickable(isEnabled: Boolean, vararg views: View) {
        for (view in views) {
            view.isClickable = isEnabled
        }
    }

    fun setPasteEnabled(isEnabled: Boolean, vararg views: View) {
        for (view in views) {
            view.isLongClickable = isEnabled
        }
    }

    fun setVisibility(isVisible: Boolean, vararg views: View) {
        for (view in views) {
            view.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }

    fun initStatusBar(activity: Activity) {
        val window = activity.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setWindowFlag(
                activity,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                true
            )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val resources = activity.resources
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

            window.statusBarColor = resources.getColor(R.color.transparent, activity.theme)
            //window.navigationBarColor = resources.getColor(R.color.transparent, activity.theme)
        }
    }

    fun statusBarDarkOrLight(activity: Activity, isDark: Boolean) {
        val view = activity.window.decorView
        if (isDark) view.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN else view.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    private fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win = activity.window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    fun loadAsset(context: Context, filepath: String?): InputStream? {
        return try {
            context.assets.open(filepath!!)
        } catch (e: IOException) {
            throw IllegalStateException(
                String.format(
                    "Can't load application properties '%s'!",
                    filepath
                ), e
            )
        }
    }

    fun isNetworkConnected(): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }

        return result
    }
}