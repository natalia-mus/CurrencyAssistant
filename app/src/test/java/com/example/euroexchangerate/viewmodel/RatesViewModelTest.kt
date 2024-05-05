package com.example.euroexchangerate.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.SingleDayRates
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class RatesViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = RatesViewModel()


    @Test
    fun convertRatesToDefaultCurrency() {
        val singleDayRates: MutableList<SingleDayRates> = ArrayList()
        singleDayRates.add(TestRates.getSingleDayRates())

        val method =
            viewModel.javaClass.getDeclaredMethod("convertRatesToDefaultCurrency", MutableList::class.java, Currency::class.java)
        method.isAccessible = true
        val result = method.invoke(viewModel, singleDayRates, Currency.EUR) as MutableList<SingleDayRates>

        val value = result[0].getRate(Currency.USD)
        Assert.assertTrue(value == 1.05)
    }

}