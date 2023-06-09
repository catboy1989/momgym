package com.catboy.momgym.presenters

import android.content.Context


interface IPermissionView {
    fun setOverlayButtonVisibility(visibility: Int)
    fun getApplicationContext(): Context?
}