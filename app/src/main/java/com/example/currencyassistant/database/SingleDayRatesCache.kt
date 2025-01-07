package com.example.currencyassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.currencyassistant.database.CacheObject
import com.example.currencyassistant.database.RatesConverter
import java.util.*

@Entity(tableName = CacheObject.TABLE_SINGLE_DAY_RATES)
data class SingleDayRatesCache(
    @PrimaryKey
    val date: String,
    var base: String,
    @TypeConverters(RatesConverter::class)
    val rates: Rates
) {
    constructor(singleDayRates: SingleDayRates) : this(
        singleDayRates.date,
        singleDayRates.base,
        singleDayRates.rates
    )
}