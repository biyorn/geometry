package com.epam.geometry.observer;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.observer.impl.Observer;
import com.epam.geometry.parameters.Parameters;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private Map<String, Parameters> map = new HashMap<>();
    private PyramidLogic logic;

    public PyramidObserver(PyramidLogic logic) {
        this.logic = logic;
    }

    @Override
    public void update(PyramidObservable pyramid) {
        double volume = logic.calculateVolume(pyramid);
        double square = logic.calculateSquare(pyramid);

        Parameters parameters = new Parameters();
        parameters.setVolume(volume);
        parameters.setSquare(square);

        String id = pyramid.getID();
        map.put(id, parameters);
    }
}
