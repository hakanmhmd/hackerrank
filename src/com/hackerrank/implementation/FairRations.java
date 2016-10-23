package com.hackerrank.implementation;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/fair-rations
 */
public class FairRations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int i=0; i < N; i++){
            B[i] = in.nextInt();
        }
        int minDistributions = 0;
        boolean possible = true;
        for (int i = 0; i < B.length; i++) {
            int element = B[i];
            if(i == B.length-1 && element % 2 != 0){
                System.out.println("NO");
                possible = false;
                break;
            }
            else if(i != B.length-1 && element % 2 != 0){
                B[i] = element + 1;
                B[i+1] = B[i+1] + 1;
                minDistributions += 2;
            }
        }
        if(possible)
            System.out.println(minDistributions);
    }

}
