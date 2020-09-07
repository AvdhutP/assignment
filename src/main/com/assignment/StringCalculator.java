package com.assignment;

public class StringCalculator {
    int Add(String numbers)
    {
        if(numbers.equals("")){
            return 0;
        }
        else{
            String nums[] = splitNumbers(numbers, "\n|,");
            return sum(nums);
        }
    }

    private int sum(String[] nums) {
        int total = 0;
        for(String number : nums){
            total += convertToInt(number);
        }
        return total;
    }

    private String[] splitNumbers(String numbers, String delimeter) {
        return numbers.split(delimeter);
    }

    private static int convertToInt(String number){
        return Integer.parseInt(number);
    }
}
