package com.hackerrank.implementation;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/minimum-distances
 */
public class MinimumDistances {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        int max = 0;
        for(int i=0; i < n; i++){
            A[i] = in.nextInt();
            if(A[i] > max){
                max = A[i];
            }
        }
        int minDistance = Integer.MAX_VALUE;
        int[] distances = new int[max+1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        //distances[A[0]] = 0;
        for (int i = 0; i < A.length; i++) {
            if(distances[A[i]] != -1){
                int distance = Math.abs(i - distances[A[i]]);
                if(distance < minDistance){
                    minDistance = distance;
                }
            }
            distances[A[i]] = i;
        }
        if(minDistance != Integer.MAX_VALUE)
            System.out.println(minDistance);
        else
            System.out.println(-1);
    }
}
