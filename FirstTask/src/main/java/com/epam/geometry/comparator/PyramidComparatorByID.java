package com.epam.geometry.comparator;

import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorByID implements Comparator<PyramidObservable> {

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        String firstId = firstPyramid.getID();
        String secondId = secondPyramid.getID();
        return firstId.compareTo(secondId);
    }
}
