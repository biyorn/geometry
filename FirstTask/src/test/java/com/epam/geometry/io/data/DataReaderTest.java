package com.epam.geometry.io.data;

import com.epam.geometry.exception.file.DataMissingException;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class DataReaderTest {

    private static final String PATH = "src/test/java/resources/data/test.txt";
    private static final String WRONG_PATH = "src/test/java/resources/data/wrongPath.txt";
    private DataReader reader;
    private static final List<String> EXPECTED_LIST = Arrays.asList("1 2 3 4 5", "4 2 1 2 4", "4 423v 32  52",
                                                                    "5 2 41 1 2", "41 fx 4/", "4324/ 42 434 34");

    @Before
    public void init() {
        reader = new DataReader();
    }

    @Test
    public void readTestWhenMethodReturnListWithSizeFive() throws DataMissingException {
        // when
        List<String> actual = reader.read(PATH);

        // then
        MatcherAssert.assertThat(actual, hasSize(6));
    }

    @Test
    public void readTestWhenMethodReturnListWithExpectedVariable() throws DataMissingException {
        // when
        List<String> actualList = reader.read(PATH);

        MatcherAssert.assertThat(actualList, is(EXPECTED_LIST));
    }

    @Test(expected = DataMissingException.class)
    public void readTestThrowExceptionWhenPathIsWrong() throws DataMissingException {
        // when
        List<String> list = reader.read(WRONG_PATH);
    }

}
