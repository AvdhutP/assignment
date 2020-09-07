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

    @Test
    public void testOneNumber() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void testTwoNumbers(){
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void testMultipleNumbers(){
        assertEquals(15, calculator.Add("1,2,3,4,5"));
    }
}
