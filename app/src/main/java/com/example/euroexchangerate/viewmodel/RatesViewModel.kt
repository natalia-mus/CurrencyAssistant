package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.util.DateUtil

class RatesViewModel : ViewModel() {

    val selectedDateRates = MutableLiveData<MutableList<SingleDayRates>>()
    val daysInRecycler = MutableLiveData<Int>(0)
    val loading = MutableLiveData<Boolean>(true)
    val success = MutableLiveData<Boolean>()

    private var array: MutableList<SingleDayRates> = ArrayList()


    fun getNewData() {
        val date = daysInRecycler.value?.let { DateUtil.getDate(it) }
        if (date != null) {
            getData(date)
        }
    }

    private fun getData(date: String) {
        loading.value = true

        Repository.getDataFromAPI(date, object : RepositoryCallback<SingleDayRates> {
            override fun onSuccess(data: SingleDayRates?) {
                if (data != null && data.success) {
                    array.add(data)
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

}