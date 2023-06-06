package com.catboy.momgym.repository

import android.content.Context

class Repository(context: Context) : IRepository {

    companion object {
        private const val BASE_NAME = "mom_db"
        private const val DEFAULT_INT = 0
        private const val DEFAULT_BOOLEAN = false
        private const val HOURS = "hours"
        private const val MINUTES = "minutes"
        private const val IS_ACTIVE = "is_active"
    }

    private val sharedPreference = SharedPreferencesStorage(context, BASE_NAME)

    override fun getHours(): Int {
        return sharedPreference.getInt(HOURS, DEFAULT_INT)
    }

    override fun getMinutes(): Int {
        return sharedPreference.getInt(MINUTES, DEFAULT_INT)
    }

    override fun getIsActive(): Boolean {
        return sharedPreference.getBoolean(IS_ACTIVE, DEFAULT_BOOLEAN)
    }

    override fun setHours(hours: Int) {
        sharedPreference.save(HOURS, hours)
    }

    override fun setMinutes(minutes: Int) {
        sharedPreference.save(MINUTES, minutes)
    }

    override fun setIsActive(isActive: Boolean) {
        sharedPreference.save(IS_ACTIVE, isActive)
    }
}