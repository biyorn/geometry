package com.epam.geometry.repository;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.repository.impl.Repository;
import com.epam.geometry.specifiacation.impl.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class PyramidRepository implements Repository {

    private List<PyramidObservable> repository;

    public PyramidRepository() {
        repository = new ArrayList<>();
    }

    @Override
    public void add(PyramidObservable pyramid) {
        repository.add(pyramid);
    }

    @Override
    public void remove(PyramidObservable pyramid) {
        repository.remove(pyramid);
    }

    @Override
    public void update(PyramidObservable pyramid) {
        String id = pyramid.getID();
        for (PyramidObservable element : repository) {
            String intermediate = element.getID();
            if(intermediate.equals(id)) {
                int index = repository.indexOf(element);
                repository.set(index, pyramid);
            }
        }
    }

    @Override
    public List<PyramidObservable> query(Specification specification) {
        return repository.stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    public void sort(Comparator<PyramidObservable> comparator) {
        repository.sort(comparator);
    }
}
