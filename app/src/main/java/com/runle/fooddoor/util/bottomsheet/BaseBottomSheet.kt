package com.runle.fooddoor.util.bottomsheet

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.runle.fooddoor.R

/**
 * Created by elnur on 24.11.21
 */
open class BaseBottomSheet: BottomSheetDialogFragment() {
    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }
}