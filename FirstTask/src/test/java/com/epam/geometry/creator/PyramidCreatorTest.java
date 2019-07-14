package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.parameters.ParametersNotValidException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PyramidCreatorTest {

    private static final Pyramid EXPECTED = new Pyramid(new Point(1, 2, 3), 4, 5);

    @Test
    public void createNewPyramid() throws ParametersNotValidException {
        // given
        PyramidCreator creator = new PyramidCreator();
        //List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        // when
        Pyramid actual = creator.createPyramid("1 2 3 4 5");

        // then
        Assert.assertEquals(EXPECTED, actual);
    }
}
