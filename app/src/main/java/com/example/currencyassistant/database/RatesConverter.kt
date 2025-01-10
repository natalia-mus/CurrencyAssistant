package com.example.currencyassistant.database

import androidx.room.TypeConverter
import com.example.currencyassistant.data.Currency
import com.example.currencyassistant.data.Rates

class RatesConverter {

    companion object {
        private const val valueSeparator = ':'
        private const val currencySeparator = ','
    }

    @TypeConverter
    fun ratesToString(rates: Rates): String {
        var result = Currency.AED.name + valueSeparator + rates.aED + currencySeparator
        result += Currency.ALL.name + valueSeparator + rates.aLL + currencySeparator
        result += Currency.ANG.name + valueSeparator + rates.aNG + currencySeparator
        result += Currency.AOA.name + valueSeparator + rates.aOA + currencySeparator
        result += Currency.ARS.name + valueSeparator + rates.aRS + currencySeparator
        result += Currency.AUD.name + valueSeparator + rates.aUD + currencySeparator
        result += Currency.BAM.name + valueSeparator + rates.bAM + currencySeparator
        result += Currency.BGN.name + valueSeparator + rates.bGN + currencySeparator
        result += Currency.BOB.name + valueSeparator + rates.bOB + currencySeparator
        result += Currency.BRL.name + valueSeparator + rates.bRL + currencySeparator
        result += Currency.BTC.name + valueSeparator + rates.bTC + currencySeparator
        result += Currency.BYR.name + valueSeparator + rates.bYR + currencySeparator
        result += Currency.CAD.name + valueSeparator + rates.cAD + currencySeparator
        result += Currency.CHF.name + valueSeparator + rates.cHF + currencySeparator
        result += Currency.CLP.name + valueSeparator + rates.cLP + currencySeparator
        result += Currency.CNY.name + valueSeparator + rates.cNY + currencySeparator
        result += Currency.COP.name + valueSeparator + rates.cOP + currencySeparator
        result += Currency.CRC.name + valueSeparator + rates.cRC + currencySeparator
        result += Currency.CUP.name + valueSeparator + rates.cUP + currencySeparator
        result += Currency.CZK.name + valueSeparator + rates.cZK + currencySeparator
        result += Currency.DKK.name + valueSeparator + rates.dKK + currencySeparator
        result += Currency.EGP.name + valueSeparator + rates.eGP + currencySeparator
        result += Currency.GBP.name + valueSeparator + rates.gBP + currencySeparator
        result += Currency.GEL.name + valueSeparator + rates.gEL + currencySeparator
        result += Currency.GIP.name + valueSeparator + rates.gIP + currencySeparator
        result += Currency.HNL.name + valueSeparator + rates.hNL + currencySeparator
        result += Currency.HRK.name + valueSeparator + rates.hRK + currencySeparator
        result += Currency.HUF.name + valueSeparator + rates.hUF + currencySeparator
        result += Currency.IDR.name + valueSeparator + rates.iDR + currencySeparator
        result += Currency.ILS.name + valueSeparator + rates.iLS + currencySeparator
        result += Currency.INR.name + valueSeparator + rates.iNR + currencySeparator
        result += Currency.JPY.name + valueSeparator + rates.jPY + currencySeparator
        result += Currency.KRW.name + valueSeparator + rates.kRW + currencySeparator
        result += Currency.KWD.name + valueSeparator + rates.kWD + currencySeparator
        result += Currency.KZT.name + valueSeparator + rates.kZT + currencySeparator
        result += Currency.LYD.name + valueSeparator + rates.lYD + currencySeparator
        result += Currency.MAD.name + valueSeparator + rates.mAD + currencySeparator
        result += Currency.MDL.name + valueSeparator + rates.mDL + currencySeparator
        result += Currency.MNT.name + valueSeparator + rates.mNT + currencySeparator
        result += Currency.MXN.name + valueSeparator + rates.mXN + currencySeparator
        result += Currency.MYR.name + valueSeparator + rates.mYR + currencySeparator
        result += Currency.NGN.name + valueSeparator + rates.nGN + currencySeparator
        result += Currency.NOK.name + valueSeparator + rates.nOK + currencySeparator
        result += Currency.NZD.name + valueSeparator + rates.nZD + currencySeparator
        result += Currency.OMR.name + valueSeparator + rates.oMR + currencySeparator
        result += Currency.PAB.name + valueSeparator + rates.pAB + currencySeparator
        result += Currency.PEN.name + valueSeparator + rates.pEN + currencySeparator
        result += Currency.PHP.name + valueSeparator + rates.pHP + currencySeparator
        result += Currency.PLN.name + valueSeparator + rates.pLN + currencySeparator
        result += Currency.PYG.name + valueSeparator + rates.pYG + currencySeparator
        result += Currency.QAR.name + valueSeparator + rates.qAR + currencySeparator
        result += Currency.RUB.name + valueSeparator + rates.rUB + currencySeparator
        result += Currency.SAR.name + valueSeparator + rates.sAR + currencySeparator
        result += Currency.SEK.name + valueSeparator + rates.sEK + currencySeparator
        result += Currency.SGD.name + valueSeparator + rates.sGD + currencySeparator
        result += Currency.SLL.name + valueSeparator + rates.sLL + currencySeparator
        result += Currency.SYP.name + valueSeparator + rates.sYP + currencySeparator
        result += Currency.THB.name + valueSeparator + rates.tHB + currencySeparator
        result += Currency.TND.name + valueSeparator + rates.tND + currencySeparator
        result += Currency.UAH.name + valueSeparator + rates.uAH + currencySeparator
        result += Currency.USD.name + valueSeparator + rates.uSD + currencySeparator
        result += Currency.VEF.name + valueSeparator + rates.vEF + currencySeparator
        result += Currency.VND.name + valueSeparator + rates.vND + currencySeparator
        result += Currency.YER.name + valueSeparator + rates.yER + currencySeparator
        result += Currency.ZAR.name + valueSeparator + rates.zAR + currencySeparator
        result += Currency.ZMW.name + valueSeparator + rates.zMW

        return result
    }

