package com.hackerrank.warmup.Anagram;

import java.util.HashSet;
import java.util.Set;

/**
 * String permutation with recursion using Set to avoid repetition
 * On each recursion the first character is taken and the remaining characters are permuted
 */
public class StringAnagram {
    private static Set<String> perms;
    public static Set<String> permutation(String str) {
        perms = new HashSet<>();
        permutation("", str);
        return perms;
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            perms.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String[] args) {
        String s = "AAC";
        System.out.println("Permutations for " + s + " are: \n" + permutation(s));
    }
}