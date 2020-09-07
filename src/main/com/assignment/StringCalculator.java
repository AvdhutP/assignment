package com.assignment;

public class StringCalculator {
    int Add(String numbers)
    {
        if(numbers.equals("")){
            return 0;
        }
        else{
            String delimiter = ",";
            if(numbers.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String nums[] = splitNumbers(numbers, delimiter + "|\n");
            return sum(nums);
        }
    }

    private String[] splitNumbers(String numbers, String delimeter) {
        return numbers.split(delimeter);
    }

    private int sum(String[] nums) {
        int total = 0;
        String negativeNumbers = "";
        for(String number : nums){
            Integer numb = convertToInt(number);
            if (numb<0) {
                if(negativeNumbers.equals(""))
                    negativeNumbers = number;
                else
                    negativeNumbers+=(","+number);
            }
            else
                total += numb;

        }
        if(!negativeNumbers.equals(""))
            throw new IllegalArgumentException("negatives not allowed " + negativeNumbers);
        return total;
    }

    private static int convertToInt(String number){
        return Integer.parseInt(number);
    }
}
