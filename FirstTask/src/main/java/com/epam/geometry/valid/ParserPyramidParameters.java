package com.epam.geometry.valid;

import com.epam.geometry.exception.parameters.ParametersNotValidException;

import java.util.ArrayList;
import java.util.List;

public class ParserPyramidParameters {

    private static final int LOCATION_X = 0;
    private static final int LOCATION_Y = 1;
    private static final int LOCATION_Z = 2;
    private static final int LENGTH_RIB = 3;
    private static final int LENGTH_EDGE = 4;
    private static final int NEGATIVE_NUMBER = 0;

    public List<Double> parser(String line) throws ParametersNotValidException {
        List<Double> options = new ArrayList<>();
        String[] list = line.split("\\s");
        double x = Double.parseDouble(list[LOCATION_X]);
        options.add(x);
        double y = Double.parseDouble(list[LOCATION_Y]);
        options.add(y);
        double z = Double.parseDouble(list[LOCATION_Z]);
        options.add(z);

        double sideRibLength = Double.parseDouble(list[LENGTH_RIB]);
        double baseEdgeLength = Double.parseDouble(list[LENGTH_EDGE]);

        if(positiveNumberValid(sideRibLength, baseEdgeLength)) {
            options.add(sideRibLength);
            options.add(baseEdgeLength);
        } else {
            throw new ParametersNotValidException();
        }
        return options;
    }

    private boolean positiveNumberValid(double first, double second) {
        return first > NEGATIVE_NUMBER && second > NEGATIVE_NUMBER;
    }
}
