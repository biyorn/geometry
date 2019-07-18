package com.epam.geometry.action.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;

public class PyramidLogic {

    private static final int FOUR_SIDED_PYRAMID = 4;
    private static final char COORDINATE_X = 'X';
    private static final char COORDINATE_Y = 'Y';
    private static final char COORDINATE_Z = 'Z';

    public double calculateSquare(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();
        double baseSquare = calculateQuadrateSquare(baseEdgeLength);
        double sideSquare = calculateTriangleSquare(baseEdgeLength, sideRibLength);

        return baseSquare + FOUR_SIDED_PYRAMID * sideSquare;
    }

    public double calculateVolume(Pyramid pyramid) {
        double baseEdgeLength = pyramid.getBaseEdgeLength();
        double sideRibLength = pyramid.getSideRibLength();

        double halfBaseDiagonal = calculateHalfDiagonalQuadrate(baseEdgeLength);
        double height = calculateHeight(sideRibLength, halfBaseDiagonal);
        double quadrateSquare = calculateQuadrateSquare(baseEdgeLength);

        return (height * quadrateSquare) / 3;
    }

    public double calculateRatioVolume(Pyramid pyramid, double coordinatePointY) {
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

    public boolean beOnCoordinatePlane(Pyramid pyramid, char plane) {
        Point point = pyramid.getPoint();
        char coordinate = Character.toUpperCase(plane);
        switch (coordinate) {
            case COORDINATE_X:
                return point.getX() == 0;
            case COORDINATE_Y:
                return point.getY() == 0;
            case COORDINATE_Z:
                return point.getZ() == 0;
                default:
                    return false;
        }
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
