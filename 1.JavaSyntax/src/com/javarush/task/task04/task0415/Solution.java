package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String a = bufferedReader.readLine(); //читаем строку с клавиатуры
        String b = bufferedReader.readLine();
        String c = bufferedReader.readLine();

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);

        if (((a1+b1)<=c1)||((b1+c1)<=a1)||((a1+c1)<=b1)){
            System.out.println("Треугольник не существует.");
        }else {
            System.out.println("Треугольник существует.");
        }

    }
}