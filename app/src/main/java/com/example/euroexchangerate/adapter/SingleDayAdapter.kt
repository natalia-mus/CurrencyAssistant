package com.example.euroexchangerate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.SingleDay

class SingleDayAdapter(
    private var data: MutableList<SingleDay?>,
    private val context: Context,
    private val onItemClickAction: RatesAdapter.OnItemClickAction
) : RecyclerView.Adapter<SingleDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleDayViewHolder {
        return SingleDayViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_day_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SingleDayViewHolder, position: Int) {
        val date = data[position]?.date
        val rates = data[position]?.rates

        holder.date.text = date

        holder.ratesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.ratesRecyclerView.adapter = RatesAdapter(rates, date, context, onItemClickAction)
    }

    override fun getItemCount() = data.size

    fun dataSetChanged(_data: MutableList<SingleDay?>) {
        data = _data
        notifyDataSetChanged()
    }

}


class SingleDayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val date: TextView = view.findViewById(R.id.single_day_item_date)
    val ratesRecyclerView: RecyclerView = view.findViewById(R.id.single_day_item_recyclerView)
}