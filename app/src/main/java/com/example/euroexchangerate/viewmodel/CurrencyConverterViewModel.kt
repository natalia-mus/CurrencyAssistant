package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.util.DateUtil
import kotlin.math.pow
import kotlin.math.roundToLong

class CurrencyConverterViewModel : ViewModel() {

    val actualConversion = MutableLiveData(Pair(Currency.EUR, Currency.USD))
    val conversionErrorOccurred = MutableLiveData<Boolean>(false)
    val convertedValue = MutableLiveData<Double>()

    private var rates: SingleDayRates? = null

    private val today = DateUtil.getDate(0)


    fun getActualBase(): Currency? {
        return actualConversion.value?.first
    }

    fun getActualResult(): Currency? {
        return actualConversion.value?.second
    }

    fun getActualConversion(): Pair<Currency, Currency>? {
        return actualConversion.value
    }

    fun updateActualConversion(base: Currency?, result: Currency?, value: Double?) {
        if (base != null && result != null) {
            actualConversion.value = Pair(base, result)
        }

        if (value != null) {
            convertCurrency(value)
        } else {
            convertedValue.value = 0.0
        }
    }

    private fun convertCurrency(value: Double) {
        conversionErrorOccurred.value = false

        if (rates == null || (rates!!.date != today)) {
            Repository.getDataFromAPI(today, object : RepositoryCallback<SingleDayRates> {
                override fun onSuccess(data: SingleDayRates?) {
                    if (data != null && data.success) {
                        rates = data
                        convert(value)

                    } else {
                        handleError()
                    }
                }

                override fun onError() {
                    handleError()
                }
            })

        } else {
            convert(value)
        }
    }

    private fun convert(value: Double) {
        if (rates != null) {
            val baseCurrency = actualConversion.value?.first
            val resultCurrency = actualConversion.value?.second

            if (baseCurrency != null && resultCurrency != null) {
                val base = if (baseCurrency == Currency.EUR) { 1.0 } else { rates!!.getRate(baseCurrency)!! }
                val result = if (resultCurrency == Currency.EUR) { 1.0 } else { rates!!.getRate(resultCurrency)!! }
                val converted = (result / base) * value
                convertedValue.value = formatValue(converted)
            }
        }
    }

    /**
     * Rounds value to 5 places after comma
     */
    private fun formatValue(value: Double): Double {
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
            val secondPart = secondPartAsString.toInt() + round

            val resultAsString = "$firstPartAsString.$secondPartZerosAfterComma$secondPart"
            result = resultAsString.toDouble()
        }

        return result
    }

    private fun handleError() {
        rates = null
        conversionErrorOccurred.value = true
    }

}