package com.epam.geometry.repository;

import com.epam.geometry.comparator.PyramidComparatorByX;
import com.epam.geometry.entity.point.Point;
import com.epam.geometry.observable.PyramidObservable;
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

    private static final String FIRST_ID = "2f4";
    private static final String SECOND_ID = "43f4";
    private static final Point FIRST_POINT = new Point(1, 2, 3);
    private static final Point SECOND_POINT = new Point(5, 4, 2);
    private static final Point UPDATE_POINT = new Point(2, 3, 4);
    private static final PyramidObservable FIRST_PYRAMID = new PyramidObservable(
            FIRST_POINT, 4, 5, FIRST_ID
    );
    private static final PyramidObservable SECOND_PYRAMID = new PyramidObservable(
            SECOND_POINT, 7, 9, SECOND_ID
    );
    private static final PyramidObservable UPDATE_PYRAMID = new PyramidObservable(
            UPDATE_POINT, 5, 6, FIRST_ID
    );

    private static final List<PyramidObservable> EXPECTED = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID);

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
        repository.add(FIRST_PYRAMID);

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, hasSize(1));
    }

    @Test
    public void testRemoveShouldRemoveObjectFromList() {
        // given
        repository.add(FIRST_PYRAMID);

        // when
        repository.remove(FIRST_PYRAMID);

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, hasSize(0));
    }

    @Test
    public void testUpdateShouldReplaceAtNewPyramidWithSameID() {
        // given
        repository.add(FIRST_PYRAMID);

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
        repository.add(FIRST_PYRAMID);
        repository.add(SECOND_PYRAMID);

        when(mockSpecification.specified(anyObject())).thenReturn(true);

        // when
        List<PyramidObservable> actual = repository.query(mockSpecification);

        // then
        verify(mockSpecification, times(2)).specified(anyObject());
        assertThat(actual, is(EXPECTED));
    }

    @Test
    public void testQueryShouldReturnEmptyListWhenSpecifiedFalse() {
        // given
        repository.add(FIRST_PYRAMID);

        when(mockSpecification.specified(anyObject())).thenReturn(false);

        // when
        List<PyramidObservable> actual = repository.query(mockSpecification);

        // then
        verify(mockSpecification, times(1)).specified(anyObject());
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testSortShouldReturnExpectedListWhenPyramidComparatorByX() {
        // given
        PyramidObservable newPyramid = new PyramidObservable(UPDATE_POINT, 4, 5, "2f");
        repository.add(newPyramid);
        repository.add(FIRST_PYRAMID);

        List<PyramidObservable> expected = Arrays.asList(FIRST_PYRAMID, newPyramid);

        // when
        repository.sort(new PyramidComparatorByX());

        // then
        List<PyramidObservable> actual = getCurrentListObjects();
        assertThat(actual, is(expected));
    }

    private List<PyramidObservable> getCurrentListObjects() {
        when(mockSpecification.specified(anyObject())).thenReturn(true);

        return repository.query(mockSpecification);
    }
}
