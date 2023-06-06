package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.repository.Repository

class SaveMinutes(context: Context) {

    private val repository = Repository(context)

    fun execute(text: String) {
        repository.setMinutes(Integer.parseInt(text))
    }

}
