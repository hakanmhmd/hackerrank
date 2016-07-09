package com.hackerrank.strings;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/making-anagrams
 * idea: count character histogram value (frequencies of each letter)
 */
public class MakingAnagrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int minDeletions = 0;
        int[] charmapA = new int[26];
        int[] charmapB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            charmapA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            charmapB[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charmapA.length; i++) {
            minDeletions += Math.abs(charmapA[i] - charmapB[i]);
        }

        System.out.println(minDeletions);

    }
}
