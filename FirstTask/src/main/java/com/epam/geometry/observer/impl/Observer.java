package com.epam.geometry.observer.impl;

import com.epam.geometry.observable.PyramidObservable;

public interface Observer {
    void update(PyramidObservable pyramid);
}
