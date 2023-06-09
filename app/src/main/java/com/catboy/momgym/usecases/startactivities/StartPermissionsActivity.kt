package com.catboy.momgym.usecases.startactivities

import android.content.Context
import com.catboy.momgym.util.Intenter

class StartPermissionsActivity(private val context: Context) {
    fun execute(needGo: Boolean) {
        if (needGo) context.startActivity(Intenter(context).permissionsActivity())
    }
}