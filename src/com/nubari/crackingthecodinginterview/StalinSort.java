package com.nubari.crackingthecodinginterview;

import java.util.ArrayList;

// STILL HAS -1 BUG

public class StalinSort {
    public static void main(String[] args) {
        var x = new int[]{4, 17, 1, 5, 6, 12, 1, 9, 67, 179, 56, 13, 11124, 345, 23, 12, 345, 56, 90};
        var y = new ArrayList<Integer>();
        y.add(x[0]);
        for (int i = 1; i < x.length; i++) {
            if (x[i] > x[i - 1]) {
                y.add(x[i]);
            } else {
                var resultSize = y.size();
                y.remove(Integer.valueOf(x[i - 1]));
                if (resultSize != 0) {
                    if (x[i] > y.get(y.size() - 1)) {
                        y.add(x[i]);
                    }
                }

            }
        }
        System.out.println(y);
    }
}
