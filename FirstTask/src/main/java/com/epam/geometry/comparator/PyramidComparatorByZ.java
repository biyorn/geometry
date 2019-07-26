package com.epam.geometry.comparator;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorByZ implements Comparator<PyramidObservable> {

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        Point firstPoint = firstPyramid.getPoint();
        Point secondPoint = secondPyramid.getPoint();
        double firstZ = firstPoint.getZ();
        double secondZ = secondPoint.getZ();
        return Double.compare(firstZ, secondZ);
    }
}
