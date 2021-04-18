package com.cat.utils;

public class MainUtil {
    private MainUtil() {
    }

    public static String unitConversion(String original, String unit) {
        if (original.toLowerCase().contains(unit.toLowerCase())) {
            return original;
        } else {
            return original + unit;
        }
    }
}
