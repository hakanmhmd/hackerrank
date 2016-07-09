package com.hackerrank.strings;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/string-reduction
 * explanation: http://stackoverflow.com/questions/8033553/stumped-on-a-java-interview-need-some-hints/8715230#8715230
*/
public class StringReduction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            String str = in.nextLine();
            int[] frequencies = new int[3];
            for (int j = 0; j < str.length(); j++) {
                frequencies[str.charAt(j) - 'a']++;
            }
            if(frequencies[0] == 0 && frequencies[1] == 0 ||
                    frequencies[1] == 0 && frequencies[2] == 0 ||
                    frequencies[2] == 0 && frequencies[0] == 0){
                System.out.println(str.length());
                continue;
            }
            if(frequenciesEven(frequencies) || frequenciesOdd(frequencies)){
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }

    private static boolean frequenciesOdd(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];
            if(frequency % 2 == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean frequenciesEven(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];
            if(frequency % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
