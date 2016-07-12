package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/quicksort3
 * in place quicksort
 * pre-sorted - we choose max element and one partition is always empty -> O(n^2)
 */
public class QuickSortInPlace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int el = in.nextInt();
            arr[i] = el;
        }
        quicksort(arr, 0, arr.length-1);
    }

    public static void quicksort(int[] arr, int left, int right) {
        // the partitioning index
        if(left < right) {
            int index = partition(arr, left, right);

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            quicksort(arr, left, index - 1);
            quicksort(arr, index+1, right);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low;
        for (int i = low; i <= high-1; i++) {
            if(arr[i] <= pivot){
                swap(arr, i, index);
                index++;
            }
        }
        //swap the pivot to its right position
        swap(arr, high, index);

        return index;
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
