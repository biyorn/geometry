package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.valid.ParametersPyramidValidator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class PyramidCreatorTest {

    private static final Point firstPoint = new Point(1, 2, 3);
    private static final Point secondPoint = new Point(6, 7, 8);
    private static final Point thirdPoint = new Point(11, 12, 13);
    private static final Pyramid fistValidPyramid = new Pyramid(firstPoint, 4, 5);
    private static final Pyramid secondValidPyramid = new Pyramid(secondPoint, 9, 10);
    private static final Pyramid thirdValidPyramid = new Pyramid(thirdPoint, 14, 15);

    private PyramidCreator creator;
    private ParametersPyramidValidator validator;

    @Before
    public void init() {
        validator = mock(ParametersPyramidValidator.class);
        this.creator = new PyramidCreator(validator);
    }

    @DataProvider
    public static Object[][] dataProviderValid() {
        return new Object[][] {
                {"1 2 3 4 5", fistValidPyramid},
                {"6 7 8 9 10", secondValidPyramid},
                {"11 12 13 14 15", thirdValidPyramid}
        };
    }

    @DataProvider
    public static Object[][] dataProviderInvalid() {
        return new Object[][] {
                {"1 2 3 -4 -5"},
                {"1 2 3 -3 3"},
                {"1 2 3 2 -4"}
        };
    }

    @Test
    @UseDataProvider("dataProviderValid")
    public void testCreatePyramidShouldReturnPyramidWhenValidParametersSupplied(String parameters, Pyramid expected) {
        // given
        when(validator.isPyramid(anyDouble(), anyDouble())).thenReturn(true);

        // when
        Optional<Pyramid> actual = creator.createPyramid(parameters);

        // then
        verify(validator, times(1)).isPyramid(anyDouble(), anyDouble());
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    @UseDataProvider("dataProviderInvalid")
    public void testCreatePyramidShouldReturnEmptyOptionalWhenInvalidParametersSupplied(String parameters) {
        // given
        when(validator.isPyramid(anyDouble(), anyDouble())).thenReturn(false);

        // when
        Optional<Pyramid> actual = creator.createPyramid(parameters);

        // then
        verify(validator, times(1)).isPyramid(anyDouble(), anyDouble());
        assertFalse(actual.isPresent());
    }

}
