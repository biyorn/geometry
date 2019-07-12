package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.shape.ShapeDoesNotExistException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PyramidLogicTest {

    private static final double DELTA = 0.1;
    private static final double EXPECTED_SQUARE = 273.20;
    private static final double EXPECTED_VOLUME = 235.66;
    private PyramidLogic logic;
    private Pyramid mockPyramid;

    @Before
    public void init() {
        logic = new PyramidLogic();
        mockPyramid = mock(Pyramid.class);
        when(mockPyramid.getBaseEdgeLength()).thenReturn(10.0);
        when(mockPyramid.getSideRibLength()).thenReturn(10.0);
    }

    @Test
    public void calculateSquareTestMethodShouldReturnExpectedSquare() throws ShapeDoesNotExistException {
        // when
        double actual = logic.calculateSquare(mockPyramid);

        // then
        Assert.assertEquals(EXPECTED_SQUARE, actual, DELTA);
    }

    @Test(expected = ShapeDoesNotExistException.class)
    public void calculateSquareTestMethodShouldThrowExceptionWhenObjectIsNull() throws ShapeDoesNotExistException {
        // when
        logic.calculateSquare(null);
    }

    @Test
    public void calculateVolumeTestMethodShouldReturnExceptedVolume() throws ShapeDoesNotExistException {
        // when
        double actual = logic.calculateVolume(mockPyramid);

        // then
        Assert.assertEquals(EXPECTED_VOLUME, actual, DELTA);

    }

    @Test(expected = ShapeDoesNotExistException.class)
    public void calculateVolumeTestMethodShouldThrowExceptionWhenObjectIsNull() throws ShapeDoesNotExistException {
        // when
        logic.calculateVolume(null);
    }
}
