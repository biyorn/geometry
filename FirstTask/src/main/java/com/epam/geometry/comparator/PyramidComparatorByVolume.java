package com.epam.geometry.comparator;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorByVolume implements Comparator<PyramidObservable> {

    private PyramidLogic logic;

    public PyramidComparatorByVolume(PyramidLogic logic) {
        this.logic = logic;
    }

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        double firstVolume = logic.calculateVolume(firstPyramid);
        double secondVolume = logic.calculateVolume(secondPyramid);
        return Double.compare(firstVolume, secondVolume);
    }
}
