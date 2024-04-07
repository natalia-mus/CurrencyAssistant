package com.example.euroexchangerate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.RateDetails
import com.example.euroexchangerate.util.Converter

class RatesAdapter(
    private val currencies: ArrayList<RateDetails>,
    private val context: Context,
    private val onItemClickAction: OnItemClickAction
) :
    RecyclerView.Adapter<RatesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        return RatesViewHolder(LayoutInflater.from(context).inflate(R.layout.rate_list, parent, false))
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        val rate = currencies[position]

        val flag = rate.currency.getFlagImageId(context)
        if (flag != null) {
            holder.flag.setImageResource(flag)
        }

        holder.currencyCode.text = rate.currency.name
        holder.currencyName.text = rate.currency.currencyName
        holder.rating.text = Converter.formatValueToString(rate.rating)

        holder.row.setOnClickListener() {
            onItemClickAction.itemClicked(rate)
        }
    }

    override fun getItemCount() = currencies.size


    interface OnItemClickAction {
        fun itemClicked(rateDetails: RateDetails)
    }
}


class RatesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val flag: ImageView = view.findViewById(R.id.currency_item_flag)
    val currencyCode: TextView = view.findViewById(R.id.currency_item_code)
    val currencyName: TextView = view.findViewById(R.id.currency_item_name)
    val rating: TextView = view.findViewById(R.id.rate_list_rating)
    val row: LinearLayout = view.findViewById(R.id.rate_list_row)
}