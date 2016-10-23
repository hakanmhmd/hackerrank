package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/save-the-prisoner
 * idea: modulo arithmetic manipulation
 */
public class SaveThePrisoner {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int testCases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < testCases; i++) {
            String[] arguments = in.nextLine().split(" ");
            int prisoners = Integer.parseInt(arguments[0]);
            int sweets = Integer.parseInt(arguments[1]);
            int startingPoint = Integer.parseInt(arguments[2]);
            int pos = (startingPoint + sweets - 1) % prisoners;
            if(pos==0){
                pos = prisoners;
            }
            System.out.println(pos);
        }
    }
}
