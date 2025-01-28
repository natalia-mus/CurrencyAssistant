package com.example.currencyassistant.database

object CacheObject {
    const val TABLE_SINGLE_DAY_RATES = "cache"

    const val CLEAR_CACHE_BEFORE_DATE = "DELETE FROM $TABLE_SINGLE_DAY_RATES WHERE date < :date"

    const val GET_ALL_CACHE = "SELECT * FROM $TABLE_SINGLE_DAY_RATES"

    const val GET_CACHE_BY_DATE = "SELECT * FROM $TABLE_SINGLE_DAY_RATES WHERE date IS :date"
}