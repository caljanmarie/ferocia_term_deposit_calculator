package com.ferocia.termdeposit.constants;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class InputConstraints {
    public static final BigDecimal MIN_AMOUNT = new BigDecimal("1000");
    public static final BigDecimal MAX_AMOUNT = new BigDecimal("1500000");
    public static final BigDecimal MAX_INTEREST_RATE = new BigDecimal("15");
    public static final int MIN_TERM_IN_YEARS = 1;
    public static final int MAX_TERM_IN_YEARS = 5;
    public static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.of("en", "AU"));
}
