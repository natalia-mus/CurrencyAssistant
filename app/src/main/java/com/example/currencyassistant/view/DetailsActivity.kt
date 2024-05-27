package com.example.currencyassistant.view

import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyassistant.Constants
import com.example.currencyassistant.R
import com.example.currencyassistant.data.RateDetails

class DetailsActivity : AppCompatActivity() {

    companion object {
        private const val CHARACTERS_FIRST_LIMIT = 6
        private const val CHARACTERS_SECOND_LIMIT = 7
    }

    private lateinit var rateDetails: RateDetails

    private lateinit var rating: TextView
    private lateinit var currencyName: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.hasExtra(Constants.RATE_DETAILS)) {
            val rateDetails = intent.getParcelableExtra(Constants.RATE_DETAILS) as RateDetails?

            if (rateDetails != null) {
                this.rateDetails = rateDetails
                setView()
            }
        }
    }

    private fun setTextSize() {
        val limit = if (rateDetails.rating.toString().contains(".")) CHARACTERS_SECOND_LIMIT else CHARACTERS_FIRST_LIMIT

        if (rateDetails.rating.toString().length > limit) {
            rating.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.converter_value_text_size))
        }
    }

    private fun setView() {
        rating = findViewById(R.id.activity_details_rating)
        currencyName = findViewById(R.id.activity_details_currency_name)
        date = findViewById(R.id.activity_details_date)

        rating.text = rateDetails.rating.toString()
        currencyName.text = rateDetails.currency.name
        date.text = rateDetails.date

        setTextSize()
    }
}