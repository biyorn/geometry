package com.epam.geometry.valid;

import com.epam.geometry.valid.impl.Validator;
import org.apache.log4j.Logger;


public class DateValidator implements Validator {

    private static final Logger log = Logger.getLogger(DateValidator.class);
    private static final String REGEX = "[[0-9]\\s]{9}";

    @Override
    public boolean isValid(String line) {
        log.info("Check string for compliance");
        String result = line.trim();
        return result.matches(REGEX);
    }
}
