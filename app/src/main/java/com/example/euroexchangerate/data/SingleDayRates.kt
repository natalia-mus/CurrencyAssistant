package com.example.euroexchangerate.data

data class SingleDayRates(
    val success: Boolean,
    var base: String,
    val date: String,
    private val rates: Rates
) {

    private lateinit var currencies: ArrayList<RateDetails>


    fun getCurrenciesList(): ArrayList<RateDetails> {
        if (!::currencies.isInitialized) {

            currencies = ArrayList()
            val aed = RateDetails(Currency.AED, rates.getRateByCurrencyCode(Currency.AED), date)
            val all = RateDetails(Currency.ALL, rates.getRateByCurrencyCode(Currency.ALL), date)
            val ang = RateDetails(Currency.ANG, rates.getRateByCurrencyCode(Currency.ANG), date)
            val aoa = RateDetails(Currency.AOA, rates.getRateByCurrencyCode(Currency.AOA), date)
            val ars = RateDetails(Currency.ARS, rates.getRateByCurrencyCode(Currency.ARS), date)
            val aud = RateDetails(Currency.AUD, rates.getRateByCurrencyCode(Currency.AUD), date)
            val bam = RateDetails(Currency.BAM, rates.getRateByCurrencyCode(Currency.BAM), date)
            val bgn = RateDetails(Currency.BGN, rates.getRateByCurrencyCode(Currency.BGN), date)
            val bob = RateDetails(Currency.BOB, rates.getRateByCurrencyCode(Currency.BOB), date)
            val brl = RateDetails(Currency.BRL, rates.getRateByCurrencyCode(Currency.BRL), date)
            val btc = RateDetails(Currency.BTC, rates.getRateByCurrencyCode(Currency.BTC), date)
            val byr = RateDetails(Currency.BYR, rates.getRateByCurrencyCode(Currency.BYR), date)
            val cad = RateDetails(Currency.CAD, rates.getRateByCurrencyCode(Currency.CAD), date)
            val chf = RateDetails(Currency.CHF, rates.getRateByCurrencyCode(Currency.CHF), date)
            val clp = RateDetails(Currency.CLP, rates.getRateByCurrencyCode(Currency.CLP), date)
            val cny = RateDetails(Currency.CNY, rates.getRateByCurrencyCode(Currency.CNY), date)
            val cop = RateDetails(Currency.COP, rates.getRateByCurrencyCode(Currency.COP), date)
            val crc = RateDetails(Currency.CRC, rates.getRateByCurrencyCode(Currency.CRC), date)
            val cup = RateDetails(Currency.CUP, rates.getRateByCurrencyCode(Currency.CUP), date)
            val czk = RateDetails(Currency.CZK, rates.getRateByCurrencyCode(Currency.CZK), date)
            val dkk = RateDetails(Currency.DKK, rates.getRateByCurrencyCode(Currency.DKK), date)
            val egp = RateDetails(Currency.EGP, rates.getRateByCurrencyCode(Currency.EGP), date)
            val gbp = RateDetails(Currency.GBP, rates.getRateByCurrencyCode(Currency.GBP), date)
            val gel = RateDetails(Currency.GEL, rates.getRateByCurrencyCode(Currency.GEL), date)
            val gip = RateDetails(Currency.GIP, rates.getRateByCurrencyCode(Currency.GIP), date)
            val hnl = RateDetails(Currency.HNL, rates.getRateByCurrencyCode(Currency.HNL), date)
            val hrk = RateDetails(Currency.HRK, rates.getRateByCurrencyCode(Currency.HRK), date)
            val huf = RateDetails(Currency.HUF, rates.getRateByCurrencyCode(Currency.HUF), date)
            val idr = RateDetails(Currency.IDR, rates.getRateByCurrencyCode(Currency.IDR), date)
            val ils = RateDetails(Currency.ILS, rates.getRateByCurrencyCode(Currency.ILS), date)
            val inr = RateDetails(Currency.INR, rates.getRateByCurrencyCode(Currency.INR), date)
            val jpy = RateDetails(Currency.JPY, rates.getRateByCurrencyCode(Currency.JPY), date)
            val krw = RateDetails(Currency.KRW, rates.getRateByCurrencyCode(Currency.KRW), date)
            val kwd = RateDetails(Currency.KWD, rates.getRateByCurrencyCode(Currency.KWD), date)
            val kzt = RateDetails(Currency.KZT, rates.getRateByCurrencyCode(Currency.KZT), date)
            val lyd = RateDetails(Currency.LYD, rates.getRateByCurrencyCode(Currency.LYD), date)
            val mad = RateDetails(Currency.MAD, rates.getRateByCurrencyCode(Currency.MAD), date)
            val mdl = RateDetails(Currency.MDL, rates.getRateByCurrencyCode(Currency.MDL), date)
            val mnt = RateDetails(Currency.MNT, rates.getRateByCurrencyCode(Currency.MNT), date)
            val mxn = RateDetails(Currency.MXN, rates.getRateByCurrencyCode(Currency.MXN), date)
            val myr = RateDetails(Currency.MYR, rates.getRateByCurrencyCode(Currency.MYR), date)
            val ngn = RateDetails(Currency.NGN, rates.getRateByCurrencyCode(Currency.NGN), date)
            val nok = RateDetails(Currency.NOK, rates.getRateByCurrencyCode(Currency.NOK), date)
            val nzd = RateDetails(Currency.NZD, rates.getRateByCurrencyCode(Currency.NZD), date)
            val omr = RateDetails(Currency.OMR, rates.getRateByCurrencyCode(Currency.OMR), date)
            val pab = RateDetails(Currency.PAB, rates.getRateByCurrencyCode(Currency.PAB), date)
            val pen = RateDetails(Currency.PEN, rates.getRateByCurrencyCode(Currency.PEN), date)
            val php = RateDetails(Currency.PHP, rates.getRateByCurrencyCode(Currency.PHP), date)
            val pln = RateDetails(Currency.PLN, rates.getRateByCurrencyCode(Currency.PLN), date)
            val pyg = RateDetails(Currency.PYG, rates.getRateByCurrencyCode(Currency.PYG), date)
            val qar = RateDetails(Currency.QAR, rates.getRateByCurrencyCode(Currency.QAR), date)
            val rub = RateDetails(Currency.RUB, rates.getRateByCurrencyCode(Currency.RUB), date)
            val sar = RateDetails(Currency.SAR, rates.getRateByCurrencyCode(Currency.SAR), date)
            val sek = RateDetails(Currency.SEK, rates.getRateByCurrencyCode(Currency.SEK), date)
            val sgd = RateDetails(Currency.SGD, rates.getRateByCurrencyCode(Currency.SGD), date)
            val sll = RateDetails(Currency.SLL, rates.getRateByCurrencyCode(Currency.SLL), date)
            val syp = RateDetails(Currency.SYP, rates.getRateByCurrencyCode(Currency.SYP), date)
            val thb = RateDetails(Currency.THB, rates.getRateByCurrencyCode(Currency.THB), date)
            val tnd = RateDetails(Currency.TND, rates.getRateByCurrencyCode(Currency.TND), date)
            val uah = RateDetails(Currency.UAH, rates.getRateByCurrencyCode(Currency.UAH), date)
            val usd = RateDetails(Currency.USD, rates.getRateByCurrencyCode(Currency.USD), date)
            val vef = RateDetails(Currency.VEF, rates.getRateByCurrencyCode(Currency.VEF), date)
            val vnd = RateDetails(Currency.VND, rates.getRateByCurrencyCode(Currency.VND), date)
            val yer = RateDetails(Currency.YER, rates.getRateByCurrencyCode(Currency.YER), date)
            val zar = RateDetails(Currency.ZAR, rates.getRateByCurrencyCode(Currency.ZAR), date)
            val zmw = RateDetails(Currency.ZMW, rates.getRateByCurrencyCode(Currency.ZMW), date)

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

    fun getRate(currency: Currency): Double? {
        var result: Double? = null

        val currencyItem = getCurrencyItemByCode(currency)
        if (currencyItem != null) {
            result = currencyItem.rating
        }

        return result
    }

    fun getSize(): Int = getCurrenciesList().size

    fun setConvertedCurrenciesList(convertedCurrenciesList: ArrayList<RateDetails>) {
        convertedCurrenciesList.sortBy { it.currency }
        currencies = convertedCurrenciesList
    }

    private fun getCurrencyItemByCode(currency: Currency): RateDetails? {
        var result: RateDetails? = null
        val currenciesList = getCurrenciesList()

        for (item in currenciesList) {
            if (item.currency == currency) {
                result = item
                break
            }
        }

        return result
    }

}