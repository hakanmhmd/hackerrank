package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/closest-numbers
 */
public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        quicksort(arr, 0, arr.length-1);
        int[] diff = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            diff[i] = Math.abs(arr[i] - arr[i + 1]);
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] < minDiff){
                minDiff = diff[i];
            }
        }
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] == minDiff){
                System.out.print(arr[i] + " " + arr[i+1] + " ");
            }
        }

    }

    public static void quicksort(int[] arr, int left, int right) {
        // the partitioning index
        if(left < right) {
            int index = partition(arr, left, right);
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
