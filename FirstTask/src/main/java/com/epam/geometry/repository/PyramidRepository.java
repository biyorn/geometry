package com.epam.geometry.repository;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.repository.impl.Repository;
import com.epam.geometry.specifiacation.impl.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class PyramidRepository implements Repository {

    private Map<String, PyramidObservable> repository;

    public PyramidRepository() {
        repository = new HashMap<>();
    }

    @Override
    public void add(PyramidObservable pyramid) {
        if(pyramid != null) {
            String id = pyramid.getID();
            repository.put(id, pyramid);
        }
    }

    @Override
    public void remove(PyramidObservable pyramid) {
        String id = pyramid.getID();
        repository.remove(id);
    }

    @Override
    public void update(PyramidObservable pyramid) {
        String id = pyramid.getID();
        for (Map.Entry element : repository.entrySet()) {
            String intermediate = (String) element.getKey();
            if(intermediate.equals(id)) {
                repository.put(id, pyramid);
            }
        }
    }

    @Override
    public List<PyramidObservable> query(Specification specification) {
        return repository.values().stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    // ???
    public void sort(Comparator<PyramidObservable> comparator) {

    }
}
