package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.file.DataMissingException;
import com.epam.geometry.io.data.DataReader;
import com.epam.geometry.valid.impl.Validator;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private DataReader reader;
    private Validator valid;
    private PyramidCreator creator;
    private static final String PATH = "data/text.txt";

    public Director(DataReader reader, Validator valid, PyramidCreator creator) {
        this.reader = reader;
        this.valid = valid;
        this.creator = creator;
    }

    public void realization() {
        List<String> invalidList;
        List<Pyramid> validList = new ArrayList<>();

        try {
            invalidList = reader.read(PATH);
            for (String line : invalidList) {
                if(valid.isValid(line)) {
                    Pyramid pyramid = creator.createNewPyramid(line);
                    validList.add(pyramid);
                }
            }
        } catch (DataMissingException e) {

        }

    }

}
