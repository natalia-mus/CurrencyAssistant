package com.example.euroexchangerate.data

data class SingleDay(
    val success: Boolean,
    val timestamp: Int,
    val base: String,
    val date: String,
    val rates: Rates
)