package com.hackerrank.warmup.LongestPalindrome;

/**
 * Palindrome finder using helper class StringBuilder
 */
public class PalindromeStringBuilder {
    public static void main(String[] args) {
        String s = "aha";
        System.out.println(isPalindrom(s));
    }

    private static boolean isPalindrom(String s) {
        if(s == null || s.isEmpty()){
            return false;
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
}
