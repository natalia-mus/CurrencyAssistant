package com.example.currencyassistant

import android.content.Context
import android.content.SharedPreferences
import com.example.currencyassistant.data.Currency

object Settings {

    private const val DEFAULT_CURRENCY = "default_currency"
    private const val SETTINGS = "settings"

    private var instance: SharedPreferences? = null

    fun init(context: Context) {
        if (instance == null) {
            instance = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
        }
    }

    fun changeDefaultCurrency(currency: Currency) {
        if (instance != null) {
            instance!!.edit().putString(DEFAULT_CURRENCY, currency.name).apply()
        }
    }

    fun getDefaultCurrency(): Currency {
        var result = Currency.EUR

        if (instance != null) {
            val defaultCurrency = instance!!.getString(DEFAULT_CURRENCY, Currency.EUR.name)
            if (defaultCurrency != null) {
                result = Currency.getByCode(defaultCurrency)
            }
        }

        return result
    }
}