package com.stringcalc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() {
        int actual = StringCalculator.add("");
        int expected = 0;

        assertEquals(expected, actual);
    }
}