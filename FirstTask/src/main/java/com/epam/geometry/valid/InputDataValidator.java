package com.epam.geometry.valid;

public class InputDataValidator {

    private static final String DIGIT_STRING = "(-?\\d+\\s?){5}";

    public boolean isValid(String line) {
        return line.matches(DIGIT_STRING);
    }
}
