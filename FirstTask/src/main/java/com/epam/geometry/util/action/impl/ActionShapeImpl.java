package com.epam.geometry.util.action.impl;

import com.epam.geometry.entity.shape.impl.ShapeImpl;

public interface ActionShapeImpl<T extends ShapeImpl> {

    int calculateSquare(T shape);

}
