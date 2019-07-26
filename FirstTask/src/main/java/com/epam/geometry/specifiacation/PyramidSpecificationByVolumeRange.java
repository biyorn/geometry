package com.epam.geometry.specifiacation;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class PyramidSpecificationByVolumeRange implements Specification {

    private PyramidLogic logic;
    private double min;
    private double max;

    public PyramidSpecificationByVolumeRange(PyramidLogic logic, double min, double max) {
        this.logic = logic;
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specified(PyramidObservable pyramid) {
        double volume = logic.calculateVolume(pyramid);
        return volume > min && volume < max;
    }
}
