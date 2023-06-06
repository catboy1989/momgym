package com.catboy.momgym.presenters

import android.content.Context
import android.text.Editable
import com.catboy.momgym.usecases.*

class MainPresenter(private val context: Context) {
    fun getButtonText(): String {
        return GetButtonText(context).execute()
    }

    fun getImage(): Int {
        return GetImage(context).execute()
    }

    fun changeIsActive() {
        ChangeIsActive(context).execute()
    }

    fun getValidHours(text: Editable?): String {
        return GetHoursFromEditText().execute(text!!)
    }

    fun saveHours(text: String) {
        SaveHours(context).execute(text)
    }

    fun getValidMinutes(text: Editable?): String {
        return GetMinutesFromEditText().execute(text!!)
    }

    fun saveMinutes(minutes: String) {
        SaveMinutes(context).execute(minutes)
    }

    fun getHourText(): String {
        return GetHourText(context).execute()
    }

    fun getMinutesText(): String {
        return GetMinutesText(context).execute()
    }

}
