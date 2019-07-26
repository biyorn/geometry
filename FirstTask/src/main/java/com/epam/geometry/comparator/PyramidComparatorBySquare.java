package com.epam.geometry.comparator;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;

import java.util.Comparator;

public class PyramidComparatorBySquare implements Comparator<PyramidObservable> {

    private PyramidLogic logic;

    public PyramidComparatorBySquare(PyramidLogic logic) {
        this.logic = logic;
    }

    @Override
    public int compare(PyramidObservable firstPyramid, PyramidObservable secondPyramid) {
        double firstSquare = logic.calculateSquare(firstPyramid);
        double secondSquare = logic.calculateSquare(secondPyramid);
        return Double.compare(firstSquare, secondSquare);
    }
}
