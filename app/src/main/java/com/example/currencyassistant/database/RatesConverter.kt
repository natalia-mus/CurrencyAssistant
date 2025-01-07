package com.example.currencyassistant.database

import androidx.room.TypeConverter
import com.example.currencyassistant.data.Rates

class RatesConverter {

    @TypeConverter
    fun ratesToString(rates: Rates): String {
    }

    @TypeConverter
    fun stringToRates(ratesAsString: String): Rates? {
    }
}