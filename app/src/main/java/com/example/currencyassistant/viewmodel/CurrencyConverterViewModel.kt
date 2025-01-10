package com.example.currencyassistant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyassistant.api.Repository
import com.example.currencyassistant.api.RepositoryCallback
import com.example.currencyassistant.data.Currency
import com.example.currencyassistant.data.SingleDayRates
import com.example.currencyassistant.util.Converter
import com.example.currencyassistant.util.DateUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrencyConverterViewModel : ViewModel() {

    val actualConversion = MutableLiveData(Pair(Currency.EUR, Currency.USD))
    val conversionErrorOccurred = MutableLiveData<Boolean>(false)
    val convertedValue = MutableLiveData<Double>()

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
            GlobalScope.launch { convertCurrency(value) }
        } else {
            convertedValue.value = 0.0
        }
    }

    private fun convert(value: Double, rates: SingleDayRates) {
        if (actualConversion.value != null) {
            convertedValue.postValue(Converter.convert(actualConversion.value!!.first, actualConversion.value!!.second, value, rates))
        }
    }

    private suspend fun convertCurrency(value: Double) {
        conversionErrorOccurred.postValue(false)

        Repository.getRatesByDate(today, object : RepositoryCallback<SingleDayRates> {
            override fun onSuccess(data: SingleDayRates?) {
                if (data != null && data.success) {
                    convert(value, data)

                } else {
                    handleError()
                }
            }

            override fun onError() {
                handleError()
            }
        })
    }

    private fun handleError() {
        conversionErrorOccurred.value = true
    }

}