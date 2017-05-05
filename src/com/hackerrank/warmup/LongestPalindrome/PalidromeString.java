package com.hackerrank.warmup.LongestPalindrome;

/**
 * Finding if a string is a palindrome without using any helper classes
 */
public class PalidromeString {
    public static void main(String[] args) {
        String s = "mom";
        if(isPalindrome(s)){
            System.out.println(s + " is palindrome.");
        } else {
            System.out.println(s + " is not palindrome.");
        }
    }

    public static boolean isPalindrome(String str){
        if(str == null || str.isEmpty()){
            return false;
        }
        int n = str.length();

        for (int i = 0; i < n/2; i++) {
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
