package com.example.euroexchangerate.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RateDetails(
    val currencyName: String,
    val rating: String,
    val date: String?
) : Parcelable