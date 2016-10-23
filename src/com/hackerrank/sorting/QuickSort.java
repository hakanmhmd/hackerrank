package com.hackerrank.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/quicksort1
 * link: https://www.hackerrank.com/challenges/quicksort2
 * strategy: divide and conquer
 * average time complexity: O(nlogn), worst O(n^2)
 * quicksort tail sort optimization available
 * space complexity - O(logn) for the call stack
 * this implementation is out of place, in-place one also exists
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int el = in.nextInt();
            list.add(i, el);
        }
        partition(list);
    }

    public static List<Integer> partition(List<Integer> arr) {
        if(arr.size() <= 1){
            return arr;
        }
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i) > pivot){
                right.add(arr.get(i));
            } else if(arr.get(i) < pivot) {
                left.add(arr.get(i));
            }
        }

        List<Integer> newList = new ArrayList<Integer>(partition(left));
        newList.add(pivot);
        newList.addAll(partition(right));

        for (int i = 0; i <  newList.size(); i++) {
            System.out.print(newList.get(i) + " ");
        }
        System.out.println();

        return newList;
    }
}
