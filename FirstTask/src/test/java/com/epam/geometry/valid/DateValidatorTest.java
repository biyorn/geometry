package com.epam.geometry.valid;

import org.junit.Assert;
import org.junit.Test;

public class DateValidatorTest {

    @Test
    public void readTestMethodReturnTrueWhenAmountNumbersFive() {
        // given
        DateValidator validator = new DateValidator();

        // when
        boolean result = validator.isValid("1 2 3 4 5");

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenAmountNumbersLessThanFive() {
        // given
        DateValidator validator = new DateValidator();

        // when
        boolean result = validator.isValid("1 2 3 4");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenAmountNumbersMoreThanFive() {
        // given
        DateValidator validator = new DateValidator();

        // when
        boolean result = validator.isValid("1 2 3 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenStringContainLetter() {
        // given
        DateValidator validator = new DateValidator();

        // when
        boolean result = validator.isValid("11z 23 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenNumberIsNegative() {
        // given
        DateValidator validator = new DateValidator();

        // when
        boolean result = validator.isValid("-1 2 3 4 5");

        // then
        Assert.assertFalse(result);
    }
}
