package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.action.impl.ShapeLogic;

public class PyramidLogic implements ShapeLogic {

    private static final int FOUR_SIDED_PYRAMID = 4;

    @Override
    public double calculateSquare(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();
        double baseSquare = calculateQuadrateSquare(baseEdgeLength);
        double sideSquare = calculateTriangleSquare(baseEdgeLength, sideRibLength);
        double square = baseSquare + FOUR_SIDED_PYRAMID * sideSquare;

        return square;
    }

    @Override
    public double calculateVolume(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();

        double halfBaseDiagonal = calculateHalfDiagonalQuadrate(baseEdgeLength);
        double height = calculateHeight(sideRibLength, halfBaseDiagonal);
        double quadrateSquare = calculateQuadrateSquare(baseEdgeLength);

        double volume = (height * quadrateSquare) / 3;
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
