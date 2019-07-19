package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.DataMissingException;
import com.epam.geometry.io.DataReader;
import com.epam.geometry.valid.InputDataValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader reader;
    private InputDataValidator valid;
    private PyramidCreator creator;

    public Director(DataReader reader, InputDataValidator valid, PyramidCreator creator) {
        this.reader = reader;
        this.valid = valid;
        this.creator = creator;
    }

    public List<Pyramid> process(String path) {
        LOGGER.info("START PROGRAM");
        List<String> invalidList;
        List<Pyramid> validList = new ArrayList<>();

        try {
            invalidList = reader.read(path);
            for (String line : invalidList) {
                if(valid.isValid(line)) {
                    Optional<Pyramid> pyramid = creator.createPyramid(line);
                    pyramid.ifPresent(validList::add);
                }
            }
        } catch (DataMissingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("STOP PROGRAM");
        return validList;
    }
}
