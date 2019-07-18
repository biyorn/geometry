package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class PyramidCreatorTest {

    private static final Point point = new Point(1, 2, 3);
    private static final Optional<Pyramid> EXPECTED = Optional.of(new Pyramid(point, 4, 5));
    private static final String VALID_DATA = "1 2 3 4 5";
    private static final String INVALID_DATA = "1 2 3 4 -5";
    private PyramidCreator creator;

    @Before
    public void init() {
        creator = new PyramidCreator();
    }

    @Test
    public void testCreatePyramidShouldReturnExpectedPyramid() {
        // when
        Optional<Pyramid> actual = creator.createPyramid(VALID_DATA);

        // then
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testCreatePyramidShouldReturnObject() {
        // when
        Optional<Pyramid> actual = creator.createPyramid(VALID_DATA);

        // then
        Assert.assertTrue(actual.isPresent());
    }

    @Test
    public void testCreatePyramidShouldReturnNull() {
        // when
        Optional<Pyramid> actual = creator.createPyramid(INVALID_DATA);

        // then
        Assert.assertFalse(actual.isPresent());
    }
}
