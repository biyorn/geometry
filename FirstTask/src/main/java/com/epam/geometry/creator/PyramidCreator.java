package com.epam.geometry.creator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class PyramidCreator {

    private static final Logger log = Logger.getLogger(PyramidCreator.class.getName());

    public Pyramid createNewPyramid(String line) {
        List<String> options = Arrays.asList(line.split("\\s"));
        double x = Double.parseDouble(options.get(0));
        double y = Double.parseDouble(options.get(1));
        double z = Double.parseDouble(options.get(2));
        Point point = new Point(x, y, z);

        double sideRibLength = Double.parseDouble(options.get(3));
        double baseEdgeLength = Double.parseDouble(options.get(4));

        Pyramid temp = new Pyramid(point, sideRibLength, baseEdgeLength);

        return temp;
    }
}
