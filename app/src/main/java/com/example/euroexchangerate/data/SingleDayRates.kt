package com.example.euroexchangerate.data

data class SingleDayRates(
    val success: Boolean,
    val timestamp: Int,
    val base: String,
    val date: String,
    private val rates: Rates
) {

    private lateinit var currencies: ArrayList<RateDetails>


    fun getCurrenciesList(): ArrayList<RateDetails> {
        if (!::currencies.isInitialized) {

            currencies = ArrayList()
            val aed = RateDetails(CurrencyCode.AED, rates.getRateByCurrencyCode(CurrencyCode.AED), date)
            val all = RateDetails(CurrencyCode.ALL, rates.getRateByCurrencyCode(CurrencyCode.ALL), date)
            val ang = RateDetails(CurrencyCode.ANG, rates.getRateByCurrencyCode(CurrencyCode.ANG), date)
            val aoa = RateDetails(CurrencyCode.AOA, rates.getRateByCurrencyCode(CurrencyCode.AOA), date)
            val ars = RateDetails(CurrencyCode.ARS, rates.getRateByCurrencyCode(CurrencyCode.ARS), date)
            val aud = RateDetails(CurrencyCode.AUD, rates.getRateByCurrencyCode(CurrencyCode.AUD), date)
            val bam = RateDetails(CurrencyCode.BAM, rates.getRateByCurrencyCode(CurrencyCode.BAM), date)
            val bgn = RateDetails(CurrencyCode.BGN, rates.getRateByCurrencyCode(CurrencyCode.BGN), date)
            val bob = RateDetails(CurrencyCode.BOB, rates.getRateByCurrencyCode(CurrencyCode.BOB), date)
            val brl = RateDetails(CurrencyCode.BRL, rates.getRateByCurrencyCode(CurrencyCode.BRL), date)
            val btc = RateDetails(CurrencyCode.BTC, rates.getRateByCurrencyCode(CurrencyCode.BTC), date)
            val byr = RateDetails(CurrencyCode.BYR, rates.getRateByCurrencyCode(CurrencyCode.BYR), date)
            val cad = RateDetails(CurrencyCode.CAD, rates.getRateByCurrencyCode(CurrencyCode.CAD), date)
            val chf = RateDetails(CurrencyCode.CHF, rates.getRateByCurrencyCode(CurrencyCode.CHF), date)
            val clp = RateDetails(CurrencyCode.CLP, rates.getRateByCurrencyCode(CurrencyCode.CLP), date)
            val cny = RateDetails(CurrencyCode.CNY, rates.getRateByCurrencyCode(CurrencyCode.CNY), date)
            val cop = RateDetails(CurrencyCode.COP, rates.getRateByCurrencyCode(CurrencyCode.COP), date)
            val crc = RateDetails(CurrencyCode.CRC, rates.getRateByCurrencyCode(CurrencyCode.CRC), date)
            val cup = RateDetails(CurrencyCode.CUP, rates.getRateByCurrencyCode(CurrencyCode.CUP), date)
            val czk = RateDetails(CurrencyCode.CZK, rates.getRateByCurrencyCode(CurrencyCode.CZK), date)
            val dkk = RateDetails(CurrencyCode.DKK, rates.getRateByCurrencyCode(CurrencyCode.DKK), date)
            val egp = RateDetails(CurrencyCode.EGP, rates.getRateByCurrencyCode(CurrencyCode.EGP), date)
            val gbp = RateDetails(CurrencyCode.GBP, rates.getRateByCurrencyCode(CurrencyCode.GBP), date)
            val gel = RateDetails(CurrencyCode.GEL, rates.getRateByCurrencyCode(CurrencyCode.GEL), date)
            val gip = RateDetails(CurrencyCode.GIP, rates.getRateByCurrencyCode(CurrencyCode.GIP), date)
            val hnl = RateDetails(CurrencyCode.HNL, rates.getRateByCurrencyCode(CurrencyCode.HNL), date)
            val hrk = RateDetails(CurrencyCode.HRK, rates.getRateByCurrencyCode(CurrencyCode.HRK), date)
            val huf = RateDetails(CurrencyCode.HUF, rates.getRateByCurrencyCode(CurrencyCode.HUF), date)
            val idr = RateDetails(CurrencyCode.IDR, rates.getRateByCurrencyCode(CurrencyCode.IDR), date)
            val ils = RateDetails(CurrencyCode.ILS, rates.getRateByCurrencyCode(CurrencyCode.ILS), date)
            val inr = RateDetails(CurrencyCode.INR, rates.getRateByCurrencyCode(CurrencyCode.INR), date)
            val jpy = RateDetails(CurrencyCode.JPY, rates.getRateByCurrencyCode(CurrencyCode.JPY), date)
            val krw = RateDetails(CurrencyCode.KRW, rates.getRateByCurrencyCode(CurrencyCode.KRW), date)
            val kwd = RateDetails(CurrencyCode.KWD, rates.getRateByCurrencyCode(CurrencyCode.KWD), date)
            val kzt = RateDetails(CurrencyCode.KZT, rates.getRateByCurrencyCode(CurrencyCode.KZT), date)
            val lyd = RateDetails(CurrencyCode.LYD, rates.getRateByCurrencyCode(CurrencyCode.LYD), date)
            val mad = RateDetails(CurrencyCode.MAD, rates.getRateByCurrencyCode(CurrencyCode.MAD), date)
            val mdl = RateDetails(CurrencyCode.MDL, rates.getRateByCurrencyCode(CurrencyCode.MDL), date)
            val mnt = RateDetails(CurrencyCode.MNT, rates.getRateByCurrencyCode(CurrencyCode.MNT), date)
            val mxn = RateDetails(CurrencyCode.MXN, rates.getRateByCurrencyCode(CurrencyCode.MXN), date)
            val myr = RateDetails(CurrencyCode.MYR, rates.getRateByCurrencyCode(CurrencyCode.MYR), date)
            val ngn = RateDetails(CurrencyCode.NGN, rates.getRateByCurrencyCode(CurrencyCode.NGN), date)
            val nok = RateDetails(CurrencyCode.NOK, rates.getRateByCurrencyCode(CurrencyCode.NOK), date)
            val nzd = RateDetails(CurrencyCode.NZD, rates.getRateByCurrencyCode(CurrencyCode.NZD), date)
            val omr = RateDetails(CurrencyCode.OMR, rates.getRateByCurrencyCode(CurrencyCode.OMR), date)
            val pab = RateDetails(CurrencyCode.PAB, rates.getRateByCurrencyCode(CurrencyCode.PAB), date)
            val pen = RateDetails(CurrencyCode.PEN, rates.getRateByCurrencyCode(CurrencyCode.PEN), date)
            val php = RateDetails(CurrencyCode.PHP, rates.getRateByCurrencyCode(CurrencyCode.PHP), date)
            val pln = RateDetails(CurrencyCode.PLN, rates.getRateByCurrencyCode(CurrencyCode.PLN), date)
            val pyg = RateDetails(CurrencyCode.PYG, rates.getRateByCurrencyCode(CurrencyCode.PYG), date)
            val qar = RateDetails(CurrencyCode.QAR, rates.getRateByCurrencyCode(CurrencyCode.QAR), date)
            val rub = RateDetails(CurrencyCode.RUB, rates.getRateByCurrencyCode(CurrencyCode.RUB), date)
            val sar = RateDetails(CurrencyCode.SAR, rates.getRateByCurrencyCode(CurrencyCode.SAR), date)
            val sek = RateDetails(CurrencyCode.SEK, rates.getRateByCurrencyCode(CurrencyCode.SEK), date)
            val sgd = RateDetails(CurrencyCode.SGD, rates.getRateByCurrencyCode(CurrencyCode.SGD), date)
            val sll = RateDetails(CurrencyCode.SLL, rates.getRateByCurrencyCode(CurrencyCode.SLL), date)
            val syp = RateDetails(CurrencyCode.SYP, rates.getRateByCurrencyCode(CurrencyCode.SYP), date)
            val thb = RateDetails(CurrencyCode.THB, rates.getRateByCurrencyCode(CurrencyCode.THB), date)
            val tnd = RateDetails(CurrencyCode.TND, rates.getRateByCurrencyCode(CurrencyCode.TND), date)
            val uah = RateDetails(CurrencyCode.UAH, rates.getRateByCurrencyCode(CurrencyCode.UAH), date)
            val usd = RateDetails(CurrencyCode.USD, rates.getRateByCurrencyCode(CurrencyCode.USD), date)
            val vef = RateDetails(CurrencyCode.VEF, rates.getRateByCurrencyCode(CurrencyCode.VEF), date)
            val vnd = RateDetails(CurrencyCode.VND, rates.getRateByCurrencyCode(CurrencyCode.VND), date)
            val yer = RateDetails(CurrencyCode.YER, rates.getRateByCurrencyCode(CurrencyCode.YER), date)
            val zar = RateDetails(CurrencyCode.ZAR, rates.getRateByCurrencyCode(CurrencyCode.ZAR), date)
            val zmw = RateDetails(CurrencyCode.ZMW, rates.getRateByCurrencyCode(CurrencyCode.ZMW), date)

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

        return currencies
    }

    fun getCurrencyByIndex(index: Int) {
        getCurrenciesList()[index]
    }

    fun getImage(currencyCode: CurrencyCode): String? {
        var result: String? = null

        val currencyItem = getCurrencyItemByCode(currencyCode)
        if (currencyItem != null) {
            result = currencyItem.getImagePath()
        }

        return result
    }

    fun getRate(currencyCode: CurrencyCode): Double? {
        var result: Double? = null

        val currencyItem = getCurrencyItemByCode(currencyCode)
        if (currencyItem != null) {
            result = currencyItem.rating
        }

        return result
    }

    fun getSize(): Int = getCurrenciesList().size

    private fun getCurrencyItemByCode(currencyCode: CurrencyCode): RateDetails? {
        var result: RateDetails? = null
        val currenciesList = getCurrenciesList()

        for (currency in currenciesList) {
            if (currency.currencyCode == currencyCode) {
                result = currency
                break
            }
        }

        return result
    }

}