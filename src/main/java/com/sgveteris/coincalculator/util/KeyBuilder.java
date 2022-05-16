package com.sgveteris.coincalculator.util;

import java.util.Locale;

public final class KeyBuilder {
    public static String convert(String coinType, String currency){
        return coinType.toUpperCase().concat("-").concat(currency.toUpperCase());
    }
}
