package com.example.euroexchangerate.view

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.data.CurrencyType
import com.example.euroexchangerate.viewmodel.CurrencyConverterViewModel

class CurrencyConverterFragment: Fragment(), OnCurrencyChangedAction {

    companion object {
        private const val DEFAULT_VALUE = 1.0f
        private const val CHARACTERS_LIMIT = 8
    }

    private lateinit var fragmentView: View
    private lateinit var viewModel: CurrencyConverterViewModel

    private lateinit var baseCurrency: ConstraintLayout
    private lateinit var resultCurrency: ConstraintLayout
    private lateinit var baseFlag: ImageView
    private lateinit var resultFlag: ImageView
    private lateinit var baseCurrencyCode: TextView
    private lateinit var resultCurrencyCode: TextView
    private lateinit var baseCurrencyName: TextView
    private lateinit var resultCurrencyName: TextView
    private lateinit var baseValue: EditText
    private lateinit var resultValue: TextView
    private lateinit var baseCurrencyDetails: ConstraintLayout
    private lateinit var resultCurrencyDetails: ConstraintLayout
    private lateinit var swapButton: ImageView

    private var actualConversion = Pair(Currency.EUR, Currency.USD)
    private lateinit var currencyTypeToChange: CurrencyType

    private val onBaseCurrencyClickListener = OnClickListener {
        currencyTypeToChange = CurrencyType.BASE
        openCurrencyPicker()
    }

    private val onResultCurrencyClickListener = OnClickListener {
        currencyTypeToChange = CurrencyType.RESULT
        openCurrencyPicker()
    }

    private val textChangedListener = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(value: CharSequence?, p1: Int, p2: Int, p3: Int) {
            refreshLengthFilter(value)
            convert()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_converter, container, false)
        viewModel = ViewModelProvider(this).get(CurrencyConverterViewModel::class.java)
        initView()
        setObservers()
        convert()

