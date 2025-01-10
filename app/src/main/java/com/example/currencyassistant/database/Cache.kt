package com.example.currencyassistant.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(RatesConverter::class)
@Database(entities = [SingleDayRatesCache::class], version = 1, exportSchema = false)
abstract class Cache : RoomDatabase() {

    abstract fun cacheDao(): CacheDao
}