package com.hackerrank.implementation;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/kangaroo
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        int a = v1 - v2;
        int b = x2 - x1;

        double result = (double)b/a;
        if(result < 0 || result != (int)result){ // if result is negative or not integer
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
