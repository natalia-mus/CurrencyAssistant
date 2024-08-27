package com.example.currencyassistant.view

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.example.currencyassistant.R
import com.example.currencyassistant.Settings
import com.example.currencyassistant.TimeRange

class TimeRangePicker(context: Context) : Dialog(context, R.id.time_range_picker, DIALOG_WIDTH, DIALOG_HEIGHT) {

    companion object {
        private const val DIALOG_WIDTH = 400f
        private const val DIALOG_HEIGHT = 220f
    }

    private lateinit var lastWeek: TextView
    private lateinit var lastMonth: TextView
    private lateinit var lastYear: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.time_range_picker)
        super.onCreate(savedInstanceState)
        setView()
    }

    private fun setTimeRange(timeRange: TimeRange) {
        Settings.setTimeRange(timeRange)
        dismiss()
    }

    private fun setView() {
        lastWeek = findViewById(R.id.time_range_picker_last_week)
        lastMonth = findViewById(R.id.time_range_picker_last_month)
        lastYear = findViewById(R.id.time_range_picker_last_year)

        lastWeek.setOnClickListener {
            setTimeRange(TimeRange.LAST_WEEK)
        }

        lastMonth.setOnClickListener {
            setTimeRange(TimeRange.LAST_MONTH)
        }

        lastYear.setOnClickListener {
            setTimeRange(TimeRange.LAST_YEAR)
        }

        selectTimeRange()
    }

    private fun selectTimeRange() {
        var option: TextView = when (Settings.getTimeRange()) {
            TimeRange.LAST_WEEK -> lastWeek
            TimeRange.LAST_MONTH -> lastMonth
            TimeRange.LAST_YEAR -> lastYear
        }

        lastWeek.isSelected = false
        lastMonth.isSelected = false
        lastYear.isSelected = false
        option.isSelected = true
    }
}