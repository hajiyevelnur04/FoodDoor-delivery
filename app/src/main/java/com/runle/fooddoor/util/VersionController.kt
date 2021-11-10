package com.runle.fooddoor.util

import android.os.Build

/**
 * Created by elnur on 05.11.21
 */
fun isVersionHigherAndEqual(version: Int): Boolean {
    return Build.VERSION.SDK_INT >= version
}

fun isVersionHigher(version: Int): Boolean {
    return Build.VERSION.SDK_INT > version
}

fun isVersionLowerAndEqual(version: Int): Boolean {
    return Build.VERSION.SDK_INT <= version
}

fun isVersionLower(version: Int): Boolean {
    return Build.VERSION.SDK_INT < version
}