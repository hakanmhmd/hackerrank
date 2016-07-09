package com.hackerrank.implementation;

import java.util.*;

/**
 * link: https://www.hackerrank.com/challenges/non-divisible-subset
 * idea: the sum of 2 values is evenly div by K only when the sum of their remainders after
 *       div with K is equal to K.
 * special cases: when the 2 values are both evenly divisible by K
 *                when K is an even number
 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        HashMap<Integer, Integer> remaindersCount = new HashMap<>();
        for(int i=0; i < n; i++){
            int remainder = in.nextInt() % k;
            if(remaindersCount.containsKey(remainder)){
                int count = remaindersCount.get(remainder);
                remaindersCount.put(remainder, count+1);
            } else {
                remaindersCount.put(remainder, 1);
            }
        }

        int subsetSize = 0;
        if(remaindersCount.containsKey(0)){
            subsetSize += 1;
            remaindersCount.remove(0);
        }

        if(k % 2 == 0){
            if(remaindersCount.containsKey(k/2)){
                subsetSize += 1;
                remaindersCount.remove(k/2);
            }
        }

        HashMap<Integer, Integer> sortedMap = sortByValues(remaindersCount);
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            //System.out.print(me2.getKey() + ": ");
            //System.out.println(me2.getValue());
            subsetSize += (Integer)me2.getValue();
            if(sortedMap.containsKey(k-(Integer)me2.getKey()))
                sortedMap.put(k-(Integer)me2.getKey(), 0);
        }

        System.out.println(subsetSize);

    }

    private static HashMap<Integer, Integer> sortByValues(HashMap<Integer, Integer> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
