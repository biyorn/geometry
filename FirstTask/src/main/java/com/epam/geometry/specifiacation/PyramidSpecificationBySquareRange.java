package com.epam.geometry.specifiacation;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class PyramidSpecificationBySquareRange implements Specification {

    private PyramidLogic logic;
    private double min;
    private double max;

    public PyramidSpecificationBySquareRange(PyramidLogic logic, double min, double max) {
        this.logic = logic;
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specified(PyramidObservable pyramid) {
        double square = logic.calculateSquare(pyramid);
        return square > min && square < max;
    }
}
