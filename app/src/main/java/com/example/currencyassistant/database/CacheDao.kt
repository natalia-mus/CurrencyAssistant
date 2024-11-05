package com.example.currencyassistant.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.currencyassistant.data.SingleDayRatesCache

@Dao
interface CacheDao {

    @Insert
    fun insert(singleDayRatesCache: SingleDayRatesCache)
}