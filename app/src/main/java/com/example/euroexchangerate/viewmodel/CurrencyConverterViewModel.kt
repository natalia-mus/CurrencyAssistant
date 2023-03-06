package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.util.DateUtil

class CurrencyConverterViewModel : ViewModel() {

    val conversionErrorOccurred = MutableLiveData<Boolean>(false)
    val convertedValue = MutableLiveData<Float>()

    private var rates: SingleDayRates? = null

    private val actualConversion = MutableLiveData(Pair(Currency.EUR, Currency.USD))
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

    fun updateActualConversion(base: Currency?, result: Currency?, value: Float?) {
        if (base != null && result != null) {
            actualConversion.value = Pair(base, result)
        }

        if (value != null) {
            convertCurrency(value.toFloat())
        } else {
            convertedValue.value = 0f
        }
    }

    private fun convertCurrency(value: Float) {
        conversionErrorOccurred.value = false

        if (rates == null || (rates!!.date != today)) {
            Repository.getDataFromAPI(today, object : RepositoryCallback<SingleDayRates> {
                override fun onSuccess(data: SingleDayRates?) {
                    if (data != null && data.success) {
                        rates = data
                        convert(value)
                    }
                }

                override fun onError() {
                    rates = null
                    conversionErrorOccurred.value = true
                }
            })

        } else {
            convert(value)
        }
    }

    private fun convert(value: Float) {
        if (rates != null) {
            val baseCurrency = actualConversion.value?.first
            val resultCurrency = actualConversion.value?.second

            if (baseCurrency != null && resultCurrency != null) {
                val base = if (baseCurrency == Currency.EUR) { 1f } else { rates!!.getRate(baseCurrency)!!.toFloat() }
                val result = if (resultCurrency == Currency.EUR) { 1f } else { rates!!.getRate(resultCurrency)!!.toFloat() }
                convertedValue.value = (result / base) * value
            }
        }
    }
}