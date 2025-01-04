package com.example.currencyassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.currencyassistant.database.CacheObject
import java.util.*

@Entity(tableName = CacheObject.TABLE_SINGLE_DAY_RATES)
data class SingleDayRatesCache(
    @PrimaryKey
    val date: String,
    var base: String,
    val ratesId: String
) {
    constructor(singleDayRates: SingleDayRates) : this(
        singleDayRates.date,
        singleDayRates.base,
        UUID.randomUUID().toString()
    )
}