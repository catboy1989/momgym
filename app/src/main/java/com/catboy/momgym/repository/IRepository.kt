package com.catboy.momgym.repository

interface IRepository {
    fun getHours(): Int
    fun getMinutes(): Int
    fun getIsActive(): Boolean
    fun setHours(hours: Int)
    fun setMinutes(minutes: Int)
    fun setIsActive(isActive: Boolean)

}