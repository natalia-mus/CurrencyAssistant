package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.util.DateUtil
import com.example.euroexchangerate.util.Formatter

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
                convertedValue.value = Formatter.formatValue(converted)
            }
        }
    }

    private fun handleError() {
        rates = null
        conversionErrorOccurred.value = true
    }

}