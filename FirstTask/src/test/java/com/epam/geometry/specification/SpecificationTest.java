package com.epam.geometry.specification;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.specifiacation.*;
import com.epam.geometry.specifiacation.impl.Specification;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.*;


@RunWith(DataProviderRunner.class)
public class SpecificationTest {

    private static final Point POINT = new Point(1, 2, 3);
    private static final Point WRONG_POINT = new Point(-10, 20, 30);
    private static final PyramidObservable PYRAMID = new PyramidObservable(
            POINT, 4, 5, "valid"
            );
    private static final PyramidObservable WRONG_PYRAMID = new PyramidObservable(
            WRONG_POINT, 40, 50, "wrong"
            );

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][] {
                {new PyramidSpecificationByDistance(5)},
                {new PyramidSpecificationByID("valid")},
                {new PyramidSpecificationByInFirstQuadrant()},
                {new PyramidSpecificationBySquareRange(new PyramidLogic(), 25, 75)},
                {new PyramidSpecificationByVolumeRange(new PyramidLogic(), 10, 20)}
        };
    }

    @Test
    @UseDataProvider("dataProvider")
    public void testSpecifiedShouldReturnTrueWhenValidParametersSupplied(Specification specification) {
        // when
        boolean actual = specification.specified(PYRAMID);
        // then
        assertTrue(actual);
    }

    @Test
    @UseDataProvider("dataProvider")
    public void testSpecifiedShouldReturnFalseWhenInvalidParametersSupplied(Specification specification) {
        // when
        boolean actual = specification.specified(WRONG_PYRAMID);

        // then
        assertFalse(actual);
    }
}
