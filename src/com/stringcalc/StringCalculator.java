package com.stringcalc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String s) {
        String semiColon = (s.contains(";")?";":null);
        String newLine = (s.contains("/n")?"/n":null);
        String comma = (s.contains(",")?",":null);

        if (s.length()<=1) {
            return Integer.parseInt(s);
        }else{
            List<String> stringSplit = Arrays.asList(s.split(comma));
            return stringSplit.stream()
                    .map(Integer::parseInt).mapToInt(Integer::intValue).sum();
        }
    }
}
