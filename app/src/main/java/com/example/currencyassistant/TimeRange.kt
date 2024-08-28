package com.example.currencyassistant

import android.content.Context

enum class TimeRange {
    LAST_WEEK,
    LAST_MONTH,
    LAST_YEAR;

    fun getText(context: Context): String {
        return when (this) {
            LAST_WEEK -> context.getString(R.string.last_week)
            LAST_MONTH -> context.getString(R.string.last_month)
            LAST_YEAR -> context.getString(R.string.last_year)
        }
    }
}