package com.nubari.leetcode.kotlin



fun longestPalindromicSubstring(s: String): String {
    if (s.length == 1) {
        return s;
    }
    // declare default string length
    var maxLength = 1
    // declare default string start
    var start = 0

    // loop through string assuming
    for (i in s.indices) {

        var left = i
        var right = i
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        val length = right - left - 1
        if (length > maxLength) {
            maxLength = length
            start = left + 1
        }
    }
    for (i in s.indices) {
        var left = i
        var right = i + 1
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        val length = right - left - 1
        if (length > maxLength) {
            maxLength = length
            start = left + 1
        }
    }
    return s.substring(start, start + maxLength)
}