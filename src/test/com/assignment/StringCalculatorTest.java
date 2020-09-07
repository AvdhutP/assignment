package com.assignment;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {
    private static StringCalculator calculator;
    public static void main(String args[]) {
        calculator = new StringCalculator();
        org.junit.runner.JUnitCore.main("com.assignment.StringCalculatorTest");
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.Add(""));
    }
}
