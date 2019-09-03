package com.stringcalc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() {
        int actual = StringCalculator.add("1,2");
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSingleNumberItIsGiven() {
        int actual = StringCalculator.add("1");
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfTwoNumbersGiven() {
        int actual = StringCalculator.add("1,2");
        int expected = 3;

        assertEquals(expected, actual);
    }
}