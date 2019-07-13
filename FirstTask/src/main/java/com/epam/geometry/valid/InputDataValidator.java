package com.epam.geometry.valid;

import com.epam.geometry.valid.impl.Validator;

public class InputDataValidator implements Validator {

    private static final String DIGIT_STRING = "(\\d+\\s?){5}";

    @Override
    public boolean isValid(String line) {
        return line.matches(DIGIT_STRING);
    }
}
