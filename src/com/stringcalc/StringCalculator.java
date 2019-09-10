package com.stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static List<String> checkSupportedDelimiters(String stringInput) throws Exception {
        List<String> supportedDelimiters = new ArrayList<>();
        String semiColon = (stringInput.contains(";")?";":null);
        String newLine = (stringInput.contains("\n")?"\n":null);
        String comma = ",";
        supportedDelimiters.add(semiColon);
        supportedDelimiters.add(newLine);
        supportedDelimiters.add(comma);
        return supportedDelimiters;
    }

    public static String extractStringFromDeclaredDelimiter(String stringInput, List<String> supportedDelimiters) throws Exception {
        if (stringInput.startsWith("//")){
            String[] splitStringWithDelimiter = stringInput.split("\n");
            supportedDelimiters.add(splitStringWithDelimiter[0].replace("//", ""));
            stringInput = splitStringWithDelimiter[1];
            return stringInput;
        }
        return stringInput;
    }

    public static String replaceDelimitersWithCommas(String stringInput, List<String> supportedDelimiters) {
        for (String delimiter:supportedDelimiters
        ) {
            if(delimiter!=null){
                stringInput = stringInput.replace(delimiter, ",");
            }
        }
        return stringInput;
    }

    public static void checkForNegativeNumbers (List<String> numbersExtractedWithCommas) throws Exception{
        ArrayList<String> negativeNumbers = new ArrayList<>();
        String exceptionMessage = "Negative numbers not allowed: ";
        for (String number:numbersExtractedWithCommas
        ) {
            if (number.startsWith("-")) {
                negativeNumbers.add(number);
                exceptionMessage = exceptionMessage + number + ", ";
            }
        }
        if (negativeNumbers.size()>0){
            System.out.println(exceptionMessage);
            throw new Exception(exceptionMessage);
        }
    }

    public static int add(String stringInput) throws Exception {

        if (stringInput.chars().allMatch(Character::isDigit)){
            return Integer.parseInt(stringInput);
        }

        List<String> supportedDelimiters = checkSupportedDelimiters(stringInput);
        stringInput = extractStringFromDeclaredDelimiter(stringInput, supportedDelimiters);
        stringInput = replaceDelimitersWithCommas(stringInput, supportedDelimiters);
        List<String> numbersExtractedWithComma = Arrays.asList(stringInput.split(","));
        checkForNegativeNumbers(numbersExtractedWithComma);

        return numbersExtractedWithComma.stream()
                .map(Integer::parseInt).mapToInt(Integer::intValue).sum();
    }
}
