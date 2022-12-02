package com.nubari.leetcode.java;

public class LongestPalindromicSubstring {

    public static String doublePointerSolve(String s) {
        if (s.length() == 1) {
            return s;
        }
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int length = right - left - 1;
            if (length > maxLength) {
                maxLength = length;
                // Increment start by one because we have decremented left earlier in while loop
                start = left + 1;
            }

        }
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                start = l + 1;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static String InefficientSolve(String s) {
        if (s.length() == 1) {
            return s;
        }
        String palindromeSub = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder u = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                u.append(s.charAt(j));
                String sub = u.toString();
                if (isPalindrome(sub)) {
                    if (palindromeSub.length() < sub.length()) {
                        palindromeSub = sub;
                    }
                }
            }
        }
        return palindromeSub;
    }

    private static boolean isPalindrome(String s) {
        char[] in = s.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in).equals(s);
    }
}
