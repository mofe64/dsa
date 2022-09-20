package com.nubari.sorts;

import com.nubari.sorts.Sort;
import com.nubari.sorts.MergeSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        var a = new Comparable[]{5, 7, 2, 11, -1};
        Sort mergeSort = new MergeSort();
        mergeSort.sort(a);
        assertEquals(-1, a[0]);
        assertEquals(11, a[a.length - 1]);
        System.out.println(Arrays.toString(a));
    }
}