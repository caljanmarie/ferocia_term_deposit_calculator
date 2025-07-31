package com.ferocia.termdeposit.service;

import com.ferocia.termdeposit.constants.InterestFrequency;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.ferocia.termdeposit.constants.InputConstraints.*;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    // Prompt to input amount
    public BigDecimal promptForAmount() {
        while (true) {
            System.out.println("Enter the amount of money you want to start saving with: ");
            String input = scanner.nextLine().trim();
            try {
                BigDecimal amount = new  BigDecimal(input);
                if (amount.compareTo(MIN_AMOUNT) < 0 || amount.compareTo(MAX_AMOUNT) > 0 )
                    throw new IllegalArgumentException("Amount must be between $10.00 and $1,500,000.00.");
                return amount;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numeric amount.");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Prompt for interest rate
    public BigDecimal promptForInterest() {
        while (true) {
            System.out.println("Enter annual interest rate: ");
            String input = scanner.nextLine().trim();
            try {
                BigDecimal rate = new  BigDecimal(input);
                if (rate.compareTo(BigDecimal.ZERO) <= 0 || rate.compareTo(MAX_INTEREST_RATE) > 0)
                    throw new IllegalArgumentException("Interest rate must be more than 0% and no greater than 15%.");
                return rate;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numeric interest rate.");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Prompt for investment term
    public int promptForTerm() {
        while (true) {
            System.out.println("Enter how long you want to leave your savings invested (in years): ");
            String input = scanner.nextLine().trim();
            try {
                int term = Integer.parseInt(input);
                if (term < MIN_TERM_IN_YEARS || term > MAX_TERM_IN_YEARS)
                    throw new IllegalArgumentException("Investment term must be between 1 and 5 years.");
                return term;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numeric investment term.");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Prompt for interest payment frequency
    public InterestFrequency promptForInterestFrequency() {
        while (true) {
            System.out.println("Enter how frequently the term deposit pays interest or roll overs and reinvests [MO - monthly, Q - quarterly, A - annually, MA - maturity]: ");
            String input = scanner.nextLine().trim();
            try {
               return InterestFrequency.valueOf(input.toUpperCase());
            } catch (Exception e) {
                System.out.println("Invalid Frequency. Please choose from [MO - monthly, Q - quarterly, A - annually, MA - maturity].");
            }
        }
    }
}
