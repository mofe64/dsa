package com.nubari.sorts;

import com.nubari.sorts.Sort;

public class MergeSort {

    public void sort(int[] a) {
        // Create a new auxiliary array that will be used to store and process the array
        int[] aux = new int[a.length];

        // Call our internal sort method with refs to our original array,
        // our auxiliary array and our start and end indexes
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(int[] a, int[] aux, int low, int high) {
        // If we have invalid indexes, we return
        if (high <= low) {
            return;
        }
        // Find the middle point so that we can break our array into two smaller sub arrays
        int mid = low + (high - low) / 2;
        // Sort left sub array from low index to middle point
        sort(a, aux, low, mid);
        // Sort right sub array from index after middle to high index
        sort(a, aux, mid + 1, high);
        // Merge the two halves into one array
        merge(a, aux, low, mid, high);
    }

    private void merge(int[] a, int[] aux, int low, int mid, int high) {
        // We firstly copy the original array
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
