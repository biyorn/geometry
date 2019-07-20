package com.epam.geometry.observer;

import com.epam.geometry.calculator.CalculateParameters;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.observer.impl.Observer;
import com.epam.geometry.parameters.Parameters;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private Map<String, Parameters> map = new HashMap<>();
    private CalculateParameters calculator;

    public PyramidObserver(CalculateParameters calculator) {
        this.calculator = calculator;
    }

    @Override
    public void update(PyramidObservable pyramid) {
        // calculate
//        double volume = calculator.calculateVolume(pyramid);
//        double square = calculator.calculateSquare(pyramid);
//
//        Parameters parameters = new Parameters();
//        parameters.setVolume(volume);
//        parameters.setSquare(square);

        // calculate
        Parameters parameters = calculator.calculate(pyramid);

        // set
        String id = pyramid.getID();
        map.put(id, parameters);
    }
}
