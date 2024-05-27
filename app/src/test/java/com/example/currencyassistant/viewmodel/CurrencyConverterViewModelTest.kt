package com.example.currencyassistant.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.currencyassistant.data.Currency
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CurrencyConverterViewModelTest {

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = CurrencyConverterViewModel()


    @Before
    fun setUp() {
        val rates = viewModel.javaClass.getDeclaredField("rates")
        rates.isAccessible = true
        rates.set(viewModel, TestRates.getSingleDayRates())
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


    @Test
    fun convertWhenResultHasManyZerosAndNeedsToBeRounded() {
        viewModel.updateActualConversion(Currency.EUR, Currency.CZK, 1.0)
        val result = viewModel.convertedValue.value
        Assert.assertTrue(result == 0.0)
    }

}