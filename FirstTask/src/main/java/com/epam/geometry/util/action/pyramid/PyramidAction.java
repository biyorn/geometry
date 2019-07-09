package com.epam.geometry.util.action.pyramid;

import com.epam.geometry.entity.point.Point;
import com.epam.geometry.entity.shape.pyramid.Pyramid;
import com.epam.geometry.util.action.impl.ActionShapeImpl;

public class PyramidAction implements ActionShapeImpl<Pyramid> {

    @Override
    public int calculateSquare(Pyramid shape) {
        Point edgePoint = calculatePointLocation(shape);
        double sideRibLength = calculateSideEdge(edgePoint, shape.getPoint());
        int baseSquare = calculateBaseSquare(shape.getLengthEdge());
        int


        return 0;
    }

    private double calculateTriangleSquare(int base, int side) {

        int result = base * Math.sqrt()


    }

    private int calculateBaseSquare(int side) {
        return (int) Math.pow(side, 2);
    }

    private double calculateSideEdge(Point first, Point second) {
        int firstX = first.getX();
        int firstY = first.getY();
        int firstZ = first.getZ();
        int secondX = second.getX();
        int secondY = second.getY();
        int secondZ = second.getZ();

        int edgeX = (int) Math.pow((firstX - secondX), 2);
        int edgeY = (int) Math.pow((firstY - secondY), 2);
        int edgeZ = (int) Math.pow((firstZ - secondZ), 2);

        double result = Math.sqrt(edgeX + edgeY + edgeZ);

        return result;
    }

    private Point calculatePointLocation(Pyramid shape) {
        Point point = shape.getPoint();
        int edgeX = point.getX();
        int edgeY = point.getY();
        int edgeZ = point.getZ();
        int lengthEdge = shape.getLengthEdge();

        edgeX += lengthEdge / 2;
        edgeZ -= lengthEdge / 2;

        return new Point(edgeX, edgeY, edgeZ);
    }
}
