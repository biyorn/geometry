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
    private Point point;
    private Pyramid pyramid;

    @Before
    public void init() {
        logic = new PyramidLogic();
        point = new Point(1, 1, 1);
        pyramid = new Pyramid(point, 10, 10);
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
}
