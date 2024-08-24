package com.example.currencyassistant.view

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyassistant.Constants
import com.example.currencyassistant.R
import com.example.currencyassistant.data.RateDetails
import com.example.currencyassistant.util.Converter

class DetailsActivity : AppCompatActivity() {

    companion object {
        private const val CHARACTERS_FIRST_LIMIT = 5
        private const val CHARACTERS_SECOND_LIMIT = 6
    }

    private lateinit var rateDetails: RateDetails

    private lateinit var flag: ImageView
    private lateinit var rating: TextView
    private lateinit var currencyCode: TextView
    private lateinit var currencyName: TextView
    private lateinit var date: TextView
    private lateinit var timeRangeButton: Button

    private var formattedRating = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.hasExtra(Constants.RATE_DETAILS)) {
            val rateDetails = intent.getParcelableExtra(Constants.RATE_DETAILS) as RateDetails?

            if (rateDetails != null) {
                this.rateDetails = rateDetails
                formattedRating = Converter.formatValueToString(rateDetails.rating)
                setView()
            }
        }
    }

    private fun openTimeRangePicker() {
        val timeRangePicker = TimeRangePicker(this)
        timeRangePicker.show()
    }

    private fun setTextSize() {
        if (formattedRating.contains(".")) {
            if (formattedRating.length == CHARACTERS_FIRST_LIMIT + 1) {
                rating.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.converter_value_text_size_small))
            } else if (formattedRating.length >= CHARACTERS_SECOND_LIMIT + 1) {
                rating.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.converter_value_text_size_tiny))
            }
        } else {
            if (formattedRating.length == CHARACTERS_FIRST_LIMIT) {
                rating.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.converter_value_text_size_small))
            } else if (formattedRating.length >= CHARACTERS_SECOND_LIMIT) {
                rating.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.converter_value_text_size_tiny))
            }
        }
    }

    private fun setView() {
        flag = findViewById(R.id.activity_details_flag)
        rating = findViewById(R.id.activity_details_rating)
        currencyCode = findViewById(R.id.activity_details_currency_code)
        currencyName = findViewById(R.id.activity_details_currency_name)
        date = findViewById(R.id.activity_details_date)
        timeRangeButton = findViewById(R.id.activity_details_time_range)

        rating.text = formattedRating
        currencyCode.text = rateDetails.currency.name
        currencyName.text = rateDetails.currency.currencyName
        date.text = rateDetails.date

        val flagId = rateDetails.currency.getFlagImageId(this)
        flagId?.let { flag.setImageResource(flagId) }

        setTextSize()

        timeRangeButton.setOnClickListener {
            openTimeRangePicker()
        }
    }
}