package com.epam.geometry.action.impl;

import com.epam.geometry.entity.shape.pyramid.Pyramid;

public interface ShapeLogic {

    double calculateSquare(Pyramid pyramid);
    double calculateVolume(Pyramid pyramid);
    double calculateRatioVolume(Pyramid pyramid, double coordinatePointY);

}
