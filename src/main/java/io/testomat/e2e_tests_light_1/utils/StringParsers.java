package io.testomat.e2e_tests_light_1.utils;

public class StringParsers {

    public static Integer parseIntegerFromString(String text) {
        String digitsText = text.replaceAll("\\D+", "");
        return Integer.parseInt(digitsText);
    }

    public static Double parseDoubleFromString(String text) {
        String digitsText = text.replaceAll("\\D+", "");
        return Double.parseDouble(digitsText);
    }

}
