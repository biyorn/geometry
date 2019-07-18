package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PyramidLogicTest {

    private static final double DELTA = 0.001;
    private static final double EXPECTED_SQUARE = 273.205;
    private static final double EXPECTED_VOLUME = 235.702;
    private static final double EXPECTED_RATIO = 0.221;
    private static final double TARGET_COORDINATE = 5;
    private PyramidLogic logic;
    private Pyramid pyramid;
    private Pyramid pyramidForCoordinateTest;

    @Before
    public void init() {
        logic = new PyramidLogic();
        Point point = new Point(1, 1, 1);
        pyramid = new Pyramid(point, 10, 10);
        Point pointForCoordinateTest = new Point(0, 0, 0);
        pyramidForCoordinateTest = new Pyramid(pointForCoordinateTest, 5, 5);
    }

    @Test
    public void calculateSquareTestMethodShouldReturnExpectedSquare() {
        // when
        double actual = logic.calculateSquare(pyramid);

        // then
        Assert.assertEquals(EXPECTED_SQUARE, actual, DELTA);
    }

    @Test
    public void calculateVolumeTestMethodShouldReturnExceptedVolume() {
        // when
        double actual = logic.calculateVolume(pyramid);

        // then
        Assert.assertEquals(EXPECTED_VOLUME, actual, DELTA);

    }

    @Test
    public void testCalculateRationVolumeShouldReturnExpectedRatio() {
        // when
        double actual = logic.calculateRatioVolume(pyramid, TARGET_COORDINATE);

        // then
        Assert.assertEquals(EXPECTED_RATIO, actual, DELTA);
    }

    @Test
    public void testBeOnCoordinatePlaneShouldReturnTrueWhenCoordinateX() {
        // when
        boolean actual = logic.beOnCoordinatePlane(pyramidForCoordinateTest, 'X');

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testBeOnCoordinatePlaneShouldReturnTrueWhenCoordinateY() {
        // when
        boolean actual = logic.beOnCoordinatePlane(pyramidForCoordinateTest, 'Y');

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testBeOnCoordinatePlaneShouldReturnTrueWhenCoordinateZ() {
        // when
        boolean actual = logic.beOnCoordinatePlane(pyramidForCoordinateTest, 'Z');

        // then
        Assert.assertTrue(actual);
    }
}
