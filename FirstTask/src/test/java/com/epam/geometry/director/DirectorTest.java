package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.DataMissingException;
import com.epam.geometry.exception.file.FileNotReadException;
import com.epam.geometry.io.DataReader;
import com.epam.geometry.valid.InputDataValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DirectorTest {

    private static final String PATH = "some path";
    private static final String WRONG_PATH = "some invalid path";
    private static final Point FIRST_POINT = new Point(1, 2, 3);
    private static final Point SECOND_POINT = new Point(6, 7, 8);
    private static final Pyramid FIRST_PYRAMID = new Pyramid(FIRST_POINT, 4, 5);
    private static final Pyramid SECOND_PYRAMID = new Pyramid(SECOND_POINT, 9, 10);

    private static final List<Pyramid> EXPECTED = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID);
    private static final String FIRST_PARAMETERS = "1 2 3 4 5";
    private static final String SECOND_PARAMETERS = "6 7 8 9 10";
    private static final String THIRD_PARAMETERS = "14 4x 54 4";
    private static final String FOURTH_PARAMETERS = "11 12 13 -14 15";

    private static final List<String> DATA = Arrays.asList(
            FIRST_PARAMETERS,
            SECOND_PARAMETERS,
            THIRD_PARAMETERS,
            FOURTH_PARAMETERS
    );

    private Director director;
    private DataReader reader;
    private InputDataValidator validator;
    private PyramidCreator creator;


    @Before
    public void init() {
        reader = mock(DataReader.class);
        validator = mock(InputDataValidator.class);
        creator = mock(PyramidCreator.class);
        director = new Director(reader, validator, creator);
    }


    @Test
    public void testProcessShouldReturnWholeListWhenValidParametersSupplied() throws DataMissingException {
        // given
        when(reader.read(anyString())).thenReturn(DATA);

        when(validator.isValid(FIRST_PARAMETERS)).thenReturn(true);
        when(validator.isValid(SECOND_PARAMETERS)).thenReturn(true);
        when(validator.isValid(THIRD_PARAMETERS)).thenReturn(false);
        when(validator.isValid(FOURTH_PARAMETERS)).thenReturn(true);

        when(creator.createPyramid(FIRST_PARAMETERS)).thenReturn(Optional.of(FIRST_PYRAMID));
        when(creator.createPyramid(SECOND_PARAMETERS)).thenReturn(Optional.of(SECOND_PYRAMID));
        when(creator.createPyramid(FOURTH_PARAMETERS)).thenReturn(Optional.empty());

        // when
        List<Pyramid> actual = director.process(PATH);

        // then
        verify(reader, times(1)).read(anyString());
        verify(validator, times(4)).isValid(anyString());
        verify(creator, times(3)).createPyramid(anyString());
        assertThat(actual, is(EXPECTED));
    }

    @Test
    public void testProcessShouldReturnEmptyListWhenInvalidPathSupplied() throws DataMissingException {
        // given
        when(reader.read(WRONG_PATH)).thenThrow(new FileNotReadException());

        // when
        List<Pyramid> actual = director.process(WRONG_PATH);

        // then
        verify(reader, times(1)).read(anyString());
        assertTrue(actual.isEmpty());
    }

}
