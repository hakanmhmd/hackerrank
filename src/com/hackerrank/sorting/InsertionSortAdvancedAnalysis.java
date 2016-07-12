package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link : https://www.hackerrank.com/challenges/insertion-sort?h_r=next-challenge&h_v=zen
 */
public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int maxSoFar = Integer.MIN_VALUE;
            int minSoFar = Integer.MAX_VALUE;
            int shiftsCount = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                int item = in.nextInt();
                arr[j] = item;
                if (item >= maxSoFar) {
                    maxSoFar = item;
                    continue;
                }
                if(item < minSoFar){
                    minSoFar = item;
                    shiftsCount += j;
                    continue;
                }
                for (int k = 0; k < j; k++) {
                    if (arr[k] > item) {
                        shiftsCount++;
                    }
                }
            }
            System.out.println(shiftsCount);
        }
    }
}
