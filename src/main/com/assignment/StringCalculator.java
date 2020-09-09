package com.assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int Add(String numbers)
    {
        if(numbers.equals("")){
            return 0;
        }
        else {
            String delimiter = ",|\n";
            if (numbers.matches("//(.*)\n(.*)")) {
                if (Character.toString(numbers.charAt(2)).equals("[")) {
                    Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                    Matcher matcher=pattern.matcher(numbers);
                    while (matcher.find()) {
                        delimiter += "|"+matcher.group().charAt(1);
                    }
                    numbers = numbers.substring(numbers.lastIndexOf('\n')+1);
                } else {
                    delimiter = Character.toString(numbers.charAt(2));
                    delimiter+="|\n";
                    numbers = numbers.substring(4);
                }
            }
            String nums[] = splitNumbers(numbers, delimiter);
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
            else if(numb>1000)
            {

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
    //[;][,]\n1;2,3"
}
