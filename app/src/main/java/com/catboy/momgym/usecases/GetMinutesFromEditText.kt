package com.catboy.momgym.usecases

import android.text.Editable

class GetMinutesFromEditText {
    fun execute(text: Editable): String {
        var minutes: Int = if (text.isEmpty()) {
            0
        }else {
            Integer.parseInt(text.toString())
        }
        if (minutes > 59) minutes = 59
        return minutes.toString()
    }

}
