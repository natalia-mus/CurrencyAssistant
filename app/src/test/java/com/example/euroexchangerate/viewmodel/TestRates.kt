package com.example.euroexchangerate.viewmodel

import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.Rates
import com.example.euroexchangerate.data.SingleDayRates
import java.util.*

object TestRates {

    fun getRates(): Rates {
        return Rates(
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.00000004829,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            4.7,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            1.05,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        )
    }

    fun getSingleDayRates(): SingleDayRates {
        return SingleDayRates(true, Currency.EUR.name, getDate(), getRates())
    }

    /***
     * Returns date in format YYYY-MM-DD
     */
    private fun getDate(): String {
        val today = GregorianCalendar()

        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH) + 1
        val day = today.get(Calendar.DAY_OF_MONTH)

        var monthAsString = month.toString()

        if (month < 10) {
            monthAsString = "0$monthAsString"
        }

        return "$year-$monthAsString-$day"
    }
}