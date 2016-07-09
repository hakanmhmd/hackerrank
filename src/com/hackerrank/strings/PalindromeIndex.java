package com.hackerrank.strings;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/palindrome-index
 */
public class PalindromeIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String str = in.nextLine();
            int leftIndex = 0;
            int rightIndex = str.length()-1;
            while(leftIndex < rightIndex) {
                if(str.charAt(leftIndex) == str.charAt(rightIndex)){
                    leftIndex++;
                    rightIndex--;
                } else {
                    break;
                }
            }
            if(leftIndex >= rightIndex){
                System.out.println(-1);
                continue;
            }
            int l = leftIndex, r = rightIndex;
            boolean wrongRight = true; // assume the char to remove is from the right
            rightIndex--;
            while(leftIndex < rightIndex){
                if(str.charAt(leftIndex) == str.charAt(rightIndex)){
                    leftIndex++;
                    rightIndex--;
                } else {
                    wrongRight = false; //the right part is ok, so we should remove from left
                    break;
                }
            }

            if(wrongRight){
                System.out.println(r);
            } else {
                System.out.println(l);
            }

        }
    }
}
