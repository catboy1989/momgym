package com.catboy.momgym.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.catboy.momgym.usecases.SetOrCancelAlarm

class BootUpReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) SetOrCancelAlarm(context).execute()
    }
}