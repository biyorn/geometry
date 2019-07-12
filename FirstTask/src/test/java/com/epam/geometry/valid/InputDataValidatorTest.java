package com.epam.geometry.valid;

import com.epam.geometry.valid.impl.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputDataValidatorTest {

    private Validator validator;

    @Before
    public void init() {
        validator = new InputDataValidator();
    }

    @Test
    public void readTestMethodShouldReturnTrueWhenAmountNumbersFive() {
        // when
        boolean actual = validator.isValid("122 2 3 422 5");

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void readTestMethodShouldReturnFalseWhenAmountNumbersLessThanFive() {
        // when
        boolean result = validator.isValid("1 2 3 4");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodShouldReturnFalseWhenAmountNumbersMoreThanFive() {
        // when
        boolean result = validator.isValid("1 2 3 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodShouldReturnFalseWhenStringContainLetter() {
        // when
        boolean result = validator.isValid("11z 23 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodShouldReturnFalseWhenNumberIsNegative() {
        // when
        boolean result = validator.isValid("-1 2 3 4 5");

        // then
        Assert.assertFalse(result);
    }
}
