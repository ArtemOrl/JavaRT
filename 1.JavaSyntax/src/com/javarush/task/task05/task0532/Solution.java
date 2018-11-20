package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] z = new int[N];
        for (int i = 0; i < N; i++) {

            z[i] = Integer.parseInt(reader.readLine());


        }
        int s = z[0];
        for (int i = 0; i < z.length; i++) {
            if (s<z[i]){
                s = z[i];
            }

        }

        System.out.println(s);
    }




}

