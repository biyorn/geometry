package com.epam.geometry.specifiacation;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class PyramidSpecificationByInFirstQuadrant implements Specification {

    private static final int POSITIVE = 0;

    @Override
    public boolean specified(PyramidObservable pyramid) {
        Point point = pyramid.getPoint();
        double x = point.getX();
        double y = point.getY();
        return x > POSITIVE && y > POSITIVE;
    }
}
