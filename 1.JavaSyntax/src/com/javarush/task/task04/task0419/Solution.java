package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        String s4 = reader.readLine();
        int m = Integer.parseInt(s1);
        int n = Integer.parseInt(s2);
        int j = Integer.parseInt(s3);
        int k = Integer.parseInt(s4);
        int arrayM[] = {m, n, j, k};
        int max = Integer.MIN_VALUE;// т.к. есть ещё минусовые значения, поэтому не ноль а -2^31
        for (int i = 0; i < 4; i++) {
            if (max <= arrayM[i]) {
                max = arrayM[i];
            }
        } System.out.print(max);
        }
    }

