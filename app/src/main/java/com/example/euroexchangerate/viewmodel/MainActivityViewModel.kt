package com.example.euroexchangerate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.euroexchangerate.api.Repository
import com.example.euroexchangerate.api.RepositoryCallback
import com.example.euroexchangerate.data.SingleDay
import com.example.euroexchangerate.util.DateUtil

class MainActivityViewModel : ViewModel() {

    val selectedDateRates =
        MutableLiveData<MutableList<SingleDay?>>()
    val daysInRecycler = MutableLiveData<Int>(0)
    val loading = MutableLiveData<Boolean>(true)
    val success = MutableLiveData<Boolean>()

    var array: MutableList<SingleDay?> = ArrayList()


    fun getNewData() {
        val date = daysInRecycler.value?.let { DateUtil.getDate(it) }
        if (date != null) {
            getData(date)
        }
    }

    private fun getData(date: String) {
        loading.value = true

        Repository.getDataFromAPI(date, object : RepositoryCallback<SingleDay> {
            override fun onSuccess(data: SingleDay?) {
                if (data?.success == true) {
                    array.add(data)
                    selectedDateRates.value = array
                    val _daysInRecycler = daysInRecycler.value
                    daysInRecycler.value = _daysInRecycler?.plus(1)
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