package com.ferocia.termdeposit.service;

import com.ferocia.termdeposit.constants.InterestFrequency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class CalculatorService {

    public BigDecimal calculateFinalBalance(BigDecimal amount, BigDecimal interestRate, int termInYears, InterestFrequency interestFrequency) {
        BigDecimal rateDecimal = interestRate.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

        if(!interestFrequency.isCompounded()) {
            return amount.multiply(BigDecimal.ONE.add(rateDecimal.multiply(BigDecimal.valueOf(termInYears))), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
        }

        int n = interestFrequency.getCompoundingPerYear();
        BigDecimal base = BigDecimal.ONE.add(rateDecimal.divide(BigDecimal.valueOf(n), 10, RoundingMode.HALF_UP));
        BigDecimal exponent = BigDecimal.valueOf((long)n * termInYears);

        BigDecimal finalBalance = amount.multiply(base.pow(exponent.intValue(), MathContext.DECIMAL64));
        return finalBalance.setScale(0, RoundingMode.HALF_UP); // final balance is a whole number
    }
}
