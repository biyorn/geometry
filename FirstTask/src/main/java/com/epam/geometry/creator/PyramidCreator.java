package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.parameters.ParametersNotValidException;
import com.epam.geometry.valid.ParametersPyramidValidator;

public class PyramidCreator {

    private static final int LOCATION_X = 0;
    private static final int LOCATION_Y = 1;
    private static final int LOCATION_Z = 2;
    private static final int LENGTH_RIB = 3;
    private static final int LENGTH_EDGE = 4;
    private static final String SEPARATION = "\\s";

    public Pyramid createPyramid(String line) throws ParametersNotValidException {
        String[] options = line.split(SEPARATION);
        double x = Double.parseDouble(options[LOCATION_X]);
        double y = Double.parseDouble(options[LOCATION_Y]);
        double z = Double.parseDouble(options[LOCATION_Z]);
        Point point = new Point(x, y, z);

        double sideRibLength = Double.parseDouble(options[LENGTH_RIB]);
        double baseEdgeLength = Double.parseDouble(options[LENGTH_EDGE]);

        Pyramid pyramid;
        ParametersPyramidValidator validator = new ParametersPyramidValidator();
        if(validator.isPyramid(sideRibLength, baseEdgeLength)) {
            pyramid = new Pyramid(point, sideRibLength, baseEdgeLength);
        } else {
            // optional instead exception
            throw new ParametersNotValidException();
        }

        return pyramid;
    }
}
