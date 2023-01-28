package com.example.euroexchangerate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.CurrencyCode

class CurrencyConverterFragment: Fragment() {

    companion object {
        private const val FLAG_IMAGE_NAME = "_flag_circle"
        private const val DRAWABLE = "drawable"
    }

    private lateinit var fragmentView: View

    private lateinit var baseFlag: ImageView
    private lateinit var resultFlag: ImageView
    private lateinit var baseCurrencyCode: TextView
    private lateinit var resultCurrencyCode: TextView
    private lateinit var baseCurrencyName: TextView
    private lateinit var resultCurrencyName: TextView
    private lateinit var baseValue: EditText
    private lateinit var resultValue: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_converter, container, false)
        initView()
        return fragmentView
    }

    private fun initView() {
        baseFlag = fragmentView.findViewById(R.id.fragment_converter_base_flag)
        resultFlag = fragmentView.findViewById(R.id.fragment_converter_result_flag)
        baseCurrencyCode = fragmentView.findViewById(R.id.fragment_converter_base_currency_code)
        resultCurrencyCode = fragmentView.findViewById(R.id.fragment_converter_result_currency_code)
        baseCurrencyName = fragmentView.findViewById(R.id.fragment_converter_base_currency_name)
        resultCurrencyName = fragmentView.findViewById(R.id.fragment_converter_result_currency_name)
        baseValue = fragmentView.findViewById(R.id.fragment_converter_base_value)
        resultValue = fragmentView.findViewById(R.id.fragment_converter_result_value)

        updateView(CurrencyCode.PLN, CurrencyCode.USD)
    }

    private fun updateView(base: CurrencyCode, result: CurrencyCode) {
        baseCurrencyCode.text = base.name
        resultCurrencyCode.text = result.name
        baseCurrencyName.text = base.currencyName
        resultCurrencyName.text = result.currencyName

        val baseFlagImage = getFlagImageId(base)
        val resultFlagImage = getFlagImageId(result)

        if (baseFlagImage != null) {
            baseFlag.setImageResource(baseFlagImage)
        }

        if (resultFlagImage != null) {
            resultFlag.setImageResource(resultFlagImage)
        }
    }

    private fun getFlagImageId(currencyCode: CurrencyCode): Int? {
        return context?.resources?.getIdentifier(currencyCode.getCurrencyCodeToLowerCase() + FLAG_IMAGE_NAME, DRAWABLE, context?.packageName)
    }
}