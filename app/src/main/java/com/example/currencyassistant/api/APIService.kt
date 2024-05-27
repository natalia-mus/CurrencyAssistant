package com.example.currencyassistant.api

import com.example.currencyassistant.data.SingleDayRates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("{date}")
    fun getSingleDay(
        @Path("date") date: String,
        @Query("access_key") accessKey: String
    ): Call<SingleDayRates>
}