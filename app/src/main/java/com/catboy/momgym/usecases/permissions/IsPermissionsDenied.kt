package com.catboy.momgym.usecases.permissions

import android.content.Context
import android.provider.Settings

class IsPermissionsDenied(private val context: Context) {
    fun execute(): Boolean {
        return !Settings.canDrawOverlays(context)
    }
}