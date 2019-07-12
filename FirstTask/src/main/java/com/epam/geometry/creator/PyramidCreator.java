package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class PyramidCreator {

    private static final Logger log = Logger.getLogger(PyramidCreator.class.getName());
    private static final int LOCATION_X = 0;
    private static final int LOCATION_Y = 1;
    private static final int LOCATION_Z = 2;
    private static final int LENGTH_RIB = 3;
    private static final int LENGTH_EDGE = 4;

    public Pyramid createNewPyramid(String line) {
        log.info("Create new pyramid");
        List<String> options = Arrays.asList(line.split("\\s"));
        double x = Double.parseDouble(options.get(LOCATION_X));
        double y = Double.parseDouble(options.get(LOCATION_Y));
        double z = Double.parseDouble(options.get(LOCATION_Z));
        Point point = new Point(x, y, z);

        double sideRibLength = Double.parseDouble(options.get(LENGTH_RIB));
        double baseEdgeLength = Double.parseDouble(options.get(LENGTH_EDGE));

        Pyramid temp = new Pyramid(point, sideRibLength, baseEdgeLength);

        return temp;
    }
}
