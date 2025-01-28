package com.example.currencyassistant.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(singleDayRatesCache: SingleDayRatesCache)

    @Query(CacheObject.CLEAR_CACHE_BEFORE_DATE)
    fun clearCacheBeforeDate(date: String)

    @Query(CacheObject.GET_ALL_CACHE)
    fun getAllCache(): List<SingleDayRatesCache>

    @Query(CacheObject.GET_CACHE_BY_DATE)
    fun getCacheByDate(date: String): SingleDayRatesCache?
}