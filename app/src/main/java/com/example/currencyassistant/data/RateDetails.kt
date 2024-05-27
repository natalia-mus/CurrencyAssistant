package com.example.currencyassistant.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RateDetails(
    val currency: Currency,
    var rating: Double,
    val date: String?
) : Parcelable