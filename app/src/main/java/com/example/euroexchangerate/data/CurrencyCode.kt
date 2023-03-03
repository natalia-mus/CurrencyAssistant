package com.example.euroexchangerate.data

import android.content.Context

enum class CurrencyCode(val currencyName: String) {
    AED("UAE Dirham"),
    ALL("Albanian Lek"),
    ANG("Netherlands Antilles Guilder"),
    AOA("Angolan Kwanza"),
    ARS("Argentine Peso"),
    AUD("Australian Dollar"),
    BAM("Convertible Mark"),
    BGN("Bulgarian Lev"),
    BOB("Boliviano"),
    BRL("Brazilian Real"),
    BTC("Bitcoin"),
    BYR("Belarusian Ruble"),
    CAD("Canadian Dollar"),
    CHF("Swiss Franc"),
    CLP("Chilean Peso"),
    CNY("Renminbi"),
    COP("Colombian Peso"),
    CRC("Costa Rican Colon"),
    CUP("Cuban Peso"),
    CZK("Czech Koruna"),
    DKK("Danish Krone"),
    EGP("Egyptian Pound"),
    EUR("Euro"),
    GBP("Pound Sterling"),
    GEL("Lari"),
    GIP("Gibraltar Pound"),
    HNL("Lempira"),
    HRK("Croatian Kuna"),
    HUF("Forint"),
    IDR("Rupiah"),
    ILS("New Israeli Sheqel"),
    INR("Indian Rupee"),
    JPY("Yen"),
    KRW("Won"),
    KWD("Kuwaiti Dinar"),
    KZT("Tenge"),
    LYD("Lybian Dinar"),
    MAD("Moroccan Dirham"),
    MDL("Moldovan Leu"),
    MNT("Mongolia Tughrik"),
    MXN("Mexican Peso"),
    MYR("Malaysian Ringgit"),
    NGN("Nigerian Naira"),
    NOK("Norwegian Krone"),
    NZD("New Zealand Dollar"),
    OMR("Omani Rial"),
    PAB("Panamanian Balboa"),
    PEN("Peruvian Sol"),
    PHP("Philippine Peso"),
    PLN("Polish Zloty"),
    PYG("Paraguayan Guarani"),
    QAR("Qatari Rial"),
    RUB("Russian Ruble"),
    SAR("Saudi Riyal"),
    SEK("Swedish Krona"),
    SGD("Singapore Dollar"),
    SLL("Leone"),
    SYP("Syrian Pound"),
    THB("Thai Baht"),
    TND("Tunisian Dinar"),
    UAH("Ukrainian Hryvnia"),
    USD("US Dollar"),
    VEF("Venezuelan Bolivar"),
    VND("Vietnamese Dong"),
    YER("Yemeni Rial"),
    ZAR("South African Rand"),
    ZMW("Zambian Kwacha");

    companion object {
        private const val FLAG_IMAGE_NAME = "_flag_circle"
        private const val DRAWABLE = "drawable"


        fun getAll(): ArrayList<CurrencyCode> {
            val result = ArrayList<CurrencyCode>()

            for (currency in values()) {
                result.add(currency)
            }

            return result
        }
    }

    /**
     * Returns flag image path for this currency
     */
    fun getFlagImageId(context: Context): Int? {
        return context.resources?.getIdentifier(getCurrencyCodeToLowerCase() + FLAG_IMAGE_NAME, DRAWABLE, context.packageName)
    }

    private fun getCurrencyCodeToLowerCase(): String {
        var result = ""

        for (letter in name) {
            when (letter) {
                'A' -> result += "a"
                'B' -> result += "b"
                'C' -> result += "c"
                'D' -> result += "d"
                'E' -> result += "e"
                'F' -> result += "f"
                'G' -> result += "g"
                'H' -> result += "h"
                'I' -> result += "i"
                'J' -> result += "j"
                'K' -> result += "k"
                'L' -> result += "l"
                'M' -> result += "m"
                'N' -> result += "n"
                'O' -> result += "o"
                'P' -> result += "p"
                'Q' -> result += "q"
                'R' -> result += "r"
                'S' -> result += "s"
                'T' -> result += "t"
                'U' -> result += "u"
                'V' -> result += "v"
                'W' -> result += "w"
                'X' -> result += "x"
                'Y' -> result += "y"
                'Z' -> result += "z"
            }
        }

        return result
    }

}