package com.example.currencyassistant.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.currencyassistant.data.Rates
import com.example.currencyassistant.data.SingleDayRates

@Entity(tableName = CacheObject.TABLE_SINGLE_DAY_RATES)
data class SingleDayRatesCache(
    @PrimaryKey
    val date: String,
    var base: String,
    val rates: Rates
) {
    constructor(singleDayRates: SingleDayRates) : this(
        singleDayRates.date,
        singleDayRates.base,
        singleDayRates.rates
    )
}