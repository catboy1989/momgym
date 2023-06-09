package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.repository.Repository
import com.catboy.momgym.util.Alarmer
import java.util.*

class SetOrCancelAlarm(private val context: Context) {

    val repository = Repository(context)

    fun execute() {
        val isActive = repository.getIsActive()
        if (!isActive) {
            Alarmer(context).cancelAlarm()
            return
        }
        val hour = repository.getHours()
        val minutes = repository.getMinutes()
        val calendar = getCalendar(hour, minutes)
        Alarmer(context).setAlarm(calendar)
    }

    private fun getCalendar(hour: Int, minutes: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minutes)
        calendar.set(Calendar.SECOND, 0)

        val currentCalendar = Calendar.getInstance()
        if (currentCalendar.after(calendar)) calendar.add(Calendar.DATE, 1)

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        if (dayOfWeek == Calendar.SATURDAY) calendar.add(Calendar.DATE, 2)
        if (dayOfWeek == Calendar.SUNDAY) calendar.add(Calendar.DATE, 1)

        return calendar
    }

}
