package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[20];
        //int z=5;
        for (int i = 0; i < 20; i++) {
            int a;
            a = Integer.parseInt(reader.readLine());
            num[i] = a;

        }
        return num;
    }

    public static int max(int[] array) {
        int z = array[0];
        for (int i = 0; i < array.length; i++) {
            if (z<array[i]){
                z=array[i];
            }

        }
        return z;
    }
}
