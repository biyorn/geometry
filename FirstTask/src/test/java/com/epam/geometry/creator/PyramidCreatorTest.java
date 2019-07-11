package com.epam.geometry.creator;

import com.epam.geometry.entity.shape.pyramid.Pyramid;
import org.junit.Test;

public class PyramidCreatorTest {

    @Test
    public void createNewPyramid() {
        // given
        PyramidCreator creator = new PyramidCreator();

        // when
        Pyramid pyramid = creator.createNewPyramid("");

        // then

    }
}
