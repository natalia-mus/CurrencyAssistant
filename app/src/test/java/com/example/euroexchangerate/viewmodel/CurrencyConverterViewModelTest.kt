package com.example.euroexchangerate.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.Rates
import com.example.euroexchangerate.data.SingleDayRates
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*


class CurrencyConverterViewModelTest {

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = CurrencyConverterViewModel()

    private lateinit var fakeRates: SingleDayRates

    private val ratesValue = Rates(
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        4.7,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        1.05,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0
    )


    @Before
    fun setUp() {
        val date = getDate()
        fakeRates = SingleDayRates(true, "EUR", date, ratesValue)

        val rates = viewModel.javaClass.getDeclaredField("rates")
        rates.isAccessible = true
        rates.set(viewModel, fakeRates)
    }

    /***
     * Returns date in format YYYY-MM-DD
     */
    private fun getDate(): String {
        val today = GregorianCalendar()

        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH) + 1
        val day = today.get(Calendar.DAY_OF_MONTH)

        var monthAsString = month.toString()

        if (month < 10) {
            monthAsString = "0$monthAsString"
        }

        return "$year-$monthAsString-$day"
    }


    // converting between euro and another currency
    @Test
    fun convertEuroToAnotherCurrency() {
        viewModel.updateActualConversion(Currency.EUR, Currency.USD, 3.0)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 3.15)
    }

    @Test
    fun convertAnotherCurrencyToEuro() {
        viewModel.updateActualConversion(Currency.PLN, Currency.EUR, 4.2)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 0.89362)
    }


    // converting between two other currencies than euro
    @Test
    fun convertBetweenTwoAnotherCurrencies() {
        viewModel.updateActualConversion(Currency.PLN, Currency.USD, 5.7)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 1.2734)
    }


    // converting when value is 0
    @Test
    fun convertWhenValueIsZero() {
        viewModel.updateActualConversion(Currency.EUR, Currency.USD, 0.0)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 0.0)
    }


    // converting when result needs to be rounded
    @Test
    fun convertWhenResultNeedsToBeRounded() {
        viewModel.updateActualConversion(Currency.EUR, Currency.PLN, 0.618219435)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 2.90563)
    }

}