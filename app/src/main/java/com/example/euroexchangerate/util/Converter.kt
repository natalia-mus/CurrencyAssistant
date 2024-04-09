package com.example.euroexchangerate.util

import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import kotlin.math.pow
import kotlin.math.roundToLong

object Converter {

    /**
     * Conversion between currencies, based on given rates
     */
    fun convert(baseCurrency: Currency, resultCurrency: Currency, value: Double, rates: SingleDayRates): Double {
        val base = if (baseCurrency == Currency.EUR) {
            1.0
        } else {
            rates.getRate(baseCurrency)!!
        }
        val result = if (resultCurrency == Currency.EUR) {
            1.0
        } else {
            rates.getRate(resultCurrency)!!
        }
        val converted = (result / base) * value
        return formatValue(converted)
    }

    /**
     * Rounds value to 5 places after comma
     */
    fun formatValue(value: Double): Double {
        var result = value
        val valueAsString = value.toBigDecimal().toPlainString()

        // counting places after comma
        val commaIndex = valueAsString.indexOf(".")
        val fractionPartLength = valueAsString.length - 1 - commaIndex

        // if value has more than 5 numbers after comma there's need to round the value
        if (fractionPartLength > 5) {
            val wholeNumberPartLength = valueAsString.length - fractionPartLength - 1
            val firstPartAsString = valueAsString.substring(0, wholeNumberPartLength)                               // whole part of number
            var secondPartAsString = valueAsString.substring(wholeNumberPartLength + 1, wholeNumberPartLength + 6)  // first 5 places after comma
            val lastPartAsString = valueAsString.substring(wholeNumberPartLength + 6, valueAsString.length)         // remaining places after comma

            // converting last part to decimal form 0.x
            val multiplier = (0.1).pow(lastPartAsString.length)
            val round = (lastPartAsString.toLong() * multiplier).roundToLong()    // result is always 0 or 1

            // previous zeros are ignored when converting to Int, variable is necessary to recover the second part after round
            var secondPartZerosAfterComma = ""
            while (secondPartAsString.startsWith("0")) {
                secondPartZerosAfterComma += "0"
                secondPartAsString = secondPartAsString.drop(1)
            }

            // creating the final value
            val secondPart = if (secondPartAsString.isNotEmpty()) {
                secondPartAsString.toInt() + round
            } else 0

            val resultAsString = "$firstPartAsString.$secondPartZerosAfterComma$secondPart"
            result = resultAsString.toDouble()
        }

        return result
    }

    /**
     * Formats value for displaying purposes
     */
    fun formatValueToString(value: Double): String {
        return value.toBigDecimal().stripTrailingZeros().toPlainString()
    }

}