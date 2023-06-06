package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.repository.Repository

class GetMinutesText(context: Context) {

    private val repository = Repository(context)

    fun execute(): String {
        return repository.getMinutes().toString()
    }

}
