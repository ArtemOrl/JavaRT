package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[5];
        int z=5;
        for (int i = 0; i < z; i++) {
            int a = 0;
            a = Integer.parseInt(reader.readLine());
            num[i] = a;

        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);

        }
    }
}
