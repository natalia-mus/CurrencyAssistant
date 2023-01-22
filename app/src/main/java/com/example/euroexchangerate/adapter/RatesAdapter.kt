package com.example.euroexchangerate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.RateDetails
import com.example.euroexchangerate.data.Rates

class RatesAdapter(
    _rates: Rates?,
    private val date: String?,
    private val context: Context,
    private val onItemClickAction: OnItemClickAction
) :
    RecyclerView.Adapter<RatesViewHolder>() {
    private var rates: MutableList<RateDetails?> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        return RatesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rate_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        holder.currencyName.text = rates[position]?.currencyCode
        holder.rating.text = rates[position]?.rating

        holder.row.setOnClickListener() {
            val currencyName = rates[position]?.currencyCode.toString()
            val rating = rates[position]?.rating.toString()

            val clickedItem = RateDetails(currencyName, rating, date)

            onItemClickAction.itemClicked(clickedItem)
        }
    }

    override fun getItemCount() = rates.size


    interface OnItemClickAction {
        fun itemClicked(rateDetails: RateDetails)
    }
}


class RatesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val currencyName: TextView = view.findViewById(R.id.rate_list_currency_name)
    val rating: TextView = view.findViewById(R.id.rate_list_rating)
    val row: LinearLayout = view.findViewById(R.id.rate_list_row)
}