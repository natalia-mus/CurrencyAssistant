package com.example.euroexchangerate.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.reflect.Method

class RatesViewModelTest {

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val singleDayRates: MutableList<SingleDayRates> = ArrayList()

    private val viewModel = RatesViewModel()

    private lateinit var method: Method


    @Before
    fun setup() {
        singleDayRates.add(TestRates.getSingleDayRates())

        method = viewModel.javaClass.getDeclaredMethod("convertRatesToDefaultCurrency", MutableList::class.java, Currency::class.java)
        method.isAccessible = true
    }


    // convert rates when default currency is euro
    @Test
    fun convertRatesToDefaultCurrencyWhenDefaultCurrencyIsEuro() {
        val result = method.invoke(viewModel, singleDayRates, Currency.EUR) as MutableList<SingleDayRates>

        val value = result[0].getRate(Currency.USD)
        Assert.assertTrue(value == 1.05)
    }


    // convert rates when default currency is other than euro
    @Test
    fun convertRatesToDefaultCurrencyWhenDefaultCurrencyIsOtherThanEuro() {
        val result = method.invoke(viewModel, singleDayRates, Currency.USD) as MutableList<SingleDayRates>

        val value = result[0].getRate(Currency.EUR)
        Assert.assertTrue(value != null && value == 0.95238)
    }
}