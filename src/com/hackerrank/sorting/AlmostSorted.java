package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/almost-sorted
 * idea: find leftmost and rightmost index that violates the sorted property
 *       try to swap them and check if the result is sorted
 *       if not try to reverse the sub-segment inbetween
 */
public class AlmostSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        boolean sorted = true;
        arr[0] = in.nextInt();
        int l=0, r=arr.length-1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = in.nextInt();
            if(sorted && arr[i] < arr[i-1]){
                sorted = false;
                l = i-1;
            }
        }

        if(sorted){
            System.out.println("yes");
        } else {
            for (int i = arr.length-1; i > l; i--) {
                if(arr[i] < arr[i-1]){
                    r = i;
                    break;
                }
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(isSorted(arr)){
                System.out.println("yes");
                System.out.println("swap " + (l+1) + " " + (r+1));
            } else {
                int a = l+1;
                int b = r-1;
                while(a < b){
                    temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                    a++;
                    b--;
                }
                if(isSorted(arr)){
                    System.out.println("yes");
                    System.out.println("reverse " + (l+1) + " " + (r+1));
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    private static boolean isSorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
