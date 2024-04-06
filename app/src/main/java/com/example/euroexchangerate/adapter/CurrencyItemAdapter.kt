package com.example.euroexchangerate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.euroexchangerate.R
import com.example.euroexchangerate.data.Currency
import com.example.euroexchangerate.view.OnCurrencyChangedAction

class CurrencyItemAdapter(
    private val currenciesSet: ArrayList<Currency>,
    private val context: Context,
    private val onCurrencyChangedAction: OnCurrencyChangedAction,
    private var actualDefaultCurrency: Currency?
) : RecyclerView.Adapter<CurrencyItemViewHolder>() {

    private var previouslyCheckedItem: CurrencyItemViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemViewHolder {
        return CurrencyItemViewHolder(LayoutInflater.from(context).inflate(R.layout.currency_item, parent, false))
    }

    override fun onBindViewHolder(holder: CurrencyItemViewHolder, position: Int) {
        val currency = currenciesSet[position]

        holder.currencyCode.text = currency.name
        holder.currencyName.text = currency.currencyName

        val flag = currency.getFlagImageId(context)
        if (flag != null) {
            holder.currencyFlag.setImageResource(flag)
        }

        holder.currencyItem.setOnClickListener() {
            onCurrencyChangedAction.changeCurrency(currency)
            actualDefaultCurrency = currency
            holder.checkSelectedItem(currency, actualDefaultCurrency, previouslyCheckedItem)
            previouslyCheckedItem = holder
        }

        holder.checkSelectedItem(currency, actualDefaultCurrency, null)

        if (currency == actualDefaultCurrency) {
            previouslyCheckedItem = holder
        }
    }

    override fun getItemCount() = currenciesSet.size
}

class CurrencyItemViewHolder(view: View) : ViewHolder(view) {
    val currencyItem: ConstraintLayout = view.findViewById(R.id.currency_item)
    val currencyFlag: ImageView = view.findViewById(R.id.currency_item_flag)
    val currencyCode: TextView = view.findViewById(R.id.currency_item_code)
    val currencyName: TextView = view.findViewById(R.id.currency_item_name)

    fun checkSelectedItem(currency: Currency, actualDefaultCurrency: Currency?, previouslyCheckedItem: CurrencyItemViewHolder?) {
        currencyItem.isSelected = currency == actualDefaultCurrency
        if (previouslyCheckedItem != null) previouslyCheckedItem.currencyItem.isSelected = false
    }
}