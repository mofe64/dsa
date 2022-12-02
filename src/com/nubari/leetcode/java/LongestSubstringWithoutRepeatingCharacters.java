package com.nubari.leetcode.java;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int solve(String s) {
        String largestSubstring = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String subString = "" + chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                char currentChar = chars[j];
                if (subString.indexOf(currentChar) == -1) {
                    subString += currentChar;
                } else {
                    break;
                }
            }
            if (subString.length() > largestSubstring.length()) {
//                System.out.println("current largest sub is " + largestSubstring);
//                System.out.println("new sub is " + subString);
                largestSubstring = subString;
            }
        }

        return largestSubstring.length();
    }
}
