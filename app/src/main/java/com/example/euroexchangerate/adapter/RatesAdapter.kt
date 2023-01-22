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

    init {
        val aed = RateDetails(context.getString(R.string.aed), _rates?.aED.toString(), date)
        val all = RateDetails(context.getString(R.string.all), _rates?.aLL.toString(), date)
        val ang = RateDetails(context.getString(R.string.ang), _rates?.aNG.toString(), date)
        val aoa = RateDetails(context.getString(R.string.aoa), _rates?.aOA.toString(), date)
        val ars = RateDetails(context.getString(R.string.ars), _rates?.aRS.toString(), date)
        val aud = RateDetails(context.getString(R.string.aud), _rates?.aUD.toString(), date)
        val bam = RateDetails(context.getString(R.string.bam), _rates?.bAM.toString(), date)
        val bgn = RateDetails(context.getString(R.string.bgn), _rates?.bGN.toString(), date)
        val bob = RateDetails(context.getString(R.string.bob), _rates?.bOB.toString(), date)
        val brl = RateDetails(context.getString(R.string.brl), _rates?.bRL.toString(), date)
        val btc = RateDetails(context.getString(R.string.btc), _rates?.bTC.toString(), date)
        val byr = RateDetails(context.getString(R.string.byr), _rates?.bYR.toString(), date)
        val cad = RateDetails(context.getString(R.string.cad), _rates?.cAD.toString(), date)
        val chf = RateDetails(context.getString(R.string.chf), _rates?.cHF.toString(), date)
        val clp = RateDetails(context.getString(R.string.clp), _rates?.cLP.toString(), date)
        val cny = RateDetails(context.getString(R.string.cny), _rates?.cNY.toString(), date)
        val cop = RateDetails(context.getString(R.string.cop), _rates?.cOP.toString(), date)
        val crc = RateDetails(context.getString(R.string.crc), _rates?.cRC.toString(), date)
        val cup = RateDetails(context.getString(R.string.cup), _rates?.cUP.toString(), date)
        val czk = RateDetails(context.getString(R.string.czk), _rates?.cZK.toString(), date)
        val dkk = RateDetails(context.getString(R.string.dkk), _rates?.dKK.toString(), date)
        val egp = RateDetails(context.getString(R.string.egp), _rates?.eGP.toString(), date)
        val gbp = RateDetails(context.getString(R.string.gbp), _rates?.gBP.toString(), date)
        val gel = RateDetails(context.getString(R.string.gel), _rates?.gEL.toString(), date)
        val gip = RateDetails(context.getString(R.string.gip), _rates?.gIP.toString(), date)
        val hnl = RateDetails(context.getString(R.string.hnl), _rates?.hNL.toString(), date)
        val hrk = RateDetails(context.getString(R.string.hrk), _rates?.hRK.toString(), date)
        val huf = RateDetails(context.getString(R.string.huf), _rates?.hUF.toString(), date)
        val idr = RateDetails(context.getString(R.string.idr), _rates?.iDR.toString(), date)
        val ils = RateDetails(context.getString(R.string.ils), _rates?.iLS.toString(), date)
        val inr = RateDetails(context.getString(R.string.inr), _rates?.iNR.toString(), date)
        val jpy = RateDetails(context.getString(R.string.jpy), _rates?.jPY.toString(), date)
        val krw = RateDetails(context.getString(R.string.krw), _rates?.kRW.toString(), date)
        val kwd = RateDetails(context.getString(R.string.kwd), _rates?.kWD.toString(), date)
        val kzt = RateDetails(context.getString(R.string.kzt), _rates?.kZT.toString(), date)
        val lyd = RateDetails(context.getString(R.string.lyd), _rates?.lYD.toString(), date)
        val mad = RateDetails(context.getString(R.string.mad), _rates?.mAD.toString(), date)
        val mdl = RateDetails(context.getString(R.string.mdl), _rates?.mDL.toString(), date)
        val mnt = RateDetails(context.getString(R.string.mnt), _rates?.mNT.toString(), date)
        val mxn = RateDetails(context.getString(R.string.mxn), _rates?.mXN.toString(), date)
        val myr = RateDetails(context.getString(R.string.myr), _rates?.mYR.toString(), date)
        val ngn = RateDetails(context.getString(R.string.ngn), _rates?.nGN.toString(), date)
        val nok = RateDetails(context.getString(R.string.nok), _rates?.nOK.toString(), date)
        val nzd = RateDetails(context.getString(R.string.nzd), _rates?.nZD.toString(), date)
        val omr = RateDetails(context.getString(R.string.omr), _rates?.oMR.toString(), date)
        val pab = RateDetails(context.getString(R.string.pab), _rates?.pAB.toString(), date)
        val pen = RateDetails(context.getString(R.string.pen), _rates?.pEN.toString(), date)
        val php = RateDetails(context.getString(R.string.php), _rates?.pHP.toString(), date)
        val pln = RateDetails(context.getString(R.string.pln), _rates?.pLN.toString(), date)
        val pyg = RateDetails(context.getString(R.string.pyg), _rates?.pYG.toString(), date)
        val qar = RateDetails(context.getString(R.string.qar), _rates?.qAR.toString(), date)
        val rub = RateDetails(context.getString(R.string.rub), _rates?.rUB.toString(), date)
        val sar = RateDetails(context.getString(R.string.sar), _rates?.sAR.toString(), date)
        val sek = RateDetails(context.getString(R.string.sek), _rates?.sEK.toString(), date)
        val sgd = RateDetails(context.getString(R.string.sgd), _rates?.sGD.toString(), date)
        val sll = RateDetails(context.getString(R.string.sll), _rates?.sLL.toString(), date)
        val syp = RateDetails(context.getString(R.string.syp), _rates?.sYP.toString(), date)
        val thb = RateDetails(context.getString(R.string.thb), _rates?.tHB.toString(), date)
        val tnd = RateDetails(context.getString(R.string.tnd), _rates?.tND.toString(), date)
        val uah = RateDetails(context.getString(R.string.uah), _rates?.uAH.toString(), date)
        val usd = RateDetails(context.getString(R.string.usd), _rates?.uSD.toString(), date)
        val vef = RateDetails(context.getString(R.string.vef), _rates?.vEF.toString(), date)
        val vnd = RateDetails(context.getString(R.string.vnd), _rates?.vND.toString(), date)
        val yer = RateDetails(context.getString(R.string.yer), _rates?.yER.toString(), date)
        val zar = RateDetails(context.getString(R.string.zar), _rates?.zAR.toString(), date)
        val zmw = RateDetails(context.getString(R.string.zmw), _rates?.zMW.toString(), date)

        rates.add(aed)
        rates.add(all)
        rates.add(ang)
        rates.add(aoa)
        rates.add(ars)
        rates.add(aud)
        rates.add(bam)
        rates.add(bgn)
        rates.add(bob)
        rates.add(brl)
        rates.add(btc)
        rates.add(byr)
        rates.add(cad)
        rates.add(chf)
        rates.add(clp)
        rates.add(cny)
        rates.add(cop)
        rates.add(crc)
        rates.add(cup)
        rates.add(czk)
        rates.add(dkk)
        rates.add(egp)
        rates.add(gbp)
        rates.add(gel)
        rates.add(gip)
        rates.add(hnl)
        rates.add(hrk)
        rates.add(huf)
        rates.add(idr)
        rates.add(ils)
        rates.add(inr)
        rates.add(jpy)
        rates.add(krw)
        rates.add(kwd)
        rates.add(kzt)
        rates.add(lyd)
        rates.add(mad)
        rates.add(mdl)
        rates.add(mnt)
        rates.add(mxn)
        rates.add(myr)
        rates.add(ngn)
        rates.add(nok)
        rates.add(nzd)
        rates.add(omr)
        rates.add(pab)
        rates.add(pen)
        rates.add(php)
        rates.add(pln)
        rates.add(pyg)
        rates.add(qar)
        rates.add(rub)
        rates.add(sar)
        rates.add(sek)
        rates.add(sgd)
        rates.add(sll)
        rates.add(syp)
        rates.add(thb)
        rates.add(tnd)
        rates.add(uah)
        rates.add(usd)
        rates.add(vef)
        rates.add(vnd)
        rates.add(yer)
        rates.add(zar)
        rates.add(zmw)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        return RatesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rate_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        holder.currencyName.text = rates[position]?.currencyName
        holder.rating.text = rates[position]?.rating

        holder.row.setOnClickListener() {
            val currencyName = rates[position]?.currencyName.toString()
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