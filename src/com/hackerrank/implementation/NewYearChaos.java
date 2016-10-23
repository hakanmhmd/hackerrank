package com.hackerrank.implementation;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/new-year-chaos
 * algorithm: bubble sort
 */
public class NewYearChaos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int queue[] = new int[n];
            for(int i=0; i < n; i++){
                queue[i] = in.nextInt();
            }
            int swaps = 0;
            boolean chaotic = false;
            for(int i=0; i < n; i++){
                if(queue[i] > 2+i+1){
                    chaotic = true;
                }
            }
            if(chaotic) {
                System.out.println("Too chaotic");
                continue;
            }
            boolean flag = true;
            while(flag) {
                flag = false;
                for (int j = 0; j < queue.length-1; j++) {
                    if(queue[j] > queue[j+1]){
                        int temp = queue[j];
                        queue[j] = queue[j+1];
                        queue[j+1] = temp;
                        swaps++;
                        flag = true;
                    }
                }
            }
            System.out.println(swaps);
        }
    }
}
