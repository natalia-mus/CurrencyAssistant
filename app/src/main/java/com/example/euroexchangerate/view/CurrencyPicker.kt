package com.example.euroexchangerate.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.adapter.CurrencyItemAdapter
import com.example.euroexchangerate.data.CurrencyCode

class CurrencyPicker(
    context: Context,
    private val actualConversion: Pair<CurrencyCode, CurrencyCode>,
    private val onCurrencyChangedAction: OnCurrencyChangedAction
) : Dialog(context) {

    companion object {
        private const val DESIGN_HEIGHT = 731f
        private const val DESIGN_WIDTH = 430f

        private const val DIALOG_HEIGHT = 550f
        private const val DIALOG_WIDTH = 400f
    }


    private lateinit var recyclerView: RecyclerView
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_picker)

        setView()
    }

    private fun setView() {
        recyclerView = findViewById(R.id.currency_picker_recyclerView)
        cancelButton = findViewById(R.id.currency_picker_cancel)

        cancelButton.setOnClickListener() {
            cancel()
        }

        val dialogWindow: ConstraintLayout = findViewById(R.id.currency_picker)
        val layoutParams = dialogWindow.layoutParams
        layoutParams.width = calcHorizontal(DIALOG_WIDTH)
        layoutParams.height = calcVertical(DIALOG_HEIGHT)

        prepareData()
    }

    private fun prepareData() {
        val currenciesSet = CurrencyCode.getAll()
        currenciesSet.remove(actualConversion.first)
        currenciesSet.remove(actualConversion.second)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CurrencyItemAdapter(currenciesSet, context, this, onCurrencyChangedAction)
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