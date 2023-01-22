package com.example.euroexchangerate.data

import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("AED")
    val aED: Double,
    @SerializedName("ALL")
    val aLL: Double,
    @SerializedName("ANG")
    val aNG: Double,
    @SerializedName("AOA")
    val aOA: Double,
    @SerializedName("ARS")
    val aRS: Double,
    @SerializedName("AUD")
    val aUD: Double,
    @SerializedName("BAM")
    val bAM: Double,
    @SerializedName("BGN")
    val bGN: Double,
    @SerializedName("BOB")
    val bOB: Double,
    @SerializedName("BRL")
    val bRL: Double,
    @SerializedName("BTC")
    val bTC: Double,
    @SerializedName("BYR")
    val bYR: Double,
    @SerializedName("CAD")
    val cAD: Double,
    @SerializedName("CHF")
    val cHF: Double,
    @SerializedName("CLP")
    val cLP: Double,
    @SerializedName("CNY")
    val cNY: Double,
    @SerializedName("COP")
    val cOP: Double,
    @SerializedName("CRC")
    val cRC: Double,
    @SerializedName("CUP")
    val cUP: Double,
    @SerializedName("CZK")
    val cZK: Double,
    @SerializedName("DKK")
    val dKK: Double,
    @SerializedName("EGP")
    val eGP: Double,
    @SerializedName("GBP")
    val gBP: Double,
    @SerializedName("GEL")
    val gEL: Double,
    @SerializedName("GIP")
    val gIP: Double,
    @SerializedName("HNL")
    val hNL: Double,
    @SerializedName("HRK")
    val hRK: Double,
    @SerializedName("HUF")
    val hUF: Double,
    @SerializedName("IDR")
    val iDR: Double,
    @SerializedName("ILS")
    val iLS: Double,
    @SerializedName("INR")
    val iNR: Double,
    @SerializedName("JPY")
    val jPY: Double,
    @SerializedName("KRW")
    val kRW: Double,
    @SerializedName("KWD")
    val kWD: Double,
    @SerializedName("KZT")
    val kZT: Double,
    @SerializedName("LYD")
    val lYD: Double,
    @SerializedName("MAD")
    val mAD: Double,
    @SerializedName("MDL")
    val mDL: Double,
    @SerializedName("MNT")
    val mNT: Double,
    @SerializedName("MXN")
    val mXN: Double,
    @SerializedName("MYR")
    val mYR: Double,
    @SerializedName("NGN")
    val nGN: Double,
    @SerializedName("NOK")
    val nOK: Double,
    @SerializedName("NZD")
    val nZD: Double,
    @SerializedName("OMR")
    val oMR: Double,
    @SerializedName("PAB")
    val pAB: Double,
    @SerializedName("PEN")
    val pEN: Double,
    @SerializedName("PHP")
    val pHP: Double,
    @SerializedName("PLN")
    val pLN: Double,
    @SerializedName("PYG")
    val pYG: Double,
    @SerializedName("QAR")
    val qAR: Double,
    @SerializedName("RUB")
    val rUB: Double,
    @SerializedName("SAR")
    val sAR: Double,
    @SerializedName("SEK")
    val sEK: Double,
    @SerializedName("SGD")
    val sGD: Double,
    @SerializedName("SLL")
    val sLL: Double,
    @SerializedName("SYP")
    val sYP: Double,
    @SerializedName("THB")
    val tHB: Double,
    @SerializedName("TND")
    val tND: Double,
    @SerializedName("UAH")
    val uAH: Double,
    @SerializedName("USD")
    val uSD: Double,
    @SerializedName("VEF")
    val vEF: Double,
    @SerializedName("VND")
    val vND: Double,
    @SerializedName("YER")
    val yER: Double,
    @SerializedName("ZAR")
    val zAR: Double,
    @SerializedName("ZMW")
    val zMW: Double
) {

    fun getRateByCurrencyCode(currencyCode: String): Double? {
        var result: Double? = null

        when (currencyCode) {
            CurrencyCode.AED -> result = aED
            CurrencyCode.ALL -> result = aLL
            CurrencyCode.ANG -> result = aNG
            CurrencyCode.AOA -> result = aOA
            CurrencyCode.ARS -> result = aRS
            CurrencyCode.AUD -> result = aUD
            CurrencyCode.BAM -> result = bAM
            CurrencyCode.BGN -> result = bGN
            CurrencyCode.BOB -> result = bOB
            CurrencyCode.BRL -> result = bRL
            CurrencyCode.BTC -> result = bTC
            CurrencyCode.BYR -> result = bYR
            CurrencyCode.CAD -> result = cAD
            CurrencyCode.CHF -> result = cHF
            CurrencyCode.CLP -> result = cLP
            CurrencyCode.CNY -> result = cNY
            CurrencyCode.COP -> result = cOP
            CurrencyCode.CRC -> result = cRC
            CurrencyCode.CUP -> result = cUP
            CurrencyCode.CZK -> result = cZK
            CurrencyCode.DKK -> result = dKK
            CurrencyCode.EGP -> result = eGP
            CurrencyCode.GBP -> result = gBP
            CurrencyCode.GEL -> result = gEL
            CurrencyCode.GIP -> result = gIP
            CurrencyCode.HNL -> result = hNL
            CurrencyCode.HRK -> result = hRK
            CurrencyCode.HUF -> result = hUF
            CurrencyCode.IDR -> result = iDR
            CurrencyCode.ILS -> result = iLS
            CurrencyCode.INR -> result = iNR
            CurrencyCode.JPY -> result = jPY
            CurrencyCode.KRW -> result = kRW
            CurrencyCode.KWD -> result = kWD
            CurrencyCode.KZT -> result = kZT
            CurrencyCode.LYD -> result = lYD
            CurrencyCode.MAD -> result = mAD
            CurrencyCode.MDL -> result = mDL
            CurrencyCode.MNT -> result = mNT
            CurrencyCode.MXN -> result = mXN
            CurrencyCode.MYR -> result = mYR
            CurrencyCode.NGN -> result = nGN
            CurrencyCode.NOK -> result = nOK
            CurrencyCode.NZD -> result = nZD
            CurrencyCode.OMR -> result = oMR
            CurrencyCode.PAB -> result = pAB
            CurrencyCode.PEN -> result = pEN
            CurrencyCode.PHP -> result = pHP
            CurrencyCode.PLN -> result = pLN
            CurrencyCode.PYG -> result = pYG
            CurrencyCode.QAR -> result = qAR
            CurrencyCode.RUB -> result = rUB
            CurrencyCode.SAR -> result = sAR
            CurrencyCode.SEK -> result = sEK
            CurrencyCode.SGD -> result = sGD
            CurrencyCode.SLL -> result = sLL
            CurrencyCode.SYP -> result = sYP
            CurrencyCode.THB -> result = tHB
            CurrencyCode.TND -> result = tND
            CurrencyCode.UAH -> result = uAH
            CurrencyCode.USD -> result = uSD
            CurrencyCode.VEF -> result = vEF
            CurrencyCode.VND -> result = vND
            CurrencyCode.YER -> result = yER
            CurrencyCode.ZAR -> result = zAR
            CurrencyCode.ZMW -> result = zMW
        }

        return result
    }
}