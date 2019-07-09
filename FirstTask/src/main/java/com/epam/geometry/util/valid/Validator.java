package com.epam.geometry.util.valid;

import com.epam.geometry.util.valid.impl.ValidatorImpl;
import org.apache.log4j.Logger;


public class Validator implements ValidatorImpl {

    private static final Logger log = Logger.getLogger(Validator.class);
    private static final String REGEX = "[[0-9]\\s]{9}";

    @Override
    public boolean isValid(String line) {
        log.info("Check string for compliance");
        String result = line.trim();
        return result.matches(REGEX);
    }
}
