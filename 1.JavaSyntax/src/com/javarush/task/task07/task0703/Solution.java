package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[10];
        int[] num = new int[10];
        for (int i = 0; i < arr.length; i++) {
            String s = reader.readLine();
            arr[i] = s;

        }
        for (int i = 0; i < num.length; i++) {
            num[i] = arr[i].length();
            System.out.println(num[i]);
        }

    }
}
