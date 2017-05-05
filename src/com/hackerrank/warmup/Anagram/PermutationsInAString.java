package com.hackerrank.warmup.Anagram;

/**
 * Finds all permutations of a smaller string in a bigger string
 * and prints the positions
 */
public class PermutationsInAString {
    public static void main(String[] args) {
        String s = "abbc";
        String b = "cbbacbabbac";

        for (int i = 0; i < b.length()-s.length()+1; i++) {
            String window = b.substring(i, i + s.length());
            //System.out.println(window);
            int[] lettermap = new int[26];
            for (int j = 0; j < window.length(); j++) {
                lettermap[window.charAt(j) - 'a']++;
            }
            //System.out.println(java.util.Arrays.toString(lettermap));
            for (int j = 0; j < s.length(); j++) {
                lettermap[s.charAt(j) - 'a']--;
            }
            //System.out.println(java.util.Arrays.toString(lettermap));

            boolean allZeros = true;
            for (int k = 0; k < lettermap.length; k++){
                if (lettermap[k] != 0){
                    allZeros = false;
                    break;
                }
            }
            if(allZeros){
                System.out.println(window);
            }

        }
    }
}
