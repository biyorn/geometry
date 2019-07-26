package com.epam.geometry.specifiacation;

import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.impl.Specification;

public class PyramidSpecificationByID implements Specification {

    private String id;

    public PyramidSpecificationByID(String id) {
        this.id = id;
    }

    @Override
    public boolean specified(PyramidObservable pyramid) {
        String pyramidID = pyramid.getID();
        return id == pyramidID || (id != null && id.equals(pyramidID));
    }
}
