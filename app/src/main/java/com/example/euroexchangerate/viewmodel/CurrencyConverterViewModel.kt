package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.CurrencyCode
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.util.DateUtil

class CurrencyConverterViewModel : ViewModel() {

    val conversionErrorOccurred = MutableLiveData<Boolean>(false)
    val convertedValue = MutableLiveData<Float>()

    private val today = DateUtil.getDate(0)
    private var rates: SingleDayRates? = null


    fun convertCurrency(baseCurrency: CurrencyCode, resultCurrency: CurrencyCode, value: Float) {
        conversionErrorOccurred.value = false

        if (rates == null || (rates != null && rates!!.date != today)) {
            Repository.getDataFromAPI(today, object : RepositoryCallback<SingleDayRates> {
                override fun onSuccess(data: SingleDayRates?) {
                    if (data != null && data.success) {
                        rates = data
                        convert(baseCurrency, resultCurrency, value)
                    }
                }

                override fun onError() {
                    rates = null
                    conversionErrorOccurred.value = true
                }
            })

        } else {
            convert(baseCurrency, resultCurrency, value)
        }
    }

    private fun convert(baseCurrency: CurrencyCode, resultCurrency: CurrencyCode, value: Float) {
        if (rates != null) {
            val base = if (baseCurrency == CurrencyCode.EUR) { 1f } else { rates!!.getRate(baseCurrency)!!.toFloat() }
            val result = if (resultCurrency == CurrencyCode.EUR) { 1f } else { rates!!.getRate(resultCurrency)!!.toFloat() }
            convertedValue.value = (result / base) * value
        }
    }
}