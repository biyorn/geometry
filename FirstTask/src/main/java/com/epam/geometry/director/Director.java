package com.epam.geometry.director;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.file.DataMissingException;
import com.epam.geometry.exception.parameters.ParametersNotValidException;
import com.epam.geometry.io.DataReader;
import com.epam.geometry.valid.ParserPyramidParameters;
import com.epam.geometry.valid.impl.Validator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader reader;
    private Validator valid;
    private PyramidCreator creator;
    private ParserPyramidParameters parser;

    public Director(DataReader reader, Validator valid, PyramidCreator creator, ParserPyramidParameters parser) {
        this.reader = reader;
        this.valid = valid;
        this.creator = creator;
        this.parser = parser;
    }

    public void process(String path) {
        List<String> invalidList;
        List<Pyramid> validList = new ArrayList<>();

        try {
            invalidList = reader.read(path);
            for (String line : invalidList) {
                if(valid.isValid(line)) {
                   // List<Double> list = parser.parser(line);
                    Pyramid pyramid = creator.createPyramid(line);
                    validList.add(pyramid);
                }
            }
        } catch (DataMissingException | ParametersNotValidException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
