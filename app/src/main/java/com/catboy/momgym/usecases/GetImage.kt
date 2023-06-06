package com.catboy.momgym.usecases

import android.content.Context
import com.catboy.momgym.R
import com.catboy.momgym.repository.Repository

class GetImage(context: Context) {

    private val repository = Repository(context)

    fun execute(): Int {
        val isActive = repository.getIsActive()
        return if (isActive) {
            R.drawable.good
        }else {
            R.drawable.bad
        }
    }

}
