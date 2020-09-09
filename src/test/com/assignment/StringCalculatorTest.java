package com.assignment;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {
    private static StringCalculator calculator;
    public static void main(final String args[]) {
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

    @Test
    public void testNewLineDelimeter(){
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void testOtherDelimiter(){
        assertEquals(3, calculator.Add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumber(){
        try {
            calculator.Add("-1,2");
        }
        catch (final IllegalArgumentException e){
            assertEquals(e.getMessage(), "negatives not allowed -1");
        }

        try {
            calculator.Add("2,-4,3,-5");
        }
        catch (final IllegalArgumentException e){
            assertEquals(e.getMessage(), "negatives not allowed -4,-5");
        }
    }

    @Test
    public void testNumberGreaterThan1000(){
        assertEquals(2, calculator.Add("1001,2"));
    }

    @Test
    public void testDelemetersMoreThanOne(){
        assertEquals(6, calculator.Add("//[;][,]\n1;2,3"));
    }
}
