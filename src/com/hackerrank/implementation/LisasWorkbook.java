package com.hackerrank.implementation;

import java.util.Scanner;

/**INPUT - n chapters, k problems per page
           n problems per chapter
 OUTPUT - special problems (its index in a chapter is same as the its page number)
**/
public class LisasWorkbook {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int numberOfChapters = Integer.parseInt(line.split(" ")[0]);
        int problemsPerPage = Integer.parseInt(line.split(" ")[1]);

        line = input.nextLine();
        int[] problemsPerChapter = new int[numberOfChapters];
        String[] s = line.split(" ");
        for (int i = 0; i < problemsPerChapter.length; i++) {
            problemsPerChapter[i] = Integer.parseInt(s[i]);
        }

        int currentPage = 1;
        int specialCount = 0;
        int temp = 0;
        for (int i = 0; i < problemsPerChapter.length; i++) {
            int numberOfProblems = problemsPerChapter[i];
            for (int j = 1; j <= numberOfProblems; j++) {
                //System.out.println("Problem " + j + " in chapter " + (i+1) + ". Current page is :" + currentPage);
                if (j == currentPage) {
                    specialCount++;
                    //System.out.println("Special problem: " + j + " in chapter " + (i+1));
                }
                temp++;
                if (temp == problemsPerPage) {
                    currentPage++;
                    temp = 0;
                }
            }
            if(temp != 0){
                currentPage++;
                temp = 0;
            }

        }
        System.out.println(specialCount);
    }
}
