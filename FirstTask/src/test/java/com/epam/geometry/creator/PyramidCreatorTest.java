package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.parameters.ParametersNotValidException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PyramidCreatorTest {

    private static final Pyramid EXPECTED = new Pyramid(new Point(1, 2, 3), 4, 5);
    private static final String VALID_DATA = "1 2 3 4 5";
    private static final String INVALID_DATA = "1 2 3 4 -5";
    private PyramidCreator creator;

    @Before
    public void init() {
        creator = new PyramidCreator();
    }

    @Test
    public void testCreatePyramidShouldReturnExpectedPyramid() throws ParametersNotValidException {
         // when
        Pyramid actual = creator.createPyramid(VALID_DATA);

        // then
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = ParametersNotValidException.class)
    public void testCreatePyramidShouldReturnExpectedException() throws ParametersNotValidException {
        // when
        creator.createPyramid(INVALID_DATA);
    }
}
