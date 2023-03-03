package com.example.euroexchangerate.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RateDetails(
    val currency: Currency,
    val rating: Double,
    val date: String?
) : Parcelable {

    fun getImagePath(): String {
        return currency.name + "_flag_circle.png"
    }
}