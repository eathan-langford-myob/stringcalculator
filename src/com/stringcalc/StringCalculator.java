package com.stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static List<String> checkSupportedDelimiters(String stringInput) {
        List<String> supportedDelimiters = new ArrayList<>();
        String semiColon = (stringInput.contains(";")?";":null);
        String newLine = (stringInput.contains("\n")?"\n":null);
        String comma = ",";
        supportedDelimiters.add(semiColon);
        supportedDelimiters.add(newLine);
        supportedDelimiters.add(comma);
        return supportedDelimiters;
    }

    public static List<String> compileDelimiterList(String stringInput, List<String> supportedDelimiters){
        String[] splitStringWithDelimiter = stringInput.split("\n");
        String delimiterFromString = splitStringWithDelimiter[0];
        delimiterFromString=delimiterFromString.replace("//","").replace("[", "").replace("]", ",");
        String[] arrayOfDelimiters = delimiterFromString.split(",");
        supportedDelimiters.addAll(Arrays.asList(arrayOfDelimiters));
        return supportedDelimiters;
    }

    public static String extractStringFromDeclaredDelimiter(String stringInput) {
        if (stringInput.startsWith("//")){
            String[] splitStringWithDelimiter = stringInput.split("\n");
            String delimiterFromString = splitStringWithDelimiter[0];
            String numbersFromString = splitStringWithDelimiter[1];
//            delimiterFromString = compileDelimiterList(delimiterFromString, supportedDelimiters);
            stringInput = numbersFromString;
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

    public static void checkForNegativeNumbers (List<String> numbersExtractedWithComma) throws Exception{
        ArrayList<String> negativeNumbers = new ArrayList<>();
        String exceptionMessage = "Negative numbers not allowed: ";
        for (String number:numbersExtractedWithComma
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
        supportedDelimiters = compileDelimiterList(stringInput, supportedDelimiters);
        stringInput = extractStringFromDeclaredDelimiter(stringInput);
        stringInput = replaceDelimitersWithCommas(stringInput, supportedDelimiters);
        List<String> numbersExtractedWithComma = Arrays.asList(stringInput.split(","));
        checkForNegativeNumbers(numbersExtractedWithComma);
        return numbersExtractedWithComma.stream()
                .map(Integer::parseInt)
                .filter(num-> num<1000)
                .mapToInt(Integer::intValue)
                .sum();

    }
}
