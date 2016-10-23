package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/sherlock-and-watson
 */
public class SherlockAndWatson {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] rotated = rotateArray(arr, k);

        for (int i = 0; i < q; i++) {
            int index = in.nextInt();
            System.out.println(rotated[index]);
        }
    }

    private static int[] rotateArray(int[] arr, int k) {
        int[] b = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int newIndex = (i+k)%arr.length;
            b[newIndex] = arr[i];
        }

        return b;
    }
}
