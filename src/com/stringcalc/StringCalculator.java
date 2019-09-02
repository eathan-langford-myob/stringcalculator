package com.stringcalc;

public class StringCalculator {
    public static int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
