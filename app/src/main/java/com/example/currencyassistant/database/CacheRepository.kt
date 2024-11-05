package com.example.currencyassistant.database

import android.content.Context
import androidx.room.Room
import com.example.currencyassistant.data.SingleDayRatesCache

object CacheRepository {

    private const val DATABASE_NAME = "database"

    private var database: Cache? = null


    fun init(context: Context) {
        if (database == null) {
            database = Room.databaseBuilder(context, Cache::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
        }
    }

    fun addToCache(singleDayRatesCache: SingleDayRatesCache) {
        database?.cacheDao()?.insert(singleDayRatesCache)
    }
}