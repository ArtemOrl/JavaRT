package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String number1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number3 = bufferedReader.readLine(); //читаем строку с клавиатуры

        int intNumber1 = Integer.parseInt(number1);
        int intNumber2 = Integer.parseInt(number2);
        int intNumber3 = Integer.parseInt(number3);

        int count=0;
        if (intNumber1>0){
            count++;
        }
        if (intNumber2>0){
            count++;
        }
        if (intNumber3>0){
            count++;
        }
        System.out.println(count);
    }
}
