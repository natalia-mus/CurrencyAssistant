package com.example.currencyassistant.api

import com.example.currencyassistant.data.SingleDayRates
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    // http://data.fixer.io/api/latest?access_key=06a2cd727f37ab10e2efcbc629559de7&base=eur

    private const val BASE_URL = "http://data.fixer.io/api/"
    private const val ACCESS_KEY = "06a2cd727f37ab10e2efcbc629559de7"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: APIService = retrofit.create(APIService::class.java)


    fun getDataFromAPI(date: String, callback: RepositoryCallback<SingleDayRates>) {
        apiService.getSingleDay(date, ACCESS_KEY).enqueue(object : Callback<SingleDayRates> {
            override fun onResponse(call: Call<SingleDayRates>, response: Response<SingleDayRates>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<SingleDayRates>, t: Throwable) {
                callback.onError()
            }
        })
    }
}