package com.epam.geometry.comparator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorByY implements Comparator<PyramidObservable> {

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        Point firstPoint = firstPyramid.getPoint();
        Point secondPoint = secondPyramid.getPoint();
        double firstY = firstPoint.getY();
        double secondY = secondPoint.getY();
        return Double.compare(firstY, secondY);
    }
}
