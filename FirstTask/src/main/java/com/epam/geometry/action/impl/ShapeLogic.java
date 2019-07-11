package com.epam.geometry.action.impl;

import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.exception.shape.ShapeDoesNotExistException;

public interface ShapeLogic {

    double calculateSquare(Pyramid pyramid) throws ShapeDoesNotExistException;
    double calculateVolume(Pyramid pyramid) throws ShapeDoesNotExistException;

}
