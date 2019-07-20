package com.epam.geometry.repository.impl;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

import java.util.List;

public interface Repository {

    void add(PyramidObservable pyramid);
    void remove(PyramidObservable pyramid);
    void update(PyramidObservable pyramid);

    List<PyramidObservable> query(Specification specification);
}
