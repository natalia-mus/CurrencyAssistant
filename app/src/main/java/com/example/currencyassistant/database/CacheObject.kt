package com.example.currencyassistant.database

object CacheObject {
    const val TABLE_SINGLE_DAY_RATES = "cache"

    const val GET_ALL = "SELECT * FROM $TABLE_SINGLE_DAY_RATES"
}