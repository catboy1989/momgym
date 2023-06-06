package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.R
import com.catboy.momgym.repository.Repository

class GetButtonText(private val context: Context) {

    private val repository = Repository(context)

    fun execute(): String {
        val isActive = repository.getIsActive()
        return if (isActive) {
            context.resources.getString(R.string.finish)
        }else {
            context.resources.getString(R.string.start)
        }
    }


}
