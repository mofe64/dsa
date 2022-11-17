package com.nubari.sorts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    void sort() {
        int[] testArray = {1, 5, 1, 267, 34, 21, -9, 6, 87, -54};
        ShellSort sort = new ShellSort();
        sort.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        assertEquals(-54, testArray[0]);
        assertEquals(-9, testArray[1]);
    }
}