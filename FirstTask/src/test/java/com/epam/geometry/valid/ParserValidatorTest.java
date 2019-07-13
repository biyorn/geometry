package com.epam.geometry.valid;

import com.epam.geometry.exception.parameters.ParametersNotValidException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserValidatorTest {

    private static final List<Double> EXPECTED_LIST = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

    private ParserPyramidParameters action;
    private List<Double> actual;

    @Before
    public void init() {
        action = new ParserPyramidParameters();
    }

    @Test
    public void testParserShouldReturnExpectedList() throws ParametersNotValidException {
        // when
        actual = action.parser("1 2 3 4 5");

        // then
        assertThat(actual, is(EXPECTED_LIST));
    }

    @Test(expected = ParametersNotValidException.class)
    public void testParserShouldReturnExceptionWhenSideRibLengthNegative() throws ParametersNotValidException {
        // when
        action.parser("1 2 3 -4 5");
    }

    @Test(expected = ParametersNotValidException.class)
    public void testParserShouldReturnExceptionWhenBaseEdgeLengthNegative() throws ParametersNotValidException {
        // when
        action.parser("1 2 3 4 -5");
    }

    @Test(expected = ParametersNotValidException.class)
    public void testParserShouldReturnExceptionWhenBothParametersNegative() throws ParametersNotValidException {
        // when
        action.parser("1 2 3 -4 -5");
    }
}
