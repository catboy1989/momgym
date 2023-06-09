package com.catboy.momgym.usecases.permissions

import android.content.Context
import com.catboy.momgym.util.Intenter

class GetOverlayPermission(private val context: Context) {
    fun execute() {
        context.startActivity(Intenter(context).overlayPermission)
    }
}