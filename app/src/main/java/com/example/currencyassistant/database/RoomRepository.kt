package com.example.currencyassistant.database

import android.content.Context
import androidx.room.Room
import com.example.currencyassistant.data.SingleDayRates

class RoomRepository(context: Context) {

    private companion object {
        const val DATABASE_NAME = "database"
    }

    private val database: Database

    init {
        database = Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    fun addToCache(singleDayRates: SingleDayRates) {
        // todo
    }
}