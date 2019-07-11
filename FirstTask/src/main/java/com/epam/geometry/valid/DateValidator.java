package com.epam.geometry.valid;

import com.epam.geometry.valid.impl.Validator;
import org.apache.log4j.Logger;


public class DateValidator implements Validator {

    private static final Logger log = Logger.getLogger(DateValidator.class.getName());
    private static final String REGEX = "(\\d+\\s?){5}";

    @Override
    public boolean isValid(String line) {
        log.info("Check string for compliance");
        String result = line.trim();
        result = result.replaceAll("\\s{2,}", " ");
        return result.matches(REGEX);
    }
}
