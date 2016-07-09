package com.hackerrank.strings;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/two-strings
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String first = in.nextLine();
            String second = in.nextLine();
            boolean[] charmap = new boolean[26];
            for (int j = 0; j < charmap.length; j++) {
                charmap[j] = false;
            }
            boolean found = false;
            for (int j = 0; j < first.length(); j++) {
                char ch = first.charAt(j);
                charmap[ch - 'a'] = true;
            }
            for (int j = 0; j < second.length(); j++) {
                char ch = second.charAt(j);
                if(charmap[ch - 'a']){
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("NO");
            }
        }
    }
}
