package com.hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/anagram
 */
public class Anagram {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int testCases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < testCases; i++) {
            String s = input.nextLine();
            if(s.length() % 2 != 0){
                System.out.println(-1);
                continue;
            }

            int[] lettermap = new int[26];
            for (int j = 0; j < lettermap.length; j++) {
                lettermap[j] = 0;
            }

            for(int j=0; j<s.length()/2; j++){
                char ch = s.charAt(j);
                lettermap[ch - 'a']++;
            }

            for(int j=s.length()/2; j<s.length(); j++){
                char ch = s.charAt(j);
                lettermap[ch - 'a']--;
            }

            int changesCount = 0;
            for (int j = 0; j < lettermap.length; j++) {
                changesCount += Math.abs(lettermap[j]);
            }
            // Each latter change removes 2 differences on both string
            // so diving by 2 gives the correct number of changes to get the anagram
            System.out.println(changesCount/2);
        }
    }
}
