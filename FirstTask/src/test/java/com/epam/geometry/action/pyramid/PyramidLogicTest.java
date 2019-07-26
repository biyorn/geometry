package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class PyramidLogicTest {

    private static final double DELTA = 0.001;
    private static final double EXPECTED_SQUARE = 273.205;
    private static final double EXPECTED_VOLUME = 235.702;
    private static final double EXPECTED_RATIO = 0.221;
    private static final double TARGET_COORDINATE = 5;
    private PyramidLogic logic;
    private Pyramid pyramid;
    private static Pyramid pyramidForCoordinateTest;

    @Before
    public void init() {
        logic = new PyramidLogic();
        Point point = new Point(1, 1, 1);
        pyramid = new Pyramid(point, 10, 10);
        Point pointForCoordinateTest = new Point(0, 0, 0);
        pyramidForCoordinateTest = new Pyramid(pointForCoordinateTest, 5, 5);
    }

    @DataProvider
    public static Object[][] dataProviderRightCoordinate() {
        return new Object[][]{
                {'x'},
                {'y'},
                {'z'},
                {'X'},
                {'Y'},
                {'z'}
        };
    }

    @DataProvider
    public static Object[][] dataProviderWrongCoordinate() {
        return new Object[][] {
                {'a'},
                {'b'},
                {'c'}
        };
    }

    @Test
    public void calculateSquareTestMethodShouldReturnExpectedSquare() {
        // when
        double actual = logic.calculateSquare(pyramid);

        // then
        assertEquals(EXPECTED_SQUARE, actual, DELTA);
    }

    @Test
    public void calculateVolumeTestMethodShouldReturnExceptedVolume() {
        // when
        double actual = logic.calculateVolume(pyramid);

        // then
        assertEquals(EXPECTED_VOLUME, actual, DELTA);

    }

    @Test
    public void testCalculateRationVolumeShouldReturnExpectedRatio() {
        // when
        double actual = logic.calculateRatioVolume(pyramid, TARGET_COORDINATE);

        // then
        assertEquals(EXPECTED_RATIO, actual, DELTA);
    }

    @Test
    @UseDataProvider("dataProviderRightCoordinate")
    public void testBeOnCoordinatePlaneShouldReturnTrueWhenRightCoordinateSupplied(char parameter) {
        // when
        boolean actual = logic.beOnCoordinatePlane(pyramidForCoordinateTest, parameter);

        // then
        assertTrue(actual);
    }

    @Test
    @UseDataProvider("dataProviderWrongCoordinate")
    public void testBeOnCoordinatePlaneShouldReturnFalseWhenWrongCoordinateSupplied(char parameter) {
        // when
        boolean actual = logic.beOnCoordinatePlane(pyramidForCoordinateTest, parameter);

        // then
        assertFalse(actual);
    }
}
