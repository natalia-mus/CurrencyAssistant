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
        private const val DEFAULT_BASE_VALUE = 1
        private const val CHARACTERS_FIRST_LIMIT = 8
        private const val CHARACTERS_SECOND_LIMIT = 12
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
            updateActualConversion()
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
        updateActualConversion()

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

        baseValue.setText(DEFAULT_BASE_VALUE.toString())
        updateView(null)

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
        viewModel.convertedValue.observe(viewLifecycleOwner) { updateView(it) }
        viewModel.conversionErrorOccurred.observe(viewLifecycleOwner) { handleError(it) }
    }

    /**
     * Refreshes length filter for baseValue
     * Comma in value is not considered a character so if value has one, there is need to increase the limit
     */
    private fun refreshLengthFilter(value: CharSequence?) {
        var limit = CHARACTERS_FIRST_LIMIT

        if (value != null && value.contains(".")) {
            limit = CHARACTERS_FIRST_LIMIT + 1
        }

        val filter = InputFilter.LengthFilter(limit)
        baseValue.filters = arrayOf(filter)
    }

    private fun adjustResultTextSize(value: Double) {
        val length = value.toString().length - 1        // comma is not considered a character
        var size = resources.getDimension(R.dimen.converter_value_text_size)

        if (length in CHARACTERS_FIRST_LIMIT..CHARACTERS_SECOND_LIMIT) {
            size = resources.getDimension(R.dimen.converter_value_text_size_small)

        } else if (length > CHARACTERS_SECOND_LIMIT) {
            size = resources.getDimension(R.dimen.converter_value_text_size_tiny)
        }

        resultValue.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    }

    private fun updateView(value: Double?) {
        val base = viewModel.getActualBase()
        val result = viewModel.getActualResult()

        if (base != null && result != null) {
            baseCurrencyCode.text = base.name
            resultCurrencyCode.text = result.name
            baseCurrencyName.text = base.currencyName
            resultCurrencyName.text = result.currencyName

            if (value != null) {
                adjustResultTextSize(value)
                resultValue.text = value.toBigDecimal().stripTrailingZeros().toPlainString()
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
    }

    private fun handleError(errorOccurred: Boolean) {
        if (errorOccurred) {
            Toast.makeText(activity, getString(R.string.error_conversion), Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Converts currency value without changing base and result currencies
     */
    private fun updateActualConversion() {
        updateActualConversion(null, null)
    }

    /**
     * Changes base and result currencies and then converts currency value
     */
    private fun updateActualConversion(base: Currency?, result: Currency?) {
        val value = baseValue.text.toString()

        if (isValidValue(value)) {
            viewModel.updateActualConversion(base, result, value.toDouble())
        } else if (value.isEmpty()) {
            viewModel.updateActualConversion(base, result, null)
        }
    }

    private fun openCurrencyPicker() {
        val actualConversion = viewModel.getActualConversion()

        if (actualConversion != null) {
            val currencyPicker = CurrencyPicker(requireContext(), actualConversion, this)
            currencyPicker.show()
        }
    }

    private fun isValidValue(value: String): Boolean {
        return value.isNotEmpty() && value.last().isDigit()
    }

    private fun swapCurrencies(){
        val newBase = viewModel.getActualResult()
        val newBaseFlag = resultFlag.drawable
        val newBaseCurrencyCode = resultCurrencyCode.text
        val newBaseCurrencyName = resultCurrencyName.text

        val newResult = viewModel.getActualBase()
        val newResultFlag = baseFlag.drawable
        val newResultCurrencyCode = baseCurrencyCode.text
        val newResultCurrencyName = baseCurrencyName.text

        baseFlag.setImageDrawable(newBaseFlag)
        baseCurrencyCode.text = newBaseCurrencyCode
        baseCurrencyName.text = newBaseCurrencyName

        resultFlag.setImageDrawable(newResultFlag)
        resultCurrencyCode.text = newResultCurrencyCode
        resultCurrencyName.text = newResultCurrencyName

        updateActualConversion(newBase, newResult)
    }

    override fun changeCurrency(currency: Currency) {
        val base: Currency?
        val result: Currency?

        if (currencyTypeToChange == CurrencyType.BASE) {
            base = currency
            result = viewModel.getActualResult()

        } else {
            base = viewModel.getActualBase()
            result = currency
        }

        updateActualConversion(base, result)
        updateView(null)
    }

}

interface OnCurrencyChangedAction {
    fun changeCurrency(currency: Currency)
}