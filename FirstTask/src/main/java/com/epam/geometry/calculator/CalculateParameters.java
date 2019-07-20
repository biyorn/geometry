package com.epam.geometry.calculator;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.parameters.Parameters;

public class CalculateParameters {

    private PyramidLogic logic;

    public CalculateParameters(PyramidLogic logic) {
        this.logic = logic;
    }

    public Parameters calculate(PyramidObservable pyramid) {
        //PyramidLogic logic = new PyramidLogic();
        double volume = logic.calculateVolume(pyramid);
        double square = logic.calculateSquare(pyramid);

        Parameters parameters = new Parameters();
        parameters.setVolume(volume);
        parameters.setSquare(square);

        return parameters;
    }
}
