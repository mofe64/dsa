package com.nubari.elementarysorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        var a = new Comparable[]{5, 7, 2, 11, -1};
        Sort mergeSort = new MergeSort();
        mergeSort.sort(a);
    }
}