package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int n = 1;
        for (int i = 1; i < 11; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print("8");

            }
            n++;
            System.out.println();
        }
    }
}
