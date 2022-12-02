package com.nubari.leetcode.java;

public class ZigZagConversion {
    public static String solve(String s, int numRows) {
        // Edge case: if the number of rows is 1, the string cannot be converted
        if (numRows == 1) {
            return s;
        }

        // Create a 2D array to store the zigzag pattern
        String[][] zigzag = new String[numRows][s.length()];

        // Create a variable to keep track of the current row and column
        int row = 0;
        int col = 0;

        // Create a variable to keep track of the current direction (either 1 for down or -1 for up)
        int direction = 1;

        // Loop through the string and fill in the zigzag pattern
        for (int i = 0; i < s.length(); i++) {
            // Store the current character in the zigzag pattern
            zigzag[row][col] = String.valueOf(s.charAt(i));

            // If we have reached the last row, change direction to go up
            if (row == numRows - 1) {
                direction = -1;
            }
            // If we have reached the first row, change direction to go down
            if (row == 0) {
                direction = 1;
            }

            // Move to the next position in the zigzag pattern
            row += direction;
            col++;
        }

        // Create a string builder to store the converted string
        StringBuilder sb = new StringBuilder();

        // Loop through the zigzag pattern and append each character to the string builder
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (zigzag[i][j] != null) {
                    sb.append(zigzag[i][j]);
                }
            }
        }

        // Return the converted string
        return sb.toString();
    }
}

