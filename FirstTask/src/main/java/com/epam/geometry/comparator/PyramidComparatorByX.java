package com.epam.geometry.comparator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorByX implements Comparator<PyramidObservable> {

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        Point firstPoint = firstPyramid.getPoint();
        Point secondPoint = secondPyramid.getPoint();
        double firstX = firstPoint.getX();
        double secondX = secondPoint.getX();
        return Double.compare(firstX, secondX);
    }
}
