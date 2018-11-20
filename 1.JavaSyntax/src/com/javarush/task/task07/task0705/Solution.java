package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrBig = new int[20];
        int[] arrSmall1 = new int[10];
        int[] arrSmall2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arrBig.length; i++) {
            arrBig[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < arrSmall1.length; i++) {
            arrSmall1[i] = arrBig[i];
        }
        for (int i = 10; i < arrBig.length; i++) {
            int j = i-10;
            arrSmall2[j] = arrBig[i];
            System.out.println(arrSmall2[j]);
        }
    }
}
