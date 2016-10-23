package com.hackerrank.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/sherlock-and-pairs
 * idea: for n numbers with the same value, there are n*(n-1) valid pairs between them such that i!=j but A[i] = A[j]
 */
public class SherlockAndPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextInt();
            long pairsFound = 0;
            HashMap<Long, Long> hm = new HashMap<>();
            for (long j = 0; j < n; j++) {
                long item = in.nextInt();
                if(hm.containsKey(item)){
                    long count = hm.get(item);
                    hm.put(item, count+1);
                } else {
                    hm.put(item, new Long(1));
                }
            }
            for (Map.Entry<Long,Long> entry : hm.entrySet()) {
                Long count = entry.getValue();
                pairsFound += count*(count-1);
            }

            System.out.println(pairsFound);
        }
    }
}
