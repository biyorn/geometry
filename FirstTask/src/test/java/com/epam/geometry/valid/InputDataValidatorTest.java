package com.epam.geometry.valid;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class InputDataValidatorTest {

    private InputDataValidator validator;

    @Before
    public void init() {
        validator = new InputDataValidator();
    }

    @DataProvider
    public static Object[][] dataProviderValid() {
        return new Object[][] {
                {"-1 2 3 -4 5"},
                {"122 2 3 422 5"}
        };
    }

    @DataProvider
    public static Object[][] dataProviderInvalid() {
        return new Object[][] {
                {"1 2 3 4"},
                {"1 2 3 4 5 6"},
                {"11z 23 4 5 6"}
        };
    }

    @Test
    @UseDataProvider("dataProviderValid")
    public void testReadShouldReturnTrueWhenNumbersFive(String parameters) {
        // when
        boolean actual = validator.isValid(parameters);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    @UseDataProvider("dataProviderInvalid")
    public void testReadShouldReturnFalseWhenAmountNumbersLessThanFive(String parameters) {
        // when
        boolean result = validator.isValid(parameters);

        // then
        Assert.assertFalse(result);
    }
}
