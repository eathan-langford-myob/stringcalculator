package com.stringcalc;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() throws Exception {
        int actual = StringCalculator.add("1,2");
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSingleNumberItIsGiven() throws Exception {
        int actual = StringCalculator.add("1");
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfTwoNumbersGiven() throws Exception {
        int actual = StringCalculator.add("1,2");
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOFMoreNumbers() throws Exception {
        int actual = StringCalculator.add("1,2,3");
        int expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfNumbersWithInterchangeableDelimiter() throws Exception {
        int actual = StringCalculator.add("1,2\n3");
        int expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfNumbersWithTheDeclaredDelimiter() throws Exception {
        int actual = StringCalculator.add("//;\n1;2");
        int expected = 3;

        assertEquals(expected, actual);
    }
    
    @Rule
    public final ExpectedException negativeNumericException = ExpectedException.none();

    @Test public void shouldThrowExceptionIfContainsNegativeNumbers() throws Exception {
        negativeNumericException.expect(Exception.class);
        negativeNumericException.expectMessage(CoreMatchers.containsString("Negative numbers not allowed: "));
        StringCalculator.add("-1,2,-3");
    }
}