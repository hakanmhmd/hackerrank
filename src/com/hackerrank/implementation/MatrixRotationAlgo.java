package com.hackerrank.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * link: https://www.hackerrank.com/challenges/matrix-rotation-algo
 * trick: use modulo for fast math calculations
 *        get and flatten each layer of the matrix
 */
public class MatrixRotationAlgo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputs = input.nextLine().split(" ");
        int height = Integer.parseInt(inputs[0]);
        int width = Integer.parseInt(inputs[1]);
        int rot = Integer.parseInt((inputs[2]));
        long[][] matrix = new long[height][width];
        for (int i = 0; i < height; i++) {
            String[] line = input.nextLine().split(" ");
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        long[][] result = new long[height][width];
        int min = Math.min(height, width);
        for(int a=0; a<min; a++) {
            if((a+1) * 2 > min) break;
            List<Long> layer = new ArrayList<Long>();
            //left to right
            for (int i = a; i < width-a; i++)
                layer.add(matrix[a][i]);
            //top to bottom
            for (int i = a+1; i < height-a; i++)
                layer.add(matrix[i][width - a - 1]);
            //left to right
            for (int i = width - a - 2; i >= a; i--)
                layer.add(matrix[height - a - 1][i]);
            // bottom to top
            for (int i = height - a - 2; i >= a+1; i--)
                layer.add(matrix[i][a]);

            //System.out.println(layer.toString());
            int newPosition = rot%layer.size();
            if(newPosition >= 0) {
                for (int i = a; i < width-a; i++) {
                    result[a][i] = layer.get(newPosition);
                    newPosition = (newPosition+1)%layer.size();
                }

                for (int i = a+1; i < height-a; i++) {
                    result[i][width - a - 1] = layer.get(newPosition);
                    newPosition = (newPosition+1)%layer.size();
                }

                for (int i = width - a - 2; i >= a; i--){
                    result[height - a - 1][i] = layer.get(newPosition);
                    newPosition = (newPosition+1)%layer.size();
                }

                for (int i = height - a - 2; i >= a+1; i--){
                    result[i][a] = layer.get(newPosition);
                    newPosition = (newPosition+1)%layer.size();
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
