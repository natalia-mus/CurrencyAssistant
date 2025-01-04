package com.example.currencyassistant.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.currencyassistant.data.SingleDayRatesCache

@Dao
interface CacheDao {

    @Insert
    fun insert(singleDayRatesCache: SingleDayRatesCache)

    @Query(CacheObject.GET_CACHE_BY_DATE)
    fun getCacheByDate(date: String): SingleDayRatesCache?
}