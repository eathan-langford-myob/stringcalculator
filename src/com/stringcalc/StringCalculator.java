package com.stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String s) {
        List<String> supportedDelimiters = new ArrayList<>();
        String semiColon = (s.contains(";")?";":null);
        String newLine = (s.contains("\n")?"\n":null);
        String comma = ",";
        supportedDelimiters.add(semiColon);
        supportedDelimiters.add(newLine);
        supportedDelimiters.add(comma);
        List<String> numbersExtractedWithComma;

        if (s.startsWith("//")){
            String[] splitStringWithDelimiter = s.split("\n");
            supportedDelimiters.add(splitStringWithDelimiter[0].replace("//", ""));
            s = splitStringWithDelimiter[1];

        }else if (s.chars().allMatch(Character::isDigit)){
            return Integer.parseInt(s);
        }

        for (String delimiter:supportedDelimiters
        ) {
            if(delimiter!=null) s = s.replace(delimiter, ",");
        }

        numbersExtractedWithComma = Arrays.asList(s.split(comma));
        return numbersExtractedWithComma.stream()
                .map(Integer::parseInt).mapToInt(Integer::intValue).sum();
    }
}
