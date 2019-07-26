package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.valid.ParametersPyramidValidator;

import java.util.Optional;

public class PyramidCreator {

    private static final int LOCATION_X = 0;
    private static final int LOCATION_Y = 1;
    private static final int LOCATION_Z = 2;
    private static final int LENGTH_RIB = 3;
    private static final int LENGTH_EDGE = 4;
    private static final String SEPARATION = "\\s";
    private ParametersPyramidValidator validator;

    public PyramidCreator(ParametersPyramidValidator validator) {
        this.validator = validator;
    }

    public Optional<Pyramid> createPyramid(String line) {
        String[] options = line.split(SEPARATION);
        double x = Double.parseDouble(options[LOCATION_X]);
        double y = Double.parseDouble(options[LOCATION_Y]);
        double z = Double.parseDouble(options[LOCATION_Z]);
        Point point = new Point(x, y, z);

        double sideRib = Double.parseDouble(options[LENGTH_RIB]);
        double baseEdge = Double.parseDouble(options[LENGTH_EDGE]);

        Optional<Pyramid> pyramid;
        if(validator.isPyramid(sideRib, baseEdge)) {
            pyramid = Optional.of(new Pyramid(point, sideRib, baseEdge));
        } else {
            pyramid = Optional.empty();
        }

        return pyramid;
    }
}
