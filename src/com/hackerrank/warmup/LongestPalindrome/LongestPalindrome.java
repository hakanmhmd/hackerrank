package com.hackerrank.warmup.LongestPalindrome;

/**
 * Finds the longest palindrome present in a given string
 * The complexity is O(n^2)
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeString("acbbcb"));
    }

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // returns empty string if no palindrome is found
        return s.substring(left + 1, right);
    }

    public static String longestPalindromeString(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            // handles odd lengths
            String palindrome = intermediatePalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            // handles even lengths
            palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }
}
