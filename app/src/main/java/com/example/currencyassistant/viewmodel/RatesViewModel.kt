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


    fun getNewData() {
        array.clear()
        selectedDateRates.value?.clear()
        daysInRecycler.value = 0
        getNextDayRates()
    }

    fun getNextDayRates() {
        val date = daysInRecycler.value?.let { DateUtil.getDate(it) }
        if (date != null) {
            getData(date)
        }
    }

    private fun convertRatesToDefaultCurrency(singleDayRates: MutableList<SingleDayRates>, defaultCurrency: Currency): MutableList<SingleDayRates> {
        if (defaultCurrency != Currency.EUR) {
            for (singleDayRate in singleDayRates) {
                singleDayRate.base = defaultCurrency.name
                val convertedRates = ArrayList<RateDetails>()

                for (rate in singleDayRate.getCurrenciesList()) {
                    if (rate.currency != defaultCurrency) {
                        val convertedRate = Converter.convert(defaultCurrency, rate.currency, 1.0, singleDayRate)
                        rate.rating = convertedRate
                        convertedRates.add(rate)
                    }
                }

                if (singleDayRate.base != Currency.EUR.name) {
                    // add euro to currencies list
                    val euroRating = Converter.convert(defaultCurrency, Currency.EUR, 1.0, singleDayRate)
                    val euro = RateDetails(Currency.EUR, euroRating, singleDayRate.date)
                    convertedRates.add(euro)
                }

                singleDayRate.setConvertedCurrenciesList(convertedRates)
            }
        }

        return singleDayRates
    }

    private fun getData(date: String) {
        loading.value = true

        Repository.getDataFromAPI(date, object : RepositoryCallback<SingleDayRates> {
            override fun onSuccess(data: SingleDayRates?) {
                if (data != null && data.success) {
                    val response = prepareResponse(data)
                    array.add(response)

                    val defaultCurrency = Settings.getDefaultCurrency()
                    array = convertRatesToDefaultCurrency(array, defaultCurrency)
                    selectedDateRates.value = array
                    daysInRecycler.value = daysInRecycler.value?.toInt()?.plus(1)
                    success.value = true
                } else {
                    success.value = false
                }
                loading.value = false
            }

            override fun onError() {
                success.value = false
                loading.value = false
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