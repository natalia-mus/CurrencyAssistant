package com.example.currencyassistant.util

import java.util.*

object DateUtil {

    fun getDate(_minusDays: Int): String {
        val minusDays = _minusDays * (-1)
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, minusDays)

        val year = date.get(Calendar.YEAR).toString()
        var month = date.get(Calendar.MONTH).plus(1).toString()
        var day = date.get(Calendar.DAY_OF_MONTH).toString()

        if (month.toInt() < 10) {
            month = "0$month"
        }

        if (day.toInt() < 10) {
            day = "0$day"
        }

        return "$year-$month-$day"
    }

}