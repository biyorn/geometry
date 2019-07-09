package com.epam.geometry.util.valid;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void readTestMethodReturnTrueWhenAmountNumbersFive() {
        // given
        Validator validator = new Validator();

        // when
        boolean result = validator.isValid("1 2 3 4 5");

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenAmountNumbersLessThanFive() {
        // given
        Validator validator = new Validator();

        // when
        boolean result = validator.isValid("1 2 3 4");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenAmountNumbersMoreThanFive() {
        // given
        Validator validator = new Validator();

        // when
        boolean result = validator.isValid("1 2 3 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenStringContainLetter() {
        // given
        Validator validator = new Validator();

        // when
        boolean result = validator.isValid("11z 23 4 5 6");

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void readTestMethodReturnFalseWhenNumberIsNegative() {
        // given
        Validator validator = new Validator();

        // when
        boolean result = validator.isValid("-1 2 3 4 5");

        // then
        Assert.assertFalse(result);
    }
}
