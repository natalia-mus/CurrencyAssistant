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
        val aed = RateDetails(context.getString(R.string.aed), _rates?.aWG.toString(), date)
        val ang = RateDetails(context.getString(R.string.ang), _rates?.aWG.toString(), date)
        val aoa = RateDetails(context.getString(R.string.aoa), _rates?.aOA.toString(), date)
        val awg = RateDetails(context.getString(R.string.awg), _rates?.aWG.toString(), date)
        val bam = RateDetails(context.getString(R.string.bam), _rates?.bAM.toString(), date)
        val bob = RateDetails(context.getString(R.string.bob), _rates?.bOB.toString(), date)
        val btc = RateDetails(context.getString(R.string.btc), _rates?.bYN.toString(), date)
        val chf = RateDetails(context.getString(R.string.chf), _rates?.cHF.toString(), date)
        val clf = RateDetails(context.getString(R.string.clf), _rates?.cLF.toString(), date)
        val cop = RateDetails(context.getString(R.string.cop), _rates?.cOP.toString(), date)
        val czk = RateDetails(context.getString(R.string.czk), _rates?.cZK.toString(), date)
        val dkk = RateDetails(context.getString(R.string.dkk), _rates?.dKK.toString(), date)
        val egp = RateDetails(context.getString(R.string.egp), _rates?.eGP.toString(), date)
        val gbp = RateDetails(context.getString(R.string.gbp), _rates?.gBP.toString(), date)
        val ghs = RateDetails(context.getString(R.string.ghs), _rates?.gHS.toString(), date)
        val gip = RateDetails(context.getString(R.string.gip), _rates?.gIP.toString(), date)
        val gyd = RateDetails(context.getString(R.string.gyd), _rates?.gYD.toString(), date)
        val hnl = RateDetails(context.getString(R.string.hnl), _rates?.hNL.toString(), date)
        val huf = RateDetails(context.getString(R.string.huf), _rates?.hUF.toString(), date)
        val irr = RateDetails(context.getString(R.string.irr), _rates?.iRR.toString(), date)
        val isk = RateDetails(context.getString(R.string.isk), _rates?.iSK.toString(), date)
        val jod = RateDetails(context.getString(R.string.jod), _rates?.jOD.toString(), date)
        val jpy = RateDetails(context.getString(R.string.jpy), _rates?.jPY.toString(), date)
        val kgs = RateDetails(context.getString(R.string.kgs), _rates?.kGS.toString(), date)
        val kmf = RateDetails(context.getString(R.string.kmf), _rates?.kMF.toString(), date)
        val kwd = RateDetails(context.getString(R.string.kwd), _rates?.kWD.toString(), date)
        val kyd = RateDetails(context.getString(R.string.kyd), _rates?.kYD.toString(), date)
        val lak = RateDetails(context.getString(R.string.lak), _rates?.lAK.toString(), date)
        val lbp = RateDetails(context.getString(R.string.lbp), _rates?.lBP.toString(), date)
        val lyd = RateDetails(context.getString(R.string.lyd), _rates?.lYD.toString(), date)
        val mad = RateDetails(context.getString(R.string.mad), _rates?.mAD.toString(), date)
        val mkd = RateDetails(context.getString(R.string.mkd), _rates?.mKD.toString(), date)
        val mur = RateDetails(context.getString(R.string.mur), _rates?.mUR.toString(), date)
        val mxn = RateDetails(context.getString(R.string.mxn), _rates?.mXN.toString(), date)
        val mzn = RateDetails(context.getString(R.string.mzn), _rates?.mZN.toString(), date)
        val nad = RateDetails(context.getString(R.string.nad), _rates?.nAD.toString(), date)
        val nio = RateDetails(context.getString(R.string.nio), _rates?.nIO.toString(), date)
        val nok = RateDetails(context.getString(R.string.nok), _rates?.nOK.toString(), date)
        val omr = RateDetails(context.getString(R.string.omr), _rates?.oMR.toString(), date)
        val pab = RateDetails(context.getString(R.string.pab), _rates?.pAB.toString(), date)
        val php = RateDetails(context.getString(R.string.php), _rates?.pHP.toString(), date)
        val pln = RateDetails(context.getString(R.string.pln), _rates?.pLN.toString(), date)
        val qar = RateDetails(context.getString(R.string.qar), _rates?.qAR.toString(), date)
        val ron = RateDetails(context.getString(R.string.ron), _rates?.rON.toString(), date)
        val rub = RateDetails(context.getString(R.string.rub), _rates?.rUB.toString(), date)
        val sar = RateDetails(context.getString(R.string.sar), _rates?.sAR.toString(), date)
        val sbd = RateDetails(context.getString(R.string.sbd), _rates?.sBD.toString(), date)
        val scr = RateDetails(context.getString(R.string.scr), _rates?.sCR.toString(), date)
        val sll = RateDetails(context.getString(R.string.sll), _rates?.sLL.toString(), date)
        val sos = RateDetails(context.getString(R.string.sos), _rates?.sOS.toString(), date)
        val syp = RateDetails(context.getString(R.string.syp), _rates?.sYP.toString(), date)
        val szl = RateDetails(context.getString(R.string.szl), _rates?.sZL.toString(), date)
        val thb = RateDetails(context.getString(R.string.thb), _rates?.tHB.toString(), date)
        val top = RateDetails(context.getString(R.string.top), _rates?.tOP.toString(), date)
        val uah = RateDetails(context.getString(R.string.uah), _rates?.uAH.toString(), date)
        val usd = RateDetails(context.getString(R.string.usd), _rates?.uSD.toString(), date)
        val vef = RateDetails(context.getString(R.string.vef), _rates?.vEF.toString(), date)
        val vuv = RateDetails(context.getString(R.string.vuv), _rates?.vUV.toString(), date)
        val wst = RateDetails(context.getString(R.string.wst), _rates?.wST.toString(), date)
        val xag = RateDetails(context.getString(R.string.xag), _rates?.xAG.toString(), date)
        val xdr = RateDetails(context.getString(R.string.xdr), _rates?.xDR.toString(), date)
        val xof = RateDetails(context.getString(R.string.xof), _rates?.xOF.toString(), date)
        val yer = RateDetails(context.getString(R.string.yer), _rates?.yER.toString(), date)
        val zar = RateDetails(context.getString(R.string.zar), _rates?.zAR.toString(), date)
        val zmk = RateDetails(context.getString(R.string.zmk), _rates?.zMK.toString(), date)

        rates.add(aed)
        rates.add(ang)
        rates.add(aoa)
        rates.add(awg)
        rates.add(bam)
        rates.add(bob)
        rates.add(btc)
        rates.add(chf)
        rates.add(clf)
        rates.add(cop)
        rates.add(czk)
        rates.add(dkk)
        rates.add(egp)
        rates.add(gbp)
        rates.add(ghs)
        rates.add(gip)
        rates.add(gyd)
        rates.add(hnl)
        rates.add(huf)
        rates.add(irr)
        rates.add(isk)
        rates.add(jod)
        rates.add(jpy)
        rates.add(kgs)
        rates.add(kmf)
        rates.add(kwd)
        rates.add(kyd)
        rates.add(lak)
        rates.add(lbp)
        rates.add(lyd)
        rates.add(mad)
        rates.add(mkd)
        rates.add(mur)
        rates.add(mxn)
        rates.add(mzn)
        rates.add(nad)
        rates.add(nio)
        rates.add(nok)
        rates.add(omr)
        rates.add(pab)
        rates.add(php)
        rates.add(pln)
        rates.add(qar)
        rates.add(ron)
        rates.add(rub)
        rates.add(sar)
        rates.add(sbd)
        rates.add(scr)
        rates.add(sll)
        rates.add(sos)
        rates.add(syp)
        rates.add(szl)
        rates.add(thb)
        rates.add(top)
        rates.add(uah)
        rates.add(usd)
        rates.add(vef)
        rates.add(vuv)
        rates.add(wst)
        rates.add(xag)
        rates.add(xdr)
        rates.add(xof)
        rates.add(yer)
        rates.add(zar)
        rates.add(zmk)
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