package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/insertionsort1
 * link: https://www.hackerrank.com/challenges/insertionsort2
 * insertion sort: stable
 * worst case time complexity: O(n^2) - reverse order to sorted
 * space complexity: O(1)
 */
public class InsertionSort {
    public static int[] insertIntoSorted(int[] ar, int newEl) {
        // Extend the array
        int[] newArr = new int[ar.length+1];
        //Copy the array
        for (int i = 0; i < ar.length; i++) {
            newArr[i] = ar[i];
        }
        newArr[newArr.length-1] = newEl;

        int pos = newArr.length-1;
        while(pos > 0 && newArr[pos-1] > newEl){
            newArr[pos] = newArr[pos-1];
            pos--;
            printArray(newArr);
        }
        newArr[pos] = newEl;
        printArray(newArr);
        return newArr;
    }

    public static int[] insertionSort(int[] ar)
    {
        // Fill up the code for the required logic here
        int shifts = 0;
        for (int i = 1; i < ar.length; i++) {
            int currentElement = ar[i];
            int pos = i;
            while(pos > 0 && ar[pos-1] > currentElement){
                ar[pos] = ar[pos-1];
                shifts++;
                pos--;
            }
            ar[pos] = currentElement;
            printArray(ar);
        }
        System.out.println(shifts);
        return ar;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        int newElement = 3;
        int[] newArr = insertIntoSorted(ar, newElement);
        System.out.println("--------------------------");
        int[] sorted = insertionSort(newArr);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
