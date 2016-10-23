package com.hackerrank.implementation;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/equal-stacks
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1PossibleOutcomes[] = new int[n1];
        int h2PossibleOutcomes[] = new int[n2];
        int h3PossibleOutcomes[] = new int[n3];
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        for (int i = n1-1; i >= 0; i--) {
            if(i != n1-1){
                h1PossibleOutcomes[n1-i-1] = h1[i] + h1PossibleOutcomes[n1-i-2];
            } else {
                h1PossibleOutcomes[n1-i-1] = h1[i];
            }
        }

        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        for (int i = n2-1; i >= 0; i--) {
            if(i != n2-1){
                h2PossibleOutcomes[n2-i-1] = h2[i] + h2PossibleOutcomes[n2-i-2];
            } else {
                h2PossibleOutcomes[n2-i-1] = h2[i];
            }
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        for (int i = n3-1; i >= 0; i--) {
            if(i != n3-1){
                h3PossibleOutcomes[n3-i-1] = h3[i] + h3PossibleOutcomes[n3-i-2];
            } else {
                h3PossibleOutcomes[n3-i-1] = h3[i];
            }
        }

        System.out.println(findMaxCommonNumber(h1PossibleOutcomes, h2PossibleOutcomes, h3PossibleOutcomes));

    }

    private static int findMaxCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int common = 0;

        while (cnt1 < arr1.length && cnt2 < arr2.length && cnt3 < arr3.length)
        {
            if (arr1[cnt1] == arr2[cnt2] && arr1[cnt1] == arr3[cnt3])
            {
                if(arr1[cnt1] > common){
                    common = arr1[cnt1];
                }
                cnt1++;
                cnt2++;
                cnt3++;
            }
            else
            {
                int min = Math.min(arr1[cnt1], arr2[cnt2]);
                min = Math.min(min, arr3[cnt3]);
                if (min == arr1[cnt1])
                    cnt1 = cnt1+1;
                else if (min == arr2[cnt2])
                    cnt2 = cnt2 + 1;
                else
                    cnt3 = cnt3 + 1;
            }
        }

        return common;
    }
}
