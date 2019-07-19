package com.epam.geometry.io;

import com.epam.geometry.exception.DataMissingException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class DataReaderTest {

    private static final String PATH = "src/test/resources/test.txt";
    private static final String WRONG_PATH = "src/test/resources/wrongPath.txt";
    private DataReader reader;
    private static final List<String> EXPECTED_LIST = Arrays.asList(
            "1 2 3 4 5",
            "4 2 1 2 4",
            "4 423v 32  52",
            "5 2 41 10 20",
            "41 fx 4/",
            "4324/ 42 434 34"
    );

    @Before
    public void init() {
        reader = new DataReader();
    }

    @Test
    public void readTestWhenMethodReturnListWithSizeSix() throws DataMissingException {
        // when
        List<String> actual = reader.read(PATH);

        // then
        assertThat(actual, hasSize(6));
    }

    @Test
    public void readTestWhenMethodReturnListWithExpectedVariable() throws DataMissingException {
        // when
        List<String> actualList = reader.read(PATH);

        assertThat(actualList, is(EXPECTED_LIST));
    }

    @Test(expected = DataMissingException.class)
    public void readTestThrowExceptionWhenPathIsWrong() throws DataMissingException {
        // when
        List<String> list = reader.read(WRONG_PATH);
    }

}
