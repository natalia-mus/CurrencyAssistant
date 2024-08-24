package com.example.currencyassistant.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.currencyassistant.R
import com.example.currencyassistant.TimeRange

class TimeRangePicker(context: Context) : Dialog(context) {

    companion object {
        private const val DESIGN_HEIGHT = 731f
        private const val DESIGN_WIDTH = 430f

        private const val DIALOG_HEIGHT = 220f
        private const val DIALOG_WIDTH = 400f
    }

    private lateinit var lastWeek: TextView
    private lateinit var lastMonth: TextView
    private lateinit var lastYear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_range_picker)
        setView()
    }

    private fun changeTimeRange(timeRange: TimeRange) {
        // todo
        dismiss()
    }

    private fun setView() {
        lastWeek = findViewById(R.id.time_range_picker_last_week)
        lastMonth = findViewById(R.id.time_range_picker_last_month)
        lastYear = findViewById(R.id.time_range_picker_last_year)

        lastWeek.setOnClickListener {
            changeTimeRange(TimeRange.LAST_WEEK)
        }

        lastMonth.setOnClickListener {
            changeTimeRange(TimeRange.LAST_MONTH)
        }

        lastYear.setOnClickListener {
            changeTimeRange(TimeRange.LAST_YEAR)
        }

        val dialogWindow: ConstraintLayout = findViewById(R.id.time_range_picker)
        val layoutParams = dialogWindow.layoutParams
        layoutParams.width = calcHorizontal(DIALOG_WIDTH)
        layoutParams.height = calcVertical(DIALOG_HEIGHT)
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