        return fragmentView
    }

    private fun initView() {
        baseCurrency = fragmentView.findViewById(R.id.currency_base)
        resultCurrency = fragmentView.findViewById(R.id.currency_result)
        baseFlag = fragmentView.findViewById(R.id.currency_base_flag)
        resultFlag = fragmentView.findViewById(R.id.currency_result_flag)
        baseCurrencyCode = fragmentView.findViewById(R.id.currency_base_currency_code)
        resultCurrencyCode = fragmentView.findViewById(R.id.currency_result_currency_code)
        baseCurrencyName = fragmentView.findViewById(R.id.currency_base_currency_name)
        resultCurrencyName = fragmentView.findViewById(R.id.currency_result_currency_name)
        baseValue = fragmentView.findViewById(R.id.currency_base_value)
        resultValue = fragmentView.findViewById(R.id.currency_result_value)
        baseCurrencyDetails = fragmentView.findViewById(R.id.currency_base_currency_details)
        resultCurrencyDetails = fragmentView.findViewById(R.id.currency_result_currency_details)
        swapButton = fragmentView.findViewById(R.id.fragment_converter_swap)

        adjustFlagsDimensions()

        baseValue.setText(DEFAULT_VALUE.toString())
        updateView(actualConversion.first, actualConversion.second, null)

        baseValue.addTextChangedListener(textChangedListener)

        swapButton.setOnClickListener() {
            swapCurrencies()
        }

        baseCurrency.setOnClickListener(onBaseCurrencyClickListener)
        resultCurrency.setOnClickListener(onResultCurrencyClickListener)
    }

    private fun adjustFlagsDimensions() {
        val totalHeight = resources.displayMetrics.heightPixels
        val centerHeight = totalHeight * 0.15
        val flagDimension = (centerHeight / 2).toInt()

        baseFlag.layoutParams.width = flagDimension
        baseFlag.layoutParams.height = flagDimension

        resultFlag.layoutParams.width = flagDimension
        resultFlag.layoutParams.height = flagDimension
    }

    private fun setObservers() {
        viewModel.convertedValue.observe(viewLifecycleOwner) { updateView(actualConversion.first, actualConversion.second, it) }
        viewModel.conversionErrorOccurred.observe(viewLifecycleOwner) { handleError(it) }
    }

    /**
     * Refreshes length filter for baseValue
     * Comma in value is not consider a character so if value has one, there is need to increase the limit
     */
    private fun refreshLengthFilter(value: CharSequence?) {
        var limit = CHARACTERS_LIMIT

        if (value != null && value.contains(".")) {
            limit = CHARACTERS_LIMIT + 1
        }

        val filter = InputFilter.LengthFilter(limit)
        baseValue.filters = arrayOf(filter)
    }

    private fun adjustResultTextSize(value: Float) {
        val length = value.toString().length - 1        // comma is not considered a character
        var size = resources.getDimension(R.dimen.converter_value_text_size)

        if (length > CHARACTERS_LIMIT) {
            size = resources.getDimension(R.dimen.converter_value_text_size_small)
        }

        resultValue.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    }

    private fun updateView(base: Currency, result: Currency, value: Float?) {
        baseCurrencyCode.text = base.name
        resultCurrencyCode.text = result.name
        baseCurrencyName.text = base.currencyName
        resultCurrencyName.text = result.currencyName

        if (value != null) {
            adjustResultTextSize(value)
            resultValue.text = value.toString()
        }

        val baseFlagImage = base.getFlagImageId(requireContext())
        val resultFlagImage = result.getFlagImageId(requireContext())

        if (baseFlagImage != null) {
            baseFlag.setImageResource(baseFlagImage)
        }

        if (resultFlagImage != null) {
            resultFlag.setImageResource(resultFlagImage)
        }
    }

    private fun handleError(errorOccurred: Boolean) {
        if (errorOccurred) {
            Toast.makeText(activity, getString(R.string.error_fetch_rates), Toast.LENGTH_LONG).show()
        }
    }

    private fun convert() {
        val baseValue = baseValue.text.toString()

        if (isValidValue(baseValue)) {
            val base = actualConversion.first
            val result = actualConversion.second
            viewModel.convertCurrency(base, result, baseValue.toFloat())
        }
    }

    private fun openCurrencyPicker() {
        val currencyPicker = CurrencyPicker(requireContext(), actualConversion, this)
        currencyPicker.show()

    }

    private fun isValidValue(value: String): Boolean {
        return value.isNotEmpty() && value.last().isDigit()
    }

    private fun swapCurrencies(){
        val newBase = actualConversion.second
        val newBaseFlag = resultFlag.drawable
        val newBaseCurrencyCode = resultCurrencyCode.text
        val newBaseCurrencyName = resultCurrencyName.text
        val newBaseValue = resultValue.text

        val newResult = actualConversion.first
        val newResultFlag = baseFlag.drawable
        val newResultCurrencyCode = baseCurrencyCode.text
        val newResultCurrencyName = baseCurrencyName.text
        val newResultValue = baseValue.text

        actualConversion = Pair(newBase, newResult)

        baseFlag.setImageDrawable(newBaseFlag)
        baseCurrencyCode.text = newBaseCurrencyCode
        baseCurrencyName.text = newBaseCurrencyName
        baseValue.setText(newBaseValue)

        resultFlag.setImageDrawable(newResultFlag)
        resultCurrencyCode.text = newResultCurrencyCode
        resultCurrencyName.text = newResultCurrencyName
        resultValue.text = newResultValue
    }

    override fun changeCurrency(currency: Currency) {
        actualConversion = if (currencyTypeToChange == CurrencyType.BASE) {
            Pair(currency, actualConversion.second)

        } else {
            Pair(actualConversion.first, currency)
        }

        convert()
    }

}

interface OnCurrencyChangedAction {
    fun changeCurrency(currency: Currency)
}