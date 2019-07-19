package com.epam.geometry.observer;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.observer.impl.Observer;
import com.epam.geometry.parameters.Parameters;

import java.util.HashMap;
import java.util.Map;

public class PyramidParameters implements Observer {

    private Map<String, Parameters> map = new HashMap<>();

    public void attach(PyramidObservable observable) {
        observable.attach(this);
    }

    @Override
    public void update(PyramidObservable pyramid) {
        // calculate
        PyramidLogic logic = new PyramidLogic();
        double volume = logic.calculateVolume(pyramid);
        double square = logic.calculateSquare(pyramid);

        Parameters parameters = new Parameters();
        parameters.setVolume(volume);
        parameters.setSquare(square);

        // set
        String id = pyramid.getID();
        for(Map.Entry<String, Parameters> value : map.entrySet()) {
            String key = value.getKey();
            if(key.equals(id)) {
                value.setValue(parameters);
            }
        }
    }
}
