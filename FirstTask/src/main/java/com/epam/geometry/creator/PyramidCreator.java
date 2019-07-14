package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.parameters.ParametersNotValidException;

public class PyramidCreator {

    private static final int LOCATION_X = 0;
    private static final int LOCATION_Y = 1;
    private static final int LOCATION_Z = 2;
    private static final int LENGTH_RIB = 3;
    private static final int LENGTH_EDGE = 4;

    public Pyramid createPyramid(String line) throws ParametersNotValidException {
        Pyramid pyramid;
        String[] options = line.split("\\s");
        double x = Double.parseDouble(options[LOCATION_X]);
        double y = Double.parseDouble(options[LOCATION_Y]);
        double z = Double.parseDouble(options[LOCATION_Z]);
        Point point = new Point(x, y, z);

        double sideRibLength = Double.parseDouble(options[LENGTH_RIB]);
        double baseEdgeLength = Double.parseDouble(options[LENGTH_EDGE]);

        if(positiveNumberValid(sideRibLength, baseEdgeLength)) {
            pyramid = new Pyramid(point, sideRibLength, baseEdgeLength);
        } else {
            throw new ParametersNotValidException();
        }

//        double x = options.get(LOCATION_X);
//        double y = options.get(LOCATION_Y);
//        double z = options.get(LOCATION_Z);
//        Point point = new Point(x, y, z);
//
//        double sideRibLength = options.get(LENGTH_RIB);
//        double baseEdgeLength = options.get(LENGTH_EDGE);
       // Pyramid pyramid = new Pyramid(point, sideRibLength, baseEdgeLength);

        return pyramid;
    }

    private boolean positiveNumberValid(double first, double second) {
        return first > 0 && second > 0;
    }
}
