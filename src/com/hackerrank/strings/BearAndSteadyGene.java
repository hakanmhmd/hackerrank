package com.hackerrank.strings;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/bear-and-steady-gene/forum
 * idea: use of sliding windows
 * idea: how to find the smallest substring which contains all character from a given string
 */
public class BearAndSteadyGene {
    public static Scanner in = new Scanner(System.in);
    public static final String GENES = "ACTG";
    public static void main(String[] args) {
        int n = in.nextInt();
        in.nextLine();
        int limit = n / 4;
        String geneSequence = in.nextLine();

        int[] frequencies = new int[4];
        for (int i = 0; i < n; i++) {
            frequencies[GENES.indexOf(geneSequence.charAt(i))]++;
        }

        // check if the gene sequence is valid
        if(frequencies[0] == limit && frequencies[1] == limit &&
                frequencies[2] == limit && frequencies[3] == limit){
            System.out.println(0);
        } else {
            // create the target string
            StringBuilder target = new StringBuilder();
            for (int i = 0; i < frequencies.length; i++) {
                if(frequencies[i] > limit){
                    for (int j = 0; j < frequencies[i]-limit; j++) {
                        target.append(GENES.charAt(i));
                    }
                }
            }

            System.out.println(minSubstringContainingAString(geneSequence, target.toString()));
        }

    }

    public static int minSubstringContainingAString(String str, String target){
        int[] toFind = new int[26];
        int[] foundSoFar = new int[26];
        int count = 0;
        //String result = null;
        int minWindowLen = Integer.MAX_VALUE;

        for (int i = 0; i < target.length(); i++) {
            toFind[target.charAt(i) - 'A']++;
        }
        int beginPointer = 0, endPointer = 0;

        for (; endPointer < str.length(); endPointer++) {
            if(toFind[str.charAt(endPointer) - 'A'] == 0){
                continue; // skip chars that we dont look for
            }
            foundSoFar[str.charAt(endPointer) - 'A']++;

            if(foundSoFar[str.charAt(endPointer) - 'A'] <= toFind[str.charAt(endPointer) - 'A']){
                count++;
            }
            //if window constraint is satisfied
            if(count == target.length()){
                //increment beginPointer to right as much as possible
                while (toFind[str.charAt(beginPointer) - 'A'] == 0 ||
                        foundSoFar[str.charAt(beginPointer) - 'A'] > toFind[str.charAt(beginPointer) - 'A']){
                    if(foundSoFar[str.charAt(beginPointer) - 'A'] > toFind[str.charAt(beginPointer) - 'A']){
                        foundSoFar[str.charAt(beginPointer) - 'A']--;
                    }
                    beginPointer++;
                }
                int windowLen = endPointer - beginPointer + 1;
                if (windowLen < minWindowLen) {
                    minWindowLen = windowLen;
                }
                /*String substring = str.substring(beginPointer, endPointer+1);
                if(result == null || result.length() > substring.length()){
                    result = substring;
                }*/
            }
        }
        return minWindowLen;
    }
}
