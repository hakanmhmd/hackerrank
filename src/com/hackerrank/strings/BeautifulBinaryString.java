    package com.hackerrank.strings;

    import java.util.Scanner;

    /**
     * link: https://www.hackerrank.com/challenges/beautiful-binary-string
     */
    public class BeautifulBinaryString {
        public static Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
            int n = in.nextInt();
            in.nextLine();
            int minCount = 0;
            String input = in.nextLine();
            for (int i = 0; i <= n - 3; i++) {
                if(findTriple(i, input)){
                    minCount++;
                    i+=2;
                }
            }

            System.out.println(minCount);

        }

        public static boolean findTriple(int i, String str){
             if(str.charAt(i) == '0'
                && str.charAt(i+1) == '1'
                && str.charAt(i+2) == '0'){
                 return true;
             }
             return false;
        }
    }
