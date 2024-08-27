package com.example.currencyassistant

import android.content.Context
import android.content.SharedPreferences
import com.example.currencyassistant.data.Currency

object Settings {

    private const val DEFAULT_CURRENCY = "default_currency"
    private const val TIME_RANGE = "time_range"
    private const val SETTINGS = "settings"

    private var instance: SharedPreferences? = null

    fun init(context: Context) {
        if (instance == null) {
            instance = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
        }
    }

    fun getDefaultCurrency(): Currency {
        var result = Currency.EUR

        if (instance != null) {
            val defaultCurrency = instance!!.getString(DEFAULT_CURRENCY, Currency.EUR.name)
            if (defaultCurrency != null) {
                result = Currency.valueOf(defaultCurrency)
            }
        }

        return result
    }

    fun setDefaultCurrency(currency: Currency) {
        if (instance != null) {
            instance!!.edit().putString(DEFAULT_CURRENCY, currency.name).apply()
        }
    }

    fun getTimeRange(): TimeRange {
        var result = TimeRange.LAST_WEEK

        if (instance != null) {
            val timeRange = instance!!.getString(TIME_RANGE, result.name)
            if (timeRange != null) {
                result = TimeRange.valueOf(timeRange)
            }
        }

        return result
    }

    fun setTimeRange(timeRange: TimeRange) {
        if (instance != null) {
            instance!!.edit().putString(TIME_RANGE, timeRange.name).apply()
        }
    }
}