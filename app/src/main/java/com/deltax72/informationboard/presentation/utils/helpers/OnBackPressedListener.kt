package com.deltax72.informationboard.presentation.utils.helpers

import androidx.annotation.IdRes

interface OnBackPressedListener {
    fun onBackPressed(@IdRes fragmentIdRes: Int)
}