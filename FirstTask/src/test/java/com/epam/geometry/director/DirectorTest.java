package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.io.DataReader;
import com.epam.geometry.valid.InputDataValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectorTest {

    private static final String PATH = "src/test/resources/test.txt";
    private static final String WRONG_PATH = "src/test/resources/tst.txt";
    private static final List<Pyramid> EXPECTED_LIST = Arrays.asList(
            new Pyramid(new Point(1, 2, 3), 4, 5),
            new Pyramid(new Point(4, 2, 1), 2, 4),
            new Pyramid(new Point(5, 2, 41), 10, 20)
    );

    private DataReader reader;
    private InputDataValidator validator;
    private PyramidCreator creator;
    private Director director;

    @Before
    public void init() {
        reader = new DataReader();
        validator = new InputDataValidator();
        creator = new PyramidCreator();
        director = new Director(reader, validator, creator);
    }

    @Test
    public void testProcessShouldReturnExpectedList() {
        // when
        List<Pyramid> actualList = director.process(PATH);

        // then
        assertThat(actualList, is(EXPECTED_LIST));
    }

    @Test
    public void testProcessShouldReturnListWithSizeThree() {
        // when
        List<Pyramid> actualList = director.process(PATH);

        // then
        assertThat(actualList, hasSize(3));
    }
}
