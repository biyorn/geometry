package com.epam.geometry.repository;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.repository.impl.Repository;
import com.epam.geometry.specifiacation.impl.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PyramidRepository implements Repository {

    private Map<String, PyramidObservable> map = new HashMap<>();

    @Override
    public void add(PyramidObservable pyramid) {
        if(pyramid != null) {
            String id = pyramid.getID();
            map.put(id, pyramid);
        }
    }

    @Override
    public void remove(PyramidObservable pyramid) {
        for (Map.Entry values : map.entrySet()) {
            PyramidObservable temp = (PyramidObservable) values.getValue();
            if(temp.equals(pyramid)) {
                String id = (String) values.getKey();
                map.remove(id);
            }
        }
    }

    @Override
    public void update(PyramidObservable pyramid) {
        
    }

    @Override
    public List<PyramidObservable> query(Specification specification) {
        return map.values().stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }
}
