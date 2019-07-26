package com.epam.geometry.specifiacation;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class PyramidSpecificationByDistance implements Specification {

    private static final Point STARTING_POINT = new Point(0, 0, 0);

    private double distance;

    public PyramidSpecificationByDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean specified(PyramidObservable pyramid) {
        Point point = pyramid.getPoint();
        double pyramidDistance = calculateDistance(point);
        return distance >= pyramidDistance;
    }

    private double calculateDistance(Point point) {
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();
        double first = Math.pow(x, 2);
        double second = Math.pow(y, 2);
        double third = Math.pow(z, 2);
        return Math.sqrt(first + second + third);
    }
}
