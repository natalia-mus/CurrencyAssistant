package com.example.euroexchangerate.data

enum class CurrencyCode(val currencyName: String) {
    AED("AED"),
    ALL("ALL"),
    ANG("ANG"),
    AOA("AOA"),
    ARS("ARS"),
    AUD("AUD"),
    BAM("BAM"),
    BGN("BGN"),
    BOB("BOB"),
    BRL("BRL"),
    BTC("BTC"),
    BYR("BYR"),
    CAD("CAD"),
    CHF("CHF"),
    CLP("CLP"),
    CNY("CNY"),
    COP("COP"),
    CRC("CRC"),
    CUP("CUP"),
    CZK("CZK"),
    DKK("DKK"),
    EGP("EGP"),
    GBP("GBP"),
    GEL("GEL"),
    GIP("GIP"),
    HNL("HNL"),
    HRK("HRK"),
    HUF("HUF"),
    IDR("IDR"),
    ILS("ILS"),
    INR("INR"),
    JPY("JPY"),
    KRW("KRW"),
    KWD("KWD"),
    KZT("KZT"),
    LYD("LYD"),
    MAD("MAD"),
    MDL("MDL"),
    MNT("MNT"),
    MXN("MXN"),
    MYR("MYR"),
    NGN("NGN"),
    NOK("NOK"),
    NZD("NZD"),
    OMR("OMR"),
    PAB("PAB"),
    PEN("PEN"),
    PHP("PHP"),
    PLN("PLN"),
    PYG("PYG"),
    QAR("QAR"),
    RUB("RUB"),
    SAR("SAR"),
    SEK("SEK"),
    SGD("SGD"),
    SLL("SLL"),
    SYP("SYP"),
    THB("THB"),
    TND("TND"),
    UAH("UAH"),
    USD("USD"),
    VEF("VEF"),
    VND("VND"),
    YER("YER"),
    ZAR("ZAR"),
    ZMW("ZMW");

    fun getCurrencyCodeToLowerCase(): String {
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