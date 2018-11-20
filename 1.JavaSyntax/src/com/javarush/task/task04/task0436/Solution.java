package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String number1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number2 = bufferedReader.readLine(); //читаем строку с клавиатуры

        int intNumber1 = Integer.parseInt(number1);
        int intNumber2 = Integer.parseInt(number2);
        String z = "8";
        for (int i = 0; i<intNumber1; i++){

            for (int j = 0; j < intNumber2; j++) {
                System.out.print(z);

            }
            System.out.println();
        }

    }
}
