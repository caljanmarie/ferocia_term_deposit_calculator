package com.ferocia.termdeposit.constants;

import java.math.BigDecimal;

public class InputConstraints {
    public static final BigDecimal MIN_AMOUNT = new BigDecimal("1000.00");
    public static final BigDecimal MAX_AMOUNT = new BigDecimal("1500000.00");
    public static final BigDecimal MAX_INTEREST_RATE = new BigDecimal("15.00");
    public static final int MIN_TERM_IN_YEARS = 1;
    public static final int MAX_TERM_IN_YEARS = 5;

}
