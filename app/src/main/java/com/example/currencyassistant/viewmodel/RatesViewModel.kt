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


    suspend fun getNewData(forceRetrievingNewData: Boolean = false) {
        array.clear()
        selectedDateRates.value?.clear()
        daysInRecycler.postValue(0)
        getNextDayRates(forceRetrievingNewData)
    }

    suspend fun getNextDayRates(forceRetrievingNewData: Boolean = false) {
        val date = daysInRecycler.value?.let { DateUtil.getDate(it) }
        if (date != null) {
            getData(date, forceRetrievingNewData)
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

                singleDayRate.setConvertedCurrenciesList(convertedRates)
            }
        } else {
            // remove euro from ratings
            for (singleDayRate in singleDayRates) {
                val convertedRates = ArrayList<RateDetails>()

                for (rate in singleDayRate.getCurrenciesList()) {
                    if (rate.currency != defaultCurrency) {
                        convertedRates.add(rate)
                    }
                }

                singleDayRate.setConvertedCurrenciesList(convertedRates)
            }
        }

        return singleDayRates
    }

    private suspend fun getData(date: String, forceRetrievingNewData: Boolean) {
        loading.postValue(true)

        Repository.getRatesByDate(date, object : RepositoryCallback<SingleDayRates> {
            override fun onSuccess(data: SingleDayRates?) {
                if (data != null && data.success) {
                    val response = prepareResponse(data)
                    array.add(response)

                    val defaultCurrency = Settings.getDefaultCurrency()
                    array = convertRatesToDefaultCurrency(array, defaultCurrency)
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
        }, forceRetrievingNewData)
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