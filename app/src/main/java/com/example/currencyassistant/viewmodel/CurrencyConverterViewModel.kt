package com.example.currencyassistant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyassistant.api.Repository
import com.example.currencyassistant.api.RepositoryCallback
import com.example.currencyassistant.data.Currency
import com.example.currencyassistant.data.SingleDayRates
import com.example.currencyassistant.util.Converter
import com.example.currencyassistant.util.DateUtil

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

    private fun convert(value: Double) {
        if (actualConversion.value != null) {
            convertedValue.value = Converter.convert(actualConversion.value!!.first, actualConversion.value!!.second, value, rates!!)
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

    private fun handleError() {
        rates = null
        conversionErrorOccurred.value = true
    }

}