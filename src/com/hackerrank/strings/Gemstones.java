package com.hackerrank.strings;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * link: https://www.hackerrank.com/challenges/gem-stones
 */
public class Gemstones {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfRocks = Integer.parseInt(input.nextLine());
        int arraySize = 'z' - 'a' + 1;
        int[] elements = new int[arraySize];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = 0;
        }
        for (int i = 0; i < numberOfRocks; i++) {
            String rock = input.nextLine();
            Set<Character> chars = new HashSet<Character>();
            for (char ch : rock.toCharArray()){
                //elements[ch - 'a']++;
                chars.add(ch);
            }
            for (Character ch : chars) {
                elements[ch - 'a']++;
            }
        }
        int gemCount = 0;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] >= numberOfRocks){
                gemCount++;
                System.out.println("GEM: " + (char)(i + 'a'));
            }
        }

        System.out.println(gemCount);
    }
}
