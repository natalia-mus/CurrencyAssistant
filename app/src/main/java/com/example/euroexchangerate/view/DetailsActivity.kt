package com.example.euroexchangerate.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.RateDetails

class DetailsActivity : AppCompatActivity() {

    private var rateDetails: RateDetails? = RateDetails("", "", "")

    private lateinit var rating: TextView
    private lateinit var currencyName: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.hasExtra("rateDetails")) {
            rateDetails = intent.getParcelableExtra("rateDetails")
        }

        setView()
    }

    private fun setView() {
        rating = findViewById(R.id.activity_details_rating)
        currencyName = findViewById(R.id.activity_details_currency_name)
        date = findViewById(R.id.activity_details_date)

        rating.text = rateDetails?.rating
        currencyName.text = rateDetails?.currencyName
        date.text = rateDetails?.date
    }
}