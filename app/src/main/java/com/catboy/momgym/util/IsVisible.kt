package com.catboy.momgym.util

import android.view.View


class IsVisible {
    fun execute(isVisible: Boolean): Int {
        return if (isVisible) View.VISIBLE else View.GONE
    }
}
