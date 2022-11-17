package com.nubari.sorts;

public class ShellSort {

    public void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j - h];
                        a[j - h] = a[j];
                        a[j] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }
}
