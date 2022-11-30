package com.nubari.crackingthecodinginterview;

import java.util.ArrayList;

public class StalinSort {
    public static void main(String[] args) {
        var x = new int[]{4, 17, 5, 6, 12, 1, 9};
        var y = new ArrayList<Integer>();
        y.add(x[0]);
        for (int i = 1; i < x.length; i++) {
            if (x[i] > x[i - 1]) {
                y.add(x[i]);
            } else {
                var resultSize = y.size();
                y.remove(Integer.valueOf(x[i - 1]));
                if (resultSize != 0) {
                    if (y.size() == 0) {
                        y.add(x[i]);
                    } else if (x[i] > y.get(y.size() - 1)) {
                        y.add(x[i]);
                    }
                }

            }
        }
        System.out.println(y);
    }
}
