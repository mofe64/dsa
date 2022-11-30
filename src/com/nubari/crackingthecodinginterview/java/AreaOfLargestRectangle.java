package com.nubari.crackingthecodinginterview;


import java.util.ArrayList;
import java.util.List;

public class AreaOfLargestRectangle {
    public static void main(String[] args) {
        int[][] y = {
                {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 0, 0, 0}
        };
        int rectangleWidth = 0;
        int rectangleLength = 0;
        List<List<Integer>> oneIndexes = new ArrayList<>();
        for (int[] row : y) {
            List<Integer> oneIndexesForCurrentRow = new ArrayList<>();
            for (int column = 0; column < row.length; column++) {
                if (column != 0) {
                    if (row[column - 1] == 1 && row[column] == 1) {
                        if (!oneIndexesForCurrentRow.contains(column - 1)) {
                            oneIndexesForCurrentRow.add(column - 1);
                        }
                        oneIndexesForCurrentRow.add(column);
                    }
                } else {
                    if (row[column] == 1 && row[column + 1] == 1) {
                        oneIndexesForCurrentRow.add(column);
                    }
                }
            }
            System.out.println(oneIndexesForCurrentRow);
            oneIndexes.add(oneIndexesForCurrentRow);
        }
        List<List<Integer>> random = new ArrayList<>();

        for (int i = 0; i < oneIndexes.size(); i++) {
            if (oneIndexes.get(i).size() != 0) {
                var x = oneIndexes.get(i);
                for (int j = i; j < oneIndexes.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    var listToCompare = oneIndexes.get(j);
                    if (listToCompare.containsAll(x) || x.containsAll(listToCompare)) {
                        random.add(x);
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(random);
        rectangleLength = random.size();
        rectangleWidth = random.get(0).size();
        for (int i = 0; i < random.size(); i++) {
            if (random.get(i).size() < rectangleWidth) {
                rectangleWidth = random.get(i).size();
            }
        }
        int area = rectangleLength * rectangleWidth;
        System.out.println(area);
    }
}
