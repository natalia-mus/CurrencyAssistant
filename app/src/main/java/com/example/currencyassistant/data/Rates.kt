package com.example.currencyassistant.data

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

    fun getRateByCurrencyCode(currency: Currency): Double {
        val result: Double

        when (currency) {
            Currency.AED -> result = aED
            Currency.ALL -> result = aLL
            Currency.ANG -> result = aNG
            Currency.AOA -> result = aOA
            Currency.ARS -> result = aRS
            Currency.AUD -> result = aUD
            Currency.BAM -> result = bAM
            Currency.BGN -> result = bGN
            Currency.BOB -> result = bOB
            Currency.BRL -> result = bRL
            Currency.BTC -> result = bTC
            Currency.BYR -> result = bYR
            Currency.CAD -> result = cAD
            Currency.CHF -> result = cHF
            Currency.CLP -> result = cLP
            Currency.CNY -> result = cNY
            Currency.COP -> result = cOP
            Currency.CRC -> result = cRC
            Currency.CUP -> result = cUP
            Currency.CZK -> result = cZK
            Currency.DKK -> result = dKK
            Currency.EGP -> result = eGP
            Currency.EUR -> result = 1.0
            Currency.GBP -> result = gBP
            Currency.GEL -> result = gEL
            Currency.GIP -> result = gIP
            Currency.HNL -> result = hNL
            Currency.HRK -> result = hRK
            Currency.HUF -> result = hUF
            Currency.IDR -> result = iDR
            Currency.ILS -> result = iLS
            Currency.INR -> result = iNR
            Currency.JPY -> result = jPY
            Currency.KRW -> result = kRW
            Currency.KWD -> result = kWD
            Currency.KZT -> result = kZT
            Currency.LYD -> result = lYD
            Currency.MAD -> result = mAD
            Currency.MDL -> result = mDL
            Currency.MNT -> result = mNT
            Currency.MXN -> result = mXN
            Currency.MYR -> result = mYR
            Currency.NGN -> result = nGN
            Currency.NOK -> result = nOK
            Currency.NZD -> result = nZD
            Currency.OMR -> result = oMR
            Currency.PAB -> result = pAB
            Currency.PEN -> result = pEN
            Currency.PHP -> result = pHP
            Currency.PLN -> result = pLN
            Currency.PYG -> result = pYG
            Currency.QAR -> result = qAR
            Currency.RUB -> result = rUB
            Currency.SAR -> result = sAR
            Currency.SEK -> result = sEK
            Currency.SGD -> result = sGD
            Currency.SLL -> result = sLL
            Currency.SYP -> result = sYP
            Currency.THB -> result = tHB
            Currency.TND -> result = tND
            Currency.UAH -> result = uAH
            Currency.USD -> result = uSD
            Currency.VEF -> result = vEF
            Currency.VND -> result = vND
            Currency.YER -> result = yER
            Currency.ZAR -> result = zAR
            Currency.ZMW -> result = zMW
        }

        return result
    }
}