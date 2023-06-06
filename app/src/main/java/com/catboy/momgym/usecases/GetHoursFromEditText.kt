package com.catboy.momgym.usecases

import android.text.Editable

class GetHoursFromEditText {
    fun execute(text: Editable): String {
        var hours: Int = if (text.isEmpty()) {
            0
        }else {
            Integer.parseInt(text.toString())
        }
        if (hours > 23) hours = 23
        return hours.toString()
    }

}
