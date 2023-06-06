package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.repository.Repository

class GetHourText(context: Context) {

    private val repository = Repository(context)

    fun execute(): String {
        return repository.getHours().toString()
    }
}
