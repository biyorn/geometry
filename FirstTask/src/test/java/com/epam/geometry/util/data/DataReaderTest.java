package com.epam.geometry.util.data;

import com.epam.geometry.exception.file.FileWorkException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataReaderTest {

    private static final String PATH = "data/text.txt";
    private static final String WRONG_PATH = "date/tst.txt";

    @Test
    public void readTestWhenMethodReturnListWithSizeFive() throws FileWorkException {
        // given
        DataReader dataReader = new DataReader();

        // when
        List<String> list = dataReader.read(PATH);

        // then
        Assert.assertEquals(5, list.size());
    }

    @Test(expected = FileWorkException.class)
    public void readTestThrowExceptionWhenPathIsWrong() throws FileWorkException {
        // given
        DataReader dataReader = new DataReader();

        // when
        List<String> list = dataReader.read(WRONG_PATH);
    }

}
