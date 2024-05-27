package com.example.currencyassistant.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyassistant.R
import com.example.currencyassistant.adapter.CurrencyItemAdapter
import com.example.currencyassistant.data.Currency

class CurrencyPicker(context: Context) : Dialog(context), OnCurrencyChangedAction {

    companion object {
        private const val DESIGN_HEIGHT = 731f
        private const val DESIGN_WIDTH = 430f

        private const val DIALOG_HEIGHT = 550f
        private const val DIALOG_WIDTH = 400f
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

    constructor(context: Context, actualConversion: Pair<Currency, Currency>?, onCurrencyChangedAction: OnCurrencyChangedAction): this(context) {
        this.actualConversion = actualConversion
        this.onCurrencyChangedAction = onCurrencyChangedAction
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_picker)

        setView()
    }

    override fun changeCurrency(currency: Currency) {
        newDefaultCurrency = currency
    }

    private fun setView() {
        recyclerView = findViewById(R.id.currency_picker_recyclerView)
        cancelButton = findViewById(R.id.currency_picker_cancel)

        cancelButton.setOnClickListener() {
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

        val dialogWindow: ConstraintLayout = findViewById(R.id.currency_picker)
        val layoutParams = dialogWindow.layoutParams
        layoutParams.width = calcHorizontal(DIALOG_WIDTH)
        layoutParams.height = calcVertical(DIALOG_HEIGHT)

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

    /**
     * Calculates horizontal dimension according to the device width in order to keep element's scale
     */
    private fun calcHorizontal(value: Float): Int {
        val dpWidth = context.resources.displayMetrics.widthPixels
        return (dpWidth * (value / DESIGN_WIDTH)).toInt()
    }

    /**
     * Calculates vertical dimension according to the device height in order to keep element's scale
     */
    private fun calcVertical(value: Float): Int {
        val dpHeight = context.resources.displayMetrics.heightPixels
        return (dpHeight * (value / DESIGN_HEIGHT)).toInt()
    }

}