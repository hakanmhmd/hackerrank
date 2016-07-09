package com.hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/** link: https://www.hackerrank.com/challenges/larrys-array
 *  algorithm: solveability of the Tiles Game - puzzle of fifteen
**/

 public class LarrysArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < testCases; i++) {
            //INPUT READING
            int arrayLen = Integer.parseInt(input.nextLine());
            int[] numbers = new int[arrayLen];
            String[] s = input.nextLine().split(" ");
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(s[j]);
            }
            //LOGIC - count the number of inversions
            int inversions = 0;
            for (int j = 0; j < numbers.length; j++) {
                int item = numbers[j];
                for (int k = j; k < numbers.length; k++) {
                    if(item  > numbers[k]){
                        inversions++;
                    }
                }
            }
            //OUTPUT
            if(inversions % 2 == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


}
