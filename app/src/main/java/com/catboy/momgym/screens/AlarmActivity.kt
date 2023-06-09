package com.catboy.momgym.screens

import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.catboy.momgym.R
import com.catboy.momgym.usecases.SetOrCancelAlarm
import com.catboy.momgym.util.LiteMediaPlayer

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            setTurnScreenOn(true)
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
        } else {
            @Suppress("DEPRECATION")
            this.window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }

        val mp = LiteMediaPlayer.getInstance()
        mp.play(applicationContext, R.raw.na_zaryadku_stanovis)

        val button: Button = findViewById(R.id.action_button)
        button.setOnClickListener {
            mp.stop()
            SetOrCancelAlarm(applicationContext).execute()
            finishAffinity()
        }
    }

    override fun onDestroy() {
        SetOrCancelAlarm(applicationContext).execute()
        super.onDestroy()
    }
}