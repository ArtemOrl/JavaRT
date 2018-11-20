package com.javarush.task.task03.task0324;

/* 
Меркантильные намерения
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
//        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
//        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.
        for (int i = 1; i<=10; i++){
            System.out.println("Я хочу большую зарплату, и для этого изучаю Java");
        }

    }
}
