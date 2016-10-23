package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/bigger-is-greater
 * idea: find the immediate lexicographically larger permutation of the given sequence
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String sequence = in.nextLine();
            if(findNextPermutation(sequence) == null){
                System.out.println("no answer");
            } else {
                //System.out.println(findNextPermutation(sequence));
            }
            permutation(sequence);
        }
    }

    private static String findNextPermutation(String input){
        char[] arr = input.toCharArray();
        int i = input.length() - 1;

        while(i > 0 && arr[i-1] >= arr[i]){
            i--;
        }

        if(i == 0){
            return null;
        }
        int j = input.length() - 1;
        while(j > i){
            if(arr[j] > arr[i-1]){
                break;
            }
            j--;
        }

        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = input.length() - 1;
        while(i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    //all permutations generator
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
