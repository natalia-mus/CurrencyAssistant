package com.example.euroexchangerate.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.SingleDayRates

class SingleDayAdapter(
    private var data: MutableList<SingleDayRates>,
    private val context: Context,
    private val onItemClickAction: RatesAdapter.OnItemClickAction
) : RecyclerView.Adapter<SingleDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleDayViewHolder {
        return SingleDayViewHolder(LayoutInflater.from(context).inflate(R.layout.single_day_item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SingleDayViewHolder, position: Int) {
        holder.date.text = data[position].date
        holder.base.text = "1 " + data[position].base

        holder.ratesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.ratesRecyclerView.adapter = RatesAdapter(data[position].getCurrenciesList(), context, onItemClickAction)
    }

    override fun getItemCount() = data.size

    fun dataSetChanged(data: MutableList<SingleDayRates>) {
        this.data = data
        notifyDataSetChanged()
    }

}


class SingleDayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val base: TextView = view.findViewById(R.id.single_day_base)
    val date: TextView = view.findViewById(R.id.single_day_item_date)
    val ratesRecyclerView: RecyclerView = view.findViewById(R.id.single_day_item_recyclerView)
}