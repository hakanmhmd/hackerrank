package com.hackerrank.strings;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/reduced-string
 */
public class SuperReducedString {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String input = in.nextLine();
        while(true){
            int index = findPair(input);
            if(index == -1){
                break;
            }
            input = input.substring(0, index) + input.substring(index+2);

        }
        if(input.equals("")){
            System.out.println("Empty String");
        } else {
            System.out.println(input);
        }
    }

    public static int findPair(String str){
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)){
                return i;
            }
        }
        return -1;
    }
}
