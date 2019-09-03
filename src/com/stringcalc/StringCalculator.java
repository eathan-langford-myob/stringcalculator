package com.stringcalc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String s) {
        if (s.length()<=1) {
            return Integer.parseInt(s);
        }else{
            List<String> stringSplit = Arrays.asList(s.split(","));
            int stringToInt = stringSplit.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.summingInt(Integer::intValue));
            return stringToInt;
        }
    }
}
