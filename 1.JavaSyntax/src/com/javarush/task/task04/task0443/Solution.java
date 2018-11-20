package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String number1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number3 = bufferedReader.readLine(); //читаем строку с клавиатуры

        int intNumber1 = Integer.parseInt(number1);
        int intNumber2 = Integer.parseInt(number2);
        int intNumber3 = Integer.parseInt(number3);

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + intNumber3 + "." + intNumber2 + "." + intNumber1);
    }
}
