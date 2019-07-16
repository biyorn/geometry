package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.action.impl.ShapeLogic;

import java.nio.channels.Pipe;
import java.security.PublicKey;
import java.util.Objects;

public class PyramidLogic implements ShapeLogic {

    private static final int FOUR_SIDED_PYRAMID = 4;

    @Override
    public double calculateSquare(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();
        double baseSquare = calculateQuadrateSquare(baseEdgeLength);
        double sideSquare = calculateTriangleSquare(baseEdgeLength, sideRibLength);

        return baseSquare + FOUR_SIDED_PYRAMID * sideSquare;
    }

    @Override
    public double calculateVolume(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();

        double halfBaseDiagonal = calculateHalfDiagonalQuadrate(baseEdgeLength);
        double height = calculateHeight(sideRibLength, halfBaseDiagonal);
        double quadrateSquare = calculateQuadrateSquare(baseEdgeLength);

        return (height * quadrateSquare) / 3;
    }

    @Override
    public double calculateRatioVolume(Pyramid pyramid, double coordinatePointY) {
        // Check is possible
        Point point = pyramid.getPoint();
        double z = point.getZ();
        double x = point.getX();
        Point pointTruncatedPyramid = new Point(x, coordinatePointY, z);

        double coefficient = calculateSimilarityCoefficient(pyramid, point, coordinatePointY);

        Pyramid truncatedPyramid = createTruncatedPyramid(pyramid, pointTruncatedPyramid, coefficient);
        double firstPart = calculateVolume(truncatedPyramid);
        double secondPart = calculateVolume(pyramid) - firstPart;

        return firstPart / secondPart;
    }

    // may be incorrect
    public boolean isPyramid(Object obj) {
        Pyramid pyramid = new Pyramid(new Point(0, 0, 0), 10, 10);
        if(pyramid == obj) {
            return true;
        }
        return obj != null && pyramid.getClass() == obj.getClass();
    }

    private double calculateSimilarityCoefficient(Pyramid pyramid, Point point, double coordinatePointY) {
        double startingPoint = point.getY();
        double endPoint = calculateEndPoint(pyramid, startingPoint);

        double intermediateSection = endPoint - startingPoint;
        double cutSection = coordinatePointY - startingPoint;

        return intermediateSection / cutSection;
    }

    private Pyramid createTruncatedPyramid(Pyramid pyramid, Point newPoint, double similarityCoefficient) {
        double sideRibLength = pyramid.getSideRibLength() / similarityCoefficient;
        double baseEdgeLength = pyramid.getBaseEdgeLength() / similarityCoefficient;

        return new Pyramid(newPoint, sideRibLength, baseEdgeLength);
    }

    private double calculateEndPoint(Pyramid pyramid, double startingPoint) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double halfDiagonal = calculateHalfDiagonalQuadrate(baseEdgeLength);
        double sideRibLength = pyramid.getSideRibLength();
        double height = calculateHeight(sideRibLength, halfDiagonal);

        return startingPoint + height;
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
        return (base * Math.sqrt(part)) / 2;
    }
}
