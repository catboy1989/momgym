package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.repository.Repository

class ChangeIsActive(context: Context) {

    private val repository = Repository(context)

    fun execute() {
        val isActive = repository.getIsActive()
        repository.setIsActive(!isActive)
    }

}
