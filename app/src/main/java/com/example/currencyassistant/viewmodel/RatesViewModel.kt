package com.example.currencyassistant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyassistant.Settings
import com.example.currencyassistant.api.Repository
import com.example.currencyassistant.api.RepositoryCallback
import com.example.currencyassistant.data.Currency
import com.example.currencyassistant.data.RateDetails
import com.example.currencyassistant.data.SingleDayRates
import com.example.currencyassistant.util.Converter
import com.example.currencyassistant.util.DateUtil

class RatesViewModel : ViewModel() {

    val selectedDateRates = MutableLiveData<MutableList<SingleDayRates>>()
    val daysInRecycler = MutableLiveData<Int>(0)
    val loading = MutableLiveData<Boolean>(true)
    val success = MutableLiveData<Boolean>()

    private var array: MutableList<SingleDayRates> = ArrayList()


    fun convertRatesAfterDefaultCurrencyChanged() {
        loading.value = true

        val defaultCurrency = Settings.getDefaultCurrency()
        for (singleDayRates in array) {
            convertRatesToDefaultCurrency(singleDayRates, defaultCurrency)
        }

        selectedDateRates.value = array
        success.value = true
        loading.value = false
    }

    suspend fun getNextDayRates() {
        val date = daysInRecycler.value?.let { DateUtil.getDate(it) }
        date?.let { getData(it) }
    }

    private fun convertRatesToDefaultCurrency(singleDayRates: SingleDayRates, defaultCurrency: Currency): SingleDayRates {
        if (defaultCurrency != Currency.EUR) {
            singleDayRates.base = defaultCurrency.name
            val convertedRates = ArrayList<RateDetails>()

            for (rate in singleDayRates.getCurrenciesList()) {
                if (rate.currency != defaultCurrency) {
                    val convertedRate = Converter.convert(defaultCurrency, rate.currency, 1.0, singleDayRates)
                    rate.rating = convertedRate
                }
                convertedRates.add(rate)
            }

            singleDayRates.setConvertedCurrenciesList(convertedRates)

        }

        return singleDayRates
    }

    private suspend fun getData(date: String) {
        loading.postValue(true)

        Repository.getRatesByDate(date, object : RepositoryCallback<SingleDayRates> {
            override fun onSuccess(data: SingleDayRates?) {
                if (data != null && data.success) {
                    val response = prepareResponse(data)

                    val defaultCurrency = Settings.getDefaultCurrency()
                    val convertedToDefaultCurrency = convertRatesToDefaultCurrency(response, defaultCurrency)
                    array.add(convertedToDefaultCurrency)

                    selectedDateRates.postValue(array)
                    daysInRecycler.postValue(daysInRecycler.value?.toInt()?.plus(1))
                    success.postValue(true)
                } else {
                    success.postValue(false)
                }
                loading.postValue(false)
            }

            override fun onError() {
                success.postValue(false)
                loading.postValue(false)
            }
        })
    }

    /**
     * Formats received response
     */
    private fun prepareResponse(data: SingleDayRates): SingleDayRates {
        val ratesList = data.getCurrenciesList()

        for (rate in ratesList) {
            val formattedRate = Converter.formatValue(rate.rating)
            rate.rating = formattedRate
        }

        return data
    }

}