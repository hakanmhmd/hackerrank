package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/tutorial-intro
 * idea: binary search in sorted array
 */
public class Intro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int findNumber = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int min = 0, max = arr.length-1;
        while(min <= max){
            int middle = (min + max)/2;
            if(arr[middle] == findNumber){
                System.out.println(middle);
                break;
            } else if(arr[middle] > findNumber){
                max = middle-1;
            } else {
                min = middle+1;
            }
        }
    }
}
