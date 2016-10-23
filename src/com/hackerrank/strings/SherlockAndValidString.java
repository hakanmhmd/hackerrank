package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String txt = in.nextLine();

        int[] letterFrequencies = new int[26];
        for (int i = 0; i < txt.length(); i++) {
            int letter = txt.charAt(i);
            letterFrequencies[letter - 'a']++;
        }
        int timesRepeated = mode(letterFrequencies);
        int changes = 0;
        for (int i = 0; i < letterFrequencies.length; i++) {
            if(letterFrequencies[i] != 0 && letterFrequencies[i] != timesRepeated){
                if(letterFrequencies[i] > timesRepeated){
                    changes += Math.abs(letterFrequencies[i] - timesRepeated);
                } else {
                    changes += letterFrequencies[i];
                }
            }

        }

        if(changes > 1){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


    }

    public static int mode(int[] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, temp = -1;
        for (int i = 0; i < array.length; i++) {
            int count;
            if(map.containsKey(array[i])){
                count = map.get(array[i]);
                count = count + 1;
                map.put(array[i], count);
            } else {
                count = 1;
                map.put(array[i], count);
            }
            if(count > max && array[i] != 0){
                max = count;
                temp = array[i];
            }
        }
        return temp;
    }

}
