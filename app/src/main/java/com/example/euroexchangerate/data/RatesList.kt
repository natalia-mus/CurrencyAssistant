package com.example.euroexchangerate.data

class RatesList(private val singleDay: SingleDay) {

    init {
        createRatesList()
    }

    private lateinit var currencies: ArrayList<RateDetails>


    fun getAllCurrencies(): ArrayList<RateDetails> = currencies

    fun getCurrency(index: Int) = currencies[index]

    fun getDate() = singleDay.date

    fun getImage(currencyCode: String): String? {
        var result: String? = null

        val currencyItem = findCurrencyItem(currencyCode)
        if (currencyItem != null) {
            result = currencyItem.getImagePath()
        }

        return result
    }

    fun getRate(currencyCode: String): Double? {
        var result: Double? = null

        val currencyItem = findCurrencyItem(currencyCode)
        if (currencyItem != null) {
            result = currencyItem.rating
        }

        return result
    }

    fun getSize(): Int = currencies.size

    private fun findCurrencyItem(currencyCode: String): RateDetails? {
        var result: RateDetails? = null

        for (currency in currencies) {
            if (currency.currencyCode == currencyCode) {
                result = currency
                break
            }
        }

        return result
    }


    private fun createRatesList() {
        currencies = ArrayList()

        val aed = RateDetails(CurrencyCode.AED, singleDay.rates.getRateByCurrencyCode(CurrencyCode.AED)!!, singleDay.date)
        val all = RateDetails(CurrencyCode.ALL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ALL)!!, singleDay.date)
        val ang = RateDetails(CurrencyCode.ANG, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ANG)!!, singleDay.date)
        val aoa = RateDetails(CurrencyCode.AOA, singleDay.rates.getRateByCurrencyCode(CurrencyCode.AOA)!!, singleDay.date)
        val ars = RateDetails(CurrencyCode.ARS, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ARS)!!, singleDay.date)
        val aud = RateDetails(CurrencyCode.AUD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.AUD)!!, singleDay.date)
        val bam = RateDetails(CurrencyCode.BAM, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BAM)!!, singleDay.date)
        val bgn = RateDetails(CurrencyCode.BGN, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BGN)!!, singleDay.date)
        val bob = RateDetails(CurrencyCode.BOB, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BOB)!!, singleDay.date)
        val brl = RateDetails(CurrencyCode.BRL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BRL)!!, singleDay.date)
        val btc = RateDetails(CurrencyCode.BTC, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BTC)!!, singleDay.date)
        val byr = RateDetails(CurrencyCode.BYR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.BYR)!!, singleDay.date)
        val cad = RateDetails(CurrencyCode.CAD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CAD)!!, singleDay.date)
        val chf = RateDetails(CurrencyCode.CHF, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CHF)!!, singleDay.date)
        val clp = RateDetails(CurrencyCode.CLP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CLP)!!, singleDay.date)
        val cny = RateDetails(CurrencyCode.CNY, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CNY)!!, singleDay.date)
        val cop = RateDetails(CurrencyCode.COP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.COP)!!, singleDay.date)
        val crc = RateDetails(CurrencyCode.CRC, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CRC)!!, singleDay.date)
        val cup = RateDetails(CurrencyCode.CUP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CUP)!!, singleDay.date)
        val czk = RateDetails(CurrencyCode.CZK, singleDay.rates.getRateByCurrencyCode(CurrencyCode.CZK)!!, singleDay.date)
        val dkk = RateDetails(CurrencyCode.DKK, singleDay.rates.getRateByCurrencyCode(CurrencyCode.DKK)!!, singleDay.date)
        val egp = RateDetails(CurrencyCode.EGP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.EGP)!!, singleDay.date)
        val gbp = RateDetails(CurrencyCode.GBP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.GBP)!!, singleDay.date)
        val gel = RateDetails(CurrencyCode.GEL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.GEL)!!, singleDay.date)
        val gip = RateDetails(CurrencyCode.GIP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.GIP)!!, singleDay.date)
        val hnl = RateDetails(CurrencyCode.HNL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.HNL)!!, singleDay.date)
        val hrk = RateDetails(CurrencyCode.HRK, singleDay.rates.getRateByCurrencyCode(CurrencyCode.HRK)!!, singleDay.date)
        val huf = RateDetails(CurrencyCode.HUF, singleDay.rates.getRateByCurrencyCode(CurrencyCode.HUF)!!, singleDay.date)
        val idr = RateDetails(CurrencyCode.IDR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.IDR)!!, singleDay.date)
        val ils = RateDetails(CurrencyCode.ILS, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ILS)!!, singleDay.date)
        val inr = RateDetails(CurrencyCode.INR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.INR)!!, singleDay.date)
        val jpy = RateDetails(CurrencyCode.JPY, singleDay.rates.getRateByCurrencyCode(CurrencyCode.JPY)!!, singleDay.date)
        val krw = RateDetails(CurrencyCode.KRW, singleDay.rates.getRateByCurrencyCode(CurrencyCode.KRW)!!, singleDay.date)
        val kwd = RateDetails(CurrencyCode.KWD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.KWD)!!, singleDay.date)
        val kzt = RateDetails(CurrencyCode.KZT, singleDay.rates.getRateByCurrencyCode(CurrencyCode.KZT)!!, singleDay.date)
        val lyd = RateDetails(CurrencyCode.LYD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.LYD)!!, singleDay.date)
        val mad = RateDetails(CurrencyCode.MAD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.MAD)!!, singleDay.date)
        val mdl = RateDetails(CurrencyCode.MDL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.MDL)!!, singleDay.date)
        val mnt = RateDetails(CurrencyCode.MNT, singleDay.rates.getRateByCurrencyCode(CurrencyCode.MNT)!!, singleDay.date)
        val mxn = RateDetails(CurrencyCode.MXN, singleDay.rates.getRateByCurrencyCode(CurrencyCode.MXN)!!, singleDay.date)
        val myr = RateDetails(CurrencyCode.MYR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.MYR)!!, singleDay.date)
        val ngn = RateDetails(CurrencyCode.NGN, singleDay.rates.getRateByCurrencyCode(CurrencyCode.NGN)!!, singleDay.date)
        val nok = RateDetails(CurrencyCode.NOK, singleDay.rates.getRateByCurrencyCode(CurrencyCode.NOK)!!, singleDay.date)
        val nzd = RateDetails(CurrencyCode.NZD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.NZD)!!, singleDay.date)
        val omr = RateDetails(CurrencyCode.OMR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.OMR)!!, singleDay.date)
        val pab = RateDetails(CurrencyCode.PAB, singleDay.rates.getRateByCurrencyCode(CurrencyCode.PAB)!!, singleDay.date)
        val pen = RateDetails(CurrencyCode.PEN, singleDay.rates.getRateByCurrencyCode(CurrencyCode.PEN)!!, singleDay.date)
        val php = RateDetails(CurrencyCode.PHP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.PHP)!!, singleDay.date)
        val pln = RateDetails(CurrencyCode.PLN, singleDay.rates.getRateByCurrencyCode(CurrencyCode.PLN)!!, singleDay.date)
        val pyg = RateDetails(CurrencyCode.PYG, singleDay.rates.getRateByCurrencyCode(CurrencyCode.PYG)!!, singleDay.date)
        val qar = RateDetails(CurrencyCode.QAR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.QAR)!!, singleDay.date)
        val rub = RateDetails(CurrencyCode.RUB, singleDay.rates.getRateByCurrencyCode(CurrencyCode.RUB)!!, singleDay.date)
        val sar = RateDetails(CurrencyCode.SAR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.SAR)!!, singleDay.date)
        val sek = RateDetails(CurrencyCode.SEK, singleDay.rates.getRateByCurrencyCode(CurrencyCode.SEK)!!, singleDay.date)
        val sgd = RateDetails(CurrencyCode.SGD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.SGD)!!, singleDay.date)
        val sll = RateDetails(CurrencyCode.SLL, singleDay.rates.getRateByCurrencyCode(CurrencyCode.SLL)!!, singleDay.date)
        val syp = RateDetails(CurrencyCode.SYP, singleDay.rates.getRateByCurrencyCode(CurrencyCode.SYP)!!, singleDay.date)
        val thb = RateDetails(CurrencyCode.THB, singleDay.rates.getRateByCurrencyCode(CurrencyCode.THB)!!, singleDay.date)
        val tnd = RateDetails(CurrencyCode.TND, singleDay.rates.getRateByCurrencyCode(CurrencyCode.TND)!!, singleDay.date)
        val uah = RateDetails(CurrencyCode.UAH, singleDay.rates.getRateByCurrencyCode(CurrencyCode.UAH)!!, singleDay.date)
        val usd = RateDetails(CurrencyCode.USD, singleDay.rates.getRateByCurrencyCode(CurrencyCode.USD)!!, singleDay.date)
        val vef = RateDetails(CurrencyCode.VEF, singleDay.rates.getRateByCurrencyCode(CurrencyCode.VEF)!!, singleDay.date)
        val vnd = RateDetails(CurrencyCode.VND, singleDay.rates.getRateByCurrencyCode(CurrencyCode.VND)!!, singleDay.date)
        val yer = RateDetails(CurrencyCode.YER, singleDay.rates.getRateByCurrencyCode(CurrencyCode.YER)!!, singleDay.date)
        val zar = RateDetails(CurrencyCode.ZAR, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ZAR)!!, singleDay.date)
        val zmw = RateDetails(CurrencyCode.ZMW, singleDay.rates.getRateByCurrencyCode(CurrencyCode.ZMW)!!, singleDay.date)

        currencies.add(aed)
        currencies.add(all)
        currencies.add(ang)
        currencies.add(aoa)
        currencies.add(ars)
        currencies.add(aud)
        currencies.add(bam)
        currencies.add(bgn)
        currencies.add(bob)
        currencies.add(brl)
        currencies.add(btc)
        currencies.add(byr)
        currencies.add(cad)
        currencies.add(chf)
        currencies.add(clp)
        currencies.add(cny)
        currencies.add(cop)
        currencies.add(crc)
        currencies.add(cup)
        currencies.add(czk)
        currencies.add(dkk)
        currencies.add(egp)
        currencies.add(gbp)
        currencies.add(gel)
        currencies.add(gip)
        currencies.add(hnl)
        currencies.add(hrk)
        currencies.add(huf)
        currencies.add(idr)
        currencies.add(ils)
        currencies.add(inr)
        currencies.add(jpy)
        currencies.add(krw)
        currencies.add(kwd)
        currencies.add(kzt)
        currencies.add(lyd)
        currencies.add(mad)
        currencies.add(mdl)
        currencies.add(mnt)
        currencies.add(mxn)
        currencies.add(myr)
        currencies.add(ngn)
        currencies.add(nok)
        currencies.add(nzd)
        currencies.add(omr)
        currencies.add(pab)
        currencies.add(pen)
        currencies.add(php)
        currencies.add(pln)
        currencies.add(pyg)
        currencies.add(qar)
        currencies.add(rub)
        currencies.add(sar)
        currencies.add(sek)
        currencies.add(sgd)
        currencies.add(sll)
        currencies.add(syp)
        currencies.add(thb)
        currencies.add(tnd)
        currencies.add(uah)
        currencies.add(usd)
        currencies.add(vef)
        currencies.add(vnd)
        currencies.add(yer)
        currencies.add(zar)
        currencies.add(zmw)
    }

}