package com.epam.geometry.valid;

public class ParametersPyramidValidator {

    public boolean isPyramid(double sideRib, double baseEdge) {
        return sideRib > 0 && baseEdge > 0;
    }
}
