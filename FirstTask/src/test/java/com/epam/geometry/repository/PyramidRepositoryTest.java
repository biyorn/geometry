package com.epam.geometry.repository;

import com.epam.geometry.action.pyramid.PyramidLogic;
import com.epam.geometry.comparator.PyramidComparatorBySquare;
import com.epam.geometry.comparator.PyramidComparatorByX;
import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;
import com.epam.geometry.observer.impl.Observer;
import com.epam.geometry.specifiacation.impl.Specification;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PyramidRepositoryTest {

    private static final String ID_FOR_PYRAMID = "2f4";
    private static final Point POINT = new Point(1, 2, 3);
    private static final Point UPDATE_POINT = new Point(2, 3, 4);
    private static final PyramidObservable PYRAMID = new PyramidObservable(
            POINT, 4, 5, ID_FOR_PYRAMID
    );
    private static final PyramidObservable UPDATE_PYRAMID = new PyramidObservable(
            UPDATE_POINT, 5, 6, ID_FOR_PYRAMID
    );

    private static final List<PyramidObservable> EXPECTED = Arrays.asList(PYRAMID);

    private PyramidRepository repository;
    private Specification mockSpecification;

    @Before
    public void init() {
        repository = new PyramidRepository();
        mockSpecification = mock(Specification.class);
    }

    @Test
    public void testAddShouldAddObjectInList() {
        // when
        repository.add(PYRAMID);

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, hasSize(1));
    }

    @Test
    public void testRemoveShouldRemoveObjectFromList() {
        // given
        repository.add(PYRAMID);

        // when
        repository.remove(PYRAMID);

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, hasSize(0));
    }

    @Test
    public void testUpdateShouldReplaceAtNewPyramidWithSameID() {
        // given
        repository.add(PYRAMID);

        // when
        repository.update(UPDATE_PYRAMID);

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, hasSize(1));
        assertEquals(UPDATE_PYRAMID, actual.get(0));
    }

    @Test
    public void testQueryShouldReturnListWithExpectedObjectsWhenSpecifiedTrue() {
        // given
        repository.add(PYRAMID);

        when(mockSpecification.specified(anyObject())).thenReturn(true);

        // when
        List<PyramidObservable> actual = repository.query(mockSpecification);

        // then
        verify(mockSpecification, times(1)).specified(anyObject());
        assertThat(actual, is(EXPECTED));
    }

    @Test
    public void testQueryShouldReturnEmptyListWhenSpecifiedFalse() {
        // given
        repository.add(PYRAMID);

        when(mockSpecification.specified(anyObject())).thenReturn(false);

        // when
        List<PyramidObservable> actual = repository.query(mockSpecification);

        // then
        verify(mockSpecification, times(1)).specified(anyObject());
        assertTrue(actual.isEmpty());
    }

//    @Test
//    public void testSort() {
//        // given
//
//        PyramidObservable observable = new PyramidObservable(UPDATE_POINT, 5, 6, "2f4");
//        List<PyramidObservable> expected = Arrays.asList(PYRAMID);
//        repository.add(PYRAMID);
//        repository.add(observable);
//
//
//    }

    private List<PyramidObservable> getCurrentListObjects() {
        when(mockSpecification.specified(anyObject())).thenReturn(true);

        return repository.query(mockSpecification);
    }
}
