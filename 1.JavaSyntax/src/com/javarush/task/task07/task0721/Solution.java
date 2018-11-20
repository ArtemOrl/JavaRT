package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            int arg = Integer.parseInt(reader.readLine());
            arr[i] = arg;
        }
        maximum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum){
                maximum = arr[i];
            }
        }
        minimum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minimum){
                minimum = arr[i];
            }
        }
        System.out.print(maximum + " ");
        System.out.print(minimum);
    }
}
