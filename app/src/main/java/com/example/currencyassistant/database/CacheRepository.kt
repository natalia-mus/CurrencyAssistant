package com.example.currencyassistant.database

import android.content.Context
import androidx.room.Room
import com.example.currencyassistant.data.SingleDayRates
import com.example.currencyassistant.util.DateUtil

object CacheRepository {

    private const val DATABASE_NAME = "database"

    private var database: Cache? = null


    fun init(context: Context) {
        if (database == null) {
            database = Room.databaseBuilder(context, Cache::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
        }

        clearCache()
    }

    fun addToCache(singleDayRates: SingleDayRates) {
        val singleDayRatesCache = SingleDayRatesCache(singleDayRates)
        database?.cacheDao()?.insert(singleDayRatesCache)
    }

    fun getFromCache(date: String): SingleDayRatesCache? {
        return database?.cacheDao()?.getCacheByDate(date)
    }

    private fun clearCache() {
        val date = DateUtil.getDate(31)
        database?.cacheDao()?.clearCacheBeforeDate(date)
    }
}