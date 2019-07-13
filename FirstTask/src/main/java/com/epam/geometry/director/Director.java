package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.file.DataMissingException;
import com.epam.geometry.io.DataReader;
import com.epam.geometry.valid.impl.Validator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader reader;
    private Validator valid;
    private PyramidCreator creator;

    public Director(DataReader reader, Validator valid, PyramidCreator creator) {
        this.reader = reader;
        this.valid = valid;
        this.creator = creator;
    }

    public void process(String path) {
        List<String> invalidList;
        List<Pyramid> validList = new ArrayList<>();

        try {
            invalidList = reader.read(path);
            for (String line : invalidList) {
                if(valid.isValid(line)) {
                    Pyramid pyramid = creator.createNewPyramid(line);
                    validList.add(pyramid);
                }
            }
        } catch (DataMissingException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
