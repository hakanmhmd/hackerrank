package com.hackerrank.sorting;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/countingsort1
 * link: https://www.hackerrank.com/challenges/countingsort2
 * link: https://www.hackerrank.com/challenges/countingsort3
 *
 * Sorts in linear time; it is not comparison based (which cant beat n.log(n) time)
 * requires the elements to have a small range of values
 * it counts the occurances of each element
 */
public class CountingSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int arr[] = new int[n];
        String[] txt = new String[n];
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            arr[i] = Integer.parseInt(line[0]);
            if(i < n/2){
                txt[i] = "-";
            } else {
                txt[i] = line[1];
            }
        }
        countingSort(arr, txt);

    }

    private static void countingSort(int[] arr, String[] txt){
        int[] counts = new int[100];
        //store the count of each value
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        // take in account the actual position of each value
        // counts[i] saves the index of value i
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }
        
        int[] result = new int[arr.length];
        String[] txtResult = new String[arr.length];
        for (int i = result.length-1; i >= 0; i--) {
            int index = counts[arr[i]]-1;
            result[index] = arr[i];
            txtResult[index] = txt[i];
            counts[arr[i]]--;
        }

        StringBuilder sb = new StringBuilder(); // printing in a 1M times loop is slow operation
        for (int i = 0; i < txtResult.length; i++) {
            sb.append(txtResult[i] + " ");
        }

        System.out.println(sb.toString());


        //copy to arr
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }
}
