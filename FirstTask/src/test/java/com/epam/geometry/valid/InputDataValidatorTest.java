package com.epam.geometry.valid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputDataValidatorTest {

    private InputDataValidator validator;

    @Before
    public void init() {
        validator = new InputDataValidator();
    }

    @Test
    public void testReadShouldReturnTrueWhenNumbersFive() {
        // when
        boolean actual = validator.isValid("122 2 3 422 5");

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testReadShouldReturnFalseWhenAmountNumbersLessThanFive() {
        // when
        boolean result = validator.isValid("1 2 3 4");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void testReadShouldReturnFalseWhenAmountNumbersMoreThanFive() {
        // when
        boolean result = validator.isValid("1 2 3 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void testReadShouldReturnFalseWhenStringContainLetter() {
        // when
        boolean result = validator.isValid("11z 23 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void testReadShouldReturnTrueWhenNumbersNegative() {
        // when
        boolean result = validator.isValid("-1 2 3 -4 5");

        // then
        Assert.assertTrue(result);
    }
}
