package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link:  https://www.hackerrank.com/challenges/find-median
 * idea: use of quickselect to find the k-th smallest element in linear time
 * in this case k is equal to (list.length/2 + 1)
 */
public class FindTheMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int median = median_selection(arr, 0, arr.length-1, n/2+1);
        System.out.println(median);
    }

    public static int median_selection(int[] arr, int left, int right, int k){
        if(k<1 || k >arr.length){
            return -1;
        }
        if(left == right){
            return arr[left];
        }
        int pivot = partition(arr, left, right);
        int sizeLeft = pivot-left+1;

        if(k == sizeLeft){
            return arr[pivot];
        } else if(k<sizeLeft){
            return median_selection(arr, left, pivot-1, k);
        } else {
            return median_selection(arr, pivot+1, right, k-sizeLeft);
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
