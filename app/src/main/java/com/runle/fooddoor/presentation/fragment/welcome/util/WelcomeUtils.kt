package com.runle.fooddoor.presentation.fragment.welcome.util

/**
 * Created by elha on 10.08.2021.
 */
fun convertLongArrayListToLongArray(arrayList: ArrayList<Long>): LongArray {
    val durations = LongArray(arrayList.size)
    for ((index, item) in arrayList.withIndex()){
        durations[index] = item
    }
    return durations
}