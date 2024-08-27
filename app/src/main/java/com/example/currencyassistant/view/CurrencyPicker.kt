package com.example.currencyassistant.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyassistant.R
import com.example.currencyassistant.adapter.CurrencyItemAdapter
import com.example.currencyassistant.data.Currency

class CurrencyPicker(context: Context) : Dialog(context, R.id.currency_picker, DIALOG_WIDTH, DIALOG_HEIGHT), OnCurrencyChangedAction {

    companion object {
        private const val DIALOG_WIDTH = 400f
        private const val DIALOG_HEIGHT = 550f
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    private var actualDefaultCurrency: Currency? = null
    private var actualConversion: Pair<Currency, Currency>? = null
    private var onCurrencyChangedAction: OnCurrencyChangedAction? = null
    private var newDefaultCurrency: Currency? = null


    constructor(context: Context, actualDefaultCurrency: Currency, onCurrencyChangedAction: OnCurrencyChangedAction) : this(context) {
        this.actualDefaultCurrency = actualDefaultCurrency
        this.newDefaultCurrency = actualDefaultCurrency
        this.onCurrencyChangedAction = onCurrencyChangedAction
    }

    constructor(context: Context, actualConversion: Pair<Currency, Currency>?, onCurrencyChangedAction: OnCurrencyChangedAction) : this(context) {
        this.actualConversion = actualConversion
        this.onCurrencyChangedAction = onCurrencyChangedAction
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.currency_picker)
        super.onCreate(savedInstanceState)
        setView()
    }

    override fun changeCurrency(currency: Currency) {
        newDefaultCurrency = currency
    }

    private fun setView() {
        recyclerView = findViewById(R.id.currency_picker_recyclerView)
        cancelButton = findViewById(R.id.currency_picker_cancel)

        cancelButton.setOnClickListener {
            cancel()
        }

        if (actualConversion == null) {
            saveButton = findViewById(R.id.currency_picker_save)
            saveButton.visibility = View.VISIBLE

            saveButton.setOnClickListener {
                newDefaultCurrency?.let { currency -> onCurrencyChangedAction!!.changeCurrency(currency) }
                dismiss()
            }

        } else {
            cancelButton.setBackgroundColor(context.resources.getColor(R.color.green_light, context.theme))
        }

        prepareData()
    }

    private fun prepareData() {
        val currenciesSet = Currency.getAll()

        if (actualConversion != null) {
            currenciesSet.remove(actualConversion!!.first)
            currenciesSet.remove(actualConversion!!.second)

            if (onCurrencyChangedAction != null) {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = CurrencyItemAdapter(currenciesSet, context, onCurrencyChangedAction!!, actualDefaultCurrency)
            }

        } else {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = CurrencyItemAdapter(currenciesSet, context, this, actualDefaultCurrency)
        }
    }

}