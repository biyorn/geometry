package com.epam.geometry.specifiacation;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class NameSpecification implements Specification {

    private String name;

    public NameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(PyramidObservable pyramid) {
        // some code
        return false;
    }
}
