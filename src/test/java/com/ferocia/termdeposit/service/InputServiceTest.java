package com.ferocia.termdeposit.service;

import com.ferocia.termdeposit.constants.InterestFrequency;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class InputServiceTest {

    @Test
    public void testPromptForAmount() {
        String input = "abc\n-10\n1600000\n10000\n"; // ["abc", "-10", "1600000", "10000"] [invalid, invalid, invalid, valid]
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputService service = new InputService();
        BigDecimal result = service.promptForAmount();
        assertEquals(new BigDecimal("10000"), result);
    }

    @Test
    public void testPromptForInterest() {
        String input = "abc\n-1\n16\n5"; // ["abc", "-1", "16", "5"] [invalid, invalid, invalid, valid]
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputService service = new InputService();
        BigDecimal result = service.promptForInterest();
        assertEquals(new BigDecimal("5"), result);
    }

    @Test
    public void testPromptForTerm() {
        String input = "abc\n0\n6\n3"; // ["abc", "0", "6", "3"] [invalid, invalid, invalid, valid]
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputService service = new InputService();
        int result = service.promptForTerm();
        assertEquals(3, result);
    }

    @Test
    public void testPromptForInterestFrequency() {
        String input = "abc\n0\nM\nmo"; // ["abc", "0", "M", "mo"] [invalid, invalid, invalid, valid]
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputService service = new InputService();
        InterestFrequency result = service.promptForInterestFrequency();
        assertEquals(InterestFrequency.MO, result);
    }
}
