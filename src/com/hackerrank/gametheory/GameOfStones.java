package com.hackerrank.gametheory;

import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/a-game-of-stones
 * algorithms: minimax, alpha-beta pruning
 */
public class GameOfStones {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int testCases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < testCases; i++) {
            int numberOfStones = Integer.parseInt(input.nextLine());
            if(numberOfStones <= 6){
                System.out.println("First");
            } else {

                //System.out.println("Second");
            }
        }
    }
}
