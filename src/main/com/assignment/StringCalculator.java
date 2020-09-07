package com.assignment;

public class StringCalculator {
    int Add(String numbers)
    {
        if(numbers.equals("")){
            return 0;
        }
        else
            return convertToInt(numbers);
    }

    private static int convertToInt(String number){
        return Integer.parseInt(number);
    }
}