    @TypeConverter
    fun stringToRates(ratesAsString: String): Rates? {
        val aed = getValueByCurrencyCode(ratesAsString, Currency.AED)
        val all = getValueByCurrencyCode(ratesAsString, Currency.ALL)
        val ang = getValueByCurrencyCode(ratesAsString, Currency.ANG)
        val aoa = getValueByCurrencyCode(ratesAsString, Currency.AOA)
        val ars = getValueByCurrencyCode(ratesAsString, Currency.ARS)
        val aud = getValueByCurrencyCode(ratesAsString, Currency.AUD)
        val bam = getValueByCurrencyCode(ratesAsString, Currency.BAM)
        val bgn = getValueByCurrencyCode(ratesAsString, Currency.BGN)
        val bob = getValueByCurrencyCode(ratesAsString, Currency.BOB)
        val brl = getValueByCurrencyCode(ratesAsString, Currency.BRL)
        val btc = getValueByCurrencyCode(ratesAsString, Currency.BTC)
        val byr = getValueByCurrencyCode(ratesAsString, Currency.BYR)
        val cad = getValueByCurrencyCode(ratesAsString, Currency.CAD)
        val chf = getValueByCurrencyCode(ratesAsString, Currency.CHF)
        val clp = getValueByCurrencyCode(ratesAsString, Currency.CLP)
        val cny = getValueByCurrencyCode(ratesAsString, Currency.CNY)
        val cop = getValueByCurrencyCode(ratesAsString, Currency.COP)
        val crc = getValueByCurrencyCode(ratesAsString, Currency.CRC)
        val cup = getValueByCurrencyCode(ratesAsString, Currency.CUP)
        val czk = getValueByCurrencyCode(ratesAsString, Currency.CZK)
        val dkk = getValueByCurrencyCode(ratesAsString, Currency.DKK)
        val egp = getValueByCurrencyCode(ratesAsString, Currency.EGP)
        val gbp = getValueByCurrencyCode(ratesAsString, Currency.GBP)
        val gel = getValueByCurrencyCode(ratesAsString, Currency.GEL)
        val gip = getValueByCurrencyCode(ratesAsString, Currency.GIP)
        val hnl = getValueByCurrencyCode(ratesAsString, Currency.HNL)
        val hrk = getValueByCurrencyCode(ratesAsString, Currency.HRK)
        val huf = getValueByCurrencyCode(ratesAsString, Currency.HUF)
        val idr = getValueByCurrencyCode(ratesAsString, Currency.IDR)
        val ils = getValueByCurrencyCode(ratesAsString, Currency.ILS)
        val inr = getValueByCurrencyCode(ratesAsString, Currency.INR)
        val jpy = getValueByCurrencyCode(ratesAsString, Currency.JPY)
        val krw = getValueByCurrencyCode(ratesAsString, Currency.KRW)
        val kwd = getValueByCurrencyCode(ratesAsString, Currency.KWD)
        val kzt = getValueByCurrencyCode(ratesAsString, Currency.KZT)
        val lyd = getValueByCurrencyCode(ratesAsString, Currency.LYD)
        val mad = getValueByCurrencyCode(ratesAsString, Currency.MAD)
        val mdl = getValueByCurrencyCode(ratesAsString, Currency.MDL)
        val mnt = getValueByCurrencyCode(ratesAsString, Currency.MNT)
        val mxn = getValueByCurrencyCode(ratesAsString, Currency.MXN)
        val myr = getValueByCurrencyCode(ratesAsString, Currency.MYR)
        val ngn = getValueByCurrencyCode(ratesAsString, Currency.NGN)
        val nok = getValueByCurrencyCode(ratesAsString, Currency.NOK)
        val nzd = getValueByCurrencyCode(ratesAsString, Currency.NZD)
        val omr = getValueByCurrencyCode(ratesAsString, Currency.OMR)
        val pab = getValueByCurrencyCode(ratesAsString, Currency.PAB)
        val pen = getValueByCurrencyCode(ratesAsString, Currency.PEN)
        val php = getValueByCurrencyCode(ratesAsString, Currency.PHP)
        val pln = getValueByCurrencyCode(ratesAsString, Currency.PLN)
        val pyg = getValueByCurrencyCode(ratesAsString, Currency.PYG)
        val qar = getValueByCurrencyCode(ratesAsString, Currency.QAR)
        val rub = getValueByCurrencyCode(ratesAsString, Currency.RUB)
        val sar = getValueByCurrencyCode(ratesAsString, Currency.SAR)
        val sek = getValueByCurrencyCode(ratesAsString, Currency.SEK)
        val sgd = getValueByCurrencyCode(ratesAsString, Currency.SGD)
        val sll = getValueByCurrencyCode(ratesAsString, Currency.SLL)
        val syp = getValueByCurrencyCode(ratesAsString, Currency.SYP)
        val thb = getValueByCurrencyCode(ratesAsString, Currency.THB)
        val tnd = getValueByCurrencyCode(ratesAsString, Currency.TND)
        val uah = getValueByCurrencyCode(ratesAsString, Currency.UAH)
        val usd = getValueByCurrencyCode(ratesAsString, Currency.USD)
        val vef = getValueByCurrencyCode(ratesAsString, Currency.VEF)
        val vnd = getValueByCurrencyCode(ratesAsString, Currency.VND)
        val yer = getValueByCurrencyCode(ratesAsString, Currency.YER)
        val zar = getValueByCurrencyCode(ratesAsString, Currency.ZAR)
        val zmw = getValueByCurrencyCode(ratesAsString, Currency.ZMW)

        if (aed != null && all != null && ang != null && aoa != null && ars != null && aud != null && bam != null && bgn != null && bob != null && brl != null && btc != null &&
            byr != null && cad != null && chf != null && clp != null && cny != null && cop != null && crc != null && cup != null && czk != null && dkk != null && egp != null &&
            gbp != null && gel != null && gip != null && hnl != null && hrk != null && huf != null && idr != null && ils != null && inr != null && jpy != null && krw != null &&
            kwd != null && kzt != null && lyd != null && mad != null && mdl != null && mnt != null && mxn != null && myr != null && ngn != null && nok != null && nzd != null &&
            omr != null && pab != null && pen != null && php != null && pln != null && pyg != null && qar != null && rub != null && sar != null && sek != null && sgd != null &&
            sll != null && syp != null && thb != null && tnd != null && uah != null && usd != null && vef != null && vnd != null && yer != null && zar != null && zmw != null
        ) {
            return Rates(
                aed,
                all,
                ang,
                aoa,
                ars,
                aud,
                bam,
                bgn,
                bob,
                brl,
                btc,
                byr,
                cad,
                chf,
                clp,
                cny,
                cop,
                crc,
                cup,
                czk,
                dkk,
                egp,
                gbp,
                gel,
                gip,
                hnl,
                hrk,
                huf,
                idr,
                ils,
                inr,
                jpy,
                krw,
                kwd,
                kzt,
                lyd,
                mad,
                mdl,
                mnt,
                mxn,
                myr,
                ngn,
                nok,
                nzd,
                omr,
                pab,
                pen,
                php,
                pln,
                pyg,
                qar,
                rub,
                sar,
                sek,
                sgd,
                sll,
                syp,
                thb,
                tnd,
                uah,
                usd,
                vef,
                vnd,
                yer,
                zar,
                zmw
            )
        } else {
            return null
        }
    }

    private fun getValueByCurrencyCode(ratesAsString: String, currency: Currency): Double? {
        val rates = java.lang.StringBuilder(ratesAsString)
        val key = currency.name + valueSeparator

        val keyStart = rates.indexOf(key)
        val keyEnd: Int = keyStart + key.length

        var value = ""
        for (i in keyEnd..rates.lastIndex) {
            val char = rates[i]
            if (char != currencySeparator) {
                value += char
            } else break
        }

        return value.toDoubleOrNull()
    }
}