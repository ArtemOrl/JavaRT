package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String sSalary = bufferedReader.readLine(); //читаем строку с клавиатуры
        int nSalary = Integer.parseInt(sSalary); //преобразовываем строку в число.
        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.
        System.out.println(name + " получает " + nSalary  + " через " + nAge + " лет.");
    }
}
