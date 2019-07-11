package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.action.impl.ShapeLogic;
import com.epam.geometry.exception.shape.ShapeDoesNotExistException;

public class PyramidLogic implements ShapeLogic {

    private static final int FOUR_SIDED_PYRAMID = 4;

    @Override
    public double calculateSquare(Pyramid pyramid) throws ShapeDoesNotExistException {
        if(pyramid == null) {
            throw new ShapeDoesNotExistException();
        }
        double baseSquare = calculateQuadrateSquare(pyramid.getBaseEdgeLength());
        double sideSquare = calculateTriangleSquare(pyramid.getBaseEdgeLength(), pyramid.getSideRibLength());
        double square = baseSquare + FOUR_SIDED_PYRAMID * sideSquare;

        return square;
    }

    @Override
    public double calculateVolume(Pyramid pyramid) throws ShapeDoesNotExistException {
        if(pyramid == null) {
            throw new ShapeDoesNotExistException();
        }
        double halfBaseDiagonal = calculateHalfDiagonalQuadrate(pyramid.getBaseEdgeLength());
        double height = calculateHeight(pyramid.getSideRibLength(), halfBaseDiagonal);
        double volume = (height * calculateQuadrateSquare(pyramid.getBaseEdgeLength())) / 3;
        return volume;
    }

    private double calculateHeight(double sideRibLength, double halfDiagonal) {
        double firstArg = Math.pow(sideRibLength, 2);
        double secondArg = Math.pow(halfDiagonal, 2);
        return Math.sqrt(firstArg - secondArg);
    }

    private double calculateHalfDiagonalQuadrate(double base) {
        double diagonal = base * Math.sqrt(2);
        return diagonal / 2;
    }

    private double calculateQuadrateSquare(double base) {
        return Math.pow(base, 2);
    }

    private double calculateTriangleSquare(double base, double side) {
        double part = Math.pow(base, 2) - (Math.pow(side, 2) / 4);
        double result = (base * Math.sqrt(part)) / 2;
        return result;
    }
}